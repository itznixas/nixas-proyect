/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.dataBase;
import modelo.producto;
import vista.ventanaLogin;

public class bebidasDAO {
         dataBase con = new dataBase();
         Connection cn;
         PreparedStatement ps;
         ResultSet rs;
         
    public List<producto> listarBebidas()throws SQLException{
        String sql = "SELECT * FORM prod_bebidas";
        List<producto> lista_producto = new ArrayList<>();
    try{
        cn = con.getConnection();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
    
        while (rs.next()){
            producto prod = new producto() {};
            prod.setId_porciones(rs.getInt("id_porciones"));
            prod.setNombre(rs.getString("nombre"));
            prod.setCantidad(rs.getInt("cantidad"));
            prod.setPrecio(rs.getFloat("precio"));
            lista_producto.add(prod);
        }
    } catch (SQLException e){
        System.out.println("Error al listar bebidas" + e.getMessage());
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
    return lista_producto;
    } 
    
    public int agregarBebidas(producto pro){
        int r = 1;
        String sql = "INSERT INTO prod_bebidas (id_porciones, nombre, cantidad, precio)"
                + "VALUES (?,?,?,?)";
    try{
        cn = con.getConnection();
        ps = cn.prepareStatement(sql);
        ps.setString(2, pro.getNombre());
        ps.setString(3, Integer.toString(pro.getCantidad()));
        ps.setString(4, Float.toString(pro.getPrecio()));
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
    
    public int actualizarBebidas (producto pro){
        int r = 1;
        String sql = "UPDATE prod_bebidas SET nombre=?, cantidad=?, precio=? WHERE nombre";
    try{
        cn = con.getConnection();
        ps = cn.prepareStatement(sql);
        ps.setString(1, pro.getNombre());
        ps.setString(2,Integer.toString(pro.getCantidad()) );
        ps.setString(3, Float.toString(pro.getPrecio()));
        ps.executeUpdate();
        if(r==1){
            return 1;
        }else{
            return 0;
        }
    }catch (SQLException e){
        System.out.println("Error al actualizar " + e.getMessage());
    }
    return r;
    }
    
    public void eliminarBebidas(String nom){
        String sql = "DELETE FROM prod_bebidas WHERE nombre=?" + nom;
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.executeLargeUpdate();
        }catch (SQLException e){
            System.out.println("Error al eliminar " + e);
        }
    }
}
