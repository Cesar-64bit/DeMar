package DeMar.src.pagos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.MouseEvent;

public class PagosControlador implements ActionListener, MouseListener, KeyListener {
    PagosModelo modPagos = new PagosModelo();

    TableRowSorter<DefaultTableModel> filtro;
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected PagosVista pagosVista;

    public PagosControlador() {
        this.pagosVista = new PagosVista(this);

        mostrarDatosIniciales();
    }

    /* ESTE MÉTODO MUESTRA LOS VALORES ACTUALES Y SE CARGAN AL ABRIR LA VENTA */
    public void mostrarDatosIniciales() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = modPagos.selecPagos();

        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        filtro = new TableRowSorter<>(modelo);
        tabla.setRowSorter(filtro);

        scroll.setViewportView(tabla);

        this.pagosVista.diseñarJTable(tabla, scroll);
    }

     /* ESTE MÉTODO MUESTRA EL VALOR BUSCADO POR ID */
     public void buscarID(int ID) {
        tabla.setModel(modPagos.selID(ID));
        scroll.setViewportView(tabla);

        this.pagosVista.diseñarJTable(tabla, scroll);
    }

    public void filtrar() {
        try {
            filtro.setRowFilter(RowFilter.regexFilter(pagosVista.getTxtBuscar()));
        }
        catch(Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pagosVista.getBtnBuscar()) {
            buscarID(Integer.parseInt(pagosVista.getTxtBuscar()));
        }
        if(e.getSource() == pagosVista.getBtnAgregar()) {
            boolean registro = modPagos.registrar(
                                                pagosVista.getTxtTotal(), 
                                                pagosVista.getTxtTipoPago(), 
                                                pagosVista.getTxtFecha(), 
                                                pagosVista.getTxtTEmpleado(), 
                                                pagosVista.getTxtDetallePedido());
            pagosVista.confirmarRegistro(registro);
            mostrarDatosIniciales();
        }
        if(e.getSource() == pagosVista.getBtnModificar()) {
            if(pagosVista.confirmarAccion(pagosVista.getBtnModificar().getText()) == 0)
                modPagos.modificar(
                                    pagosVista.getTxtFolio(),
                                    pagosVista.getTxtTotal(), 
                                    pagosVista.getTxtTipoPago(), 
                                    pagosVista.getTxtFecha(), 
                                    pagosVista.getTxtTEmpleado(), 
                                    pagosVista.getTxtDetallePedido());
        }
        if(e.getSource() == pagosVista.getBtnEliminar()) {
            if(pagosVista.confirmarAccion(pagosVista.getBtnEliminar().getText()) == 0)
                modPagos.eliminar(pagosVista.getTxtFolio());
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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == pagosVista.getTxtFiltrar()) {
            filtrar();
        } 
    }
}
