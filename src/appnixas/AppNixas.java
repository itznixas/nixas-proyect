
package appnixas;

import java.sql.SQLException;
import modelo.dataBase;
import vista.*;
import controlador.*;


public class AppNixas {

 
    public static void main(String[] args) throws SQLException {
      
        
        
        //Prueba de conexion
        dataBase db = new dataBase();
        db.getConnection();
       

        
        
    }
    
}
