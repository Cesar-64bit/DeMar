//

package DeMar.DeMar.src.menuPrincipal;


//LIBRERIAS 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class MenuPrincipalVista extends JFrame{
    
    private JPanel pFondo, pUsuario;
    private JLabel lblTitulo;
    private JButton btnArea, btnEmpleados, btnProveedores, btnPedidos, btnPagos, btnPrestamos, btnRecepcion,btnGastos;
    
    public MenuPrincipalVista() {
        super("Menu Principal");
        this.crearPanels();
        this.crearLabels();
        this.crearBotones();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 600);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true); 
    }
    
    public void crearPanels(){
    // PANEL FONDO -----------------------------------------------------------------------------
    pFondo = new JPanel();
    pFondo.setSize(1200, 600);
    pFondo.setLocation(0, 0);
    pFondo.setBackground(Color.GRAY); //pantalla de fon
    pFondo.setLayout(null);
    this.add(pFondo);
    
    // PANEL BIO ---------------------------------------------------------------------------
    pUsuario = new JPanel(); //asinar a un atributo un rol
    pUsuario.setSize(250,600);
    pUsuario.setLocation(0, 0);
    pUsuario.setBackground(Color. WHITE); //pantalla de fondo blanco
    pUsuario.setLayout(null);
    this.add(pUsuario);    //agregar un panel
    pFondo.add(pUsuario); //agregar un panel sobre otro 
    
    
    }
    
    public void crearLabels(){
        
    //TITULOS
    lblTitulo = new JLabel("Nombre de boton seleccionado ");
    lblTitulo.setBounds(260,50,150,30);
    lblTitulo.setForeground(Color.black);
    pFondo.add(lblTitulo);
    } 
    
    public void crearBotones(){
    
    btnArea = new JButton ("    AREA");
    btnArea.setBounds(10,100,220,30);
    btnArea.setForeground(Color.black);
    pUsuario.add(btnArea);
    
    btnEmpleados = new JButton ("   Empleados");
    btnEmpleados.setBounds(10, 130, 220, 30);
    btnEmpleados.setForeground(Color.black);
    pUsuario.add(btnEmpleados);
    
    btnProveedores = new JButton ("   Proveedores");
    btnProveedores.setBounds(10,160,220,30);
    btnProveedores.setForeground(Color.black);
    pUsuario.add (btnProveedores);
    
    btnPedidos = new JButton ("   Pedidos");
    btnPedidos.setBounds(10,190,220,30);
    btnPedidos.setForeground(Color.BLACK);
    pUsuario.add(btnPedidos);
    
    btnPagos = new JButton ("   Pagos");
    btnPagos.setBounds(10,220,220,30);
    btnPagos.setForeground(Color.BLACK);
    pUsuario.add(btnPagos);
    
    btnPrestamos = new JButton ("   Prestamos");
    btnPrestamos.setBounds(10,250,220,30);
    btnPrestamos.setForeground(Color.BLACK);
    pUsuario.add(btnPrestamos);
    
    btnRecepcion = new JButton ("   Recepción");
    btnRecepcion.setBounds(10,280,220,30);
    btnRecepcion.setForeground(Color.BLACK);
    pUsuario.add(btnRecepcion);
    
    btnGastos = new JButton ("   Gastos");
    btnGastos.setBounds(10,310,220,30);
    btnGastos.setForeground(Color.BLACK);
    pUsuario.add(btnGastos);
    
            
    }
    
    
}