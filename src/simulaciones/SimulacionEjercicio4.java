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

package simulaciones;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import simulaciones.distribuciones.Distribuciones;

/**
 *
 * @author warlock
 */
public class SimulacionEjercicio4 extends Thread{
    ArrayList<Float> numeros1;
    ArrayList<Float> numeros2;
    String respuestaA;
    String respuestaB;
    JTextArea listaResultados;
    JList listaCorridas;    
    JButton boton;
    JProgressBar jp;
    
    int corridas;
    private JScrollPane jScrollPaneResultado;
    private int velocidad;

    public SimulacionEjercicio4() {

    }

    @Override
    public void run(){
        boton.setEnabled(false);
        simularPuntoB();
        simularPuntoA();
        //Vista
        listaResultados.append(respuestaA+"\n");
        listaResultados.append(respuestaB+"\n");
        
        Dimension tamanhoTextArea = listaResultados.getSize();
        Point p = new Point(0,tamanhoTextArea.height);
        jScrollPaneResultado.getViewport().setViewPosition(p);
        
        boton.setEnabled(true);
    }
//    public double distribucionNormal(double media, double varianza,ArrayList<Float> num){
//        double resultado = 0;
//        double sumatoria=0;
//        for(int i=0;i<num.size();i++)
//            sumatoria+=num.get(i);
//
//        resultado=media+(varianza*(sumatoria-6));
//        return resultado;
//    }

    public void simularPuntoB(){
        int i=0;
         int j=0;
         
         int valorVerdadero=0;
         float result=0;
         do{
            ArrayList<Float> x1 = new ArrayList();
            ArrayList<Float> x2 = new ArrayList();
            for(int l=0;l<12;l++){
                if(j==numeros1.size())
                    j=0;
                int m= j++;
                x1.add(this.numeros1.get(m));
                x2.add(this.numeros2.get(m));
            }
            double varX1=Distribuciones.distribucionNormal(1.5, 0.0016, x1);
            double varX2=Distribuciones.distribucionNormal(1.48, 0.0009, x2);
            double dif = varX1-varX2;
            System.out.println("Ejercicio b:"+dif);
            listaResultados.append("Ejercicio b:"+dif+"\n");
            if(dif<0.1){
                valorVerdadero++;
            }
            i++;
            result = (float)valorVerdadero/i;
            listaResultados.append("Resultado "+result+"\n");
            Dimension tamanhoTextArea = listaResultados.getSize();
            Point p = new Point(0,tamanhoTextArea.height);
            jScrollPaneResultado.getViewport().setViewPosition(p);
//            System.out.println("Resultado "+result);
         } while (result<0.95);
         respuestaB="El numero de veces que se debe ejecutar el experimento es: "+ i;
    }

    public void simularPuntoA(){
        int i=0;
        int j=0;
        int interferencia = 0;
        while(i<this.corridas){
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimulacionEjercicio4.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<Float> x1 = new ArrayList();
            ArrayList<Float> x2 = new ArrayList();
            for(int l=0;l<12;l++){
                if(j==numeros1.size())
                    j=0;
                int m= j++;
                x1.add(this.numeros1.get(m));
                x2.add(this.numeros2.get(m));
            }
            double varX1=Distribuciones.distribucionNormal(1.5, 0.0016, x1);
            double varX2=Distribuciones.distribucionNormal(1.48, 0.0009, x2);
            if(varX2>=varX1){
                listaResultados.append("Hay Interferencia: "+(varX1-varX2)+"\n");
                Dimension tamanhoTextArea = listaResultados.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneResultado.getViewport().setViewPosition(p);
                System.out.println("Hay Interferencia: "+(varX1-varX2));
                interferencia++;
            }else{

                listaResultados.append("No Hay Interferencia: "+(varX1-varX2)+"\n");
                Dimension tamanhoTextArea = listaResultados.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneResultado.getViewport().setViewPosition(p);
                System.out.println("No Hay Interferencia: "+(varX1-varX2));
            }
            i++;
            
            float value=(float)i/corridas;
            int valor = (int) (value * 100);
            jp.setValue(valor);
            jp.setString("Simulando: "+ valor +" %");

        }
        double inter = (double)interferencia/corridas;
        respuestaA="La probabilidad de que haya interferencia es: " +(inter*100);
        listaResultados.append(respuestaA+"\n");

        
    }
//    public static void main(String args[]){
//        NumerosRectangulares g = new NumerosRectangulares();
//        Ejercicio4 e = new Ejercicio4();
//        e.setCorridas(100);
//        e.setNumeros1(g.metodoAditivoGreen(10000, 500));
//        e.setNumeros2(g.metodoAditivoGreen(10000, 500));
//        e.simularPuntoA();
//    }

    public int getCorridas() {
        return corridas;
    }

    public void setCorridas(int corridas) {
        this.corridas = corridas;
    }

    public ArrayList<Float> getNumeros1() {
        return numeros1;
    }

    public void setNumeros1(ArrayList<Float> numeros1) {
        this.numeros1 = numeros1;
    }

    public ArrayList<Float> getNumeros2() {
        return numeros2;
    }

    public void setNumeros2(ArrayList<Float> numeros2) {
        this.numeros2 = numeros2;
    }

    public JList getListaCorridas() {
        return listaCorridas;
    }

    public void setListaCorridas(JList listaCorridas) {
        this.listaCorridas = listaCorridas;
    }

    public JTextArea getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(JTextArea listaResultados) {
        this.listaResultados = listaResultados;
    }

    public String getRespuestaA() {
        return respuestaA;
    }

    public void setRespuestaA(String respuestaA) {
        this.respuestaA = respuestaA;
    }

    public String getRespuestaB() {
        return respuestaB;
    }

    public void setRespuestaB(String respuestaB) {
        this.respuestaB = respuestaB;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public void setJScrollPaneResultado(JScrollPane jScrollPaneResultado) {
        this.jScrollPaneResultado=jScrollPaneResultado;
    }

    public void setVelocidad(int i) {
        velocidad=i;
    }

    public JProgressBar getJp() {
        return jp;
    }

    public void setJp(JProgressBar jp) {
        this.jp = jp;
    }


}
