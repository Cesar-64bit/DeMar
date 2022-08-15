package DeMar.src.usuarios;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class UsuariosVista extends JFrame{
    protected JPanel pFondo, pGrupo;
    protected JTextField txtBuscar;
    protected JButton btnBuscar, btnCrearUsuario;
    protected JTable obtenerTabla;

    protected UsuariosControlador usuariosControlador;

    public UsuariosVista(UsuariosControlador usuariosControlador) {
        super("Control de usuarios");

        this.usuariosControlador = usuariosControlador;
        this.crearPanels();
        this.crearTextField();
        this.crearButtons();

        setSize(515, 625);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true);
    }

    public void diseñarJTable(JTable tabla, JScrollPane scroll) {
        obtenerTabla = tabla;
        obtenerTabla.addMouseListener(usuariosControlador);

        tabla.setSize(350,250);
        tabla.setLocation((pGrupo.getWidth() - tabla.getWidth())/2,(pGrupo.getHeight() - tabla.getHeight())/2);
        scroll.setSize(350,250);
        scroll.setLocation((pGrupo.getWidth() - tabla.getWidth())/2,(pGrupo.getHeight() - tabla.getHeight())/2);
        pGrupo.add(scroll);
    }

    public void crearPanels() {
        pFondo = new JPanel();
        pFondo.setSize(500,600);
        pFondo.setLocation(0,0);
        pFondo.setBackground(Color.WHITE);
        pFondo.setLayout(null);
        this.add(pFondo);

        pGrupo = new JPanel();
        pGrupo.setSize(400,500);
        pGrupo.setLocation((pFondo.getWidth() - pGrupo.getWidth()) / 2,35);
        pGrupo.setBackground(Color.WHITE);
        pGrupo.setLayout(null);
        pGrupo.setBorder(BorderFactory.createTitledBorder("Datos usuarios: "));
        this.add(pGrupo);
        pFondo.add(pGrupo);
    }

    public void crearTextField() {
        txtBuscar = new JTextField();
        txtBuscar.setSize(250, 35);
        txtBuscar.setLocation((pGrupo.getWidth() - txtBuscar.getWidth()) / 2, 25);
        txtBuscar.setBackground(Color.WHITE);
        txtBuscar.setCaretColor(Color.BLACK);
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        pGrupo.add(txtBuscar);
    }

    public void crearButtons() {
        btnBuscar = new JButton("Buscar");
        btnBuscar.setSize(250, 35);
        btnBuscar.setLocation((pGrupo.getWidth() - btnBuscar.getWidth()) / 2, 65);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setForeground(Color.DARK_GRAY);
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener((ActionListener) usuariosControlador);
        pGrupo.add(btnBuscar);

        btnCrearUsuario = new JButton("Crear usuario");
        btnCrearUsuario.setSize(250, 35);
        btnCrearUsuario.setLocation((pGrupo.getWidth() - btnCrearUsuario.getWidth()) / 2, 450);
        btnCrearUsuario.setBackground(Color.WHITE);
        btnCrearUsuario.setForeground(Color.DARK_GRAY);
        btnCrearUsuario.setFocusable(false);
        btnCrearUsuario.addActionListener((ActionListener) usuariosControlador);
        pGrupo.add(btnCrearUsuario);
    }

    /* OBTENER TABLA */
    public JTable getTabla() {
        return obtenerTabla;
    }

    /* OBTENER BOTONES */
    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnCrearUsuario() {
        return btnCrearUsuario;
    }

    /* OBTENER CAJAS DE TEXTO */
    public int getTxtBuscar() {
        return Integer.parseInt(txtBuscar.getText());
    }
}