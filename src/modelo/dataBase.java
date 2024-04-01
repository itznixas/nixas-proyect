package modelo;

import java.sql.*;

public class dataBase {

    private Connection con;

    public dataBase() {
        this.con = getConnection();
    }

    public Connection getConnection() {
        try {
            String url = "jdbc:sqlite:nixas.db";
            con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
        }
        return null;
    }
}
