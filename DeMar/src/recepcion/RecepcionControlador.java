package DeMar.src.recepcion;

public class RecepcionControlador {
    protected RecepcionVista recepcionVista;

    public RecepcionControlador() {
        this.recepcionVista = new RecepcionVista(this);
    }
}