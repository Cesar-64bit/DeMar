package DeMar.src.recepcion;

import DeMar.src.Modelo;;

public class RecepcionModelo extends Modelo {
    // CONSTRUCTORES
    public RecepcionModelo() {
        super();
    }
    public RecepcionModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public RecepcionModelo(RecepcionModelo recepcionModelo) {
        super(recepcionModelo);
    }

    // CONSULTAS
}
