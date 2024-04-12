/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;


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
      regEmpleado emp = new accionEmple() {};
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
    regEmpleado emp = new regEmpleado(){}; // Crear una instancia de regEmpleado
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "SELECT nom_emple, ape_emple FROM reg_empleado WHERE ced_emple = ? AND rol = 333";
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
      regEmpleado emp = new accionEmple() {};
      String sql = "SELECT ced_emple,nom_emple,ape_emple FROM reg_empleado WHERE ced_emple=?";
    try {
        cn = con.getConnection();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, em);
        rs = ps.executeQuery();
        while (rs.next()) {
            // Si se encontró un cliente, establece la cédula en el objeto regEmpleado
            emp.setCedulaEmpl(rs.getInt("ced_emple"));
            emp.setNombreEmpl(rs.getString("nom_emple"));
            emp.setApellidoEmpl(rs.getString("ape_emple"));
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
  
}

