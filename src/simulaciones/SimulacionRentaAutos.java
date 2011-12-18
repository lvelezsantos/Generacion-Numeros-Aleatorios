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

/**
 *
 * @author Warlock
 */
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class SimulacionRentaAutos extends Thread{
    int balanceanual;
    int clienteInsatisfecho;
    int ocioso;
    int numeroautos;
    int numerorentados;
    int diasASimular;
    int corridas;
    int autosMaximosAProbar;
    JButton boton;
    JList jListResultados;
    JList jListCorridas;
    ArrayList<Auto> auto;
    ArrayList<Float> numAutoRenPorDia;
    ArrayList<Float> diaRenPorAuto;
    DefaultListModel dlmResultados;
    DefaultListModel dlmCorridas;
    
    public SimulacionRentaAutos(){
        this.auto = new ArrayList<Auto>();
        dlmCorridas=new DefaultListModel();
        dlmResultados=new DefaultListModel();
//        for(int i=0;i<numeroautos;i++){
//            this.auto.add(new Auto());
//        }
//        this.numeroautos= numeroautos;
//        this.clienteInsatisfecho= 0;
//        this.ocioso= numeroautos;
//        this.numerorentados= 0;
    }
    
    public void rentar (int dias){
        if(numeroautos==numerorentados){
            clienteInsatisfecho++;
        }else{
//            System.out.println("Rentando Auto por "+dias);
            for(int i=0;i<numeroautos;i++){
                if(auto.get(i).getDiasrenta()==0){
                    auto.get(i).setDiasrenta(dias);
                    ocioso--;
                    numerorentados++;
                    break;
                }
            }
                       
           
//            System.out.println(ocioso);
            
        }    
    }
    
    public int balanceDia(){
        int balance = 0;
        balance=(numerorentados*350)-(clienteInsatisfecho*200)-(ocioso*50);
        balanceanual+=balance;
        clienteInsatisfecho=0;
        return balance;
    }

    @Override
    public void run(){
        String cad;
        this.boton.setEnabled(false);
        for(int j=0;j<this.corridas;j++){
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int i=1;i<=this.autosMaximosAProbar;i++){
                int ban = simularDia(i);
                list.add(ban);
                cad="El balance para el numero de autos anual para "+  i +" autos es:"+ ban;
                dlmResultados.addElement(cad);
                System.out.println(cad);
            }
            int aux=0;
            int auxIndice=0;
            for(int i=0;i<this.autosMaximosAProbar;i++){                 
                if(i==0){
                    aux=list.get(i);
                    auxIndice=i;
                }else if(aux<list.get(i)){
                    aux=list.get(i);
                    auxIndice = i;
                }
                cad="El balance para el numero de autos anual para "+  (i+1) +" autos es:"+ list.get(i);
                dlmResultados.addElement(cad);
                System.out.println(cad);
            }
            cad=(j+1)+": El numero de auto mas rentable es: "+(auxIndice+1)+" y el balance es: $ "+aux;
            dlmCorridas.addElement(cad);
            System.out.println(cad);
            System.out.println();
        }
        jListResultados.setModel(dlmResultados);
        jListCorridas.setModel(dlmCorridas);
        this.boton.setEnabled(true);
    }
    
    public int simularDia(int numAutos){
        int dias=1;
        int i=0;
        int k=0;
        this.clienteInsatisfecho= 0;
        this.numeroautos= numAutos;
        this.ocioso= numAutos;
        this.balanceanual =0;
        String cad;
        
        this.numerorentados= 0;
        if(!this.auto.isEmpty()){
            this.auto.clear();
        }
        this.auto = new ArrayList<Auto>();
        for(int m=0;m<numeroautos;m++){
            this.auto.add(new Auto());
        }
//        System.out.println(auto.size());

        while(dias<=diasASimular){
            if(i==numAutoRenPorDia.size()){
                i=0;
            }
           cad="Dia: "+dias;
           dlmResultados.addElement(cad);
           System.out.println(cad);
           int autos=0;
           if(numAutoRenPorDia.get(i)>=0.1&&numAutoRenPorDia.get(i)<0.2){
               autos=1;
           }else if(numAutoRenPorDia.get(i)<0.45){
               autos=2;
           }else if(numAutoRenPorDia.get(i)<0.75){
               autos=3;
           }else if(numAutoRenPorDia.get(i)<1){
               autos=4;
           }
           cad="Autos disponibles: "+this.ocioso;
           dlmResultados.addElement(cad);
           System.out.println(cad);
           cad="Numero de Autos Rentados del dia: "+autos;
           dlmResultados.addElement(cad);
           System.out.println(cad);
           
           if(autos>this.ocioso){
               clienteInsatisfecho+=(autos-this.ocioso);
               autos=this.ocioso;
           }


           
           int l=1;
           while(l<=autos){
               if(k==diaRenPorAuto.size())
                   k=0;

               int numDias=0;
               if (diaRenPorAuto.get(k)<0.40){
                    numDias=1;                    
                }else
                   if(diaRenPorAuto.get(k)<0.75){
                   numDias=2;
                }else
                   if(diaRenPorAuto.get(k)<0.90){
                    numDias=3;
                }else
                   if(diaRenPorAuto.get(k)<1){
                     numDias=4;
                }
                rentar(numDias);
                cad="Auto "+l+": "+numDias+" Dias";
                dlmResultados.addElement(cad);
                System.out.println(cad);
                l++;
                k++;
            }
//            clienteInsatisfecho=0;
//            ocioso=numeroautos-autos;

            
           i++;
           dias++;
           cad="Numero de Clientes insatisfechos: "+this.clienteInsatisfecho;
           dlmResultados.addElement(cad);
           System.out.println(cad);
           cad="Balance del Dia:"+balanceDia();
           dlmResultados.addElement(cad);
           System.out.println(cad);
           cad="Balance del Año:"+balanceanual;
           dlmResultados.addElement(cad);
           System.out.println(cad);

           cad="Numero de rentados: "+this.numerorentados;
           dlmResultados.addElement(cad);
           System.out.println(cad);

           cad="Numero de autos ociosos: "+this.ocioso;
           dlmResultados.addElement(cad);
           System.out.println(cad);
           

           for(int j=0;j<numeroautos;j++){
                if(auto.get(j).getDiasrenta()>0){
                    auto.get(j).setDiasrenta(auto.get(j).getDiasrenta()-1);
                    if(auto.get(j).getDiasrenta()==0){
                        numerorentados--;
                        ocioso++;
                    }
                }
            }
        }
        this.balanceanual -=(numAutos*75000);
        cad="Balance del Año:"+this.balanceanual;
        dlmResultados.addElement(cad);
        System.out.println(cad);
        
//        this.balanceanual -=(numAutos*75000);
        return this.balanceanual;

    }

    public int getClienteInsatisfecho() {
        return clienteInsatisfecho;
    }

    public void setClienteInsatisfecho(int clienteInsatisfecho) {
        this.clienteInsatisfecho = clienteInsatisfecho;
    }

    public int getDiasASimular() {
        return diasASimular;
    }

    public void setDiasASimular(int diasASimular) {
        this.diasASimular = diasASimular;
    }

    public int getCorridas() {
        return corridas;
    }

    public void setCorridas(int corridas) {
        this.corridas = corridas;
    }

    
    
    
    

    public void setNodisponible(int nodisponible) {
        this.clienteInsatisfecho = nodisponible;
    }

    public void setOcioso(int ocioso) {
        this.ocioso = ocioso;
    }

    public int getBalanceanual() {
        return balanceanual;
    }

    public void setBalanceanual(int balanceanual) {
        this.balanceanual = balanceanual;
    }

    
    public int getNodisponible() {
        return clienteInsatisfecho;
    }

    public int getOcioso() {
        return ocioso;
    }

   

    public ArrayList<Auto> getAuto() {
        return auto;
    }

    public void setAuto(ArrayList<Auto> auto) {
        this.auto = auto;
    }

    public int getNumeroautos() {
        return numeroautos;
    }

    public void setNumeroautos(int numeroautos) {
        this.numeroautos = numeroautos;
    }

    public int getNumerorentados() {
        return numerorentados;
    }

    public void setNumerorentados(int numerorentados) {
        this.numerorentados = numerorentados;
    }

    public ArrayList<Float> getDiaRenPorAuto() {
        return diaRenPorAuto;
    }

    public void setDiaRenPorAuto(ArrayList<Float> diaRenPorAuto) {
        this.diaRenPorAuto = diaRenPorAuto;
    }

    public ArrayList<Float> getNumAutoRenPorDia() {
        return numAutoRenPorDia;
    }

    public void setNumAutoRenPorDia(ArrayList<Float> numAutoRenPorDia) {
        this.numAutoRenPorDia = numAutoRenPorDia;
    }

    public int getAutosMaximosAProbar() {
        return autosMaximosAProbar;
    }

    public void setAutosMaximosAProbar(int autosMaximosAProbar) {
        this.autosMaximosAProbar = autosMaximosAProbar;
    }

    public void setJlistResultado(JList jListResultado) {
        this.jListResultados=jListResultado;
    }

    public void setJlistCorridas(JList jListCorridas) {
        this.jListCorridas=jListCorridas;

    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }
    
    
    
    
}
