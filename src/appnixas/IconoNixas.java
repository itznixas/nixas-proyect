package appnixas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class IconoNixas{

    public static void establecerIcono(JFrame frame) {
        ImageIcon icono = new ImageIcon(IconoNixas.class.getResource("/componentes/img/cursor.png")); 

        frame.setIconImage(icono.getImage());
    }
}