package DeMar.src;

import javax.swing.SwingUtilities;
import DeMar.src.login.LoginGraficos;

public class Principal {
    public static void main(String[] args) {
        Runnable runApplication = new Runnable() {
            public void run() {
                LoginGraficos login = new LoginGraficos();
                login.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication); 
    }
}

