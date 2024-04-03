package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class pedidosDAO {

    dataBase con = new dataBase();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public void mesero(JComboBox<String> meseroCombo) throws SQLException {
        String sql = "SELECT re.id_emple\n"
                + "FROM reg_empleado re\n"
                + "INNER JOIN emple_rol er ON re.rol = er.id_rol\n"
                + "WHERE er.nom_rol = 'Mesero';";

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

    public int agregarPedidos(tmpPedidos pro, String est) {
        int r = 1;
        String sql = "INSERT INTO tmp_pedidos (mesa, mesero, producto, cantidad, estado, hora) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, Integer.toString(pro.getIdMesas())); // Índice 1 para mesa
            ps.setString(2, Integer.toString(pro.getMesero())); // Índice 2 para mesero
            ps.setString(3, pro.getProducto()); // Índice 3 para producto
            ps.setString(4, Integer.toString(pro.getCantidad())); // Índice 4 para cantidad
            ps.setString(5, est); // Índice 5 para estado
            ps.setString(6, pro.getHora()); // Índice 6 para hora
            ps.executeUpdate();
            return r; // Devolver 1 si se ejecuta correctamente
        } catch (SQLException e) {
            System.out.println("Error al agregar la porcion " + e.getMessage());
            return 0; // Devolver 0 en caso de error
        } finally {
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

    public List<tmpPedidos> listaPedidoPendiente() throws SQLException {
        String sql = "SELECT * FROM tmp_pedidos";
        List<tmpPedidos> lista_pedi = new ArrayList<>();
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                tmpPedidos ped = new tmpPedidos() {
                };
                ped.setIdPedidos(rs.getInt("id_pedidos"));
                ped.setIdMesas(rs.getInt("mesa"));
                ped.setMesero(rs.getInt("mesero"));
                ped.setProducto(rs.getString("producto"));
                ped.setCantidad(rs.getInt("cantidad"));
                ped.setEstado(rs.getString("estado"));
                ped.setHora(rs.getString("hora"));
                // Obtener la cadena de tiempo como String desde la base de datos

                // Convertir la cadena de tiempo a LocalTime con milisegundos
                lista_pedi.add(ped);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        // Return the list of pending orders
        return lista_pedi;
    }

    public void eliminarPedidoPendie() throws SQLException {
        String sql = "DELETE FROM tmp_pedidos WHERE id_pedidos";
        try {
            tmpPedidos pt = new tmpPedidos() {
            };
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, pt.getIdPedidos());
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

    public boolean actualizarPedidoListo(tmpPedidos emp) throws SQLException {

        String sql = "UPDATE tmp_pedidos SET estado=? WHERE id_pedidos=?";

        try {
            cn = con.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, emp.getEstado());
            ps.setInt(2, emp.getIdPedidos());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    public boolean verificarEstadoListo(tmpPedidos pedido) throws SQLException {
        String sql = "SELECT estado FROM tmp_pedidos WHERE id_pedidos = ?";
        try (Connection cn = con.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, pedido.getIdPedidos());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String estadoActual = rs.getString("estado");
                    return "Listo".equalsIgnoreCase(estadoActual); // Verificar si el estado es "Listo"
                } else {
                    // El pedido no fue encontrado en la base de datos
                    return false;
                }
            }
        }
    }

}
