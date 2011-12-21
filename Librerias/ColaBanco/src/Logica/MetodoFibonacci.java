/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import javax.swing.JOptionPane;


public class MetodoFibonacci {
    private double xn;
    private double xn1;
    private double m;
    private int periodo;

    public MetodoFibonacci(double xn, double xn1, double m) {
        this.xn = xn;
        this.xn1 = xn1;
        this.m = m;
    }

    public double nuevonumero(){
        double x=(xn1+xn)%m;
        xn1=xn;
        periodo++;
        xn=x;
        return x/m;
    }
    public double nuevo(){
        double x=(xn1+xn)%m;
        xn1=xn;
        periodo++;
        xn=x;
        return x;
    }
      public boolean esPar() {

        if (m % 2 != 0 ) {
            JOptionPane.showMessageDialog(null,"M - debe ser par");
            return false;
        }
        return true;
    }
    public boolean periodoCompleto() {
        return periodo >= m*m;
    }

    
}
