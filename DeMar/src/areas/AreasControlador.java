package DeMar.src.areas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DeMar.src.resaltarCampo;

public class AreasControlador implements ActionListener, MouseListener, KeyListener {
    ArrayList<JComponent> arregloComponent = new ArrayList<JComponent>();
    private resaltarCampo resaltado;

    AreasModelo modAreas = new AreasModelo();
    
    TableRowSorter<DefaultTableModel> filtro;
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected AreasVista aVista;


    public AreasControlador() {
        this.aVista = new AreasVista(this);
        
        mostrarDatosIniciales();
    }

    /* ESTE MÉTODO MUESTRA LOS VALORES ACTUALES Y SE CARGAN AL ABRIR LA VENTA */
    public void mostrarDatosIniciales() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = modAreas.selTodos();

        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        filtro = new TableRowSorter<>(modelo);
        tabla.setRowSorter(filtro);

        this.aVista.diseñarJTable(tabla, scroll);
    }

    /* ESTE MÉTODO MUESTRA EL VALOR BUSCADO POR ID */
    public void buscarID(int ID) {
        tabla.setModel(modAreas.selID(ID));
        scroll.setViewportView(tabla);

        this.aVista.diseñarJTable(tabla, scroll);
    }

    public void filtrar() {
        try {
            filtro.setRowFilter(RowFilter.regexFilter(aVista.getTxtBuscar()));
        }
        catch(Exception e) {

        }
    }

    /* MÉTODO PARA OBTENER LOS EVENTOS DE LOS BOTONES SELECCIONADOS*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aVista.getBtnBuscar()) {
            try{
                buscarID(Integer.parseInt(aVista.getTxtBuscar()));
            }
            catch(Exception exception) {
                verificarBuscar();
            }
        }
        if(e.getSource() == aVista.getBtnAgregar()) {
            try{
                if(verificarCampos() == 0) {
                    boolean registro = modAreas.registrar(
                                                        aVista.getTxtNombre(), aVista.getTxtInsumo(),
                                                        aVista.getTxtEmpleados(), aVista.getTxtSueldo(), 
                                                        aVista.getTxtEntrada(), aVista.getTxtSalida());
                    aVista.confirmarRegistro(registro);
                    aVista.limpiar();
                    mostrarDatosIniciales();
                }
            }
            catch(NumberFormatException ex) {
                //JOptionPane.showMessageDialog(null, "Error en la captura de datos");
            }
        }
        if(e.getSource() == aVista.getBtnModificar()) {
            try {
                if(aVista.confirmarAccion(aVista.getBtnModificar().getText()) == 0) {
                    if(verificarCampos() == 0) {
                        boolean modificar = modAreas.modificar(
                                                            aVista.getTxtNombre(), aVista.getTxtInsumo(),
                                                            aVista.getTxtEmpleados(), aVista.getTxtSueldo(), 
                                                            aVista.getTxtEntrada(), aVista.getTxtSalida(),
                                                            aVista.getAuxNombre());
                        aVista.confirmarRegistro(modificar);
                        mostrarDatosIniciales();
                    }
                }
            }
            catch(NumberFormatException ex) {
                //JOptionPane.showMessageDialog(null, "Rellenar los campos que se indican");
            }
        }
        if(e.getSource() == aVista.getBtnEliminar()) {
            if(aVista.confirmarAccion(aVista.getBtnEliminar().getText()) == 0) {
                modAreas.eliminar(aVista.getTxtNombre());
                aVista.limpiar();
                mostrarDatosIniciales();
            }
        }
        if(e.getSource() == aVista.getBtnLimpiar()) {
            aVista.limpiar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == aVista.getTabla()) {
            int filas = aVista.getTabla().rowAtPoint(e.getPoint());
            if(filas > -1) {
                aVista.setTxtNombre(aVista.getTabla(), filas);
                aVista.setTxtInsumo(aVista.getTabla(), filas);
                aVista.setTxtEmpleados(aVista.getTabla(), filas);
                aVista.setTxtSueldo(aVista.getTabla(), filas);
                aVista.setTxtEntrada(aVista.getTabla(), filas);
                aVista.setTxtSalida(aVista.getTabla(), filas);

                aVista.setAuxNombre(aVista.getTxtNombre());
                aVista.getBtnAgregar().setEnabled(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == aVista.getTxtFiltrar()) {
            filtrar();
        }
    }

    /*  Verifica la cantidad de campos vacíos y los almacena en un arrelo
     * de tipo JComponent para posteriormente recorrer el arreglo y
     * pintar el fondo de los campos que no tienen datos
    */
    public int verificarCampos() {
        if(aVista.txtNombre.getText().length() == 0)
            arregloComponent.add(aVista.getComponentTxtNombre());
        if(aVista.txtInsumoEntrada.getText().length() == 0)
            arregloComponent.add(aVista.getComponentTxtInsumoEntrada());
        if(aVista.txtCantidadEmpleados.getText().length() == 0)
            arregloComponent.add(aVista.getComponentTxtCantidadEmpleados());
        if(aVista.txtSueldoBase.getText().length() == 0)
            arregloComponent.add(aVista.getComponentTxtSueldoBase());
        if(aVista.txtHoraEntrada.getText().length() == 0)
            arregloComponent.add(aVista.getComponentTxtHoraEntrada());
        if(aVista.txtHoraEntrada.getText().length() == 0)
            arregloComponent.add(aVista.getComponentTxtHoraSalida());
        
        int tamaño = arregloComponent.size();

        resaltar(arregloComponent.size());

        return tamaño;
    }

    public void verificarBuscar() {
        if(aVista.txtBuscar.getText().length() == 0)
            arregloComponent.add(aVista.getComponentTxtBuscar());

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