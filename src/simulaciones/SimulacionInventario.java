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

/**
 *
 * @author warlock
 */
public class SimulacionInventario extends Thread{
    ArrayList<Float> poisson;
    ArrayList<Float> binomial;    
    ArrayList<Float> bin;
    ArrayList<Float> pois;
    JTextArea jtextArea;
    JTextArea listaResultado;
    JTextArea listaCorridas;
    JScrollPane jScrollPaneResultado;
    JScrollPane jScrollPaneCorridas;
    JButton boton;
    JProgressBar jp;
    int costoPor8Dias;
    int costoPor30Art;
    int lamda;
    float teta;
    int n;
    int numCorridas;
    int acum30;
    int acum8;
    int dias;
    private int velocidad;

    public SimulacionInventario(float teta, int n,int lamda,int numCorridas) {
        poisson = new ArrayList<Float>();
        binomial = new ArrayList<Float>();
        

        this.teta = teta;
        this.n = n;
        this.lamda = lamda;
        this.numCorridas=numCorridas;
    }

    public SimulacionInventario(int numCorridas){
        poisson = new ArrayList<Float>();
        binomial = new ArrayList<Float>();
        this.teta = (float) 0.5;
        this.n = 6;
        this.lamda = 3;
        
        this.numCorridas=numCorridas;

    }



    public ArrayList<Float> distribucionBinomial(){
        if(!binomial.isEmpty())
           binomial.clear();
        float x=0;
        binomial.add((float)0);
        for(int i=0;i<n;i++){
            float resultado= (float) (combinacion(n, i) * Math.pow(teta, i) * Math.pow(1 - teta, n - i));
            x+=resultado;
            binomial.add(x);
            System.out.println(x);
        }
        return binomial;
    }

    public ArrayList<Float> distribucionPoisson(){
        float x=0;
        if(!poisson.isEmpty())
           poisson.clear();
        poisson.add((float)0);
        for(int i=0;i<15;i++){
            float numerador= (float) (Math.pow(Math.E, -lamda) * Math.pow(lamda, i));
            float denominador=factorial(i);
            float resultado= numerador/denominador;
            x+=resultado;
            poisson.add(x);
            System.out.println(x);
        }
        return poisson;
    }

    public float combinacion(int a, int b)    {
        float combinacion=(float)factorial(a)/(factorial(b)*factorial(a-b));
        return combinacion;
    }

    public void run(){    
        boton.setEnabled(false);
        acum30=0;
        acum8=0;
        int k=0;
        int l=0;

        jp.setString("Simulando: 0 %");
        for(int j=0;j<numCorridas;j++){

            
            int unidadesDisponibles=30;
            costoPor8Dias=0;

            for(int i=1;i<=dias;i++){
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulacionInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(k==bin.size()){
                    k=0;
                }
                if(l==pois.size()){
                    k=0;
                }
                if(escogerBinomial(bin.get(k))<=unidadesDisponibles){
                    unidadesDisponibles = unidadesDisponibles-escogerBinomial(bin.get(k));
                    costoPor8Dias+=escogerPoisson(pois.get(k)*bin.get(k));
                }else{
                    listaResultado.append("No hay suficientes articulos para la venta\n");
                    System.out.println("No hay suficientes articulos para la venta");
                    costoPor8Dias+=escogerBinomial(bin.get(k))*10;
                }

                if(i%8==0){
                    unidadesDisponibles+=(30-unidadesDisponibles);
                    costoPor8Dias+=50;
                }
                k++;
                listaResultado.append("Costo 8 Dias:"+costoPor8Dias+", dia "+i+", unidades: "+unidadesDisponibles+"\n");
//                System.out.println("Costo 8 Dias:"+costoPor8Dias+", dia "+i+", unidades: "+unidadesDisponibles);
                Dimension tamanhoTextArea = listaResultado.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneResultado.getViewport().setViewPosition(p);
            }
            unidadesDisponibles=30;
            costoPor30Art=0;
            for(int i=1;i<=dias;i++){
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulacionInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(l==bin.size()){
                    l=0;
                }
                if(l==pois.size()){
                    l=0;
                }
                if(escogerBinomial(bin.get(l))<=unidadesDisponibles){
                    unidadesDisponibles = unidadesDisponibles-escogerBinomial(bin.get(l));
                    costoPor30Art+=escogerPoisson(pois.get(l)*bin.get(l));
                }else{
                    listaResultado.append("No hay suficientes articulos para la venta\n");
//                    System.out.println("No hay suficientes articulos para la venta");
                    costoPor30Art+=escogerBinomial(bin.get(l))*10;
                }

                if(unidadesDisponibles<=10){
                    unidadesDisponibles+=(30-unidadesDisponibles);
                    costoPor30Art+=50;
                }
                listaResultado.append("Costo 30 art:"+costoPor30Art+", dia "+i+", unidades: "+unidadesDisponibles+"\n");
//                System.out.println("Costo 30 art:"+costoPor30Art+", dia "+i+", unidades: "+unidadesDisponibles);
                l++;
                Dimension tamanhoTextArea = listaResultado.getSize();
                Point p = new Point(0,tamanhoTextArea.height);
                jScrollPaneResultado.getViewport().setViewPosition(p);
            }

            if(costoPor30Art>costoPor8Dias){
                listaResultado.append((j+1)+": Mayor para 30 Art\n");
                listaCorridas.append((j+1)+": Mayor para 30 Art\n");
                acum30++;
            }else{
                listaResultado.append((j+1)+": Mayor para 8 Dias\n");
                listaCorridas.append((j+1)+": Mayor para 8 Dias\n");
                acum8++;                
            }
            float value=(float)(j+1)/numCorridas;
            int valor = (int) (value * 100);
            jp.setValue(valor);
            jp.setString("Simulando: "+ valor +" %");
            Dimension tamanhoTextArea = listaResultado.getSize();
            Point p = new Point(0,tamanhoTextArea.height);
            jScrollPaneResultado.getViewport().setViewPosition(p);
            Dimension tamanhoTextArea2 = listaCorridas.getSize();
            Point p2 = new Point(0,tamanhoTextArea2.height);
            jScrollPaneCorridas.getViewport().setViewPosition(p2);
        }

        float aux1=((float)getAcum30()/getNumCorridas())*100;
        float aux2=((float)getAcum8()/getNumCorridas())*100;
        String economica = "";
        if(getAcum30()>getAcum8()){
            economica="Es mas economica la compra cada 8 dias\n";
            listaResultado.append(economica);
        }else{
            economica="Es mas economica la compra cada 30 articulos\n";
            listaResultado.append(economica);
        }
        jtextArea.setText("Resultados\n\nPara cada 30 Articulos el numero\nde veces "
                + "que fue mayor es: "+getAcum30()+
                "\nPara cada 8 dias el numero\nde veces que fue mayor es: "+getAcum8()+""
                + "\nEl porcentaje para 30 articulos es: "+aux1+"%\n"
                + "El porcetaje para 8 dias es: "+aux2+"%" +"\n"+economica);      
        boton.setEnabled(true);
    }

