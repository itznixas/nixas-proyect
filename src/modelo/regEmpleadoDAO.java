package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import vista.ventanaLogin;

public class regEmpleadoDAO extends dataBase {

    dataBase con = new dataBase();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public List listarEmpleado() throws SQLException {
        String sql = "SELECT * FROM reg_empleado";
        List<regEmpleado> lista_empleado = new ArrayList<>();
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                regEmpleado emp = new regEmpleado() {
                };
                emp.setIdEmpl(rs.getInt("id_emple"));
                emp.setNombreEmpl(rs.getString("nom_emple"));
                emp.setApellidoEmpl(rs.getString("ape_emple"));
                emp.setCedulaEmpl(rs.getInt("ced_emple"));
                emp.setCelEmpl(rs.getInt("tele_emple"));
                emp.setUserEmpl(rs.getString("usuario"));
                emp.setClaveEmpl(rs.getString("clave"));
                emp.setIdRol(rs.getInt("rol"));
                lista_empleado.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
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
        return lista_empleado;
    }

    public int autenticacionRol(regEmpleado emp) {
        String sql = "SELECT reg_empleado.rol \n"
                + "FROM reg_empleado\n"
                + "INNER JOIN emple_rol ON reg_empleado.rol = emple_rol.id_rol WHERE usuario = ? AND clave = ? ";
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
                System.out.println(ex);
            }
        }
        return 0; // Si no se encuentra ninguna coincidencia
    }

    public List<regEmpleado> buscarCedEmpleado(regEmpleado empe) throws SQLException {
        List<regEmpleado> empleado = new ArrayList<>();
        String sql = "SELECT * FROM reg_empleado WHERE ced_emple = ?";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, empe.getCedulaEmpl());
            rs = ps.executeQuery();

            while (rs.next()) {
                regEmpleado emp = new regEmpleado() {
                };
                emp.setIdEmpl(rs.getInt("id_emple"));
                emp.setNombreEmpl(rs.getString("nom_emple"));
                emp.setApellidoEmpl(rs.getString("ape_emple"));
                emp.setCedulaEmpl(rs.getInt("ced_emple"));
                emp.setCelEmpl(rs.getInt("tele_emple"));
                emp.setUserEmpl(rs.getString("usuario"));
                emp.setClaveEmpl(rs.getString("clave"));
                emp.setIdRol(rs.getInt("rol"));
                empleado.add(emp);
            }
        } catch (SQLException e) {
            System.out.println(e);
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
        return empleado;
    }

    public List<regEmpleado> buscarNomEmpleado(regEmpleado empe) throws SQLException {
        List<regEmpleado> empleado = new ArrayList<>();
        String sql = "SELECT * FROM reg_empleado WHERE nom_emple = ?";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, empe.getNombreEmpl());
            rs = ps.executeQuery();

            while (rs.next()) {
                regEmpleado emp = new regEmpleado() {
                };
                emp.setIdEmpl(rs.getInt("id_emple"));
                emp.setNombreEmpl(rs.getString("nom_emple"));
                emp.setApellidoEmpl(rs.getString("ape_emple"));
                emp.setCedulaEmpl(rs.getInt("ced_emple"));
                emp.setCelEmpl(rs.getInt("tele_emple"));
                emp.setUserEmpl(rs.getString("usuario"));
                emp.setClaveEmpl(rs.getString("clave"));
                emp.setIdRol(rs.getInt("rol"));
                empleado.add(emp);
            }
        } catch (SQLException e) {
            System.out.println(e);
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
        return empleado;
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
                System.out.println(ex);
            }
        }
        return false; // Si no se encuentra ninguna coincidencia
    }

    //Metodo para agregar
    public int agregarEmpleado(regEmpleado emp) throws SQLException {
        int r = 1;
        String sql = "INSERT INTO reg_empleado (id_emple, nom_emple, ape_emple, ced_emple,tele_emple, usuario, clave, rol)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            // ps.setString(1, Integer.toString(emp.getIdEmpl()));
            ps.setString(2, emp.getNombreEmpl());
            ps.setString(3, emp.getApellidoEmpl());
            ps.setString(4, Integer.toString(emp.getCedulaEmpl()));
            ps.setString(5, Integer.toString(emp.getCelEmpl()));
            ps.setString(6, emp.getUserEmpl());
            ps.setString(7, emp.getClaveEmpl());
            ps.setString(8, Integer.toString(emp.getIdRol()));
            ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(e);
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
        return r;
    }

    //Metodo para actualizar registros
    public boolean actualizarEmpleado(regEmpleado emp) throws SQLException {

        String sql = "UPDATE reg_empleado SET nom_emple=?, ape_emple=?, ced_emple=?, tele_emple=?, usuario=?, clave=?, rol=? WHERE id_emple=?";

        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);

            ps.setString(1, emp.getNombreEmpl());  // Índice 1
            ps.setString(2, emp.getApellidoEmpl());  // Índice 2
            ps.setInt(3, emp.getCedulaEmpl());  // Índice 3
            ps.setInt(4, emp.getCelEmpl());  // Índice 4
            ps.setString(5, emp.getUserEmpl());  // Índice 5
            ps.setString(6, emp.getClaveEmpl());  // Índice 6
            ps.setInt(7, emp.getIdRol());  // Índice 7
            ps.setInt(8, emp.getIdEmpl());  // Índice 8 (id_emple)
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            // Cerrar recursos en orden inverso de apertura para evitar problemas
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    //Metodo para eliminar por documento del empleado
    public void eliminarEmpleado(regEmpleado empe) throws SQLException {
        String sql = "DELETE FROM reg_empleado WHERE ced_emple =?";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, empe.getCedulaEmpl());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
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
    }

    public void rol(JComboBox<String> rolCombo) throws SQLException {
        String sql = "SELECT  nom_rol FROM emple_rol";

        try {
            // Establecer conexión y preparar la consulta SQL
            Connection cn = con.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Limpiar el JComboBox antes de agregar elementos
            rolCombo.removeAllItems();

            // Recorrer el resultado y agregar elementos al JComboBox
            while (rs.next()) {
                rolCombo.addItem(rs.getString("nom_rol"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            // Cerrar recursos en el bloque finally
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
