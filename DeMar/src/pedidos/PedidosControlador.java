package DeMar.src.pedidos;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DeMar.src.resaltarCampo;
import DeMar.src.Insumos.InsumosModelo;
import DeMar.src.empleados.EmpleadosModelo;
import DeMar.src.proveedores.ProveedoresModelo;
import java.awt.Component;

public class PedidosControlador{
    protected PedidosVista pedidosVista;
    private PedidosModelo modeloPedidos;
    private EmpleadosModelo modeloEmpleados;
    private ProveedoresModelo modeloProveedores;
    private resaltarCampo resaltado;
    private InsumosModelo modeloInsumos;
    private DefaultTableModel tablaProveedores, tablaInsumos, tablaDetalles, idTDetalles, tablaPedidos, estadoTPedidos, tablaEmpleados;

    public PedidosControlador(String nombreUsuario) {
        this.pedidosVista = new PedidosVista(this);
        this.modeloPedidos = new PedidosModelo();
        this.modeloProveedores = new ProveedoresModelo();
        this.modeloEmpleados = new EmpleadosModelo();
        this.modeloInsumos = new InsumosModelo();
        pedidosVista.lblNomEmpleado.setText(nombreUsuario);

        this.asignarEventos();
        this.actualizarProveedores();
        this.actualizarEmpleados();
        this.reiniciarTDetalles();
        this.reiniciarTPedidos();
        this.obtenerPedidos();
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

    public void actualizarEmpleados(){
        pedidosVista.cbxEmpleado.removeAllItems();

        tablaEmpleados = modeloEmpleados.selecEmpleadosActivos();
        pedidosVista.cbxEmpleado.addItem("-- Seleccionar --");
        for(int j=0; j<tablaEmpleados.getRowCount(); j++)
            pedidosVista.cbxEmpleado.addItem(tablaEmpleados.getValueAt(j, 1).toString());
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

        // Darle formato a las filas
        pedidosVista.tbInsumos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,  boolean hasFocus, int row, int column){
                setHorizontalAlignment(0);

                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
    }

    // Reinicia el contenido de Tabla Detalles
    public void reiniciarTDetalles(){
        tablaDetalles = new DefaultTableModel();
        idTDetalles = new DefaultTableModel();

        tablaDetalles.setColumnIdentifiers(new String[] {"Nombre", "Precio", "Cantidad", "Total"});
        idTDetalles.setColumnIdentifiers(new String[] {"id"});

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
        try{
            pedidosVista.tbPedidos.setModel(tabla);
            pedidosVista.diseñarTbhPedidos();

            // Darle formato a las filas
            pedidosVista.tbPedidos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,  boolean hasFocus, int row, int column){
                    setHorizontalAlignment(0);

                    int estado = Integer.parseInt(estadoTPedidos.getValueAt(row, 0).toString());
                    if(estado == 2) setBackground(pedidosVista.color_Pendiente);
                    else if(estado == 1) setBackground(pedidosVista.color_EnProceso);
                    else if(estado == 0) setBackground(pedidosVista.color_Finalizado);
                    else if(estado == -1) setBackground(pedidosVista.color_Cancelar);

                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            });
            int tamañoTabla = pedidosVista.psTablaDetalles.getWidth();
            pedidosVista.tbPedidos.getColumnModel().getColumn(0).setMaxWidth((int)(tamañoTabla*.1));
            pedidosVista.tbPedidos.getColumnModel().getColumn(0).setMinWidth((int)(tamañoTabla*.1));
            pedidosVista.tbPedidos.getColumnModel().getColumn(3).setMaxWidth((int)(tamañoTabla*.2));
            pedidosVista.tbPedidos.getColumnModel().getColumn(3).setMinWidth((int)(tamañoTabla*.2));
        } catch(ArrayIndexOutOfBoundsException exception){
            //Acción pendiente
            System.out.println("Excepción para fuera de indice.");
        } catch(Exception exception){
            //Acción pendiente
            System.out.println(exception);
        }
    }

    // Reinicia el contenido de Tabla Detalles
    public void reiniciarTPedidos(){
        tablaPedidos = new DefaultTableModel();
        estadoTPedidos = new DefaultTableModel();

        tablaPedidos.setColumnIdentifiers(new String[] {"Folio", "Fecha", "Proveedor", "Total"});
        estadoTPedidos.setColumnIdentifiers(new String[] {"estado"});
    }

    // Constricción tabla pedidos
    // La tabla proporcionada debe ser una consulta a pedidos.
    public void construirNuevaTPedidos(DefaultTableModel consultaPedidos){
        try{
            reiniciarTPedidos();

            for(int j=consultaPedidos.getRowCount()-1; j>=0; j--){
                // Obtiene el "folio"
                int id = Integer.parseInt(consultaPedidos.getValueAt(j, 0).toString());

                // Obtiene y le da formato a la fecha
                SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                Date fecha = formato.parse(consultaPedidos.getValueAt(j, 1).toString());
                Locale lenguaje = new Locale("es");
                formato = new SimpleDateFormat("d 'de' MMMMM 'del' y", lenguaje);
                String fechaTexto = formato.format(fecha);

                // Obtiene el nombre del proveedor
                String nombreProveedor = "Desconocido";
                int idProveedor = Integer.parseInt(consultaPedidos.getValueAt(j, 2).toString());
                for(int i=0; i<tablaProveedores.getRowCount(); i++){
                    int idTProveedor = Integer.parseInt(tablaProveedores.getValueAt(i, 0).toString());
                    if(idProveedor == idTProveedor){
                        nombreProveedor = tablaProveedores.getValueAt(i, 1).toString();
                        break;
                    }
                }

                //Obtiene el total del proveedor
                String total = "$" + consultaPedidos.getValueAt(j, 0).toString();

                //Agregar una nueva fila con los datos en 'tablaPedidos'
                tablaPedidos.addRow(new Object[] {id, fechaTexto, nombreProveedor, total});

                //Obtiene el estado y lo agrega a la tabla 'estadoTPedidos'
                estadoTPedidos.addRow(new Object[] {consultaPedidos.getValueAt(j, 4).toString()});
            }
        } catch (ParseException exception) {
            //Acción pendiente
            System.out.println("Imposible convertir la fecha");
        } catch (Exception exception){
            //Acción pendiente
            System.out.println(exception);
        }
    }

    //Consultar todos los pedidos
    public void obtenerPedidos(){
        DefaultTableModel consulta = modeloPedidos.selecTodos();
        construirNuevaTPedidos(consulta);
        actualizarTPedidos(tablaPedidos);
    }

    // Consultar pedidos con los filtros
    // En caso de querer descartar un campo se manda -1, a escepción del estado.
    // VALORES PERIODOS:
    //      0: Todos
    //      1: Hoy
    //      2: Esta semana
    //      3: Este mes
    //      4: Este año
    //
    public void obtenerPedidos_Filtros(int periodo, int idProveedor, int idEmpleado, int estado){
        
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
                    resaltado = new resaltarCampo(
                        pedidosVista.txtCantidad,
                        new Color(214, 181, 178),
                        2);
                    resaltado.start();

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
                        obtenerPedidos();
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