package DeMar.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo {
    protected String ip;
    protected String puerto;
    protected String baseDatos;
    protected String usuario;
    protected String contraseña;
    protected Connection conexion;
    
    public Modelo(){
        this.ip = "localhost";
        this.puerto = "3306";
        this.baseDatos = "demar";
        this.usuario = "root";
        this.contraseña = "";
    }
    public Modelo(String ip, String puerto, String baseDatos, String usuario, String contraseña){
        this.ip = ip;
        this.puerto = puerto;
        this.baseDatos = baseDatos;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    public Modelo(Modelo modelo){
        this.ip = modelo.ip;
        this.puerto = modelo.puerto;
        this.baseDatos = modelo.baseDatos;
        this.usuario = modelo.usuario;
        this.contraseña = modelo.contraseña;
    }
    
    //ENCAPSULAMIENTO (Solo SETs)
    public void setIp(String ip) {
        this.ip = ip;
    }
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    //INICIA LA CONEXIÓN CON LA BASE DE DATOS
    public boolean establecerConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://" + this.ip + ":" + this.puerto + "/" + this.baseDatos,
                    usuario,
                    contraseña);

            return true;
        }
        catch(ClassNotFoundException e){
            return false;
        }
        catch(SQLException e) {
            return false;
        }
    }    
    
    //CIERRA LA CONEXIÓN CON LA BASE DE DATOS
    public void finalizarConexion(){
        if(conexion != null){
            try{
                conexion.close();
            }
            catch(SQLException e){
                //IGNORAR
            }
        }
    }
    
    //CONSTRUCCIÓN DE LA TABLA
    //con los metadatos resultantes de la ejecución de un SELECT.
    public DefaultTableModel modelarTabla(ResultSet resultado) throws SQLException{
        ResultSetMetaData metaData = resultado.getMetaData(); //Obtiene los metadatos.
        int columnas = metaData.getColumnCount(); //Obtiene el numero de columnas.
        DefaultTableModel tabla = new DefaultTableModel(); //Se crea e inicializa la tabla.
        
        //CONSTRUCCIÓN
        //Se le agregan las columnas
        for(int i = 1; i <= columnas; i++){
            tabla.addColumn(metaData.getColumnName(i));
        }
        //Se le agregan las filas
        while(resultado.next()){
            Object[] fila = new Object[columnas];
            for(int i = 0; i < columnas; i++){
                fila[i] = resultado.getObject(i + 1);
            }
            tabla.addRow(fila);
        }
        return tabla;
    }
    
    //Metodo general para realizar CONSULTAS DE SELECCIÓN.
    //Solo es necesario recibir la consulta.
    public DefaultTableModel consultaSeleccion(String consulta){
        try{
            this.establecerConexion();
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            return modelarTabla(rs);
        }catch(SQLException e){
            return null;
        }finally{
            this.finalizarConexion();
        }
    }
}