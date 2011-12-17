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
public class GirarDados extends Thread{
        JLabel jLabelDado1;
        JLabel jLabelDado2;
        URL dadoCara1;
        URL dadoCara2;
        URL dadoCara3;
        URL dadoCara4;
        URL dadoCara5;
        URL dadoCara6;
//        int velocidad;

        public GirarDados(){
            dadoCara1= getClass().getResource("/Vista/dado_1.png");
            dadoCara2= getClass().getResource("/Vista/dado_2.png");
            dadoCara3= getClass().getResource("/Vista/dado_3.png");
            dadoCara4= getClass().getResource("/Vista/dado_4.png");
            dadoCara5= getClass().getResource("/Vista/dado_5.png");
            dadoCara6= getClass().getResource("/Vista/dado_6.png");
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
                    insertarImagen(dadoCara1, jLabelDado1);
                    break;
                case 2:
                    insertarImagen(dadoCara2, jLabelDado1);
                    break;
                case 3:
                    insertarImagen(dadoCara3, jLabelDado1);
                    break;
                case 4:
                    insertarImagen(dadoCara4, jLabelDado1);
                    break;
                case 5:
                    insertarImagen(dadoCara5, jLabelDado1);
                    break;
                case 6:
                    insertarImagen(dadoCara6, jLabelDado1);
                    break;
            }
        }

        public void seleccionarDado2(int r){
            switch(r){
                case 1:
                    insertarImagen(dadoCara1, jLabelDado2);
                    break;
                case 2:
                    insertarImagen(dadoCara2, jLabelDado2);
                    break;
                case 3:
                    insertarImagen(dadoCara3, jLabelDado2);
                    break;
                case 4:
                    insertarImagen(dadoCara4, jLabelDado2);
                    break;
                case 5:
                    insertarImagen(dadoCara5, jLabelDado2);
                    break;
                case 6:
                    insertarImagen(dadoCara6, jLabelDado2);
                    break;
            }
        }


        public JLabel getjLabelDado1() {
            return this.jLabelDado1;
        }

        public void setjLabelDado1(JLabel jLabelDado1) {
            this.jLabelDado1 = jLabelDado1;
        }

        public JLabel getjLabelDado2() {
            return this.jLabelDado2;
        }

        public void setjLabelDado2(JLabel jLabelDado2) {
            this.jLabelDado2 = jLabelDado2;
        }

//        public int getVelocidad() {
//            return velocidad;
//        }
//
//        public void setVelocidad(int velocidad) {
//            this.velocidad = velocidad;
//        }




}
