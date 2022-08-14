package DeMar.src.prestamos;

import javax.swing.table.DefaultTableModel;

import DeMar.src.Modelo;

public class PrestamosModelo extends Modelo {
    // CONSTRUCTORES
    public PrestamosModelo() {
        super();
    }
    public PrestamosModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public PrestamosModelo(PrestamosModelo prestamosModelo) {
        super(prestamosModelo);
    }

    // CONSULTAS
    public DefaultTableModel selecPrestamos() {
        String consulta = "CALL selecPrestamos();";
        return consultaSeleccion(consulta);
    }

    // Seleccionar un prestamo con un ID
    public DefaultTableModel selID(int id){ 
        String consulta = "CALL buscarUnPrestamo('"+ id +"');";
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

    // AGREGAR PRÉSTAMOS
    public boolean registrar(String fechaPrestamo, String fechaPago, String empleado, String tipoPlazo, String cantidad, String plazosTotales, String plazosPagados) {
        String consulta = "CALL agregarPrestamos('"+fechaPrestamo+"','"+fechaPago+"','"+empleado+"','"+tipoPlazo+"','"+cantidad+"','"+plazosTotales+"','"+plazosPagados+"');";
        return consultaPersistencia(consulta);
    }

    // MODIFICAR PRÉSTAMOS
    public boolean modificar(String id, String fechaPrestamo, String fechaPago, String empleado, String tipoPlazo, String cantidad, String plazosTotales, String plazosPagados) {
        String consulta = "CALL modificarPrestamos('"+id+"','"+fechaPrestamo+"','"+fechaPago+"','"+empleado+"','"+tipoPlazo+"','"+cantidad+"','"+plazosTotales+"','"+plazosPagados+"');";
        return consultaPersistencia(consulta);
    }

    // ELIMINAR PRÉSTAMOS
    public boolean eliminar(String folio) {
        String consulta = "CALL eliminarPrestamos('"+folio+"');";
        return consultaPersistencia(consulta);
    }
}
