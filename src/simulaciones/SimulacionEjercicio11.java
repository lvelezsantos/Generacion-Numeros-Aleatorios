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
public class SimulacionEjercicio11 extends Thread{
    
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
    int numeros=0;
    int cantidadOrdenar, nivelReorden;
    int inventarioInicial;
    int costoOrdenar;
    int costoInventarioUnidadAnio;
    int costoFaltanteSinEspera;
    int costoFaltanteConEspera;
    int diasDeTrabajo;
    int inventarioFinal;
    int gastoTotal;
    int cantidadFaltanteTotal;
    int inventarioTotal;
    int valorMaximoAEvaluar;
    
    ArrayList<Gastos> todosLosGastos;
    public SimulacionEjercicio11() {
        costoOrdenar=100;
        costoFaltanteSinEspera=50;
        costoInventarioUnidadAnio=52;
        costoFaltanteConEspera=20;
        inventarioInicial=100;
        diasDeTrabajo=260;
        todosLosGastos = new ArrayList<Gastos>();
    }
    
    
    
    
    @Override
    public void run(){
        boton.setEnabled(false);
        cantidadOrdenar =1; //valores iniciales
        nivelReorden=1; 
        for(int i=1;i<=valorMaximoAEvaluar;i++){//q -CantidadOrdenar
            cantidadOrdenar=i;
            for(int j=1;j<valorMaximoAEvaluar;j++){//R - nivelReorden
                nivelReorden=j;
                simular();
                todosLosGastos.add(new Gastos(i, j, gastoTotal));
                listaResultados.append("Los valores de q y R, son: "+i+", "+j+" Respectivamente\n Y el gasto total es: "+gastoTotal+"\n");
                Dimension tamanhoTextArea = listaResultados.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneResultado.getViewport().setViewPosition(p);
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulacionEjercicio11.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            float value=(float)(i)/valorMaximoAEvaluar;
            int valor = (int) (value * 100);
            jp.setValue(valor);
            jp.setString("Simulando: "+ valor +" %");
        }
        
        int gastoMenor=todosLosGastos.get(0).getGastoTotal();
        Gastos g=todosLosGastos.get(0);
        for(int i=1;i<todosLosGastos.size();i++){
            if(gastoMenor>todosLosGastos.get(i).getGastoTotal()){
                gastoMenor=todosLosGastos.get(i).getGastoTotal();
                g=todosLosGastos.get(i);
            }
        }
        
        System.out.println("Los valores optimos para q y R, son: "+g.getCantidadOrdenar()+", "+g.getNivelReorden()+" Respectivamente");
        System.out.println("El gasto total para esos valores fue: "+ g.getGastoTotal()); 
        listaResultados.append("Los valores optimos para q y R, son: "+g.getCantidadOrdenar()+", "+g.getNivelReorden()+" Respectivamente\n");
        listaResultados.append("El gasto total para esos valores fue: "+ g.getGastoTotal()+"\n");
        Dimension tamanhoTextArea = listaResultados.getSize();
        Point p = new Point(0,tamanhoTextArea.height);
        jScrollPaneResultado.getViewport().setViewPosition(p);
        boton.setEnabled(true);
    }
    
    private void simular(){
        this.inventarioFinal = this.inventarioInicial;
        int diasDeEntrega=0;
        inventarioTotal = inventarioInicial;
        cantidadFaltanteTotal=0;
        gastoTotal=0;
        boolean ordenar=false;
        int cantidadFaltante=0;
        for (int i=1;i<=this.diasDeTrabajo;i++){
            int cantidadDiaria=demandaDiaria(numeros1.get(i)); 
                                   
            if(cantidadFaltante<inventarioFinal){
                inventarioFinal -= cantidadFaltante;
            }
            
            
            if(cantidadDiaria<=inventarioFinal){
                inventarioFinal -=cantidadDiaria;
            }else{
                cantidadFaltante += cantidadDiaria -inventarioFinal;
                this.cantidadFaltanteTotal += (cantidadDiaria -inventarioFinal);
                this.gastoTotal += (cantidadDiaria -inventarioFinal) * costoFaltanteSinEspera;
            }
            
            
            //ordenar
          
            
            
            if(diasDeEntrega>0){
                diasDeEntrega--;
            }
            if(diasDeEntrega==0 && ordenar){
                inventarioFinal  += cantidadOrdenar;
                ordenar=false;
                inventarioFinal+=cantidadOrdenar;
                inventarioTotal+=cantidadOrdenar;
            }
            
            if(inventarioFinal<= nivelReorden){
                ordenar=true;
                diasDeEntrega = entregaDias(numeros2.get(i));
                gastoTotal += costoOrdenar;
            }
            
            if(inventarioFinal<=0&&(diasDeEntrega<=esperaDias(i))){
                gastoTotal +=costoFaltanteConEspera*cantidadDiaria;
            }else if(inventarioFinal<=0&&(diasDeEntrega>=esperaDias(i))){
                gastoTotal +=costoFaltanteSinEspera*cantidadDiaria;
            }
            
            
            System.out.println("Inventario Final"+ inventarioFinal);
            System.out.println("Faltante"+ cantidadFaltante);
            System.out.println("Demanda diaria"+ cantidadDiaria);
            System.out.println("Dias de Entrega"+ diasDeEntrega);
            
            
        }
        gastoTotal += inventarioTotal * costoInventarioUnidadAnio;
    }
    
    private int demandaDiaria(double num){
        int demandaDiaria=0;
        if(verificaSiEstaEntreDos(num, 0.0, 0.02)){
            demandaDiaria=25;
        }else if(verificaSiEstaEntreDos(num, 0.02, 0.06)){
            demandaDiaria=26;
        }else if(verificaSiEstaEntreDos(num, 0.06, 0.12)){
            demandaDiaria=27;
        }else if(verificaSiEstaEntreDos(num, 0.12, 0.24)){
            demandaDiaria=28;
        }else if(verificaSiEstaEntreDos(num, 0.24, 0.44)){
            demandaDiaria=29;
        }else if(verificaSiEstaEntreDos(num, 0.44, 0.68)){
            demandaDiaria=30;
        }else if(verificaSiEstaEntreDos(num, 0.68, 0.83)){
            demandaDiaria=31;
        }else if(verificaSiEstaEntreDos(num, 0.83, 0.93)){
            demandaDiaria=32;
        }else if(verificaSiEstaEntreDos(num, 0.93, 0.98)){
            demandaDiaria=33;
        }else if(verificaSiEstaEntreDos(num, 0.98, 1)){
            demandaDiaria=34;
        }
        return demandaDiaria;        
    }
    
    private int entregaDias(double num){
        int dias=0;
        
        if(verificaSiEstaEntreDos(num, 0.0, 0.2)){
            dias=1;
        }else if(verificaSiEstaEntreDos(num, 0.2, 0.5)){
            dias=2;
        }else if(verificaSiEstaEntreDos(num, 0.5, 0.75)){
            dias=3;
        }else if(verificaSiEstaEntreDos(num, 0.75, 1)){
            dias=4;
        }        
        return dias;
    }
    
    
    private int esperaDias(double num){
        int dias=0;
        
        if(verificaSiEstaEntreDos(num, 0.0, 0.40)){
            dias=0;
        }else if(verificaSiEstaEntreDos(num, 0.40, 0.6)){
            dias=1;
        }else if(verificaSiEstaEntreDos(num, 0.6, 0.75)){
            dias=2;
        }else if(verificaSiEstaEntreDos(num, 0.75, 0.9)){
            dias=3;
        }else if(verificaSiEstaEntreDos(num, 0.9, 1)){
            dias=4;
        }          
        return dias;
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

    public int getCantidadFaltanteTotal() {
        return cantidadFaltanteTotal;
    }

    public void setCantidadFaltanteTotal(int cantidadFaltanteTotal) {
        this.cantidadFaltanteTotal = cantidadFaltanteTotal;
    }

    public int getCantidadOrdenar() {
        return cantidadOrdenar;
    }

    public void setCantidadOrdenar(int cantidadOrdenar) {
        this.cantidadOrdenar = cantidadOrdenar;
    }

    public int getCorridas() {
        return corridas;
    }

    public void setCorridas(int corridas) {
        this.corridas = corridas;
    }

    public int getCostoFaltante() {
        return costoFaltanteSinEspera;
    }

    public void setCostoFaltante(int costoFaltante) {
        this.costoFaltanteSinEspera = costoFaltante;
    }

    public int getCostoInventarioUnidadAnio() {
        return costoInventarioUnidadAnio;
    }

    public void setCostoInventarioUnidadAnio(int costoInventarioUnidadAnio) {
        this.costoInventarioUnidadAnio = costoInventarioUnidadAnio;
    }

    public int getCostoOrdenar() {
        return costoOrdenar;
    }

    public void setCostoOrdenar(int costoOrdenar) {
        this.costoOrdenar = costoOrdenar;
    }

    public int getDiasDeTrabajo() {
        return diasDeTrabajo;
    }

    public void setDiasDeTrabajo(int diasDeTrabajo) {
        this.diasDeTrabajo = diasDeTrabajo;
    }

    public int getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(int gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public int getInventarioFinal() {
        return inventarioFinal;
    }

    public void setInventarioFinal(int inventarioFinal) {
        this.inventarioFinal = inventarioFinal;
    }

    public int getInventarioInicial() {
        return inventarioInicial;
    }

    public void setInventarioInicial(int inventarioInicial) {
        this.inventarioInicial = inventarioInicial;
    }

    public int getInventarioTotal() {
        return inventarioTotal;
    }

    public void setInventarioTotal(int inventarioTotal) {
        this.inventarioTotal = inventarioTotal;
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

    public int getNivelReorden() {
        return nivelReorden;
    }

    public void setNivelReorden(int nivelReorden) {
        this.nivelReorden = nivelReorden;
    }

    public int getNumeros() {
        return numeros;
    }

    public void setNumeros(int numeros) {
        this.numeros = numeros;
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

    public ArrayList<Gastos> getTodosLosGastos() {
        return todosLosGastos;
    }

    public void setTodosLosGastos(ArrayList<Gastos> todosLosGastos) {
        this.todosLosGastos = todosLosGastos;
    }

    public int getValorMaximoAEvaluar() {
        return valorMaximoAEvaluar;
    }

    public void setValorMaximoAEvaluar(int valorMaximoAEvaluar) {
        this.valorMaximoAEvaluar = valorMaximoAEvaluar;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    
}
