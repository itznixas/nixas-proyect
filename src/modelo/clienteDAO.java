
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.dataBase;
import modelo.regEmpleado;
import vista.ventanaLogin;

public class clienteDAO extends dataBase{
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
               regEmpleado clin = new regEmpleado();
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


            public int agregarCliente(regEmpleado cli){
            String sql = "INSERT INTO reg_clientes (nom_cli, ape_cli, ced_cli, telef, direccion) VALUES (?,?,?,?,?)";

            try{
                cn = con.getConnection();
                ps = cn.prepareStatement(sql);
                ps.setString(1, cli.getNombreEmpl());
                ps.setString(2, cli.getApellidoEmpl());
                ps.setInt(3, cli.getCedulaEmpl()); // Utilizar setInt para el número de cédula
                ps.setInt(4, cli.getCelEmpl()); // Utilizar setInt para el teléfono
                ps.setString(5, cli.getDireccion());

                int r = ps.executeUpdate(); // Ejecutar la actualización

                if (r > 0){ // Verificar si se insertaron filas correctamente
                    return 1; // Éxito
                } else {
                    return 0; // Falla
                }
            } catch (SQLException e){
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

         public int actualizarCliente (regEmpleado cli){
             int r= 1;
             String sql = "UPDATE reg_cliente SET  nom_cli=?, ape_cli=?, ced_cli=?"
                     + " direccion=?, telef=? WHERE ced_cli";
          try{
                 cn = con.getConnection();
                 ps = cn.prepareStatement(sql);
                 ps.setString(1, cli.getNombreEmpl());
                 ps.setString(2, cli.getApellidoEmpl());
                 ps.setString(3, Integer.toString(cli.getCedulaEmpl()));
                 ps.setString(4, Integer.toString(cli.getCelEmpl()));
                 ps.setString(5, cli.getDireccion());
                 ps.executeUpdate();
                 if (r == 1){
                     return 1;
                 }else{
                     return 0;
                 }
             }catch (SQLException e){
                 System.out.println("e");
             }
         return r;
         }
         
              //Metodo para eliminar por documento del cliente
                public void eliminarCliente(int doc){
                    String sql = "DELETE FROM reg_cliente WHERE ced_cli =?"+doc;
                    try{
                        cn = con.getConnection();
                        ps = cn.prepareStatement(sql);
                        ps.executeUpdate();
                    } catch (SQLException e){
                        System.out.println(e);
                    }
                }



}