    public JTextArea getJtextArea() {
        return jtextArea;
    }

    public void setJtextArea(JTextArea jtextArea) {
        this.jtextArea = jtextArea;
    }

    public int escogerBinomial(float num){
        int r=0;
        for(int i=0;i<(binomial.size()-1);i++){
            if((num>=binomial.get(i))&&(num<binomial.get(i+1))){
//                System.out.println(i);
                r=i;
            }
        }
        return r;
    }

    public int escogerPoisson(float num){
        int r=0;
        for(int i=0;i<(poisson.size()-1);i++){
            if((num>=poisson.get(i))&&(num<poisson.get(i+1))){
//                System.out.println(i);
                r=i;
            }
        }
        return r;
    }

    public float factorial(int num){
        float resultado=1;
        if(num!=0){
            do{
                resultado=resultado*num;
                num--;
            }while(num>0);
        }
//        System.out.println(resultado);
        return resultado;
    }

    public ArrayList<Float> getBinomial() {
        return binomial;
    }

    public void setBinomial(ArrayList<Float> binomial) {
        this.binomial = binomial;
    }

    public int getLamda() {
        return lamda;
    }

    public void setLamda(int lamda) {
        this.lamda = lamda;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public float getTeta() {
        return teta;
    }

    public void setTeta(float teta) {
        this.teta = teta;
    }

    public int getCostoPor30Art() {
        return costoPor30Art;
    }

    public void setCostoPor30Art(int costoPor30Art) {
        this.costoPor30Art = costoPor30Art;
    }

    public int getCostoPor8Dias() {
        return costoPor8Dias;
    }

    public void setCostoPor8Dias(int costoPor8Dias) {
        this.costoPor8Dias = costoPor8Dias;
    }

    public int getAcum30() {
        return acum30;
    }

    public void setAcum30(int acum30) {
        this.acum30 = acum30;
    }

    public int getAcum8() {
        return acum8;
    }

    public void setAcum8(int acum8) {
        this.acum8 = acum8;
    }

    public int getNumCorridas() {
        return numCorridas;
    }

    public void setNumCorridas(int numCorridas) {
        this.numCorridas = numCorridas;
    }
 
    public ArrayList<Float> getBin() {
        return bin;
    }

    public void setBin(ArrayList<Float> bin) {
        this.bin = bin;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public JTextArea getListaCorridas() {
        return listaCorridas;
    }

    public void setListaCorridas(JTextArea listaCorridas) {
        this.listaCorridas = listaCorridas;
    }

    public JTextArea getListaResultado() {
        return listaResultado;
    }

    public void setListaResultado(JTextArea listaResultado) {
        this.listaResultado = listaResultado;
    }

    public ArrayList<Float> getPois() {
        return pois;
    }

    public void setPois(ArrayList<Float> pois) {
        this.pois = pois;
    }

    public JProgressBar getJp() {
        return jp;
    }

    public void setJp(JProgressBar jp) {
        this.jp = jp;
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

    public void setVelocidad(int i) {
        this.velocidad = i;
    }



}
