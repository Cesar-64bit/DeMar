package DeMar.src.usuarios;

import javax.swing.table.DefaultTableModel;

import DeMar.src.Modelo;

public class UsuariosModelo extends Modelo {
    // CONSTRUCTORES
    public UsuariosModelo() {
        super();
    }
    public UsuariosModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public UsuariosModelo(UsuariosModelo usuarioModelo) {
        super(usuarioModelo);
    }

    // CONSULTAS
    // Seleccionar todos los usuarios activos estado = 1
    public DefaultTableModel selecUsuariosActivos() {
        String consulta = "CALL selecUsuariosActivos();";
        return consultaSeleccion(consulta);
    }

    public DefaultTableModel buscarUsuario(int id) {
        String consulta = "CALL buscarUnUsuario('"+id+"')";
        return consultaSeleccion(consulta);
    }
}