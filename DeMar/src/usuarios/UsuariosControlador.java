package DeMar.src.usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class UsuariosControlador implements ActionListener, MouseListener, KeyListener {
    UsuariosModelo modUsuarios = new UsuariosModelo();

    TableRowSorter<DefaultTableModel> filtro;
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected UsuariosVista usuariosVista;

    public UsuariosControlador() {
        this.usuariosVista = new UsuariosVista(this);

        mostrarDatosIniciales();
    }

    public void mostrarDatosIniciales() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = modUsuarios.selecUsuariosActivos();

        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        filtro = new TableRowSorter<>(modelo);
        tabla.setRowSorter(filtro);

        scroll.setViewportView(tabla);

        this.usuariosVista.diseñarJTable(tabla, scroll);
    }

    public void buscarID(int ID) {
        tabla.setModel(modUsuarios.buscarUsuario(ID));
        scroll.setViewportView(tabla);

        this.usuariosVista.diseñarJTable(tabla, scroll);
    }

    public void filtrar() {
        try {
            filtro.setRowFilter(RowFilter.regexFilter(usuariosVista.getTxtBuscar()));
        }
        catch(Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == usuariosVista.getBtnBuscar()) {
            buscarID(Integer.parseInt(usuariosVista.getTxtBuscar()));
        }
        if(e.getSource() == usuariosVista.getBtnCrearUsuario()) {
            CrearUsuariosControlador cuVista = new CrearUsuariosControlador();
            cuVista.getClass();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
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
        if(e.getSource() == usuariosVista.getTxtFiltrar()) {
            filtrar();
        } 
    }    
}