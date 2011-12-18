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
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author KARLOS
 */
public class SimulacionRuleta extends Thread {
    ArrayList<Float> numeros;
    JTextArea listaEstrategia1;
    JTextArea listaEstrategia2;
    JLabel jLabelResultado;
    JLabel jLabelColor;
    JLabel jLabelEstrategia;
    JScrollPane jScrollPaneEstrategia1;
    JScrollPane jScrollPaneEstrategia2;
    int velocidad;
//    DefaultListModel dm1;
//    DefaultListModel dm2;
    JButton boton;
    int cantidadInicial;
    int valorDeApuesta;
    int corridas;
    int meta;
//    private final URL colorRojo;
//    private final URL colorNegro;
//    private final URL colorVerde;
    private JProgressBar jp;

    public SimulacionRuleta(ArrayList<Float> numeros, int cantidadInicial, int valorDeApuesta,  int corridas,int meta) {
        this.numeros = numeros;
        this.cantidadInicial = cantidadInicial;
        this.valorDeApuesta = valorDeApuesta;
//        colorRojo= getClass().getResource("/Vista/rojo.png");
//        colorNegro= getClass().getResource("/Vista/negro.png");
//        colorVerde= getClass().getResource("/Vista/verde.png");
        this.corridas = corridas;
        this.meta = meta;
    }

   

    public int getCorridas() {
        return corridas;
    }

    public void setCorridas(int corridas) {
        this.corridas = corridas;
    }

