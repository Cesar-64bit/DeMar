package DeMar.src.gastos;

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

import DeMar.src.resaltarCampo;

public class GastosControlador implements ActionListener, MouseListener, KeyListener{
    ArrayList<JComponent> arregloComponent = new ArrayList<JComponent>();
    private resaltarCampo resaltado;

    GastosModelo modGastos = new GastosModelo();

    TableRowSorter<DefaultTableModel> filtro;
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected GastosVista gastosVista;

    public GastosControlador() {
        this.gastosVista = new GastosVista(this);

        mostrarDatosIniciales();
        rellenarEmpleados();
    }

    public void mostrarDatosIniciales() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = modGastos.selecGastos();

        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        filtro = new TableRowSorter<>(modelo);
        tabla.setRowSorter(filtro);

        scroll.setViewportView(tabla);

        this.gastosVista.diseñarJTable(tabla, scroll);
    }

     /* ESTE MÉTODO MUESTRA EL VALOR BUSCADO POR ID */
     public void buscarID(int ID) {
        tabla.setModel(modGastos.selID(ID));
        scroll.setViewportView(tabla);

        this.gastosVista.diseñarJTable(tabla, scroll);
    }

    // SE COLOCAN LOS EMPLEADOS EN UN JCOMBOBOX
    public void rellenarEmpleados() {
        gastosVista.setCbmEmpleados(modGastos.filEmpleados());
    }

    public void filtrar() {
        try {
            filtro.setRowFilter(RowFilter.regexFilter(gastosVista.getTxtBuscar()));
        }
        catch(Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gastosVista.getBtnBuscar()) {
            buscarID(Integer.parseInt(gastosVista.getTxtBuscar()));

        }
        if(e.getSource() == gastosVista.getBtnAgregar()) {
            if(verificarCampos() == 0) {
                boolean registro = modGastos.registrar(
                                                        gastosVista.getTxtTipo(),
                                                        gastosVista.getTxtCantidad(),
                                                        gastosVista.getTxtFecha(),
                                                        gastosVista.getTxtEmpleado());
                gastosVista.confirmarRegistro(registro);
                mostrarDatosIniciales();
            }
        }
        if(e.getSource() == gastosVista.getBtnModificar()) {
            if(gastosVista.confirmarAccion(gastosVista.getBtnModificar().getText()) == 0)
                modGastos.modificar(
                                    gastosVista.getTxtGasto(),
                                    gastosVista.getTxtTipo(),
                                    gastosVista.getTxtCantidad(),
                                    gastosVista.getTxtFecha(),
                                    gastosVista.getTxtEmpleado());
        }
        if(e.getSource() == gastosVista.getBtnEliminar()) {
            if(gastosVista.confirmarAccion(gastosVista.getBtnEliminar().getText()) == 0)
                modGastos.eliminar(gastosVista.getTxtGasto());

        }
        if(e.getSource() == gastosVista.getBtnLimpiar()) {
            gastosVista.limpiar();
        }
        if(e.getSource() == gastosVista.getCombo()) {
            DefaultTableModel tb = modGastos.idEmpleado(gastosVista.getCombo().getSelectedItem().toString());   
            gastosVista.colocarID(String.valueOf(tb.getValueAt(0, 0)));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == gastosVista.getTabla()) {
            int filas = gastosVista.getTabla().rowAtPoint(e.getPoint());
            if(filas > -1) {
                gastosVista.setTxtGasto(gastosVista.getTabla(), filas);
                gastosVista.setTxtTipo(gastosVista.getTabla(), filas);
                gastosVista.setTxtCantidad(gastosVista.getTabla(), filas);
                gastosVista.setTxtFecha(gastosVista.getTabla(), filas);
                gastosVista.setTxtEmpleado(gastosVista.getTabla(), filas);
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
        if(e.getSource() == gastosVista.getTxtFiltrar()) {
            filtrar();
        }
    }

    /*  Verifica la cantidad de campos vacíos y los almacena en un arrelo
     * de tipo JComponent para posteriormente recorrer el arreglo y
     * pintar el fondo de los campos que no tienen datos
    */
    public int verificarCampos() {
        if(gastosVista.txtTipo.getText().length() == 0)
            arregloComponent.add(gastosVista.getComponentTxtGasto());
        if(gastosVista.txtCantidad.getText().length() == 0)
            arregloComponent.add(gastosVista.getComponentTxtCantidad());
        if(gastosVista.txtEmpleado.getText().length() == 0)
            arregloComponent.add(gastosVista.getComponentTxtEmpleado());

        int camposVacios = arregloComponent.size();
        
        resaltar();

        return camposVacios;
    }

     public void resaltar() {
        for(int indice = 0; indice < arregloComponent.size(); indice++) {
            resaltado = new resaltarCampo(arregloComponent.get(indice), new Color(214, 181, 178), 4);
            resaltado.start();
        }
        arregloComponent.clear();
    }
}
