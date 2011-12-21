/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulaciones;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author warlock
 */
public class SimulacionEjercicio15 extends Thread{
    
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
    
    private JScrollPane jScrollPaneResultado;
    private int velocidad;//sp
    
    private int gastoCamionesAjenos;
    private int maximoCamionesParaProbar;
    private int camionesDisponibles;
    private int camionesAjenos;
    private int gastoTotal;
    private int costoCamionAjeno;
    private int costoCamionNuevo;
    private int anios;
    
    public SimulacionEjercicio15() {
       costoCamionAjeno=100;
       costoCamionNuevo=100000;
    }
    
    
    
    
    @Override
    public void run(){
        ArrayList<Integer> gastos=new ArrayList<Integer>();
       for(int i=1;i<=maximoCamionesParaProbar;i++){
            camionesDisponibles=i;
            simular();
            listaResultados.append("Camiones ajenos"+camionesAjenos+"\n");
            listaResultados.append("camiones disponible: "+camionesDisponibles+"\n");
            listaResultados.append("Gasto total: "+gastoTotal+"\n");
            Dimension tamanhoTextArea = listaResultados.getSize();
            Point p = new Point(0,tamanhoTextArea.height);
            jScrollPaneResultado.getViewport().setViewPosition(p);
            gastos.add(gastoTotal); 
            float value=(float)(i)/maximoCamionesParaProbar;
            int valor = (int) (value * 100);
            jp.setValue(valor);
            jp.setString("Simulando: "+ valor +" %");
       }
       int gastoMenor=gastos.get(0);
       int pos=0;
       for(int i=1;i<gastos.size();i++){
            if(gastoMenor>gastos.get(i)){
                gastoMenor=gastos.get(i);  
                pos=i;
            }
        }
        
        listaResultados.append("El numero de camiones optimo es: "+(pos+1)+"\n");
        listaResultados.append("Con un gasto total de: "+(gastos.get(pos))+"\n");
        Dimension tamanhoTextArea = listaResultados.getSize();
        Point p = new Point(0,tamanhoTextArea.height);
        jScrollPaneResultado.getViewport().setViewPosition(p);
    }
    
    private void simular(){
        int toneladaDiaria=0;
        double camionesNecesarios=0;
        int toneladasPorCamion=0;
        gastoTotal=0;
        for(int i=1;i<=(250*anios);i++){
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimulacionEjercicio11.class.getName()).log(Level.SEVERE, null, ex);
            }
            toneladaDiaria = demandaDiaria(numeros1.get(i));
            toneladasPorCamion=cargaPorCamion(numeros2.get(i));
            camionesNecesarios = toneladaDiaria/toneladasPorCamion;
            camionesAjenos =(int) (camionesNecesarios -camionesDisponibles);
            camionesAjenos = (camionesAjenos<1)?0:camionesAjenos;
            gastoCamionesAjenos=toneladasPorCamion*camionesAjenos*costoCamionAjeno;
            gastoTotal+=gastoCamionesAjenos;
            listaResultados.append("Toneladas Dia: "+toneladaDiaria+"\n");
            listaResultados.append("Toneladas Por Camion: "+toneladasPorCamion+"\n");
            listaResultados.append("Camiones Necesario Dia: "+camionesNecesarios+"\n");
            listaResultados.append("Camiones Ajenos Dia: "+camionesAjenos+"\n");
            Dimension tamanhoTextArea = listaResultados.getSize();
            Point p = new Point(0,tamanhoTextArea.height);
            jScrollPaneResultado.getViewport().setViewPosition(p);
        }
        gastoTotal+=costoCamionNuevo*camionesDisponibles;          
        
    }
    
    private int demandaDiaria(double num){
        int produccioDiaria=0;
        if(verificaSiEstaEntreDos(num, 0.0, 0.1)){
            produccioDiaria=50;
        }else if(verificaSiEstaEntreDos(num, 0.1, 0.25)){
            produccioDiaria=55;
        }else if(verificaSiEstaEntreDos(num, 0.25, 0.55)){
            produccioDiaria=60;
        }else if(verificaSiEstaEntreDos(num, 0.5, 0.9)){
            produccioDiaria=65;
        }else if(verificaSiEstaEntreDos(num, 0.9, 0.98)){
            produccioDiaria=70;
        }else if(verificaSiEstaEntreDos(num, 0.98, 1)){
            produccioDiaria=75;
        }
        return produccioDiaria;        
    }
    
    private int cargaPorCamion(double num){
        int toneladas=0;
        
        if(verificaSiEstaEntreDos(num, 0.0, 0.3)){
            toneladas=1;
        }else if(verificaSiEstaEntreDos(num, 0.3, 0.7)){
            toneladas=2;
        }else if(verificaSiEstaEntreDos(num, 0.7, 0.9)){
            toneladas=3;
        }else if(verificaSiEstaEntreDos(num, 0.9, 1)){
            toneladas=4;
        }        
        return toneladas;
    }
    
    
    
    
    private boolean verificaSiEstaEntreDos(double num,double antes, double despues){
        return (num>=antes && num<despues);
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

    
    public int getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(int gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public JScrollPane getjScrollPaneCorridas() {
        return jScrollPaneCorridas;
    }

    public void setjScrollPaneCorridas(JScrollPane jScrollPaneCorridas) {
        this.jScrollPaneCorridas = jScrollPaneCorridas;
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

    public int getCamionesAjenos() {
        return camionesAjenos;
    }

    public void setCamionesAjenos(int camionesAjenos) {
        this.camionesAjenos = camionesAjenos;
    }

    public int getCamionesDisponibles() {
        return camionesDisponibles;
    }

    public void setCamionesDisponibles(int camionesDisponibles) {
        this.camionesDisponibles = camionesDisponibles;
    }

    public int getCostoCamionAjeno() {
        return costoCamionAjeno;
    }

    public void setCostoCamionAjeno(int costoCamionAjeno) {
        this.costoCamionAjeno = costoCamionAjeno;
    }

    public int getCostoCamionNuevo() {
        return costoCamionNuevo;
    }

    public void setCostoCamionNuevo(int costoCamionNuevo) {
        this.costoCamionNuevo = costoCamionNuevo;
    }

    public int getGastoCamionesAjenos() {
        return gastoCamionesAjenos;
    }

    public void setGastoCamionesAjenos(int gastoCamionesAjenos) {
        this.gastoCamionesAjenos = gastoCamionesAjenos;
    }

    public int getMaximoCamionesParaProbar() {
        return maximoCamionesParaProbar;
    }

    public void setMaximoCamionesParaProbar(int maximoCamionesParaProbar) {
        this.maximoCamionesParaProbar = maximoCamionesParaProbar;
    }

    public void setAnios(int convertirStringAEntero) {
        this.anios=convertirStringAEntero;
    }
    
    
}
