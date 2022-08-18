package DeMar.src.empleados;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.time.LocalDate;

public class EmpleadosVista extends JFrame {
    protected JLabel lblNumeroEmpleado, lblNombre, lblTelefono,
                    lblDireccion, lblDiasLaborados, lblFechaContrato,
                    lblFoto, lblArea;
    protected JTextField txtNumeroEmpleado, txtNombre, txtTelefono,
                    txtDireccion, txtDiasLaborados, txtFechaContrato,
                    txtAreas, txtBuscar, txtRuta;
    protected JButton btnAgregar, btnModificar, btnEliminar, btnLimpiar,
                    btnBuscar, btnCargarFoto;
    protected JComboBox<String> cmbAreas;
    protected JPanel pFondo, pContenedor, pSeparador, pContenedorBotones,
                    pNumeroEmpleado, pNombre, pTelefono, pDireccion,
                    pFechaContrato, pDiasLaborados, pEmpleado;
    protected JTable obtenerTabla;

    protected EmpleadosControlador eControlador;

    public EmpleadosVista(EmpleadosControlador eControlador) {
        super("Empleados");

        this.eControlador = eControlador;
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
        obtenerTabla.addMouseListener(eControlador);

        tabla.setBounds(380,125,690,200);
        scroll.setBounds(380,125,690,200);
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

        pNumeroEmpleado = new JPanel();
        pNumeroEmpleado.setSize(300,1);
        pNumeroEmpleado.setLocation((pContenedor.getWidth() - pNumeroEmpleado.getWidth()) / 2,75);
        pNumeroEmpleado.setBackground(Color.BLACK);
        pNumeroEmpleado.setLayout(null);
        this.add(pNumeroEmpleado);
        pContenedor.add(pNumeroEmpleado);

        pNombre = new JPanel();
        pNombre.setSize(300,1);
        pNombre.setLocation((pContenedor.getWidth() - pNombre.getWidth()) / 2,145);
        pNombre.setBackground(Color.BLACK);
        pNombre.setLayout(null);
        this.add(pNombre);
        pContenedor.add(pNombre);

        pTelefono = new JPanel();
        pTelefono.setSize(300,1);
        pTelefono.setLocation((pContenedor.getWidth() - pTelefono.getWidth()) / 2,215);
        pTelefono.setBackground(Color.BLACK);
        pTelefono.setLayout(null);
        this.add(pTelefono);
        pContenedor.add(pTelefono);

        pDireccion = new JPanel();
        pDireccion.setSize(300,1);
        pDireccion.setLocation((pContenedor.getWidth() - pDireccion.getWidth()) / 2,285);
        pDireccion.setBackground(Color.BLACK);
        pDireccion.setLayout(null);
        this.add(pDireccion);
        pContenedor.add(pDireccion);

        pEmpleado = new JPanel();
        pEmpleado.setSize(300,1);
        pEmpleado.setLocation((pContenedor.getWidth() - pEmpleado.getWidth()) / 2,425);
        pEmpleado.setBackground(Color.BLACK);
        pEmpleado.setLayout(null);
        this.add(pEmpleado);
        pContenedor.add(pEmpleado);

        pFechaContrato = new JPanel();
        pFechaContrato.setSize(300,1);
        pFechaContrato.setLocation((pContenedor.getWidth() - pFechaContrato.getWidth()) / 2,495);
        pFechaContrato.setBackground(Color.BLACK);
        pFechaContrato.setLayout(null);
        this.add(pFechaContrato);
        pContenedor.add(pFechaContrato);

        pDiasLaborados = new JPanel();
        pDiasLaborados.setSize(300,1);
        pDiasLaborados.setLocation((pContenedor.getWidth() - pDiasLaborados.getWidth()) / 2,565);
        pDiasLaborados.setBackground(Color.BLACK);
        pDiasLaborados.setLayout(null);
        this.add(pDiasLaborados);
        pContenedor.add(pDiasLaborados);
    }

