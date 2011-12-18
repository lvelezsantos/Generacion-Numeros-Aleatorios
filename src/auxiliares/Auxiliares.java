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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import simulaciones.SimulacionInventario;

/**
 *
 * @author warlock
 */
public class Auxiliares {
    public static boolean esDivisible(int numerador, int denominador){
        boolean resultado;
        if(numerador%denominador == 0)
            resultado = true;
        else
            resultado= false;
        
        return resultado;
    }

    public static boolean esImpar(int numero){
        boolean resultado;
        if(numero%2 != 0)
            resultado = true;
        else
            resultado= false;

        return resultado;
    }

    public static boolean esPrimo(int numero){
        if (numero%2==0)
            return false;
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }

    public static int maximoComunDivisor(int a, int b){
        int resultado;
        if(b==0)
            resultado = a;
        else
            resultado = maximoComunDivisor(b, a% b);

        return resultado;
    }

    public static boolean primoRelativo(int a, int b){
        boolean resultado;
        int mcd;
        if(a>b){
            mcd= maximoComunDivisor(a, b);
        }else{
            mcd =maximoComunDivisor(b, a);
        }
        if(mcd==1)
            resultado=true;
        else
            resultado=false;
        
        return resultado;
    }

    public static float mediaAritmetica(ArrayList<Float> numeros){
        float resultado = 0;
        float acum=0;
        Iterator n = numeros.iterator();        
        int i=0;
        while(n.hasNext()){
            acum += (Float)n.next();
        }             
        resultado=acum/numeros.size();
//        System.out.println("Media: "+resultado);
        return resultado;
    }

    public static int selecionDeACongruencialMixtoMultiplicativoSumado(int t){
        return ((8*t)+3);
    }
    public static int selecionDeACongruencialMixtoMultiplicativoRestado(int t){
        return ((8*t)-3);
    }

    public static ArrayList factoresPrimosImpares(int m){
        ArrayList vector = new ArrayList();
        for(int i=3;i<(m/2);i++){
            if(esPrimo(i)&&m%i==0){
                vector.add(i);
//                System.out.println(i);
            }
        }
        return vector;
    }

    public static boolean validarVariablesAuxiliaresMC(int a, int d,int m){
        ArrayList numeros= factoresPrimosImpares(m);
        for(int i=0;i<numeros.size();i++){
            int aux=(Integer)numeros.get(i);
            boolean flag=(d%aux==0&&(a-1)%aux==0);
            if(!flag){
                return false;
            }
        }
        return true;
    }

     public static boolean ValidarDyA_MC(int m, int a,int d,int c){
        boolean flag=true;
        if(m%4==0){
            flag=(a-1)%4==d&&d%2==0;
            if(!flag){
                return false;
            }
        }if(m%2==0){
            flag=(a-1)%2==d&&d%2==0;
            if(!flag){
                return false;
            }
        }if(m%9==0){
            flag=((0)%9==d)||(1%9==a&&(c*d==6%9));
            if(!flag){
                return false;
            }
        }
        return true;
    }

     public static int convertirStringAEntero(JTextField cad){
         int num=0;
         try{
             num = Integer.parseInt(cad.getText());
         }catch(Exception e){
             System.err.println("Error Convertir String a Entero");
         }
         return num;
     }
     
     public static void dormirHilo(int velocidad){
         try {
                    Thread.sleep(velocidad);
         } catch (InterruptedException ex) {
                    ex.printStackTrace();
         }
     }
}
