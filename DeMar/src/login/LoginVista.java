package DeMar.DeMar.src.login;

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

public class LoginVista extends JFrame {
    private JPanel pLogin, pFondo, pUsuario, pContraseña;
    private JLabel lblUsuario, lblContraseña, lblFondo, lblIcono;;
    private JTextField txtNombreUsuario;
    private JPasswordField txtClaveUsuario;
    private JComboBox<String> cbxTipoUsuario;
    private JButton btnIngresar, btnCerrar;
    private ImageIcon iFondo, iIcono;
    private LoginControlador loginControlador;
    private LoginControlador principalVista;
    

public LoginVista(LoginControlador loginControlador) {
    this.loginControlador = loginControlador;
    this.principalVista = loginControlador;
    this.agregarImagenes();
    this.crearPanels();
    this.crearLabels();
    this.crearTextField();
    this.crearComboBox();
    this.crearButtons();

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(980, 500);
    setLocationRelativeTo(this);
    setUndecorated(true);
    setLayout(null);
    setVisible(true);
  }

public void agregarImagenes() {
    iFondo = new ImageIcon("src/DeMar/DeMar/resources/images/FondoMarLogin.jpg");
    iIcono = new ImageIcon("src/DeMar/DeMar/resources/images/AtunIcono.jpg");
}

public void crearLabels() {
    // LABEL PARA CONTENER FONDO --------------------------------------------------------------
    lblFondo = new JLabel();
    lblFondo.setBounds(0,0,980,500);
    lblFondo.setIcon(iFondo);
    pFondo.add(lblFondo);
    lblFondo.add(pLogin);

    // LABEL PARA CONTENER ICONO ------------------------------------------------------------
    lblIcono = new JLabel();
    lblIcono.setSize(128,128);
    lblIcono.setLocation((pLogin.getWidth() - lblIcono.getWidth()) / 2, 20);
    lblIcono.setIcon(iIcono);
    pLogin.add(lblIcono);

    // LABEL USUARIO -------------------------------------------------------------------------
    lblUsuario = new JLabel("Usuario");
    lblUsuario.setSize(150, 30);
    lblUsuario.setLocation(50, 145);
    lblUsuario.setForeground(Color.DARK_GRAY);
    pLogin.add(lblUsuario);

    // LABEL CONTRASEÑA ----------------------------------------------------------------------
    lblContraseña = new JLabel("Contraseña");
    lblContraseña.setSize(150, 30);
    lblContraseña.setLocation(50, 225);
    lblContraseña.setForeground(Color.DARK_GRAY);
    pLogin.add(lblContraseña);
}
  
public void crearPanels() {
    // PANEL FONDO -----------------------------------------------------------------------------
    pFondo = new JPanel();
    pFondo.setSize(980, 500);
    pFondo.setLocation(0, 0);
    pFondo.setBackground(Color.WHITE);
    pFondo.setLayout(null);
    this.add(pFondo);

    // PANEL LOGIN -----------------------------------------------------------------------------
    pLogin = new JPanel();
    pLogin.setSize(360, 450);
    pLogin.setLocation(595, 25);
    pLogin.setBackground(Color.WHITE);
    pLogin.setLayout(null);
    this.add(pLogin);

    // PANEL SEPARADOR USUARIO ----------------------------------------------------------------
    pUsuario = new JPanel();
    pUsuario.setSize(260,1);
    pUsuario.setLocation((pLogin.getWidth() - pUsuario.getWidth()) / 2, 215);
    pUsuario.setBackground(Color.BLACK);
    this.add(pUsuario);
    pLogin.add(pUsuario);

    // PANEL SEPARADOR CONTRASEÑA -------------------------------------------------------------
    pContraseña = new JPanel();
    pContraseña.setSize(260,1);
    pContraseña.setLocation((pLogin.getWidth() - pUsuario.getWidth()) / 2, 295);
    pContraseña.setBackground(Color.BLACK);
    this.add(pContraseña);
    pLogin.add(pContraseña);
}

public void crearTextField() {
    // TEXTFIELD USUARIO ---------------------------------------------------------------------------
    txtNombreUsuario = new JTextField("Ingresar usuario"); 
    txtNombreUsuario.setSize(260,40);
    txtNombreUsuario.setLocation((pLogin.getWidth() - txtNombreUsuario.getWidth()) / 2,175);
    txtNombreUsuario.setForeground(Color.GRAY);
    txtNombreUsuario.setBackground(Color.WHITE);
    txtNombreUsuario.setCaretColor(Color.BLACK);
    txtNombreUsuario.setBorder(null);
    txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
    pLogin.add(txtNombreUsuario);

    // PASSWORDFIELD CONTRASEÑA --------------------------------------------------------------------
    txtClaveUsuario = new JPasswordField("Contraseña");
    txtClaveUsuario.setSize(260, 40);
    txtClaveUsuario.setLocation((pLogin.getWidth() - txtClaveUsuario.getWidth()) / 2, 250);
    txtClaveUsuario.setForeground(Color.DARK_GRAY);
    txtClaveUsuario.setCaretColor(Color.BLACK);
    txtClaveUsuario.setBorder(null);
    txtClaveUsuario.setHorizontalAlignment(SwingConstants.CENTER);
    pLogin.add(txtClaveUsuario);
}

public void crearComboBox() {
    // COMBOBOX TIPO ACCESO -----------------------------------------------------------------------
    cbxTipoUsuario = new JComboBox<>();
    cbxTipoUsuario.addItem("Recepcionista");
    cbxTipoUsuario.addItem("Administrador");
    cbxTipoUsuario.setSize(220,30);
    cbxTipoUsuario.setLocation((pLogin.getWidth() - cbxTipoUsuario.getWidth()) / 2, 315);
    cbxTipoUsuario.setForeground(Color.DARK_GRAY);
    cbxTipoUsuario.setBackground(Color.WHITE);
    ((JLabel) cbxTipoUsuario.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    pLogin.add(cbxTipoUsuario);
}

public void crearButtons() {
    // BOTON INGRESAR ---------------------------------------------------------------------
    btnIngresar = new JButton("Ingresar");
    btnIngresar.setSize(140, 40);
    btnIngresar.setLocation((pLogin.getWidth() - btnIngresar.getWidth()) / 2, 375);
    btnIngresar.setBackground(Color.WHITE);
    btnIngresar.setForeground(Color.DARK_GRAY);
    btnIngresar.setFocusable(false);
    btnIngresar.addActionListener(principalVista);
    pLogin.add(btnIngresar);

    // BOTON CERRAR ----------------------------------------------------------------------
    btnCerrar = new JButton("X");
    btnCerrar.setSize(45,45);
    btnCerrar.setLocation(310, 5);
    btnCerrar.setBackground(Color.WHITE);
    btnCerrar.setForeground(Color.BLACK);
    btnCerrar.setFocusable(false);
    btnCerrar.setBorder(null);
    btnCerrar.addActionListener(this.loginControlador);
    pLogin.add(btnCerrar);
}

public JButton getBtnCerrar() { return this.btnCerrar; }
public JButton getBtnIngresar() { return this.btnIngresar; }

}