package DeMar.src.gastos;

import javax.swing.table.DefaultTableModel;

import DeMar.src.Modelo;

public class GastosModelo extends Modelo {
    // CONSTRUCTORES
    public GastosModelo() {
        super();
    }
    public GastosModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public GastosModelo(GastosModelo recepcionModelo) {
        super(recepcionModelo);
    }

    // CONSULTAS
    public DefaultTableModel selecGastos() {
        String consulta = "CALL selecGastos();";
        return consultaSeleccion(consulta);
    }

    // Seleccionar un gasto con un ID
    public DefaultTableModel selID(int id){ 
        String consulta = "CALL buscarUnGasto('"+ id +"');";
        return consultaSeleccion(consulta);
    }

     // FILTRAR NOMBRES DE EMPLEADOS PARA COMBOBOX
     public DefaultTableModel filEmpleados() {
        String consulta = "CALL filtrarEmpleados();";
        return consultaSeleccion(consulta);
    }

    // OBTENER ID DE LOS EMPLEADOS
    public DefaultTableModel idEmpleado(String nombre) {
        String consulta = "CALL idEmpleado('"+nombre+"');";
        return consultaSeleccion(consulta);
    }

    // AGREGAR GASTOS
    public boolean registrar(String tipo, String cantidad, String fecha, String idEmpleado) {
        String consulta = "CALL agregarGastos('"+tipo+"','"+cantidad+"','"+fecha+"','"+idEmpleado+"');";
        return consultaPersistencia(consulta);
    }

    // MODIFICAR GASTOS
    public boolean modificar(String idGasto, String tipo, String cantidad, String fecha, String idEmpleado) {
        String consulta = "CALL modificarGastos('"+idGasto+"','"+tipo+"','"+cantidad+"','"+fecha+"','"+idEmpleado+"');";
        return consultaPersistencia(consulta);
    }

    // ELIMINAR GASTOS
    public boolean eliminar(String idGasto) {
        String consulta = "CALL eliminarGastos('"+idGasto+"');";
        return consultaPersistencia(consulta);
    }
}
