/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.util.Calendar;
import javax.swing.JOptionPane;


public class MetodoMoore {
    private double m;
    private int k=54,j=23;
    double y[];
    int periodo;

    public MetodoMoore(double m) {
        this.m = m;
        periodo=0;
        definirvector();
    }

    public double siguienteMoore(){
        y[k]=(y[k]+y[j])%m;
        j=j-1;
        k=k-1;
        double aux=y[k];
        periodo++;
        if(j==0){
            j=54;
        }
        if(k==0){
            k=54;
        }
        return aux/m;
    }
    public double siguiente(){
        y[k]=(y[k]+y[j])%m;
        j=j-1;
        k=k-1;
        double aux=y[k];
        periodo++;
        if(j==0){
            j=54;
        }
        if(k==0){
            k=54;
        }
        return aux;
    }
    private  void definirvector(){
        y= new double[55];
        Calendar c= Calendar.getInstance();
        double numero1=(double)c.get(Calendar.MILLISECOND)/100;
        double numero2=(double)(c.get(Calendar.SECOND));
        MetodoFibonacci me= new MetodoFibonacci(numero1, numero2, m);
        for(int i=0;i<55;i++){
           y[i]=me.nuevo();
           
        }
    }
    public boolean MesValido() {
    if(m %2 != 0)
        JOptionPane.showMessageDialog(null,"M mod 2 = 0");
        return m%2 == 0;

    }
    public boolean periodoCompleto() {
        return periodo >= m*m;
    }
}
