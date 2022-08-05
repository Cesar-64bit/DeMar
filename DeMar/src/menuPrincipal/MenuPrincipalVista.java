package DeMar.src.menuPrincipal;

/*imports para elementos gráficos*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class MenuPrincipalVista extends JFrame {
    private JPanel pFondo, pUsuario;
    private JPanel pSombraArea, pSombraEmpleados, pSombraProveedores,
                   pSombraPedidos, pSombraPagos, pSombraPrestamos,
                   pSombraRecepcion, pSombraGastos, pSombraInsumos;
    private JButton btnArea, btnEmpleados, btnProveedores, btnPedidos,
                    btnPagos, btnPrestamos, btnRecepcion,btnGastos,
                    btnInsumo, btnUsuarios, btnPerfiles, btnCerrarSesion;
    private ImageIcon imgAreas, imgEmpleados, imgProveedor, imgPedidos, imgPagos,
                      imgPrestamos, imgRecepcion, imgGastos, imgFotoPerfil, imgInsumo;
    private JLabel lblNombreEmpleado, lblTipoAcceso, lblFotoPerfil;
    private String nombreUsuario, tipoUsuario;

    private MenuPrincipalControlador mnControlador;
    
    Color colorContenedor = new Color(255, 255,255);
    Color sombraBotones = new Color(206,212,218);
    
    public MenuPrincipalVista(String nombreUsuario, String tipoUsuario, MenuPrincipalControlador mnControlador) {
        super("Menu Principal");

        this.nombreUsuario = nombreUsuario;
        this.tipoUsuario = tipoUsuario;
        this.mnControlador = mnControlador;

        this.agregarImagenes();
        this.crearPanels();
        this.crearLabels();
        this.crearButtons();

        setSize(1200, 600);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true); 
    }

    public void agregarImagenes() {
        imgAreas = new ImageIcon("DeMar/resources/images/areas.png");
        imgEmpleados = new ImageIcon("DeMar/resources/images/empleados.png");
        imgProveedor = new ImageIcon("DeMar/resources/images/proveedores.png");
        imgPedidos = new ImageIcon("DeMar/resources/images/pedidos.png");
        imgPagos = new ImageIcon("DeMar/resources/images/pagos.png");
        imgPrestamos = new ImageIcon("DeMar/resources/images/prestamos.png");
        imgRecepcion = new ImageIcon("DeMar/resources/images/recepcion.png");
        imgGastos = new ImageIcon("DeMar/resources/images/gastos.png");
        imgFotoPerfil = new ImageIcon("DeMar/resources/images/perfil3.png");
        imgInsumo = new ImageIcon("DeMar/resources/images/insumo.png");
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
        pUsuario.setBackground(new Color(106,139,170)); //pantalla de fondo blanco
        pUsuario.setLayout(null);
        this.add(pUsuario);    //agregar un panel
        pFondo.add(pUsuario); //agregar un panel sobre otro

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

        pSombraInsumos = new JPanel();
        pSombraInsumos.setSize(240,150);
        pSombraInsumos.setLocation(880, 380);
        pSombraInsumos.setBackground(sombraBotones);
        pSombraInsumos.setLayout(null);
        this.add(pSombraInsumos);
        pFondo.add(pSombraInsumos);
    }
    
    public void crearLabels(){
        // NOMBRE EMPLEADO ------------------------------------------------------------
        lblNombreEmpleado = new JLabel(nombreUsuario);
        lblNombreEmpleado.setSize(100,50);
        lblNombreEmpleado.setLocation((pUsuario.getWidth() - lblNombreEmpleado.getWidth()) / 2, 5);
        lblNombreEmpleado.setForeground(Color.WHITE);
        lblNombreEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreEmpleado.setFont(new Font("Arial", Font.BOLD, 16));
        pUsuario.add(lblNombreEmpleado);

        // TIPO DE ACCESO
        lblTipoAcceso = new JLabel(tipoUsuario);
        lblTipoAcceso.setSize(100, 50);
        lblTipoAcceso.setLocation((pUsuario.getWidth() - lblTipoAcceso.getWidth()) / 2, 200);
        lblTipoAcceso.setForeground(Color.WHITE);
        lblTipoAcceso.setHorizontalAlignment(SwingConstants.CENTER);
        lblTipoAcceso.setFont(new Font("Arial", Font.BOLD, 14));
        pUsuario.add(lblTipoAcceso);

        // FOTO PERFIL ---------------------------------------------------------
        lblFotoPerfil = new JLabel();
        lblFotoPerfil.setSize(150,150);
        lblFotoPerfil.setLocation((pUsuario.getWidth() - lblFotoPerfil.getWidth()) / 2,60);
        lblFotoPerfil.setIcon(imgFotoPerfil);
        pUsuario.add(lblFotoPerfil);
    }

    public void crearButtons(){
        btnArea = new JButton();
        btnArea.setSize(220,130);
        btnArea.setLocation((pSombraArea.getWidth() - btnArea.getWidth()) / 2, 10);
        btnArea.setBackground(colorContenedor);
        btnArea.setForeground(Color.BLACK);
        btnArea.setFocusable(false);
        btnArea.setBorder(null);
        btnArea.setIcon(imgAreas);
        btnArea.setHorizontalAlignment(SwingConstants.CENTER);
        btnArea.addActionListener(mnControlador);
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

        btnInsumo = new JButton();
        btnInsumo.setSize(220, 130);
        btnInsumo.setLocation((pSombraInsumos.getWidth() - btnInsumo.getWidth()) / 2, 10);
        btnInsumo.setBackground(colorContenedor);
        btnInsumo.setForeground(Color.BLACK);
        btnInsumo.setFocusable(false);
        btnInsumo.setBorder(null);
        btnInsumo.setIcon(imgInsumo);
        btnInsumo.setHorizontalAlignment(SwingConstants.CENTER);
        pSombraInsumos.add(btnInsumo);

        // BOTON USUARIOS -----------------------------------------------------------------------
        btnUsuarios = new JButton("Usuarios");
        btnUsuarios.setSize(150, 50);
        btnUsuarios.setLocation((pUsuario.getWidth() - btnUsuarios.getWidth()) / 2, 300);
        btnUsuarios.setBackground(colorContenedor);
        btnUsuarios.setForeground(Color.BLACK);
        btnUsuarios.setFocusable(false);
      //  btnUsuarios.setBorder(null);
        btnUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
        pUsuario.add(btnUsuarios);

        // BOTON PERFILES -----------------------------------------------------------------------
        btnPerfiles = new JButton("Perfiles");
        btnPerfiles.setSize(150, 50);
        btnPerfiles.setLocation((pUsuario.getWidth() - btnPerfiles.getWidth()) / 2, 365);
        btnPerfiles.setBackground(colorContenedor);
        btnPerfiles.setForeground(Color.BLACK);
        btnPerfiles.setFocusable(false);
        //btnPerfiles.setBorder(null);
        btnPerfiles.setHorizontalAlignment(SwingConstants.CENTER);
        pUsuario.add(btnPerfiles);

        // BOTON CERRAR SESIÓN
        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setSize(150, 50);
        btnCerrarSesion.setLocation((pUsuario.getWidth() - btnCerrarSesion.getWidth()) / 2, 470);
        btnCerrarSesion.setBackground(colorContenedor);
        btnCerrarSesion.setForeground(Color.BLACK);
        btnCerrarSesion.setFocusable(false);
        //btnPerfiles.setBorder(null);
        btnCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        pUsuario.add(btnCerrarSesion);
    }

    public JButton getBtnAreas() {
        return btnArea;
    }
}