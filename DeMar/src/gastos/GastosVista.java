package DeMar.src.gastos;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GastosVista extends JFrame {
    protected JPanel pFondo, pContenedor, pSeparador;

    protected GastosControlador gastosControlador;

    public GastosVista(GastosControlador gastosControlador) {
        super("Gastos");

        this.gastosControlador = gastosControlador;
        this.crearPanels();

        setSize(1115, 575);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true);
    }

    public void crearPanels() {
        pFondo = new JPanel();
        pFondo.setSize(1100,550);
        pFondo.setLocation(0,0);
        pFondo.setBackground(Color.WHITE);
        pFondo.setLayout(null);
        this.add(pFondo);

        pContenedor = new JPanel();
        pContenedor.setSize(349,550);
        pContenedor.setLocation(0,0);
        pContenedor.setBackground(Color.WHITE);
        pContenedor.setLayout(null);
        this.add(pContenedor);
        pFondo.add(pContenedor);

        pSeparador = new JPanel();
        pSeparador.setSize(3,550);
        pSeparador.setLocation(350,0);
        pSeparador.setBackground(Color.DARK_GRAY);
        pSeparador.setLayout(null);
        this.add(pSeparador);
        pFondo.add(pSeparador);
    }
}
