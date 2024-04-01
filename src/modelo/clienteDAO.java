package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.dataBase;
import modelo.regEmpleado;
import vista.ventanaLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class clienteDAO extends dataBase {

    dataBase con = new dataBase();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public List<regEmpleado> listarCliente() throws SQLException {
        String sql = "SELECT * FROM reg_clientes";
        List<regEmpleado> lista_cliente = new ArrayList<>();

        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                regEmpleado clin = new regEmpleado(){};
                clin.setIdEmpl(rs.getInt("id_cliente")); // Obtener el ID directamente desde la base de datos
                clin.setNombreEmpl(rs.getString("nom_cli"));
                clin.setApellidoEmpl(rs.getString("ape_cli"));
                clin.setCedulaEmpl(rs.getInt("ced_cli"));
                clin.setDireccion(rs.getString("direccion"));
                clin.setCelEmpl(rs.getInt("telef"));
                lista_cliente.add(clin);
            }
        } catch (SQLException e) {
            System.out.println(lista_cliente);
            System.out.println("Error al listar clientes: " + e.getMessage());
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
        return lista_cliente;
    }
    
     public List<regEmpleado> buscarCedCliente (regEmpleado empe) throws SQLException{
            List<regEmpleado> cliente = new ArrayList<>();
            String sql = "SELECT * FROM reg_clientes WHERE ced_cli = ?";
            try{
               cn = con.getConnection();
               ps = cn.prepareStatement(sql);
               ps.setInt(1, empe.getCedulaEmpl());
               rs = ps.executeQuery();
               
               while (rs.next()){
                   regEmpleado cli = new regEmpleado(){};
                     cli.setIdEmpl(rs.getInt("id_cliente"));
                     cli.setNombreEmpl(rs.getString("nom_cli"));
                     cli.setApellidoEmpl(rs.getString("ape_cli"));
                     cli.setCedulaEmpl(rs.getInt("ced_cli"));
                     cli.setDireccion(rs.getString("direccion"));
                     cli.setCelEmpl(rs.getInt("telef"));
                     cliente.add(cli);
               }
            }catch (SQLException e){
                System.out.println(e);
            }finally {
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
            return cliente;
        }
     
      public List<regEmpleado> buscarNomCliente (regEmpleado empe) throws SQLException{
             List<regEmpleado> cliente = new ArrayList<>();
            String sql = "SELECT * FROM reg_clientes WHERE nom_cli = ?";
            try{
               cn = con.getConnection();
               ps = cn.prepareStatement(sql);
               ps.setString(1, empe.getNombreEmpl());
               rs = ps.executeQuery();
               
               while (rs.next()){
                   regEmpleado cli = new regEmpleado(){};
                     cli.setIdEmpl(rs.getInt("id_cliente"));
                     cli.setNombreEmpl(rs.getString("nom_cli"));
                     cli.setApellidoEmpl(rs.getString("ape_cli"));
                     cli.setCedulaEmpl(rs.getInt("ced_cli"));
                     cli.setDireccion(rs.getString("direccion"));
                     cli.setCelEmpl(rs.getInt("telef"));
                     cliente.add(cli);
               }
            }catch (SQLException e){
                System.out.println(e);
            }finally {
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
            return cliente;
        }
    
    public int agregarCliente(regEmpleado cli) {
        String sql = "INSERT INTO reg_clientes (nom_cli, ape_cli, ced_cli,direccion, telef) VALUES (?,?,?,?,?)";

        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, cli.getNombreEmpl());
            ps.setString(2, cli.getApellidoEmpl());
            ps.setInt(3, cli.getCedulaEmpl()); // Utilizar setInt para el número de cédula
             ps.setString(4, cli.getDireccion());
            ps.setInt(5, cli.getCelEmpl()); // Utilizar setInt para el teléfono
           

            int r = ps.executeUpdate(); // Ejecutar la actualización

            if (r > 0) { // Verificar si se insertaron filas correctamente
                return 1; // Éxito
            } else {
                return 0; // Falla
            }
        } catch (SQLException e) {
            // Manejar la excepción adecuadamente, por ejemplo:
            e.printStackTrace(); // Imprimir la traza de la excepción para depuración
            return 0; // Indicar falla debido a la excepción
        } finally {
            // Cerrar recursos (ps y cn) en un bloque finally para asegurar su liberación
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

     public int actualizarCliente(regEmpleado emp) throws SQLException{
             int r = 1;
             String sql = "UPDATE reg_clientes SET  nom_cli=?,"
                    + " ape_cli=? ,ced_cli=?, direccion=?, telef=?,  WHERE ced_cli=?";
                try{
                    cn = con.getConnection();
                    ps = cn.prepareStatement(sql);               
                    ps.setString(2, emp.getNombreEmpl());
                    ps.setString(3, emp.getApellidoEmpl());
                    ps.setInt(4, emp.getCedulaEmpl());
                    ps.setString(6, emp.getDireccion());
                    ps.setInt(5, emp.getCelEmpl());
                    ps.executeUpdate();
                   if (r == 1){
                 return 1;
             }else{
                     return 0;
                 }
                }catch (SQLException e){
                    System.out.println(e);
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
                return r;
                }

    //Metodo para eliminar por documento del cliente
    public void eliminarCliente(regEmpleado cli) throws SQLException{
                    String sql = "DELETE FROM reg_clientes WHERE ced_cli =?";
                    try{
                        cn = con.getConnection();
                        ps = cn.prepareStatement(sql);
                        ps.setInt(1, cli.getCedulaEmpl());
                        ps.executeUpdate();
                    } catch (SQLException e){
                        System.out.println(e);
                    }finally {
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
                }

}
