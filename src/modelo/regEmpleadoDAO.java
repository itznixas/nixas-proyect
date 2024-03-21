
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import vista.ventanaLogin;

public class regEmpleadoDAO extends dataBase {
         dataBase con = new dataBase();
         Connection cn;
         PreparedStatement ps;
         ResultSet rs;
         
         public List listarEmpleado() throws SQLException{
             String sql ="SELECT * FROM reg_empleado";
             List<regEmpleado> lista_empleado = new ArrayList<>();
             try{
                 cn = con.getConnection();
                 ps = cn.prepareStatement(sql);
                 rs = ps.executeQuery();
                 while(rs.next()){
                     regEmpleado emp = new regEmpleado();
                     emp.setIdEmpl(rs.getInt(1));
                     emp.setNombreEmpl(rs.getString(2));
                     emp.setApellidoEmpl(rs.getString(3));
                     emp.setCedulaEmpl(rs.getInt(4));
                     emp.setCelEmpl(rs.getInt(5));
                     emp.setUserEmpl(rs.getString(6));
                     emp.setClaveEmpl(rs.getString(7));
                     emp.setIdRol(rs.getInt(8));
                     lista_empleado.add(emp);
                 }
                }catch (SQLException e){
                         System.out.println("e");
                 }
             return lista_empleado;
         }
         
         public int autenticacionRol(regEmpleado emp){
            String sql = "SELECT reg_empleado.rol \n" +
                        "FROM reg_empleado\n" +
                        "INNER JOIN emple_rol ON reg_empleado.rol = emple_rol.id_rol WHERE usuario = ? AND clave = ? "; 
            try {
                    cn = con.getConnection();
                    ps = cn.prepareStatement(sql);
                    // Establecer los parámetros de la consulta
                    ps.setString(1, emp.getUserEmpl());
                    ps.setString(2, emp.getClaveEmpl());
                    
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        return rs.getInt("rol");
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                } finally {
                    // Cerrar la conexión y los recursos relacionados
                    try {
                        if (rs != null) rs.close();
                        if (ps != null) ps.close();
                        if (cn != null) cn.close();
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
                return 0; // Si no se encuentra ninguna coincidencia
            }
         
         
         
         public boolean autenticacion(regEmpleado emp) {
    String sql = "SELECT * FROM reg_empleado WHERE usuario = ? AND clave = ?";
    try {
        cn = con.getConnection();
        ps = cn.prepareStatement(sql);
        // Establecer los parámetros de la consulta
        ps.setString(1, emp.getUserEmpl());
        ps.setString(2, emp.getClaveEmpl());
        rs = ps.executeQuery();
        if (rs.next()) { // Si se encuentra una coincidencia
            return true;
        }
    } catch (SQLException e) {
        System.out.println(e);
    } finally {
        // Cerrar la conexión y los recursos relacionados
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    return false; // Si no se encuentra ninguna coincidencia
}


         
         //Metodo para agregar
         public int agregarEmpleado(regEmpleado emp){
             int r = 1;
             String sql = "INSERT INTO reg_empleado (id_emple, nom_emple, ape_emple, ced_emple,tele_emple, usuario, clave, rol)"
                     + "VALUES (?,?,?,?,?,?,?,?)";
             try{
                 cn = con.getConnection();
                 ps = cn.prepareStatement(sql);
                // ps.setString(1, Integer.toString(emp.getIdEmpl()));
                 ps.setString(2, emp.getNombreEmpl());
                 ps.setString(3, emp.getApellidoEmpl());
                 ps.setString(4, Integer.toString(emp.getCedulaEmpl()));
                 ps.setString(5, Integer.toString(emp.getCelEmpl()));
                 ps.setString(6, emp.getUserEmpl());
                 ps.setString(7, emp.getClaveEmpl());
                 ps.setString(8,Integer.toString(emp.getIdRol()));
                 ps.executeUpdate();
                 if (r == 1){
                 return 1;
             }else{
                     return 0;
                 }
             }catch (SQLException e){
                 System.out.println(e);
             }
             return r;
         }
         
         //Metodo para actualizar registros
                public int actualizarEmpleado(regEmpleado emp){
                    int r = 1;
                    String sql = "UPDATE reg_empleado SET id_emple=?, nom_emple=?,"
                            + " ape_emple=? ,tele_emple=?, usuario=?, clave=?, rol=? WHERE ced_emple=?";
                try{
                    cn = con.getConnection();
                    ps = cn.prepareStatement(sql);
                    ps.setString(1, Integer.toString(emp.getIdEmpl()));
                    ps.setString(2, emp.getNombreEmpl());
                    ps.setString(3, emp.getApellidoEmpl());
                    ps.setString(4, Integer.toString(emp.getCedulaEmpl()));
                   ps.setString(5, Integer.toString(emp.getCelEmpl()));
                    ps.setString(6, emp.getUserEmpl());
                    ps.setString(7, emp.getClaveEmpl());
                    ps.setString(8,Integer.toString(emp.getIdRol()));
                    ps.executeUpdate();
                    if(r == 1){
                        return 1;
                    }else{
                        return 0;
                    }
                }catch (SQLException e){
                    System.out.println(e);
                }
                return r;
                }
                
                
                //Metodo para eliminar por documento del empleado
                public void eliminarEmpleado(int doc){
                    String sql = "DELETE FROM reg_empleado WHERE ced_emple =?"+doc;
                    try{
                        cn = con.getConnection();
                        ps = cn.prepareStatement(sql);
                        ps.executeUpdate();
                    } catch (SQLException e){
                        System.out.println(e);
                    }
                }
                
                
         public ArrayList<regEmpleado> obtenerRoles() {
                ArrayList<regEmpleado> listaR = new ArrayList<>();

               String sql = "SELECT id_rol, nom_rol FROM emple_rol";

               try (Connection conex = con.getConnection();
                    PreparedStatement ps = conex.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery()) {

                   while(rs.next()){
                       regEmpleado em = new regEmpleado();
                       em.setIdRol((rs.getInt("id_rol")));
                       em.setNombreRol((rs.getString("nom_rol")));
                       listaR.add(em);
                       System.out.println("Roles encontrados");
                   }

                   System.out.println("Roles listados");
               } catch (SQLException e) {
                   e.printStackTrace();
               }
               return listaR;
           }
                
}


    
    
     

    

