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

    // AGREGAR
    // Agregar una nueva áreas
    /* PENDIENTE */

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
}