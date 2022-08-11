package DeMar.src.pagos;

public class PagosControlador {
    protected PagosVista pagosVista;

    public PagosControlador() {
        this.pagosVista = new PagosVista(this);
    }
}
