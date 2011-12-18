/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulaciones;

import java.util.ArrayList;
import javax.swing.*;
import simulaciones.distribuciones.Distribuciones;

/**
 *
 * @author warlock
 */
public class SimulacionEjercicio6 extends Thread{
    ArrayList<Float> numeros1;
    ArrayList<Float> numeros2;
    String respuestaA;
    String respuestaB;
    JTextArea listaResultados;
    JList listaCorridas;    
    JButton boton;
    JProgressBar jp;
    int equipos []= {0,0,0,0};
    int horasASimular;
    private int media;
    private int varianza;
    private long costoEstrategiaTodos;
    
    int corridas;
    private JScrollPane jScrollPaneResultado;
    private int velocidad;

    public SimulacionEjercicio6() {
        //valores por defecto
        media=600;
        varianza=100;
    }

    
    @Override
    public void run(){
        
        
        
    }
    
    public void estrategiaCambioTodos(){
        boolean primeraPasada=true;
        int nums = 0;
        costoEstrategiaTodos=0;
        for(int i=0;i<=horasASimular;i++)   {
            if(!primeraPasada){
                for(int m=0;m<equipos.length;m++){                
                    if(equipos[m]<=0){                    
                        i+=2;
                        costoEstrategiaTodos+=200;//costo por el numero de horas paradas
                        costoEstrategiaTodos+=200*equipos.length;//Costo por cada equipo que se compra
                        System.out.println("Costo: "+costoEstrategiaTodos);
                        primeraPasada=true;
                        for(int j=0;j<equipos.length;j++){
                            equipos[j]=0;
                            m=equipos.length;
                        }
                    }
                }
            }
            for(int j=0;j<equipos.length;j++){
                ArrayList<Float> x1 = new ArrayList();                
                for(int l=0;l<12;l++){
                    if(nums==numeros1.size())
                        nums=0;
                    int m= nums++;
                    x1.add(this.numeros1.get(m));                    
                }
                if(equipos[j]<=0){                    
                    equipos[j]=(int) Distribuciones.distribucionNormal(media, varianza, x1);
                    System.out.println("Equipo "+j+": "+equipos[j]); 
                    primeraPasada=true;
                }
            }
            System.out.println("Horas Restantes");
            for(int j=0;j<equipos.length;j++){
                equipos[j]--; 
                System.out.println("Equipo "+ j+": "+equipos[j]);
            }
        }
    }
    
    public void estrategiaCambioUno(){
        
    }
    
    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public int getCorridas() {
        return corridas;
    }

    public void setCorridas(int corridas) {
        this.corridas = corridas;
    }

    public JScrollPane getjScrollPaneResultado() {
        return jScrollPaneResultado;
    }

    public void setjScrollPaneResultado(JScrollPane jScrollPaneResultado) {
        this.jScrollPaneResultado = jScrollPaneResultado;
    }

    public JProgressBar getJp() {
        return jp;
    }

    public void setJp(JProgressBar jp) {
        this.jp = jp;
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

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    
}
