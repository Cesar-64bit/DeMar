package DeMar.src.gastos;

import DeMar.src.Modelo;

public class GastosModelo extends Modelo {
    // CONSTRUCTORES
    public GastosModelo() {
        super();
    }
    public GastosModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public GastosModelo(GastosModelo recepcionModelo) {
        super(recepcionModelo);
    }

    // CONSULTAS   
}
