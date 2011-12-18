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
    JTextArea listaCorridas;    
    JButton boton;
    JProgressBar jp;
    JScrollPane jScrollPaneCorridas;
    int equipos []= {0,0,0,0};
    int horasASimular;
    private int media;
    private int varianza;
    private long costoEstrategiaTodos;
    private long costoEstrategiaUno;
    int numsTodos = 0;
    int numsUno=0;
    int corridas;
    private JScrollPane jScrollPaneResultado;
    private int velocidad;

    public SimulacionEjercicio6() {
        //valores por defecto
        media=600;
        varianza=100;
        horasASimular=20000;
    }

    
    @Override
    public void run(){
        jp.setString("Simulando: 0 %");
        boton.setEnabled(false); 
        int estUno=0;
        int estTodos=0;
        for (int i=0;i<corridas;i++){
            try {
                estrategiaCambioTodos();
                estrategiaCambioUno();
                String estrategiaGanadora="";
                if(costoEstrategiaTodos<costoEstrategiaUno){
                    estrategiaGanadora="Estrategia todos: "+costoEstrategiaTodos +"<"+"Estrategia uno: "+costoEstrategiaUno+"\n"; 
                    estTodos++;
                }else if(costoEstrategiaTodos>costoEstrategiaUno){
                    estrategiaGanadora="Estrategia todos: "+costoEstrategiaTodos +">"+"Estrategia uno: "+costoEstrategiaUno+"\n"; 
                    estUno++;
                }else {
                    estrategiaGanadora="Estrategia todos: "+costoEstrategiaTodos +"="+"Estrategia uno: "+costoEstrategiaUno+"\n"; 
                }
                listaCorridas.append("Corrida "+(i+1)+": "+estrategiaGanadora+"\n");
                Dimension tamanhoTextArea = listaCorridas.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneCorridas.getViewport().setViewPosition(p);
                float value=(float)(i+1)/corridas;
                int valor = (int) (value * 100);
                jp.setValue(valor);
                jp.setString("Simulando: "+ valor +" %");
            } catch (Exception ex) {
                Logger.getLogger(SimulacionEjercicio6.class.getName()).log(Level.SEVERE, null, ex);
                listaResultados.setText("");
            }
        }
        if(estTodos>estUno){
            listaResultados.append("La estrategia de cambiar todos es mejor\n");
            Dimension tamanhoTextArea = listaResultados.getSize();
            Point p = new Point(0,tamanhoTextArea.height);
            jScrollPaneResultado.getViewport().setViewPosition(p);
        }else{
            listaResultados.append("La estrategia de cambiar solo la pieza dañada es mejor\n");
            Dimension tamanhoTextArea = listaResultados.getSize();
            Point p = new Point(0,tamanhoTextArea.height);
            jScrollPaneResultado.getViewport().setViewPosition(p);
        }
        
        boton.setEnabled(true); 
        
    }
    
    public void estrategiaCambioTodos()throws Exception{
        boolean primeraPasada=true;
        
        costoEstrategiaTodos=0;
        inicializarEquipos();
        for(int i=0;i<=horasASimular;i++){
            Auxiliares.dormirHilo(velocidad); 
            if(!primeraPasada){
                for(int m=0;m<equipos.length;m++){                
                    if(equipos[m]<=0){                    
                        i+=2;
                        costoEstrategiaTodos+=200;//costo por el numero de horas paradas
                        costoEstrategiaTodos+=200*equipos.length;//Costo por cada equipo que se compra
//                        listaResultados.append("Costo: "+costoEstrategiaTodos+"\n");
//                        Dimension tamanhoTextArea = listaResultados.getSize();
//                        Point p = new Point(0,tamanhoTextArea.height);
//                        jScrollPaneResultado.getViewport().setViewPosition(p);
                        inicializarEquipos();
                        m=equipos.length;
                    }
                }
            }
            for(int j=0;j<equipos.length;j++){
                ArrayList<Float> x1 = new ArrayList();                
                for(int l=0;l<12;l++){
                    if(numsTodos==numeros1.size())
                        numsTodos=0;
                    int m= numsTodos++;
                    x1.add(this.numeros1.get(m));                    
                }
                if(equipos[j]<=0){                    
                    equipos[j]=(int) Distribuciones.distribucionNormal(media, varianza, x1);
//                    System.out.println("Equipo "+j+": "+equipos[j]); 
//                    listaResultados.append("Equipo "+j+": "+equipos[j]+"\n");
//                    Dimension tamanhoTextArea = listaResultados.getSize();
//                    Point p = new Point(0,tamanhoTextArea.height);
//                    jScrollPaneResultado.getViewport().setViewPosition(p);
                    primeraPasada=false;
                }
            }
//            System.out.println("Horas Restantes");
//            listaResultados.append("Horas Restantes"+"\n");
            
            for(int j=0;j<equipos.length;j++){
                equipos[j]--; 
//                System.out.println("Equipo "+ j+": "+equipos[j]);
//                listaResultados.append("Equipo "+ j+": "+equipos[j]+"\n");
                
            }
//            Dimension tamanhoTextArea = listaResultados.getSize();
//            Point p = new Point(0,tamanhoTextArea.height);
//            jScrollPaneResultado.getViewport().setViewPosition(p);
        }
        listaResultados.append("Costo total para cambio de todos los equipos: "+costoEstrategiaTodos+"\n");
        Dimension tamanhoTextArea = listaResultados.getSize();
        Point p = new Point(0,tamanhoTextArea.height);
        jScrollPaneResultado.getViewport().setViewPosition(p);
    }
    
    public void estrategiaCambioUno() throws Exception{
        boolean primeraPasada=true;
        
        costoEstrategiaUno=0;
        inicializarEquipos();
        for(int i=0;i<=horasASimular;i++)   {
            if(!primeraPasada){
                for(int m=0;m<equipos.length;m++){                
                    if(equipos[m]<=0){
                        i++;
                        costoEstrategiaUno+=100;//costo por el numero de horas paradas
                        costoEstrategiaUno+=200;//Costo por cada equipo que se compra
//                        listaResultados.append("Costo: "+costoEstrategiaUno+"\n");
//                        Dimension tamanhoTextArea = listaResultados.getSize();
//                        Point p = new Point(0,tamanhoTextArea.height);
//                        jScrollPaneResultado.getViewport().setViewPosition(p);
                    }
                }
            }
            for(int j=0;j<equipos.length;j++){
                ArrayList<Float> x1 = new ArrayList();                
                for(int l=0;l<12;l++){
                    if(numsUno==numeros1.size())
                        numsUno=0;
                    int m= numsUno++;
                    x1.add(this.numeros1.get(m));                    
                }
                if(equipos[j]<=0){                    
                    equipos[j]=(int) Distribuciones.distribucionNormal(media, varianza, x1);
//                    System.out.println("Equipo "+j+": "+equipos[j]); 
//                    listaResultados.append("Equipo "+j+": "+equipos[j]+"\n");
//                    Dimension tamanhoTextArea = listaResultados.getSize();
//                    Point p = new Point(0,tamanhoTextArea.height);
//                    jScrollPaneResultado.getViewport().setViewPosition(p);
                    primeraPasada=false;
                }
            }
//            System.out.println("Horas Restantes");
//            listaResultados.append("Horas Restantes: "+i+"\n");
            
            for(int j=0;j<equipos.length;j++){
                equipos[j]--; 
//                System.out.println("Equipo "+ j+": "+equipos[j]);
//                listaResultados.append("Equipo "+ j+": "+equipos[j]+"\n");
                
            }
//            Dimension tamanhoTextArea = listaResultados.getSize();
//            Point p = new Point(0,tamanhoTextArea.height);
//            jScrollPaneResultado.getViewport().setViewPosition(p);
        }
        listaResultados.append("Costo total para cambio de uno de los componentes: "+costoEstrategiaUno+"\n");
        Dimension tamanhoTextArea = listaResultados.getSize();
        Point p = new Point(0,tamanhoTextArea.height);
        jScrollPaneResultado.getViewport().setViewPosition(p);
    }
    
    private void inicializarEquipos(){
        //pone todos los equipos en cero
        for (int i=0;i<equipos.length;i++){
            equipos[i]=0;
        }
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
