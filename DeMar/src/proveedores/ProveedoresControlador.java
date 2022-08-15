package DeMar.src.proveedores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProveedoresControlador implements ActionListener, MouseListener {
    ProveedoresModelo modProveedores = new ProveedoresModelo();
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected ProveedoresVista pVista;

    public ProveedoresControlador() {
        this.pVista = new ProveedoresVista(this);

        mostrarDatosIniciales();
    }

    public void mostrarDatosIniciales() {
        tabla.setModel(modProveedores.selecProveedoresActivos());
        scroll.setViewportView(tabla);

        this.pVista.diseñarJTable(tabla, scroll);
    }

     /* ESTE MÉTODO MUESTRA EL VALOR BUSCADO POR ID */
     public void buscarID(int ID) {
        tabla.setModel(modProveedores.selID(ID));
        scroll.setViewportView(tabla);

        this.pVista.diseñarJTable(tabla, scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pVista.getBtnBuscar()) {
            buscarID(pVista.getTxtBuscar());
        }
        if(e.getSource() == pVista.getBtnAgregar()) {
            boolean registro = modProveedores.registrar(
                                                        pVista.getTxtNombre(),
                                                        pVista.getTxtInsumo(),
                                                        pVista.getTxtTelefono());
            pVista.confirmarRegistro(registro);
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
}
