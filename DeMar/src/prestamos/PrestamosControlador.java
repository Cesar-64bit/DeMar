package DeMar.src.prestamos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseEvent;

public class PrestamosControlador implements ActionListener, MouseListener {
    PrestamosModelo modPrestamos = new PrestamosModelo();
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();
    
    protected PrestamosVista prestamosVista;

    public PrestamosControlador() {
        this.prestamosVista = new PrestamosVista(this);

        mostrarDatosIniciales();
        rellenarEmpleados();
    }

    public void mostrarDatosIniciales() {
        tabla.setModel(modPrestamos.selecPrestamos());
        scroll.setViewportView(tabla);

        this.prestamosVista.diseñarJTable(tabla, scroll);
    }

     // SE COLOCAN LOS EMPLEADOS EN UN JCOMBOBOX
     public void rellenarEmpleados() {
        prestamosVista.setCbmEmpleados(modPrestamos.filEmpleados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == prestamosVista.getBtnAgregar()) {
            boolean registro = modPrestamos.registrar(
                                                    prestamosVista.getTxtFechaPrestamo(),
                                                    prestamosVista.getTxtFechaPago(),
                                                    prestamosVista.getTxtEmpleado(),
                                                    prestamosVista.getTxtTipo(),
                                                    prestamosVista.getTxtCantidad(),
                                                    prestamosVista.getTxtPlazosTotales(),
                                                    prestamosVista.getTxtPlazosPagados());
            prestamosVista.confirmarRegistro(registro);
        }
        if(e.getSource() == prestamosVista.getBtnModificar()) {
            if(prestamosVista.confirmarAccion(prestamosVista.getBtnModificar().getText()) == 0)
                modPrestamos.modificar(
                                        prestamosVista.getTxtFolio(),
                                        prestamosVista.getTxtFechaPrestamo(),
                                        prestamosVista.getTxtFechaPago(),
                                        prestamosVista.getTxtEmpleado(),
                                        prestamosVista.getTxtTipo(),
                                        prestamosVista.getTxtCantidad(),
                                        prestamosVista.getTxtPlazosTotales(),
                                        prestamosVista.getTxtPlazosPagados());
        }
        if(e.getSource() == prestamosVista.getBtnEliminar()) {
            if(prestamosVista.confirmarAccion(prestamosVista.getBtnEliminar().getText()) == 0)
                modPrestamos.eliminar(prestamosVista.getTxtFolio());
        }
        if(e.getSource() == prestamosVista.getBtnLimpiar()) {
            prestamosVista.limpiar();
        }
        if(e.getSource() == prestamosVista.getCombo()) {
            DefaultTableModel tb = modPrestamos.nomEmpleado(prestamosVista.getCombo().getSelectedItem().toString());   
            prestamosVista.colocarID(String.valueOf(tb.getValueAt(0, 0)));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == prestamosVista.getTabla()) {
            int filas = prestamosVista.getTabla().rowAtPoint(e.getPoint());
            if(filas > -1) {
                prestamosVista.setTxtFolio(prestamosVista.getTabla(), filas);
                prestamosVista.setTxtFechaPrestamo(prestamosVista.getTabla(), filas);
                prestamosVista.setTxtFechaPago(prestamosVista.getTabla(), filas);
                prestamosVista.setTxtEmpleado(prestamosVista.getTabla(), filas);
                prestamosVista.setTxtCantidad(prestamosVista.getTabla(), filas);
                prestamosVista.setTxtPlazosTotales(prestamosVista.getTabla(), filas);
                prestamosVista.setTxtPlazosPagados(prestamosVista.getTabla(), filas);
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
