package DeMar.src.prestamos;

public class PrestamosControlador {
    protected PrestamosVista prestamosVista;

    public PrestamosControlador() {
        this.prestamosVista = new PrestamosVista(this);
    }
}
