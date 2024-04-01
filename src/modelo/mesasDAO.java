package modelo;


import java.sql.*;
import java.util.ArrayList;


import java.util.List;

public class mesasDAO {
    dataBase con = new dataBase();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    private Connection connection;

    public mesasDAO(Connection connection) {
        this.connection = connection;
    }

    public mesasDAO() {

    }

    public void actualizarEstadoMesa(Connection connection, int idMesa, String ocupada) {
        String sql = "UPDATE reg_mesa SET estado = ? WHERE id_mesa = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, ocupada);
            pstmt.setInt(2, idMesa);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado de la mesa: " + e.getMessage());
        }
    }

    public void actualizarEstadoMesa(int idMesa, String libre) {
        String sql = "UPDATE reg_mesa SET estado = ? WHERE id_mesa = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, libre);
            pstmt.setInt(2, idMesa);
            pstmt.executeUpdate();
            System.out.println("Estado de la mesa " + idMesa + " actualizado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado de la mesa: " + e.getMessage());
        }
    }

    public boolean obtenerEstadoMesa(int idMesa) {
        String sql = "SELECT estado FROM reg_mesa WHERE id_mesa = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idMesa);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String estado = rs.getString("estado");
                    return estado.equals("Ocupado");
                } else {
                    // Si no se encontró la mesa con el ID especificado, se considera libre
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el estado de la mesa: " + e.getMessage());
        }
        // En caso de error, retornar false (por ejemplo, si no se puede conectar a la base de datos)
        return false;
    }

    
    public List<mesas> estadoMesas() throws SQLException {
    List<mesas> listMesas = new ArrayList<>();
    String sql = "SELECT id_mesa, estado FROM reg_mesa";
    try {
        cn = con.getConnection();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            mesas m = new mesas();
            m.setIdMesas(rs.getInt("id_mesa"));
            m.setEstadoMesa(rs.getString("estado"));
            listMesas.add(m);
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
    return listMesas;
}

}
