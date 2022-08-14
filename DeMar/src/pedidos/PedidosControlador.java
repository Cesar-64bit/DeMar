package DeMar.src.pedidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.table.DefaultTableModel;
import DeMar.src.Insumos.InsumosModelo;
import DeMar.src.proveedores.ProveedoresModelo;

public class PedidosControlador{
    protected PedidosVista pedidosVista;
    private ProveedoresModelo modeloProveedores;
    private InsumosModelo modeloInsumos;
    private DefaultTableModel tablaProveedores, tablaInsumos;

    public PedidosControlador(String nombreUsuario) {
        this.pedidosVista = new PedidosVista(this);
        this.modeloProveedores = new ProveedoresModelo();
        this.modeloInsumos = new InsumosModelo();

        pedidosVista.lblNomEmpleado.setText(nombreUsuario);

        this.asignarEventos();
        this.actualizarProveedores();
    }

    //Obtener proveedores y agregarlos al ComboBox.
    public void actualizarProveedores(){
        pedidosVista.cbxProveedor.removeAllItems();

        tablaProveedores = modeloProveedores.selecProveedoresActivos();
        pedidosVista.cbxProveedor.addItem("-- Selecionar --");
        for(int j=0; j<tablaProveedores.getRowCount(); j++)
            pedidosVista.cbxProveedor.addItem(tablaProveedores.getValueAt(j, 1).toString());
    }

    //Obtener insumos de un proveedor y agregarlos al ComboBox.
    public void actualizarInsumos(){
        pedidosVista.cbxInsumos.removeAllItems();
        pedidosVista.cbxInsumos.addItem("Insumos");
        
        if(tablaProveedores.getRowCount() > 0  &&  pedidosVista.cbxProveedor.getSelectedIndex() > 0){
            int idProveedor = Integer.parseInt(tablaProveedores.getValueAt(pedidosVista.cbxProveedor.getSelectedIndex()-1, 0).toString());

            // tablaInsumos = modeloInsumos.selecPorProveedor(idProveedor, 1);
            
            for(int j=0; j<tablaInsumos.getRowCount(); j++)
                pedidosVista.cbxInsumos.addItem(tablaInsumos.getValueAt(j, 1).toString());
            if(tablaInsumos.getRowCount() == 1)
                pedidosVista.cbxInsumos.removeItemAt(0);
        }
    }

    private void asignarEventos(){
        pedidosVista.btnCerrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                System.exit(0);
            }
        });

        pedidosVista.cbxProveedor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                actualizarInsumos();
            }
        });
    }
}