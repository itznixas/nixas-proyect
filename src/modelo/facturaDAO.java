package modelo;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import vista.MenuAdmin;

public class facturaDAO {

    dataBase con = new dataBase();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    MenuAdmin admin = new MenuAdmin();

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
    
 public void guardarCantidadEnTemp(String ingrediente, int cantidadNecesaria) {
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        cn = con.getConnection();
        
        // Obtener el ID de iv_prod_ent para el ingrediente
        PreparedStatement selectEntStatement = cn.prepareStatement("SELECT id_prod_sal FROM iv_prod_sal WHERE nombre = ?");
        selectEntStatement.setString(1, ingrediente);
        ResultSet entResultSet = selectEntStatement.executeQuery();
        int idProdEnt = -1; // Valor predeterminado si no se encuentra el ingrediente en iv_prod_ent
        if (entResultSet.next()) {
            idProdEnt = entResultSet.getInt("id_prod_sal");
        }

        // Obtener el ID de iv_prod_sal para el ingrediente
        PreparedStatement selectSalStatement = cn.prepareStatement("SELECT id_prod_ent, cantidad FROM iv_prod_ent WHERE nombre = ?");
        selectSalStatement.setString(1, ingrediente);
        ResultSet salResultSet = selectSalStatement.executeQuery();
        int idProdSal = -1; // Valor predeterminado si no se encuentra el ingrediente en iv_prod_sal
        int cantidadSal = 0; // Valor predeterminado para la cantidad de salida
        if (salResultSet.next()) {
            idProdSal = salResultSet.getInt("id_prod_ent");
            cantidadSal = salResultSet.getInt("cantidad");
        }

        // Verificar si el ingrediente ya existe en la tabla iv_temp
        PreparedStatement selectTempStatement = cn.prepareStatement("SELECT * FROM iv_temp WHERE nombre = ?");
        selectTempStatement.setString(1, ingrediente);
        ResultSet tempResultSet = selectTempStatement.executeQuery();
        

        if (tempResultSet.next()) {
            // Si el ingrediente ya existe, actualizar la cantidad
            int cantidadExistente = tempResultSet.getInt("cant_sal");
            int nuevaCantidad = cantidadExistente + cantidadNecesaria;
            
            PreparedStatement updateStatement = cn.prepareStatement(
                    "UPDATE iv_temp SET cant_sal = ?, cant_ent = ?, iv_prod_ent_id_prod_ent = ?, iv_prod_sal_id_prod_sal = ? WHERE nombre = ?");
            updateStatement.setInt(1, nuevaCantidad);
            updateStatement.setInt(2, cantidadSal); // Actualizar la cantidad de salida
            updateStatement.setInt(3, idProdSal);
            updateStatement.setInt(4, idProdEnt);
            updateStatement.setString(5, ingrediente);
            updateStatement.executeUpdate();
        } else {
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            String a = dateFormat.format(date);
            // Si el ingrediente no existe, insertarlo en la tabla iv_temp
            PreparedStatement insertStatement = cn.prepareStatement(
                    "INSERT INTO iv_temp (nombre, cant_sal, cant_ent, iv_prod_ent_id_prod_ent, iv_prod_sal_id_prod_sal, fecha) VALUES (?, ?, ?, ?, ?, ?)");
            insertStatement.setString(1, ingrediente);
            insertStatement.setInt(2, cantidadNecesaria); // Cantidad de entrada
            insertStatement.setInt(3, cantidadSal); // Asignar la cantidad de salida inicial
            insertStatement.setInt(4, idProdSal);
            insertStatement.setInt(5, idProdEnt);
            insertStatement.setString(6, a); // Usar la variable 'a' que contiene la fecha actual
            insertStatement.executeUpdate();

        }
    } catch (SQLException e) {
        System.err.println("Error al guardar la cantidad en la tabla iv_temp: " + e.getMessage());
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


   public String obtenerFechaActual() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date = new java.util.Date();
    return dateFormat.format(date);
}

public void procesarPedido(String plato, int cantidad) {
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        cn = con.getConnection();
        Statement statement = cn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM prod_platos WHERE nombre = '" + plato + "'");

        while (resultSet.next()) {
            String ingrediente = resultSet.getString("ingredientes");
            int cantidadNecesaria = resultSet.getInt("cantidad");

            // Verificar si hay suficientes ingredientes en el inventario
            PreparedStatement checkStatement = cn.prepareStatement(
                    "SELECT cantidad FROM iv_prod_ent WHERE nombre = ?");
            checkStatement.setString(1, ingrediente);
            ResultSet checkResult = checkStatement.executeQuery();
            if (checkResult.next()) {
                int cantidadDisponible = checkResult.getInt("cantidad");
                if (cantidadDisponible < (cantidadNecesaria * cantidad)) {
                    JOptionPane.showMessageDialog(admin, "No hay suficientes ingredientes en el inventario para realizar el pedido de " + plato);
                    return; // Salir del método si no hay suficientes ingredientes
                }
            } else {
                JOptionPane.showMessageDialog(admin, "El ingrediente " + ingrediente + " no está en el inventario.");
                return; // Salir del método si el ingrediente no está en el inventario
            }

            // Actualizar la cantidad de ingredientes en el inventario
            PreparedStatement updateStatement = cn.prepareStatement(
                    "UPDATE iv_prod_ent SET cantidad = cantidad - ? WHERE nombre = ?");
            updateStatement.setInt(1, cantidadNecesaria * cantidad);
            updateStatement.setString(2, ingrediente);
            updateStatement.executeUpdate();

            // Guardar la cantidad de ingredientes en iv_temp
            guardarCantidadEnTemp( ingrediente, cantidadNecesaria);

            // Verificar si ya existe una entrada para el ingrediente en iv_prod_sal para el día actual
            java.util.Date fechaActual = new java.util.Date();
            java.sql.Date fechaActualSql = new java.sql.Date(fechaActual.getTime());
            
            PreparedStatement selectStatement = cn.prepareStatement(
                    "SELECT * FROM iv_prod_sal WHERE nombre = ? AND fecha = ?");
            selectStatement.setString(1, ingrediente);
            selectStatement.setDate(2, fechaActualSql);
            ResultSet selectResult = selectStatement.executeQuery();
            
            if (selectResult.next()) {
                // Si ya existe una entrada para el ingrediente en el día actual, actualizar la cantidad
                int cantidadExistente = selectResult.getInt("cantidad");
                int nuevaCantidad = cantidadExistente + (cantidadNecesaria * cantidad);
                
                PreparedStatement updateQuantityStatement = cn.prepareStatement(
                        "UPDATE iv_prod_sal SET cantidad = ? WHERE nombre = ? AND fecha = ?");
                updateQuantityStatement.setInt(1, nuevaCantidad);
                updateQuantityStatement.setString(2, ingrediente);
                updateQuantityStatement.setDate(3, fechaActualSql);
                updateQuantityStatement.executeUpdate();
            } else {
                // Si no existe una entrada para el ingrediente en el día actual, insertar una nueva fila
                PreparedStatement insertStatement = cn.prepareStatement(
                        "INSERT INTO iv_prod_sal (nombre, cantidad, fecha) VALUES (?, ?, ?)");
                insertStatement.setString(1, ingrediente);
                insertStatement.setInt(2, cantidadNecesaria * cantidad);
                insertStatement.setDate(3, fechaActualSql);
                insertStatement.executeUpdate();
            }
        }
        System.out.println("Pedido procesado: " + cantidad + " plato(s) de " + plato);
        JOptionPane.showMessageDialog(admin, "Pedido realizado correctamente\nPlato: " + plato + "\nCantidad: " + cantidad);
    } catch (SQLException e) {
        System.err.println("Error al procesar el pedido: " + e.getMessage());
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
