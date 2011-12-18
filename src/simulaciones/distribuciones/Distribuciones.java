/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulaciones.distribuciones;

import java.util.ArrayList;

/**
 *
 * @author warlock
 */
public class Distribuciones {
    
    
    public static double distribucionNormal(double media, double varianza,ArrayList<Float> num){
        double resultado = 0;
        double sumatoria=0;
        for(int i=0;i<num.size();i++)
            sumatoria+=num.get(i);

        resultado=media+(varianza*(sumatoria-6));
        return resultado;
    }
}
