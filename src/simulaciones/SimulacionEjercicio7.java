/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulaciones;

import auxiliares.Auxiliares;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import simulaciones.distribuciones.Distribuciones;

/**
 *
 * @author warlock
 */
public class SimulacionEjercicio7 extends Thread{
    ArrayList<Float> numeros1;
    ArrayList<Float> numeros2;
    String respuestaA;
    String respuestaB;
    JTextArea listaResultados;
    JTextArea listaCorridas;    
    JButton boton;
    JProgressBar jp;
    JScrollPane jScrollPaneCorridas;
    int corridas;
    private JScrollPane jScrollPaneResultado;
    private int velocidad;
    private int revistasVendidasEstrategia1;
    private double gananciasEstrategia1;//recaudoVentaTotal1-costoParaElVendedor1
    private double recaudoVentaTotal1;
    private double costoParaElVendedor1;
    

    public SimulacionEjercicio7()  {
        revistasVendidasEstrategia1=0;
    }

    
    @Override
    public void run(){
        jp.setString("Simulando: 0 %");
        boton.setEnabled(false); 
        
        boton.setEnabled(true); 
        
    }
    
    
    private void estrategia1(){
        costoParaElVendedor1=0;
        recaudoVentaTotal1=0;
        revistasVendidasEstrategia1=0;
        gananciasEstrategia1=0;
        for(int i=1;i<=10;i++){
            double numeroGenerado = numeros1.get(i);
            
            if(numeroGenerado>=0 &&numeroGenerado<0.05){
                this.revistasVendidasEstrategia1 +=5;
            }else if(numeroGenerado>=0.05 &&numeroGenerado<0.1){
                this.revistasVendidasEstrategia1 +=6;
            }else if(numeroGenerado>=0.1 &&numeroGenerado<0.2){
                this.revistasVendidasEstrategia1 +=7;
            }else if(numeroGenerado>=0.2 &&numeroGenerado<0.35){
                this.revistasVendidasEstrategia1 +=8;
            }else if(numeroGenerado>=0.35 &&numeroGenerado<0.6){
                this.revistasVendidasEstrategia1 +=9;
            }else if(numeroGenerado>=0.6 &&numeroGenerado<0.85){
                this.revistasVendidasEstrategia1 +=10;
            }else if(numeroGenerado>=0.85 &&numeroGenerado<1){
                this.revistasVendidasEstrategia1 +=11;
            }
        }
        costoParaElVendedor1=revistasVendidasEstrategia1*1.5;
        recaudoVentaTotal1 = revistasVendidasEstrategia1*2;
        gananciasEstrategia1=recaudoVentaTotal1-costoParaElVendedor1;
    }
    
    private void estrategia2(){
        
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

    public JTextArea getListaCorridas() {
        return listaCorridas;
    }

    public void setListaCorridas(JTextArea listaCorridas) {
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

    public void setjScrollPaneCorridas(JScrollPane jScrollPaneCorridas) {
        this.jScrollPaneCorridas = jScrollPaneCorridas;
    }
    

}
