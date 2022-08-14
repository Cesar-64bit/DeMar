package DeMar.src.empleados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpleadosControlador implements ActionListener, MouseListener {
    EmpleadosModelo modEmpleados = new EmpleadosModelo();
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
        tabla.setModel(modEmpleados.selecEmpleadosActivos());
        scroll.setViewportView(tabla);

        this.eVista.diseñarJTable(tabla, scroll);
    }

    // SE OBTIENE EL ID DEL AREA
    public int obtenerAreaID(String nombre) {
        DefaultTableModel id = modEmpleados.obtenerIDArea(nombre);
        return Integer.parseInt(id.getValueAt(0, 0).toString());
    }

    // SE COLOCAN LAS ÁREAS EN UN JCOMBOBOX
    public void rellenarAreas() {
        eVista.setTxtAreas(modEmpleados.filAreas());
    }

    // EVENTOS DE LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == eVista.getBtnAgregar()) {
            boolean registro = modEmpleados.registrar(
                                                eVista.getTxtNombre(), eVista.getTxtTelefono(), 
                                                eVista.getTxtDireccion(), eVista.getTxtDiasLaborados(), 
                                                eVista.getTxtFechaContrato(), obtenerAreaID(eVista.getTxtAreas()));
            eVista.confirmarRegistro(registro);
        }
        if(e.getSource() == eVista.getBtnModificar()) {
            // Pendiente
        }

        if(e.getSource() == eVista.getBtnEliminar()) {
            if(eVista.confirmarAccion(eVista.getBtnEliminar().getText()) == 0)
                modEmpleados.eliminar(eVista.getTxtNumeroEmpleado());
        }

        if(e.getSource() == eVista.getBtnLimpiar()) {
            eVista.limpiar();
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
                //eVista.setAuxNombre(eVista.getTxtNombre());
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