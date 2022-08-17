package DeMar.src;

import javax.swing.SwingUtilities;
import DeMar.src.login.LoginControlador;
 
public class Principal {
    public static void main(String[] args) {
        Runnable runApplication = new Runnable() {
            public void run() {
                LoginControlador login = new LoginControlador();
                login.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication); 
    }
}

