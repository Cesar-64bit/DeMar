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
}
