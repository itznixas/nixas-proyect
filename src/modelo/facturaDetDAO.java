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
        
        public int registrarVenta(facturaDetallee fac){
            int r=0;
            String sql = "INSERT INTO fact_detalle (id_det_fact, num_fact, producto, cant_prod, prec_unit, total)"
                    + "VALUES (?,?,?,?,?,?)";
            try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);   
            ps.setInt(2, fac.getIdDetFact());
            ps.setString(3, fac.getProducto());
            ps.setInt(4, fac.getCantProd());
            ps.setFloat(5, fac.getPredUnitario());
            ps.setFloat(6, fac.getTotal());
            ps.executeUpdate();
                if(r == 1){
                    return 1;
                }else{
                    return 0;
                }
            }catch(SQLException e){
                System.out.println(e.toString());
            }
            return r;
        }
        
}
