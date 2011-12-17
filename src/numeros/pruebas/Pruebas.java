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



package numeros.pruebas;


import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author warlock
 */
public class Pruebas {
    public void pruebaPromedios(ArrayList<Float> numeros){
//        float z = (float) (((auxiliares.Auxiliares.mediaAritmetica(numeros)-(1/2))* Math.sqrt(100)) / (Math.sqrt(1 / 12)));
        if(!numeros.isEmpty()){
            float promedio = auxiliares.Auxiliares.mediaAritmetica(numeros);
            System.out.println(promedio);
            float numerador =  (float) ((promedio - 0.5) * Math.sqrt(numeros.size()));

            float estadistico = Math.abs((float) (numerador / Math.sqrt(0.08333)));
            System.out.println(estadistico);

            if(estadistico<1.96){
                JOptionPane.showMessageDialog(null, "Los numeros son aceptados", "Error", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Los numeros no son aceptados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
                JOptionPane.showMessageDialog(null, "La lista esta vacia", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pruebaFrecuencias(ArrayList<Float> numeros){
//        int acum1,acum2,acum3,acum4,acum5;
//        acum1=acum2=acum3=acum4=acum5=0;
        if(!numeros.isEmpty()){
            int acum[]= {0,0,0,0,0};
            float frecuenciaEsperada=(float)numeros.size()/5;
            System.out.println(frecuenciaEsperada);
            for(int i=0;i<numeros.size();i++){
                float num = (float)numeros.get(i);
    //            System.out.println(num);
                if(num>=0 && num<0.2)
                    acum[0]++;
                else if(num>=0.2 && num<0.4)
                    acum[1]++;
                else if(num>=0.4 && num<0.6)
                    acum[2]++;
                else if(num>=0.6 && num<0.8)
                    acum[3]++;
                else if(num>=0.8 && num<=1)
                    acum[4]++;
            }
    //        System.out.println(acum[0]);
            float estadistico=0;
            for (int i=0;i<5;i++){
               estadistico += (float)(((acum[i]-frecuenciaEsperada)*(acum[i]-frecuenciaEsperada))/frecuenciaEsperada);
    //                   System.out.println(estadistico);
            }

    //        System.out.println("Acum1:"+acum[4]);

            if(estadistico<9.49)
                JOptionPane.showMessageDialog(null, "Los numeros son aceptados", "Error", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Los numeros no son aceptados", "Error", JOptionPane.ERROR_MESSAGE);
         }else
             JOptionPane.showMessageDialog(null, "La lista esta vacia", "Error", JOptionPane.ERROR_MESSAGE);
    }

}

