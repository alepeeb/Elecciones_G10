package Model;

import Classes.ClsCandidato;
import Classes.ClsEleccion;
import Classes.ClsMensaje;
import Classes.ClsVotacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class MdlVotacion {

    BaseDatos jdbc;

    public MdlVotacion() {
        this.jdbc = new BaseDatos();
        jdbc.CreConexion();
    }

    public LinkedList<ClsEleccion> ObtenerElecciones() {

        try {

            LinkedList<ClsEleccion> listaElecciones = new LinkedList<>();

            String sql = "SELECT * FROM tbl_elecciones WHERE estado = 'Creado'";
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

    public LinkedList<ClsCandidato> ObtenerCandidatosEleccion(String idEleccion) {

        try {

            LinkedList<ClsCandidato> listaCandidatos = new LinkedList<>();

            String sql = "SELECT tc.*  FROM tbl_cadidatosxeleccion tcxe, "
                    + "tbl_candidatos tc WHERE tcxe.id_eleccion = ? AND "
                    + " tcxe.id_candidato = tc.id_candidato ";

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

                ClsCandidato candi = new ClsCandidato(numeroDocumento, nombre, telefono, correo, partidoPolitico, ciudadOrigen, correo, mensajeCampania);
                listaCandidatos.add(candi);

            }

            return listaCandidatos;

        } catch (Exception e) {

            System.out.println("Uy error" + e.getMessage());
            return null;
        }

    }

    public ClsMensaje AgregarVoto(ClsVotacion voto) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "INSERT INTO tbl_votos (id_votante , id_candidato, id_eleccion, fecha_insercion)  VALUES (?,?,?,now())";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, voto.getIdVotante());
            sentencia.setString(2, voto.getIdCandidato());
            sentencia.setInt(3, voto.getIdEleccion());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Voto enviado exisosamente, gracias por votar.");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

    public int UsurioVoto(String idVotante, int idEleccion) {

        try {

            String sql = "SELECT COUNT(id_votante) FROM tbl_votos WHERE id_eleccion = ? AND id_votante = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setInt(1, idEleccion);
            sentencia.setString(2, idVotante);

            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                return resultado.getInt(1);
            }

            return 1;

        } catch (SQLException e) {

            System.out.println("Uy error" + e.getMessage());
            return 1;
        }

    }
}
