package DeMar.src.pedidos;

import java.util.Date;
import java.util.Locale;
import java.awt.*;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import javax.swing.table.JTableHeader;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class PedidosVista extends JFrame {
    //COMPONENTES GRAFICOS
    protected JTabbedPane tpOpciones;
    protected JPanel pFondo, pInfo, pInformacion, pBus, pBusqueda, pBotones, pDatosGenerales, pDetalles, pTablaDetalles, pFiltros, pColores, pPeriodos, pTablaPedidos, pCPendiente, pCProceso, pCCancelar, pCFinalizado;
    protected JScrollPane psTablaDetalles, psTablaPedidos;
    protected JSeparator sBusqueda1, sBusqueda2, sInformacion1, sInformacion2, sEmpleado;
    protected JLabel lblFecha, lblNomEmpleado, lblEmpleado, lblProveedor, lbFolio, lbPeriodo, lbProveedor, lbEmpleado, lblCPendiente, lblCProceso, lblCCancelar, lblCFinalizado, lblTotal;
    protected JComboBox<String> cbxProveedor, cbxInsumos, cbxProveedor2, cbxEmpleado;
    protected JButton btnGuardar, btnLimpiar, btnCerrar, btnAgregar, btnEliminar;
    protected JRadioButton rbHoy, rbEstaSemana, rbEsteMes, rbEsteAño, rbTodos;
    protected JTextField txtCantidad, txtFolio;
    protected JTable tbInsumos, tbPedidos;
    protected JTableHeader tbhInsumos, tbhPedidos;
    protected ButtonGroup bgPeridos;

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
    protected Color color_Pendiente = new Color(255, 230, 153);
    protected Color color_EnProceso = new Color(248, 203, 173);
    protected Color color_Cancelar = Color.WHITE;
    protected Color color_Finalizado = new Color(197, 224, 180);
    private Font fuenteMuyGrande = new Font("Segoe UI", 1, 18);
    private Font fuenteMuyGrande2 = new Font("Segoe UI", 0, 18);
    private Font fuenteGrande = new Font("Segoe UI", 1, 16);
    private Font fuenteMediana = new Font("Segoe UI", 0, 14);
    private Border sinBordes = BorderFactory.createLineBorder(colorFondo, 0);
    private Border bordeSencillo = BorderFactory.createLineBorder(colorPrimario, 1);

    public PedidosVista(PedidosControlador pedidosControlador) {
        this.pedidosControlador = pedidosControlador;

        this.crearPanels();
        this.crearTablas();
        this.crearSeparadores();
        this.crearComboBoxs();
        this.crearTextField();
        this.crearEtiquetas();
        this.crearBotones();
        this.crearRadioButtons();

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
        pFiltros = new JPanel();
        psTablaPedidos = new JScrollPane();
        pColores = new JPanel();
        pPeriodos = new JPanel();
        pTablaPedidos = new JPanel();
        pCFinalizado = new JPanel();
        pCPendiente = new JPanel();
        pCProceso = new JPanel();
        pCCancelar = new JPanel();
        
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
            (int)(anchoJTP*.34), (int)(altoJTP-ejeyJTP*.92),
            (int)(anchoJTP*.3), (int)(ejeyJTP*.45));
        pBotones.setLayout(null);
        pInformacion.add(pBotones);

        pDatosGenerales.setBackground(colorSecundario);
        pDatosGenerales.setLayout(null);
        pDatosGenerales.setBounds(
            (int)(pInformacion.getWidth()*.25), (int)(pInformacion.getHeight()*.06),
            (int)(pInformacion.getWidth()*.5), (int)(pInformacion.getHeight()*.3));
        pInformacion.add(pDatosGenerales);

        pDetalles.setBackground(colorFondo);
        pDetalles.setLayout(null);
        pDetalles.setBounds(
            (int)(pInformacion.getWidth()*.1), (int)(pInformacion.getHeight()*.42),
            (int)(pInformacion.getWidth()*.8), (int)(pInformacion.getHeight()*.4));
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

        pFiltros.setBounds(
            (int)(pBusqueda.getWidth()*.02), (int)(pBusqueda.getHeight()*.062),
            (int)(pBusqueda.getWidth()*.31), (int)(pBusqueda.getHeight()*.72));
        pFiltros.setBackground(colorFondo);
        pFiltros.setBorder(sinBordes);
        pFiltros.setLayout(null);
        pBusqueda.add(pFiltros);

        pPeriodos.setBorder(BorderFactory.createTitledBorder(
            bordeSencillo, 
            "Periodo",
            TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION,
            fuenteMediana));
        pPeriodos.setBounds(
            0, (int)(pFiltros.getHeight()*.04 + 50),
            pFiltros.getWidth(), 210);
        pPeriodos.setLayout(null);
        pPeriodos.setBackground(colorFondo);
        pFiltros.add(pPeriodos);

        psTablaPedidos.setBounds(
            (int)(anchoJTP*.38), (int)(pBusqueda.getHeight()*.08),
            (int)(pBusqueda.getWidth()*.6), (int)(pBusqueda.getHeight()*.72));
        psTablaPedidos.setBackground(colorFondo);
        psTablaPedidos.setBorder(sinBordes);
        psTablaPedidos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pBusqueda.add(psTablaPedidos);

        pTablaPedidos.setBackground(colorPrimario3);
        pTablaPedidos.setLayout(null);
        psTablaPedidos.setViewportView(pTablaPedidos);
        
        pColores.setBounds(
            (int)(pBusqueda.getWidth()*.25), (int)(altoJTP-ejeyJTP*.92),
            (int)(pBusqueda.getWidth()*.5), (int)(ejeyJTP*.45));
        pColores.setBackground(colorFondo);
        pColores.setBorder(sinBordes);
        pColores.setLayout(null);
        pBusqueda.add(pColores);

        pCFinalizado.setBounds(
            (int)(pColores.getWidth()*.04)-17, 9,
            15, 15);
        pCFinalizado.setBackground(color_Finalizado);
        pCFinalizado.setLayout(null);
        pCFinalizado.setBorder(sinBordes);
        pColores.add(pCFinalizado);

        pCPendiente.setBounds(
            (int)(pColores.getWidth()*.29)-17, 9,
            15, 15);
        pCPendiente.setBackground(color_Pendiente);
        pCPendiente.setLayout(null);
        pCPendiente.setBorder(sinBordes);
        pColores.add(pCPendiente);

        pCProceso.setBounds(
            (int)(pColores.getWidth()*.54)-17, 9,
            15, 15);
        pCProceso.setBackground(color_EnProceso);
        pCProceso.setLayout(null);
        pCProceso.setBorder(sinBordes);
        pColores.add(pCProceso);

        pCCancelar.setBounds(
            (int)(pColores.getWidth()*.79)-17, 9,
            15, 15);
        pCCancelar.setBackground(color_Cancelar);
        pCCancelar.setLayout(null);
        pCCancelar.setBorder(bordeSencillo);
        pColores.add(pCCancelar);
    }

    private void crearSeparadores(){
        int anchoSep = (int)((anchoJTP - ejexJTP)*.92);     //Ancho separador.
        int disIzq = (int)((anchoJTP - ejexJTP)*.04);      //Distancia izquierda.

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
        lbFolio = new JLabel();
        lbPeriodo = new JLabel();
        lbProveedor = new JLabel();
        lblEmpleado = new JLabel();
        lblCFinalizado = new JLabel();
        lblCPendiente = new JLabel();
        lblCProceso = new JLabel();
        lblCCancelar = new JLabel();
        lblTotal = new JLabel();

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

        lblEmpleado.setBounds(
            (int)(pDatosGenerales.getWidth()*.12), (int)(pDatosGenerales.getHeight()*.30 - 25),
            (int)(pDatosGenerales.getWidth()*.2), 25);
        lblEmpleado.setLayout(null);
        lblEmpleado.setFont(fuenteMediana);
        lblEmpleado.setHorizontalAlignment(2);
        lblEmpleado.setText("Empleado");
        lblEmpleado.setForeground(colorPrimario);

        lblProveedor.setBounds(
            (int)(pDatosGenerales.getWidth()*.12), (int)(pDatosGenerales.getHeight()*.63 - 25),
            (int)(pDatosGenerales.getWidth()*.2), 25);
        lblProveedor.setLayout(null);
        lblProveedor.setFont(fuenteMediana);
        lblProveedor.setHorizontalAlignment(2);
        lblProveedor.setText("Proveedor");
        lblProveedor.setForeground(colorPrimario);

        lblTotal.setBounds(
            (int)(pInformacion.getWidth()*.1), (int)(pInformacion.getHeight()*.82),
            (int)(psTablaDetalles.getWidth()*.97), 25);
        lblTotal.setLayout(null);
        lblTotal.setFont(fuenteMediana);
        lblTotal.setHorizontalAlignment(4);
        lblTotal.setForeground(colorPrimario);
        lblTotal.setBackground(colorFondo);

        lblCFinalizado.setBounds(
            (int)(pColores.getWidth()*.04), 3,
            (int)(pColores.getWidth()*.2), 25);
        lblCFinalizado.setText("Finalizado");
        lblCFinalizado.setFont(fuenteGrande);
        lblCFinalizado.setHorizontalAlignment(2);

        lblCPendiente.setBounds(
            (int)(pColores.getWidth()*.29), 3,
            (int)(pColores.getWidth()*.2), 25);
        lblCPendiente.setText("Pendientes");
        lblCPendiente.setFont(fuenteGrande);
        lblCPendiente.setHorizontalAlignment(2);

        lblCProceso.setBounds(
            (int)(pColores.getWidth()*.54), 3,
            (int)(pColores.getWidth()*.2), 25);
        lblCProceso.setText("En Proceso");
        lblCProceso.setFont(fuenteGrande);
        lblCProceso.setHorizontalAlignment(2);

        lblCCancelar.setBounds(
            (int)(pColores.getWidth()*.79), 3,
            (int)(pColores.getWidth()*.2), 25);
        lblCCancelar.setText("Cancelados");
        lblCCancelar.setFont(fuenteGrande);
        lblCCancelar.setHorizontalAlignment(2);

        //Mostrar
        pFondo.add(lblFecha);
        pInformacion.add(lblTotal);
        pDatosGenerales.add(lblNomEmpleado);
        pDatosGenerales.add(lblEmpleado);
        pDatosGenerales.add(lblProveedor);
        pColores.add(lblCFinalizado);
        pColores.add(lblCPendiente);
        pColores.add(lblCProceso);
        pColores.add(lblCCancelar);
    }

    private void crearComboBoxs(){
        //Instanciamiento
        cbxProveedor = new JComboBox<>();
        cbxInsumos = new JComboBox<>();
        cbxProveedor2 = new JComboBox<>();
        cbxEmpleado = new JComboBox<>();

        //Contrucción
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
        cbxProveedor.setFont(fuenteGrande);
        cbxProveedor.setForeground(colorPrimario);
        cbxProveedor.setBackground(colorSecundario);
        cbxProveedor.setFocusable(false);
        cbxProveedor.setBorder(bordeSencillo);
        ((JLabel)cbxProveedor.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

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
        cbxInsumos.setFont(fuenteGrande);
        cbxInsumos.setForeground(colorPrimario);
        cbxInsumos.setBackground(colorFondo);
        cbxInsumos.setFocusable(false);
        cbxInsumos.setBorder(bordeSencillo);
        ((JLabel)cbxInsumos.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        cbxProveedor2.setBorder(BorderFactory.createTitledBorder(
            bordeSencillo, 
            "Proveedor",
            TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION,
            fuenteMediana));
        cbxProveedor2.setBounds(
            0, (int)(pFiltros.getHeight()*.10 + 250),
            pFiltros.getWidth(), 60);
            cbxProveedor2.setUI(new BasicComboBoxUI(){
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
                arrowButton.setBackground(colorFondo);
                arrowButton.setForeground(colorPrimario);
            }
        });
        cbxProveedor2.setFont(fuenteGrande);
        cbxProveedor2.setForeground(colorPrimario);
        cbxProveedor2.setBackground(colorFondo);
        cbxProveedor2.setFocusable(false);
        ((JLabel)cbxProveedor2.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        cbxEmpleado.setBorder(BorderFactory.createTitledBorder(
            bordeSencillo, 
            "Empleado",
            TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION,
            fuenteMediana));
        cbxEmpleado.setBounds(
            0, (int)(pFiltros.getHeight()*.14 + 310),
            pFiltros.getWidth(), 60);
            cbxEmpleado.setUI(new BasicComboBoxUI(){
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
                arrowButton.setBackground(colorFondo);
                arrowButton.setForeground(colorPrimario);
            }
        });
        cbxEmpleado.setFont(fuenteGrande);
        cbxEmpleado.setForeground(colorPrimario);
        cbxEmpleado.setBackground(colorFondo);
        cbxEmpleado.setFocusable(false);
        ((JLabel)cbxEmpleado.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        //Mostrar
        pDatosGenerales.add(cbxProveedor);
        pDetalles.add(cbxInsumos);
        pFiltros.add(cbxEmpleado);
        pFiltros.add(cbxProveedor2);
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
            (int)(pDetalles.getWidth()*.85), (int)(pDetalles.getHeight()*.14),
            (int)(pDetalles.getWidth()*.15), 40);
        btnAgregar.setBorder(sinBordes);

        btnEliminar.setBackground(colorPrimario2);
        btnEliminar.setFont(fuenteMuyGrande);
        btnEliminar.setForeground(colorFondo);
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Eliminar un insumo a la lista.");
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBounds(
            (int)(pDetalles.getWidth()*.85), (int)(pDetalles.getHeight()*.14 + 50),
            (int)(pDetalles.getWidth()*.15), 40);
        btnEliminar.setBorder(sinBordes);

        //Mostrar
        pFondo.add(btnCerrar);
        pBotones.add(btnGuardar);
        pBotones.add(btnLimpiar);
        pDetalles.add(btnAgregar);
        pDetalles.add(btnEliminar);
    }

    public void crearRadioButtons(){
        //Instanciamiento
        bgPeridos = new ButtonGroup();
        rbHoy = new JRadioButton();
        rbEstaSemana = new JRadioButton();
        rbEsteMes = new JRadioButton();
        rbEsteAño = new JRadioButton();
        rbTodos = new JRadioButton();

        //Construcción
        rbHoy.setBounds(
            (int)(pPeriodos.getWidth()*0.12), 25,
            (int)(pPeriodos.getWidth()*0.8), 25);
        rbHoy.setLayout(null);
        rbHoy.setBackground(colorFondo);
        rbHoy.setForeground(colorPrimario);
        rbHoy.setFont(fuenteMuyGrande2);
        rbHoy.setFocusPainted(false);
        rbHoy.setName("Hoy");
        rbHoy.setText("Hoy");

        rbEstaSemana.setBounds(
            (int)(pPeriodos.getWidth()*0.12), 60,
            (int)(pPeriodos.getWidth()*0.8), 25);
        rbEstaSemana.setLayout(null);
        rbEstaSemana.setBackground(colorFondo);
        rbEstaSemana.setForeground(colorPrimario);
        rbEstaSemana.setFont(fuenteMuyGrande2);
        rbEstaSemana.setFocusPainted(false);
        rbEstaSemana.setName("Esta semana");
        rbEstaSemana.setText("Esta semana");

        rbEsteMes.setBounds(
            (int)(pPeriodos.getWidth()*0.12), 95,
            (int)(pPeriodos.getWidth()*0.8), 25);
        rbEsteMes.setLayout(null);
        rbEsteMes.setBackground(colorFondo);
        rbEsteMes.setForeground(colorPrimario);
        rbEsteMes.setFont(fuenteMuyGrande2);
        rbEsteMes.setFocusPainted(false);
        rbEsteMes.setName("Este mes");
        rbEsteMes.setText("Este mes");

        rbEsteAño.setBounds(
            (int)(pPeriodos.getWidth()*0.12), 130,
            (int)(pPeriodos.getWidth()*0.8), 25);
        rbEsteAño.setLayout(null);
        rbEsteAño.setBackground(colorFondo);
        rbEsteAño.setForeground(colorPrimario);
        rbEsteAño.setFont(fuenteMuyGrande2);
        rbEsteAño.setFocusPainted(false);
        rbEsteAño.setSelected(true);
        rbEsteAño.setName("Este año");
        rbEsteAño.setText("Este año");

        rbTodos.setBounds(
            (int)(pPeriodos.getWidth()*0.12), 165,
            (int)(pPeriodos.getWidth()*0.8), 25);
        rbTodos.setLayout(null);
        rbTodos.setBackground(colorFondo);
        rbTodos.setForeground(colorPrimario);
        rbTodos.setFont(fuenteMuyGrande2);
        rbTodos.setFocusPainted(false);
        rbTodos.setName("Todos");
        rbTodos.setText("Todos");

        //Mostrar
        pPeriodos.add(rbHoy);
        pPeriodos.add(rbEstaSemana);
        pPeriodos.add(rbEsteMes);
        pPeriodos.add(rbEsteAño);
        pPeriodos.add((rbTodos));

        //Agrupar
        bgPeridos.add(rbHoy);
        bgPeridos.add(rbEstaSemana);
        bgPeridos.add(rbEsteMes);
        bgPeridos.add(rbEsteAño);
        bgPeridos.add(rbTodos);
    }

    public void crearTextField(){
        //Instanciamiento
        txtCantidad = new JTextField();
        txtFolio = new JTextField();
        
        //Construcción
        txtCantidad.setBounds(
            (int)(pDetalles.getWidth()*.55), 0,
            (int)(pDetalles.getWidth()*.17), 35);
        txtCantidad.setFont(fuenteGrande);
        txtCantidad.setHorizontalAlignment(0);
        txtCantidad.setBorder(bordeSencillo);
        txtCantidad.setBackground(colorFondo);
        txtCantidad.setForeground(colorPrimario);
        txtCantidad.setText("Cantidad");
        
        txtFolio.setBorder(BorderFactory.createTitledBorder(
            bordeSencillo, 
            "Folio",
            TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION,
            fuenteMediana));
        txtFolio.setBounds(
            0, 0,
            (int)(pFiltros.getWidth()*.65), 50);
        txtFolio.setFont(fuenteGrande);
        txtFolio.setHorizontalAlignment(2);
        txtFolio.setBackground(colorFondo);
        txtFolio.setForeground(colorPrimario);
        txtFolio.setHorizontalAlignment(0);
        
        //Mostrar
        pDetalles.add(txtCantidad);
        pFiltros.add(txtFolio);
    }

    public void crearTablas(){
        //Instanciamiento
        tbInsumos = new JTable();
        tbhInsumos = new JTableHeader();
        tbPedidos = new JTable();
        tbhPedidos = new JTableHeader();

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

        tbPedidos.setBounds(
            0, 30,
            pTablaPedidos.getWidth(), 0);
        tbPedidos.setBorder(bordeSencillo);
        tbPedidos.setBackground(colorFondo);
        tbPedidos.setForeground(colorPrimario);
        tbPedidos.setFont(fuenteMediana);
        tbPedidos.setRowHeight(25);
        diseñarTbhPedidos();

        //Mostrar
        pTablaDetalles.add(tbhInsumos);
        pTablaDetalles.add(tbInsumos);
        pTablaPedidos.add(tbPedidos);
        pTablaPedidos.add(tbhPedidos);
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

    public void diseñarTbhPedidos(){
        tbhPedidos = tbPedidos.getTableHeader();
        tbhPedidos.setBounds(
            0, 0,
            pTablaPedidos.getWidth(), 30);
        tbhPedidos.setBorder(bordeSencillo);
        tbhPedidos.setBackground(colorPrimario);
        tbhPedidos.setForeground(colorFondo);
        tbhPedidos.setFont(fuenteGrande);

        tbPedidos.setSize(psTablaPedidos.getWidth(), tbPedidos.getRowCount()*25);

        pTablaPedidos.setPreferredSize(
            new Dimension(0, tbhPedidos.getHeight() + tbPedidos.getHeight()));
    }
}