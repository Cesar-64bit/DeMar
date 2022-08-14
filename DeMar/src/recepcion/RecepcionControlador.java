package DeMar.src.recepcion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RecepcionControlador implements ActionListener, MouseListener{
    RecepcionModelo modRecepcion = new RecepcionModelo();
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected RecepcionVista recepcionVista;


    public RecepcionControlador() {
        this.recepcionVista = new RecepcionVista(this);

        mostrarDatosIniciales();
        rellenarEmpleados();
    }

     /* ESTE MÉTODO MUESTRA LOS VALORES ACTUALES Y SE CARGAN AL ABRIR LA VENTA */
     public void mostrarDatosIniciales() {
        tabla.setModel(modRecepcion.selecRecepciones());
        scroll.setViewportView(tabla);

        this.recepcionVista.diseñarJTable(tabla, scroll);
    }

    // SE COLOCAN LOS EMPLEADOS EN UN JCOMBOBOX
    public void rellenarEmpleados() {
        recepcionVista.setCbmEmpleados(modRecepcion.filEmpleados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == recepcionVista.getBtnAgregar()) {
            boolean registro = modRecepcion.registrar(
                                                    recepcionVista.getTxtFecha(),
                                                    recepcionVista.getTxtCantidad(), 
                                                    recepcionVista.getTxtEmpleado());
            recepcionVista.confirmarRegistro(registro);
        }
        if(e.getSource() == recepcionVista.getBtnModificar()) {
            if(recepcionVista.confirmarAccion(recepcionVista.getBtnEliminar().getText()) == 0)
                modRecepcion.modificar(
                                        recepcionVista.getTxtFolio(),
                                        recepcionVista.getTxtFecha(),
                                        recepcionVista.getTxtCantidad(),
                                        recepcionVista.getTxtEmpleado());
        }
        if(e.getSource() == recepcionVista.getBtnEliminar()) {
            if(recepcionVista.confirmarAccion(recepcionVista.getBtnEliminar().getText()) == 0)
                modRecepcion.eliminar(recepcionVista.getTxtFolio());
        }
        if(e.getSource() == recepcionVista.getBtnLimpiar()) {
            recepcionVista.limpiar();
        }
        if(e.getSource() == recepcionVista.getCombo()) {
            DefaultTableModel tb = modRecepcion.nomEmpleado(recepcionVista.getCombo().getSelectedItem().toString());   
            recepcionVista.colocarID(String.valueOf(tb.getValueAt(0, 0)));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == recepcionVista.getTabla()) {
            int filas = recepcionVista.getTabla().rowAtPoint(e.getPoint());
            if(filas > -1) {
                recepcionVista.setTxtFolio(recepcionVista.getTabla(), filas);
                recepcionVista.setTxtFecha(recepcionVista.getTabla(), filas);
                recepcionVista.setTxtCantidad(recepcionVista.getTabla(), filas);
                recepcionVista.setTxtEmpleado(recepcionVista.getTabla(), filas);
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