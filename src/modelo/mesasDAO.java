package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

public class mesasDAO {

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

}
