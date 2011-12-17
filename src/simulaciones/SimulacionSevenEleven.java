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

import auxiliares.GirarDados;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;

/**
 *
 * @author warlock
 */
public class SimulacionSevenEleven extends Thread{
    private JList listaCorrdias;
    private JList textArea;
    private JButton boton;
    private JCheckBox checkBox;
    private JLabel jLabelDado1;
    private JLabel jLabelDado2;
    private JLabel resultado;
    private int velocidad;
    private JProgressBar jp;
    private ArrayList<Float> dado1;
    private ArrayList<Float> dado2;
    private int cantidadInicial;
    private int valorDeApuesta;
    private int cantidadFinal;
    private int corridas=100;
    public SimulacionSevenEleven(ArrayList<Float> dado1, ArrayList<Float> dado2, int cantidadInicial, int valorDeApuesta, int cantidadFinal) {
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.cantidadInicial = cantidadInicial;
        this.valorDeApuesta = valorDeApuesta;
        this.cantidadFinal = cantidadFinal;
    }

    public SimulacionSevenEleven() {
//        GirarDados g = new GirarDados();
    }

    public int getCantidadFinal() {
        return cantidadFinal;
    }

    public void setCantidadFinal(int cantidadFinal) {
        this.cantidadFinal = cantidadFinal;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public ArrayList<Float> getDado1() {
        return dado1;
    }

    public void setDado1(ArrayList<Float> dado1) {
        this.dado1 = dado1;
    }

    public ArrayList<Float> getDado2() {
        return dado2;
    }

    public void setDado2(ArrayList<Float> dado2) {
        this.dado2 = dado2;
    }

    public int getValorDeApuesta() {
        return valorDeApuesta;
    }

    public void setValorDeApuesta(int valorDeApuesta) {
        this.valorDeApuesta = valorDeApuesta;
    }


    @Override
    public void run(){
        String cad="";
        DefaultListModel dm= new DefaultListModel();
        DefaultListModel dmCorridas= new DefaultListModel();
        int i=0;
        int partidasGanadas=0;
        int partidasPerdidas=0;
        boton.setText("Simulando");
        boton.setEnabled(false);
        jp.setString("Simulando");
        System.out.println("Dentro del hilo");
        for(int j=0;j<corridas;j++){
//            resultado.setText("Resultado");
//            resultado.setForeground(Color.black);
            if(checkBox.isSelected()){
                velocidad=0;
            }else{
                velocidad = 100;
            }

            boolean ganaPartida=false;
            boolean finPartida=false;
            int ci = this.cantidadInicial;
            int k=1;
            dm.addElement("Corrida: "+ j);
            while(!finPartida){
//                resultado.setText("Resultado");
//                resultado.setForeground(Color.black);
                boolean terminado=false;
                boolean gano=false;
                int lanzamiento=1;
                int suma2=0;
                dm.addElement("partida: "+k);
                while(!terminado){
//                    resultado.setText("Resultado");
//                    resultado.setForeground(Color.black);
                    GirarDados g = new GirarDados();                    
                    g.setjLabelDado1(jLabelDado1);
                    g.setjLabelDado2(jLabelDado2);
//                    if(velocidad>0){
//                        g.start();
//                    }
                    
                    System.out.println(i);
                    if(i==dado1.size()){
                     i=0;
                    }
                    int suma;
                    if(velocidad==0){
                        suma = lanzar(dado1.get(i))+lanzar(dado2.get(i));
                    }else{
                        suma = lanzar1(dado1.get(i),g)+lanzar2(dado2.get(i),g);
                    }
                    

                    cad="Suma: "+suma;
                    System.out.println(cad);
                    try {
                        Thread.sleep(velocidad*10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SimulacionSevenEleven.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    dm.addElement(cad);
//                    textArea.setModel(dm);
//                    System.out.println("Suma: "+suma);
                    if(lanzamiento==1){
                        if(suma==7 || suma ==11){
                            gano=true;
                            terminado=true;
                        }
                        if(suma==2 || suma==12 || suma==3){
                            gano=false;
                            terminado=true;
                        }
                        if((suma>=4&&suma<=6)||suma==8||suma==9||suma==10){
                           suma2=suma;
                        }
                    }else if(lanzamiento>1 && !terminado){
                        if(suma2==suma){
                            gano=true;
                            terminado=true;
                        }else if(suma==7){
                            gano=false;
                            terminado=true;
                        }
                    }
                    lanzamiento++;
                    i++;
                }
                if(gano){
                      cad="gano";
                      System.out.println(cad);
                      resultado.setText(cad);
                      resultado.setForeground(Color.green);
                      dm.addElement(cad);
//                      textArea.setModel(dm);
//                      System.out.println(cad);
                      ci+=valorDeApuesta;
                      cad="Dinero Restante: "+ci;
                      System.out.println(cad);
                      dm.addElement(cad);
//                      textArea.setModel(dm);
//                      System.out.println(cad);
                }else{
                     cad="perdio";
                      resultado.setText(cad);
                     resultado.setForeground(Color.red);
                     System.out.println(cad);
                     dm.addElement(cad);
//                     textArea.setModel(dm);
//                     System.out.println("perdio");
                     ci-=valorDeApuesta;
                     cad="Dinero Restante: "+ci;
                     System.out.println(cad);
                     dm.addElement(cad);
//                     textArea.setModel(dm);
//                     System.out.println("Dinero Restante"+ci);
                }
                if(ci==0){
                    ganaPartida=false;
                    finPartida=true;
                }
                if(ci==cantidadFinal){
                    ganaPartida=true;
                    finPartida=true;
                }
                k++;
            }
            if(ganaPartida){
                cad="gano la Partida";
                resultado.setText(cad);
                resultado.setForeground(Color.green);
                System.out.println(cad);
                dm.addElement(cad);
//                textArea.setModel(dm);
                partidasGanadas++;
                dmCorridas.addElement(j+": "+cad);
            }else{
                cad="Perdio la Partida";
                resultado.setText(cad);
                resultado.setForeground(Color.red);
                System.out.println(cad);
                dm.addElement(cad);
//                textArea.setModel(dm);
                partidasPerdidas++;
                dmCorridas.addElement(j+": "+cad); 
            }
            int v=j+1;
            float value=(float)v/corridas;
            int valor = (int) (value * 100);
            

            jp.setValue(valor);
            jp.setString("Simulando: "+ valor +" %");
        }
        float pg=(float)partidasGanadas/corridas;
        float pp=(float)partidasPerdidas/corridas;
        cad="Porcentaje de partidas Ganadas: "+pg*100;
        System.out.println(cad);
        dm.addElement(cad);
//        textArea.setModel(dm);
        cad="Porcentaje de partidas Perdidas: "+pp*100;
        System.out.println(cad);
        dm.addElement(cad);
        textArea.setModel(dm);
        listaCorrdias.setModel(dmCorridas); 
        boton.setText("Simular");
        jp.setString("Simular") ;
        boton.setEnabled(true);
    }

    private int lanzar1(float num,GirarDados g){
        int resultado1=0;
        if(num >= 0 && num <0.16){            
            resultado1=1;
            g.seleccionarDado1(resultado1);
        }else if(num >= 0.16 && num <0.32){            
            resultado1=2;
            g.seleccionarDado1(resultado1);
        }else if(num >= 0.32 && num <0.48){
            resultado1=3;
            g.seleccionarDado1(resultado1);
        }else if(num >= 0.48 && num <0.64){
            resultado1=4;
            g.seleccionarDado1(resultado1);
        }else if(num >= 0.64 && num <0.8){
            resultado1=5;
            g.seleccionarDado1(resultado1);
        }else if(num >= 0.8 && num <1){
            resultado1=6;
            g.seleccionarDado1(resultado1);
        }
        return resultado1;
    }

    private int lanzar(float num){
        int resultado1=0;
        if(num >= 0 && num <0.16){
            resultado1=1;
        }else if(num >= 0.16 && num <0.32){
            resultado1=2;
        }else if(num >= 0.32 && num <0.48){
            resultado1=3;
        }else if(num >= 0.48 && num <0.64){
            resultado1=4;
        }else if(num >= 0.64 && num <0.8){
            resultado1=5;
        }else if(num >= 0.8 && num <1){
            resultado1=6;
        }
        return resultado1;
    }

    private int lanzar2(float num,GirarDados g){
        int resultado2=0;
        if(num >= 0 && num <0.16){
            resultado2=1;
            g.seleccionarDado2(resultado2);
        }else if(num >= 0.16 && num <0.32){
            resultado2=2;
            g.seleccionarDado2(resultado2);
        }else if(num >= 0.32 && num <0.48){
            resultado2=3;
            g.seleccionarDado2(resultado2);
        }else if(num >= 0.48 && num <0.64){
            resultado2=4;
            g.seleccionarDado2(resultado2);
        }else if(num >= 0.64 && num <0.8){
            resultado2=5;
            g.seleccionarDado2(resultado2);
        }else if(num >= 0.8 && num <1){
            resultado2=6;
            g.seleccionarDado2(resultado2);
        }
        return resultado2;
    }

    
    public int getCorridas() {
        return corridas;
    }

    public void setCorridas(int corridas) {
        this.corridas = corridas;
    }

    public JList getListaCorrdias() {
        return listaCorrdias;
    }

    public void setListaCorrdias(JList listaCorrdias) {
        this.listaCorrdias = listaCorrdias;
    }

    public JList getTextArea() {
        return textArea;
    }

    public void setTextArea(JList textArea) {
        this.textArea = textArea;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public JLabel getjLabelDado1() {
        return jLabelDado1;
    }

    public void setjLabelDado1(JLabel jLabelDado1) {
        this.jLabelDado1 = jLabelDado1;
    }

    public JLabel getjLabelDado2() {
        return jLabelDado2;
    }

    public void setjLabelDado2(JLabel jLabelDado2) {
        this.jLabelDado2 = jLabelDado2;
    }

    public JLabel getResultado() {
        return resultado;
    }

    public void setResultado(JLabel resultado) {
        this.resultado = resultado;
    }

    public JProgressBar getJp() {
        return jp;
    }

    public void setJp(JProgressBar jp) {
        this.jp = jp;
    }


    
    
     


}
