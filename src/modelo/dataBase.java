package modelo;
import java.sql.*;

public class dataBase {
    
    Connection con;

    public dataBase() {
    
    }

    public dataBase(Connection con) {
        this.con = con;
    }
    
    public Connection getConnection(){
        try {
            String url = "jdbc:sqlite:C:\\SQLite\\sena.db";
            con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
        }
        
        return null;
    }
    
    
}
