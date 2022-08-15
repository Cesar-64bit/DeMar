package DeMar.src.pedidos;

import java.util.Date;
import java.util.Locale;
import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.basic.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.border.Border;


public class PedidosVista extends JFrame {
    //COMPONENTES GRAFICOS
    protected JTabbedPane tpOpciones;
    protected JPanel pFondo, pInfo, pInformacion, pBus, pBusqueda, pBotones, pDatosGenerales, pDetalles, pTablaDetalles;
    protected JScrollPane psTablaDetalles;
    protected JSeparator sBusqueda1, sBusqueda2, sInformacion1, sInformacion2, sEmpleado;
    protected JLabel lblFecha, lblNomEmpleado, lblEmpleado, lblProveedor;
    protected JComboBox<String> cbxProveedor, cbxInsumos;
    protected JButton btnGuardar, btnLimpiar, btnCerrar, btnAgregar, btnEliminar;
    protected JTextField txtCantidad;
    protected JTable tbInsumos;
    protected JTableHeader tbhInsumos;

    //CLASES USADAS
    protected PedidosControlador pedidosControlador;

    //VALORES GENERALES
    private int anchoPan = 1100;    //Altura de la pantalla.
    private int altoPan = 600;      //Anchura de la pantalla.
    private int anchoJTP = (int)(anchoPan - anchoPan*.08f);
    private int altoJTP = (int)(altoPan);
    private int ejexJTP = (int)(anchoPan*.026f);
    private int ejeyJTP = 74;
    private Color colorFondo = Color.WHITE;
    private Color colorPrimario = new Color(51, 62, 80);
    private Color colorPrimario2 =  new Color(70, 85, 110);
    private Color colorPrimario3 = new Color(172, 179, 188);
    private Color colorSecundario = new Color(197, 223, 183);
    private Font fuenteMuyGrande = new Font("Segoe UI", 1, 18);
    private Font fuenteGrande = new Font("Segoe UI", 1, 16);
    private Font fuenteMediana = new Font("Segoe UI", 0, 14);
    private Border sinBordes = BorderFactory.createLineBorder(colorFondo, 0);
    private Border bordeSencillo = BorderFactory.createLineBorder(colorPrimario, 1);

    public PedidosVista(PedidosControlador pedidosControlador) {
        this.pedidosControlador = pedidosControlador;

        this.crearPanels();
        this.crearTablas();
        this.crearSeparadores();
        this.crearEtiquetas();
        this.crearComboBoxs();
        this.crearTextField();
        this.crearBotones();

        this.setUndecorated(true);
        this.setSize(anchoPan, altoPan);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        this.setVisible(true);
    }

