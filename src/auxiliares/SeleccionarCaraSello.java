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

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author warlock
 */
public class SeleccionarCaraSello extends Thread{
        JLabel jLabelMoneda;
        URL cara;
        URL sello;
        
//        int velocidad;

        public SeleccionarCaraSello(){
            cara= getClass().getResource("/Vista/Cara.png");
            sello= getClass().getResource("/Vista/sello.png");
        }

        private void insertarImagen(URL imagen, JLabel jLabel){
        ImageIcon image = new ImageIcon(imagen);
        jLabel.setText("");
            if(image.getIconWidth() > 195 || image.getIconHeight() > 161){
                ImageIcon imageScalada = new ImageIcon(image.getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), java.awt.Image.SCALE_DEFAULT));
                jLabel.setIcon(imageScalada);
            }else{
                jLabel.setIcon(image);
            }
        }



        public void seleccionarDado1(int r){
            switch(r){
                case 1:
                    insertarImagen(cara, jLabelMoneda);
                    break;
                case 2:
                    insertarImagen(sello, jLabelMoneda);
                    break;
            }
        }

       


        public JLabel getjLabelMoneda() {
            return this.jLabelMoneda;
        }

        public void setjLabelMoneda(JLabel jLabelDado1) {
            this.jLabelMoneda = jLabelDado1;
        }





}
