package DeMar.src.gastos;

public class GastosControlador {
    protected GastosVista gastosVista;

    public GastosControlador() {
        this.gastosVista = new GastosVista(this);
    }
}
