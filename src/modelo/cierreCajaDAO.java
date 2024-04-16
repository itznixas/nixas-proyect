/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Royer
 */
public class cierreCajaDAO {
    dataBase con = new dataBase();
         Connection cn;
         PreparedStatement ps;
         ResultSet rs;
         
         public int agregarCierre (cierreCaja cj) throws SQLException{
             int r = 0;
             String sql = "INSERT INTO aud_cierre_caja (id_cierre_caja, usuario, saldo_inicio, "
                     + "entrada, caja, valor_actual, hora_cierre, fecha_cierre) VALUES"
                     + "(?,?,?,?,?,?,?,?)";
             try{
                 cn = con.getConnection();
                 ps = cn.prepareStatement(sql);
                 
                 ps.setInt(2, cj.getIdCaja());
                 ps.setString(3, cj.getUserEmpl());
                 ps.setFloat(4, cj.getSaldoInicio());
                 ps.setFloat(4, cj.getEntrada());
                 ps.setFloat(4, cj.getCaja());
                 ps.setFloat(4, cj.getValorActual());
                 ps.setString(4, cj.getHoraCierre());
                 ps.setString(4, cj.getFechaCierre());
                 ps.executeUpdate();
                 if(r == 1){
                     return 1;
                 }else{
                     return 0;
                 }                
             }catch (SQLException e){
        System.out.println("Error al agregar caja" + e.getMessage());
    } finally{
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
             return r;
}
         
         

}