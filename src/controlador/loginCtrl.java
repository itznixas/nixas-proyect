/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import vista.ventanaLogin;
import modelo.*;
import java.awt.event.ActionEvent;
import modelo.regEmpleadoDAO;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import vista.MenuAdmin;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Royer
 */
public class loginCtrl implements ActionListener{
    regEmpleado reG = new regEmpleado();
    regEmpleadoDAO emD = new regEmpleadoDAO();
    ventanaLogin ventana = new ventanaLogin();
    MenuAdmin admin = new MenuAdmin();
    DefaultTableModel modelo = new DefaultTableModel();
    clienteDAO cli = new clienteDAO();
    private MouseListener l;
 

    public loginCtrl(ventanaLogin ventana){
        this.ventana = ventana;
        this.ventana.BtnLogin.addActionListener(this);
      // this.admin.btnAgregarEm.addActionListener(this);
   }
   
   
    public loginCtrl(MenuAdmin admin) {
        this.admin = admin;
        this.admin.btnAgregarC.addActionListener(this);
        this.admin.btnAgregarEm.addActionListener(this);
    }
      //Ingreso a login
    public void btnIngresar(){
        System.out.println("pete");
        String user = ventana.getCampoUsuario().getText();
        String clave = ventana.getCampoContraseña().getText();
         // Establecer los valores de usuario y contraseña en la instancia reG
        reG.setUserEmpl(user);
        reG.setClaveEmpl(clave);
         // Obtener el rol
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
                    cajero.btnAgregarEm.setEnabled(false);
                    ventana.setVisible(false);
                break;
                default:
                     System.out.println("Rol no encontrado");
                break;
                }     
            }
             //Tabla de cliente
    public void listarClientes(JTable tblClientes){
        modelo = (DefaultTableModel) tblClientes.getModel();
            try{
                List<regEmpleado> listarClientes = cli.listarCliente();
                Object[] object = new Object[5];
                for (int i = 0; i < listarClientes.size(); i++)
                {
                    object[0] = listarClientes.get(i).getNombreEmpl();
                    object[1] = listarClientes.get(i).getApellidoEmpl();
                    object[2] = listarClientes.get(i).getCedulaEmpl();
                    object[3] = listarClientes.get(i).getCelEmpl();
                    object[4] = listarClientes.get(i).getDireccion();
                    modelo.addRow(object);
                }
                    admin.tblClientes.setModel(modelo);
                } catch (SQLException ex){   
                Logger.getLogger(loginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
            
    public void btnAgregarCliente(){
        System.out.println("Sirviiooo");
        regEmpleado cliente = new regEmpleado();
        clienteDAO cliD = new clienteDAO();

        String nombreCliente = admin.txtNombreC.getText();
        String apellidoCliente = admin.txtApellidoC.getText();
        // Verifica que los campos de texto no estén vacíos antes de convertir a enteros
        int cedulaCliente = 0;
        int celularCliente = 0;
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
            }
    
    public void limpiarcajasCliente(){
        admin.txtNombreC.setText(null);
        admin.txtApellidoC.setText(null);
        admin.txtCedulaC.setText(null);
        admin.txtTelefonoC.setText(null);
        admin.txtDireccionC.setText(null);
        admin.txtCedulaC.requestFocus();
                }
        
    //Agregar empleado
    public void btnAgregarEmple(){
        regEmpleado empleado = new regEmpleado();
        regEmpleadoDAO dao = new regEmpleadoDAO();
        
        String nombreEm = admin.txtNombreE.getText();
        String apellidoEm = admin.txtApellidoE.getText();
        String usuarioEm = admin.txtUserE.getText();
        String claveEm = admin.txtClaveE.getText();
        int idRol = 0;
        int docEmp = 0;
        int celEm = 0;
         try {
                if (!admin.txtDocE.getText().isEmpty()) {
                    docEmp = Integer.parseInt(admin.txtDocE.getText());
                    }
                if (!admin.txtCelE.getText().isEmpty()) {
                    celEm = Integer.parseInt(admin.txtCelE.getText());
                    }

                    String direccionCliente = admin.txtDireccionC.getText();
                    empleado.setNombreEmpl(nombreEm);
                    empleado.setApellidoEmpl(apellidoEm);
                    empleado.setCedulaEmpl(docEmp);
                    empleado.setCelEmpl(celEm);
                    empleado.setUserEmpl(usuarioEm);
                    empleado.setClaveEmpl(claveEm);                  
                    int r = dao.agregarEmpleado(empleado);
                    
                if (r == 1) {
                    JOptionPane.showMessageDialog(admin, "Registro exitoso");
                } else {
                    JOptionPane.showMessageDialog(admin, "Error al registrar cliente");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(admin, "Error en el formato de datos. Verifica los campos numéricos.");
                }

    }
    

        //Cmbiar el metodo 
        public void limpiartabla(){
 
                          }

  


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== ventana.BtnLogin){
           btnIngresar();
       }
        if(e.getSource()== admin.btnAgregarC){  
            btnAgregarCliente();
            limpiarcajasCliente();
            limpiartabla();
            listarClientes(admin.tblClientes);
       }
        if(e.getSource()== admin.btnAgregarEm){
            btnAgregarEmple();
        }
    }

    
}
