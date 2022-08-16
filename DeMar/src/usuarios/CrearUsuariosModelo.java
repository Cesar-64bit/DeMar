package DeMar.src.usuarios;

import javax.swing.table.DefaultTableModel;

import DeMar.src.Modelo;

public class CrearUsuariosModelo extends Modelo {
    // CONSTRUCTORES
    public CrearUsuariosModelo() {
        super();
    }
    public CrearUsuariosModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public CrearUsuariosModelo(CrearUsuariosModelo crearUsuariosModelo) {
        super(crearUsuariosModelo);
    }

    // FILTRAR NOMBRES DE EMPLEADOS PARA COMBOBOX
    public DefaultTableModel filEmpleados() {
        String consulta = "CALL filtrarEmpleados();";
        return consultaSeleccion(consulta);
    }

    // FILTRAR NOMBRES DE PERFILES PARA COMBOBOX
    public DefaultTableModel filPerfiles() {
        String consulta = "CALL filtrarPerfiles();";
        return consultaSeleccion(consulta);
    }

    // OBTENER ID DE EMPLEADOS 
    public DefaultTableModel nomEmpleado(String nombre) {
        String consulta = "CALL idEmpleado('"+nombre+"');";
        return consultaSeleccion(consulta);
    }

    public DefaultTableModel nomRol(String nombre) {
        String consulta = "CALL idRol('"+nombre+"');";
        return consultaSeleccion(consulta);
    }

    // AGREGAR USUARIOS
    public boolean agregarUsuarios(String nomUsuario, String conUsuario, String idEmpleado, String idPerfiles) {
        String consulta = "CALL agregarUsuarios('"+nomUsuario+"','"+conUsuario+"', '"+idEmpleado+"','"+idPerfiles+"');";
        return consultaPersistencia(consulta);
    }
}
