package DeMar.src.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;

import DeMar.src.menuPrincipal.MenuPrincipalVista;

public class LoginControlador extends MouseAdapter implements ActionListener {
    LoginModelo lgnModelo = new LoginModelo();
    private LoginVista loginVista;

    public LoginControlador() { this.loginVista = new LoginVista(this); }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginVista.getBtnCerrar()) System.exit(0);

        if(e.getSource() == loginVista.getBtnIngresar()) {

            // VALIDA LA CONEXIÓN A LA BASE DE DATOS
            if(lgnModelo.conectar.establecerConexion()) {

                // VALIDA EL LOGIN
                if(lgnModelo.validadLogin (
                    loginVista.getTxtNombreUsuario(),
                    loginVista.getTxtClaveUsuario(),
                    loginVista.getCbxTipoUsuario())) {

                    JOptionPane.showMessageDialog(null, "Bienvenido");

                    String nombreUsuario = lgnModelo.nombreEmpleado(loginVista.getTxtNombreUsuario());
                    MenuPrincipalVista principalVista = new MenuPrincipalVista(nombreUsuario);
                    principalVista.getClass();
                }
                else
                    JOptionPane.showMessageDialog(null, "Datos inválidos");
            }
            else
                JOptionPane.showMessageDialog(null, "Error en la base de datos");
        }
    } 
}