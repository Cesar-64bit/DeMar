package DeMar.src.login;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
// import javax.swing.JRadioButton;
// import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class LoginGraficos extends JFrame {
  private static final long serialVersionUID = 1L;

  // Declaración Objetos Gráficos
  private JPanel pLogin, pFondo;
  private JLabel lblNombreEmpresa, lEslogan, lTituloLogin, lNotificaciones;
  private JTextField txtNombreUsuario;
  private JPasswordField txtClaveUsuario;
  private JComboBox<String> cbxTipoUsuario;
  private JButton bEntrar, bCerrar, bRegistrarse, bOpcion1, bOpcion2, bOpcion3;
  private JCheckBox checkSi, checkNo;
  private ButtonGroup grupo;
  private ImageIcon iFondo;
  private JLabel lFondo;
  private Font fontNombreEmpresa;

  // private JRadioButton rbOpcion1, rbOpcion2;
  // private JTextArea taSugerencias;

  public LoginGraficos() {
    super("Login Usuario");

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

    /* Fuente del título*/
    fontNombreEmpresa = new Font("Forte", Font.PLAIN, 30);

    /* Labels */
    lblNombreEmpresa = new JLabel("DE MAR");
    lblNombreEmpresa.setSize(150,30);
    lblNombreEmpresa.setLocation((pLogin.getWidth() - lblNombreEmpresa.getWidth()) / 2, 60);
    lblNombreEmpresa.setForeground(Color.BLACK);
    lblNombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
    lblNombreEmpresa.setFont(fontNombreEmpresa);
    pLogin.add(lblNombreEmpresa);


    /* Caja de texto */
    txtNombreUsuario = new JTextField("Nombre de usuario"); 
    txtNombreUsuario.setSize(260,40);
    txtNombreUsuario.setLocation((pLogin.getWidth() - txtNombreUsuario.getWidth()) / 2, 120);
    txtNombreUsuario.setForeground(Color.DARK_GRAY);
    txtNombreUsuario.setBackground(Color.WHITE);
    txtNombreUsuario.setCaretColor(Color.BLUE);
    txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
    pLogin.add(txtNombreUsuario);

    /* Caja de texto con contraseña */
    txtClaveUsuario = new JPasswordField("Contraseña");
    txtClaveUsuario.setSize(260, 40);
    txtClaveUsuario.setLocation((pLogin.getWidth() - txtClaveUsuario.getWidth()) / 2, 200);
    txtClaveUsuario.setForeground(Color.DARK_GRAY);
    txtClaveUsuario.setCaretColor(Color.BLUE);
    txtClaveUsuario.setHorizontalAlignment(SwingConstants.CENTER);
    pLogin.add(txtClaveUsuario);

    /* Combo box */
    cbxTipoUsuario = new JComboBox<>();
    cbxTipoUsuario.addItem("Gerente");
    cbxTipoUsuario.addItem("Administrador");
    cbxTipoUsuario.setSize(220,30);
    cbxTipoUsuario.setLocation((pLogin.getWidth() - cbxTipoUsuario.getWidth()) / 2, 280);
    cbxTipoUsuario.setForeground(Color.DARK_GRAY);
    cbxTipoUsuario.setBackground(Color.WHITE);
    ((JLabel) cbxTipoUsuario.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    pLogin.add(cbxTipoUsuario);

    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(995, 535);
    setLocationRelativeTo(this);
    setLayout(null);
    setVisible(true);
  }
}