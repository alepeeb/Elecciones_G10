package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatos {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "root";
    private final String password = "";
    private final String bd = "bd_elecciones_g10";
    private final String url = "jdbc:mysql://localhost:3306/" + this.bd;

    public Connection conexion;

    public void CreConexion() {

        try {
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(url, user, password);

            if (this.conexion != null) {
                System.out.println("Conexión exitosa");
            }

        } catch (Exception e) {
            System.out.println("Uy ocurrió un error: " + e.getMessage());
        }

    }

}
