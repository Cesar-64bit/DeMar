package DeMar.src.empleados;

import DeMar.src.Modelo;

import javax.swing.table.DefaultTableModel;

public class EmpleadosModelo extends Modelo {
    // CONSTRUCTORES
    public EmpleadosModelo() {
        super();
    }
    public EmpleadosModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public EmpleadosModelo(EmpleadosModelo empleadosModelo) {
        super(empleadosModelo);
    }

    // CONSULTAS
    // Seleccionar todos los empleados sin excepción
    public DefaultTableModel selTodos() {
        String consulta = "CALL seleccionarEmpleados();";
        return consultaSeleccion(consulta);
    }

    // Consulta para filtrarAreas
    public DefaultTableModel filAreas() {
        String consulta = "CALL filtrarAreas();";
        return consultaSeleccion(consulta);
    }

    // Consulta para obtener ID Area
    public DefaultTableModel obtenerIDArea(String nombre) {
        String consulta = "CALL obtenerIDArea('"+nombre+"');";
        return consultaSeleccion(consulta);
    }

    // Agregar nuevos empleados
    public boolean registrar(String nombre, String telefono, String direccion, Float dias, String fechaContrato, int idAreas) {
        String consulta = "CALL agregarEmpleado('"+nombre+"', '"+telefono+"', '"+direccion+"', '"+dias+"', '"+fechaContrato+"', '"+idAreas+"');";
        return consultaPersistencia(consulta);
    }
}