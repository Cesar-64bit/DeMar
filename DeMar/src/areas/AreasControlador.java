package DeMar.src.areas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AreasControlador implements ActionListener, MouseListener {
    AreasModelo modAreas = new AreasModelo();
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected AreasVista aVista;


    public AreasControlador() {
        this.aVista = new AreasVista(this);
        mostrarDatosIniciales();
    }

    /* ESTE MÉTODO MUESTRA LOS VALORES ACTUALES Y SE CARGAN AL ABRIR LA VENTA */
    public void mostrarDatosIniciales() {
        tabla.setModel(modAreas.selTodos());
        scroll.setViewportView(tabla);

        this.aVista.diseñarJTable(tabla, scroll);
    }

    /* ESTE MÉTODO MUESTRA EL VALOR BUSCADO POR ID */
    public void buscarID(int ID) {
        tabla.setModel(modAreas.selID(ID));
        scroll.setViewportView(tabla);

        this.aVista.diseñarJTable(tabla, scroll);
    }

    /* MÉTODO PARA OBTENER LOS EVENTOS DE LOS BOTONES SELECCIONADOS*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aVista.getBtnBuscar()) {
            buscarID(aVista.getTxtBuscar());
        }
        if(e.getSource() == aVista.getBtnAgregar()) {
            boolean registro = modAreas.registrar(
                                                aVista.getTxtNombre(), aVista.getTxtInsumo(),
                                                aVista.getTxtEmpleados(), aVista.getTxtSueldo(), 
                                                aVista.getTxtEntrada(), aVista.getTxtSalida());
            aVista.confirmarRegistro(registro);
        }
        if(e.getSource() == aVista.getBtnModificar()) {
            if(aVista.confirmarAccion(aVista.getBtnModificar().getText()) == 0) {
                boolean registro = modAreas.modificar(
                                                    aVista.getTxtNombre(), aVista.getTxtInsumo(),
                                                    aVista.getTxtEmpleados(), aVista.getTxtSueldo(), 
                                                    aVista.getTxtEntrada(), aVista.getTxtSalida(),
                                                    aVista.getAuxNombre());
                aVista.confirmarRegistro(registro);
            }
        }
        if(e.getSource() == aVista.getBtnEliminar()) {
            if(aVista.confirmarAccion(aVista.getBtnEliminar().getText()) == 0)
                modAreas.eliminar(aVista.getTxtNombre());
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
}