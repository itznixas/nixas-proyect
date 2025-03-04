package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import componentes.alert.Notification;
import java.awt.FontFormatException;
import vista.*;
import modelo.*;
import java.time.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import com.itextpdf.text.pdf.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.filechooser.FileSystemView;

public class loginCtrl implements ActionListener {

    dataBase con = new dataBase();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    regEmpleado reG = new regEmpleado() {
    };
    regEmpleadoDAO emD = new regEmpleadoDAO();
    ventanaLogin ventana;
    MenuAdmin admin = new MenuAdmin();
    MenuCajero cajero = new MenuCajero();
    DefaultTableModel modelo = new DefaultTableModel();

    clienteDAO cli = new clienteDAO();
    proCatDAO proDAO = new proCatDAO();
    mesasDAO mDAO = new mesasDAO();
    pedidosDAO peD = new pedidosDAO() {
    };
    platoProducto pl = new platoProducto() {
    };
    prodPlatosDAO plDAO = new prodPlatosDAO();
    inventarioDAO inDAO = new inventarioDAO();
    Excel ex = new Excel();
    facturaDetDAO faDAO = new facturaDetDAO();
    facturaDAO fDAO = new facturaDAO();
    int item;
    int items;
    float totalPagar = (float) 0.0;

    public loginCtrl() {
    }

    public loginCtrl(ventanaLogin ventana) throws FontFormatException, IOException {
        this.ventana = new ventanaLogin();
        this.ventana = ventana;
        this.ventana.BtnLogin.addActionListener(this);
    }

    public loginCtrl(MenuAdmin admin) throws FontFormatException, IOException, SQLException {
        this.ventana = new ventanaLogin();
        this.admin = admin;
        this.admin.btnAgregarC.addActionListener(this);
        this.admin.btnAgregarEm.addActionListener(this);
        this.admin.cmbEmpleado.addActionListener(this);
        this.admin.cmbComidas.addActionListener(this);
        this.admin.jmiOrdenes.addActionListener(this);
        this.admin.jmiClientes.addActionListener(this);
        this.admin.jmiProductos.addActionListener(this);
        this.cajero.jmiOrdenes.addActionListener(this);
        this.cajero.jmiClientes.addActionListener(this);
        this.cajero.jmiProductos.addActionListener(this);
        this.admin.jmiEmpleado.addActionListener(this);
        this.admin.jmiClienteConsu.addActionListener(this);
        this.admin.jmiEmpleadoConsu.addActionListener(this);
        this.admin.jmiCerrarSesion.addActionListener(this);
        this.admin.btnPorcion.addActionListener(this);
        this.admin.btnConsultarEm.addActionListener(this);
        this.admin.btnEliminarEmp.addActionListener(this);
        this.admin.btnConsultaCL.addActionListener(this);
        this.admin.btnEliminarClie.addActionListener(this);
        this.admin.btnActblE.addActionListener(this);
        this.admin.btnActbCli.addActionListener(this);
        this.admin.btnModificarEmpl.addActionListener(this);
        this.proDAO.categoria(admin.cmbPorcion);
        this.peD.llenarPlatoss(admin.cmbComidas);
        this.admin.btnActuaMesa.addActionListener(this);
        this.emD.rol(admin.cmbEmpleado);
        this.admin.btnAggPedidos.addActionListener(this);
        this.peD.mesero(admin.jcbMesero);
        this.admin.btnActuaTabPenPet.addActionListener(this);
        this.admin.btnPedidosListo.addActionListener(this);
        this.admin.btnAggProInv.addActionListener(this);
        this.admin.btnActualizarInv.addActionListener(this);
        this.admin.btnActualizarInv.addActionListener(this);
        this.admin.btnExcel.addActionListener(this);
        this.admin.btnCkeckIn.addActionListener(this);
        this.admin.btnActualizarFactura.addActionListener(this);
        this.admin.cerrar.addActionListener(this);
        this.admin.btnFacturar.addActionListener(this);
        this.admin.txtIdClienteFac.addActionListener(this);
        this.admin.txtCantProdDet.addActionListener(this);
        this.admin.txtIdMesero.addActionListener(this);
        this.admin.txtIdCajeroFac.addActionListener(this);
        this.admin.txtProductoDet.addActionListener(this);
        this.admin.btnEliminarFactura.addActionListener(this);
        this.admin.btnMonto.addActionListener(this);
        this.admin.buscarInven.addActionListener(this);
        this.admin.jmifactura.addActionListener(this);
        this.admin.Mesas.addActionListener(this);
        this.admin.Caja.addActionListener(this);
        this.admin.modificarCliente.addActionListener(this);
    }

    public void btnExcell() {
        ex.reporte();
    }

