/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class prodPlatosDAO {
    dataBase con = new dataBase();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
   public List <platoProducto> platos()  throws SQLException{
       List<platoProducto> listaPlato = new ArrayList<>();
       String sql = "SELECT id_platos, nombre, cantidad FROM prod_platos";
       try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                platoProducto plato = new platoProducto() {};
                plato.setId_plato(rs.getInt("id_platos"));
                plato.setNombreProd(rs.getString("nombre"));
                plato.setCantidad(0);
            }
       
       
       }catch (SQLException e) {
        System.out.println(e);
    } finally {
        // Cerrar recursos en orden inverso de apertura para evitar problemas
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (cn != null) {
            cn.close();
        }
    }
    
        return null;
       
   }
    
}