    public void crearLabels() {
        Font tipo = new Font("Arial", Font.BOLD, 14);

        lblNumeroEmpleado = new JLabel("Número empleado:");
        lblNumeroEmpleado.setSize(150,50);
        lblNumeroEmpleado.setLocation(20,5);
        lblNumeroEmpleado.setForeground(Color.BLACK);
        lblNumeroEmpleado.setFont(tipo);
        pContenedor.add(lblNumeroEmpleado);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setSize(100,50);
        lblNombre.setLocation(20,75);
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setFont(tipo);
        pContenedor.add(lblNombre);

        lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setSize(100,50);
        lblTelefono.setLocation(20,145);
        lblTelefono.setForeground(Color.BLACK);
        lblTelefono.setFont(tipo);
        pContenedor.add(lblTelefono);

        lblDireccion = new JLabel("Dirección:");
        lblDireccion.setSize(100,50);
        lblDireccion.setLocation(20,215);
        lblDireccion.setForeground(Color.BLACK);
        lblDireccion.setFont(tipo);
        pContenedor.add(lblDireccion);

        lblArea = new JLabel("Áreas:");
        lblArea.setSize(150,50);
        lblArea.setLocation(20,285);
        lblArea.setForeground(Color.BLACK);
        lblArea.setFont(tipo);
        pContenedor.add(lblArea);

        lblFechaContrato = new JLabel("Fecha contrato:");
        lblFechaContrato.setSize(150,50);
        lblFechaContrato.setLocation(20,425);
        lblFechaContrato.setForeground(Color.BLACK);
        lblFechaContrato.setFont(tipo);
        pContenedor.add(lblFechaContrato);

        lblDiasLaborados = new JLabel("Días laborados:");
        lblDiasLaborados.setSize(150,50);
        lblDiasLaborados.setLocation(20,495);
        lblDiasLaborados.setForeground(Color.BLACK);
        lblDiasLaborados.setFont(tipo);
        pContenedor.add(lblDiasLaborados);
    }

    public void crearTextField() {
        txtNumeroEmpleado = new JTextField();
        txtNumeroEmpleado.setSize(300, 35);
        txtNumeroEmpleado.setLocation((pContenedor.getWidth() - txtNumeroEmpleado.getWidth()) / 2, 40);
        txtNumeroEmpleado.setBackground(Color.WHITE);
        txtNumeroEmpleado.setCaretColor(Color.BLACK);
        txtNumeroEmpleado.setBorder(null);
        txtNumeroEmpleado.setEnabled(false);
        txtNumeroEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtNumeroEmpleado);

