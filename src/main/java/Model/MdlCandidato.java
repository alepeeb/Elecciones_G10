package Model;

import Classes.ClsCandidato;
import Classes.ClsMensaje;
import Classes.ClsPropuesta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class MdlCandidato {

    BaseDatos jdbc;

    public MdlCandidato() {
        this.jdbc = new BaseDatos();
        jdbc.CreConexion();
    }

// :::::::::::::::::::::::::: Agregar Candidato
    public ClsMensaje AgregarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "INSERT INTO tbl_candidatos  VALUES (?,?,?,?,?,?,?,?,NULL)";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);

            sentencia.setString(1, candidato.getNumeroDocumento());
            sentencia.setString(2, candidato.getNombre());
            sentencia.setString(3, candidato.getTelefono());
            sentencia.setString(4, candidato.getCorreo());
            sentencia.setString(5, candidato.getPartidoPolitico());
            sentencia.setString(6, candidato.getCiudadrigen());
            sentencia.setString(7, candidato.getDescripcion());
            sentencia.setString(8, candidato.getMensajeCampania());
            //sentencia.setString(9, candidato.getPropuestas());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has agregado un nuevo candidato");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;
        } catch (SQLException e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }
    }

// :::::::::::::::::::::::::: Obtener Candidato
    public LinkedList<ClsCandidato> ObtenerCandidatos() {

        try {

            LinkedList<ClsCandidato> listaCandidatos = new LinkedList<>();

            String sql = "SELECT * FROM tbl_candidatos";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String numeroDocumento = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");
                String partidoPolitico = resultados.getString("partido_politico");
                String ciudadOrigen = resultados.getString("ciudad_origen");
                String descripcion = resultados.getString("descripcion");
                String mensajeCampania = resultados.getString("mensaje_campania");
                //String propuestas = resultados.getString("propuestas");

                //ClsCandidato candi = new ClsCandidato(numeroDocumento, nombre, telefono, correo, partidoPolitico, ciudadOrigen, correo, mensajeCampania);
                ClsCandidato candi = new ClsCandidato(numeroDocumento, nombre, telefono, correo, partidoPolitico, ciudadOrigen, descripcion, mensajeCampania);
                listaCandidatos.add(candi);

            }

            return listaCandidatos;

        } catch (SQLException ex) {
            return null;
        }

    }

//::::::::::::::::::::::: Eliminar  Candidato
    public ClsMensaje EliminarCandidato(String idCandidato) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "DELETE FROM tbl_candidatos WHERE id_candidato = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idCandidato);

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has elimando al candidato exitosamente");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

// :::::::::::::::::::::: Actualizar Candidato
    public ClsMensaje ActualizarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "UPDATE tbl_candidatos SET nombre = ?, correo = ?, telefono = ?, ciudad_origen = ?, partido_politico = ?, mensaje_campania = ?, descripcion = ? where id_candidato = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, candidato.getNombre());
            sentencia.setString(2, candidato.getCorreo());
            sentencia.setString(3, candidato.getTelefono());
            sentencia.setString(4, candidato.getCiudadrigen());
            sentencia.setString(5, candidato.getPartidoPolitico());
            sentencia.setString(6, candidato.getMensajeCampania());
            sentencia.setString(7, candidato.getDescripcion());
            sentencia.setString(8, candidato.getNumeroDocumento());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has editado al candidato exitosamente");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

//::::::::::::::::::::::::::: PROPUESTAS
//:::::::::: Agregar Propuesta
    public ClsMensaje AgregarPropuesta(ClsPropuesta propuesta) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "INSERT INTO tbl_propuestas (id_candidato, fecha_insercion, sector, descripcion) VALUES (?, now(), ?, ?)";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, propuesta.getIdCandidato());
            sentencia.setString(2, propuesta.getSector());
            sentencia.setString(3, propuesta.getDescripcion());
            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has agregado una propuesta");

                ResultSet rs = sentencia.getGeneratedKeys();
                if (rs.next()) {
                    mensaje.setData(rs.getString(1) + "");
                }

            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

//:::::::::: Obtener Propuestas
    public LinkedList<ClsPropuesta> ObtenerPropuestas(String idCandidato) {

        try {

            LinkedList<ClsPropuesta> listaPropuestas = new LinkedList<>();

            String sql = "SELECT * FROM tbl_propuestas WHERE id_candidato = " + idCandidato;
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String id = resultados.getString("id_propuesta");
                String sector = resultados.getString("sector");
                String fechaCreacion = resultados.getString("fecha_insercion");
                String descripcion = resultados.getString("descripcion");

                ClsPropuesta propuesta = new ClsPropuesta(id, idCandidato, descripcion, fechaCreacion, sector);

                listaPropuestas.add(propuesta);

            }

            return listaPropuestas;

        } catch (Exception e) {

            System.out.println("Uy error" + e.getMessage());
            return null;
        }

    }

//:::::::::::::::::::: Eliminar propuesta
    public ClsMensaje EliminarPropuesta(String idPropuesta) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "DELETE FROM tbl_propuestas WHERE id_propuesta = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idPropuesta);

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has eliminado la propuesta con ID: " + idPropuesta);
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

//::::::::::::::::::::::::: Actualizar Propuesta
    public ClsMensaje ActualizarPropuesta(ClsPropuesta propuesta) {
        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "UPDATE tbl_propuestas SET sector = ?, descripcion = ? WHERE id_propuesta = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, propuesta.getSector());
            sentencia.setString(2, propuesta.getDescripcion());
            sentencia.setString(3, propuesta.getIdPropuesta());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Se Ha editado la propuesta exitosamente");
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
