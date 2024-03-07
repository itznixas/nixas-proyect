
package modelo;

import java.sql.*;
import java.util.ArrayList;

public class regEmpleadoDAO extends dataBase {
          Connection cn = getConexion();
          dataBase con = new dataBase();
          ResultSet rs;
          Statement st;
  
      
     public ArrayList<regEmpleado> ObtenerEmpleado() throws SQLException{
         ArrayList<regEmpleado> lista_empleado = new ArrayList<>();
         try{
             String consulta = "SELECT * FROM reg_empleados ";
             
             st = cn.createStatement();
             rs = st.executeQuery(consulta);
             while (rs.next()){
                 regEmpleado regE = new regEmpleado();
                 regE.setIdEmpl(rs.getInt("id_emple"));
                 regE.setNombreEmpl(rs.getString("nom_emple"));
                 regE.setApellidoEmpl(rs.getString("ape_emple"));
                 regE.setCedulaEmpl(rs.getInt("ced_emple"));
                 regE.setCelEmpl(rs.getInt("tele_emple"));
                 regE.setUserEmpl(rs.getString("usuario"));
                 regE.setClaveEmpl(rs.getInt("clave"));
                 regE.setIdRol(rs.getInt("rol"));  
         }
             System.out.println("Empleado obtenido");
     }catch (SQLException e){
             System.out.println("Error al buscar categorias"+e);
     }finally{
             try{
                 cn.close();
             }catch(SQLException e){
                 System.err.println(e);
             }
         }
         return lista_empleado;
    }
     
     
     public void registraEmpleado (regEmpleado emp) throws SQLException{
         try{
             PreparedStatement ps= cn.prepareStatement
        ("INSERT INTO reg_empleados (id_emple, nom_emple, ape_emple, ced_emple, tele_emple, usuario, clave) VALUES (?,?,?,?,?,?,?,?)");
             ps.setInt(1, emp.getIdEmpl());
             ps.setString(2, emp.getNombreEmpl());
             ps.setString(3, emp.getApellidoEmpl());
             ps.setInt(4, emp.getCedulaEmpl());
             ps.setInt(5, emp.getCelEmpl());
             ps.setString(6, emp.getUserEmpl());
             ps.setInt(7, emp.getClaveEmpl());
             ps.setInt(8, emp.getIdRol());
             ps.execute();
         System.out.println("Registro exitoso del empleado");
       
         }catch(SQLException e){
            System.out.println("Error con el registo del empleado"+e);
     }finally{
             try{
                 cn.close();
             }catch(SQLException e){
                 System.err.println(e);
             }
         }   
}
  
     
       public void modificarEmpleado (regEmpleado emp) throws SQLException{
        
        PreparedStatement ps = null;
       
        String sql = "UPDATE  reg_empleados SET id_emple=?, nom_emple=?, ape_emple=?,"
                + " ced_emple=?, tele_empleado=?, dave=?, rol=?, usuario=? VALUES id_emple=?";
        
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(2, emp.getNombreEmpl());
            ps.setString(3, emp.getApellidoEmpl());
            ps.setInt(4, emp.getCedulaEmpl());
            ps.setInt(5, emp.getCelEmpl());
            ps.setInt(6, emp.getClaveEmpl());
            ps.setInt(7, emp.getIdRol());
            ps.setString(8, emp.getNombreRol());
            ps.setString(9, emp.getUserEmpl());
            ps.setInt(10, emp.getIdEmpl());
            ps.execute();
        }catch(SQLException e)
        {
             System.err.println(e);
        }finally{
            try{
            cn.close();
        }catch (SQLException e){
                System.err.println(e);
                }
        }
    }
       
        public void eliminar (regEmpleado emp) throws SQLException{
        
        PreparedStatement ps = null;
        String sql = "DELETE FROM  reg_empleados WHERE id_emple=? ";
        
        try{
            ps = cn.prepareStatement(sql);
            ps.setInt(1, emp.getIdEmpl());
        }catch(SQLException e)
        {
            System.err.println(e);  
        }finally{
            try{
            cn.close();
        }catch (SQLException e){
                 System.err.println(e);
                }
        }
    } 
    }
    
     

    

