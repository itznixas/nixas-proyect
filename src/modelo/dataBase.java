
package modelo;

import java.sql.Connection;
import java.sql.*;

public class dataBase {
   private String url;
   private String driver;
   private Connection conexion;
    
    public dataBase(){
        this.driver = "jdbc:sqlite";
        this.url = "data.db";
      
    }
    
    protected void conectar() throws SQLException{
         this.conexion =  DriverManager.getConnection(this.url);
        if (this.conexion.isClosed()){
            System.out.println("Conectado");
        }
    }

    protected void cerrar() throws SQLException{
        if(!this.conexion.isClosed()){
            this.conexion.close();
        }
    }
    
    protected Connection getConexion() {
        return conexion;
    }
}
