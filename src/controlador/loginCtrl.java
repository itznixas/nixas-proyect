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
    
    

    public  void btnIngresar(){
        
       String user = ventana.getCampoUsuario().getText();
       String clave = ventana.getCampoContraseña().getText();
        
        
        if(emD.autenticacion(reG)){
        JOptionPane.showMessageDialog(null, "Correcto");
        }else{
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
