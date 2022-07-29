package DeMar.src.menuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import DeMar.src.areas.AreasControlador;

public class MenuPrincipalControlador extends MouseAdapter implements ActionListener {

    private MenuPrincipalVista mnPrincipalVista;

    public MenuPrincipalControlador(String nombreUsuario, String tipoUsuario) {
        this.mnPrincipalVista = new MenuPrincipalVista(nombreUsuario, tipoUsuario, this);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mnPrincipalVista.getBtnAreas()) {
            AreasControlador aVista = new AreasControlador();
            aVista.getClass();
        }
    }
}