    private void crearPanels() {
        //Instanciamiento
        pFondo = new JPanel();
        tpOpciones = new JTabbedPane();
        pInfo = new JPanel();
        pBus = new JPanel();
        pInformacion = new JPanel();
        pBusqueda = new JPanel();
        pBotones = new JPanel();
        pDatosGenerales = new JPanel();
        pDetalles = new JPanel();
        psTablaDetalles = new JScrollPane();
        pTablaDetalles = new JPanel();
        
        
        //Construcción
        pFondo.setSize(anchoPan,altoPan);
        pFondo.setLocation(0,0);
        pFondo.setBackground(colorFondo);
        pFondo.setLayout(null);
        pFondo.setBorder(bordeSencillo);
        this.add(pFondo);

        tpOpciones.setLayout(null);
        tpOpciones.setBounds(ejexJTP, 1, anchoJTP, altoJTP);
        tpOpciones.setTabPlacement(1);
        tpOpciones.setBackground(colorFondo);
        tpOpciones.setBorder(sinBordes);
        tpOpciones.setUI(new BasicTabbedPaneUI() {
            //protected void paintTabBackground( Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected ) {}
            protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {}
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {}
        });
        tpOpciones.setFont(fuenteGrande);;
        tpOpciones.add("Información", pInfo);
        tpOpciones.add("Búsqueda", pBus);
        pFondo.add(tpOpciones);

        pInfo.setBackground(colorFondo);
        pInfo.setLayout(null);
        pInfo.setSize(anchoJTP, altoJTP);
        pInformacion.setBackground(colorFondo);
        pInformacion.setLayout(null);
        pInformacion.setBounds(ejexJTP, 0, anchoJTP - ejexJTP, altoJTP);
        pInfo.add(pInformacion);

        pBotones.setBackground(colorFondo);
        pBotones.setLayout(null);
        pBotones.setBounds(
            (int)(anchoJTP*.34f), (int)(altoJTP-ejeyJTP*.92f),
            (int)(anchoJTP*.3f), (int)(ejeyJTP*.45f));
        pBotones.setLayout(null);
        pInformacion.add(pBotones);

        pDatosGenerales.setBackground(colorSecundario);
        pDatosGenerales.setLayout(null);
        pDatosGenerales.setBounds(
            (int)(pInformacion.getWidth()*.25f), (int)(pInformacion.getHeight()*.06f),
            (int)(pInformacion.getWidth()*.5f), (int)(pInformacion.getHeight()*.3f));
        pInformacion.add(pDatosGenerales);

        pDetalles.setBackground(colorFondo);
        pDetalles.setLayout(null);
        pDetalles.setBounds(
            (int)(pInformacion.getWidth()*.1f), (int)(pInformacion.getHeight()*.42f),
            (int)(pInformacion.getWidth()*.8f), (int)(pInformacion.getHeight()*.4f));
        pInformacion.add(pDetalles);

        psTablaDetalles.setBackground(colorPrimario2);
        psTablaDetalles.setBounds(
            0, 50,
            (int)(pDetalles.getWidth()*.81f), pDetalles.getHeight() - 50);
        psTablaDetalles.setBorder(sinBordes);
        psTablaDetalles.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pDetalles.add(psTablaDetalles);

        pTablaDetalles.setBackground(colorPrimario3);
        pTablaDetalles.setLayout(null);
        psTablaDetalles.setViewportView(pTablaDetalles);

        pBus.setBackground(colorFondo);
        pBus.setLayout(null);
        pBus.setSize(anchoJTP, altoJTP);
        pBusqueda.setBackground(colorFondo);
        pBusqueda.setBounds(ejexJTP, 0, anchoJTP - ejexJTP, altoJTP);
        pBusqueda.setLayout(null);
        pBus.add(pBusqueda);
    }

    private void crearSeparadores(){
        int anchoSep = (int)((anchoJTP - ejexJTP)*.92f);     //Ancho separador.
        int disIzq = (int)((anchoJTP - ejexJTP)*.04f);      //Distancia izquierda.

        //Instanciamiento
        sInformacion1 = new JSeparator();
        sInformacion2 = new JSeparator();
        sBusqueda1 = new JSeparator();
        sBusqueda2 = new JSeparator();
        sEmpleado = new JSeparator();

        //Construcción
        sInformacion1.setForeground(colorPrimario);
        sInformacion1.setOrientation(SwingConstants.HORIZONTAL);
        sInformacion1.setBounds(disIzq, 1, anchoSep, 1);
        sInformacion1.setLayout(null);

        sInformacion2.setForeground(colorPrimario);
        sInformacion2.setOrientation(SwingConstants.HORIZONTAL);
        sInformacion2.setBounds(disIzq, altoJTP-ejeyJTP, anchoSep, 1);
        sInformacion2.setLayout(null);

        sEmpleado.setForeground(colorPrimario);
        sEmpleado.setOrientation(SwingConstants.HORIZONTAL);
        sEmpleado.setBounds(
            (int)(pDatosGenerales.getWidth()*.15), (int)(pDatosGenerales.getHeight()*.30),
            (int)(pDatosGenerales.getWidth()*.7), 1);
        sEmpleado.setLayout(null);

        sBusqueda1.setForeground(colorPrimario);
        sBusqueda1.setOrientation(SwingConstants.HORIZONTAL);
        sBusqueda1.setBounds(disIzq, 1, anchoSep, 1);
        sBusqueda1.setLayout(null);

        sBusqueda2.setForeground(colorPrimario);
        sBusqueda2.setOrientation(SwingConstants.HORIZONTAL);
        sBusqueda2.setBounds(disIzq, altoJTP-ejeyJTP, anchoSep, 1);
        sBusqueda2.setLayout(null);

        //Mostrar
        pInformacion.add(sInformacion1);
        pInformacion.add(sInformacion2);
        pDatosGenerales.add(sEmpleado);
        pBusqueda.add(sBusqueda1);
        pBusqueda.add(sBusqueda2);
    }

