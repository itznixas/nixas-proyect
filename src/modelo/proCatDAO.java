/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import javax.swing.JComboBox;


/**
 *
 * @author Royer
 */
public class proCatDAO {
             dataBase con = new dataBase();
         Connection cn;
         PreparedStatement ps;
         ResultSet rs;
         
         
         public void categoria( JComboBox categoria)throws SQLException{
             categoriaProd pr = new categoriaProd()  {};
             int r = 0;
             String sql = "SELECT cat_prod_nom FROM prod_cat ";
             try{
                 cn = con.getConnection();
                 ps = cn.prepareStatement(sql);
                 rs = ps.executeQuery();
                 while (rs.next()){
                     categoria.addItem(rs.getString("cat_prod_nom"));
                 }
             }catch (SQLException e){
                    System.out.println(e.toString());
                }finally {
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
         }
             
}
