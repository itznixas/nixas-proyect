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

/**
 *
 * @author Royer
 */
public class loginCtrl implements ActionListener{
    regEmpleado reG = new regEmpleado();
    regEmpleadoDAO emD = new regEmpleadoDAO();
    ventanaLogin ventana = new ventanaLogin();
    private MouseListener l;
 

   public loginCtrl(ventanaLogin ventana){
       this.ventana = ventana;
       this.ventana.BtnLogin.addActionListener(this);
       
   }
    
    

   public void btnIngresar(){
    String user = ventana.getCampoUsuario().getText();
    String clave = ventana.getCampoContraseña().getText();
    
    // Establecer los valores de usuario y contraseña en la instancia reG
    reG.setUserEmpl(user);
    reG.setClaveEmpl(clave);
    
    // Llamar al método autenticacion
    if(emD.autenticacion(reG)){
        JOptionPane.showMessageDialog(null, "Correcto");
    }else{
        System.out.println("Error");
        JOptionPane.showMessageDialog(null, "Contraseña o usuario mal");
    }
}


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== ventana.BtnLogin){
           btnIngresar();
       }
        
        
        
        
        
        
      
    }
}
