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
    
    //Selecciona los pedidos dependiendo la fecha, el proveedor y el empleado.
    //Si no se quiere tomar en cuenta un parametro, enviar un string vacio ("").
    public DefaultTableModel selecFiltros(String periodo, String idProveedor, String idEmpleado){
        String consulta = "call demar.seleccionarPedidosFiltros('"+periodo+"', '"+idProveedor+"', '"+idEmpleado+"');";
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
