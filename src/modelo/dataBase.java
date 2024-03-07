package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dataBase {

    protected String url;
    protected String driver;
    protected Connection conexion;

    public dataBase() {
        this.driver = "jdbc:sqlite";
        this.url = "sena.db";
    }

    public void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (conexion != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
            Logger.getLogger(dataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public dataBase(Connection conexion) {
        this.conexion = conexion;
    }

    public void cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
