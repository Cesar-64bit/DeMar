package DeMar.src.pedidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import DeMar.src.Insumos.InsumosModelo;
import DeMar.src.proveedores.ProveedoresModelo;

public class PedidosControlador{
    protected PedidosVista pedidosVista;
    private PedidosModelo modeloPedidos;
    private ProveedoresModelo modeloProveedores;
    private InsumosModelo modeloInsumos;
    private DefaultTableModel tablaProveedores, tablaInsumos, tablaDetalles, idTDetalles, tablaPedidos;

    public PedidosControlador(String nombreUsuario) {
        this.pedidosVista = new PedidosVista(this);
        this.modeloPedidos = new PedidosModelo();
        this.modeloProveedores = new ProveedoresModelo();
        this.modeloInsumos = new InsumosModelo();

        pedidosVista.lblNomEmpleado.setText(nombreUsuario);

        this.asignarEventos();
        this.actualizarProveedores();
        this.reiniciarTDetalles();
        this.reiniciarTPedidos();
    }

    //Obtener proveedores y agregarlos al ComboBox.
    public void actualizarProveedores(){
        pedidosVista.cbxProveedor.removeAllItems();
        pedidosVista.cbxProveedor2.removeAllItems();

        tablaProveedores = modeloProveedores.selecProveedoresActivos();
        pedidosVista.cbxProveedor.addItem("-- Seleccionar --");
        pedidosVista.cbxProveedor2.addItem("-- Seleccionar --");
        for(int j=0; j<tablaProveedores.getRowCount(); j++){
            pedidosVista.cbxProveedor.addItem(tablaProveedores.getValueAt(j, 1).toString());
            pedidosVista.cbxProveedor2.addItem(tablaProveedores.getValueAt(j, 1).toString());
        }
    }

    //Obtener insumos de un proveedor y agregarlos al ComboBox.
    public void actualizarInsumos(){
        pedidosVista.cbxInsumos.removeAllItems();
        pedidosVista.cbxInsumos.addItem("Seleccionar un insumo");
        
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
    public void agregarFilaTDetalles(int id, String nombre, Double precio, double cantidad, Double total){
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

    // Comprobar si el insumo seleccionado ya existe en Tabla Detalles
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

    // Limpia pestaña información
    public void limpiarPInformación(){
        reiniciarTDetalles();
        pedidosVista.cbxProveedor.setSelectedIndex(0);
    }

    // Muestra una tabla en tbInsumos.
    public void actualizarTPedidos(DefaultTableModel tabla){
        pedidosVista.tbPedidos.setModel(tabla);
        pedidosVista.diseñarTbhPedidos();
    }

    // Reinicia el contenido de Tabla Detalles
    public void reiniciarTPedidos(){
        tablaPedidos = new DefaultTableModel();

        String[] columnas =  {"Folio", "Fecha", "Proveedor", "Total"};
        tablaPedidos.setColumnIdentifiers(columnas);

        actualizarTPedidos(tablaPedidos);
    }

    // - - - - - - - - - - - - - - - EVENTOS de COMPONENTES GRAFICOS - - - - - - - - - - - - - - - - - - - - 


    private void asignarEventos(){
        // Clic del boton Cerrar (X)
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
                int id = 0, selecInsumo, posicionInsumo;
                String nombre = "";
                double precio = 0.0, total = 0.0, cantidadSelec = 0.0;
                
                try{
                    selecInsumo = pedidosVista.cbxInsumos.getSelectedIndex();
                    posicionInsumo = insumoExistente(selecInsumo);

                    cantidadSelec = Double.parseDouble(pedidosVista.txtCantidad.getText());
                    precio = Double.parseDouble(tablaInsumos.getValueAt(selecInsumo-1, 3).toString());
                    
                    if(posicionInsumo > -1)
                    {
                        double cantidadFilaAct =  Double.parseDouble(tablaDetalles.getValueAt(posicionInsumo, 2).toString());

                        tablaDetalles.setValueAt(cantidadFilaAct+cantidadSelec, posicionInsumo, 2);
                        tablaDetalles.setValueAt((cantidadFilaAct+cantidadSelec)*precio, posicionInsumo, 3);
                        actualizarTDetalles(tablaDetalles);
                    }
                    else if(selecInsumo > 0){
                        id = Integer.parseInt(tablaInsumos.getValueAt(selecInsumo-1, 0).toString());
                        nombre = tablaInsumos.getValueAt(selecInsumo-1, 1).toString();
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
        
        //Clic del boton Eliminar
        pedidosVista.btnEliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){

                try{
                    int selecInsumo = pedidosVista.cbxInsumos.getSelectedIndex();
                    int posicionInsumo = insumoExistente(selecInsumo);

                    if(posicionInsumo > -1){
                        double cantidadSelec = Double.parseDouble(pedidosVista.txtCantidad.getText());
                        double cantidadFilaAct =  Double.parseDouble(tablaDetalles.getValueAt(posicionInsumo, 2).toString());
                        
                        if(cantidadFilaAct > cantidadSelec){
                            double nuevaCantidad = cantidadFilaAct-cantidadSelec;
                            tablaDetalles.setValueAt(nuevaCantidad, posicionInsumo, 2);
                            actualizarTDetalles(tablaDetalles);

                            double precio = Double.parseDouble(tablaInsumos.getValueAt(selecInsumo-1, 3).toString());
                            tablaDetalles.setValueAt((nuevaCantidad)*precio, posicionInsumo, 3);

                            actualizarTDetalles(tablaDetalles);
                        } 
                        else removerFilaTDetalles(posicionInsumo);
                        
                        limpiarCDetalles();
                    }
                } catch(NumberFormatException exception){
                    // Acción pendiente
                    System.out.println("Excepcion de formato numerico");
                } catch(Exception exception){
                    // Acción pendiente
                    System.out.println("Excepcion general");
                }
            }
        });

        // Clic del boton Limpiar
        pedidosVista.btnLimpiar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                limpiarPInformación();
            }
        });

        // Clic del boton Guardar
        pedidosVista.btnGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                try{
                    if(tablaDetalles.getRowCount()>0 && idTDetalles.getRowCount()>0){
                        //Inserción del pedido
                        int idProveedor = Integer.parseInt(tablaProveedores.getValueAt(pedidosVista.cbxProveedor.getSelectedIndex()-1, 0).toString());
                        String nombreEmpleado = pedidosVista.lblNomEmpleado.getText();
                        modeloPedidos.agregarPedido(idProveedor, nombreEmpleado);
    
                        //Inserción de los detalles pedidos
                        for(int j=0; j<idTDetalles.getRowCount(); j++){
                            int idInsumo = Integer.parseInt(idTDetalles.getValueAt(j, 0).toString());
                            Double cantidad = Double.parseDouble(tablaDetalles.getValueAt(j, 2).toString());
                            modeloPedidos.agregarDetalle(idInsumo, cantidad);
                        }
    
                        //Finalización de la captura
                        modeloPedidos.finalizarCaptura();
                        limpiarPInformación();
                    }
                } catch(NumberFormatException exception){
                    // Acción pendiente
                    System.out.println("Excepcion de formato numerico");
                } catch(Exception exception){
                    // Acción pendiente
                    System.out.println("Excepcion general");
                }
            }
        });
    }
}