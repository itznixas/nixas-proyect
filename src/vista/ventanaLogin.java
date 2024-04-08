package vista;

import controlador.loginCtrl;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import appnixas.IconoNixas;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ventanaLogin extends javax.swing.JFrame {

    public ventanaLogin() throws FontFormatException, IOException {
        initComponents();
        IconoNixas.establecerIcono(this);
        this.setLocationRelativeTo(null);
        try {
            InputStream inputStream = getClass().getResourceAsStream("/fonts/Helixa-Bold.otf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(40f);
            jLabel5.setFont(font);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTransparente1 = new LIB.JPanelTransparente();
        CampoUsuario = new componentes.TextField();
        CampoContraseña = new componentes.PasswordField();
        BtnLogin = new javax.swing.JButton();
        TituloInicioSesion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTransparente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CampoUsuario.setHint("USER");
        jPanelTransparente1.add(CampoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 220, -1));

        CampoContraseña.setHint("PASSWORD");
        jPanelTransparente1.add(CampoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 220, -1));

        BtnLogin.setBackground(new java.awt.Color(22, 18, 38));
        BtnLogin.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        BtnLogin.setForeground(new java.awt.Color(255, 255, 255));
        BtnLogin.setText("LOG IN");
        jPanelTransparente1.add(BtnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 260, 50));

        TituloInicioSesion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        TituloInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        TituloInicioSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloInicioSesion.setText("SIGN IN TO YOUR ACCOUNT");
        jPanelTransparente1.add(TituloInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 370, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoUsuario.png"))); // NOI18N
        jPanelTransparente1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/IconoContraseña.png"))); // NOI18N
        jPanelTransparente1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 40));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("HELLO");
        jPanelTransparente1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 370, 70));

        getContentPane().add(jPanelTransparente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 370, 510));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/MejorLogo (1).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componentes/img/FondoImgLogin (1).jpeg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaLogin login;
                try {
                    login = new ventanaLogin();
                    loginCtrl lox = new loginCtrl(login);
                    login.setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(ventanaLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ventanaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }

                //new ventanaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnLogin;
    public componentes.PasswordField CampoContraseña;
    public componentes.TextField CampoUsuario;
    private javax.swing.JLabel TituloInicioSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private LIB.JPanelTransparente jPanelTransparente1;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnLogin() {
        return BtnLogin;
    }

    public JPasswordField getCampoContraseña() {
        return CampoContraseña;
    }

    public JTextField getCampoUsuario() {
        return CampoUsuario;
    }
}
