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
    public DefaultTableModel selID(int id){
        String consulta = "call demar.buscarUnPedido('" + id + "');";
        return consultaSeleccion(consulta);
    }
    
    //Seleccionar todos los pedidos sin excepciones.
    public DefaultTableModel selTodos(){
        String consulta = "call demar.seleccionarPedidos();";
        return consultaSeleccion(consulta);
    }
    
    //Selecciona los pedidos dependiendo su estado:
    //  - Concluido
    //  - En proceso
    //  - Pendiente
    //
    //Se puede dejar vacio el 'estado' para traer los pendientes.
    public DefaultTableModel selPendientes(String estado){
        int est;
        switch(estado){
            case "Concluido": est = 0; break;
            case "En Proceso": est = 1; break;
            case "Pendiente": est = 2; break;
            default: est = 2;
        }
        String consulta = "call demar.seleccionarPedidosPen('" + est + "');";
        return consultaSeleccion(consulta);
    }
}