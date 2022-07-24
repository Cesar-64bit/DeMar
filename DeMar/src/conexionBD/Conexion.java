package DeMar.src.conexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import DeMar.src.conexionBD.Conexion;
import java.sql.Driver;
import java.sql.DriverManager;

public class Conexion {
    public Connection con;

    public Conexion() {
        this.establecerConexion();
    }

    public boolean establecerConexion() {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

            String cadenaConexion = "jdbc:mysql://" + "localhost" + ":3306/" + "demar";
            String usuario = "root";
            String contraseña = "";

            con = DriverManager.getConnection(cadenaConexion, usuario, contraseña);

            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }    
}
