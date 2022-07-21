package DeMar.src.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import DeMar.src.menuPrincipal.MenuPrincipalVista;

public class LoginControlador extends MouseAdapter implements ActionListener {
    private LoginVista loginVista;

    public LoginControlador() {
        this.loginVista = new LoginVista(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginVista.getBtnCerrar()) System.exit(0);

        if(e.getSource() == loginVista.getBtnIngresar()) {
            MenuPrincipalVista principalVista = new MenuPrincipalVista();
            principalVista.getClass();
        }
    } 
}