package Model;

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

    public boolean agregarVotante(ClsVotante votante) {

        try {
            String sql = "INSERT INTO tbl_votantes  VALUES (?,?,?,?,?)";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);

            sentencia.setString(1, votante.getNumeroDocumento());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getTelefono());
            sentencia.setString(4, votante.getCorreo());
            sentencia.setString(5, votante.getDireccion());

            int resultado = sentencia.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
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

//:::::::::::::::::::::::::: Eliminar
    public boolean EliminarVotante(String idVotante) {

        try {

            String sql = "DELETE FROM tbl_votantes WHERE id_votante = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idVotante);

            int resultado = sentencia.executeUpdate();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    // :::::::::::::::::::::: Actualizar 
    public boolean ActualizarVotante(ClsVotante votante) {

        try {

            String sql = "UPDATE tbl_votantes SET nombre = ?, telefono = ?, correo = ?, direccion = ? WHERE id_votante = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, votante.getNombre());
            sentencia.setString(2, votante.getTelefono());  
            sentencia.setString(3, votante.getCorreo());

            sentencia.setString(4, votante.getDireccion());
            sentencia.setString(5, votante.getNumeroDocumento());

            int resultado = sentencia.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

}
