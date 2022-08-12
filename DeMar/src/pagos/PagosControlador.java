package DeMar.src.pagos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseEvent;

public class PagosControlador implements ActionListener, MouseListener {
    PagosModelo modPagos = new PagosModelo();
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected PagosVista pagosVista;

    public PagosControlador() {
        this.pagosVista = new PagosVista(this);

        mostrarDatosIniciales();
    }

    /* ESTE MÉTODO MUESTRA LOS VALORES ACTUALES Y SE CARGAN AL ABRIR LA VENTA */
    public void mostrarDatosIniciales() {
        tabla.setModel(modPagos.selecPagos());
        scroll.setViewportView(tabla);

        this.pagosVista.diseñarJTable(tabla, scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pagosVista.getBtnAgregar()) {
            boolean registro = modPagos.registrar(
                                                pagosVista.getTxtTotal(), 
                                                pagosVista.getTxtTipoPago(), 
                                                pagosVista.getTxtFecha(), 
                                                pagosVista.getTxtTEmpleado(), 
                                                pagosVista.getTxtDetallePedido());
            pagosVista.confirmarRegistro(registro);
        }
        if(e.getSource() == pagosVista.getBtnModificar()) {

        }
        if(e.getSource() == pagosVista.getBtnEliminar()) {

        }
        if(e.getSource() == pagosVista.getBtnLimpiar()) {
            pagosVista.limpiar();
        }
        if(e.getSource() == pagosVista.getCombo()) {
            pagosVista.establecerTipoPago(pagosVista.getCombo().getSelectedItem().toString());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == pagosVista.getTabla()) {
            int filas = pagosVista.getTabla().rowAtPoint(e.getPoint());
            if(filas > -1) {
                pagosVista.setTxtFolio(pagosVista.getTabla(), filas);
                pagosVista.setTxtTotal(pagosVista.getTabla(), filas);
                pagosVista.setTxtTipoPago(pagosVista.getTabla(), filas);
                pagosVista.setTxtFecha(pagosVista.getTabla(), filas);
                pagosVista.setTxtEmpleado(pagosVista.getTabla(), filas);
                pagosVista.setTxtDetallePedido(pagosVista.getTabla(), filas);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {        

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
