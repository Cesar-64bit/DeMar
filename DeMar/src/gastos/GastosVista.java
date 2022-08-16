package DeMar.src.gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GastosVista extends JFrame {
    protected JPanel pFondo, pContenedor, pSeparador, pContenedorBotones,
                    pIDGasto, pTipoGasto, pCantidad,
                    pFecha, pEmpleado;
    protected JLabel lblIDGasto, lblTipoGasto, lblCantidad,
                    lblFecha, lblEmpleado;
    protected JTextField txtGasto, txtTipo, txtCantidad,
                        txtFecha, txtEmpleado, txtBuscar;
    protected JComboBox<String> cmbEmpleado;
    protected JButton btnAgregar, btnModificar, btnEliminar, btnLimpiar,
                    btnBuscar;
    protected JTable obtenerTabla;

    protected GastosControlador gastosControlador;

    public GastosVista(GastosControlador gastosControlador) {
        super("Gastos");

        this.gastosControlador = gastosControlador;
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
        obtenerTabla.addMouseListener(gastosControlador);

        tabla.setBounds(380,125,690,200);
        scroll.setBounds(380,125,690,200);
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

        pIDGasto = new JPanel();
        pIDGasto.setSize(300,1);
        pIDGasto.setLocation((pContenedor.getWidth() - pIDGasto.getWidth()) / 2,75);
        pIDGasto.setBackground(Color.BLACK);
        pIDGasto.setLayout(null);
        this.add(pIDGasto);
        pContenedor.add(pIDGasto);

        pTipoGasto = new JPanel();
        pTipoGasto.setSize(300,1);
        pTipoGasto.setLocation((pContenedor.getWidth() - pTipoGasto.getWidth()) / 2,145);
        pTipoGasto.setBackground(Color.BLACK);
        pTipoGasto.setLayout(null);
        this.add(pTipoGasto);
        pContenedor.add(pTipoGasto);

        pCantidad = new JPanel();
        pCantidad.setSize(300,1);
        pCantidad.setLocation((pContenedor.getWidth() - pCantidad.getWidth()) / 2,215);
        pCantidad.setBackground(Color.BLACK);
        pCantidad.setLayout(null);
        this.add(pCantidad);
        pContenedor.add(pCantidad);

        pFecha = new JPanel();
        pFecha.setSize(300,1);
        pFecha.setLocation((pContenedor.getWidth() - pFecha.getWidth()) / 2,285);
        pFecha.setBackground(Color.BLACK);
        pFecha.setLayout(null);
        this.add(pFecha);
        pContenedor.add(pFecha);

        pEmpleado = new JPanel();
        pEmpleado.setSize(300,1);
        pEmpleado.setLocation((pContenedor.getWidth() - pEmpleado.getWidth()) / 2,425);
        pEmpleado.setBackground(Color.BLACK);
        pEmpleado.setLayout(null);
        this.add(pEmpleado);
        pContenedor.add(pEmpleado);

    }

    public void crearLabels() {
        Font tipo = new Font("Arial", Font.BOLD, 14);

        lblIDGasto = new JLabel("Número gasto:");
        lblIDGasto.setSize(150,50);
        lblIDGasto.setLocation(20,5);
        lblIDGasto.setForeground(Color.BLACK);
        lblIDGasto.setFont(tipo);
        pContenedor.add(lblIDGasto);

        lblTipoGasto = new JLabel("Tipo gasto:");
        lblTipoGasto.setSize(100,50);
        lblTipoGasto.setLocation(20,75);
        lblTipoGasto.setForeground(Color.BLACK);
        lblTipoGasto.setFont(tipo);
        pContenedor.add(lblTipoGasto);

        lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setSize(100,50);
        lblCantidad.setLocation(20,145);
        lblCantidad.setForeground(Color.BLACK);
        lblCantidad.setFont(tipo);
        pContenedor.add(lblCantidad);

        lblFecha = new JLabel("Fecha:");
        lblFecha.setSize(100,50);
        lblFecha.setLocation(20,215);
        lblFecha.setForeground(Color.BLACK);
        lblFecha.setFont(tipo);
        pContenedor.add(lblFecha);

        lblEmpleado = new JLabel("Empleado:");
        lblEmpleado.setSize(150,50);
        lblEmpleado.setLocation(20,285);
        lblEmpleado.setForeground(Color.BLACK);
        lblEmpleado.setFont(tipo);
        pContenedor.add(lblEmpleado);
    }

    public void crearTextField() {
        txtGasto = new JTextField();
        txtGasto.setSize(300, 35);
        txtGasto.setLocation((pContenedor.getWidth() - txtGasto.getWidth()) / 2, 40);
        txtGasto.setBackground(Color.WHITE);
        txtGasto.setCaretColor(Color.BLACK);
        txtGasto.setBorder(null);
        txtGasto.setEnabled(false);
        txtGasto.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtGasto);

        txtTipo = new JTextField();
        txtTipo.setSize(300, 35);
        txtTipo.setLocation((pContenedor.getWidth() - txtTipo.getWidth()) / 2, 110);
        txtTipo.setBackground(Color.WHITE);
        txtTipo.setCaretColor(Color.BLACK);
        txtTipo.setBorder(null);
        txtTipo.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtTipo);

        txtCantidad = new JTextField();
        txtCantidad.setSize(300, 35);
        txtCantidad.setLocation((pContenedor.getWidth() - txtCantidad.getWidth()) / 2, 180);
        txtCantidad.setBackground(Color.WHITE);
        txtCantidad.setCaretColor(Color.BLACK);
        txtCantidad.setBorder(null);
        txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtCantidad);

        txtFecha = new JTextField();
        txtFecha.setSize(300, 35);
        txtFecha.setLocation((pContenedor.getWidth() - txtFecha.getWidth()) / 2, 250);
        txtFecha.setBackground(Color.WHITE);
        txtFecha.setCaretColor(Color.BLACK);
        txtFecha.setBorder(null);
        txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtFecha);
        
        cmbEmpleado = new JComboBox<>();
        cmbEmpleado.setSize(300, 35);
        cmbEmpleado.setLocation((pContenedor.getWidth() - cmbEmpleado.getWidth()) / 2, 320);
        cmbEmpleado.setBackground(Color.WHITE);
        cmbEmpleado.setForeground(Color.BLACK);
        cmbEmpleado.setBorder(null);
        ((JLabel) cmbEmpleado.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cmbEmpleado.addActionListener((ActionListener) gastosControlador);
        pContenedor.add(cmbEmpleado);

        txtEmpleado = new JTextField();
        txtEmpleado.setSize(300, 35);
        txtEmpleado.setLocation((pContenedor.getWidth() - txtEmpleado.getWidth()) / 2, 390);
        txtEmpleado.setBackground(Color.WHITE);
        txtEmpleado.setCaretColor(Color.BLACK);
        txtEmpleado.setBorder(null);
        txtEmpleado.setEnabled(false);
        txtEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtEmpleado);

        txtBuscar = new JTextField();
        txtBuscar.setSize(300, 35);
        txtBuscar.setLocation(380, 75);
        txtBuscar.setBackground(Color.WHITE);
        txtBuscar.setCaretColor(Color.BLACK);
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        txtBuscar.addKeyListener((KeyListener) gastosControlador);
        pFondo.add(txtBuscar);
    }

    public void crearButtons() {
        btnAgregar = new JButton("Agregar");
        btnAgregar.setSize(120, 120);
        btnAgregar.setLocation(60, (pContenedorBotones.getHeight() - btnAgregar.getHeight()) / 2);
        btnAgregar.setBackground(Color.WHITE);
        btnAgregar.setForeground(Color.DARK_GRAY);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener((ActionListener) gastosControlador);
        pContenedorBotones.add(btnAgregar);

        btnModificar = new JButton("Modificar");
        btnModificar.setSize(120, 120);
        btnModificar.setLocation(210, (pContenedorBotones.getHeight() - btnModificar.getHeight()) / 2);
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setForeground(Color.DARK_GRAY);
        btnModificar.setFocusable(false);
        btnModificar.addActionListener((ActionListener) gastosControlador);
        pContenedorBotones.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setSize(120, 120);
        btnEliminar.setLocation(360, (pContenedorBotones.getHeight() - btnEliminar.getHeight()) / 2);
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setForeground(Color.DARK_GRAY);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener((ActionListener) gastosControlador);
        pContenedorBotones.add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setSize(120, 120);
        btnLimpiar.setLocation(510, (pContenedorBotones.getHeight() - btnLimpiar.getHeight()) / 2);
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setForeground(Color.DARK_GRAY);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener((ActionListener) gastosControlador);
        pContenedorBotones.add(btnLimpiar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setSize(100, 35);
        btnBuscar.setLocation(700, 75);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setForeground(Color.DARK_GRAY);
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener((ActionListener) gastosControlador);
        pFondo.add(btnBuscar);
    }

    public void limpiar() {
        txtGasto.setText("");
        txtTipo.setText("");
        txtCantidad.setText("");
        txtFecha.setText("");
        txtEmpleado.setText("");
    }

    public void colocarID(String c) {
        txtEmpleado.setText(c);
    }

    /* OBTENER TTABLA */
    public JTable getTabla() {
        return obtenerTabla;
    }

     /* OBTENER COMBO */
     public JComboBox<String> getCombo() {
        return cmbEmpleado;
    }

    /* OBTENER EVENTO DE LOS BOTONES */
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

    /* OBTENER TEXTO DE LAS CAJAS DE TEXTO */
    public String getTxtGasto() {
        return txtGasto.getText();
    }

    public String getTxtTipo() {
        return txtTipo.getText();
    }

    public String getTxtCantidad() {
        return txtCantidad.getText();
    }

    public String getTxtFecha() {
        return txtFecha.getText();
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

     /* ESTABLECER TEXTO EN LAS CAJAS DE TEXTO */
    public void setTxtGasto(JTable jtabla, int filas) {
        txtGasto.setText(String.valueOf(jtabla.getValueAt(filas, 0)));
    }

    public void setTxtTipo(JTable jtabla, int filas) {
        txtTipo.setText(String.valueOf(jtabla.getValueAt(filas, 1)));
    }

    public void setTxtCantidad(JTable jtabla, int filas) {
        txtCantidad.setText(String.valueOf(jtabla.getValueAt(filas, 2)));
    }

    public void setTxtFecha(JTable jtabla, int filas) {
        txtFecha.setText(String.valueOf(jtabla.getValueAt(filas, 3)));
    }

    public void setTxtEmpleado(JTable jtabla, int filas) {
        txtEmpleado.setText(String.valueOf(jtabla.getValueAt(filas, 4)));
    }

     /* ESTABLECER EMPLEADOS COMBOBOX*/
     public void setCbmEmpleados(DefaultTableModel empleados) {
        int filas = empleados.getRowCount();

        for(int indice = 0; indice < filas; indice++)
            cmbEmpleado.addItem(empleados.getValueAt(indice, 0).toString());
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
