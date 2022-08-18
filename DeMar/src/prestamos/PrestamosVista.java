package DeMar.src.prestamos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;


public class PrestamosVista extends JFrame {
    DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");

    protected JPanel pFondo, pContenedor, pSeparador, pContenedorBotones,
                    pFolio, pFechaPrestamo, pFechaPagado, pCantidad,
                    pPlazosTotales, pPlazosPagados, pTipoPlazos, pEmpleado;
    protected JLabel lblFolio, lblFechaPrestamo, lblFechaPago, lblCantidad,
                    lblPlazosTotales, lblPlazosPagados, lblTipoPlazo, lblEmpleado;
    protected JTextField txtFolio, txtFechaPrestamo, txtFechaPago, txtEmpleado,
                    txtCantidad, txtplazosTotales, txtPlazosPagados, txtBuscar;
    protected JButton btnAgregar, btnModificar, btnEliminar, btnLimpiar,
                    btnBuscar;
    protected JTable obtenerTabla;
    protected JComboBox<String> cmbEmpleado, cmbTipoPago;

    protected PrestamosControlador prestamosControlador;

    public PrestamosVista(PrestamosControlador prestamosControlador) {
        super("Prestamos");

        this.prestamosControlador = prestamosControlador;
        this.crearPanels();
        this.crearLabels();
        this.crearTextField();
        this.crearButtons();

        setSize(1115, 700);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true);
    }

    public void diseñarJTable(JTable tabla, JScrollPane scroll) {
        obtenerTabla = tabla;
        obtenerTabla.addMouseListener(prestamosControlador);

        tabla.setBounds(380,125,690,200);
        scroll.setBounds(380,125,690,200);
        scroll.setViewportView(tabla);
        pFondo.add(scroll);
    }

    public void crearPanels() {
        pFondo = new JPanel();
        pFondo.setSize(1100,675);
        pFondo.setLocation(0,0);
        pFondo.setBackground(Color.WHITE);
        pFondo.setLayout(null);
        this.add(pFondo);

        pContenedor = new JPanel();
        pContenedor.setSize(349,675);
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
        pSeparador.setSize(3,675);
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

        pFechaPrestamo = new JPanel();
        pFechaPrestamo.setSize(300,1);
        pFechaPrestamo.setLocation((pContenedor.getWidth() - pFechaPrestamo.getWidth()) / 2,145);
        pFechaPrestamo.setBackground(Color.BLACK);
        pFechaPrestamo.setLayout(null);
        this.add(pFechaPrestamo);
        pContenedor.add(pFechaPrestamo);

        pFechaPagado = new JPanel();
        pFechaPagado.setSize(300,1);
        pFechaPagado.setLocation((pContenedor.getWidth() - pFechaPagado.getWidth()) / 2,215);
        pFechaPagado.setBackground(Color.BLACK);
        pFechaPagado.setLayout(null);
        this.add(pFechaPagado);
        pContenedor.add(pFechaPagado);

        pEmpleado = new JPanel();
        pEmpleado.setSize(300,1);
        pEmpleado.setLocation((pContenedor.getWidth() - pEmpleado.getWidth()) / 2,355);
        pEmpleado.setBackground(Color.BLACK);
        pEmpleado.setLayout(null);
        this.add(pEmpleado);
        pContenedor.add(pEmpleado);

        pCantidad = new JPanel();
        pCantidad.setSize(300,1);
        pCantidad.setLocation((pContenedor.getWidth() - pCantidad.getWidth()) / 2,495);
        pCantidad.setBackground(Color.BLACK);
        pCantidad.setLayout(null);
        this.add(pCantidad);
        pContenedor.add(pCantidad);

        pPlazosTotales = new JPanel();
        pPlazosTotales.setSize(300,1);
        pPlazosTotales.setLocation((pContenedor.getWidth() - pPlazosTotales.getWidth()) / 2,565);
        pPlazosTotales.setBackground(Color.BLACK);
        pPlazosTotales.setLayout(null);
        this.add(pPlazosTotales);
        pContenedor.add(pPlazosTotales);

        pPlazosPagados = new JPanel();
        pPlazosPagados.setSize(300,1);
        pPlazosPagados.setLocation((pContenedor.getWidth() - pPlazosTotales.getWidth()) / 2,635);
        pPlazosPagados.setBackground(Color.BLACK);
        pPlazosPagados.setLayout(null);
        this.add(pPlazosPagados);
        pContenedor.add(pPlazosPagados);
    }

    public void crearLabels() {
        Font tipo = new Font("Arial", Font.BOLD, 14);

        lblFolio = new JLabel("Folio:");
        lblFolio.setSize(150,50);
        lblFolio.setLocation(20,5);
        lblFolio.setForeground(Color.BLACK);
        lblFolio.setFont(tipo);
        pContenedor.add(lblFolio);

        lblFechaPrestamo = new JLabel("Fecha préstamo:");
        lblFechaPrestamo.setSize(200,50);
        lblFechaPrestamo.setLocation(20,75);
        lblFechaPrestamo.setForeground(Color.BLACK);
        lblFechaPrestamo.setFont(tipo);
        pContenedor.add(lblFechaPrestamo);

        lblFechaPago = new JLabel("Fecha pagado:");
        lblFechaPago.setSize(200,50);
        lblFechaPago.setLocation(20,145);
        lblFechaPago.setForeground(Color.BLACK);
        lblFechaPago.setFont(tipo);
        pContenedor.add(lblFechaPago);

        lblEmpleado = new JLabel("Empleado:");
        lblEmpleado.setSize(150,50);
        lblEmpleado.setLocation(20,215);
        lblEmpleado.setForeground(Color.BLACK);
        lblEmpleado.setFont(tipo);
        pContenedor.add(lblEmpleado);

        lblTipoPlazo = new JLabel("Tipo plazo:");
        lblTipoPlazo.setSize(150,50);
        lblTipoPlazo.setLocation(20,355);
        lblTipoPlazo.setForeground(Color.BLACK);
        lblTipoPlazo.setFont(tipo);
        pContenedor.add(lblTipoPlazo);

        lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setSize(100,50);
        lblCantidad.setLocation(20,425);
        lblCantidad.setForeground(Color.BLACK);
        lblCantidad.setFont(tipo);
        pContenedor.add(lblCantidad);

        lblPlazosTotales = new JLabel("Plazos totales:");
        lblPlazosTotales.setSize(150,50);
        lblPlazosTotales.setLocation(20,495);
        lblPlazosTotales.setForeground(Color.BLACK);
        lblPlazosTotales.setFont(tipo);
        pContenedor.add(lblPlazosTotales);

        lblPlazosPagados = new JLabel("Plazos pagados:");
        lblPlazosPagados.setSize(150,50);
        lblPlazosPagados.setLocation(20,565);
        lblPlazosPagados.setForeground(Color.BLACK);
        lblPlazosPagados.setFont(tipo);
        pContenedor.add(lblPlazosPagados);
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

        txtFechaPrestamo = new JTextField();
        txtFechaPrestamo.setSize(300, 35);
        txtFechaPrestamo.setLocation((pContenedor.getWidth() - txtFechaPrestamo.getWidth()) / 2, 110);
        txtFechaPrestamo.setBackground(Color.WHITE);
        txtFechaPrestamo.setCaretColor(Color.BLACK);
        txtFechaPrestamo.setBorder(null);
        txtFechaPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
        txtFechaPrestamo.setEnabled(false);
        txtFechaPrestamo.setText(dft.format(LocalDateTime.now()));
        pContenedor.add(txtFechaPrestamo);

        txtFechaPago = new JTextField();
        txtFechaPago.setSize(300, 35);
        txtFechaPago.setLocation((pContenedor.getWidth() - txtFechaPago.getWidth()) / 2, 180);
        txtFechaPago.setBackground(Color.WHITE);
        txtFechaPago.setCaretColor(Color.BLACK);
        txtFechaPago.setBorder(null);
        txtFechaPago.setHorizontalAlignment(SwingConstants.CENTER);
        txtFechaPago.setText(dft.format(LocalDateTime.now()));
        pContenedor.add(txtFechaPago);

        cmbEmpleado = new JComboBox<>();
        cmbEmpleado.setSize(300, 35);
        cmbEmpleado.setLocation((pContenedor.getWidth() - cmbEmpleado.getWidth()) / 2, 250);
        cmbEmpleado.setBackground(Color.WHITE);
        cmbEmpleado.setForeground(Color.BLACK);
        cmbEmpleado.setBorder(null);
        ((JLabel) cmbEmpleado.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cmbEmpleado.addActionListener((ActionListener) prestamosControlador);
        pContenedor.add(cmbEmpleado);

        txtEmpleado = new JTextField();
        txtEmpleado.setSize(300, 35);
        txtEmpleado.setLocation((pContenedor.getWidth() - txtEmpleado.getWidth()) / 2, 320);
        txtEmpleado.setBackground(Color.WHITE);
        txtEmpleado.setCaretColor(Color.BLACK);
        txtEmpleado.setBorder(null);
        txtEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmpleado.setEnabled(false);
        pContenedor.add(txtEmpleado);

        cmbTipoPago = new JComboBox<>();
        cmbTipoPago.setSize(300, 35);
        cmbTipoPago.setLocation((pContenedor.getWidth() - cmbTipoPago.getWidth()) / 2, 390);
        cmbTipoPago.setBackground(Color.WHITE);
        cmbTipoPago.setForeground(Color.BLACK);
        cmbTipoPago.setBorder(null);
        cmbTipoPago.addItem("Semanales");
        cmbTipoPago.addItem("Quincenales");
        cmbTipoPago.addItem("Mensuales");
        cmbTipoPago.addItem("Libre");
        ((JLabel) cmbTipoPago.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(cmbTipoPago);

        txtCantidad = new JTextField();
        txtCantidad.setSize(300, 35);
        txtCantidad.setLocation((pContenedor.getWidth() - txtCantidad.getWidth()) / 2, 460);
        txtCantidad.setBackground(Color.WHITE);
        txtCantidad.setCaretColor(Color.BLACK);
        txtCantidad.setBorder(null);
        txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtCantidad);

        txtplazosTotales = new JTextField();
        txtplazosTotales.setSize(300, 35);
        txtplazosTotales.setLocation((pContenedor.getWidth() - txtplazosTotales.getWidth()) / 2, 530);
        txtplazosTotales.setBackground(Color.WHITE);
        txtplazosTotales.setCaretColor(Color.BLACK);
        txtplazosTotales.setBorder(null);
        txtplazosTotales.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtplazosTotales);

        txtPlazosPagados = new JTextField();
        txtPlazosPagados.setSize(300, 35);
        txtPlazosPagados.setLocation((pContenedor.getWidth() - txtPlazosPagados.getWidth()) / 2, 600);
        txtPlazosPagados.setBackground(Color.WHITE);
        txtPlazosPagados.setCaretColor(Color.BLACK);
        txtPlazosPagados.setBorder(null);
        txtPlazosPagados.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtPlazosPagados);

        txtBuscar = new JTextField();
        txtBuscar.setSize(300, 35);
        txtBuscar.setLocation(380, 75);
        txtBuscar.setBackground(Color.WHITE);
        txtBuscar.setCaretColor(Color.BLACK);
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        txtBuscar.addKeyListener((KeyListener) prestamosControlador);
        pFondo.add(txtBuscar);
    }

    public void crearButtons() {
        btnAgregar = new JButton("Agregar");
        btnAgregar.setSize(120, 120);
        btnAgregar.setLocation(60, (pContenedorBotones.getHeight() - btnAgregar.getHeight()) / 2);
        btnAgregar.setBackground(Color.WHITE);
        btnAgregar.setForeground(Color.DARK_GRAY);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener((ActionListener) prestamosControlador);
        pContenedorBotones.add(btnAgregar);

        btnModificar = new JButton("Modificar");
        btnModificar.setSize(120, 120);
        btnModificar.setLocation(210, (pContenedorBotones.getHeight() - btnModificar.getHeight()) / 2);
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setForeground(Color.DARK_GRAY);
        btnModificar.setFocusable(false);
        btnModificar.addActionListener((ActionListener) prestamosControlador);
        pContenedorBotones.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setSize(120, 120);
        btnEliminar.setLocation(360, (pContenedorBotones.getHeight() - btnEliminar.getHeight()) / 2);
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setForeground(Color.DARK_GRAY);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener((ActionListener) prestamosControlador);
        pContenedorBotones.add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setSize(120, 120);
        btnLimpiar.setLocation(510, (pContenedorBotones.getHeight() - btnLimpiar.getHeight()) / 2);
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setForeground(Color.DARK_GRAY);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener((ActionListener) prestamosControlador);
        pContenedorBotones.add(btnLimpiar);

        /*btnBuscar = new JButton("Buscar");
        btnBuscar.setSize(100, 35);
        btnBuscar.setLocation(700, 75);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setForeground(Color.DARK_GRAY);
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener((ActionListener) prestamosControlador);
        pFondo.add(btnBuscar);*/
    }

    public void limpiar() {
        txtFolio.setText("");
        txtFechaPrestamo.setText(dft.format(LocalDateTime.now()));
        txtFechaPago.setText(dft.format(LocalDateTime.now()));
        txtEmpleado.setText("");
        txtCantidad.setText("");
        txtplazosTotales.setText("");
        txtPlazosPagados.setText("");
        btnAgregar.setEnabled(true);
    }

    public void colocarID(String c) {
        txtEmpleado.setText(c);
    }

    /* OBTENER TABLA */
    public JTable getTabla() {
        return obtenerTabla;
    }

    /* OBTENER COMBO */
    public JComboBox<String> getCombo() {
        return cmbEmpleado;
    }

    /* OBTENER EVENTO DE LOS BOTONES*/
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

    public JButton getBtnBuscar(){ 
        return  btnBuscar;
    }

    /* OBTENER CAJAS DE TEXTO */
    public String getTxtFolio() {
        return txtFolio.getText();
    }

    public String getTxtFechaPrestamo() {
        return txtFechaPrestamo.getText();
    }

    public String getTxtFechaPago() {
        return txtFechaPago.getText();
    }

    public String getTxtEmpleado() {
        return txtEmpleado.getText();
    }

    public String getTxtTipo() {
        return cmbTipoPago.getSelectedItem().toString();
    }

    public String getTxtCantidad() {
        return txtCantidad.getText();
    }

    public String getTxtPlazosTotales() {
        return txtplazosTotales.getText();
    }

    public String getTxtPlazosPagados() {
        return txtPlazosPagados.getText();
    }

    public String getTxtBuscar() {
        return txtBuscar.getText();
    }

    public JTextField getTxtFiltrar() {
        return txtBuscar;
    }

    public JTextField getComponentTxtEmpleado() {
        return txtEmpleado;
    }

    public JTextField getComponentTxtCantidad() {
        return txtCantidad;
    }

    public JTextField getComponentTxtPlazosTotales(){
        return txtplazosTotales;
    }

    public JTextField getComponentTxtPlazosPagados(){
        return txtPlazosPagados;
    }
    
    /* ESTABLECER TEXTO EN LAS CAJAS DE TEXTO */
    public void setTxtFolio(JTable jtabla, int filas) {
        txtFolio.setText(String.valueOf(jtabla.getValueAt(filas, 0)));
    }

    public void setTxtFechaPrestamo(JTable jtabla, int filas) {
        txtFechaPrestamo.setText(String.valueOf(jtabla.getValueAt(filas, 1)));
    }

    public void setTxtFechaPago(JTable jtabla, int filas) {
        txtFechaPago.setText(String.valueOf(jtabla.getValueAt(filas, 2)));
    }

    public void setTxtEmpleado(JTable jtabla, int filas) {
        txtEmpleado.setText(String.valueOf(jtabla.getValueAt(filas, 7)));
    }

    public void setTxtCantidad(JTable jtabla, int filas) {
        txtCantidad.setText(String.valueOf(jtabla.getValueAt(filas, 3)));
    }

    public void setTxtPlazosTotales(JTable jtabla, int filas) {
        txtplazosTotales.setText(String.valueOf(jtabla.getValueAt(filas, 4)));
    }

    public void setTxtPlazosPagados(JTable jtabla, int filas) {
        txtPlazosPagados.setText(String.valueOf(jtabla.getValueAt(filas, 5)));
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