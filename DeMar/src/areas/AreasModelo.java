package DeMar.src.areas;

import DeMar.src.Modelo;

import javax.swing.table.DefaultTableModel;

public class AreasModelo extends Modelo {
    // CONSTRUCTORES
    public AreasModelo() {
        super();
    }
    public AreasModelo(String ip, String puerto, String baseDatos, String usuario, String contraseña) {
        super(ip, puerto, baseDatos, usuario, contraseña);
    }
    public AreasModelo(AreasModelo areasModelo) {
        super(areasModelo);
    }

    // CONSULTAS
    // Seleccionar todad las áreas son excepciones
    public DefaultTableModel selTodos() {
        String consulta = "CALL seleccionarAreas();";
        return consultaSeleccion(consulta);
    }

    // Seleccionar un área con su ID
    public DefaultTableModel selID(int id) {
        String consulta = "CALL buscarUnArea('"+ id +"');";
        return consultaSeleccion(consulta);
    }

    // Agregar una nueva área
    public boolean registrar(String nombre, String insumo, int cEmpleados, float sBase, String hEntrada, String hSalida) {
        String consulta = "CALL agregarArea('"+nombre+"', '"+insumo+"','"+cEmpleados+"','"+sBase+"','"+hEntrada+"','"+hSalida+"')";
        return consultaPersistencia(consulta);
    }

    // Modificar áreas
    public boolean modificar(String nombre, String insumo, int cEmpleados, float sBase, String hEntrada, String hSalida, String auxNombre) {
        String consulta = "CALL modificarAreas('"+nombre+"','"+insumo+"','"+cEmpleados+"','"+sBase+"','"+hEntrada+"','"+hSalida+"', '"+auxNombre+"')";
        return consultaPersistencia(consulta);
    }

    // Eliminar un área con su nombre
    public boolean eliminar(String nombre) {
        String consulta = "CALL eliminarArea('"+nombre+"');";
        return consultaPersistencia(consulta);
    }
}