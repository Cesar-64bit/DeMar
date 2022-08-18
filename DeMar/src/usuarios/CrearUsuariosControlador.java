package DeMar.src.usuarios;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;

import DeMar.src.resaltarCampo;

public class CrearUsuariosControlador implements ActionListener {
    ArrayList<JComponent> arregloComponent = new ArrayList<JComponent>();
    private resaltarCampo resaltado;

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
            DefaultTableModel tb = modCrearUsuarioModelo.nomEmpleado(crearUsuariosVista.getCombo().getSelectedItem().toString());   
            crearUsuariosVista.setTxtNombreEmpleado(String.valueOf(tb.getValueAt(0, 0)));
        }
        if(e.getSource() == crearUsuariosVista.getCombo2()) {
            DefaultTableModel tb = modCrearUsuarioModelo.nomRol(crearUsuariosVista.getCombo2().getSelectedItem().toString());   
            crearUsuariosVista.setTxtRol(String.valueOf(tb.getValueAt(0, 0)));
        }
        if(e.getSource() == crearUsuariosVista.getBtnAceptar()) {
            if(verificarCampos() == 0) {
                boolean registro = modCrearUsuarioModelo.agregarUsuarios(
                                                                        crearUsuariosVista.getTxtNombreUsuario(),
                                                                        crearUsuariosVista.getTxtContraseña(),
                                                                        crearUsuariosVista.getTxtIDEmpleado(),
                                                                        crearUsuariosVista.getTxtIDRol());
                crearUsuariosVista.confirmarRegistro(registro);
            }
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

        nombreUsuario = Arrays.copyOf(nombreUsuario, x);

        return String.valueOf(nombreUsuario);
    }

    public int verificarCampos() {
        if(crearUsuariosVista.txtNombreUsuario.getText().length() == 0)
            arregloComponent.add(crearUsuariosVista.getComponentTxtNombre());
        if(crearUsuariosVista.txtContraseña.getText().length() == 0)
            arregloComponent.add(crearUsuariosVista.getComponentTxtContraseña());
        
        int tamaño = arregloComponent.size();

        resaltar(arregloComponent.size());

        return tamaño;
    }

    public void resaltar(int size) {
        for(int indice = 0; indice < size; indice++) {
            resaltado = new resaltarCampo(arregloComponent.get(indice), new Color(214, 181, 178), 4);
            resaltado.start();
        }
        arregloComponent.clear();
    }
}
