package DeMar.src.pedidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PedidosControlador{
    protected PedidosVista pedidosVista;

    public PedidosControlador() {
        this.pedidosVista = new PedidosVista(this);

        pedidosVista.lblNomEmpleado.setText("Fulanito Fulan de los Grandes Fulanos");

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