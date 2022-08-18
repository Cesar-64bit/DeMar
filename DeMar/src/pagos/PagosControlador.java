package DeMar.src.pagos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import DeMar.src.resaltarCampo;

import java.awt.event.MouseEvent;

public class PagosControlador implements ActionListener, MouseListener, KeyListener {
    ArrayList<JComponent> arregloComponent = new ArrayList<JComponent>();
    private resaltarCampo resaltado;

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
            try{
                buscarID(Integer.parseInt(pagosVista.getTxtBuscar()));
            }
            catch(Exception exception) {
                verificarBuscar();
            }
        }
        if(e.getSource() == pagosVista.getBtnAgregar()) {
            if(verificarCampos() == 0) {
                boolean registro = modPagos.registrar(
                                                    pagosVista.getTxtTotal(), 
                                                    pagosVista.getTxtTipoPago(), 
                                                    pagosVista.getTxtFecha(), 
                                                    pagosVista.getTxtTEmpleado(), 
                                                    pagosVista.getTxtDetallePedido());
                pagosVista.confirmarRegistro(registro);
                pagosVista.limpiar();
                mostrarDatosIniciales();
            }
        }
        if(e.getSource() == pagosVista.getBtnModificar()) {
            if(pagosVista.confirmarAccion(pagosVista.getBtnModificar().getText()) == 0) {
                if(verificarCampos() == 0) {
                    modPagos.modificar(
                                        pagosVista.getTxtFolio(),
                                        pagosVista.getTxtTotal(), 
                                        pagosVista.getTxtTipoPago(), 
                                        pagosVista.getTxtFecha(), 
                                        pagosVista.getTxtTEmpleado(), 
                                        pagosVista.getTxtDetallePedido());
                    mostrarDatosIniciales();
                }
            }
        }
        if(e.getSource() == pagosVista.getBtnEliminar()) {
            if(pagosVista.confirmarAccion(pagosVista.getBtnEliminar().getText()) == 0) {
                modPagos.eliminar(pagosVista.getTxtFolio());
                mostrarDatosIniciales();
            }
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
            pagosVista.getBtnAgregar().setEnabled(false);
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

    /*  Verifica la cantidad de campos vacíos y los almacena en un arrelo
     * de tipo JComponent para posteriormente recorrer el arreglo y
     * pintar el fondo de los campos que no tienen datos
    */
    public int verificarCampos() {
        if(pagosVista.txtTotal.getText().length() == 0)
            arregloComponent.add(pagosVista.getComponentTxtTotal());
        if(pagosVista.txtEmpleado.getText().length() == 0)
            arregloComponent.add(pagosVista.getComponentTxtEmpleado());
        if(pagosVista.txtDetallesPedido.getText().length() == 0)
            arregloComponent.add(pagosVista.getComponentTxtDetalles());

        int camposVacios = arregloComponent.size();
        
        resaltar(camposVacios);

        return camposVacios;
    }

    public void verificarBuscar() {
        if(pagosVista.txtBuscar.getText().length() == 0)
            arregloComponent.add(pagosVista.getComponentTxtBuscar());

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
