package DeMar.src.pedidos;

import DeMar.src.Modelo;
import javax.swing.table.DefaultTableModel;

public class PedidosModelo extends Modelo{
    //CONSTRUCTORES
    public PedidosModelo(){
        super();
    }
    public PedidosModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña){
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public PedidosModelo(PedidosModelo pedidosModelo){
        super(pedidosModelo);
    }
    
    //CONSULTAS
    //Seleccionar un pedido con su ID.
    public DefaultTableModel selecID(int id){
        String consulta = "call demar.buscarUnPedido('" + id + "');";
        return consultaSeleccion(consulta);
    }
    
    //Seleccionar todos los pedidos sin excepciones.
    public DefaultTableModel selecTodos(){
        String consulta = "call demar.seleccionarPedidos();";
        return consultaSeleccion(consulta);
    }
    
    //Selecciona los pedidos dependiendo la fecha, el proveedor, el empleado y el estado del pedido.
    //Si no se quiere tomar en cuenta un parametro, enviarlo como null (a excepción del estado).
    //Valores validos del estado:
    //  0: Entregado
    //  1: En proceso
    //  2: Pendiente
    //  3: En captura
    public DefaultTableModel selecFiltros(String fecha, String idProveedor, String idEmpleado, int estado){
        String consulta = "call demar.seleccionarPedidosFiltros(";
        if(fecha == null) consulta += "'', ";
        else consulta += "'" + fecha + "', ";
        if(idProveedor == null) consulta += "'', ";
        else consulta += "'" + idProveedor + "', ";
        if(idEmpleado == null) consulta += "'', ";
        else consulta += "'" + idEmpleado + "', ";
        consulta += "'" + estado + "');";
        return consultaSeleccion(consulta);
    }
    
    // Inserta un pedido con la fecha actual y en estado proceso de captura.
    public boolean agregarPedido(int idProveedor, String nombreEmpleado){
        String consulta = "call demar.agregarPedido('" + idProveedor + "', '" + nombreEmpleado + "');";
        return consultaPersistencia(consulta);
    }

    // Inserta un detalle para un pedido.
    // Si no existe ni un pedido con estado en 3 y el insumo no es congruente, no se realizara la inserción.
    public boolean agregarDetalle(int idInsumo, Double cantidad){
        String consulta = "call demar.agregarDetallesPedido('" + idInsumo + "', '" + cantidad + "');";
        return consultaPersistencia(consulta);
    }

    // Finalizar la captura de una pedido (Muy importante).
    public boolean finalizarCaptura(){
        String consulta = "call demar.pedidos_finalizarCaptura();";
        return consultaPersistencia(consulta);
    }

    // Modificar el estado de un pedido.
    public boolean modificarEstado(int idPedido, int estado){
        String consulta = "call demar.modificarEstadoPedido('" + idPedido + "', '" + estado + "');";
        return consultaPersistencia(consulta);
    }
}
