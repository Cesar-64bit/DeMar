package DeMar.src.proveedores;

import DeMar.src.resaltarCampo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ProveedoresControlador implements ActionListener, MouseListener, KeyListener{
    ArrayList<JComponent> arregloComponent = new ArrayList<JComponent>();
    private resaltarCampo resaltado;
    
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
            try{
                buscarID(Integer.parseInt(pVista.getTxtBuscar()));
            }
            catch(Exception exception) {
                verificarBuscar();
            }
        }
        if(e.getSource() == pVista.getBtnAgregar()) {
            if(verificarCampos() == 0) {
                boolean registro = modProveedores.registrar(
                                                            pVista.getTxtNombre(),
                                                            pVista.getTxtInsumo(),
                                                            pVista.getTxtTelefono());
                pVista.confirmarRegistro(registro);
                pVista.limpiar();
                mostrarDatosIniciales();
            }
        }
        if(e.getSource() == pVista.getBtnModificar()) {
            if(pVista.confirmarAccion(pVista.getBtnModificar().getText()) == 0) {
                if(verificarCampos() == 0) {
                    modProveedores.modificar(
                                            pVista.getTxtNumeroProveedor(),
                                            pVista.getTxtNombre(),
                                            pVista.getTxtInsumo(),
                                            pVista.getTxtTelefono());
                    mostrarDatosIniciales();
                }
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
            pVista.getBtnAgregar().setEnabled(false);
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

    /*  Verifica la cantidad de campos vacíos y los almacena en un arrelo
     * de tipo JComponent para posteriormente recorrer el arreglo y
     * pintar el fondo de los campos que no tienen datos
    */
    public int verificarCampos() {
        if(pVista.txtNombre.getText().length() == 0)
            arregloComponent.add(pVista.getComponentTxtNombre());
        if(pVista.txtInsumo.getText().length() == 0)
            arregloComponent.add(pVista.getComponentTxtInsumo());
        if(pVista.txtTelefono.getText().length() == 0)
            arregloComponent.add(pVista.getComponentTxtTelefono());
        
        int tamaño = arregloComponent.size();

        resaltar(arregloComponent.size());

        return tamaño;
    }

    public void verificarBuscar() {
        if(pVista.txtBuscar.getText().length() == 0)
            arregloComponent.add(pVista.getComponentTxtBuscar());

        resaltar(arregloComponent.size());
    }

    public void resaltar(int size) {
        for(int indice = 0; indice < size; indice++) {
            resaltado = new resaltarCampo(arregloComponent.get(indice), new Color(214, 181, 178), 4);
            resaltado.start();
        }
        arregloComponent.clear();
    }
}
