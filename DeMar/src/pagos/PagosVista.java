package DeMar.src.pagos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PagosVista extends JFrame {
    protected JPanel pFondo, pContenedor, pSeparador,
                    pFolio, pTotal, pTipoPago, pFecha,
                    pEmpleado, pDetallePedido, pContenedorBotones;
    protected JLabel lblFolio, lblTotal, lblTipoPago,
                    lblFecha, lblEmpleado, lblDetallesPedidos;
    protected JTextField txtFolio, txtTotal, txtTipoPago, txtFecha,
                        txtEmpleado, txtDetallesPedido, txtBuscar;
    protected JComboBox<String> cmbTipoPago;
    protected JButton btnAgregar, btnModificar, btnEliminar, btnLimpiar,
                    btnBuscar;
    protected JTable obtenerTabla;

    protected PagosControlador pagosControlador;

    public PagosVista(PagosControlador pagosControlador) {
        super("Pagos");

        this.pagosControlador = pagosControlador;
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
        obtenerTabla.addMouseListener(pagosControlador);

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

        pSeparador = new JPanel();
        pSeparador.setSize(3,550);
        pSeparador.setLocation(350,0);
        pSeparador.setBackground(Color.DARK_GRAY);
        pSeparador.setLayout(null);
        this.add(pSeparador);
        pFondo.add(pSeparador);

        pContenedorBotones = new JPanel();        
        pContenedorBotones.setSize(690,175);
        pContenedorBotones.setLocation(380,350);
        pContenedorBotones.setBackground(Color.GRAY);
        pContenedorBotones.setLayout(null);
        this.add(pContenedorBotones);
        pFondo.add(pContenedorBotones);

        pFolio = new JPanel();
        pFolio.setSize(300,1);
        pFolio.setLocation((pContenedor.getWidth() - pFolio.getWidth()) / 2,75);
        pFolio.setBackground(Color.BLACK);
        pFolio.setLayout(null);
        this.add(pFolio);
        pContenedor.add(pFolio);

        pTotal = new JPanel();
        pTotal.setSize(300,1);
        pTotal.setLocation((pContenedor.getWidth() - pTotal.getWidth()) / 2,145);
        pTotal.setBackground(Color.BLACK);
        pTotal.setLayout(null);
        this.add(pTotal);
        pContenedor.add(pTotal);

        pTipoPago = new JPanel();
        pTipoPago.setSize(300,1);
        pTipoPago.setLocation((pContenedor.getWidth() - pTipoPago.getWidth()) / 2,285);
        pTipoPago.setBackground(Color.BLACK);
        pTipoPago.setLayout(null);
        this.add(pTipoPago);
        pContenedor.add(pTipoPago);

        pFecha = new JPanel();
        pFecha.setSize(300,1);
        pFecha.setLocation((pContenedor.getWidth() - pFecha.getWidth()) / 2,355);
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

        pDetallePedido = new JPanel();
        pDetallePedido.setSize(300,1);
        pDetallePedido.setLocation((pContenedor.getWidth() - pDetallePedido.getWidth()) / 2,495);
        pDetallePedido.setBackground(Color.BLACK);
        pDetallePedido.setLayout(null);
        this.add(pDetallePedido);
        pContenedor.add(pDetallePedido);
    }

    public void crearLabels() {
        Font tipo = new Font("Arial", Font.BOLD, 14);

        lblFolio = new JLabel("Folio:");
        lblFolio.setSize(150,50);
        lblFolio.setLocation(20,5);
        lblFolio.setForeground(Color.BLACK);
        lblFolio.setFont(tipo);
        pContenedor.add(lblFolio);

        lblTotal = new JLabel("Total:");
        lblTotal.setSize(100,50);
        lblTotal.setLocation(20,75);
        lblTotal.setForeground(Color.BLACK);
        lblTotal.setFont(tipo);
        pContenedor.add(lblTotal);

        lblTipoPago = new JLabel("Tipo pago:");
        lblTipoPago.setSize(100,50);
        lblTipoPago.setLocation(20,145);
        lblTipoPago.setForeground(Color.BLACK);
        lblTipoPago.setFont(tipo);
        pContenedor.add(lblTipoPago);

        lblFecha = new JLabel("Fecha:");
        lblFecha.setSize(100,50);
        lblFecha.setLocation(20,285);
        lblFecha.setForeground(Color.BLACK);
        lblFecha.setFont(tipo);
        pContenedor.add(lblFecha);

        lblEmpleado = new JLabel("Empleado:");
        lblEmpleado.setSize(150,50);
        lblEmpleado.setLocation(20,355);
        lblEmpleado.setForeground(Color.BLACK);
        lblEmpleado.setFont(tipo);
        pContenedor.add(lblEmpleado);

        lblDetallesPedidos = new JLabel("Detalles pedidos:");
        lblDetallesPedidos.setSize(150,50);
        lblDetallesPedidos.setLocation(20,425);
        lblDetallesPedidos.setForeground(Color.BLACK);
        lblDetallesPedidos.setFont(tipo);
        pContenedor.add(lblDetallesPedidos);
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

        txtTotal = new JTextField();
        txtTotal.setSize(300, 35);
        txtTotal.setLocation((pContenedor.getWidth() - txtTotal.getWidth()) / 2, 110);
        txtTotal.setBackground(Color.WHITE);
        txtTotal.setCaretColor(Color.BLACK);
        txtTotal.setBorder(null);
        txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtTotal);

        cmbTipoPago = new JComboBox<>();
        cmbTipoPago.addItem("Crédito");
        cmbTipoPago.addItem("Efectivo");
        cmbTipoPago.setSize(300, 35);
        cmbTipoPago.setLocation((pContenedor.getWidth() - cmbTipoPago.getWidth()) / 2, 180);
        cmbTipoPago.setBackground(Color.WHITE);
        cmbTipoPago.setForeground(Color.BLACK);
        cmbTipoPago.setBorder(null);
        ((JLabel) cmbTipoPago.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cmbTipoPago.addActionListener((ActionListener) pagosControlador);
        pContenedor.add(cmbTipoPago);

        txtTipoPago = new JTextField();
        txtTipoPago.setSize(300, 35);
        txtTipoPago.setLocation((pContenedor.getWidth() - txtTipoPago.getWidth()) / 2, 250);
        txtTipoPago.setBackground(Color.WHITE);
        txtTipoPago.setCaretColor(Color.BLACK);
        txtTipoPago.setBorder(null);
        txtTipoPago.setEnabled(false);
        txtTipoPago.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtTipoPago);

        txtFecha = new JTextField();
        txtFecha.setSize(300, 35);
        txtFecha.setLocation((pContenedor.getWidth() - txtFecha.getWidth()) / 2, 320);
        txtFecha.setBackground(Color.WHITE);
        txtFecha.setCaretColor(Color.BLACK);
        txtFecha.setBorder(null);
        txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtFecha);

        txtEmpleado = new JTextField();
        txtEmpleado.setSize(300, 35);
        txtEmpleado.setLocation((pContenedor.getWidth() - txtEmpleado.getWidth()) / 2, 390);
        txtEmpleado.setBackground(Color.WHITE);
        txtEmpleado.setCaretColor(Color.BLACK);
        txtEmpleado.setBorder(null);
        txtEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtEmpleado);

        txtDetallesPedido = new JTextField();
        txtDetallesPedido.setSize(300, 35);
        txtDetallesPedido.setLocation((pContenedor.getWidth() - txtDetallesPedido.getWidth()) / 2, 460);
        txtDetallesPedido.setBackground(Color.WHITE);
        txtDetallesPedido.setCaretColor(Color.BLACK);
        txtDetallesPedido.setBorder(null);
        txtDetallesPedido.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtDetallesPedido);

        txtBuscar = new JTextField();
        txtBuscar.setSize(300, 35);
        txtBuscar.setLocation(380, 75);
        txtBuscar.setBackground(Color.WHITE);
        txtBuscar.setCaretColor(Color.BLACK);
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        pFondo.add(txtBuscar);
    }

    public void crearButtons() {
        btnAgregar = new JButton("Agregar");
        btnAgregar.setSize(120, 120);
        btnAgregar.setLocation(60, (pContenedorBotones.getHeight() - btnAgregar.getHeight()) / 2);
        btnAgregar.setBackground(Color.WHITE);
        btnAgregar.setForeground(Color.DARK_GRAY);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener((ActionListener) pagosControlador);
        pContenedorBotones.add(btnAgregar);

        btnModificar = new JButton("Modificar");
        btnModificar.setSize(120, 120);
        btnModificar.setLocation(210, (pContenedorBotones.getHeight() - btnModificar.getHeight()) / 2);
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setForeground(Color.DARK_GRAY);
        btnModificar.setFocusable(false);
        btnModificar.addActionListener((ActionListener) pagosControlador);
        pContenedorBotones.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setSize(120, 120);
        btnEliminar.setLocation(360, (pContenedorBotones.getHeight() - btnEliminar.getHeight()) / 2);
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setForeground(Color.DARK_GRAY);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener((ActionListener) pagosControlador);
        pContenedorBotones.add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setSize(120, 120);
        btnLimpiar.setLocation(510, (pContenedorBotones.getHeight() - btnLimpiar.getHeight()) / 2);
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setForeground(Color.DARK_GRAY);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener((ActionListener) pagosControlador);
        pContenedorBotones.add(btnLimpiar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setSize(100, 35);
        btnBuscar.setLocation(700, 75);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setForeground(Color.DARK_GRAY);
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener((ActionListener) pagosControlador);
        pFondo.add(btnBuscar);
    }

    public void limpiar() {
        txtFolio.setText("");
        txtTotal.setText("");
        txtTipoPago.setText("");
        txtFecha.setText("");
        txtEmpleado.setText("");
        txtDetallesPedido.setText("");
    }

    public void establecerTipoPago(String c) {
        txtTipoPago.setText(c);
    }

    /* OBTENER TABLA */
    public JTable getTabla() {
        return obtenerTabla;
    }

    /* OBTENER COMBOBOX*/
    public JComboBox<String> getCombo() {
        return cmbTipoPago;
    }

    /* OBTENER EVENTOS DE LOS BOTONES */
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

    public String getTxtTotal() {
        return txtTotal.getText();
    }

    public String getTxtTipoPago() {
        return txtTipoPago.getText();
    }

    public String getTxtFecha() {
        return txtFecha.getText();
    }

    public String getTxtTEmpleado() {
        return txtEmpleado.getText();
    }

    public String getTxtDetallePedido() {
        return txtDetallesPedido.getText();
    }

    public int getTxtBuscar() {
        return Integer.parseInt(txtBuscar.getText());
    }

    /* ESTABLECER TEXTO EN LAS CAJAS DE TEXTO */
    public void setTxtFolio(JTable jtabla, int filas) {
        txtFolio.setText(String.valueOf(jtabla.getValueAt(filas, 0)));
    }

    public void setTxtTotal(JTable jtabla, int filas) {
        txtTotal.setText(String.valueOf(jtabla.getValueAt(filas, 1)));
    }

    public void setTxtTipoPago(JTable jtabla, int filas) {
        txtTipoPago.setText(String.valueOf(jtabla.getValueAt(filas, 2)));
    }

    public void setTxtFecha(JTable jtabla, int filas) {
        txtFecha.setText(String.valueOf(jtabla.getValueAt(filas, 3)));
    }

    public void setTxtEmpleado(JTable jtabla, int filas) {
        txtEmpleado.setText(String.valueOf(jtabla.getValueAt(filas, 4)));
    }

    public void setTxtDetallePedido(JTable jtabla, int filas) {
        txtDetallesPedido.setText(String.valueOf(jtabla.getValueAt(filas, 5)));
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
