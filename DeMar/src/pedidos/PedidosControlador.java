package DeMar.src.pedidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import DeMar.src.Insumos.InsumosModelo;
import DeMar.src.proveedores.ProveedoresModelo;

public class PedidosControlador{
    protected PedidosVista pedidosVista;
    private ProveedoresModelo modeloProveedores;
    private InsumosModelo modeloInsumos;
    private DefaultTableModel tablaProveedores, tablaInsumos, tablaDetalles, idTDetalles;

    public PedidosControlador(String nombreUsuario) {
        this.pedidosVista = new PedidosVista(this);
        this.modeloProveedores = new ProveedoresModelo();
        this.modeloInsumos = new InsumosModelo();

        pedidosVista.lblNomEmpleado.setText(nombreUsuario);

        this.asignarEventos();
        this.actualizarProveedores();
        this.reiniciarTDetalles();
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
            int idProveedor = Integer.parseInt(tablaProveedores.getValueAt(
                pedidosVista.cbxProveedor.getSelectedIndex()-1,
                0).toString());
            tablaInsumos = modeloInsumos.selecPorProveedor(idProveedor, 1);
            
            for(int j=0; j<tablaInsumos.getRowCount(); j++)
                pedidosVista.cbxInsumos.addItem(tablaInsumos.getValueAt(j, 1).toString());
            if(tablaInsumos.getRowCount() == 1)
                pedidosVista.cbxInsumos.setSelectedIndex(1);
        }
    }

    // Muestra una tabla en tbInsumos.
    public void actualizarTDetalles(DefaultTableModel tabla){
        pedidosVista.tbInsumos.setModel(tabla);
        pedidosVista.diseñarTbhInsumos();
    }

    // Reinicia el contenido de Tabla Detalles
    public void reiniciarTDetalles(){
        tablaDetalles = new DefaultTableModel();
        idTDetalles = new DefaultTableModel();

        String[] colum0 =  {"Nombre", "Precio", "Cantidad", "Total"};
        tablaDetalles.setColumnIdentifiers(colum0);
        String[] colum1 =  {"id"};
        idTDetalles.setColumnIdentifiers(colum1);

        actualizarTDetalles(tablaDetalles);
    }

    // Agrega una fila a Tabla Detalles
    public void agregarFilaTDetalles(int id, String nombre, Double precio, int cantidad, Double total){
        Object[] filaTID = {id};
        idTDetalles.addRow(filaTID);
        Object[] filaTDetalles = {nombre, precio, cantidad, total};
        tablaDetalles.addRow(filaTDetalles);

        actualizarTDetalles(tablaDetalles);
    }

    //Remover una fila a Tabla Detalles
    public void removerFilaTDetalles(int posicion){
        if(tablaDetalles.getRowCount()>0 && idTDetalles.getRowCount()>0){
            tablaDetalles.removeRow(posicion);
            idTDetalles.removeRow(posicion);

            actualizarTDetalles(tablaDetalles);
        }
    }

    // Comprobar si el insumo seleccionado ya se agrego a Tabla Detalles
    //    -1: Insumo no encontrado
    //  >= 0: Posición del insumo en tablaDetalles y idTDetalles
    public int insumoExistente(int posicionComboBox){
        int resultado = -1;

        try{
            if(posicionComboBox > 0){
                for(int j=0; j<tablaInsumos.getRowCount(); j++){
                    String idInsumoSelec = tablaInsumos.getValueAt(posicionComboBox-1, 0).toString();
                    String idInsumoFilaAct = idTDetalles.getValueAt(j, 0).toString();
    
                    if(idInsumoSelec.equals(idInsumoFilaAct)){
                        resultado = j;
                        break;
                    }
                }   
            }
            else{
                //Acción pendiente.
            }
        } catch(ArrayIndexOutOfBoundsException exception){
            // Acciones pendientes
            System.out.println("Excepción para fuera de indice.");
        } catch(Exception exception){
            // Acciones pendientes
            System.out.println("Excepcion general");
        }

        return resultado;
    }

    // Limpia Campos de Detalles
    public void limpiarCDetalles(){
        pedidosVista.cbxInsumos.setSelectedIndex(0);
        pedidosVista.txtCantidad.setText("Cantidad");
        if(tablaInsumos.getRowCount() == 1)
                pedidosVista.cbxInsumos.setSelectedIndex(1);
    }


    // - - - - - - - - - - - - - - - - EVENTOS BOTONES - - - - - - - - - - - - - - - - - - - - - 


    private void asignarEventos(){
        // Clic al boton Cerrar (X)
        pedidosVista.btnCerrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                System.exit(0);
            }
        });

        //Cambiar de insumo en el ComboBox
        pedidosVista.cbxProveedor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                actualizarInsumos();
                reiniciarTDetalles();
                pedidosVista.txtCantidad.setText("Cantidad");
            }
        });

        //Clic al boton Agregar
        pedidosVista.btnAgregar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                int id = 0, cantidadSelec = 0, selecInsumo, posicionInsumo;
                String nombre = "";
                Double precio = 0.0, total = 0.0;
                
                try{
                    cantidadSelec = Integer.parseInt(pedidosVista.txtCantidad.getText());
                    precio = Double.parseDouble(tablaInsumos.getValueAt(pedidosVista.cbxInsumos.getSelectedIndex()-1, 3).toString());

                    selecInsumo = pedidosVista.cbxInsumos.getSelectedIndex();
                    posicionInsumo = insumoExistente(selecInsumo);
                    if(posicionInsumo > -1)
                    {
                        int cantidadFilaAct =  Integer.parseInt(tablaDetalles.getValueAt(posicionInsumo, 2).toString());

                        tablaDetalles.setValueAt(cantidadFilaAct+cantidadSelec, posicionInsumo, 2);
                        tablaDetalles.setValueAt((cantidadFilaAct+cantidadSelec)*precio, posicionInsumo, 3);
                        actualizarTDetalles(tablaDetalles);
                    }
                    else if(selecInsumo > 0){
                        id = Integer.parseInt(tablaInsumos.getValueAt(pedidosVista.cbxInsumos.getSelectedIndex()-1, 0).toString());
                        nombre = tablaInsumos.getValueAt(pedidosVista.cbxInsumos.getSelectedIndex()-1, 1).toString();
                        total = precio*cantidadSelec;

                        agregarFilaTDetalles(id, nombre, precio, cantidadSelec, total);
                    }

                    limpiarCDetalles();
                } catch(NumberFormatException exception){
                    // Acción pendiente
                    System.out.println("Excepcion de formato numerico");
                } catch(Exception exception){
                    // Acción pendiente
                    System.out.println("Excepcion general");
                }
            }
        });
        
        pedidosVista.btnEliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){

                try{
                    int selecInsumo = pedidosVista.cbxInsumos.getSelectedIndex();
                    int posicionInsumo = insumoExistente(selecInsumo);

                    if(posicionInsumo > -1){
                        int cantidadSelec = Integer.parseInt(pedidosVista.txtCantidad.getText());
                        int cantidadFilaAct =  Integer.parseInt(tablaDetalles.getValueAt(posicionInsumo, 2).toString());
                        
                        if(cantidadFilaAct > cantidadSelec){
                            tablaDetalles.setValueAt(cantidadFilaAct-cantidadSelec, posicionInsumo, 2);
                            actualizarTDetalles(tablaDetalles);
                        } 
                        else removerFilaTDetalles(posicionInsumo);
                        
                        limpiarCDetalles();
                    }
                } catch(NumberFormatException exception){
                    // Acción pendiente
                } catch(Exception exception){
                    // Acción pendiente.
                }
            }
        });
    }
}