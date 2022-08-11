package DeMar.src.pagos;

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
}
