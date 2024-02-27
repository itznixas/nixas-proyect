
package modelo;
import java.sql.*;
import java.util.*;


public class dataManager extends dataBase{
    private Connection conexion;
    private Statement consulta;
    private ResultSet resultado;
    
    
    
    public dataManager() {
        super();
    }
    
    public void ejecutarConsulta(String sql) throws SQLException{
        super.conectar();
        this.conexion = super.getConexion();
        consulta = conexion.createStatement();
        consulta.execute(sql);
        super.cerrar();
    }
    
    public ResultSet obtenerDatos (String sql) throws SQLException{
        super.conectar();
        this.consulta = conexion.createStatement();
        this.resultado = consulta.executeQuery(sql);
        return this.resultado;
    }
    
    
    //esta funcion devuelve datos tipo lista 
    public List<Object> resultado (String sql) throws SQLException{
    List<Object> retorno = new java.util.ArrayList<>();
    super.conectar();
    this.consulta = this.conexion.createStatement();
    this.resultado = this.consulta.executeQuery(sql);
    if (this.resultado.next()){
        for(int i = 1; i <= this.resultado.getMetaData().getColumnCount(); i++){
            retorno.add(this.resultado.getObject(i));
        }
    }
    super.cerrar();
    return retorno;
}
    
    
    @Override
    public void cerrar() throws SQLException{
         if(!this.conexion.isClosed()){
            this.conexion.close();
        }
    }
    
    
}
