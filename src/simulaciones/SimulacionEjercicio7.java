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
    //sc = se calcula
    //sp = se pide
    private int revistasCompradasEs1;//sp
    private int revistasCompradasEs2;//sp
    private JScrollPane jScrollPaneResultado;
    private int velocidad;//sp
    private int revistasVendidasEstrategia1;
    private int revistasTotales;
    private int revistasFaltantes;
    private double gananciasEstrategia1;//recaudoVentaTotal1-costoParaElVendedor1
    private double recaudoVentaTotal1;
    private double costoParaElVendedor1;
    private int revistasVendidasEstrategia2;
    private double gananciasEstrategia2;//recaudoVentaTotal2-costoParaElVendedor2
    private double recaudoVentaTotal2;//se calcula
    private double costoParaElVendedor2;//
    int numeros=0;

    public SimulacionEjercicio7()  {
        revistasVendidasEstrategia1=0;
    }

    
    @Override
    public void run(){
        jp.setString("Simulando: 0 %");
        boton.setEnabled(false); 
        for(int i=1;i<=corridas;i++){
            estrategia1();
            estrategia2();
            String estrategiaGanadora;
            if(this.gananciasEstrategia1>this.gananciasEstrategia2){
                estrategiaGanadora="Ganancias Estrategia 2: "+gananciasEstrategia2+"\nLas ganancias de la estrategia 1 es mayor, "+this.gananciasEstrategia1+"\n";
            }else if(this.gananciasEstrategia1<this.gananciasEstrategia2){
                estrategiaGanadora="Ganancias Estrategia 1: "+gananciasEstrategia1+"\nLas ganancias de la estrategia 2 es mayor, "+this.gananciasEstrategia2+"\n";
            }else{
                estrategiaGanadora="Las ganancias de la estrategias son iguales\n";
            }
            listaResultados.append(estrategiaGanadora+"\n");
            Dimension tamanhoTextArea2 = listaResultados.getSize();
            Point p2 = new Point(0,tamanhoTextArea2.height);
            jScrollPaneResultado.getViewport().setViewPosition(p2);
            
            listaCorridas.append("Corrida "+(i)+": "+estrategiaGanadora+"\n");
            Dimension tamanhoTextArea = listaCorridas.getSize();
            Point p = new Point(0,tamanhoTextArea.height);
            jScrollPaneCorridas.getViewport().setViewPosition(p);
            float value=(float)(i)/corridas;
            int valor = (int) (value * 100);
            jp.setValue(valor);
            jp.setString("Simulando: "+ valor +" %");
        }
        listaResultados.append("Las ganancias de las ventas totales fueron: "+(gananciasEstrategia1+gananciasEstrategia2)+"$\n");
        Dimension tamanhoTextArea2 = listaResultados.getSize();
        Point p2 = new Point(0,tamanhoTextArea2.height);
        jScrollPaneResultado.getViewport().setViewPosition(p2);
        boton.setEnabled(true); 
        
    }
    
    
    private void estrategia1(){
        costoParaElVendedor1=0;
        recaudoVentaTotal1=0;
        revistasVendidasEstrategia1=0;
        gananciasEstrategia1=0;
        revistasTotales=revistasCompradasEs1;
        revistasFaltantes=revistasCompradasEs1;
        for(int i=1;i<=10;i++){
            if(numeros>=numeros1.size()){
                numeros=0;
            }
            int revistasVendidas=0;
            double numeroGenerado = numeros1.get(numeros);
            
            if(numeroGenerado>=0 &&numeroGenerado<0.05){
                revistasVendidas +=5;
            }else if(numeroGenerado>=0.05 &&numeroGenerado<0.1){
                revistasVendidas +=6;
            }else if(numeroGenerado>=0.1 &&numeroGenerado<0.2){
                revistasVendidas +=7;
            }else if(numeroGenerado>=0.2 &&numeroGenerado<0.35){
                revistasVendidas +=8;
            }else if(numeroGenerado>=0.35 &&numeroGenerado<0.6){
                revistasVendidas +=9;
            }else if(numeroGenerado>=0.6 &&numeroGenerado<0.85){
                revistasVendidas +=10;
            }else if(numeroGenerado>=0.85 &&numeroGenerado<1){
                revistasVendidas +=11;
            }
            
            if((revistasVendidasEstrategia1+revistasVendidas)<=revistasCompradasEs1){
                revistasVendidasEstrategia1+=revistasVendidas;
            }else{
                listaResultados.append("No hay suficientes revistas para vender\n");
            }

            listaResultados.append("Numero de revistas vendidas al dia "+i+": "+ this.revistasVendidasEstrategia1+"\n");
            Dimension tamanhoTextArea = listaResultados.getSize();
            Point p = new Point(0,tamanhoTextArea.height);
            jScrollPaneResultado.getViewport().setViewPosition(p);
            
            numeros++;
        }
        costoParaElVendedor1=revistasCompradasEs1*1.5;
        
        recaudoVentaTotal1 = revistasVendidasEstrategia1*2;
        recaudoVentaTotal1+=(revistasCompradasEs1-revistasVendidasEstrategia1)*0.9;
        gananciasEstrategia1=recaudoVentaTotal1-costoParaElVendedor1;
        revistasFaltantes-=revistasVendidasEstrategia1;
    }
    
    private void estrategia2(){
        costoParaElVendedor2=0;
        recaudoVentaTotal2=0;
        revistasVendidasEstrategia2=0;
        gananciasEstrategia2=0;
        revistasTotales+=revistasCompradasEs2;
        revistasFaltantes+=revistasCompradasEs2;
        
        for(int i=1;i<=20;i++){
            if(numeros>=numeros1.size()){
                numeros=0;
            }
            double numeroGenerado = numeros1.get(numeros);
            int revistasVendidas=0;
            if(numeroGenerado>=0 &&numeroGenerado<0.15){
                revistasVendidas +=4;
            }else if(numeroGenerado>=0.15 &&numeroGenerado<0.35){
                revistasVendidas +=5;
            }else if(numeroGenerado>=0.35 &&numeroGenerado<0.65){
                revistasVendidas +=6;
            }else if(numeroGenerado>=0.65 &&numeroGenerado<0.85){
                revistasVendidas +=7;
            }else if(numeroGenerado>=0.85 &&numeroGenerado<1){
                revistasVendidas +=8;
            }
            if(revistasFaltantes>=revistasVendidas){
                revistasVendidasEstrategia2+=revistasVendidas;
                revistasFaltantes -=revistasVendidas;
            }else{
                listaResultados.append("No hay suficientes revistas para vender\n");
            }
            
            listaResultados.append("Numero de revistas vendidas al dia "+(i+10)+": "+ this.revistasVendidasEstrategia2+"\n");
            Dimension tamanhoTextArea = listaResultados.getSize();
            Point p = new Point(0,tamanhoTextArea.height);
            jScrollPaneResultado.getViewport().setViewPosition(p);
            numeros++;
        }
        
        costoParaElVendedor2=revistasCompradasEs2*1.2;
        recaudoVentaTotal2 = revistasVendidasEstrategia2*2;
        recaudoVentaTotal2 += (revistasTotales-revistasVendidasEstrategia1-revistasVendidasEstrategia2)*0.6;
        gananciasEstrategia2=recaudoVentaTotal2-costoParaElVendedor2;
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

    public int getRevistasCompradasEs1() {
        return revistasCompradasEs1;
    }

    public void setRevistasCompradasEs1(int revistasCompradasEs1) {
        this.revistasCompradasEs1 = revistasCompradasEs1;
    }

    public int getRevistasCompradasEs2() {
        return revistasCompradasEs2;
    }

    public void setRevistasCompradasEs2(int revistasCompradasEs2) {
        this.revistasCompradasEs2 = revistasCompradasEs2;
    }
    
    
}
