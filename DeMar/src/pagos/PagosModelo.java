package DeMar.src.pagos;

import javax.swing.table.DefaultTableModel;

import DeMar.src.Modelo;

public class PagosModelo extends Modelo {
    // CONSTRUCTORES
    public PagosModelo() {
        super();
    }
    public PagosModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public PagosModelo(PagosModelo pagosModelo) {
        super(pagosModelo);
    }
    
    // CONSULTAS
    // CONSULTA PARA MOSTRAR TODOS LOS EMPLEAODS SIN EXCEPCIÓN
    public DefaultTableModel selecPagos() {
        String consulta  = "CALL selecPagos();";
        return consultaSeleccion(consulta);
    }

    // AGREGAR NUEVO PAGO
    public boolean registrar(String total, String tipoPago, String fecha, String empleado, String detallesPedidos) {
        String consulta = "CALL agregarPagos('"+total+"','"+tipoPago+"','"+fecha+"','"+empleado+"','"+detallesPedidos+"');";
        return consultaPersistencia(consulta);
    }

    // MODIFICAR PAGOS
    public boolean modificar(String folio, String total, String tipoPago, String fecha, String empleado, String detallesPedidos) {
        String consulta = "CALL modificarPagos('"+folio+"','"+total+"','"+tipoPago+"','"+fecha+"','"+empleado+"','"+detallesPedidos+"');";
        return consultaPersistencia(consulta);
    }

    // ELIMINAR PAGOS
    public boolean eliminar(String folioPago) {
        String consulta = "CALL eliminarPagos('"+folioPago+"');";
        return consultaPersistencia(consulta);
    }
}