    public void listarMesas(JTable tblEleccionMesa) throws SQLException {
        System.out.println("aa");
        modelo = (DefaultTableModel) tblEleccionMesa.getModel();
        modelo.setRowCount(0); // Limpiar modelo de la tabla antes de agregar nuevos datos

        try {
            List<mesas> estadoMes = mDAO.estadoMesas();
            Object[] object = new Object[2];

            for (int i = 0; i < estadoMes.size(); i++) {
                object[0] = estadoMes.get(i).getIdMesas();
                object[1] = estadoMes.get(i).getEstadoMesa();

                modelo.addRow(object);
            }
            modelo.fireTableDataChanged(); // Notificar a la vista que los datos han cambiado
        } catch (SQLException ex) {
            Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarPlatosPedidos(JTable tblStockProductos) throws SQLException {
        System.out.println("aa");
        modelo = (DefaultTableModel) tblStockProductos.getModel();
        modelo.setRowCount(0); // Limpiar modelo de la tabla antes de agregar nuevos datos

        try {
            List<platoProducto> plato = plDAO.platos();
            Object[] object = new Object[1];

            for (int i = 0; i < plato.size(); i++) {
                object[0] = plato.get(i).getNombreProd();
                modelo.addRow(object);
            }
            modelo.fireTableDataChanged(); // Notificar a la vista que los datos han cambiado
        } catch (SQLException ex) {
            Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarFactura(JTable tblFactura) throws SQLException {
        modelo = (DefaultTableModel) tblFactura.getModel();
        modelo.setRowCount(0); // Limpiar modelo de la tabla antes de agregar nuevos datos

        try {
            List<platoProducto> plato = plDAO.platos();
            Object[] object = new Object[3];

            for (int i = 0; i < plato.size(); i++) {
                object[0] = plato.get(i).getId_plato();
                object[1] = plato.get(i).getNombreProd();
                object[2] = plato.get(i).getCantidad();
                modelo.addRow(object);
            }
            modelo.fireTableDataChanged(); // Notificar a la vista que los datos han cambiado
        } catch (SQLException ex) {
            Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CAMBIAR PANELES
    public void pedidosAggPaneles() {
        admin.jTabbedPane.setSelectedIndex(1);
    }

    public void pedidosAggPaneles2() {
        cajero.jTabbedPane.setSelectedIndex(1);
    }

    public void clienteAggPaneles() {
        admin.jTabbedPane.setSelectedIndex(2);
        cajero.jTabbedPane.setSelectedIndex(2);
    }

    public void clienteAggPaneles2() {
        cajero.jTabbedPane.setSelectedIndex(2);
    }

    public void empleadosAggPaneles() {
        admin.jTabbedPane.setSelectedIndex(3);
    }

    public void productosAggPaneles() {
        admin.jTabbedPane.setSelectedIndex(4);
        cajero.jTabbedPane.setSelectedIndex(4);
    }

    public void productosAggPaneles2() {
        cajero.jTabbedPane.setSelectedIndex(4);
    }

    public void clienteConsuPaneles() {
        admin.jTabbedPane.setSelectedIndex(5);
        cajero.jTabbedPane.setSelectedIndex(5);
    }

    public void clienteConsuPaneles2() {
        cajero.jTabbedPane.setSelectedIndex(5);
    }

    public void empleadoConsuPaneles() {
        admin.jTabbedPane.setSelectedIndex(6);
    }

    public void inventarioConsuPaneles() {
        admin.jTabbedPane.setSelectedIndex(7);
    }

    public void facturaConsuPaneles() {
        admin.jTabbedPane.setSelectedIndex(8);
    }

    public void mesasPaneles() {
        admin.jTabbedPane.setSelectedIndex(9);
    }

    public void cierreCajaPaneles() {
        admin.jTabbedPane.setSelectedIndex(10);
    }

    public void cerrarSesion() throws FontFormatException, IOException {
        int option = JOptionPane.showOptionDialog(admin,
                "¿Desea continuar?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Sí", "No"},
                "Sí");

        if (option == JOptionPane.YES_OPTION) {
            admin.dispose();
            ventanaLogin login = new ventanaLogin();
            loginCtrl lox = new loginCtrl(login);
            login.setVisible(true);
        }
    }

    //Metodo del login
    public void btnIngresar() throws FontFormatException, IOException, SQLException {
        String user = ventana.CampoUsuario.getText();
        String clave = new String(ventana.CampoContraseña.getText());
        reG.setUserEmpl(user);
        reG.setClaveEmpl(hash.sha1(clave));
        int rol = emD.autenticacionRol(reG);
        admin.jmiProductos.setEnabled(false);
        admin.jmiClienteConsu.setVisible(true);
        switch (rol) {
            case 111:
                MenuAdmin m = new MenuAdmin();
                loginCtrl lx = new loginCtrl(m);

                Notification panel = new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "LOG IN SUCCES");
                panel.showNotification();
                System.out.println(rol);
//                m.lblRoles.setText(Integer.toString(rol));
                admin.jmiProductos.setEnabled(true);

                Thread thread = new Thread(() -> {
                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            m.iniciar();
                            Notification panel2 = new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_LEFT, "ROLE ADMINISTRATION.");
                            panel2.showNotification();
                            ventana.setVisible(false);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                });
                thread.start();
                break;
            case 222:
                MenuCajero cajero = new MenuCajero();
                loginCtrl lgx = new loginCtrl();
                Notification panel2 = new Notification(cajero, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "LOG IN SUCCES.");
                panel2.showNotification();
                admin.jmiClienteConsu.setVisible(false);
//                cajero.lblRoles.setText(Integer.toString(rol));
                Thread thread2 = new Thread(() -> {
                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cajero.iniciar();
                            Notification panel2 = new Notification(cajero, Notification.Type.SUCCESS, Notification.Location.TOP_LEFT, "ROLE CASHIER.");
                            panel2.showNotification();
                            ventana.setVisible(false);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                });
                thread2.start();
                break;
            default:
                MenuAdmin menu = new MenuAdmin();
                Notification panel3 = new Notification(menu, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "ROLE NOT FOUND.");
                panel3.showNotification();
                System.out.println("Rol no encontrado");
                break;
        }
    }

    public void listarClientes(JTable tblClientes) {
        modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0); // Limpiar modelo de la tabla antes de agregar nuevos datos

        try {
            List<regEmpleado> listarClientes = cli.listarCliente();
            Object[] object = new Object[6];

            for (int i = 0; i < listarClientes.size(); i++) {
                object[0] = listarClientes.get(i).getIdEmpl();
                object[1] = listarClientes.get(i).getNombreEmpl();
                object[2] = listarClientes.get(i).getApellidoEmpl();
                object[3] = listarClientes.get(i).getCedulaEmpl();
                object[4] = listarClientes.get(i).getDireccion();
                object[5] = listarClientes.get(i).getCelEmpl();

                modelo.addRow(object);
            }

            modelo.fireTableDataChanged(); // Notificar a la vista que los datos han cambiado
        } catch (SQLException ex) {
            Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void btnAgregarCliente() {
        regEmpleado cliente = new regEmpleado() {
        };
        clienteDAO cliD = new clienteDAO();

        String nombreCliente = admin.txtNombreC.getText();
        String apellidoCliente = admin.txtApellidoC.getText();
        Integer cedulaCliente = 0;
        Integer celularCliente = 0;

        try {
            if (!admin.txtCedulaC.getText().isEmpty()) {
                cedulaCliente = Integer.parseInt(admin.txtCedulaC.getText());
            }
            if (!admin.txtTelefonoC.getText().isEmpty()) {
                celularCliente = Integer.parseInt(admin.txtTelefonoC.getText());
            }

            String direccionCliente = admin.txtDireccionC.getText();
            System.out.println(direccionCliente);
            cliente.setNombreEmpl(nombreCliente);
            cliente.setApellidoEmpl(apellidoCliente);
            cliente.setCedulaEmpl(cedulaCliente);
            cliente.setDireccion(direccionCliente);
            cliente.setCelEmpl(celularCliente);

            int r = cliD.agregarCliente(cliente);
            if (r == 1) {
                JOptionPane.showMessageDialog(admin, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(admin, "Error al registrar cliente");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(admin, "Error en el formato de datos. Verifica los campos numéricos.");
        }

        limpiartabla();
        listarClientes(admin.tblClientes); // Actualizar tabla de clientes
    }

    public void btnConsultarCliente(JTable tblClientes) {
        regEmpleado cliente = new regEmpleado() {
        };
        Integer cedula = 0;
        String nombre = admin.txtConsulatCL.getText();

        if (!admin.txtConsulatCL.getText().isEmpty()) {
            try {
                cedula = Integer.parseInt(admin.txtConsulatCL.getText());
                cliente.setCedulaEmpl(cedula);
            } catch (NumberFormatException e) {
                // No es un número de cédula válido
                cliente.setNombreEmpl(nombre);
            }
        }
        try {
            List<regEmpleado> empleadosEncontrados;
            if (cedula != 0) {
                // Buscar por cédula
                empleadosEncontrados = cli.buscarCedCliente(cliente);
                admin.txtConsulatCL.setText("");
            } else if (!nombre.isEmpty()) {
                // Buscar por nombre si no se ingresó una cédula válida
                cliente.setNombreEmpl(nombre);
                empleadosEncontrados = cli.buscarNomCliente(cliente);
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar una cédula o un nombre válido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            actualizarTablaCliente(empleadosEncontrados, tblClientes);
            admin.txtConsultarEm.setText(""); // Limpiar el campo de consulta después de la búsqueda
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnEliminarCliente() {
        regEmpleado cliente = new regEmpleado() {
        };
        Integer cedula = 0;
        if (!admin.txtConsulatCL.getText().isEmpty()) {
            try {
                cedula = Integer.parseInt(admin.txtConsulatCL.getText());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número de cédula válido", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si la cédula no es válida
            }
            cliente.setCedulaEmpl(cedula);
        }
        if (cedula != 0) {
            try {
                cli.eliminarCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente eliminado ");
                admin.txtConsulatCL.setText(""); // Limpiar el campo de consulta después de la búsqueda
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al buscar Cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cédula válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
        listarClientes(admin.tblClientes);
    }

    public void actualizarTablaCliente(List<regEmpleado> cliente, JTable tblClientes) {
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0); // Limpiar modelo de la tabla antes de agregar nuevos datos

        for (regEmpleado clien : cliente) {
            Object[] fila = {
                clien.getIdEmpl(),
                clien.getNombreEmpl(),
                clien.getApellidoEmpl(),
                clien.getCedulaEmpl(),
                clien.getCelEmpl(),
                clien.getDireccion(),};
            modelo.addRow(fila);
        }

        modelo.fireTableDataChanged(); // Notificar a la vista que los datos han cambiado
    }

    public void limpiarcajasCliente() {
        admin.txtNombreC.setText(null);
        admin.txtApellidoC.setText(null);
        admin.txtCedulaC.setText(null);
        admin.txtTelefonoC.setText(null);
        admin.txtDireccionC.setText(null);
        // admin.txtCedulaC.requestFocus();
    }

    public void btnAgregarEmple() throws SQLException {
        regEmpleado empleado = new regEmpleado() {
        };
        regEmpleadoDAO dao = new regEmpleadoDAO();

        String nombreEm = admin.txtNombreE.getText();
        String apellidoEm = admin.txtApellidoE.getText();
        String usuarioEm = admin.txtUserE.getText();
        String claveEm = new String(admin.txtClaveE.getText());
        int id_rol = 0;
        Integer docEmp = 0;
        Integer celEm = 0;

        try {
            if (!admin.txtDocE.getText().isEmpty()) {
                docEmp = Integer.parseInt(admin.txtDocE.getText());
            }
            if (!admin.txtCelE.getText().isEmpty()) {
                celEm = Integer.parseInt(admin.txtCelE.getText());
            }
            if (admin.cmbEmpleado.getSelectedItem().equals("Administrador")) {
                id_rol = 111;
            } else if (admin.cmbEmpleado.getSelectedItem().equals("Cajero")) {
                id_rol = 222;
            } else if (admin.cmbEmpleado.getSelectedItem().equals("Mesero")) {
                id_rol = 333;
            }

            empleado.setNombreEmpl(nombreEm);
            empleado.setApellidoEmpl(apellidoEm);
            empleado.setCedulaEmpl(docEmp);
            empleado.setCelEmpl(celEm);
            empleado.setUserEmpl(usuarioEm);
            empleado.setClaveEmpl(hash.sha1(claveEm));
            empleado.setIdRol(id_rol);

            int r = dao.agregarEmpleado(empleado);

            if (r == 1) {
                JOptionPane.showMessageDialog(admin, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(admin, "Error al registrar empleado");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(admin, "Error en el formato de datos. Verifica los campos numéricos.");
        }

        // Llamar a métodos después de la operación try-catch
        listarEmpleado(admin.tblEmpleados);
        limpiartabla();
    }

    public void btnModificarEmple() throws SQLException {
        regEmpleado em = new regEmpleado() {
        };
        regEmpleadoDAO dao = new regEmpleadoDAO();
        int id_rol = 0;
        if ("".equals(admin.txtIdConsuEmpl.getText())) {
        } else {
            em.setIdEmpl(Integer.parseInt(admin.txtIdConsuEmpl.getText()));
            em.setNombreEmpl(admin.txtNombreConsuEmpl.getText());
            em.setApellidoEmpl(admin.txtApellidoConuEmpl.getText());
            em.setCedulaEmpl(Integer.parseInt(admin.txtCedulaConseEmpl.getText()));
            em.setCelEmpl(Integer.parseInt(admin.txtTelefonoConsuEmpl.getText()));
            em.setUserEmpl(admin.txtUserConsuEmpl.getText());
            em.setClaveEmpl(admin.txtClaveConsuEmpl.getText());
            if (admin.cmbEmpleado.getSelectedItem().equals("Admin")) {
                id_rol = 111;
            } else if (admin.cmbEmpleado.getSelectedItem().equals("Cajero")) {
                id_rol = 222;
            } else if (admin.cmbEmpleado.getSelectedItem().equals("Mesero")) {
                id_rol = 333;
            }
            em.setIdRol(id_rol);
        }
        dao.actualizarEmpleado(em);
        listarEmpleado(admin.tblEmpleados);
        JOptionPane.showMessageDialog(admin, "Correcto");
    }
    public void btnModificarCliente() throws SQLException {
        regEmpleado em = new regEmpleado() {
        };
        regEmpleadoDAO dao = new regEmpleadoDAO();
        int id_rol = 0;
        if ("".equals(admin.txtIdConsuCli.getText())) {
        } else {
            em.setIdEmpl(Integer.parseInt(admin.txtIdConsuCli.getText()));
            em.setNombreEmpl(admin.txtNombreConsCli.getText());
            em.setApellidoEmpl(admin.txtApellidoConsuCli.getText());
            em.setCedulaEmpl(Integer.parseInt(admin.txtDireccionConsuCli.getText()));
            em.setCelEmpl(Integer.parseInt(admin.txtCedulaConsuCli1.getText()));
            em.setUserEmpl(admin.txtTelefonoConsuCli.getText());
            em.setClaveEmpl(admin.txtIdConsuCli.getText());
            em.setIdRol(id_rol);
        }
        dao.actualizarEmpleado(em);
        listarEmpleado(admin.tblEmpleados);
        JOptionPane.showMessageDialog(admin, "Correcto");
    }

    public void btnConsultarEmpleado(JTable tblEmpleado) throws SQLException {
        regEmpleado empleado = new regEmpleado() {
        };
        Integer cedula = 0;
        String nombre = admin.txtConsultarEm.getText();

        if (!admin.txtConsultarEm.getText().isEmpty()) {
            try {
                cedula = Integer.parseInt(admin.txtConsultarEm.getText());
                empleado.setCedulaEmpl(cedula);
            } catch (NumberFormatException e) {
                // No es un número de cédula válido
                empleado.setNombreEmpl(nombre);
            }
        }
        try {
            List<regEmpleado> empleadosEncontrados;
            if (cedula != 0) {
                // Buscar por cédula
                empleadosEncontrados = emD.buscarCedEmpleado(empleado);
            } else if (!nombre.isEmpty()) {
                // Buscar por nombre si no se ingresó una cédula válida
                empleado.setNombreEmpl(nombre);
                empleadosEncontrados = emD.buscarNomEmpleado(empleado);
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar una cédula o un nombre válido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            actualizarTablaEmpleados(empleadosEncontrados, tblEmpleado);
            admin.txtConsultarEm.setText(""); // Limpiar el campo de consulta después de la búsqueda
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnEliminarEmpleado() {
        regEmpleado empleado = new regEmpleado() {
        };
        Integer cedula = 0;
        if (!admin.txtConsultarEm.getText().isEmpty()) {
            try {
                cedula = Integer.parseInt(admin.txtConsultarEm.getText());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número de cédula válido", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si la cédula no es válida
            }
            empleado.setCedulaEmpl(cedula);
        }
        if (cedula != 0) {
            try {
                emD.eliminarEmpleado(empleado);
                JOptionPane.showMessageDialog(null, "Empleado eliminado ");
                admin.txtConsultarEm.setText(""); // Limpiar el campo de consulta después de la búsqueda
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al buscar empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cédula válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
        listarEmpleado(admin.tblEmpleados);
    }

    public void listarEmpleado(JTable tblEmpleado) {
        modelo = (DefaultTableModel) tblEmpleado.getModel();
        modelo.setRowCount(0);

        try {
            List<regEmpleado> listarEmpleado = emD.listarEmpleado();
            Object[] object = new Object[9];

            for (int i = 0; i < listarEmpleado.size(); i++) {
                object[0] = listarEmpleado.get(i).getIdEmpl();
                object[1] = listarEmpleado.get(i).getNombreEmpl();
                object[2] = listarEmpleado.get(i).getApellidoEmpl();
                object[3] = listarEmpleado.get(i).getCedulaEmpl();
                object[4] = listarEmpleado.get(i).getCelEmpl();
                object[5] = listarEmpleado.get(i).getIdRol();
                object[6] = listarEmpleado.get(i).getUserEmpl();
                object[7] = listarEmpleado.get(i).getClaveEmpl();
                modelo.addRow(object);
            }
            modelo.fireTableDataChanged();
        } catch (SQLException e) {
            Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public void limpiarcajasEmpleado() {
        admin.txtNombreE.setText(null);
        admin.txtApellidoE.setText(null);
        admin.txtUserE.setText(null);
        admin.txtClaveE.setText(null);
        admin.txtDocE.setText(null);
        admin.txtCelE.setText(null);
        admin.txtDocE.requestFocus();
    }

    public void actualizarTablaEmpleados(List<regEmpleado> empleados, JTable tblEmpleado) {
        DefaultTableModel modelo = (DefaultTableModel) tblEmpleado.getModel();
        modelo.setRowCount(0); // Limpiar modelo de la tabla antes de agregar nuevos datos

        for (regEmpleado empleado : empleados) {
            Object[] fila = {
                empleado.getIdEmpl(),
                empleado.getNombreEmpl(),
                empleado.getApellidoEmpl(),
                empleado.getCedulaEmpl(),
                empleado.getCelEmpl(),
                empleado.getIdRol(),
                empleado.getUserEmpl(),
                empleado.getClaveEmpl()
            };
            modelo.addRow(fila);
        }

        modelo.fireTableDataChanged(); // Notificar a la vista que los datos han cambiado
    }

    //Metodos de prociones
    public void btnAgregarPorcion() throws SQLException {
        producto prod = new producto() {
        };
        porcionesDAO porDAO = new porcionesDAO();
        bebidasDAO be = new bebidasDAO();
        String nombreB, nombreC;
        int cantidadB = 0;
        float precioB = 0;
        int cantidadC = 0;
        float precioC = 0;
        int id = 0;
        int r = 0;
        System.out.println("g");
        try {

            if (admin.cmbPorcion.getSelectedItem().equals("Bebidas")) {
                id = 1;
                nombreB = admin.txtNombreP.getText();

                if (!admin.txtCantidadP.getText().isEmpty()) {
                    cantidadB = Integer.parseInt(admin.txtCantidadP.getText());
                }
                if (!admin.txtPrecioP.getText().isEmpty()) {
                    precioB = Float.parseFloat(admin.txtPrecioP.getText());
                }

                prod.setNombreProd(nombreB);
                prod.setCantidad(cantidadB);
                prod.setPrecio(precioB);
                r = be.agregarBebidas(prod);
                if (r == 1) {
                    AggInventario();
                    // JOptionPane.showMessageDialog(admin, "Registro exitoso");
                } else {
                    JOptionPane.showMessageDialog(admin, "Error ");
                }
            } //METODO DE AGG COMIDA
            else if (admin.cmbPorcion.getSelectedItem().equals("Comida")) {
                id = 2;
                producto pr = new producto() {
                };
                pr.setNombreProd(admin.txtNombreP.getText());
                pr.setCantidad(Integer.parseInt(admin.txtCantidadP.getText()));
                pr.setPrecio(Float.parseFloat(admin.txtPrecioP.getText()));

                System.out.println(pr.getCantidad()); // This confirms you have the value

                r = porDAO.agregarPorciones(pr);

                if (r == 1) {
                    AggInventario();
                    // JOptionPane.showMessageDialog(admin, "Registro exitoso");
                } else {
                    JOptionPane.showMessageDialog(admin, "Error");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(admin, "Error en el formato de datos. Verifica los campos numéricos.");
        }
        //Guardar datos de BEBIDAS
    }

    public void ingresarPedidos(KeyEvent evt) throws SQLException {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(admin.txtCantidadProPed.getText())) {
                tmpPedidos tp = new tmpPedidos() {
                };
                tp.setIdMesas(Integer.parseInt(admin.txtMesaId.getText()));
                String meseroSeleccionadoStr = (String) admin.jcbMesero.getSelectedItem();
                int meseroSeleccionadoInt = Integer.parseInt(meseroSeleccionadoStr);
                tp.setMesero(meseroSeleccionadoInt);
                tp.setProducto(admin.txtNomProducPed.getText());
                tp.setCantidad(Integer.parseInt(admin.txtCantidadProPed.getText()));
                String est = "PENDIENTE";
                tp.setEstado(est);

                // Obtener la hora actual como un String en formato HH:mm
                LocalDateTime ahora = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                String horaActual = ahora.format(formatter);
                tp.setHora(horaActual);

                int r = peD.agregarPedidos(tp, est);
                if (r == 1) {
                    JOptionPane.showMessageDialog(admin, "Registro exitoso");
                    listaPedidos(admin.tblPedidoPendiente);
                } else {
                    JOptionPane.showMessageDialog(admin, "Error al registrar pedido");
                }
            } else {
                JOptionPane.showMessageDialog(admin, "Ingrese la cantidad del producto");
            }
        }
    }

    public void listaComida(JTable tblStockProductos) {
        modelo = (DefaultTableModel) tblStockProductos.getModel();
        modelo.setRowCount(0);

    }

    public void ActualizarTablaFactura() {
        modelo = (DefaultTableModel) admin.tblFactura.getModel();
        modelo.setRowCount(0); // Limpiar modelo de la tabla antes de agregar nuevos datos

        try {
            List<tmpPedidos> listarTablaFactura = cli.listarTablaFactura();
            Object[] object = new Object[6];

            for (int i = 0; i < listarTablaFactura.size(); i++) {
                object[0] = listarTablaFactura.get(i).getIdPedidos();
                object[1] = listarTablaFactura.get(i).getIdMesas();
                object[2] = listarTablaFactura.get(i).getMesero();
                object[3] = listarTablaFactura.get(i).getProducto();
                object[4] = listarTablaFactura.get(i).getCantidad();
                object[5] = listarTablaFactura.get(i).getEstado();

                modelo.addRow(object);
            }

            modelo.fireTableDataChanged(); // Notificar a la vista que los datos han cambiado
        } catch (SQLException ex) {
            Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarFactura() {
        facturaDAO dao = new facturaDAO();
        try {
            int filaSeleccionada = admin.tblFactura.getSelectedRow();
            int idFactura = (int) admin.tblFactura.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID de factura está en la primera columna
            boolean eliminada = dao.eliminarFacturaPorID(idFactura);
            if (eliminada) {
                System.out.println("Factura eliminada correctamente.");
                ActualizarTablaFactura(); // Actualizar la tabla después de la eliminación
            } else {
                System.out.println("No se pudo eliminar la factura.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listaPedidos(JTable tblPedidoPendiente) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tblPedidoPendiente.getModel();
        modelo.setRowCount(0);
        String est = "";
        try {
            List<tmpPedidos> listarPed = peD.listaPedidoPendiente();
            Object[] object = new Object[8]; // Solo hay 6 columnas según tu código

            for (int i = 0; i < listarPed.size(); i++) {
                object[0] = listarPed.get(i).getIdPedidos();
                object[1] = listarPed.get(i).getIdMesas();
                object[2] = listarPed.get(i).getMesero();
                object[3] = listarPed.get(i).getProducto();
                object[4] = listarPed.get(i).getCantidad();
                object[5] = listarPed.get(i).getEstado();
                object[6] = listarPed.get(i).getHora();

                // Agregar el objeto al modelo de la tabla
                modelo.addRow(object);
            }

            // Asignar el modelo actualizado a la tabla
            tblPedidoPendiente.setModel(modelo);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pedidosListo(KeyEvent evt) throws SQLException {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(admin.txtIdPedidoConse.getText())) {
                tmpPedidos tp = new tmpPedidos() {
                };
                tp.setIdPedidos(Integer.parseInt(admin.txtIdPedidoConse.getText()));
                String est = "LISTO";
                tp.setEstado(est);

                pedidosDAO peD = new pedidosDAO();
                // Verificar si el pedido ya está en estado "Listo"
                if (peD.verificarEstadoListo(tp)) {
                    JOptionPane.showMessageDialog(admin, "El pedido ya se encuentra en estado Listo.");
                } else {
                    peD.actualizarPedidoListo(tp);
                    listaPedidosListo(admin.tblPedidoListo);
                    JOptionPane.showMessageDialog(admin, "Pedido actualizado correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(admin, "Ingrese el ID del pedido");
            }
        }
    }

    public void buscarPrecio(KeyEvent evt) throws SQLException {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(admin.txtProductoDet.getText())) {
                String nom = admin.txtProductoDet.getText();
                platoProducto pl = peD.buscarPrecio(nom);
                if (pl != null) {
                    admin.txtPrecioUniDet.setText(String.valueOf(pl.getPrecio()));
                    admin.txtProductoDet.requestFocus();
                } else {
                    admin.txtPrecioUniDet.setText("");
                    admin.txtProductoDet.requestFocus();
                    JOptionPane.showMessageDialog(admin, "No se encontró el precio del producto.");
                }

            } else {
                JOptionPane.showMessageDialog(admin, "Selecciona la ID correcta");
            }
        }
    }

    public void listaPedidosListo(JTable tblPedidoListo) throws SQLException {
        System.out.println("aaaaasd");
        DefaultTableModel modelo = (DefaultTableModel) tblPedidoListo.getModel();
        modelo.setRowCount(0);
        String est = "";
        try {
            List<tmpPedidos> listarPed = peD.listaPedidoListo();
            Object[] object = new Object[8]; // Solo hay 6 columnas según tu código

            for (int i = 0; i < listarPed.size(); i++) {
                object[0] = listarPed.get(i).getIdPedidos();
                object[1] = listarPed.get(i).getIdMesas();
                object[2] = listarPed.get(i).getMesero();
                object[3] = listarPed.get(i).getProducto();
                object[4] = listarPed.get(i).getCantidad();
                object[5] = listarPed.get(i).getEstado();
                object[6] = listarPed.get(i).getHora();

                // Agregar el objeto al modelo de la tabla
                modelo.addRow(object);
            }

            // Asignar el modelo actualizado a la tabla
            tblPedidoListo.setModel(modelo);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    inventario in = new inventario();

    public void ingresarInvenEntrada(KeyEvent evt) throws SQLException {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(admin.txtNomProdInv.getText())) {

                in.setNomEntrada(admin.txtNomProdInv.getText());
                in.setCantEntrada(Integer.parseInt(admin.txtCanProdInv.getText()));

                LocalDate fechaActual = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String fechaFormateada = fechaActual.format(formatter);
                in.setFechaInvEntrada(fechaFormateada);

                String nom = in.getNomEntrada();
                int can = in.getCantEntrada();
                inDAO.agregarProductos(nom, can);
            } else {
                JOptionPane.showMessageDialog(admin, "Ingrese el nombre del producto");
            }
        }
    }

    public void ingresarInvenSalida() throws SQLException {
        in.setNomSalida(admin.txtNombreP.getText());
        in.setCantSalida(Integer.parseInt(admin.txtCantidadP.getText()));

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaActual.format(formatter);
        in.setFechaInvSalida(fechaFormateada);

        inventarioDAO dao = new inventarioDAO();
        if (dao.productoExiste(in)) {
            int r = inDAO.agregarPedidoSalida(in);
            if (r == 1) {
                AggInventario();
            } else {
                JOptionPane.showMessageDialog(admin, "Error");
            }
        } else {
            JOptionPane.showMessageDialog(admin, "Producto NO EXISTE");
        }

    }

    public void AggInventario() throws SQLException {
        try {
            inventarioDAO da = new inventarioDAO();

            // Obtener valores del objeto in y asignarlos a variables
            in.getNomSalida();
            in.getFechaInvSalida();
            in.getCantEntrada();
            in.getCantSalida();

            // Agregar inventario a la base de datos
            int r = da.agregarInvetario(in);

            // Verificar si el producto ya existe en la base de datos
            if (da.existeNombreEnInventario(in)) {
                if (r == 1) {
                    // La inserción fue exitosa
                } else if (da.productoExiste(in)) {
                    // El nombre del inventario ya existe en la base de datos
                } else {
                    JOptionPane.showMessageDialog(admin, "Error, no se pudo ingresar al inventario");
                }
            } else {
                JOptionPane.showMessageDialog(admin, "Error, no se encuentra el producto");
            }
        } catch (SQLException e) {
            // Manejar la excepción SQL aquí (mostrar mensaje, registrar en log, etc.)
            JOptionPane.showMessageDialog(admin, "Error SQL: " + e.getMessage());
        }
    }

    public void listarInventario(JTable tblInventario) {
        System.out.println("ss");
        modelo = (DefaultTableModel) tblInventario.getModel();
        modelo.setRowCount(0);
        try {
            List<inventario> listaInv = inDAO.listaInventario();
            Object[] object = new Object[7];
            for (int i = 0; i < listaInv.size(); i++) {
                object[0] = listaInv.get(i).getIdIvTmp();
                object[1] = listaInv.get(i).getNomSalida();
                object[2] = listaInv.get(i).getCantEntrada();
                object[3] = listaInv.get(i).getCantSalida();
                object[4] = listaInv.get(i).getFechaInvSalida();

                modelo.addRow(object);
            }
            modelo.fireTableDataChanged(); // Notificar a la vista que los datos han cambiado
        } catch (SQLException ex) {
            Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkIn() {
        // Instancia de pedidosDAO
        pedidosDAO peD = new pedidosDAO();

        int selectedRow = admin.tblPedidoListo.getSelectedRow();

        if (selectedRow != -1) {
            Object[] fila = new Object[admin.tblPedidoListo.getColumnCount()];
            for (int i = 0; i < admin.tblPedidoListo.getColumnCount(); i++) {
                fila[i] = admin.tblPedidoListo.getValueAt(selectedRow, i);
            }

            DefaultTableModel modeloOrigen = (DefaultTableModel) admin.tblPedidoListo.getModel();
            if (selectedRow != -1) {
                modeloOrigen.removeRow(selectedRow);
            }
        }
    }

    public void limpiarCajaInventario() {
        admin.txtNomProdInv.setText(null);
        admin.txtCanProdInv.setText(null);
    }

    //Factura
    public void buscarDNICli(KeyEvent evt) throws SQLException {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(admin.txtIdClienteFac.getText())) {
                try {
                    int cedula = Integer.parseInt(admin.txtIdClienteFac.getText());
                    regEmpleado em = new regEmpleado() {
                    };
                    em.setCedulaEmpl(cedula);
                    facturaDAO da = new facturaDAO();
                    regEmpleado ten = new regEmpleado() {
                    };
                    ten = da.buscarDNIClien(cedula);
                    if (ten.getCedulaEmpl() != null) {
                        admin.txtNomClintFac.setText("" + ten.getNombreEmpl());
                        admin.txtApeClintFac.setText("" + ten.getApellidoEmpl());

                    } else {
                        admin.txtNomClintFac.setText("");
                        admin.txtApeClintFac.setText("");
                        JOptionPane.showMessageDialog(admin, "Selecciona la id correcta");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(admin, "El valor ingresado no es un número válido.");
                }
            } else {
                JOptionPane.showMessageDialog(admin, "Selecciona la id correcta");
            }
        }
    }

    public void buscarDNIMese(KeyEvent evt) throws SQLException {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(admin.txtIdMesero.getText())) {
                try {
                    int cedula = Integer.parseInt(admin.txtIdMesero.getText());
                    regEmpleado em = new regEmpleado() {
                    };
                    regEmpleado ten = new regEmpleado() {
                    };
                    em.setCedulaEmpl(cedula);
                    facturaDAO da = new facturaDAO();

                    ten = da.buscarDNIMese(cedula);
                    if (ten.getCedulaEmpl() != null) {
                        admin.txtNomMeseroFac.setText("" + ten.getNombreEmpl());
                        admin.txtApeMeseroFac.setText("" + ten.getApellidoEmpl());
                    } else {
                        admin.txtNomMeseroFac.setText("");
                        admin.txtApeMeseroFac.setText("");
                        JOptionPane.showMessageDialog(admin, "No se encontró ningún empleado con la cédula especificada.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(admin, "El valor ingresado no es un número válido.");
                }
            } else {
                JOptionPane.showMessageDialog(admin, "Selecciona la id correcta");
            }
        }
    }

    public void buscarDNIEmple(KeyEvent evt) throws SQLException {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(admin.txtIdCajeroFac.getText())) {
                try {
                    int cedula = Integer.parseInt(admin.txtIdCajeroFac.getText());
                    regEmpleado em = new regEmpleado() {
                    };
                    em.setCedulaEmpl(cedula);
                    facturaDAO da = new facturaDAO();
                    regEmpleado ten = new regEmpleado() {
                    };
                    ten = da.buscarDNIEmple(cedula);
                    if (ten.getCedulaEmpl() != null) {
                        admin.txtNomCajeroFac.setText("" + ten.getNombreEmpl());
                        admin.txtApeCajeroFac.setText("" + ten.getApellidoEmpl());

                    } else {
                        admin.txtNomCajeroFac.setText("");
                        admin.txtApeCajeroFac.setText("");
                        JOptionPane.showMessageDialog(admin, "Selecciona la id correcta");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(admin, "El valor ingresado no es un número válido.");
                }
            } else {
                JOptionPane.showMessageDialog(admin, "Selecciona la id correcta");
            }
        }
    }

    public void TotalPagar() throws SQLException {
        totalPagar = 0.0f;
        int numFila = admin.tblFacturaEleccipn.getRowCount();
        for (int i = 0; i < numFila; i++) {
            // Check if a value exists at this row and column
            if (admin.tblFacturaEleccipn.getModel().getValueAt(i, 4) != null) {
                float can = (float) admin.tblFacturaEleccipn.getModel().getValueAt(i, 4);
                totalPagar += can;
            } else {
            }
        }
        admin.lblTotalFinal.setText(String.format(("%,2f"), totalPagar));
        da.setTotal(totalPagar);
    }

    facturaDetallee dae = new facturaDetallee() {
    };

    public void registrarDetalle(KeyEvent evt) throws SQLException {
        System.out.println("was");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(admin.txtCantProdDet.getText())) {
                int cod = Integer.parseInt(admin.txtNumFacturaDet.getText());
                String product = admin.txtProductoDet.getText();
                int cantidad = Integer.parseInt(admin.txtCantProdDet.getText());
                float precioU = Float.parseFloat(admin.txtPrecioUniDet.getText());
                float total = cantidad * precioU;
                //admin.lblTotal.setText(String.valueOf(total));
                if (20 >= cantidad) {
                    item = item + 1;
                    // Verifica si la tabla está inicializada y no es null
                    if (admin.tblFacturaEleccipn != null) {
                        modelo = (DefaultTableModel) admin.tblFacturaEleccipn.getModel();
                        for (int i = 0; i < admin.tblFacturaEleccipn.getRowCount(); i++) {
                            // Verifica si el producto ya está registrado en la tabla
                            if (admin.tblFacturaEleccipn.getValueAt(i, 1) != null
                                    && admin.tblFacturaEleccipn.getValueAt(i, 1).equals(product)) {
                                JOptionPane.showMessageDialog(admin, "El producto ya está registrado");
                                return;
                            }
                        }

                        // Si el producto no está registrado, agrégalo a la tabla
                        ArrayList lista = new ArrayList();
                        lista.add(item);
                        lista.add(cod);
                        lista.add(product);
                        lista.add(cantidad);
                        lista.add(precioU);
                        lista.add(total);
                        Object[] o = new Object[5];
                        o[0] = lista.get(1);
                        o[1] = lista.get(2);
                        o[2] = lista.get(3);
                        o[3] = lista.get(4);
                        o[4] = lista.get(5);
                        modelo.addRow(o);
                        admin.tblFacturaEleccipn.setModel(modelo);
                        TotalPagar();
                        // Realiza el registro de la venta en la base de datos
                        dae.setIdDetFact(cod);
                        dae.setProducto(product);
                        dae.setCantProd(cantidad);
                        dae.setPredUnitario(precioU);
                        dae.setTotal(total);

                        int r = faDAO.registrarVenta(dae);
                        if (r == 1) {
                            JOptionPane.showMessageDialog(admin, "Venta registrada en la factura detalle");

                        } else {

                        }
                    } else {
                        JOptionPane.showMessageDialog(admin, "La tabla de factura no está inicializada");
                    }
                } else {
                    JOptionPane.showMessageDialog(admin, "Error, sobrepasa el stock");
                }
            } else {
                JOptionPane.showMessageDialog(admin, "Ingrese la cantidad para facturar");
            }
        }
    }

    factauraCabe da = new factauraCabe() {
    };

    public void factura(KeyEvent evt) throws SQLException {
        System.out.println("ws");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(admin.txtCantProdDet.getText())) {
                int cod = Integer.parseInt(admin.txtNumFacturaDet.getText());
                int idCli = Integer.parseInt(admin.txtIdClienteFac.getText());
                String tipo = admin.txtMetodoPago.getText();
                int mesero = Integer.parseInt(admin.txtIdMesero.getText());
                int cajero = Integer.parseInt(admin.txtIdClienteFac.getText());
                int cantidad = Integer.parseInt(admin.txtCantProdDet.getText());
                float precioU = Float.parseFloat(admin.txtPrecioUniDet.getText());
                float desc = Float.parseFloat(admin.txtDescuentoFac.getText());

                LocalDate fechaActual = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String fechaFormateada = fechaActual.format(formatter);

                LocalDateTime ahora = LocalDateTime.now();
                DateTimeFormatter formatte = DateTimeFormatter.ofPattern("HH:mm");
                String horaActual = ahora.format(formatte);

                float cant = da.getTotal();
                float iva = cant * 0.19f;
                float descuento = cant * (desc / 100.0f);
                float total = iva + (cant - descuento);

                admin.lblTotal.setText(String.format(("%,2f"), total));

                if (50 >= cantidad) {

                    da.setIdCabFac(cod);
                    da.setIdTipoPago(tipo);
                    da.setIdCli(idCli);
                    da.setIdMesero(mesero);
                    da.setIdCajero(cajero);
                    da.setDescuento(descuento);
                    da.setIva(iva);
                    da.setTotal(total);
                    da.setFechaFact(fechaFormateada);
                    da.setHoraFact(horaActual);

                    String ingre = dae.getProducto();
                    ingresos();
                    int r = fDAO.facturar(da);
                    if (r == 1) {
                        JOptionPane.showMessageDialog(admin, " factura detalle");
                        // fDAO.guardarCantidadEnTemp(ingre, cantidad);
                        fDAO.procesarPedido(ingre, cantidad);
                        limpiartabla();

                    } else {
                        JOptionPane.showMessageDialog(admin, "Error, en la factura detalle");
                    }
                } else {
                    JOptionPane.showMessageDialog(admin, "Error, Sobrepasa el stock");
                }
            } else {
                JOptionPane.showMessageDialog(admin, "Ingrese la cantidad para facturar");
            }
        }
    }
    //CAJA DE CIERRE
    float suma = 0;

    public void ingresos() {
        DefaultTableModel modelos = (DefaultTableModel) admin.tblIngreso.getModel(); // Obtener el modelo existente de la tabla
        items = items + 1;
        int fac = da.getIdCabFac();
        float total = da.getTotal();
        ArrayList listas = new ArrayList();
        listas.add(items);
        listas.add(fac);
        listas.add(total);
        Object[] a = new Object[3];
        a[0] = listas.get(0); // Corregir los índices de los elementos de la lista
        a[1] = listas.get(1);
        a[2] = listas.get(2);
        modelos.addRow(a);
        modelos.fireTableDataChanged(); // No es necesario llamar a esto si solo estás agregando filas
        admin.totals.setText(String.valueOf(total));
    }

    public void agregarCierreCaja() {
        String user = reG.getUserEmpl();

    }

    /*
    //REPORTE POR PDF
    public void reportePdf() {

        try {
            Date date = new Date();
            FileOutputStream archivo;
            File file = new File("src/pdf/ventas.pdf");
            archivo = new FileOutputStream(file);
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/componentes/img/logoNixas.png");

            //Fecha
            Paragraph fecha = new Paragraph();
            fecha.add(Chunk.NEWLINE);
            fecha.add("Vendedor: " + admin.txtNomCajeroFac.getText() + "\nMesero: " + admin.txtNomMeseroFac.getText() + "\nFactura: " + da.getIdCabFac() + "\nFecha: "
                    + new SimpleDateFormat("dd/MM/yyyy").format(date) + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] columnWidthsEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(columnWidthsEncabezado);
            Encabezado.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            Encabezado.addCell(img);

            String rut = "100039823";
            String nom = "Nixas";
            String cel = "328393043";
            String dir = "Barranquilla/Atlantico";

            Encabezado.addCell("");
            Encabezado.addCell("\nNIT: " + rut + "\nNombre: " + nom + "\nCelular: " + cel + "\nDirrecion: " + dir);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("Datos del cliente" + "\n\n");
            doc.add(cli);

            PdfPTable tablacli = new PdfPTable(3) {
            };
            tablacli.setWidthPercentage(100);
            tablacli.getDefaultCell().setBorder(0);
            float[] columnCliente = new float[]{50f, 25f, 25f};
            tablacli.setWidths(columnCliente);
            tablacli.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            PdfPCell cli1 = new PdfPCell(new Phrase("DN1"));
            PdfPCell cli2 = new PdfPCell(new Phrase("Nombre"));
            PdfPCell cli3 = new PdfPCell(new Phrase("Apellido"));
            cli1.setBorder(0);
            cli2.setBorder(0);
            cli3.setBorder(0);
            tablacli.addCell(cli1);
            tablacli.addCell(cli2);
            tablacli.addCell(cli3);
            tablacli.addCell(admin.txtIdClienteFac.getText());
            tablacli.addCell(admin.txtNomClintFac.getText());
            tablacli.addCell(admin.txtApeClintFac.getText());

            // Obtener datos de la tabla y agregarlos a la tabla de productos
            PdfPTable tablapro = new PdfPTable(5); // 5 columnas para los datos de producto
            tablapro.setWidthPercentage(100);
            float[] columnpro = new float[]{25f, 25f, 25f, 25f, 25f}; // Ancho de las columnas
            tablapro.setWidths(columnpro);

            PdfPCell p1 = new PdfPCell(new Phrase("fac"));
            PdfPCell p2 = new PdfPCell(new Phrase("Nombre"));
            PdfPCell p3 = new PdfPCell(new Phrase("Cant"));
            PdfPCell p4 = new PdfPCell(new Phrase("Precio U"));
            PdfPCell p5 = new PdfPCell(new Phrase("Precio T"));

            p1.setBorder(0);
            p2.setBorder(0);
            p3.setBorder(0);
            p4.setBorder(0);
            p5.setBorder(0);

            tablapro.addCell(p1);
            tablapro.addCell(p2);
            tablapro.addCell(p3);
            tablapro.addCell(p4);
            tablapro.addCell(p5);

            for (int i = 0; i < 1; i++) {
                Integer fac = (Integer) admin.tblFacturaEleccipn.getValueAt(i, 1);
                String nombre = (String) admin.tblFacturaEleccipn.getValueAt(i, 2);
                Integer cantidad = (Integer) admin.tblFacturaEleccipn.getValueAt(i, 3);
                Integer precioU = (Integer) admin.tblFacturaEleccipn.getValueAt(i, 4);
                Integer precioT = (Integer) admin.tblFacturaEleccipn.getValueAt(i, 5);

                // Convertir los valores Integer a String
                String cantidadStr = cantidad.toString();
                String precioUStr = precioU.toString();
                String precioTStr = precioT.toString();
                String facTStr = fac.toString();
                // Agregar los datos a la tabla
                tablapro.addCell(facTStr);
                tablapro.addCell(nombre);
                tablapro.addCell(cantidadStr);
                tablapro.addCell(precioUStr);
                tablapro.addCell(precioTStr);
            }
            doc.add(tablacli);
            doc.add(tablapro);
            doc.close();
            archivo.close(); // Cerrar el flujo de salida después de cerrar el documento
        } catch (Exception e) {
            System.out.println("Número de columnas: " + admin.tblFacturaEleccipn.getColumnCount());
            e.printStackTrace(); // Imprimir la traza de la excepción en caso de error
        }
    }
     */
    public void limpiartabla() {
        int rowCount = modelo.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin.btnActualizarFactura) {
            ActualizarTablaFactura();
        }
        if (e.getSource() == admin.btnExcel) {
            btnExcell();
        }
        //Cambios de paneles
        if (e.getSource() == admin.jmiOrdenes) {
            pedidosAggPaneles();

        }
        if (e.getSource() == cajero.jmiOrdenes) {
            pedidosAggPaneles2();
        }
        if (e.getSource() == admin.jmiClientes) {
            clienteAggPaneles();
        }
        if (e.getSource() == cajero.jmiClientes) {
            clienteAggPaneles2();
        }
        if (e.getSource() == admin.jmiEmpleado) {
            empleadosAggPaneles();
        }
        if (e.getSource() == admin.jmiProductos) {
            productosAggPaneles();
        }
        if (e.getSource() == cajero.jmiProductos) {
            productosAggPaneles2();
        }
        if (e.getSource() == admin.jmiClienteConsu) {
            clienteConsuPaneles();
            listarClientes(admin.tblClientes);
        }
        if (e.getSource() == cajero.jmiClienteConsu) {
            clienteConsuPaneles2();
            listarClientes(admin.tblClientes);
        }
        if (e.getSource() == admin.jmiEmpleadoConsu) {
            empleadoConsuPaneles();
            listarEmpleado(admin.tblEmpleados);
        }
        if (e.getSource() == admin.buscarInven) {
            inventarioConsuPaneles();
        }
        if (e.getSource() == admin.jmifactura) {
            facturaConsuPaneles();
        }
        if (e.getSource() == admin.MesasL) {
            mesasPaneles();
        }
        if (e.getSource() == admin.CajaS) {
            cierreCajaPaneles();
        }
        if (e.getSource() == admin.btnCkeckIn) {
            System.out.println("GA");
            checkIn();
        }
        if (e.getSource() == admin.cerrar) {
            try {
                cerrarSesion();
            } catch (FontFormatException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Ingreso al login
        if (e.getSource() == ventana.BtnLogin) {
            if (ventana.CampoUsuario.getText().isEmpty() || ventana.CampoContraseña.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                ventana.CampoContraseña.requestFocus();
            } else {
                try {
                    try {
                        btnIngresar();
                    } catch (SQLException ex) {
                        Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FontFormatException ex) {
                    Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == admin.btnAgregarC) {
            if (admin.txtNombreC.getText().isEmpty() || admin.txtApellidoC.getText().isEmpty()
                    || admin.txtCedulaC.getText().isEmpty() || admin.txtTelefonoC.getText().isEmpty()
                    || admin.txtDireccionC.getText().isEmpty() || admin.txtCedulaC.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Debes llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                admin.txtCedulaC.requestFocus();
            } else {
                btnAgregarCliente();
                limpiarcajasCliente();
                limpiartabla();
                listarClientes(admin.tblClientes);
            }
        }

        if (e.getSource() == admin.btnAgregarEm) {
            if (admin.txtNombreE.getText().isEmpty() || admin.txtApellidoE.getText().isEmpty()
                    || admin.txtDocE.getText().isEmpty() || admin.txtCelE.getText().isEmpty()
                    || admin.txtUserE.getText().isEmpty() || admin.txtClaveE.getText().isEmpty()
                    || admin.cmbEmpleado.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Debes llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                admin.txtDocE.requestFocus();
            } else {
                try {
                    btnAgregarEmple();
                    limpiarcajasEmpleado();
                    limpiartabla();
                    listarEmpleado(admin.tblEmpleados);
                } catch (SQLException ex) {
                    Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        if (e.getSource() == admin.btnModificarEmpl) {
            if (admin.txtNombreConsuEmpl.getText().isEmpty() || admin.txtIdConsuEmpl.getText().isEmpty()
                    || admin.txtCedulaConseEmpl.getText().isEmpty() || admin.txtTelefonoConsuEmpl.getText().isEmpty()
                    || admin.txtUserConsuEmpl.getText().isEmpty() || admin.txtClaveConsuEmpl.getText().isEmpty()
                    || admin.jcmRConsuEmpl.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Debes llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                admin.txtDocE.requestFocus();
            } else {
                try {
                    btnModificarEmple();
                    limpiarcajasEmpleado();
                    limpiartabla();
                    listarEmpleado(admin.tblEmpleados);
                } catch (SQLException ex) {
                    Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        if (e.getSource() == admin.modificarCliente) {
            
            if (admin.txtNombreConsCli.getText().isEmpty() || admin.txtApellidoConsuCli.getText().isEmpty()
                    || admin.txtDireccionConsuCli.getText().isEmpty() || admin.txtCedulaConsuCli1.getText().isEmpty()
                    || admin.txtTelefonoConsuCli.getText().isEmpty() || admin.txtIdConsuCli.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
//                admin.txtDocE.requestFocus();
            } else {
                try {
                    btnModificarCliente();
                    limpiarcajasEmpleado();
                    limpiartabla();
                    listarEmpleado(admin.tblClientes);
                } catch (SQLException ex) {
                    Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        if (e.getSource() == admin.btnActualizarFactura) {
            ActualizarTablaFactura();
        }
        if (e.getSource() == admin.btnEliminarFactura) {
            eliminarFactura();
        }

        if (e.getSource() == admin.btnPorcion) {

            try {
                btnAgregarPorcion();
                ingresarInvenSalida();
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == admin.btnConsultarEm) {
            try {
                btnConsultarEmpleado(admin.tblEmpleados);
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == admin.btnEliminarEmp) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                btnEliminarEmpleado();
                listarEmpleado(admin.tblEmpleados);
            }
        }
        if (e.getSource() == admin.btnConsultaCL) {
            btnConsultarCliente(admin.tblClientes);
        }
        if (e.getSource() == admin.btnEliminarClie) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                btnEliminarCliente();
                listarClientes(admin.tblClientes);
            }
        }
        if (e.getSource() == admin.btnActbCli) {
            listarClientes(admin.tblClientes);

        }
        if (e.getSource() == admin.btnActblE) {
            listarEmpleado(admin.tblEmpleados);
        }
        if (e.getSource() == admin.btnActuaMesa) {
            try {
                listarMesas(admin.tblEleccionMesa);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        if (e.getSource() == admin.btnAggPedidos) {

            try {
                KeyEvent fakeEvent = new KeyEvent(admin.txtCantidadProPed, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
                ingresarPedidos(fakeEvent);
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == admin.btnActuaTabPenPet) {
            try {

                listaPedidos(admin.tblPedidoPendiente);
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == admin.btnPedidosListo) {
            KeyEvent fakeEvent = new KeyEvent(admin.txtCantidadProPed, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
            try {
                pedidosListo(fakeEvent);
                //listaPedidosListo(admin.tblPedidoListo);
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == admin.btnAggProInv) {
            KeyEvent fakeEvent = new KeyEvent(admin.txtNomProdInv, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
            try {

                ingresarInvenEntrada(fakeEvent);
                limpiarCajaInventario();
                //listaPedidosListo(admin.tblPedidoListo);
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == admin.btnActualizarInv) {

            listarInventario(admin.tblInventario);
        }
        if (e.getSource() == admin.txtProductoDet) {
            KeyEvent fakeEvent = new KeyEvent(admin.txtProductoDet, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
            try {
                buscarPrecio(fakeEvent);

            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == admin.txtIdClienteFac) {
            KeyEvent fakeEvent = new KeyEvent(admin.txtIdClienteFac, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
            try {
                buscarDNICli(fakeEvent);
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == admin.btnFacturar) {
            KeyEvent fakeEvent1 = new KeyEvent(admin.txtCantProdDet, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
            KeyEvent fakeEvent2 = new KeyEvent(admin.txtCantProdDet, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
            try {
                // registrarDetalle(fakeEvent1);
                factura(fakeEvent2);
                eliminarFactura();
                limpiartabla();

                //reportePdf();
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == admin.txtCantProdDet) {
            KeyEvent fakeEvent1 = new KeyEvent(admin.txtCantProdDet, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
            try {
                registrarDetalle(fakeEvent1);
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == admin.txtIdMesero) {
            KeyEvent fakeEvent1 = new KeyEvent(admin.txtIdMesero, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
            try {
                buscarDNIMese(fakeEvent1);
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == admin.txtIdCajeroFac) {
            KeyEvent fakeEvent1 = new KeyEvent(admin.txtIdCajeroFac, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
            try {
                buscarDNIEmple(fakeEvent1);
            } catch (SQLException ex) {
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == admin.btnMonto) {
            ingresos();
        }
    }
}