        txtNombre = new JTextField();
        txtNombre.setSize(300, 35);
        txtNombre.setLocation((pContenedor.getWidth() - txtNombre.getWidth()) / 2, 110);
        txtNombre.setBackground(Color.WHITE);
        txtNombre.setCaretColor(Color.BLACK);
        txtNombre.setBorder(null);
        txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtNombre);

        txtTelefono = new JTextField();
        txtTelefono.setSize(300, 35);
        txtTelefono.setLocation((pContenedor.getWidth() - txtTelefono.getWidth()) / 2, 180);
        txtTelefono.setBackground(Color.WHITE);
        txtTelefono.setCaretColor(Color.BLACK);
        txtTelefono.setBorder(null);
        txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtTelefono);

        txtDireccion = new JTextField();
        txtDireccion.setSize(300, 35);
        txtDireccion.setLocation((pContenedor.getWidth() - txtDireccion.getWidth()) / 2, 250);
        txtDireccion.setBackground(Color.WHITE);
        txtDireccion.setCaretColor(Color.BLACK);
        txtDireccion.setBorder(null);
        txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtDireccion);
        
        cmbAreas = new JComboBox<>();
        cmbAreas.setSize(300, 35);
        cmbAreas.setLocation((pContenedor.getWidth() - cmbAreas.getWidth()) / 2, 320);
        cmbAreas.setBackground(Color.WHITE);
        cmbAreas.setForeground(Color.BLACK);
        cmbAreas.setBorder(null);
        ((JLabel) cmbAreas.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cmbAreas.addActionListener((ActionListener) eControlador);
        pContenedor.add(cmbAreas);

        txtAreas = new JTextField();
        txtAreas.setSize(300, 35);
        txtAreas.setLocation((pContenedor.getWidth() - txtAreas.getWidth()) / 2, 390);
        txtAreas.setBackground(Color.WHITE);
        txtAreas.setCaretColor(Color.BLACK);
        txtAreas.setBorder(null);
        txtAreas.setEnabled(false);
        txtAreas.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtAreas);

        txtFechaContrato = new JTextField();
        txtFechaContrato.setSize(300, 35);
        txtFechaContrato.setLocation((pContenedor.getWidth() - txtFechaContrato.getWidth()) / 2, 460);
        txtFechaContrato.setBackground(Color.WHITE);
        txtFechaContrato.setCaretColor(Color.BLACK);
        txtFechaContrato.setBorder(null);
        txtFechaContrato.setHorizontalAlignment(SwingConstants.CENTER);
        txtFechaContrato.setText(LocalDate.now().toString());
        txtFechaContrato.setEnabled(false);
        pContenedor.add(txtFechaContrato);

        txtDiasLaborados = new JTextField();
        txtDiasLaborados.setSize(300, 35);
        txtDiasLaborados.setLocation((pContenedor.getWidth() - txtDiasLaborados.getWidth()) / 2, 530);
        txtDiasLaborados.setBackground(Color.WHITE);
        txtDiasLaborados.setCaretColor(Color.BLACK);
        txtDiasLaborados.setBorder(null);
        txtDiasLaborados.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtDiasLaborados);

        txtBuscar = new JTextField();
        txtBuscar.setSize(300, 35);
        txtBuscar.setLocation(380, 75);
        txtBuscar.setBackground(Color.WHITE);
        txtBuscar.setCaretColor(Color.BLACK);
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        txtBuscar.addKeyListener((KeyListener) eControlador);
        pFondo.add(txtBuscar);

        txtRuta = new JTextField();
        txtRuta.setSize(300, 35);
        txtRuta.setLocation(380, 15);
        txtRuta.setBackground(Color.WHITE);
        txtRuta.setCaretColor(Color.BLACK);
        txtRuta.setEnabled(false);
        txtRuta.setHorizontalAlignment(SwingConstants.CENTER);
        txtRuta.setText("null");
        pFondo.add(txtRuta);
    }

    public void crearButtons() {
        btnAgregar = new JButton("Agregar");
        btnAgregar.setSize(120, 120);
        btnAgregar.setLocation(60, (pContenedorBotones.getHeight() - btnAgregar.getHeight()) / 2);
        btnAgregar.setBackground(Color.WHITE);
        btnAgregar.setForeground(Color.DARK_GRAY);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener((ActionListener) eControlador);
        pContenedorBotones.add(btnAgregar);

        btnModificar = new JButton("Modificar");
        btnModificar.setSize(120, 120);
        btnModificar.setLocation(210, (pContenedorBotones.getHeight() - btnModificar.getHeight()) / 2);
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setForeground(Color.DARK_GRAY);
        btnModificar.setFocusable(false);
        btnModificar.addActionListener((ActionListener) eControlador);
        pContenedorBotones.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setSize(120, 120);
        btnEliminar.setLocation(360, (pContenedorBotones.getHeight() - btnEliminar.getHeight()) / 2);
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setForeground(Color.DARK_GRAY);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener((ActionListener) eControlador);
        pContenedorBotones.add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setSize(120, 120);
        btnLimpiar.setLocation(510, (pContenedorBotones.getHeight() - btnLimpiar.getHeight()) / 2);
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setForeground(Color.DARK_GRAY);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener((ActionListener) eControlador);
        pContenedorBotones.add(btnLimpiar);

        /*btnBuscar = new JButton("Buscar");
        btnBuscar.setSize(100, 35);
        btnBuscar.setLocation(700, 75);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setForeground(Color.DARK_GRAY);
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener((ActionListener) eControlador);
        pFondo.add(btnBuscar);*/

        btnCargarFoto = new JButton("Cargar Foto");
        btnCargarFoto.setSize(200, 35);
        btnCargarFoto.setLocation(850, 75);
        btnCargarFoto.setBackground(Color.WHITE);
        btnCargarFoto.setForeground(Color.DARK_GRAY);
        btnCargarFoto.setFocusable(false);
        btnCargarFoto.addActionListener((ActionListener) eControlador);
        pFondo.add(btnCargarFoto);
    }

    public void limpiar() {
        txtNumeroEmpleado.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtDiasLaborados.setText("");
        btnAgregar.setEnabled(true);
    }

    public void colocarID(String c) {
        txtAreas.setText(c);
    }

    /* OBTENER TABLA */
    public JTable getTabla() {
        return obtenerTabla;
    }

    /* OBTENER COMBO */
    public JComboBox<String> getCombo() {
        return cmbAreas;
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

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnCargarFoto() {
        return btnCargarFoto;
    }

    public JTextField getTxtFiltrar() {
        return txtBuscar;
    }

    /* OBTENER CAJAS DE TEXTO */
    public String getTxtNumeroEmpleado() {
        return txtNumeroEmpleado.getText();
    }

    public String getTxtNombre() {
        return txtNombre.getText();
    }

    public String getTxtTelefono() {
        return txtTelefono.getText();
    }

    public String getTxtDireccion() {
        return txtDireccion.getText();
    }

    public float getTxtDiasLaborados() {
        return Float.parseFloat(txtDiasLaborados.getText());
    }

    public String getTxtFechaContrato() {
        return txtFechaContrato.getText();
    }

    public String getCmbAreas() {
        return cmbAreas.getSelectedItem().toString();
    }

    public String getTxtAreas() {
        return txtAreas.getText();
    }

    public String getTxtBuscar() {
        return txtBuscar.getText();
    }

    public String getTxtRutaImagen() {
        return txtRuta.getText();
    }

    /* OBTENER COMPONENTE JTEXTFIELD*/
    public JTextField getComponentTxtNombre() {
        return txtNombre;
    }

    public JTextField getComponentTxtTelefono() {
        return txtTelefono;
    }

    public JTextField getComponentTxtDireccion() {
        return txtDireccion;
    }
    public JTextField getComponentTxtDiasLaborados() {
        return txtDiasLaborados;
    }

    public JTextField getComponentTxtBuscar() {
        return txtBuscar;
    }

    /* ESTABLECER TEXTO EN LAS CAJAS DE TEXTO */
    public void setTxtNumeroEmpleado(JTable jtabla, int filas) {
        txtNumeroEmpleado.setText(String.valueOf(jtabla.getValueAt(filas, 0)));
    }

    public void setTxtNombre(JTable jtabla, int filas) {
        txtNombre.setText(String.valueOf(jtabla.getValueAt(filas, 1)));
    }

    public void setTxtTelefono(JTable jtabla, int filas) {
        txtTelefono.setText(String.valueOf(jtabla.getValueAt(filas, 2)));
    }

    public void setTxtDireccion(JTable jtabla, int filas) {
        txtDireccion.setText(String.valueOf(jtabla.getValueAt(filas, 3)));
    }

    public void setTxtAreas(JTable jtabla, int filas) {
        txtAreas.setText(String.valueOf(jtabla.getValueAt(filas, 7)));
    }

    public void setTxtFechaContrato(JTable jtabla, int filas) {
        txtFechaContrato.setText(String.valueOf(jtabla.getValueAt(filas, 5)));
    }

    public void setTxtDiasLaborados(JTable jtabla, int filas) {
        txtDiasLaborados.setText(String.valueOf(jtabla.getValueAt(filas, 4)));
    }

    public void setTxtRuta(JTable jtabla, int filas) {
        txtRuta.setText(String.valueOf(jtabla.getValueAt(filas, 6)));
    }

    public void setTxtRuta(String ruta) {
        txtRuta.setText(ruta);
    }

    /* ESTABLECER DATOS EN JCOMBOBOX*/
    public void setCmbAreas(DefaultTableModel areas) {
        int filas = areas.getRowCount();

        for(int indice = 0; indice < filas; indice++)
            cmbAreas.addItem(areas.getValueAt(indice, 0).toString());
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