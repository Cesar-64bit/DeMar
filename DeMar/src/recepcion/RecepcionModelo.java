package DeMar.src.recepcion;

import javax.swing.table.DefaultTableModel;

import DeMar.src.Modelo;;

public class RecepcionModelo extends Modelo {
    // CONSTRUCTORES
    public RecepcionModelo() {
        super();
    }
    public RecepcionModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public RecepcionModelo(RecepcionModelo recepcionModelo) {
        super(recepcionModelo);
    }

    // CONSULTAS
    public DefaultTableModel selecRecepciones() {
        String consulta = "CALL selecRecepciones();";
        return consultaSeleccion(consulta); 
    }

    // Seleccionar un proveedor con un ID
    public DefaultTableModel selID(int id){ 
        String consulta = "CALL buscarUnaRecepcion('"+ id +"');";
        return consultaSeleccion(consulta);
    }

    // OBTENER NOMBRE DE EMPLEADOS
    public DefaultTableModel nomEmpleado(String nombre) {
        String consulta = "CALL idEmpleado('"+nombre+"');";
        return consultaSeleccion(consulta);
    }

    // FILTRAR NOMBRES DE EMPLEADOS PARA COMBOBOX
    public DefaultTableModel filEmpleados() {
        String consulta = "CALL filtrarEmpleados();";
        return consultaSeleccion(consulta);
    }

    // AGREGAR RECEPCIONES
    public boolean registrar(String fecha, String cantidad, String empleado) {
        String consulta = "CALL agregarRecepciones('"+fecha+"','"+cantidad+"','"+empleado+"');";
        return consultaPersistencia(consulta);
    }

    // MODIFICACIÓN DE UNA RECEPCIÓN
    public boolean modificar(String folio, String fecha, String cantidad, String empleado) {
        String consulta = "CALL modificarRecepcion('"+folio+"','"+fecha+"','"+cantidad+"','"+empleado+"');";
        return consultaPersistencia(consulta);
    }

    // ELIMINACIÓN LÓGICA DE UNA RECEPCIÓN
    public boolean eliminar(String folio) {
        String consulta = "CALL eliminarRecepcion('"+folio+"');";
        return consultaPersistencia(consulta);
    }
}
