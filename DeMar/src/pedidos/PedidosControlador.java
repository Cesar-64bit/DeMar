package DeMar.src.pedidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PedidosControlador{
    private int idUsuario;
    protected PedidosVista pedidosVista;

    public PedidosControlador(String nombreUsuario) {
        this.pedidosVista = new PedidosVista(this);

        pedidosVista.lblNomEmpleado.setText(nombreUsuario);

        this.asignarEventos();
    }

    private void asignarEventos(){
        pedidosVista.btnCerrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent eventoClic){
                System.exit(0);
            }
        });
    }
}