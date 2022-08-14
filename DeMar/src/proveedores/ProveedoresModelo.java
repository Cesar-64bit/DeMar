package DeMar.src.proveedores;

import DeMar.src.Modelo;

import javax.swing.table.DefaultTableModel;

public class ProveedoresModelo extends Modelo {
    // CONSTRUCTORES
    public ProveedoresModelo() {
        super();
    }
    public ProveedoresModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public ProveedoresModelo(ProveedoresModelo proveedoresModelo) {
        super(proveedoresModelo);
    }

    // CONSULTAS
    // Seleccionar todos los proveedores estatus = 1
    public DefaultTableModel selecProveedoresActivos() {
        String consulta = "CALL selecProveedoresActivos();";
        return consultaSeleccion(consulta);
    }

     // Seleccionar un proveedor con un ID
     public DefaultTableModel selID(int id){ 
        String consulta = "CALL buscarUnProveedor('"+ id +"');";
        return consultaSeleccion(consulta);
    }

    // Agregar nuevos proveedores
    public boolean registrar(String nombre, String insumo, String telefono) {
        String consulta = "CALL agregarProveedor('"+nombre+"', '"+insumo+"', '"+telefono+"');";
        return consultaPersistencia(consulta);
    }

    // Modificación de proveedores
    public boolean modificar(String id, String nombre, String insumo, String telefono) {
        String consulta = "CALL modificarProveedores('"+id+"', '"+nombre+"', '"+insumo+"', '"+telefono+"');";
        return consultaPersistencia(consulta);
    }

    // Eliminación lógica de un proveedor
    public boolean eliminar(String id) {
        String consulta = "CALL eliminarProveedor('"+id+"');";
        return consultaPersistencia(consulta);
    }
}