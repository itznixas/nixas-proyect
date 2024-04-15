package modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class facturaDAO {

    dataBase con = new dataBase();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public int facturar(factauraCabe fac) throws SQLException {
        int r = 0;
        String sql = "INSERT INTO fact_cabe (num_fact, id_cli, id_tipo_pago, id_mesero, id_cajero, descuento, iva, total, hora_fact, fecha_fact) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, fac.getIdCabFac());
            ps.setInt(2, fac.getIdCli());
            ps.setString(3, fac.getIdTipoPago());
            ps.setInt(4, fac.getIdMesero());
            ps.setInt(5, fac.getIdCajero());
            ps.setFloat(6, fac.getDescuento());
            ps.setFloat(7, fac.getIva());
            ps.setFloat(8, fac.getTotal());
            ps.setString(9, fac.getHoraFact());
            ps.setString(10, fac.getFechaFact());
            r = ps.executeUpdate();

            // Obtener el ID generado automáticamente (si es necesario)
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                // Haz lo que necesites con el ID generado (si es necesario)
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            // Cerrar recursos en orden inverso de apertura para evitar problemas
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return r;
    }

    public regEmpleado buscarDNIClien(Integer em) throws SQLException {
        regEmpleado emp = new accionEmple() {
        };
        String sql = "SELECT ced_cli,nom_cli,ape_cli FROM reg_clientes WHERE ced_cli=?";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, em);
            rs = ps.executeQuery();
            while (rs.next()) {
                // Si se encontró un cliente, establece la cédula en el objeto regEmpleado
                emp.setCedulaEmpl(rs.getInt("ced_cli"));
                emp.setNombreEmpl(rs.getString("nom_cli"));
                emp.setApellidoEmpl(rs.getString("ape_cli"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
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
        return emp; // Devolver si el cliente fue encontrado o no
    }

    public regEmpleado buscarDNIMese(Integer em) throws SQLException {
        regEmpleado emp = new regEmpleado() {
        }; // Crear una instancia de regEmpleado
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT nom_emple, ape_emple FROM reg_empleado WHERE ced_emple = ? AND rol = 333";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, em);
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Si se encontró un empleado, establecer nombre y apellido
                emp.setNombreEmpl(rs.getString("nom_emple"));
                emp.setApellidoEmpl(rs.getString("ape_emple"));
                emp.setCedulaEmpl(em); // Establecer la cédula del empleado
            } else {
                // Si no se encontró ningún empleado, establecer valores nulos
                emp = null;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
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
        return emp; // Devolver el empleado encontrado o null si no se encontró ninguno
    }

    public regEmpleado buscarDNIEmple(Integer em) throws SQLException {
        regEmpleado emp = new regEmpleado() {
        }; // Crear una instancia de regEmpleado
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT nom_emple, ape_emple FROM reg_empleado WHERE ced_emple = ? AND rol IN (111, 222)";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, em);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Si se encontró un empleado, establecer nombre y apellido
                emp.setNombreEmpl(rs.getString("nom_emple"));
                emp.setApellidoEmpl(rs.getString("ape_emple"));
                emp.setCedulaEmpl(em); // Establecer la cédula del empleado
            } else {
                // Si no se encontró ningún empleado, establecer valores nulos
                emp = null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Id incorrecto de empleado", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
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
        return emp; // Devolver el empleado encontrado o null si no se encontró ninguno
    }

    public boolean eliminarFacturaPorID(int idFactura) throws SQLException {
        String sql = "DELETE FROM tmp_pedidos WHERE id_pedidos = ?";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idFactura);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Devuelve true si se eliminó al menos una fila
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
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
}
