package DeMar.src.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class LoginControlador extends MouseAdapter implements ActionListener {
    private LoginVista loginGraficos;
    
    public LoginControlador() {
        this.loginGraficos = new LoginVista(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginGraficos.getBtnCerrar()) System.exit(0);
    } 
}
