package DeMar.src.Insumos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class InsumosVista extends JFrame {
    protected JPanel pFondo, pContenedor, pSeparador, pContenedorBotones,
                    pFolio, pNombre, pProveedor, pPrecio;
    protected JLabel lblFolio, lblNombre, lblProveedor,
                    lblPrecio;
    protected JTextField txtFolio, txtNombre, txtProveedor, txtPrecio,
                        txtBuscar;
    protected JComboBox<String> cmbProveedor;
    protected JButton btnAgregar, btnModificar, btnEliminar, btnLimpiar,
                    btnBuscar;
    protected JTable obtenerTabla;

    protected InsumosControlador insumosControlador;

    public InsumosVista(InsumosControlador insumosControlador) {
        super("Insumos");

        this.insumosControlador = insumosControlador;
        this.crearPanels();
        this.crearLabels();
        this.crearTextFields();
        this.crearButtons();

        setSize(1115, 575);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true);
    }

    public void diseñarJTable(JTable tabla, JScrollPane scroll) {
        obtenerTabla = tabla;
        obtenerTabla.addMouseListener(insumosControlador);

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

        pFolio = new JPanel();
        pFolio.setSize(300,1);
        pFolio.setLocation((pContenedor.getWidth() - pFolio.getWidth()) / 2,75);
        pFolio.setBackground(Color.BLACK);
        pFolio.setLayout(null);
        this.add(pFolio);
        pContenedor.add(pFolio);

        pNombre = new JPanel();
        pNombre.setSize(300,1);
        pNombre.setLocation((pContenedor.getWidth() - pNombre.getWidth()) / 2,145);
        pNombre.setBackground(Color.BLACK);
        pNombre.setLayout(null);
        this.add(pNombre);
        pContenedor.add(pNombre);

        pProveedor = new JPanel();
        pProveedor.setSize(300,1);
        pProveedor.setLocation((pContenedor.getWidth() - pProveedor.getWidth()) / 2,285);
        pProveedor.setBackground(Color.BLACK);
        pProveedor.setLayout(null);
        this.add(pProveedor);
        pContenedor.add(pProveedor);

        pPrecio = new JPanel();
        pPrecio.setSize(300,1);
        pPrecio.setLocation((pContenedor.getWidth() - pPrecio.getWidth()) / 2,355);
        pPrecio.setBackground(Color.BLACK);
        pPrecio.setLayout(null);
        this.add(pPrecio);
        pContenedor.add(pPrecio);
    }

    public void crearLabels() {
        Font tipo = new Font("Arial", Font.BOLD, 14);

        lblFolio = new JLabel("Folio:");
        lblFolio.setSize(150,50);
        lblFolio.setLocation(20,5);
        lblFolio.setForeground(Color.BLACK);
        lblFolio.setFont(tipo);
        pContenedor.add(lblFolio);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setSize(100,50);
        lblNombre.setLocation(20,75);
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setFont(tipo);
        pContenedor.add(lblNombre);

        lblProveedor = new JLabel("Proveedor:");
        lblProveedor.setSize(100,50);
        lblProveedor.setLocation(20,145);
        lblProveedor.setForeground(Color.BLACK);
        lblProveedor.setFont(tipo);
        pContenedor.add(lblProveedor);

        lblPrecio = new JLabel("Precio:");
        lblPrecio.setSize(100,50);
        lblPrecio.setLocation(20,285);
        lblPrecio.setForeground(Color.BLACK);
        lblPrecio.setFont(tipo);
        pContenedor.add(lblPrecio);
    }

    public void crearTextFields() {
        txtFolio = new JTextField();
        txtFolio.setSize(300, 35);
        txtFolio.setLocation((pContenedor.getWidth() - txtFolio.getWidth()) / 2, 40);
        txtFolio.setBackground(Color.WHITE);
        txtFolio.setCaretColor(Color.BLACK);
        txtFolio.setBorder(null);
        txtFolio.setEnabled(false);
        txtFolio.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtFolio);

        txtNombre = new JTextField();
        txtNombre.setSize(300, 35);
        txtNombre.setLocation((pContenedor.getWidth() - txtNombre.getWidth()) / 2, 110);
        txtNombre.setBackground(Color.WHITE);
        txtNombre.setCaretColor(Color.BLACK);
        txtNombre.setBorder(null);
        txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtNombre);

        cmbProveedor = new JComboBox<>();
        cmbProveedor.setSize(300, 35);
        cmbProveedor.setLocation((pContenedor.getWidth() - cmbProveedor.getWidth()) / 2, 180);
        cmbProveedor.setBackground(Color.WHITE);
        cmbProveedor.setBorder(null);
        ((JLabel) cmbProveedor.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cmbProveedor.addActionListener((ActionListener) insumosControlador);
        pContenedor.add(cmbProveedor);

        txtProveedor = new JTextField();
        txtProveedor.setSize(300, 35);
        txtProveedor.setLocation((pContenedor.getWidth() - txtProveedor.getWidth()) / 2, 250);
        txtProveedor.setBackground(Color.WHITE);
        txtProveedor.setCaretColor(Color.BLACK);
        txtProveedor.setBorder(null);
        txtProveedor.setHorizontalAlignment(SwingConstants.CENTER);
        txtProveedor.setEnabled(false);
        pContenedor.add(txtProveedor);

        txtPrecio = new JTextField();
        txtPrecio.setSize(300, 35);
        txtPrecio.setLocation((pContenedor.getWidth() - txtPrecio.getWidth()) / 2, 320);
        txtPrecio.setBackground(Color.WHITE);
        txtPrecio.setCaretColor(Color.BLACK);
        txtPrecio.setBorder(null);
        txtPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtPrecio);

        txtBuscar = new JTextField();
        txtBuscar.setSize(300, 35);
        txtBuscar.setLocation(380, 75);
        txtBuscar.setBackground(Color.WHITE);
        txtBuscar.setCaretColor(Color.BLACK);
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        txtBuscar.addKeyListener((KeyListener) insumosControlador);
        pFondo.add(txtBuscar);
    }

    public void crearButtons() {
        btnAgregar = new JButton("Agregar");
        btnAgregar.setSize(120, 120);
        btnAgregar.setLocation(60, (pContenedorBotones.getHeight() - btnAgregar.getHeight()) / 2);
        btnAgregar.setBackground(Color.WHITE);
        btnAgregar.setForeground(Color.DARK_GRAY);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener((ActionListener) insumosControlador);
        pContenedorBotones.add(btnAgregar);

        btnModificar = new JButton("Modificar");
        btnModificar.setSize(120, 120);
        btnModificar.setLocation(210, (pContenedorBotones.getHeight() - btnModificar.getHeight()) / 2);
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setForeground(Color.DARK_GRAY);
        btnModificar.setFocusable(false);
        btnModificar.addActionListener((ActionListener) insumosControlador);
        pContenedorBotones.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setSize(120, 120);
        btnEliminar.setLocation(360, (pContenedorBotones.getHeight() - btnEliminar.getHeight()) / 2);
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setForeground(Color.DARK_GRAY);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener((ActionListener) insumosControlador);
        pContenedorBotones.add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setSize(120, 120);
        btnLimpiar.setLocation(510, (pContenedorBotones.getHeight() - btnLimpiar.getHeight()) / 2);
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setForeground(Color.DARK_GRAY);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener((ActionListener) insumosControlador);
        pContenedorBotones.add(btnLimpiar);

        /*btnBuscar = new JButton("Buscar");
        btnBuscar.setSize(100, 35);
        btnBuscar.setLocation(700, 75);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setForeground(Color.DARK_GRAY);
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener((ActionListener) insumosControlador);
        pFondo.add(btnBuscar);*/
    }

    public void limpiar() {
        txtFolio.setText("");
        txtNombre.setText("");
        txtProveedor.setText("");
        txtPrecio.setText("");
        btnAgregar.setEnabled(true);
    }

    public void colocarID(String c) {
        txtProveedor.setText(c);
    }

     /* OBTENER TTABLA */
     public JTable getTabla() {
        return obtenerTabla;
    }

     /* OBTENER COMBO */
     public JComboBox<String> getCombo() {
        return cmbProveedor;
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
    public String getTxtFolio() {
        return txtFolio.getText();
    }

    public String getTxtNombre() {
        return txtNombre.getText();
    }

    public String getTxtProveedor() {
        return txtProveedor.getText();
    }

    public String getTxtPrecio() {
        return txtPrecio.getText();
    }

    public String getTxtBuscar() {
        return txtBuscar.getText();
    }

    public JTextField getTxtFiltrar() {
        return txtBuscar;
    }

    public JTextField getComponentTxtNombre() {
        return txtNombre;
    }

    public JTextField getComponentTxtProveedor() {
        return txtProveedor;
    }

    public JTextField getComponentTxtPrecio() {
        return txtPrecio;
    }

     /* ESTABLECER TEXTO EN LAS CAJAS DE TEXTO */
     public void setTxtFolio(JTable jtabla, int filas) {
        txtFolio.setText(String.valueOf(jtabla.getValueAt(filas, 0)));
    }

    public void setTxtNombre(JTable jtabla, int filas) {
        txtNombre.setText(String.valueOf(jtabla.getValueAt(filas, 1)));
    }

    public void setTxtProveedor(JTable jtabla, int filas) {
        txtProveedor.setText(String.valueOf(jtabla.getValueAt(filas, 2)));
    }

    public void setTxtPrecio(JTable jtabla, int filas) {
        txtPrecio.setText(String.valueOf(jtabla.getValueAt(filas, 3)));
    }

     /* ESTABLECER EMPLEADOS COMBOBOX*/
     public void setCbmProveedor(DefaultTableModel empleados) {
        int filas = empleados.getRowCount();

        for(int indice = 0; indice < filas; indice++)
            cmbProveedor.addItem(empleados.getValueAt(indice, 0).toString());
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