    private void crearEtiquetas(){
        //Instanciamiento
        lblFecha =  new JLabel();
        lblNomEmpleado = new JLabel();
        lblEmpleado = new JLabel();
        lblProveedor = new JLabel();

        //Construccion
        lblFecha.setLayout(null);
        lblFecha.setFont(fuenteMediana);
        lblFecha.setHorizontalAlignment(0);
        Locale lenguaje = new Locale("es");
        SimpleDateFormat formato = new SimpleDateFormat("EEEEE, d 'de' MMMMM 'del' y", lenguaje);
        lblFecha.setText(formato.format(new Date()));
        lblFecha.setBounds((int)(anchoPan*.29f), 1, (int)(anchoPan*.4f), 30);
        lblFecha.setForeground(colorPrimario);

        lblNomEmpleado.setLayout(null);
        lblNomEmpleado.setFont(fuenteGrande);
        lblNomEmpleado.setHorizontalAlignment(0);
        lblNomEmpleado.setText("Nombre Empleado.");
        lblNomEmpleado.setBounds(
            (int)(pDatosGenerales.getWidth()*.15), (int)(pDatosGenerales.getHeight()*.3),
            (int)(pDatosGenerales.getWidth()*.7), 25);
        lblNomEmpleado.setForeground(colorPrimario);

        lblEmpleado.setLayout(null);
        lblEmpleado.setFont(fuenteMediana);
        lblEmpleado.setHorizontalAlignment(2);
        lblEmpleado.setText("Empleado");
        lblEmpleado.setBounds(
            (int)(pDatosGenerales.getWidth()*.12), (int)(pDatosGenerales.getHeight()*.30 - 25),
            (int)(pDatosGenerales.getWidth()*.2), 25);
        lblEmpleado.setForeground(colorPrimario);

        lblProveedor.setLayout(null);
        lblProveedor.setFont(fuenteMediana);
        lblProveedor.setHorizontalAlignment(2);
        lblProveedor.setText("Proveedor");
        lblProveedor.setBounds(
            (int)(pDatosGenerales.getWidth()*.12), (int)(pDatosGenerales.getHeight()*.63 - 25),
            (int)(pDatosGenerales.getWidth()*.2), 25);
        lblProveedor.setForeground(colorPrimario);

        //Mostrar
        pFondo.add(lblFecha);
        pDatosGenerales.add(lblNomEmpleado);
        pDatosGenerales.add(lblEmpleado);
        pDatosGenerales.add(lblProveedor);
    }

