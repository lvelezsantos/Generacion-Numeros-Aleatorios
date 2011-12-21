/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import colabanco.Main;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Simulacion {
        ArrayList <Usuario>  U;
        Usuario[] FILA ;//Fila
        Usuario[] CAJA={null,null,null};//Caja
        ArrayList <Usuario> SALIDA;//Salida de Caja

    public Simulacion() {
        definirVectores();
    }

    private void definirVectores(){
         U= UsuarioMetodos.CrearUsuarios();
         FILA = new Usuario[U.size()];//Fila
         SALIDA = new ArrayList<Usuario>();
    }

    public void simular(){
       int aux=0;

        for (int i = 0; i < U.size(); i++) {
            aux=(int) (aux + U.get(i).getTCaja());
        }
        int control = 0;
        
        
        do{
            
            for (int i = control; i < U.size(); i++) {
                if(U.get(i).getTLlegada()>0){
                U.get(i).setTLlegada(U.get(i).getTLlegada()-1);
                    System.out.println("Tiempo de llegada para el proximo usuario: "+U.get(i).getTLlegada());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                if(U.get(i).getTLlegada()==0){
                    for (int j = 0; j < U.size(); j++) {
                        if(FILA[j]==null){
                           FILA[j]=U.get(i);

                           control++;
                           Main.g.animarEntrada();
                           try {
                        Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                           deFilaACaja();
                           break;
                        }
                    }
                }
                deFilaACaja();
                break;
                }else{
                    if(U.get(i).getTLlegada()==0){
                    for (int j = 0; j < U.size(); j++) {
                        if(FILA[j]==null){
                           FILA[j]=U.get(i);
                           deFilaACaja();
                           control++;
                        Main.g.animarEntrada();
                        try {
                        Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        deFilaACaja();
                        break;
                        }
                    }
                }
                deFilaACaja();
                break;
                }

            }
            for (int i = 0; i < U.size()&&FILA[i]!=null; i++) {
                FILA[i].setTGlobal(FILA[i].getTGlobal()+1);

            }
            
            if(control==U.size()){
                deFilaACaja();
            }
            }while(SALIDA.size()<U.size());
        
        Main.g.getjLabel3().setText("Tiempo total de las cajas : "+aux);
        Main.g.getjLabel9().setText("Tiempo promedio de usuarios en las cajas : "+aux/U.size());
    }
    private void deFilaACaja(){
        for(int j=0;j<3;j++){
            if(CAJA[j]!=null){
            CAJA[j].setTCaja(CAJA[j].getTCaja()-1);
            System.out.println("Tiempo restante en caja:  "+j+" "+"es: "+(int)CAJA[j].getTCaja());
            if(CAJA[j].getTCaja()<=0){
                SALIDA.add(CAJA[j]);
                CAJA[j]=null;
                Main.g.sacar(j);
                System.out.println("Salir de la caja");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            CAJA[j]=FILA[0];
            if(FILA[1]==null){
                FILA[0]=null;
            }
            for(int i=1;i<FILA.length&&FILA[i]!=null;i++){
                FILA[i-1]=FILA[i];
                
            }
                
        }
        }
        Main.g.deFilaACaja();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
