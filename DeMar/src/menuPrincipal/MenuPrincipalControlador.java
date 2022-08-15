package DeMar.src.menuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.table.DefaultTableModel;

import DeMar.src.Insumos.InsumosControlador;
import DeMar.src.areas.AreasControlador;
import DeMar.src.empleados.EmpleadosControlador;
import DeMar.src.gastos.GastosControlador;
import DeMar.src.pagos.PagosControlador;
import DeMar.src.pedidos.PedidosControlador;
import DeMar.src.prestamos.PrestamosControlador;
import DeMar.src.proveedores.ProveedoresControlador;
import DeMar.src.recepcion.RecepcionControlador;
import DeMar.src.usuarios.UsuariosControlador;

public class MenuPrincipalControlador extends MouseAdapter implements ActionListener {
    MenuPrincipalModelo modMenu = new MenuPrincipalModelo();

    private MenuPrincipalVista mnPrincipalVista;
    private String nombreUsuario, fotoPerfil;

    public MenuPrincipalControlador(String nombreUsuario, String tipoUsuario) {
        DefaultTableModel tb = modMenu.selecImagen(nombreUsuario);
        fotoPerfil = String.valueOf(tb.getValueAt(0, 0));

        this.mnPrincipalVista = new MenuPrincipalVista(nombreUsuario, tipoUsuario, fotoPerfil, this);   
        this.nombreUsuario = nombreUsuario;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mnPrincipalVista.getBtnAreas()) {
            AreasControlador aVista = new AreasControlador();
            aVista.getClass();
        }
        if(e.getSource() == mnPrincipalVista.getBtnEmpleados()) {
            EmpleadosControlador eVista = new EmpleadosControlador();
            eVista.getClass();
        }
        if(e.getSource() == mnPrincipalVista.getBtnProveedores()) {
            ProveedoresControlador pVista = new ProveedoresControlador();
            pVista.getClass();
        }
        if(e.getSource() == mnPrincipalVista.getBtnPedidos()) {
            PedidosControlador pedidosVista = new PedidosControlador(nombreUsuario);
            pedidosVista.getClass();
        }
        if(e.getSource() == mnPrincipalVista.getBtnPagos()) {
            PagosControlador pagosVista = new PagosControlador();
            pagosVista.getClass();
        }
        if(e.getSource() == mnPrincipalVista.getBtnPrestamos()) {
            PrestamosControlador prestamosVista = new PrestamosControlador();
            prestamosVista.getClass();
        }
        if(e.getSource() == mnPrincipalVista.getBtnRecepcion()) {
            RecepcionControlador recepcionVista = new RecepcionControlador();
            recepcionVista.getClass();
        }
        if(e.getSource() == mnPrincipalVista.getBtnGastos()) {
            GastosControlador gastosVista = new GastosControlador();
            gastosVista.getClass();
        }
        if(e.getSource() == mnPrincipalVista.getBtnInsumos()) {
            InsumosControlador insumosVista = new InsumosControlador();
            insumosVista.getClass();
        }
        if(e.getSource() == mnPrincipalVista.getBtnUsuarios()) {
            UsuariosControlador usuariosVista = new UsuariosControlador();
            usuariosVista.getClass();
        }
    }
}