    private void crearComboBoxs(){
        //Instanciamiento
        cbxProveedor = new JComboBox<>();
        cbxInsumos = new JComboBox<>();

        //Contrucción
        cbxProveedor.setFont(fuenteGrande);
        cbxProveedor.setForeground(colorPrimario);
        cbxProveedor.setBackground(colorSecundario);
        cbxProveedor.setFocusable(false);
        ((JLabel)cbxProveedor.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cbxProveedor.setBounds(
            (int)(pDatosGenerales.getWidth()*.15), (int)(pDatosGenerales.getHeight()*.63),
            (int)(pDatosGenerales.getWidth()*.75), 35);
        cbxProveedor.setUI(new BasicComboBoxUI(){
            protected JButton createArrowButton() {
                final JButton button = new JButton("▼");
                button.setName("ComboBox.arrowButton");
                button.setFocusPainted(false);
                button.setBorder(sinBordes);
                button.setFont(fuenteGrande);
                return button;
            }
            public void configureArrowButton() {
                super.configureArrowButton();
                arrowButton.setBackground(colorPrimario);
                arrowButton.setForeground(colorFondo);
            }
        });
        cbxProveedor.setBorder(bordeSencillo);

        cbxInsumos.setFont(fuenteGrande);
        cbxInsumos.setForeground(colorPrimario);
        cbxInsumos.setBackground(colorFondo);
        cbxInsumos.setFocusable(false);
        cbxInsumos.setBounds(
            (int)(pDetalles.getWidth()*.07), 0,
            (int)(pDetalles.getWidth()*.45), 35);
            cbxInsumos.setUI(new BasicComboBoxUI(){
            protected JButton createArrowButton() {
                final JButton button = new JButton("▼");
                button.setName("ComboBox.arrowButton");
                button.setFocusPainted(false);
                button.setBorder(sinBordes);
                button.setFont(fuenteGrande);
                return button;
            }
            public void configureArrowButton() {
                super.configureArrowButton();
                arrowButton.setBackground(colorPrimario);
                arrowButton.setForeground(colorFondo);
            }
        });
        cbxInsumos.setBorder(bordeSencillo);

        //Mostrar
        pDatosGenerales.add(cbxProveedor);
        pDetalles.add(cbxInsumos);
    }

    private void crearBotones(){
        //Instanciamiento
        btnCerrar = new JButton();
        btnGuardar = new JButton();
        btnLimpiar = new JButton();
        btnAgregar = new JButton();
        btnEliminar = new JButton();

        //Construcción
        btnCerrar.setBackground(colorPrimario);
        btnCerrar.setFont(fuenteGrande);
        btnCerrar.setForeground(colorFondo);
        btnCerrar.setText("X");
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBounds(anchoPan-40, 3, 30, 28);
        btnCerrar.setBorder(sinBordes);

        btnGuardar.setBackground(colorPrimario2);
        btnGuardar.setFont(fuenteGrande);
        btnGuardar.setForeground(colorFondo);
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Registrar el pedido.");
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBounds(0, 0, (int)(pBotones.getWidth()*.48f), pBotones.getHeight());
        btnGuardar.setBorder(sinBordes);

        btnLimpiar.setBackground(colorPrimario2);
        btnLimpiar.setFont(fuenteGrande);
        btnLimpiar.setForeground(colorFondo);
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Vaciar la pestaña.");
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setBounds(
            (int)(pBotones.getWidth()*.52f), 0,
            (int)(pBotones.getWidth()*.48f), pBotones.getHeight());
        btnLimpiar.setBorder(sinBordes);

        btnAgregar.setBackground(colorPrimario2);
        btnAgregar.setFont(fuenteMuyGrande);
        btnAgregar.setForeground(colorFondo);
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Agregar un insumo a la lista.");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBounds(
            (int)(pDetalles.getWidth()*.85f), (int)(pDetalles.getHeight()*.14f),
            (int)(pDetalles.getWidth()*.15f), 40);
        btnAgregar.setBorder(sinBordes);

        btnEliminar.setBackground(colorPrimario2);
        btnEliminar.setFont(fuenteMuyGrande);
        btnEliminar.setForeground(colorFondo);
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Eliminar un insumo a la lista.");
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBounds(
            (int)(pDetalles.getWidth()*.85f), (int)(pDetalles.getHeight()*.14f + 50),
            (int)(pDetalles.getWidth()*.15f), 40);
        btnEliminar.setBorder(sinBordes);

        //Mostrar
        pFondo.add(btnCerrar);
        pBotones.add(btnGuardar);
        pBotones.add(btnLimpiar);
        pDetalles.add(btnAgregar);
        pDetalles.add(btnEliminar);
    }

    public void crearTextField(){
        //Instanciamiento
        txtCantidad = new JTextField();

        //Construcción
        txtCantidad.setFont(fuenteGrande);
        txtCantidad.setHorizontalAlignment(0);
        txtCantidad.setBorder(bordeSencillo);
        txtCantidad.setBackground(colorFondo);
        txtCantidad.setForeground(colorPrimario);
        txtCantidad.setBounds(
            (int)(pDetalles.getWidth()*.55), 0,
            (int)(pDetalles.getWidth()*.17), 35);
        txtCantidad.setText("Cantidad");
        
        //Mostrar
        pDetalles.add(txtCantidad);
    }

    public void crearTablas(){
        //Instanciamiento
        tbInsumos = new JTable();
        tbhInsumos = new JTableHeader();

        //Construcción
        tbInsumos.setBounds(
            0, 30,
            pTablaDetalles.getWidth(), 0);
        tbInsumos.setBorder(bordeSencillo);
        tbInsumos.setBackground(colorFondo);
        tbInsumos.setForeground(colorPrimario);
        tbInsumos.setFont(fuenteMediana);
        tbInsumos.setRowHeight(25);
        diseñarTbhInsumos();

        //Mostrar
        pTablaDetalles.add(tbhInsumos);
        pTablaDetalles.add(tbInsumos);
    }

    public void diseñarTbhInsumos(){
        tbhInsumos = tbInsumos.getTableHeader();
        tbhInsumos.setBounds(
            0, 0,
            pTablaDetalles.getWidth(), 30);
        tbhInsumos.setBorder(bordeSencillo);
        tbhInsumos.setBackground(colorPrimario);
        tbhInsumos.setForeground(colorFondo);
        tbhInsumos.setFont(fuenteGrande);

        tbInsumos.setSize(psTablaDetalles.getWidth(), tbInsumos.getRowCount()*25);

        pTablaDetalles.setPreferredSize(
            new Dimension(0, tbhInsumos.getHeight() + tbInsumos.getHeight()));
    }
}