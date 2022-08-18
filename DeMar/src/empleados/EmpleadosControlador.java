package DeMar.src.empleados;

import DeMar.src.resaltarCampo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class EmpleadosControlador implements ActionListener, MouseListener, KeyListener {
    ArrayList<JComponent> arregloComponent = new ArrayList<JComponent>();
    private resaltarCampo resaltado;
    DefaultTableModel modelo = new DefaultTableModel();

    EmpleadosModelo modEmpleados = new EmpleadosModelo();

    TableRowSorter<DefaultTableModel> filtro;
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected EmpleadosVista eVista;

    public EmpleadosControlador() {
        this.eVista = new EmpleadosVista(this);

        mostrarDatosIniciales();
        rellenarAreas();
    }

    /* ESTE MÉTODO MUESTRA LOS VALORES ACTUALES Y SE CARGAN AL ABRIR LA VENTA */
    public void mostrarDatosIniciales() {
        modelo = modEmpleados.selecEmpleadosActivos();

        tabla.setModel(modelo);

        tabla.setAutoCreateRowSorter(true);
        filtro = new TableRowSorter<>(modelo);
        tabla.setRowSorter(filtro);

        this.eVista.diseñarJTable(tabla, scroll);
    }


    /* ESTE MÉTODO MUESTRA EL VALOR BUSCADO POR ID */
    public void buscarID(int ID) {
        tabla.setModel(modEmpleados.selID(ID));
        scroll.setViewportView(tabla);

        this.eVista.diseñarJTable(tabla, scroll);
    }

    // SE OBTIENE EL ID DEL AREA
    public String obtenerAreaID(String nombre) {
        DefaultTableModel id = modEmpleados.obtenerIDArea(nombre);
        return id.getValueAt(0, 0).toString();
    }

    // SE COLOCAN LAS ÁREAS EN UN JCOMBOBOX
    public void rellenarAreas() {
        eVista.setCmbAreas(modEmpleados.filAreas());
    }

    public void filtrar() {
        try {
            filtro.setRowFilter(RowFilter.regexFilter(eVista.getTxtBuscar()));
        }
        catch(Exception e) {

        }
    }

    // EVENTOS DE LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == eVista.getBtnBuscar()) {
            try{
                buscarID(Integer.parseInt(eVista.getTxtBuscar()));
            }
            catch(Exception exception) {
                verificarBuscar();
            }
        }
        if(e.getSource() == eVista.getBtnAgregar()) {
            try {
                boolean registro = modEmpleados.registrar(
                                                    eVista.getTxtNombre(),
                                                    eVista.getTxtTelefono(), 
                                                    eVista.getTxtDireccion(),
                                                    eVista.getTxtDiasLaborados(), 
                                                    eVista.getTxtFechaContrato(),
                                                    eVista.getTxtAreas(),
                                                    eVista.getTxtRutaImagen());
                eVista.confirmarRegistro(registro);
                eVista.limpiar();
                mostrarDatosIniciales();
            }
            catch(Exception exception) {
                verificarCampos();
            }
        }
        if(e.getSource() == eVista.getBtnModificar()) {
            try{
                if(eVista.confirmarAccion(eVista.getBtnModificar().getText()) == 0) {
                    modEmpleados.modificar(
                                            eVista.getTxtNumeroEmpleado(),
                                            eVista.getTxtNombre(),
                                            eVista.getTxtTelefono(), 
                                            eVista.getTxtDireccion(),
                                            eVista.getTxtDiasLaborados(), 
                                            eVista.getTxtFechaContrato(),
                                            eVista.getTxtAreas(),
                                            eVista.getTxtRutaImagen());
                    mostrarDatosIniciales();
                }
            }
            catch(Exception exception) {
                verificarCampos();
            }
        }

        if(e.getSource() == eVista.getBtnEliminar()) {
            if(eVista.confirmarAccion(eVista.getBtnEliminar().getText()) == 0) {
                modEmpleados.eliminar(eVista.getTxtNumeroEmpleado());
                mostrarDatosIniciales();
            }
        }

        if(e.getSource() == eVista.getBtnLimpiar()) {
            eVista.limpiar();
        }
        if(e.getSource() == eVista.getBtnCargarFoto()) {
            // Cargar ruta de una imagen
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(choose);

            File ruta = choose.getSelectedFile();
            String rutas = ruta.getAbsolutePath();

            eVista.setTxtRuta(rutas.replace("\\", "/"));
        }
        if(e.getSource() == eVista.getCombo()) {
            eVista.colocarID(obtenerAreaID(eVista.getCmbAreas()));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == eVista.getTabla()) {
            int filas = eVista.getTabla().rowAtPoint(e.getPoint());
            if(filas > -1) {
                eVista.setTxtNumeroEmpleado(eVista.getTabla(), filas);
                eVista.setTxtNombre(eVista.getTabla(), filas);
                eVista.setTxtTelefono(eVista.getTabla(), filas);
                eVista.setTxtDireccion(eVista.getTabla(), filas);
                eVista.setTxtAreas(eVista.getTabla(), filas);
                eVista.setTxtFechaContrato(eVista.getTabla(), filas);
                eVista.setTxtDiasLaborados(eVista.getTabla(), filas);
                eVista.setTxtRuta(eVista.getTabla(), filas);
            }
            eVista.getBtnAgregar().setEnabled(false);;
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
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == eVista.getTxtFiltrar()) {
            filtrar();
        }
    }


    /*  Verifica la cantidad de campos vacíos y los almacena en un arrelo
     * de tipo JComponent para posteriormente recorrer el arreglo y
     * pintar el fondo de los campos que no tienen datos
    */
    public void verificarCampos() {
        if(eVista.txtNombre.getText().length() == 0)
            arregloComponent.add(eVista.getComponentTxtNombre());
        if(eVista.txtTelefono.getText().length() == 0)
            arregloComponent.add(eVista.getComponentTxtTelefono());
        if(eVista.txtDireccion.getText().length() == 0)
            arregloComponent.add(eVista.getComponentTxtDireccion());
        if(eVista.txtDiasLaborados.getText().length() == 0)
            arregloComponent.add(eVista.getComponentTxtDiasLaborados());
        
        resaltar(arregloComponent.size());
    }

    public void verificarBuscar() {
        if(eVista.txtBuscar.getText().length() == 0)
            arregloComponent.add(eVista.getComponentTxtBuscar());

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