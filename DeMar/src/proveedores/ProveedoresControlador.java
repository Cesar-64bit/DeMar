package DeMar.src.proveedores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ProveedoresControlador implements ActionListener, MouseListener, KeyListener{
    ProveedoresModelo modProveedores = new ProveedoresModelo();

    TableRowSorter<DefaultTableModel> filtro;
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected ProveedoresVista pVista;

    public ProveedoresControlador() {
        this.pVista = new ProveedoresVista(this);

        mostrarDatosIniciales();
    }

    public void mostrarDatosIniciales() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = modProveedores.selecProveedoresActivos();

        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        filtro = new TableRowSorter<>(modelo);
        tabla.setRowSorter(filtro);

        scroll.setViewportView(tabla);

        this.pVista.diseñarJTable(tabla, scroll);
    }

     /* ESTE MÉTODO MUESTRA EL VALOR BUSCADO POR ID */
     public void buscarID(int ID) {
        tabla.setModel(modProveedores.selID(ID));
        scroll.setViewportView(tabla);

        this.pVista.diseñarJTable(tabla, scroll);
    }

    public void filtrar() {
        try {
            filtro.setRowFilter(RowFilter.regexFilter(pVista.getTxtBuscar()));
        }
        catch(Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pVista.getBtnBuscar()) {
            buscarID(Integer.parseInt(pVista.getTxtBuscar()));
        }
        if(e.getSource() == pVista.getBtnAgregar()) {
            boolean registro = modProveedores.registrar(
                                                        pVista.getTxtNombre(),
                                                        pVista.getTxtInsumo(),
                                                        pVista.getTxtTelefono());
            pVista.confirmarRegistro(registro);
            mostrarDatosIniciales();
        }
        if(e.getSource() == pVista.getBtnModificar()) {
            if(pVista.confirmarAccion(pVista.getBtnModificar().getText()) == 0) {
                modProveedores.modificar(
                                        pVista.getTxtNumeroProveedor(),
                                        pVista.getTxtNombre(),
                                        pVista.getTxtInsumo(),
                                        pVista.getTxtTelefono());
            }
        }
        if(e.getSource() == pVista.getBtnEliminar()) {
            if(pVista.confirmarAccion(pVista.getBtnEliminar().getText()) == 0)
                modProveedores.eliminar(pVista.getTxtNumeroProveedor());
        }
        if(e.getSource() == pVista.getBtnLimpiar()) {
            pVista.limpiar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == pVista.getTabla()) {
            int filas = pVista.getTabla().rowAtPoint(e.getPoint());
            if(filas > -1) {
                pVista.setTxtNumerpProveedor(pVista.getTabla(), filas);
                pVista.setTxtNombre(pVista.getTabla(), filas);
                pVista.setTxtInsumo(pVista.getTabla(), filas);
                pVista.setTxtTelefono(pVista.getTabla(), filas);
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
        if(e.getSource() == pVista.getTxtFiltrar()) {
            filtrar();
        } 
    }
}
