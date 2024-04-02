/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import java.time.LocalTime;

public class pedidosDAO {
    dataBase con = new dataBase();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    
   public void mesero(JComboBox<String> meseroCombo) throws SQLException {
    String sql = "SELECT re.id_emple\n" +
        "FROM reg_empleado re\n" +
        "INNER JOIN emple_rol er ON re.rol = er.id_rol\n" +
        "WHERE er.nom_rol = 'Mesero';";

    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        // Establecer conexión y preparar la consulta SQL
        cn = con.getConnection();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();

        // Limpiar el JComboBox antes de agregar elementos
        meseroCombo.removeAllItems();

        // Recorrer el resultado y agregar elementos al JComboBox
        while (rs.next()) {
            meseroCombo.addItem(rs.getString("id_emple")); // Cambiado a "id_emple" que es la columna correcta
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    } finally {
        // Cerrar recursos en el bloque finally
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}

    public int agregarPedidos(tmpPedidos pro){
           int r = 1;
           String sql = "INSERT INTO tmp_pedidos (mesa, mesero, producto, cantidad, estado, hora) VALUES (?, ?, ?, ?, ?, strftime('%Y-%m-%d %H:%M:%S', 'now'))";
       try{
          
           cn = con.getConnection();
           ps = cn.prepareStatement(sql);
           ps.setString(2, Integer.toString(pro.getIdMesas()));
           ps.setString(3, Integer.toString(pro.getMesero()));
           ps.setString(4, pro.getProducto());
           ps.setString(5, Integer.toString(pro.getCantidad()));
           ps.setString(6, "PEDIENTE");
           ps.setString(7, LocalTime.now().toString());
           ps.executeUpdate();
       if(r == 1){
           return 1;
       }else{
           return 0;
       }
       }catch (SQLException e){
           System.out.println("Error al agregar la porcion " + e.getMessage());
           return 0;
       }finally{
            try {
               if (ps != null) {
                   ps.close();
                   }
                       if (cn != null) {
                           cn.close();
                       }
                   } catch (SQLException ex) {
                       ex.printStackTrace(); // Manejar cualquier excepción al cerrar recursos
                   }
       }
       }

}
