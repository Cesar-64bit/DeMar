package DeMar.src.recepcion;

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

public class RecepcionControlador implements ActionListener, MouseListener, KeyListener {
    ArrayList<JComponent> arregloComponent = new ArrayList<JComponent>();
    private resaltarCampo resaltado;

    RecepcionModelo modRecepcion = new RecepcionModelo();

    TableRowSorter<DefaultTableModel> filtro;
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
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = modRecepcion.selecRecepciones();

        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        filtro = new TableRowSorter<>(modelo);
        tabla.setRowSorter(filtro);
        this.recepcionVista.diseñarJTable(tabla, scroll);
    }

    /* ESTE MÉTODO MUESTRA EL VALOR BUSCADO POR ID */
    public void buscarID(int ID) {
        tabla.setModel(modRecepcion.selID(ID));
        scroll.setViewportView(tabla);

        this.recepcionVista.diseñarJTable(tabla, scroll);
    }

    // SE COLOCAN LOS EMPLEADOS EN UN JCOMBOBOX
    public void rellenarEmpleados() {
        recepcionVista.setCbmEmpleados(modRecepcion.filEmpleados());
    }

    public void filtrar() {
        try {
            filtro.setRowFilter(RowFilter.regexFilter(recepcionVista.getTxtBuscar()));
        }
        catch(Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == recepcionVista.getBtnBuscar()) {
            buscarID(Integer.parseInt(recepcionVista.getTxtBuscar()));

        }
        if(e.getSource() == recepcionVista.getBtnAgregar()) {
            if(verificarCampos() == 0) {
                boolean registro = modRecepcion.registrar(
                                                        recepcionVista.getTxtFecha(),
                                                        recepcionVista.getTxtCantidad(), 
                                                        recepcionVista.getTxtEmpleado());
                recepcionVista.confirmarRegistro(registro);
                recepcionVista.limpiar();
                mostrarDatosIniciales();
            }
        }
        if(e.getSource() == recepcionVista.getBtnModificar()) {
            if(recepcionVista.confirmarAccion(recepcionVista.getBtnModificar().getText()) == 0) {
                if(verificarCampos() == 0) {
                    modRecepcion.modificar(
                                            recepcionVista.getTxtFolio(),
                                            recepcionVista.getTxtFecha(),
                                            recepcionVista.getTxtCantidad(),
                                            recepcionVista.getTxtEmpleado());
                    mostrarDatosIniciales();
                }
            }
        }
        if(e.getSource() == recepcionVista.getBtnEliminar()) {
            if(recepcionVista.confirmarAccion(recepcionVista.getBtnEliminar().getText()) == 0) {
                modRecepcion.eliminar(recepcionVista.getTxtFolio());
                mostrarDatosIniciales();
            }
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
            recepcionVista.getBtnAgregar().setEnabled(false);
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
        if(e.getSource() == recepcionVista.getTxtFiltrar()) {
            filtrar();
        } 
    }

    /*  Verifica la cantidad de campos vacíos y los almacena en un arrelo
     * de tipo JComponent para posteriormente recorrer el arreglo y
     * pintar el fondo de los campos que no tienen datos
    */
    public int verificarCampos() {
        if(recepcionVista.txtCantidad.getText().length() == 0)
            arregloComponent.add(recepcionVista.getComponentTxtCantidad());
        if(recepcionVista.txtEmpleado.getText().length() == 0)
            arregloComponent.add(recepcionVista.getComponentTxtEmpleado());

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