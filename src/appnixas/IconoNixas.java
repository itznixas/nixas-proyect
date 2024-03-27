package appnixas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class IconoNixas{

    public static void establecerIcono(JFrame frame) {
        ImageIcon icono = new ImageIcon(IconoNixas.class.getResource("/componentes/img/perfil.png")); 

        frame.setIconImage(icono.getImage());
    }
}