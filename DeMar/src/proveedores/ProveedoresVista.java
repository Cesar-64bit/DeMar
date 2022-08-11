package DeMar.src.proveedores;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

public class ProveedoresVista extends JFrame{
    protected JPanel pFondo, pContenedor, pSeparador,
                    pNumeroProveedor, pNombre, pInsumo,
                    pTelefono, pContenedorBotones;
    protected JLabel lblNumeroProveedor, lblNombre,
                    lblInsumo, lblTelefono;
    protected JTextField txtNumeroProveedor, txtNombre,
                    txtInsumo, txtTelefono;
    protected JButton btnAgregar, btnModificar, btnEliminar,
                    btnLimpiar;
    protected JTable obtenerTabla;

    protected ProveedoresControlador pControlador;

    public ProveedoresVista(ProveedoresControlador pControlador) {
        super("Proveedores");

        this.pControlador = pControlador;
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
        obtenerTabla.addMouseListener(pControlador);

        tabla.setBounds(380,125,690,175);
        scroll.setBounds(380,125,690,175);
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

        pNumeroProveedor = new JPanel();
        pNumeroProveedor.setSize(300,1);
        pNumeroProveedor.setLocation((pContenedor.getWidth() - pNumeroProveedor.getWidth()) / 2,75);
        pNumeroProveedor.setBackground(Color.BLACK);
        pNumeroProveedor.setLayout(null);
        this.add(pNumeroProveedor);
        pContenedor.add(pNumeroProveedor);

        pNombre = new JPanel();
        pNombre.setSize(300,1);
        pNombre.setLocation((pContenedor.getWidth() - pNombre.getWidth()) / 2,145);
        pNombre.setBackground(Color.BLACK);
        pNombre.setLayout(null);
        this.add(pNombre);
        pContenedor.add(pNombre);

        pInsumo = new JPanel();
        pInsumo.setSize(300,1);
        pInsumo.setLocation((pContenedor.getWidth() - pInsumo.getWidth()) / 2,215);
        pInsumo.setBackground(Color.BLACK);
        pInsumo.setLayout(null);
        this.add(pInsumo);
        pContenedor.add(pInsumo);

        pTelefono = new JPanel();
        pTelefono.setSize(300,1);
        pTelefono.setLocation((pContenedor.getWidth() - pTelefono.getWidth()) / 2,285);
        pTelefono.setBackground(Color.BLACK);
        pTelefono.setLayout(null);
        this.add(pTelefono);
        pContenedor.add(pTelefono);
    }

    public void crearLabels() {
        Font tipo = new Font("Arial", Font.BOLD, 14);

        lblNumeroProveedor = new JLabel("Número proveedor:");
        lblNumeroProveedor.setSize(150,50);
        lblNumeroProveedor.setLocation(20,5);
        lblNumeroProveedor.setForeground(Color.BLACK);
        lblNumeroProveedor.setFont(tipo);
        pContenedor.add(lblNumeroProveedor);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setSize(100,50);
        lblNombre.setLocation(20,75);
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setFont(tipo);
        pContenedor.add(lblNombre);

        lblInsumo = new JLabel("Insumo:");
        lblInsumo.setSize(100,50);
        lblInsumo.setLocation(20,145);
        lblInsumo.setForeground(Color.BLACK);
        lblInsumo.setFont(tipo);
        pContenedor.add(lblInsumo);

        lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setSize(100,50);
        lblTelefono.setLocation(20,215);
        lblTelefono.setForeground(Color.BLACK);
        lblTelefono.setFont(tipo);
        pContenedor.add(lblTelefono);
    }

    public void crearTextField() {
        txtNumeroProveedor = new JTextField();
        txtNumeroProveedor.setSize(300, 35);
        txtNumeroProveedor.setLocation((pContenedor.getWidth() - txtNumeroProveedor.getWidth()) / 2, 40);
        txtNumeroProveedor.setBackground(Color.WHITE);
        txtNumeroProveedor.setCaretColor(Color.BLACK);
        txtNumeroProveedor.setBorder(null);
        txtNumeroProveedor.setEnabled(false);
        txtNumeroProveedor.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtNumeroProveedor);

