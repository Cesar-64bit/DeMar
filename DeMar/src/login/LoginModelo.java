package DeMar.src.login;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import DeMar.src.conexionBD.Conexion;
import java.sql.ResultSet;

public class LoginModelo {
    Conexion conectar = new Conexion();

    public boolean validadLogin(String nombreUsuario, String claveUsuario, String tipoUsuario) {
        try {
            String consulta = "SELECT usuarios.nombre, usuarios.contraseña, perfiles.nombre FROM usuarios INNER JOIN perfiles ON usuarios.idPerfil = perfiles.id WHERE usuarios.nombre = '"+nombreUsuario+"' AND usuarios.contraseña = '"+claveUsuario+"' AND perfiles.nombre = '"+tipoUsuario+"';";
           
            java.sql.Statement declaracion = conectar.con.createStatement();
            ResultSet resultado = declaracion.executeQuery(consulta);

            if(resultado.next())
                return true;
            else
                return false;
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public String nombreEmpleado(String nombreEmpleado) {
        try {
            String consulta = "SELECT empleados.nombre FROM empleados INNER JOIN usuarios ON empleados.id = usuarios.idEmpleado WHERE usuarios.nombre = '"+nombreEmpleado+"';";
           
            java.sql.Statement declaracion = conectar.con.createStatement();
            ResultSet resultado = declaracion.executeQuery(consulta);

            resultado.next();
            return resultado.getString(1);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return "cesar";
    }
}