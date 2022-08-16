package DeMar.src.usuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CrearUsuariosVista extends JFrame {
    protected JPanel pFondo, pGrupo;
    protected JLabel lblEmpleado, lblNombreUsuario,
                    lblContraseña, lblRol; 
    protected JTextField txtNombreUsuario, txtContraseña;
    protected JComboBox<String> cmbEmpleado, cmbRol;
    protected JButton btnAceptar;
    protected String nombreEmpleado, nombreRol;

    protected CrearUsuariosControlador crearUsuariosControlador;

    public CrearUsuariosVista(CrearUsuariosControlador crearUsuariosControlador) {
        super("Crear usuarios");

        this.crearUsuariosControlador = crearUsuariosControlador;
        this.crearPanels();
        this.crearLabels();
        this.crearTextField();
        this.crearButtons();

        setSize(515, 625);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true);
    }

    public void crearPanels() {
        pFondo = new JPanel();
        pFondo.setSize(500,600);
        pFondo.setLocation(0,0);
        pFondo.setBackground(Color.WHITE);
        pFondo.setLayout(null);
        this.add(pFondo);

        pGrupo = new JPanel();
        pGrupo.setSize(400,500);
        pGrupo.setLocation((pFondo.getWidth() - pGrupo.getWidth()) / 2,35);
        pGrupo.setBackground(Color.WHITE);
        pGrupo.setLayout(null);
        pGrupo.setBorder(BorderFactory.createTitledBorder("Nuevo usuario: "));
        this.add(pGrupo);
        pFondo.add(pGrupo);
    }

    public void crearLabels() {
        Font tipo = new Font("Arial", Font.BOLD, 14);

        lblEmpleado = new JLabel("Empleado:");
        lblEmpleado.setSize(75,35);
        lblEmpleado.setLocation((pGrupo.getWidth() - lblEmpleado.getWidth())/2,15);
        lblEmpleado.setForeground(Color.BLACK);
        lblEmpleado.setFont(tipo);
        pGrupo.add(lblEmpleado);

        lblNombreUsuario = new JLabel("Nombre usuario:");
        lblNombreUsuario.setSize(117,35);
        lblNombreUsuario.setLocation((pGrupo.getWidth() - lblNombreUsuario.getWidth())/2,115);
        lblNombreUsuario.setForeground(Color.BLACK);
        lblNombreUsuario.setFont(tipo);
        pGrupo.add(lblNombreUsuario);

        lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setSize(100,35);
        lblContraseña.setLocation((pGrupo.getWidth() - lblContraseña.getWidth())/2,215);
        lblContraseña.setForeground(Color.BLACK);
        lblContraseña.setFont(tipo);
        pGrupo.add(lblContraseña);

        lblRol = new JLabel("Rol:");
        lblRol.setSize(30,35);
        lblRol.setLocation((pGrupo.getWidth() - lblRol.getWidth())/2,315);
        lblRol.setForeground(Color.BLACK);
        lblRol.setFont(tipo);
        pGrupo.add(lblRol);
    }

    public void crearTextField() {
        cmbEmpleado = new JComboBox<>();
        cmbEmpleado.setSize(250, 35);
        cmbEmpleado.setLocation((pGrupo.getWidth() - cmbEmpleado.getWidth()) / 2, 55);
        cmbEmpleado.setBackground(Color.WHITE);
        cmbEmpleado.setForeground(Color.BLACK);
        ((JLabel) cmbEmpleado.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cmbEmpleado.addActionListener((ActionListener) crearUsuariosControlador);;
        pGrupo.add(cmbEmpleado);

        txtNombreUsuario = new JTextField();
        txtNombreUsuario.setSize(250, 35);
        txtNombreUsuario.setLocation((pGrupo.getWidth() - txtNombreUsuario.getWidth()) / 2, 155);
        txtNombreUsuario.setBackground(Color.WHITE);
        txtNombreUsuario.setCaretColor(Color.BLACK);
        txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        pGrupo.add(txtNombreUsuario);

        txtContraseña = new JPasswordField();
        txtContraseña.setSize(250, 35);
        txtContraseña.setLocation((pGrupo.getWidth() - txtContraseña.getWidth()) / 2, 255);
        txtContraseña.setBackground(Color.WHITE);
        txtContraseña.setCaretColor(Color.BLACK);
        txtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        pGrupo.add(txtContraseña);

        cmbRol = new JComboBox<>();
        cmbRol.setSize(250, 35);
        cmbRol.setLocation((pGrupo.getWidth() - cmbRol.getWidth()) / 2, 355);
        cmbRol.setBackground(Color.WHITE);
        cmbRol.setForeground(Color.BLACK);
        ((JLabel) cmbRol.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cmbRol.addActionListener((ActionListener) crearUsuariosControlador);;
        pGrupo.add(cmbRol);
    }

    public void crearButtons() {
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setSize(250, 35);
        btnAceptar.setLocation((pGrupo.getWidth() - btnAceptar.getWidth()) / 2, 450);
        btnAceptar.setBackground(Color.WHITE);
        btnAceptar.setForeground(Color.DARK_GRAY);
        btnAceptar.setFocusable(false);
        btnAceptar.addActionListener((ActionListener) crearUsuariosControlador);
        pGrupo.add(btnAceptar);
    }

    public JComboBox<String> getCombo() {
        return cmbEmpleado;
    }

    public JComboBox<String> getCombo2() {
        return cmbRol;
    }

    /* OBTENER COMBOBOX*/
    public String getCmbEmpleados() {
        return cmbEmpleado.getSelectedItem().toString();
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public String getTxtNombreUsuario() {
        return txtNombreUsuario.getText();
    }

    public String getTxtContraseña() {
        return txtContraseña.getText();
    }

    public String getTxtIDEmpleado() {
        return nombreEmpleado;
    }

    public String getTxtIDRol() {
        return nombreRol;
    }
    
    public void setTxtNombreUsuario(String nombreUsuario) {
        txtNombreUsuario.setText(nombreUsuario);
    }

    /* ESTABLECER EMPLEADOS COMBOBOX*/
    public void setCbmEmpleados(DefaultTableModel empleados) {
        int filas = empleados.getRowCount();

        for(int indice = 0; indice < filas; indice++)
            cmbEmpleado.addItem(empleados.getValueAt(indice, 0).toString());
    }

    public void setCmbRol(DefaultTableModel roles) {
        int filas = roles.getRowCount();

        for(int indice = 0; indice < filas; indice++)
            cmbRol.addItem(roles.getValueAt(indice, 0).toString());
    }

    public void setTxtNombreEmpleado(String nombre) {
        nombreEmpleado = nombre;
    }

    public void setTxtRol(String rol) {
        nombreRol = rol;
    }

    public void confirmarRegistro(boolean registro) {
        if(registro == true)
            JOptionPane.showMessageDialog(null, "Se agregó correctamente");
        else
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
    }
}
