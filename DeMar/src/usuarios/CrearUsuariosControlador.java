package DeMar.src.usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearUsuariosControlador implements ActionListener {
    CrearUsuariosModelo modCrearUsuarioModelo = new CrearUsuariosModelo();
    protected CrearUsuariosVista crearUsuariosVista;

    public CrearUsuariosControlador() {
        this.crearUsuariosVista = new CrearUsuariosVista(this);

        rellenarEmpleados();
        rellenarRoles();
    }

    // SE COLOCAN LOS EMPLEADOS EN UN JCOMBOBOX
    public void rellenarEmpleados() {
        crearUsuariosVista.setCbmEmpleados(modCrearUsuarioModelo.filEmpleados());
    }

    public void rellenarRoles() {
        crearUsuariosVista.setCmbRol(modCrearUsuarioModelo.filPerfiles());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == crearUsuariosVista.getCombo()) {
            crearUsuariosVista.setTxtNombreUsuario(generarUsuario(crearUsuariosVista.getCmbEmpleados()));
        }   
    }


    public String generarUsuario(String nombreEmpleado) {
        char[] nombreEmpleadoChar = nombreEmpleado.toCharArray();
        char[] nombreUsuario = new char[10];

        nombreUsuario[0] = nombreEmpleadoChar[0];
        int x = 1;

        for(int indice = 1; indice < nombreEmpleado.length(); indice++) {
            if(nombreEmpleadoChar[indice] == ' ') {
                nombreUsuario[x] = nombreEmpleadoChar[indice+1];
                x++;
            }
        }

        return String.valueOf(nombreUsuario);
    }
}
