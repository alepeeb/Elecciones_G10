package Model;

import Classes.ClsCandidato;
import Classes.ClsEleccion;
import Classes.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;

public class MdlEleccion {

    BaseDatos jdbc;

    public MdlEleccion() {
        this.jdbc = new BaseDatos();
        jdbc.CreConexion();
    }

    public ClsMensaje AgregarEleccion(ClsEleccion eleccion) {

        ClsMensaje mensaje = new ClsMensaje();

        try {
            String sql = "INSERT INTO tbl_elecciones VALUES ( ?, ?, ?, now(), ?, ?, ?, NULL)";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);

            sentencia.setInt(1, eleccion.getIdEleccion());
            sentencia.setString(2, eleccion.getNombre());
            sentencia.setString(3, eleccion.getTipo());
            sentencia.setString(4, eleccion.getFechaInicio());
            sentencia.setString(5, eleccion.getFechaFin());
            sentencia.setString(6, eleccion.getEstado());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has agregado una elección");
            } else {
                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Exepción: " + e.getMessage());
            return mensaje;
        }
    }

    public LinkedList<ClsEleccion> ObtenerElecciones() {

        try {

            LinkedList<ClsEleccion> listaElecciones = new LinkedList<>();

            String sql = "SELECT * FROM tbl_elecciones";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                int idEleccion = resultados.getInt("id_eleccion");
                String nombre = resultados.getString("nombre");
                String tipo = resultados.getString("tipo");
                String fechaInicio = resultados.getString("fecha_inicio");
                String fechaFin = resultados.getString("fecha_fin");
                String estado = resultados.getString("estado");
                String ganador = resultados.getString("ganador");

                ClsEleccion eleccion = new ClsEleccion(idEleccion, nombre, tipo, fechaInicio, fechaFin, estado, ganador);
                eleccion.setGanador(ganador);

                listaElecciones.add(eleccion);

            }

            return listaElecciones;

        } catch (Exception e) {

            System.out.println("Uy error" + e.getMessage());
            return null;
        }

    }

    public ClsMensaje EliminarEleccion(String id) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "DELETE FROM tbl_elecciones WHERE id_eleccion = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, id);

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has eliminado a la elección: " + id);
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (SQLException e) {

            if (e.getErrorCode() == 1451) {
                mensaje.CambiarMensaje(mensaje.ERROR, "No se puede elimar esta elección porque hay candidatos asociados");
                e.getErrorCode();
            } else {
                mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
                e.getErrorCode();
            }

            return mensaje;
        }

    }

    public ClsMensaje AsociarCandidato(String idEleccion, String idCandidato) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "INSERT INTO tbl_cadidatosxeleccion VALUES ( ?, ?, now())";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idCandidato);
            sentencia.setString(2, idEleccion);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has asociado un candidato a una elección");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (SQLIntegrityConstraintViolationException e) {

            mensaje.CambiarMensaje(mensaje.ERROR, "Esté candidato ya está asociado a la elección seleccionada");

            return mensaje;
        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsCandidato> ObtenerCandidatosEleccion(String idEleccion) {

        try {

            LinkedList<ClsCandidato> listaCandidatos = new LinkedList<>();

            String sql = "SELECT tc.*, tv.votos FROM tbl_cadidatosxeleccion tcxe, tbl_candidatos tc,\n"
                    + "(SELECT id_candidato, COUNT(*) AS votos FROM `tbl_votos` GROUP BY id_candidato) tv\n"
                    + "WHERE tcxe.id_eleccion = ? AND\n"
                    + "tcxe.id_candidato = tc.id_candidato AND\n"
                    + "tc.id_candidato = tv.id_candidato";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idEleccion);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String numeroDocumento = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");
                String partidoPolitico = resultados.getString("partido_politico");
                String ciudadOrigen = resultados.getString("ciudad_origen");
                //String descripcion = resultados.getString("descripcion");
                String mensajeCampania = resultados.getString("mensaje_campania");
                //String propuestas = resultados.getString("propuestas");
                String votos = resultados.getString("votos");

                ClsCandidato candi = new ClsCandidato(numeroDocumento, nombre, telefono, correo, partidoPolitico, ciudadOrigen, correo, mensajeCampania);
                candi.setVotos(votos);
                listaCandidatos.add(candi);

            }

            return listaCandidatos;

        } catch (Exception e) {

            System.out.println("Uy error" + e.getMessage());
            return null;
        }

    }

// TO-DO 
    public ClsMensaje EliminarAsociacion(String idEleccion, String idCandidato) {

        ClsMensaje mensaje = new ClsMensaje();

        try {
            int idE = Integer.parseInt(idEleccion);
            
            String sql = "DELETE tbl_votos,tbl_cadidatosxeleccion FROM tbl_votos INNER JOIN\n"
                    + "tbl_cadidatosxeleccion ON tbl_cadidatosxeleccion.id_eleccion = tbl_votos.id_eleccion AND\n"
                    + "tbl_cadidatosxeleccion.id_candidato = tbl_votos.id_candidato\n"
                    + "WHERE tbl_votos.id_eleccion = ?";

            //DELETE FROM tbl_cadidatosxeleccion WHERE id_eleccion = ? AND id_candidato = ?
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);

            sentencia.setInt(1, idE);
            //sentencia.setString(2, idCandidato);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has eliminado a la una asociación: ");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

    public ClsMensaje ActualizarEleccion(ClsEleccion eleccion) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "UPDATE tbl_elecciones SET nombre = ?, tipo = ?, fecha_inicio = ?, fecha_fin = ? WHERE id_eleccion = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, eleccion.getNombre());
            sentencia.setString(2, eleccion.getTipo());
            sentencia.setString(3, eleccion.getFechaInicio());
            sentencia.setString(4, eleccion.getFechaFin());
            sentencia.setInt(5, eleccion.getIdEleccion());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has editado la elección exitosamente");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

    public ClsMensaje ActualizarEstado(ClsEleccion eleccion) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "UPDATE tbl_elecciones SET estado = ? WHERE id_eleccion = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, eleccion.getEstado());
            sentencia.setInt(2, eleccion.getIdEleccion());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has cambiado el estado de la elección");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

}
