package DeMar.src.Insumos;

import javax.swing.table.DefaultTableModel;

import DeMar.src.Modelo;

public class InsumosModelo extends Modelo {
    // CONSTRUCTORES
    public InsumosModelo() {
        super();
    }
    public InsumosModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public InsumosModelo(InsumosModelo insumosModelo) {
        super(insumosModelo);
    }

    // CONSULTAS
    public DefaultTableModel selecInsumos() {
        String consulta = "CALL selecInsumos()";
        return consultaSeleccion(consulta);
    }

    public DefaultTableModel filProveedores() {
        String consulta = "CALL filProveedores();";
        return consultaSeleccion(consulta);
    }

    public DefaultTableModel idProveedor(String nomProveedor) {
        String consulta = "CALL idProveedor('"+nomProveedor+"');";
        return consultaSeleccion(consulta);
    }

    // AGREGAR INSUMOS
    public boolean registrar(String nombre, String proveedor, String precio) {
        String consulta = "CALL agregarInsumos('"+nombre+"','"+proveedor+"','"+precio+"');";
        return consultaPersistencia(consulta);
    }

    // MODIFICAR INSUMO
    public boolean modificar(String folio, String nombre, String proveedor, String precio) {
        String consulta = "CALL modificarInsumo('"+folio+"','"+nombre+"','"+proveedor+"','"+precio+"');";
        return consultaPersistencia(consulta);
    }

    // ELIMINAR INSUMO
    public boolean eliminar(String folio) {
        String consulta = "CALL eliminarInsumo('"+folio+"');";
        return consultaPersistencia(consulta);
    }
}
