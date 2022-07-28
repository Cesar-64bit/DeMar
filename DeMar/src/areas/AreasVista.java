package DeMar.src.areas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AreasVista extends JFrame {
    // VARIABLES PARA OBJETOS GRÁFICOS
    private JPanel pFondo, pContenedor, pSeparador, pNombre, pInsumoEntrada,
                    pCantidadEmpleados, pSueldoBase, pHoraEntrada, pHoraSalida,
                    pBuscar;
    private JLabel lblNombre, lblInsumoEntrada, lblCantidaEmpleados,
                    lblSueldoBase, lblHoraEntrada, lblHoraSalida;
    private JTextField txtNombre, txtInsumoEntrada, txtCantidadEmpleados,
                        txtSueldoBase, txtHoraEntrada, txtHoraSalida,
                        txtBuscar;
    private JButton btnBuscar, btnAgregar, btnModificar, btnEliminar, btnLimpiar;

    private AreasControlador aControlador;

    /* Constructor */
    public AreasVista(AreasControlador aControlador) {
        super("Areas");

        this.aControlador = aControlador;

        this.crearPanels();
        this.crearLabels();
        this.crearTextField();
        this.crearButtons();

        setSize(1100, 550);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true);
    }


    public void diseñarJTable(JTable tabla, JScrollPane scroll) {
        tabla.setBounds(400,100,600,400);
        scroll.setBounds(400,100,600,400);
        pFondo.add(scroll);
    }

    public void crearPanels() {
        // PANEL PARA FONDO
        pFondo = new JPanel();
        pFondo.setSize(1100, 550);
        pFondo.setLocation(0,0);
        pFondo.setBackground(Color.WHITE);
        pFondo.setLayout(null);
        this.add(pFondo);

        // PANEL CONTENEDOR DATOS
        pContenedor = new JPanel();
        pContenedor.setSize(349, 550);;
        pContenedor.setLocation(0,0);
        pContenedor.setBackground(Color.WHITE);
        pContenedor.setLayout(null);
        this.add(pContenedor);
        pFondo.add(pContenedor);

        // PANEL SEPARADOR
        pSeparador = new JPanel();
        pSeparador.setSize(3,550);
        pSeparador.setLocation(350,0);
        pSeparador.setBackground(Color.DARK_GRAY);
        pSeparador.setLayout(null);
        this.add(pSeparador);
        pFondo.add(pSeparador);

        pNombre = new JPanel();
        pNombre.setSize(300,1);
        pNombre.setLocation((pContenedor.getWidth() - pNombre.getWidth()) / 2,80);
        pNombre.setBackground(Color.BLACK);
        pNombre.setLayout(null);
        this.add(pNombre);
        pContenedor.add(pNombre);

        pInsumoEntrada = new JPanel();
        pInsumoEntrada.setSize(300,1);
        pInsumoEntrada.setLocation((pContenedor.getWidth() - pInsumoEntrada.getWidth()) / 2,155);
        pInsumoEntrada.setBackground(Color.BLACK);
        pInsumoEntrada.setLayout(null);
        this.add(pInsumoEntrada);
        pContenedor.add(pInsumoEntrada);

        pCantidadEmpleados = new JPanel();
        pCantidadEmpleados.setSize(130,1);
        pCantidadEmpleados.setLocation(20,230);
        pCantidadEmpleados.setBackground(Color.BLACK);
        pCantidadEmpleados.setLayout(null);
        this.add(pCantidadEmpleados);
        pContenedor.add(pCantidadEmpleados);

        pSueldoBase = new JPanel();
        pSueldoBase.setSize(130,1);
        pSueldoBase.setLocation(20,305);
        pSueldoBase.setBackground(Color.BLACK);
        pSueldoBase.setLayout(null);
        this.add(pSueldoBase);
        pContenedor.add(pSueldoBase);

        pHoraEntrada = new JPanel();
        pHoraEntrada.setSize(130,1);
        pHoraEntrada.setLocation(20,380);
        pHoraEntrada.setBackground(Color.BLACK);
        pHoraEntrada.setLayout(null);
        this.add(pHoraEntrada);
        pContenedor.add(pHoraEntrada);

        pHoraSalida = new JPanel();
        pHoraSalida.setSize(130,1);
        pHoraSalida.setLocation(20,455);
        pHoraSalida.setBackground(Color.BLACK);
        pHoraSalida.setLayout(null);
        this.add(pHoraSalida);
        pContenedor.add(pHoraSalida);

        pBuscar = new JPanel();
        pBuscar.setSize(300,1);
        pBuscar.setLocation(400,80);
        pBuscar.setBackground(Color.BLACK);
        pBuscar.setLayout(null);
        this.add(pBuscar);
        pFondo.add(pBuscar);
    }

    public void crearLabels() {
        Font tipo = new Font("Arial", Font.BOLD, 16);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setSize(100,50);
        lblNombre.setLocation(20,5);
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setFont(tipo);
        pContenedor.add(lblNombre);

        lblInsumoEntrada = new JLabel("Insumo entrada:");
        lblInsumoEntrada.setSize(130,50);
        lblInsumoEntrada.setLocation(20,80);
        lblInsumoEntrada.setForeground(Color.BLACK);
        lblInsumoEntrada.setFont(tipo);
        pContenedor.add(lblInsumoEntrada);

        lblCantidaEmpleados = new JLabel("Cantidad empleados:");
        lblCantidaEmpleados.setSize(180,50);
        lblCantidaEmpleados.setLocation(20,155);
        lblCantidaEmpleados.setForeground(Color.BLACK);
        lblCantidaEmpleados.setFont(tipo);
        pContenedor.add(lblCantidaEmpleados);

        lblSueldoBase = new JLabel("Sueldo base:");
        lblSueldoBase.setSize(180,50);
        lblSueldoBase.setLocation(20,230);
        lblSueldoBase.setForeground(Color.BLACK);
        lblSueldoBase.setFont(tipo);
        pContenedor.add(lblSueldoBase);

        lblHoraEntrada = new JLabel("Hora entrada:");
        lblHoraEntrada.setSize(180,50);
        lblHoraEntrada.setLocation(20,305);
        lblHoraEntrada.setForeground(Color.BLACK);
        lblHoraEntrada.setFont(tipo);
        pContenedor.add(lblHoraEntrada);

        lblHoraSalida = new JLabel("Hora salida:");
        lblHoraSalida.setSize(180,50);
        lblHoraSalida.setLocation(20,380);
        lblHoraSalida.setForeground(Color.BLACK);
        lblHoraSalida.setFont(tipo);
        pContenedor.add(lblHoraSalida);
    }

    public void crearTextField() {
        txtNombre = new JTextField();
        txtNombre.setSize(300, 40);
        txtNombre.setLocation((pContenedor.getWidth() - txtNombre.getWidth()) / 2, 40);
        txtNombre.setBackground(Color.WHITE);
        txtNombre.setCaretColor(Color.BLACK);
        txtNombre.setBorder(null);
        txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtNombre);

        txtInsumoEntrada = new JTextField();
        txtInsumoEntrada.setSize(300, 40);
        txtInsumoEntrada.setLocation((pContenedor.getWidth() - txtInsumoEntrada.getWidth()) / 2, 115);
        txtInsumoEntrada.setBackground(Color.WHITE);
        txtInsumoEntrada.setCaretColor(Color.BLACK);
        txtInsumoEntrada.setBorder(null);
        txtInsumoEntrada.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtInsumoEntrada);

        txtCantidadEmpleados = new JTextField();
        txtCantidadEmpleados.setSize(130, 40);
        txtCantidadEmpleados.setLocation(20, 190);
        txtCantidadEmpleados.setBackground(Color.WHITE);
        txtCantidadEmpleados.setCaretColor(Color.BLACK);
        txtCantidadEmpleados.setBorder(null);
        txtCantidadEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtCantidadEmpleados);

        txtSueldoBase = new JTextField();
        txtSueldoBase.setSize(130, 40);
        txtSueldoBase.setLocation(20, 265);
        txtSueldoBase.setBackground(Color.WHITE);
        txtSueldoBase.setCaretColor(Color.BLACK);
        txtSueldoBase.setBorder(null);
        txtSueldoBase.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtSueldoBase);

        txtHoraEntrada = new JTextField();
        txtHoraEntrada.setSize(130, 40);
        txtHoraEntrada.setLocation(20, 340);
        txtHoraEntrada.setBackground(Color.WHITE);
        txtHoraEntrada.setCaretColor(Color.BLACK);
        txtHoraEntrada.setBorder(null);
        txtHoraEntrada.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtHoraEntrada);

        txtHoraSalida = new JTextField();
        txtHoraSalida.setSize(130,40);
        txtHoraSalida.setLocation(20,415);
        txtHoraSalida.setBackground(Color.WHITE);
        txtHoraSalida.setCaretColor(Color.BLACK);
        txtHoraSalida.setBorder(null);
        txtHoraSalida.setHorizontalAlignment(SwingConstants.CENTER);
        pContenedor.add(txtHoraSalida);

        txtBuscar = new JTextField("Buscar");
        txtBuscar.setSize(300,40);
        txtBuscar.setLocation(400,40);
        txtBuscar.setForeground(Color.GRAY);
        txtBuscar.setBackground(Color.WHITE);
        txtBuscar.setCaretColor(Color.BLACK);
        txtBuscar.setBorder(null);
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        pFondo.add(txtBuscar);
    }

    public void crearButtons() {
        btnBuscar = new JButton("Buscar");
        btnBuscar.setSize(140, 40);
        btnBuscar.setLocation(750, 20);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setForeground(Color.DARK_GRAY);
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(aControlador);
        pFondo.add(btnBuscar);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setSize(120, 40);
        btnAgregar.setLocation(210, 190);
        btnAgregar.setBackground(Color.WHITE);
        btnAgregar.setForeground(Color.DARK_GRAY);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener(aControlador);
        pContenedor.add(btnAgregar);

        btnModificar = new JButton("Modificar");
        btnModificar.setSize(120, 40);
        btnModificar.setLocation(210, 260);
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setForeground(Color.DARK_GRAY);
        btnModificar.setFocusable(false);
        btnModificar.addActionListener(aControlador);
        pContenedor.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setSize(120, 40);
        btnEliminar.setLocation(210, 330);
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setForeground(Color.DARK_GRAY);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener(aControlador);
        pContenedor.add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setSize(120, 40);
        btnLimpiar.setLocation(210, 400);
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setForeground(Color.DARK_GRAY);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener(aControlador);
        pContenedor.add(btnLimpiar);
    }

    /* OBTENER EVENTOS DE BOTONES */
    public JButton getBtnBuscar() { 
        return btnBuscar;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getLimpiar() {
        return btnLimpiar;
    }

    /* OBTENER CONTENIDO DE LAS CAJAS DE TEXTO */
    public int getTxtBuscar() {
        return Integer.parseInt(txtBuscar.getText());
    }
}