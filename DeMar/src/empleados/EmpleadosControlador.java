package DeMar.src.empleados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class EmpleadosControlador implements ActionListener, MouseListener, KeyListener {
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
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = modEmpleados.selecEmpleadosActivos();

        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        filtro = new TableRowSorter<>(modelo);
        tabla.setRowSorter(filtro);

        scroll.setViewportView(tabla);

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
            buscarID(Integer.parseInt(eVista.getTxtBuscar()));
        }
        if(e.getSource() == eVista.getBtnAgregar()) {
            boolean registro = modEmpleados.registrar(
                                                eVista.getTxtNombre(),
                                                eVista.getTxtTelefono(), 
                                                eVista.getTxtDireccion(),
                                                eVista.getTxtDiasLaborados(), 
                                                eVista.getTxtFechaContrato(),
                                                eVista.getTxtAreas(),
                                                eVista.getTxtRutaImagen());
            eVista.confirmarRegistro(registro);
            mostrarDatosIniciales();
        }
        if(e.getSource() == eVista.getBtnModificar()) {
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
            }
        }

        if(e.getSource() == eVista.getBtnEliminar()) {
            if(eVista.confirmarAccion(eVista.getBtnEliminar().getText()) == 0) {
                modEmpleados.eliminar(eVista.getTxtNumeroEmpleado());
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
}