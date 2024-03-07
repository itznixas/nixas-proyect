
package modelo;

import java.sql.*;
import java.util.ArrayList;
import modelo.regEmpleado;


public class empleadoRolDAO extends dataBase{
            Connection cn = getConexion();
          dataBase con = new dataBase();
          ResultSet rs;
          Statement st;
          
    public ArrayList<empleadoRol> ObtenerRol() throws SQLException{
         ArrayList<empleadoRol> lista_rol = new ArrayList<>();
         try{
             String consulta = "SELECT * FROM  emple_rol";
             
             st = cn.createStatement();
             rs = st.executeQuery(consulta);
             while (rs.next()){
                 regEmpleado rolE = new regEmpleado();
                 rolE.setIdRol(rs.getInt("id_rol"));
                 rolE.setNombreRol(rs.getString("nom_rol"));
         }
             System.out.println("Rol obtenido");
     }catch (SQLException e){
             System.out.println("Error al buscar categorias"+e);
     }finally{
             try{
                 cn.close();
             }catch(SQLException e){
                 System.err.println(e);
             }
         }
         return lista_rol;
    }
    
    public void registraRol (empleadoRol rolE) throws SQLException{
         try{
             PreparedStatement ps= cn.prepareStatement
        ("INSERT INTO emple_rol (id_rol, nom_rol) VALUES (?,?)");
             ps.setInt(1, rolE.getIdRol());
             ps.setString(2, rolE.getNombreRol());
             
             ps.execute();
         System.out.println("Registro exitoso del rol");
       
         }catch(SQLException e){
            System.out.println("Error con el registo del rol"+e);
     }finally{
             try{
                 cn.close();
             }catch(SQLException e){
                 System.err.println(e);
             }
         }
    }
         
      public void modificarRol(empleadoRol rolE) throws SQLException{
        PreparedStatement ps = null;
       
        String sql = "UPDATE  emple_rol SET id_rol=?, nom_rol=? VALUES id_rol ";

        try{
            ps = cn.prepareStatement(sql);
            ps.setInt(1, rolE.getIdRol());
            ps.setString(2, rolE.getNombreRol());
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
        
    public void eliminarRol (empleadoRol rolE) throws SQLException{
        
        PreparedStatement ps = null;
        String sql = "DELETE FROM  emple_rol WHERE id_rol=? ";
        
        try{
            ps = cn.prepareStatement(sql);
            ps.setInt(1, rolE.getIdRol());
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


      
      
         
         
   