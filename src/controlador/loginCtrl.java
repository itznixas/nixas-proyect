package controlador;


import vista.*;
import modelo.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class loginCtrl implements ActionListener {
    regEmpleado reG = new regEmpleado();
    regEmpleadoDAO emD = new regEmpleadoDAO();
    ventanaLogin ventana = new ventanaLogin();
    MenuAdmin admin = new MenuAdmin();
    DefaultTableModel modelo = new DefaultTableModel();
    clienteDAO cli = new clienteDAO();

    public loginCtrl(ventanaLogin ventana) {
        this.ventana = ventana;
        this.ventana.BtnLogin.addActionListener(this);
    }

    public loginCtrl(MenuAdmin admin) {
        this.admin = admin;
        this.admin.btnAgregarC.addActionListener(this);
        this.admin.btnAgregarEm.addActionListener(this);
        this.admin.cmbEmpleado.addActionListener(this);
        this.admin.jmiOrdenes.addActionListener(this);
        this.admin.jmiClientes.addActionListener(this);
        this.admin.jmiProductos.addActionListener(this);
        this.admin.jmiEmpleado.addActionListener(this);
        this.admin.jmiClienteConsu.addActionListener(this);
        this.admin.jmiEmpleadoConsu.addActionListener(this);
        this.admin.cerrar.addActionListener(this);
        this.admin.btnPorcion.addActionListener(this);
    }

    //CAMBIAR PANELES
    public void pedidosAggPaneles(){
        admin.jTabbedPane.setSelectedIndex(1);
    }
    public void clienteAggPaneles(){
        admin.jTabbedPane.setSelectedIndex(2);
    }
    public void empleadosAggPaneles(){
        admin.jTabbedPane.setSelectedIndex(3);
    }
    public void productosAggPaneles(){
        admin.jTabbedPane.setSelectedIndex(4);
    }
    public void clienteConsuPaneles(){
        admin.jTabbedPane.setSelectedIndex(5);
    }
    public void empleadoConsuPaneles(){
        admin.jTabbedPane.setSelectedIndex(6);
    }
    public void cerrarSesion(){
         int a = JOptionPane.showConfirmDialog(admin.cerrar, "¿Desea cerrar sesion?");
        if (a == JOptionPane.YES_OPTION) {
            admin.dispose();
        ventanaLogin login = new ventanaLogin();
        loginCtrl lox = new loginCtrl(login);
        login.setVisible(true);
        }
    }
    
    //Metodo del login
    public void btnIngresar() {
        String user = ventana.CampoUsuario.getText();
        String clave = new String(ventana.CampoContraseña.getText());
        reG.setUserEmpl(user);
        reG.setClaveEmpl(hash.sha1(clave));
        int rol = emD.autenticacionRol(reG);

        switch (rol) {
            case 111:
                MenuAdmin m = new MenuAdmin();
                loginCtrl lx = new loginCtrl(m);
                m.iniciar();
                ventana.setVisible(false);
                break;
            case 222:
                MenuAdmin cajero = new MenuAdmin();
                loginCtrl lgx = new loginCtrl(cajero);
                cajero.iniciar();
                cajero.jTabbedPane.setVisible(false);
                ventana.setVisible(false);
                break;
            default:
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
            object[4] = listarClientes.get(i).getCelEmpl();
            object[5] = listarClientes.get(i).getDireccion();
            modelo.addRow(object);
        }

        modelo.fireTableDataChanged(); // Notificar a la vista que los datos han cambiado
    } catch (SQLException ex) {
        Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    public void btnAgregarCliente() {
        regEmpleado cliente = new regEmpleado();
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
            cliente.setNombreEmpl(nombreCliente);
            cliente.setApellidoEmpl(apellidoCliente);
            cliente.setCedulaEmpl(cedulaCliente);
            cliente.setCelEmpl(celularCliente);
            cliente.setDireccion(direccionCliente);

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

    public void limpiarcajasCliente() {
        admin.txtNombreC.setText(null);
        admin.txtApellidoC.setText(null);
        admin.txtCedulaC.setText(null);  
        admin.txtTelefonoC.setText(null);
        admin.txtDireccionC.setText(null);
       // admin.txtCedulaC.requestFocus();
    }

    public void btnAgregarEmple() {
        regEmpleado empleado = new regEmpleado();
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
            if (admin.cmbEmpleado.getSelectedItem().equals("Admin")) {
                id_rol = 111;
            } else if (admin.cmbEmpleado.getSelectedItem().equals("Cajero")) {
                id_rol = 222;
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
        listarEmpleado(admin.tblEmpleados);
      limpiartabla();
    }
    
    public void listarEmpleado (JTable tblEmpleado){
        modelo = (DefaultTableModel) tblEmpleado.getModel();
        modelo.setRowCount(0);
        
        try{
            List<regEmpleado> listarEmpleado =emD.listarEmpleado();
            Object[] object = new Object[9];
            
            for(int i = 0; i< listarEmpleado.size(); i++){
                  object[0] = listarEmpleado.get(i).getIdEmpl() ;
                  object[1] = listarEmpleado.get(i).getNombreEmpl();
                  object[2] = listarEmpleado.get(i).getApellidoEmpl() ;
                  object[3] = listarEmpleado.get(i).getCedulaEmpl();
                  object[4] = listarEmpleado.get(i).getCelEmpl();
                  object[5] = listarEmpleado.get(i).getUserEmpl();
                  object[6] = listarEmpleado.get(i).getClaveEmpl();
                  object[7] = listarEmpleado.get(i).getIdRol();
                    modelo.addRow(object);
            }
                    modelo.fireTableDataChanged();
        }catch (SQLException e){
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

    //Metodos de prociones
    public void btnAgregarPorcion(){
        producto prod = new producto(){};
        porcionesDAO porDAO = new porcionesDAO();
        bebidasDAO be = new bebidasDAO();
        String nombreB,nombreC;
        int cantidadB = 0;
        float precioB = 0;
        int cantidadC = 0;
        float precioC = 0;
        int id = 0;
        int r = 0;
        System.out.println("g");
        try{
          if (admin.cmbPorcion.getSelectedItem().equals("BEBIDAS")){
            id = 1;
             nombreB =admin.txtNombreP.getText();
             
               if (!admin.txtCantidadP.getText().isEmpty()) {
                cantidadB = Integer.parseInt(admin.txtDocE.getText());
               }
               if (!admin.txtPrecioP.getText().isEmpty()) {
                precioC = Float.parseFloat(admin.txtDocE.getText());
            }
             prod.setNombre(nombreB);
             prod.setCantidad(cantidadB);
             prod.setPrecio(precioB);
             r = be.agregarBebidas(prod);
              if (r == 1) {
                JOptionPane.showMessageDialog(admin, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(admin, "Error al registrar empleado");
            }
        }
          //METODO DE AGG COMIDA
          else if  (admin.cmbPorcion.getSelectedItem().equals("COMIDA")){
            id = 1;
             nombreB =admin.txtNombreP.getText();
             
               if (!admin.txtCantidadP.getText().isEmpty()) {
                cantidadC = Integer.parseInt(admin.txtDocE.getText());
               }
               if (!admin.txtPrecioP.getText().isEmpty()) {
                precioC = Float.parseFloat(admin.txtDocE.getText());
            }
             prod.setNombre(nombreB);
             prod.setCantidad(cantidadB);
             prod.setPrecio(precioB);
             r = porDAO.agregarPorciones(prod);
             if (r == 1) {
                JOptionPane.showMessageDialog(admin, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(admin, "Error al registrar empleado");
            }
        }
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(admin, "Error en el formato de datos. Verifica los campos numéricos.");
        }
            //Guardar datos de BEBIDAS
            
    }
    
    
        public void limpiartabla() {
            int rowCount = modelo.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                modelo.removeRow(i);
    }
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Cambios de paneles
        if(e.getSource() == admin.jmiOrdenes){
            pedidosAggPaneles();
        }
        if(e.getSource()== admin.jmiClientes){
            clienteAggPaneles();
        }
        if(e.getSource()== admin.jmiEmpleado){
            empleadosAggPaneles();
        }
        if(e.getSource()== admin.jmiProductos){
            productosAggPaneles();
        }
        if(e.getSource()== admin.jmiClienteConsu){
            clienteConsuPaneles();
        } 
        if(e.getSource()== admin.jmiEmpleadoConsu){
            empleadoConsuPaneles();
        }
        if(e.getSource()== admin.cerrar){
            cerrarSesion();
        }
        
        //Ingreso al login
        if (e.getSource() == ventana.BtnLogin) {
            if(ventana.CampoUsuario.getText().isEmpty() ||ventana.CampoContraseña.getText().isEmpty() ){
                 JOptionPane.showMessageDialog(null, "Debes llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                 ventana.CampoContraseña.requestFocus();
            }else{
                btnIngresar();
            }
        }
        if (e.getSource() == admin.btnAgregarC) {  
            if (admin.txtNombreC.getText().isEmpty() || admin.txtApellidoC.getText().isEmpty() ||
                admin.txtCedulaC.getText().isEmpty() || admin.txtTelefonoC.getText().isEmpty() ||
                admin.txtDireccionC.getText().isEmpty() || admin.txtCedulaC.getText().isEmpty()) {

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
           if(admin.txtNombreE.getText().isEmpty() ||admin.txtApellidoE.getText().isEmpty() ||
              admin.txtDocE.getText().isEmpty() || admin.txtCelE.getText().isEmpty() ||
              admin.txtUserE.getText().isEmpty() || admin.txtClaveE.getText().isEmpty() ||
              admin.cmbEmpleado.getSelectedItem()==null ){
                   JOptionPane.showMessageDialog(null, "Debes llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                   admin.txtDocE.requestFocus();
           }else{
                   btnAgregarEmple();
                   limpiarcajasEmpleado();
                   limpiartabla();
                   listarEmpleado(admin.tblEmpleados);
           }
        }
        if (e.getSource()== admin.btnPorcion){
            btnAgregarPorcion();
        }
    }
}
