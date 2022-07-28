package DeMar.src.areas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;

public class AreasControlador implements ActionListener {
    AreasModelo verDatos = new AreasModelo();
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    private AreasVista aVista;


    public AreasControlador() {
        this.aVista = new AreasVista(this);
        mostrarDatosIniciales();
    }


    /* ESTE MÉTODO MUESTRA LOS VALORES ACTUALES Y SE CARGAN AL ABRIR LA VENTA */
    public void mostrarDatosIniciales() {
        tabla.setModel(verDatos.selTodos());
        scroll.setViewportView(tabla);

        this.aVista.diseñarJTable(tabla, scroll);
    }

    /* ESTE MÉTODO MUESTRA EL VALOR BUSCADO POR ID */
    public void buscarID(int ID) {
        tabla.setModel(verDatos.selID(ID));
        scroll.setViewportView(tabla);

        this.aVista.diseñarJTable(tabla, scroll);
    }

    /* MÉTODO PARA OBTENER LOS EVENTOS DE LOS BOTONES SELECCIONADOS*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aVista.getBtnBuscar()) {
            buscarID(aVista.getTxtBuscar());
        }
        else
         JOptionPane.showMessageDialog(null, "No");
    }
}
