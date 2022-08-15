package DeMar.src.menuPrincipal;

import javax.swing.table.DefaultTableModel;

import DeMar.src.Modelo;

public class MenuPrincipalModelo extends Modelo{
    // CONSTRUCTORES
    public MenuPrincipalModelo() {
        super();
    }
    public MenuPrincipalModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public MenuPrincipalModelo(MenuPrincipalModelo mnpModelo) {
        super(mnpModelo);
    }

    // CONSULTAS
    public DefaultTableModel selecImagen(String nombre) {
        String consulta  = "CALL selecImagen('"+nombre+"');";
        return consultaSeleccion(consulta);
    }
}

