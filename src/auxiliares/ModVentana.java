/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Autores:
 * Luis Alfonso Velez Santos
 * Carlos Yesid Hernandez Herrera
 * Jose Esteban Betin Diaz
 */

package auxiliares;

//import com.nilo.plaf.nimrod.NimRODLookAndFeel;
//import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import java.io.IOException;


/**
 *
 * @author Scot3004
 */
public class ModVentana {
    
    public static void ubicarVentana(java.awt.Window ventana) {
        java.awt.Dimension dim = ventana.getToolkit().getScreenSize();
        System.out.print(dim.getWidth()+" x "+dim.getHeight());
        ventana.setBounds(25, 25, (int) (dim.getWidth() - 50), (int) (dim.getHeight() - 75));
        ventana.requestFocus();
    }
//
//    public static void cargarNimROD(){
//         try {
//            UIManager.setLookAndFeel( new NimRODLookAndFeel());
//        } catch (UnsupportedLookAndFeelException ex) {
//            System.out.println("Operacion No Soportada"+ex.getMessage());
//        }
//    }

    public static void centrar(java.awt.Window ventana) {
        java.awt.Dimension dim = ventana.getToolkit().getScreenSize();
        java.awt.Rectangle abounds = ventana.getBounds();
        ventana.setLocation((dim.width - abounds.width) / 2
                , (dim.height - abounds.height) / 2);
        ventana.requestFocus();
    }

    public static void colocarFavicon(String pathImagen, java.awt.Window ventana){
        try {
            java.awt.Image image = javax.imageio.ImageIO.read(ventana.getClass().getResource(pathImagen));
            ventana.setIconImage(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void colocarFavicon(java.awt.Image image, java.awt.Window ventana){
        ventana.setIconImage(image);
    }
}
