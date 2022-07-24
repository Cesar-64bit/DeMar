package DeMar.src.menuPrincipal;

/*imports para elementos gráficos*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MenuPrincipalVista extends JFrame{
    private JPanel pFondo, pUsuario, pSeparador;
    private JPanel pSombraArea, pSombraEmpleados, pSombraProveedores,
                   pSombraPedidos, pSombraPagos, pSombraPrestamos,
                   pSombraRecepcion, pSombraGastos;
    private JButton btnArea, btnEmpleados, btnProveedores, btnPedidos,
                   btnPagos, btnPrestamos, btnRecepcion,btnGastos;
    private ImageIcon imgEmpleados, imgProveedor, imgPedidos, imgPagos,
                   imgPrestamos, imgRecepcion, imgGastos, imgFotoPerfil;
    private JLabel lblNombreEmpleado, lblFotoPerfil;
    private String nombreUsuario;
    
    Color colorContenedor = new Color(255, 255,255);
    Color sombraBotones = new Color(206,212,218);

    public MenuPrincipalVista(String nombreUsuario) {
        super("Menu Principal");
        this.nombreUsuario = nombreUsuario;
        this.agregarImagenes();
        this.crearPanels();
        this.crearLabels();
        this.crearButtons();
        
     //   setDefaultCloseOperation(EXIT_ON_CLOSE); // Esto sirve para cerrar todo el programa

        setSize(1200, 600);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true); 
    }

    public void agregarImagenes() {
        imgEmpleados = new ImageIcon("DeMar/resources/images/empleados.png");
        imgProveedor = new ImageIcon("DeMar/resources/images/proveedores.png");
        imgPedidos = new ImageIcon("DeMar/resources/images/pedidos.png");
        imgPagos = new ImageIcon("DeMar/resources/images/pagos.png");
        imgPrestamos = new ImageIcon("DeMar/resources/images/prestamos.png");
        imgRecepcion = new ImageIcon("DeMar/resources/images/recepcion.png");
        imgGastos = new ImageIcon("DeMar/resources/images/gastos.png");
        imgFotoPerfil = new ImageIcon("DeMar/resources/images/perfil3.png");
    }

    public void crearPanels(){
        // PANEL FONDO -----------------------------------------------------------------------------
        pFondo = new JPanel();
        pFondo.setSize(1200, 600);
        pFondo.setLocation(0, 0);
        pFondo.setBackground(Color.WHITE); //pantalla de fon
        pFondo.setLayout(null);
        this.add(pFondo);
        
        // PANEL BIO ---------------------------------------------------------------------------
        pUsuario = new JPanel(); //asinar a un atributo un rol
        pUsuario.setSize(250,600);
        pUsuario.setLocation(0, 0);
        pUsuario.setBackground(Color.WHITE); //pantalla de fondo blanco
        pUsuario.setLayout(null);
        this.add(pUsuario);    //agregar un panel
        pFondo.add(pUsuario); //agregar un panel sobre otro

        // PANEL SEPARADOR ------------------------------------------------------------------------
        pSeparador = new JPanel();
        pSeparador.setSize(3, 600);
        pSeparador.setLocation(250, 10);
        pSeparador.setBackground(Color.BLACK);
        pSeparador.setLayout(null);
        this.add(pSeparador);
        pFondo.add(pSeparador);

        pSombraArea = new JPanel();
        pSombraArea.setSize(240, 150);
        pSombraArea.setLocation(300, 20);
        pSombraArea.setBackground(sombraBotones);
        pSombraArea.setLayout(null);
        this.add(pSombraArea);
        pFondo.add(pSombraArea);

        pSombraEmpleados = new JPanel();
        pSombraEmpleados.setSize(240, 150);
        pSombraEmpleados.setLocation(590, 20);
        pSombraEmpleados.setBackground(sombraBotones);
        pSombraEmpleados.setLayout(null);
        this.add(pSombraEmpleados);
        pFondo.add(pSombraEmpleados);

        pSombraProveedores = new JPanel();
        pSombraProveedores.setSize(240, 150);
        pSombraProveedores.setLocation(880, 20);
        pSombraProveedores.setBackground(sombraBotones);
        pSombraProveedores.setLayout(null);
        this.add(pSombraProveedores);
        pFondo.add(pSombraProveedores);

        pSombraPedidos = new JPanel();
        pSombraPedidos.setSize(240, 150);
        pSombraPedidos.setLocation(300, 200);
        pSombraPedidos.setBackground(sombraBotones);
        pSombraPedidos.setLayout(null);
        this.add(pSombraPedidos);
        pFondo.add(pSombraPedidos);

        pSombraPagos = new JPanel();
        pSombraPagos.setSize(240, 150);
        pSombraPagos.setLocation(590, 200);
        pSombraPagos.setBackground(sombraBotones);
        pSombraPagos.setLayout(null);
        this.add(pSombraPagos);
        pFondo.add(pSombraPagos);

        pSombraPrestamos = new JPanel();
        pSombraPrestamos.setSize(240, 150);
        pSombraPrestamos.setLocation(880, 200);
        pSombraPrestamos.setBackground(sombraBotones);
        pSombraPrestamos.setLayout(null);
        this.add(pSombraPrestamos);
        pFondo.add(pSombraPrestamos);

        pSombraRecepcion = new JPanel();
        pSombraRecepcion.setSize(240, 150);
        pSombraRecepcion.setLocation(300, 380);
        pSombraRecepcion.setBackground(sombraBotones);
        pSombraRecepcion.setLayout(null);
        this.add(pSombraRecepcion);
        pFondo.add(pSombraRecepcion);

        pSombraGastos = new JPanel();
        pSombraGastos.setSize(240, 150);
        pSombraGastos.setLocation(590, 380);
        pSombraGastos.setBackground(sombraBotones);
        pSombraGastos.setLayout(null);
        this.add(pSombraGastos);
        pFondo.add(pSombraGastos);
    }
    
    public void crearLabels(){
        //TITULOS ------------------------------------------------------------
        lblNombreEmpleado = new JLabel(nombreUsuario);
        lblNombreEmpleado.setSize(100,50);
        lblNombreEmpleado.setLocation((pUsuario.getWidth() - lblNombreEmpleado.getWidth()) / 2, 5);
        lblNombreEmpleado.setForeground(Color.black);
        lblNombreEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
        pUsuario.add(lblNombreEmpleado);

        // FOTO PERFIL ---------------------------------------------------------
        lblFotoPerfil = new JLabel();
        lblFotoPerfil.setSize(150,150);
        lblFotoPerfil.setLocation((pUsuario.getWidth() - lblFotoPerfil.getWidth()) / 2,60);
        lblFotoPerfil.setIcon(imgFotoPerfil);
        pUsuario.add(lblFotoPerfil);
    } 
    
    public void crearButtons(){
        btnArea = new JButton ("Areas");
        btnArea.setSize(220,130);
        btnArea.setLocation((pSombraArea.getWidth() - btnArea.getWidth()) / 2, 10);
        btnArea.setBackground(colorContenedor);
        btnArea.setForeground(Color.BLACK);
        btnArea.setFocusable(false);
        btnArea.setBorder(null);
        btnArea.setHorizontalAlignment(SwingConstants.CENTER);
        pSombraArea.add(btnArea);
        
        btnEmpleados = new JButton();
        btnEmpleados.setSize(220, 130);
        btnEmpleados.setLocation((pSombraEmpleados.getWidth() - btnEmpleados.getWidth()) / 2, 10);
        btnEmpleados.setBackground(colorContenedor);
        btnEmpleados.setForeground(Color.BLACK);
        btnEmpleados.setFocusable(false);
        btnEmpleados.setBorder(null);
        btnEmpleados.setIcon(imgEmpleados);
        btnEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
        pSombraEmpleados.add(btnEmpleados);
        
        btnProveedores = new JButton();
        btnProveedores.setSize(220, 130);
        btnProveedores.setLocation((pSombraProveedores.getWidth() - btnEmpleados.getWidth()) / 2, 10);
        btnProveedores.setBackground(colorContenedor);
        btnProveedores.setForeground(Color.BLACK);
        btnProveedores.setFocusable(false);
        btnProveedores.setBorder(null);
        btnProveedores.setIcon(imgProveedor);
        btnProveedores.setHorizontalAlignment(SwingConstants.CENTER);
        pSombraProveedores.add (btnProveedores);
    
        btnPedidos = new JButton();
        btnPedidos.setSize(220, 130);
        btnPedidos.setLocation((pSombraPedidos.getWidth() - btnPedidos.getWidth()) / 2, 10);
        btnPedidos.setBackground(colorContenedor);
        btnPedidos.setForeground(Color.BLACK);
        btnPedidos.setFocusable(false);
        btnPedidos.setBorder(null);
        btnPedidos.setIcon(imgPedidos);
        btnPedidos.setHorizontalAlignment(SwingConstants.CENTER);
        pSombraPedidos.add(btnPedidos);
        
        btnPagos = new JButton();
        btnPagos.setSize(220, 130);
        btnPagos.setLocation((pSombraPagos.getWidth() - btnPagos.getWidth()) / 2, 10);
        btnPagos.setBackground(colorContenedor);
        btnPagos.setForeground(Color.BLACK);
        btnPagos.setFocusable(false);
        btnPagos.setBorder(null);
        btnPagos.setIcon(imgPagos);
        btnPagos.setHorizontalAlignment(SwingConstants.CENTER);
        pSombraPagos.add(btnPagos);
        
        btnPrestamos = new JButton();
        btnPrestamos.setSize(220, 130);
        btnPrestamos.setLocation((pSombraPrestamos.getWidth() - btnPrestamos.getWidth()) / 2, 10);
        btnPrestamos.setBackground(colorContenedor);
        btnPrestamos.setForeground(Color.BLACK);
        btnPrestamos.setFocusable(false);
        btnPrestamos.setBorder(null);
        btnPrestamos.setIcon(imgPrestamos);
        btnPrestamos.setHorizontalAlignment(SwingConstants.CENTER);
        pSombraPrestamos.add(btnPrestamos);
        
        btnRecepcion = new JButton();
        btnRecepcion.setSize(220, 130);
        btnRecepcion.setLocation((pSombraRecepcion.getWidth() - btnRecepcion.getWidth()) / 2, 10);
        btnRecepcion.setBackground(colorContenedor);
        btnRecepcion.setForeground(Color.BLACK);
        btnRecepcion.setFocusable(false);
        btnRecepcion.setBorder(null);
        btnRecepcion.setIcon(imgRecepcion);
        btnRecepcion.setHorizontalAlignment(SwingConstants.CENTER);
        pSombraRecepcion.add(btnRecepcion);
        
        btnGastos = new JButton();
        btnGastos.setSize(220, 130);
        btnGastos.setLocation((pSombraGastos.getWidth() - btnGastos.getWidth()) / 2, 10);
        btnGastos.setBackground(colorContenedor);
        btnGastos.setForeground(Color.BLACK);
        btnGastos.setFocusable(false);
        btnGastos.setBorder(null);
        btnGastos.setIcon(imgGastos);
        btnGastos.setHorizontalAlignment(SwingConstants.CENTER);
        pSombraGastos.add(btnGastos);
    }

    /*OBTENER EL TEXTO DE LA ETIQUETA*/
    public String getLblNombreEmpleado() { return lblNombreEmpleado.getText(); }
}