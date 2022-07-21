package DeMar.src.login;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
// import javax.swing.JRadioButton;
// import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class LoginGraficos extends JFrame {
  private static final long serialVersionUID = 1L;

  // Declaración Objetos Gráficos
  private JPanel pLogin, pFondo, pUsuario, pContraseña;
  private JLabel lblUsuario, lblContraseña;
  private JTextField txtNombreUsuario;
  private JPasswordField txtClaveUsuario;
  private JComboBox<String> cbxTipoUsuario;
  private JButton btnIngresar;
  private ImageIcon iFondo, iIcono;
  private JLabel lFondo, lIcono;
  private Font fontNombreEmpresa;

  // private JRadioButton rbOpcion1, rbOpcion2;
  // private JTextArea taSugerencias;

  public LoginGraficos() {
    super("De Mar");

    /* Panel para contener el fondo */
    pFondo = new JPanel();
    pFondo.setSize(980, 500);
    pFondo.setLocation(0, 0);
    pFondo.setBackground(Color.WHITE);
    pFondo.setLayout(null);
    this.add(pFondo);

    iFondo = new ImageIcon("DeMar/resources/images/FondoMarLogin.jpg");

    lFondo = new JLabel();
    lFondo.setBounds(0,0,980,500);
    lFondo.setIcon(iFondo);
    pFondo.add(lFondo);

    /* Panel para ingresar datos */
    pLogin = new JPanel();

    Color contenedor = new Color(255, 255, 255);

    pLogin.setSize(360, 450);
    pLogin.setLocation(595, 25);
    pLogin.setBackground(contenedor);
    pLogin.setLayout(null);
    this.add(pLogin);
    lFondo.add(pLogin);

    /* Dibujar Icono */ 

    iIcono = new ImageIcon("DeMar/resources/images/AtunIcono.jpg");

    lIcono = new JLabel();
    lIcono.setSize(128,128);
    lIcono.setLocation((pLogin.getWidth() - lIcono.getWidth()) / 2, 20);
    lIcono.setIcon(iIcono);
    pLogin.add(lIcono);


    /* Panel separador */
    pUsuario = new JPanel();
    pUsuario.setSize(260,1);
    pUsuario.setLocation((pLogin.getWidth() - pUsuario.getWidth()) / 2, 215);
    pUsuario.setBackground(Color.BLACK);
    this.add(pUsuario);
    pLogin.add(pUsuario);

    pContraseña = new JPanel();
    pContraseña.setSize(260,1);
    pContraseña.setLocation((pLogin.getWidth() - pUsuario.getWidth()) / 2, 295);
    pContraseña.setBackground(Color.BLACK);
    this.add(pContraseña);
    pLogin.add(pContraseña);

    /* Fuente del título*/
    fontNombreEmpresa = new Font("Forte", Font.PLAIN, 30);

    /* Labels */
  /*   lblNombreEmpresa = new JLabel("DE MAR");
    lblNombreEmpresa.setSize(150,30);
    lblNombreEmpresa.setLocation((pLogin.getWidth() - lblNombreEmpresa.getWidth()) / 2, 60);
    lblNombreEmpresa.setForeground(Color.BLACK);
    lblNombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
    lblNombreEmpresa.setFont(fontNombreEmpresa);
    pLogin.add(lblNombreEmpresa);*/


    lblUsuario = new JLabel("Usuario");
    lblUsuario.setSize(150, 30);
    lblUsuario.setLocation(50, 145);
    lblUsuario.setForeground(Color.DARK_GRAY);
    pLogin.add(lblUsuario);

    lblContraseña = new JLabel("Contraseña");
    lblContraseña.setSize(150, 30);
    lblContraseña.setLocation(50, 225);
    lblContraseña.setForeground(Color.DARK_GRAY);
    pLogin.add(lblContraseña);

    /* Caja de texto */
    txtNombreUsuario = new JTextField("Ingresar usuario"); 
    txtNombreUsuario.setSize(260,40);
    txtNombreUsuario.setLocation((pLogin.getWidth() - txtNombreUsuario.getWidth()) / 2,175);
    txtNombreUsuario.setForeground(Color.GRAY);
    txtNombreUsuario.setBackground(Color.WHITE);
    txtNombreUsuario.setCaretColor(Color.BLACK);
    txtNombreUsuario.setBorder(null);
    txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
    pLogin.add(txtNombreUsuario);

    /* Caja de texto con contraseña */
    txtClaveUsuario = new JPasswordField("Contraseña");
    txtClaveUsuario.setSize(260, 40);
    txtClaveUsuario.setLocation((pLogin.getWidth() - txtClaveUsuario.getWidth()) / 2, 250);
    txtClaveUsuario.setForeground(Color.DARK_GRAY);
    txtClaveUsuario.setCaretColor(Color.BLACK);
    txtClaveUsuario.setBorder(null);
    txtClaveUsuario.setHorizontalAlignment(SwingConstants.CENTER);
    pLogin.add(txtClaveUsuario);

    /* ComboBox */
    cbxTipoUsuario = new JComboBox<>();
    cbxTipoUsuario.addItem("Recepcionista");
    cbxTipoUsuario.addItem("Administrador");
    cbxTipoUsuario.setSize(220,30);
    cbxTipoUsuario.setLocation((pLogin.getWidth() - cbxTipoUsuario.getWidth()) / 2, 315);
    cbxTipoUsuario.setForeground(Color.DARK_GRAY);
    cbxTipoUsuario.setBackground(Color.WHITE);
    ((JLabel) cbxTipoUsuario.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    pLogin.add(cbxTipoUsuario);

    /* Boton ingresar */
    btnIngresar = new JButton("Ingresar");
    btnIngresar.setSize(140, 40);
    btnIngresar.setLocation((pLogin.getWidth() - btnIngresar.getWidth()) / 2, 375);
    btnIngresar.setBackground(Color.WHITE);
    btnIngresar.setForeground(Color.DARK_GRAY);
    btnIngresar.setFocusable(false);
    pLogin.add(btnIngresar);

    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(995, 535);
    setLocationRelativeTo(this);
    setLayout(null);
    setVisible(true);
  }
}