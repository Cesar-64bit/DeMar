package DeMar.src.pedidos;

import javax.swing.SwingUtilities;

public class exePedidos {
    public static void main(String[] args) {
        Runnable runApplication = new Runnable() {
            public void run() {
                PedidosControlador login = new PedidosControlador("Cesar Oswaldo Bernal Sanchez");
                login.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication); 
    }
}
