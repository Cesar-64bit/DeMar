package DeMar.src.usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UsuariosControlador implements ActionListener, MouseListener {
    UsuariosModelo modUsuarios = new UsuariosModelo();
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    protected UsuariosVista usuariosVista;

    public UsuariosControlador() {
        this.usuariosVista = new UsuariosVista(this);

        mostrarDatosIniciales();
    }

    public void mostrarDatosIniciales() {
        tabla.setModel(modUsuarios.selecUsuariosActivos());
        scroll.setViewportView(tabla);

        this.usuariosVista.diseñarJTable(tabla, scroll);
    }

    public void buscarID(int ID) {
        tabla.setModel(modUsuarios.buscarUsuario(ID));
        scroll.setViewportView(tabla);

        this.usuariosVista.diseñarJTable(tabla, scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == usuariosVista.getBtnBuscar()) {
            buscarID(usuariosVista.getTxtBuscar());
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
}