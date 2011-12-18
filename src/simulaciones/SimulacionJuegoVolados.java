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

import auxiliares.SeleccionarCaraSello;
import java.awt.Dimension;
import java.awt.Point;
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
import javax.swing.JTextPane;

/**
 *
 * @author warlock
 */
public class SimulacionJuegoVolados extends Thread{
    int apuesta;
    int cantidadInicial;
    int meta;
    int corridas;
    JButton boton;
    JLabel jLabelMoneda;
    int velocidad;
    String porcentajeVictoria;
    JProgressBar jp;
    JTextArea listaCorridas;

    ArrayList<Float> numeros;
    ArrayList<String> juegos;
    private JScrollPane jScrollPaneResultados;

//    public JuegoVolados(int apuesta, int cantidadInicial, int meta, int corridas) {
//        this.apuesta = apuesta;
//        this.cantidadInicial = cantidadInicial;
//        this.meta = meta;
//        this.corridas = corridas;
//    }

    public SimulacionJuegoVolados() {
        
    }


    @Override
    public void run(){
        listaCorridas.setText("");
        boton.setEnabled(false);
//        DefaultListModel dm = new DefaultListModel();
        juegos = new ArrayList<String>();
        int auxCI = cantidadInicial;
        int auxApuesta= apuesta;
        int j=2;
        SeleccionarCaraSello selec=new SeleccionarCaraSello();
        selec.setjLabelMoneda(jLabelMoneda);
        
            for(int i=0;juegos.size()<corridas;i++){
                if(i==numeros.size())
                    i=0;                
                System.out.println(auxCI);
                if(auxApuesta>auxCI){
                    auxApuesta=auxCI;
                }
                if(numeros.get(i)<0.5){
                    try {
                         Thread.sleep(velocidad);
                    } catch (InterruptedException ex) {
                         Logger.getLogger(SimulacionJuegoVolados.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    auxCI+=auxApuesta;
                    auxApuesta=apuesta;
                    if(velocidad!=0)
                        selec.seleccionarDado1(1);
                    if(auxCI>=50){
                        juegos.add("Gana");
                        listaCorridas.append("Gana\n");
                        auxApuesta=apuesta;
                        auxCI=cantidadInicial;
                        j=2;
                    }
                
                }else{
                    try {
                         Thread.sleep(velocidad);
                    } catch (InterruptedException ex) {
                         Logger.getLogger(SimulacionJuegoVolados.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    auxCI -= auxApuesta;
                    auxApuesta= auxApuesta *j;
                    j=j*2;
                    if(velocidad!=0)
                        selec.seleccionarDado1(2);
                    if(auxCI<=0){
                        juegos.add("Quiebra");
                        listaCorridas.append("Pierde\n");
                        Dimension tamanhoTextArea = listaCorridas.getSize();
                        Point p = new Point(0,tamanhoTextArea.height);
                        jScrollPaneResultados.getViewport().setViewPosition(p);
                        auxApuesta=apuesta;
                        auxCI=cantidadInicial;
                        j=2;
                    }
                     
                }

                float var=(float)juegos.size()/corridas;
                int valor=(int)(var*100);
                jp.setValue(valor);
                jp.setString("Simulando: "+valor+" %");
                Dimension tamanhoTextArea = listaCorridas.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneResultados.getViewport().setViewPosition(p);
        }

        int gana=0;

        for(int i=0;i<juegos.size();i++){
            if(juegos.get(i).equalsIgnoreCase("Gana")){
                listaCorridas.append(i+": Gana\n");
                Dimension tamanhoTextArea = listaCorridas.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneResultados.getViewport().setViewPosition(p);
                gana++;
            }else{
                listaCorridas.append(i+": Pierde\n");
                Dimension tamanhoTextArea = listaCorridas.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneResultados.getViewport().setViewPosition(p);
            }

        }
        float porcentaje = 0;
        porcentaje =(float) gana/juegos.size();
        System.out.println(porcentaje);
        porcentaje = porcentaje*100;
        listaCorridas.append("El jugador gano: "+gana+" veces.\ny se quebró: "+(juegos.size()-gana)+"\n");
        listaCorridas.append("El porcentaje de victoria es: "+porcentaje+"%\n");
        Dimension tamanhoTextArea = listaCorridas.getSize();
        Point p = new Point(0,tamanhoTextArea.height);
        jScrollPaneResultados.getViewport().setViewPosition(p);
        boton.setEnabled(true);
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public int getCorridas() {
        return corridas;
    }

    public void setCorridas(int corridas) {
        this.corridas = corridas;
    }

    public String getPorcentajeVictoria() {
        return porcentajeVictoria;
    }

    public void setPorcentajeVictoria(String porcentajeVictoria) {
        this.porcentajeVictoria = porcentajeVictoria;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JLabel getjLabelMoneda() {
        return jLabelMoneda;
    }

    public void setjLabelMoneda(JLabel jLabelMoneda) {
        this.jLabelMoneda = jLabelMoneda;
    }

    public JTextArea getjListCorridas() {
        return listaCorridas;
    }

    public void setjListCorridas(JTextArea jListCorridas) {
        this.listaCorridas = jListCorridas;
    }

    public JProgressBar getJp() {
        return jp;
    }

    public void setJp(JProgressBar jp) {
        this.jp = jp;
    }

    public ArrayList<String> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<String> juegos) {
        this.juegos = juegos;
    }

    public ArrayList<Float> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Float> numeros) {
        this.numeros = numeros;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setJScrollPaneResultados(JScrollPane jScrollPaneResultados) {
        this.jScrollPaneResultados = jScrollPaneResultados;
    }





}