        txtNombre = new JTextField();
        txtNombre.setSize(300, 35);
        txtNombre.setLocation((pContenedor.getWidth() - txtNombre.getWidth()) / 2, 110);
        txtNombre.setBackground(Color.WHITE);
        txtNombre.setCaretColor(Color.BLACK);
        txtNombre.setBorder(null);
        txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtNombre);

        txtInsumo = new JTextField();
        txtInsumo.setSize(300, 35);
        txtInsumo.setLocation((pContenedor.getWidth() - txtInsumo.getWidth()) / 2, 180);
        txtInsumo.setBackground(Color.WHITE);
        txtInsumo.setCaretColor(Color.BLACK);
        txtInsumo.setBorder(null);
        txtInsumo.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtInsumo);

        txtTelefono = new JTextField();
        txtTelefono.setSize(300, 35);
        txtTelefono.setLocation((pContenedor.getWidth() - txtTelefono.getWidth()) / 2, 250);
        txtTelefono.setBackground(Color.WHITE);
        txtTelefono.setCaretColor(Color.BLACK);
        txtTelefono.setBorder(null);
        txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtTelefono);
    }

    public void crearButtons() {
        btnAgregar = new JButton("Agregar");
        btnAgregar.setSize(120, 120);
        btnAgregar.setLocation(60, (pContenedorBotones.getHeight() - btnAgregar.getHeight()) / 2);
        btnAgregar.setBackground(Color.WHITE);
        btnAgregar.setForeground(Color.DARK_GRAY);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener((ActionListener) pControlador);
        pContenedorBotones.add(btnAgregar);

        btnModificar = new JButton("Modificar");
        btnModificar.setSize(120, 120);
        btnModificar.setLocation(210, (pContenedorBotones.getHeight() - btnModificar.getHeight()) / 2);
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setForeground(Color.DARK_GRAY);
        btnModificar.setFocusable(false);
        btnModificar.addActionListener((ActionListener) pControlador);
        pContenedorBotones.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setSize(120, 120);
        btnEliminar.setLocation(360, (pContenedorBotones.getHeight() - btnEliminar.getHeight()) / 2);
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setForeground(Color.DARK_GRAY);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener((ActionListener) pControlador);
        pContenedorBotones.add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setSize(120, 120);
        btnLimpiar.setLocation(510, (pContenedorBotones.getHeight() - btnLimpiar.getHeight()) / 2);
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setForeground(Color.DARK_GRAY);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener((ActionListener) pControlador);
        pContenedorBotones.add(btnLimpiar);
    }

    public void limpiar() {
        txtNumeroProveedor.setText("");
        txtNombre.setText("");
        txtInsumo.setText("");
        txtTelefono.setText("");
    }

    /* OBTENER TABLA */
    public JTable getTabla() {
        return obtenerTabla;
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

    /* OBTENER CONTENIDO DE LAS CAJAS DE TEXTO */
    public String getTxtNumeroProveedor() {
        return txtNumeroProveedor.getText();
    }

    public String getTxtNombre() {
        return txtNombre.getText();
    }

    public String getTxtInsumo() {
        return txtInsumo.getText();
    }

    public String getTxtTelefono() {
        return txtTelefono.getText();
    }

    /* ESTABLECER TEXTO EN LAS CAJAS DE TEXTO */
    public void setTxtNumerpProveedor(JTable jtabla, int filas) {
        txtNumeroProveedor.setText(String.valueOf(jtabla.getValueAt(filas, 0)));
    }

    public void setTxtNombre(JTable jtabla, int filas) {
        txtNombre.setText(String.valueOf(jtabla.getValueAt(filas, 1)));
    }

    public void setTxtInsumo(JTable jtabla, int filas) {
        txtInsumo.setText(String.valueOf(jtabla.getValueAt(filas, 2)));
    }

    public void setTxtTelefono(JTable jtabla, int filas) {
        txtTelefono.setText(String.valueOf(jtabla.getValueAt(filas, 3)));
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
