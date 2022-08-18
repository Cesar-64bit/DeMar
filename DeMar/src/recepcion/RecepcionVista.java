package DeMar.src.recepcion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class RecepcionVista extends JFrame {
    DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");

    protected JPanel pFondo, pContenedor, pSeparador, pContenedorBotones,
                    pFolio, pFecha, pCantida, pEmpleado;
    protected JLabel lblFolio, lblFecha, lblCantidad,
                    lblEmpleado;
    protected JTextField txtFolio, txtFecha, txtCantidad,
                    txtEmpleado, txtBuscar;
    protected JComboBox<String> cmbEmpleados;
    protected JButton btnAgregar, btnModificar, btnEliminar, btnLimpiar,
                    btnBuscar;
    protected JTable obtenerTabla;

    protected RecepcionControlador recepcionControlador;

    public RecepcionVista(RecepcionControlador recepcionControlador) {
        super("Recepcion");

        this.recepcionControlador = recepcionControlador;
        this.crearPanels();
        this.crearLabels();
        this.crearTextField();
        this.crearButtons();

        setSize(1115, 575);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true);
    }

    public void diseñarJTable(JTable tabla, JScrollPane scroll) {
        obtenerTabla = tabla;
        obtenerTabla.addMouseListener(recepcionControlador);

        tabla.setBounds(380,125,690,200);
        scroll.setBounds(380,125,690,200);
        scroll.setViewportView(tabla);
        pFondo.add(scroll);
    }

    public void crearPanels() {
        pFondo = new JPanel();
        pFondo.setSize(1100,550);
        pFondo.setLocation(0,0);
        pFondo.setBackground(Color.WHITE);
        pFondo.setLayout(null);
        this.add(pFondo);

        pContenedor = new JPanel();
        pContenedor.setSize(349,550);
        pContenedor.setLocation(0,0);
        pContenedor.setBackground(Color.WHITE);
        pContenedor.setLayout(null);
        this.add(pContenedor);
        pFondo.add(pContenedor);

        pContenedorBotones = new JPanel();        
        pContenedorBotones.setSize(690,175);
        pContenedorBotones.setLocation(380,350);
        pContenedorBotones.setBackground(Color.GRAY);
        pContenedorBotones.setLayout(null);
        this.add(pContenedorBotones);
        pFondo.add(pContenedorBotones);

        pSeparador = new JPanel();
        pSeparador.setSize(3,550);
        pSeparador.setLocation(350,0);
        pSeparador.setBackground(Color.DARK_GRAY);
        pSeparador.setLayout(null);
        this.add(pSeparador);
        pFondo.add(pSeparador);

        pFolio = new JPanel();
        pFolio.setSize(300,1);
        pFolio.setLocation((pContenedor.getWidth() - pFolio.getWidth()) / 2,75);
        pFolio.setBackground(Color.BLACK);
        pFolio.setLayout(null);
        this.add(pFolio);
        pContenedor.add(pFolio);

        pFecha = new JPanel();
        pFecha.setSize(300,1);
        pFecha.setLocation((pContenedor.getWidth() - pFecha.getWidth()) / 2,145);
        pFecha.setBackground(Color.BLACK);
        pFecha.setLayout(null);
        this.add(pFecha);
        pContenedor.add(pFecha);

        pCantida = new JPanel();
        pCantida.setSize(300,1);
        pCantida.setLocation((pContenedor.getWidth() - pCantida.getWidth()) / 2,215);
        pCantida.setBackground(Color.BLACK);
        pCantida.setLayout(null);
        this.add(pCantida);
        pContenedor.add(pCantida);

        pEmpleado = new JPanel();
        pEmpleado.setSize(300,1);
        pEmpleado.setLocation((pContenedor.getWidth() - pEmpleado.getWidth()) / 2,355);
        pEmpleado.setBackground(Color.BLACK);
        pEmpleado.setLayout(null);
        this.add(pEmpleado);
        pContenedor.add(pEmpleado);
    }

    public void crearLabels() {
        Font tipo = new Font("Arial", Font.BOLD, 14);

        lblFolio = new JLabel("Folio:");
        lblFolio.setSize(150,50);
        lblFolio.setLocation(20,5);
        lblFolio.setForeground(Color.BLACK);
        lblFolio.setFont(tipo);
        pContenedor.add(lblFolio);

        lblFecha = new JLabel("Fecha:");
        lblFecha.setSize(100,50);
        lblFecha.setLocation(20,75);
        lblFecha.setForeground(Color.BLACK);
        lblFecha.setFont(tipo);
        pContenedor.add(lblFecha);

        lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setSize(100,50);
        lblCantidad.setLocation(20,145);
        lblCantidad.setForeground(Color.BLACK);
        lblCantidad.setFont(tipo);
        pContenedor.add(lblCantidad);

        lblEmpleado = new JLabel("Empleado:");
        lblEmpleado.setSize(100,50);
        lblEmpleado.setLocation(20,215);
        lblEmpleado.setForeground(Color.BLACK);
        lblEmpleado.setFont(tipo);
        pContenedor.add(lblEmpleado);
    }

    public void crearTextField() {
        txtFolio = new JTextField();
        txtFolio.setSize(300, 35);
        txtFolio.setLocation((pContenedor.getWidth() - txtFolio.getWidth()) / 2, 40);
        txtFolio.setBackground(Color.WHITE);
        txtFolio.setCaretColor(Color.BLACK);
        txtFolio.setBorder(null);
        txtFolio.setEnabled(false);
        txtFolio.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtFolio);

        txtFecha = new JTextField();
        txtFecha.setSize(300, 35);
        txtFecha.setLocation((pContenedor.getWidth() - txtFecha.getWidth()) / 2, 110);
        txtFecha.setBackground(Color.WHITE);
        txtFecha.setCaretColor(Color.BLACK);
        txtFecha.setBorder(null);
        txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
        txtFecha.setText(dft.format(LocalDateTime.now()));
        pContenedor.add(txtFecha);

        txtCantidad = new JTextField();
        txtCantidad.setSize(300, 35);
        txtCantidad.setLocation((pContenedor.getWidth() - txtCantidad.getWidth()) / 2, 180);
        txtCantidad.setBackground(Color.WHITE);
        txtCantidad.setCaretColor(Color.BLACK);
        txtCantidad.setBorder(null);
        txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtCantidad);

        cmbEmpleados = new JComboBox<>();
        cmbEmpleados.setSize(300, 35);
        cmbEmpleados.setLocation((pContenedor.getWidth() - cmbEmpleados.getWidth()) / 2, 250);
        cmbEmpleados.setBackground(Color.WHITE);
        cmbEmpleados.setBorder(null);
        ((JLabel) cmbEmpleados.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cmbEmpleados.addActionListener((ActionListener) recepcionControlador);
        pContenedor.add(cmbEmpleados);
        
        txtEmpleado = new JTextField();
        txtEmpleado.setSize(300, 35);
        txtEmpleado.setLocation((pContenedor.getWidth() - txtEmpleado.getWidth()) / 2, 320);
        txtEmpleado.setBackground(Color.WHITE);
        txtEmpleado.setForeground(Color.BLACK);
        txtEmpleado.setBorder(null);
        txtEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtEmpleado);

        txtBuscar = new JTextField();
        txtBuscar.setSize(300, 35);
        txtBuscar.setLocation(380, 75);
        txtBuscar.setBackground(Color.WHITE);
        txtBuscar.setCaretColor(Color.BLACK);
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        txtBuscar.addKeyListener((KeyListener) recepcionControlador);
        pFondo.add(txtBuscar);

    }

    public void crearButtons() {
        btnAgregar = new JButton("Agregar");
        btnAgregar.setSize(120, 120);
        btnAgregar.setLocation(60, (pContenedorBotones.getHeight() - btnAgregar.getHeight()) / 2);
        btnAgregar.setBackground(Color.WHITE);
        btnAgregar.setForeground(Color.DARK_GRAY);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener((ActionListener) recepcionControlador);
        pContenedorBotones.add(btnAgregar);

        btnModificar = new JButton("Modificar");
        btnModificar.setSize(120, 120);
        btnModificar.setLocation(210, (pContenedorBotones.getHeight() - btnModificar.getHeight()) / 2);
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setForeground(Color.DARK_GRAY);
        btnModificar.setFocusable(false);
        btnModificar.addActionListener((ActionListener) recepcionControlador);
        pContenedorBotones.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setSize(120, 120);
        btnEliminar.setLocation(360, (pContenedorBotones.getHeight() - btnEliminar.getHeight()) / 2);
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setForeground(Color.DARK_GRAY);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener((ActionListener) recepcionControlador);
        pContenedorBotones.add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setSize(120, 120);
        btnLimpiar.setLocation(510, (pContenedorBotones.getHeight() - btnLimpiar.getHeight()) / 2);
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setForeground(Color.DARK_GRAY);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener((ActionListener) recepcionControlador);
        pContenedorBotones.add(btnLimpiar);

        /*btnBuscar = new JButton("Buscar");
        btnBuscar.setSize(100, 35);
        btnBuscar.setLocation(700, 75);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setForeground(Color.DARK_GRAY);
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener((ActionListener) recepcionControlador);
        pFondo.add(btnBuscar);*/
    }

    public void limpiar() {
        txtFolio.setText("");
        txtFecha.setText(dft.format(LocalDateTime.now()));
        txtCantidad.setText("");
        txtEmpleado.setText("");
        btnAgregar.setEnabled(true);
    }

    public void colocarID(String c) {
        txtEmpleado.setText(c);
    }

    /* OBTENER TABLA*/
    public JTable getTabla() {
        return obtenerTabla;
    }

    /* OBTENER COMBO */
    public JComboBox<String> getCombo() {
        return cmbEmpleados;
    }

    /* OBTENER BOTONES */
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    /* OBTENER CAJAS DE TEXTO */
    public String getTxtFolio() {
        return txtFolio.getText();
    }

    public String getTxtFecha() {
        return txtFecha.getText();
    }

    public String getTxtCantidad() {
        return txtCantidad.getText();
    }

    public String getTxtEmpleado() {
        return txtEmpleado.getText();
    }

    public String getTxtBuscar() {
        return txtBuscar.getText();
    }

    public JTextField getTxtFiltrar() {
        return txtBuscar;
    }

    public JTextField getComponentTxtCantidad() {
        return txtCantidad;
    }

    public JTextField getComponentTxtEmpleado(){
        return txtEmpleado;
    }

    /* ESTABLECER TETXTO EN LAS CAJAS DE TEXTO */
    public void setTxtFolio(JTable jtabla, int filas) {
        txtFolio.setText(String.valueOf(jtabla.getValueAt(filas, 0)));
    }

    public void setTxtFecha(JTable jtabla, int filas) {
        txtFecha.setText(String.valueOf(jtabla.getValueAt(filas, 1)));
    }

    public void setTxtCantidad(JTable jtabla, int filas) {
        txtCantidad.setText(String.valueOf(jtabla.getValueAt(filas, 2)));
    }

    public void setTxtEmpleado(JTable jtabla, int filas) {
        txtEmpleado.setText(String.valueOf(jtabla.getValueAt(filas, 3)));
    }

    /* ESTABLECER EMPLEADOS COMBOBOX*/
    public void setCbmEmpleados(DefaultTableModel empleados) {
        int filas = empleados.getRowCount();

        for(int indice = 0; indice < filas; indice++)
            cmbEmpleados.addItem(empleados.getValueAt(indice, 0).toString());
    }

    /* MENSAJES */
    public int confirmarAccion(String boton) {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea "+boton+"?", "Alerta", JOptionPane.YES_NO_OPTION);
        return respuesta;
    }

    public void confirmarRegistro(boolean registro) {
        if(registro == true)
            JOptionPane.showMessageDialog(null, "Se agregó correctamente");
        else
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
    }
}