    public ArrayList<Float> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Float> numeros) {
        this.numeros = numeros;
    }


    public int getCantidadInicial(){
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial){
        this.cantidadInicial = cantidadInicial;
    }

    public int getValorDeApuesta(){
        return valorDeApuesta;
    }

    public void setValorDeApuesta(int valorDeApuesta){
        this.valorDeApuesta = valorDeApuesta;
    }

    @Override
    public void run(){
        String cad;
        boton.setEnabled(false);
        int apuestaEstrategia1=SimularEstrategia1();
        int apuestaEstrategia2=SimularEstrategia2();
        if(apuestaEstrategia1>apuestaEstrategia2){
            jLabelResultado.setText("La estrategia 1 es mejor");
        }else{
            jLabelResultado.setText("La estrategia 2 es mejor");
        }
        boton.setEnabled(true);
    }

    

    public int SimularEstrategia1(){
        int i = 0;
        int apuestaGanada = 0;
        int apuestaPerdida = 0;
        System.out.println("Estrategia 1");
        jLabelEstrategia.setText("Estrategia 1");
        listaEstrategia1.setText("Estrategia 1\n");
        jp.setString("Estrategia 1: "+ 0 +" %");

        for(int j=1;j<=corridas;j++){
            boolean ganaPartida=false;
            boolean finPartida=false;
            int ci = this.cantidadInicial;
            while(!finPartida){
                boolean terminada = false;
                boolean gana = false;
                while(!terminada){
                     if(i==numeros.size()){
                        i=0;
                     }
                     switch(apostar(numeros.get(i))){
                         case 1:
                             terminada=false;
                             listaEstrategia1.append("Verde\n");
//                             if(velocidad!=0)
                             break;
                         case 2:
                             terminada=true;
                             listaEstrategia1.append("Rojo\n");
                             listaEstrategia1.append("---Gano---\n");
//                             if(velocidad!=0)
                             gana=true;
                             break;
                         case 3:
                             terminada=true;
                             listaEstrategia1.append("Negro\n");
                             listaEstrategia1.append("---Perdio---\n");
//                             if(velocidad!=0)
                             gana=false;
                             break;
                     }
                     Dimension tamanhoTextArea = listaEstrategia1.getSize();
                     Point p = new Point(0,tamanhoTextArea.height);
                     jScrollPaneEstrategia1.getViewport().setViewPosition(p);
                     try {
                        Thread.sleep(velocidad);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SimulacionRuleta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     i++;
                }
                if(gana){
                    ci++;
                    listaEstrategia1.append("Cantidad De Dinero: "+ ci+"\n");
                    if(ci>=meta){
                        ganaPartida=true;
                        finPartida=true;
                        apuestaGanada++;
                    }
                }else{
                    ci--;
                    listaEstrategia1.append("Cantidad De Dinero: "+ ci+"\n");
                    if(ci<=0){
                        ganaPartida=false;
                        finPartida=true;
                        apuestaPerdida++;
                    }
                }
                Dimension tamanhoTextArea = listaEstrategia1.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneEstrategia1.getViewport().setViewPosition(p);
            }
            float value=(float)j/corridas;
            int valor = (int) (value * 100);
            jp.setValue(valor);
            jp.setString("Estrategia 1: "+ valor +" %");
        }
        float porApuestaG = (float)apuestaGanada/corridas;
        float porApuestaP = (float)apuestaPerdida/corridas;
        listaEstrategia1.append("Porcentaje partida Ganada: "+(porApuestaG*100)+"\n");
        listaEstrategia1.append("Porcentaje partida Perdida: "+(porApuestaP*100)+"\n");
        Dimension tamanhoTextArea = listaEstrategia1.getSize();
        Point p = new Point(0,tamanhoTextArea.height);
        jScrollPaneEstrategia1.getViewport().setViewPosition(p);
        return apuestaGanada;
    }

    public int SimularEstrategia2(){
        jp.setString("Estrategia 2: "+ 0 +" %");
        int i = 0;       
        int apuestaGanada = 0;
        int apuestaPerdida = 0;
        jLabelEstrategia.setText("Estrategia 2");
        listaEstrategia2.setText("Estrategia 2\n");
        for(int j=1;j<=corridas;j++){
            int auxApuesta=this.valorDeApuesta;
            boolean ganaPartida=false;
            boolean finPartida=false;
            int ci = this.cantidadInicial;
            while(!finPartida){
                if(auxApuesta>ci)
                    auxApuesta=ci;
                boolean terminada = false;
                boolean gana = false;
                while(!terminada){
                     if(i==numeros.size()){
                        i=0;
                     }
                     switch(apostar(numeros.get(i))){
                         case 1:
                             terminada=false;
                               listaEstrategia2.append("Verde"+"\n");                               
//                             if(velocidad!=0)
//                                jLabelColor.setBackground(Color.green);
                             break;
                         case 2:
                             terminada=true;
                              listaEstrategia2.append("Rojo"+"\n");
                             listaEstrategia2.append("---Gano---"+"\n");
//                             if(velocidad!=0)
//                                jLabelColor.setBackground(Color.red);
                             gana=true;
                             break;
                         case 3:
                             terminada=true;
                             gana=false;
                             listaEstrategia2.append("Negro"+"\n");
                             listaEstrategia2.append("---Perdio---"+"\n");
//                             if(velocidad!=0)
//                                jLabelColor.setBackground(Color.black);
                             break;
                     }
                     Dimension tamanhoTextArea = listaEstrategia2.getSize();
                     Point p = new Point(0,tamanhoTextArea.height);
                     jScrollPaneEstrategia2.getViewport().setViewPosition(p);
                     i++;
                    try {
                        Thread.sleep(velocidad);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SimulacionRuleta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(gana){
                    ci+=auxApuesta;
                    listaEstrategia2.append("Cantidad De Dinero: "+ ci+"\n");
                    if(ci>=meta){
                        ganaPartida=true;
                        finPartida=true;
                        apuestaGanada++;
                    }
                }else{
                    ci-=auxApuesta;
                    auxApuesta= auxApuesta*2;
                    if(auxApuesta>=500)
                        auxApuesta=1;
                    listaEstrategia2.append("Cantidad De Dinero: "+ ci+"\n");
                    if(ci<=0){
                        ganaPartida=false;
                        finPartida=true;
                        apuestaPerdida++;
                    }
                }
                Dimension tamanhoTextArea = listaEstrategia2.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneEstrategia2.getViewport().setViewPosition(p);
            }
            float value=(float)j/corridas;
            int valor = (int) (value * 100);
            jp.setValue(valor);
            jp.setString("Estrategia 2: "+ valor +" %");
          }
        float porApuestaG = (float)apuestaGanada/corridas;
        float porApuestaP = (float)apuestaPerdida/corridas;

        listaEstrategia2.append("Porcentaje partida Ganada: "+(porApuestaG*100)+"\n");
        listaEstrategia2.append("Porcentaje partida Perdida: "+(porApuestaP*100)+"\n");
        Dimension tamanhoTextArea = listaEstrategia2.getSize();
        Point p = new Point(0,tamanhoTextArea.height);
        jScrollPaneEstrategia2.getViewport().setViewPosition(p);
        return apuestaGanada;
    }
    public int apostar(float num){
          int resultado=0;
        if(num >= 0 && num <0.09){
            resultado = 1;//verde
        }else if(num >= 0.09 && num <0.55){
            resultado=2;//rojo
        }else if(num >= 0.55 && num <1){
            resultado=3;//negro
        }
        return resultado;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JLabel getjLabelColor() {
        return jLabelColor;
    }

    public void setjLabelColor(JLabel jLabelColor) {
        this.jLabelColor = jLabelColor;
    }

    public JLabel getjLabelResultado() {
        return jLabelResultado;
    }

    public void setjLabelResultado(JLabel jLabelResultado) {
        this.jLabelResultado = jLabelResultado;
    }

    public JTextArea getjListEstrategia1() {
        return listaEstrategia1;
    }

    public void setjListEstrategia1(JTextArea jListEstrategia1) {
        this.listaEstrategia1 = jListEstrategia1;
    }

    public JTextArea getjListEstrategia2() {
        return listaEstrategia2;
    }

    public void setjListEstrategia2(JTextArea jListEstrategia2) {
        this.listaEstrategia2 = jListEstrategia2;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public JLabel getjLabelEstrategia() {
        return jLabelEstrategia;
    }

    public void setjLabelEstrategia(JLabel jLabelEstrategia) {
        this.jLabelEstrategia = jLabelEstrategia;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setJp(JProgressBar jProgressBar1) {
        this.jp=jProgressBar1;
    }

    public JScrollPane getjScrollPaneEstrategia1() {
        return jScrollPaneEstrategia1;
    }

    public void setjScrollPaneEstrategia1(JScrollPane jScrollPaneEstrategia1) {
        this.jScrollPaneEstrategia1 = jScrollPaneEstrategia1;
    }

    public JScrollPane getjScrollPaneEstrategia2() {
        return jScrollPaneEstrategia2;
    }

    public void setjScrollPaneEstrategia2(JScrollPane jScrollPaneEstrategia2) {
        this.jScrollPaneEstrategia2 = jScrollPaneEstrategia2;
    }

    




}
