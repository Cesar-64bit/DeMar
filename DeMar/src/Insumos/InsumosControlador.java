package DeMar.src.Insumos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InsumosControlador implements ActionListener, MouseListener {
    InsumosModelo modInsumo = new InsumosModelo();
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected InsumosVista insumosVista;

    // CONSTRUCTOR
    public InsumosControlador() {
        this.insumosVista = new InsumosVista(this);

        mostrarDatosIniciales();
        rellenarProveedores();
    }

    // INICIALIZAR DATOS EN EL JFRAME
    public void mostrarDatosIniciales() {
        tabla.setModel(modInsumo.selecInsumos());
        scroll.setViewportView(tabla);

        this.insumosVista.diseñarJTable(tabla, scroll);
    }

    /* ESTE MÉTODO MUESTRA EL VALOR BUSCADO POR ID */
    public void buscarID(int ID) {
        tabla.setModel(modInsumo.selID(ID));
        scroll.setViewportView(tabla);

        this.insumosVista.diseñarJTable(tabla, scroll);
    }

     // SE COLOCAN LOS PROVEEDORES EN UN JCOMBOBOX
     public void rellenarProveedores() {
        insumosVista.setCbmProveedor(modInsumo.filProveedores());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == insumosVista.getBtnBuscar()) {
            buscarID(insumosVista.getTxtBuscar());

        }
        if(e.getSource() == insumosVista.getBtnAgregar()) {
            boolean registro = modInsumo.registrar(
                                                    insumosVista.getTxtNombre(),
                                                    insumosVista.getTxtProveedor(),
                                                    insumosVista.getTxtPrecio());
            insumosVista.confirmarRegistro(registro);
        }
        if(e.getSource() == insumosVista.getBtnModificar()) {
            if(insumosVista.confirmarAccion(insumosVista.getBtnModificar().getText()) == 0)
                modInsumo.modificar(
                                    insumosVista.getTxtFolio(),
                                    insumosVista.getTxtNombre(),
                                    insumosVista.getTxtProveedor(),
                                    insumosVista.getTxtPrecio());
        }
        if(e.getSource() == insumosVista.getBtnEliminar()) {
            if(insumosVista.confirmarAccion(insumosVista.getBtnEliminar().getText()) == 0)
                modInsumo.eliminar(insumosVista.getTxtFolio());
        }
        if(e.getSource() == insumosVista.getBtnLimpiar()) {
            insumosVista.limpiar();
        }
        if(e.getSource() == insumosVista.getCombo()) {
            DefaultTableModel tb = modInsumo.idProveedor(insumosVista.getCombo().getSelectedItem().toString());   
            insumosVista.colocarID(String.valueOf(tb.getValueAt(0, 0)));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == insumosVista.getTabla()) {
            int filas = insumosVista.getTabla().rowAtPoint(e.getPoint());
            if(filas > -1) {
                insumosVista.setTxtFolio(insumosVista.getTabla(), filas);
                insumosVista.setTxtNombre(insumosVista.getTabla(), filas);
                insumosVista.setTxtProveedor(insumosVista.getTabla(), filas);
                insumosVista.setTxtPrecio(insumosVista.getTabla(), filas);
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
