package modelo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import vista.MenuAdmin;

/**
 *
 * @author Royer
 */
public class inventarioDAO {

         dataBase con = new dataBase();
         Connection cn;
         PreparedStatement ps;
         ResultSet rs;
         MenuAdmin admin = new MenuAdmin();
        public int agregarPedidoEntrada(inventario inv) throws SQLException {
    String sql = "INSERT INTO iv_prod_ent (nombre, cantidad, fecha) VALUES (?, ?, ?)";
    try {
        cn = con.getConnection();
        ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, inv.getNomEntrada());
        ps.setInt(2, inv.getCantEntrada());
        ps.setString(3, inv.getFechaInvEntrada());
        
        int r = ps.executeUpdate();
        if (r == 1) {
            // Obtener el ID generado para iv_prod_ent
            rs = ps.getGeneratedKeys();
            int idGenerado = -1;
            if (rs.next()) {
                idGenerado = rs.getInt(1);
                inv.setIdProEntrada(idGenerado);
            }
            System.out.println("ID generado para iv_prod_ent: " + idGenerado);
            return 1;
        } else {
            return 0;
        }
    } catch (SQLException e) {
        System.out.println("Error al agregar pedido de entrada " + e.getMessage());
        return 0;
    } finally {
        // Cerrar conexiones y recursos
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (cn != null) cn.close();
    }
}

         inventario inv = new inventario();
    public int agregarPedidoSal(inventario inv) throws SQLException {
        int r = 0;
        String sql = "INSERT INTO iv_prod_sal (id_prod_sal, nombre, cantidad, fecha)"
                + " VALUES (?, ?, ?, ?)";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(2, inv.getNomSalida());
            ps.setInt(3, inv.getCantSalida());
            ps.setString(4, inv.getFechaInvEntrada()); 
            ps.executeUpdate();
            r = 1; // Establecer r a 1 para indicar éxito
        } catch (SQLException e) {
            System.out.println("Error al agregar producto de salida " + e.getMessage());
        } finally {
            // Cerrar recursos
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        
        // Ejecutar la consulta para activar el trigger
        if (r == 1) {
            try {
                cn = con.getConnection();
                String sqlTrigger = "SELECT 1"; // Cualquier consulta válida para activar el trigger
                ps = cn.prepareStatement(sqlTrigger);
                ps.executeQuery();
            } catch (SQLException ex) {
                System.out.println("Error al ejecutar trigger: " + ex.getMessage());
                // Aquí puedes manejar el error según tu lógica de la aplicación
            } finally {
                // Cerrar recursos
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            }
        }

        return r;
    }
    
    public int agregarPedidoSalida(inventario inv) throws SQLException {
    String sql = "INSERT INTO iv_prod_sal (nombre, cantidad, fecha) VALUES (?, ?, ?)";
    try {
        cn = con.getConnection();
        ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, inv.getNomSalida());
        ps.setInt(2, inv.getCantSalida());
        ps.setString(3, inv.getFechaInvSalida());
        
        int r = ps.executeUpdate();
        if (r == 1) {
            // Obtener el ID generado para iv_prod_sal
            rs = ps.getGeneratedKeys();
            int idGenerado = -1;
            if (rs.next()) {
                idGenerado = rs.getInt(1);
                inv.setIdProSalida(idGenerado);
            }
            System.out.println("ID generado para iv_prod_sal: " + idGenerado);
            return 1;
        } else {
            return 0;
        }
    } catch (SQLException e) {
        System.out.println("Error al agregar pedido de salida " + e.getMessage());
        return 0;
    } finally {
        // Cerrar conexiones y recursos
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (cn != null) cn.close();
    }
}

   
    
    public int agregarInvetario(inventario inv) throws SQLException{
             int r = 0;
             String sql = "INSERT INTO iv_temp (id_iv_temp, nombre,cant_ent, cant_sal, fecha, iv_prod_sal_id_prod_sal,iv_prod_ent_id_prod_ent)"
                     + "VALUES (?, ?, ?, ?, ?, ?, ?)";
             try{
                cn = con.getConnection();
                ps = cn.prepareStatement(sql);
                ps.setString(2, inv.getNomSalida());
                ps.setInt(3, inv.getCantEntrada());
                ps.setInt(4, inv.getCantSalida());
                ps.setString(5,inv.getFechaInvSalida());
                ps.setInt(6, inv.getIdProSalida());
                ps.setInt(7, inv.getIdProEntrada());
                ps.executeUpdate();
                if(r == 1){
                        return 1;
                    }else{
                        return 0;
                    }
             }catch (SQLException e){
        System.out.println("Error al agregar" + e.getMessage());
        return 0;
    }         
         }
    
    public boolean productoExiste(inventario in) throws SQLException {
        String sql = "SELECT nombre FROM iv_prod_ent WHERE nombre = ?";
        try (Connection cn = con.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, in.getNomSalida());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nombree = rs.getString("nombre");
                    return in.getNomSalida().equalsIgnoreCase(nombree); // Verificar si el estado es "Listo"
                } else {
                    // El pedido no fue encontrado en la base de datos
                    return false;
                }
            }
        }
    }
    
    public boolean existeNombreEnInventario(inventario in) throws SQLException {
    String sql = "SELECT nombre, id_prod_ent FROM iv_prod_ent WHERE nombre=?";
    try (Connection cn = con.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, in.getNomSalida());
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String nombreEnDB = rs.getString("nombre");
                // Verificar si el nombre obtenido de la base de datos es igual al nombre proporcionado (ignorando mayúsculas y minúsculas)
                return in.getNomSalida().equalsIgnoreCase(nombreEnDB);
            } else {
                return false;
            }
        }
    } catch (SQLException e) {
        // Manejar cualquier excepción de SQL
        e.printStackTrace();
        throw e; // Propagar la excepción hacia arriba
    }
}

    public List listaInventario()throws SQLException{
        String sql = "SELECT * FROM iv_temp";
        List<inventario> lista_inventario = new ArrayList<>();
        try{
             cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                inventario inv = new inventario();
                inv.setIdIvTmp(rs.getInt("id_iv_temp"));
                inv.setNomSalida(rs.getString("nombre"));
                inv.setCantEntrada(rs.getInt("cant_ent"));
                inv.setCantSalida(rs.getInt("cant_sal"));
                inv.setFechaInvSalida(rs.getString("fecha"));
                inv.setIdProSalida(rs.getInt("iv_prod_sal_id_prod_sal"));
                inv.setIdProEntrada(rs.getInt("iv_prod_ent_id_prod_ent"));
                lista_inventario.add(inv);
            }
            }catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        return lista_inventario;
    }
    
   public void agregarProductos(String nombre, int cantidad) {
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        cn = con.getConnection();
        // Verificar si el producto ya existe en la tabla iv_prod_ent
        PreparedStatement selectStatement = cn.prepareStatement("SELECT * FROM iv_prod_ent WHERE nombre = ?");
        selectStatement.setString(1, nombre);
        ResultSet resultSet = selectStatement.executeQuery();
        
        if (resultSet.next()) {
            // Si el producto ya existe, actualizar la cantidad y la fecha
            int cantidadExistente = resultSet.getInt("cantidad");
            int nuevaCantidad = cantidadExistente + cantidad;
            
            Timestamp fechaActualizacion = new Timestamp(System.currentTimeMillis());
            String fechaActualizacionStr = new SimpleDateFormat("dd/MM/yyyy").format(fechaActualizacion);
            
            PreparedStatement updateStatement = cn.prepareStatement(
                    "UPDATE iv_prod_ent SET cantidad = ?, fecha = ? WHERE nombre = ?");
            updateStatement.setInt(1, nuevaCantidad);
            updateStatement.setString(2, fechaActualizacionStr);
            updateStatement.setString(3, nombre);
            updateStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(admin, "Se ha actualizado la cantidad y la fecha del producto en el inventario.");
        } else {
            // Si el producto no existe, insertarlo en la tabla iv_prod_ent
            Timestamp fechaInsercion = new Timestamp(System.currentTimeMillis());
            String fechaInsercionStr = new SimpleDateFormat("dd/MM/yyyy").format(fechaInsercion);
            
            PreparedStatement insertStatement = cn.prepareStatement(
                    "INSERT INTO iv_prod_ent (nombre, cantidad, fecha) VALUES (?, ?, ?)");
            insertStatement.setString(1, nombre);
            insertStatement.setInt(2, cantidad);
            insertStatement.setString(3, fechaInsercionStr);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(admin, "Producto agregado correctamente al inventario.");
        }
    } catch (SQLException e) {
        System.err.println("Error al agregar o actualizar el producto en el inventario: " + e.getMessage());
    } finally {
        // Cerrar recursos en orden inverso de apertura para evitar problemas
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
            System.err.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}


}
