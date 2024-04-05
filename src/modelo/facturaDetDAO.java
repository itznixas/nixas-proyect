/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;



public class facturaDetDAO {
         dataBase con = new dataBase();
         Connection cn;
         PreparedStatement ps;
         ResultSet rs;
         
        public platoProducto BuscarPlato (String Nom){
            platoProducto pla = new platoProducto() {};
            String sql = "SELECT nombre, cantidad, precio FROM prod_platos WHERE id_platos=?";
            try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, Nom);
            rs = ps.executeQuery();
            if(rs.next()){
                pla.setNombreProd(rs.getString("nombre"));
                pla.setCantidad(rs.getInt("cantidad"));
                pla.setPrecio(rs.getFloat("precio"));
            }
            } catch(Exception e){
                System.out.println(e.toString());
            }
            return pla;
        }
}
