package Model;

import Classes.ClsMensaje;
import Classes.ClsVotante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class MdlVotante {

    BaseDatos jdbc;

    public MdlVotante() {
        this.jdbc = new BaseDatos();
        jdbc.CreConexion();
    }

    public ClsMensaje agregarVotante(ClsVotante votante) {

        ClsMensaje mensaje = new ClsMensaje();

        try {
            String sql = "INSERT INTO tbl_votantes  VALUES (?,?,?,?,?)";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);

            sentencia.setString(1, votante.getNumeroDocumento());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getTelefono());
            sentencia.setString(4, votante.getCorreo());
            sentencia.setString(5, votante.getDireccion());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Votante agregado exitosamente");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (SQLException e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }
    }

    //:::::::::::::::::::::::::: Eliminar
    public ClsMensaje EliminarVotante(String idVotante) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "DELETE FROM tbl_votantes WHERE id_votante = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idVotante);

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Votante eliminado exitosamente");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {

            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

    // :::::::::::::::::::::: Actualizar 
    public ClsMensaje ActualizarVotante(ClsVotante votante) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "UPDATE tbl_votantes SET nombre = ?, telefono = ?, correo = ?, direccion = ? WHERE id_votante = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, votante.getNombre());
            sentencia.setString(2, votante.getTelefono());
            sentencia.setString(3, votante.getCorreo());

            sentencia.setString(4, votante.getDireccion());
            sentencia.setString(5, votante.getNumeroDocumento());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Votante actualizado exitosamente");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsVotante> ObtenerVotantes() {

        try {

            LinkedList<ClsVotante> listavotantes = new LinkedList<>();

            String sql = "SELECT * FROM tbl_votantes";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String numeroDocumento = resultados.getString("id_votante");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");
                String dieccion = resultados.getString("direccion");

                ClsVotante votan = new ClsVotante(numeroDocumento, nombre, telefono, correo, dieccion);

                listavotantes.add(votan);

            }

            return listavotantes;

        } catch (SQLException ex) {
            return null;
        }

    }
    
    
    public boolean UsurioExiste(String idVotante) {

        try {

            String sql = "SELECT * FROM tbl_votantes WHERE id_votante = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idVotante);

            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                return true;
            }

            return false;

        } catch (SQLException e) {

            System.out.println("Uy error" + e.getMessage());
            return true;
        }

    }

}
