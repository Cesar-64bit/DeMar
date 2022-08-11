package DeMar.src.pedidos;

public class PedidosControlador {
    protected PedidosVista pedidosVista;

    public PedidosControlador() {
        this.pedidosVista = new PedidosVista(this);
    }
}