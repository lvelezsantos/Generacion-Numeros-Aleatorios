/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 * Autores:
 * Luis Alfonso Velez Santos
 * Carlos Yesid Hernandez Herrera
 * Jose Esteban Betin Diaz
 *
 *
 * Hola mundo
 */


package GenaracionNumeros;

import java.util.ArrayList;
import auxiliares.Auxiliares;
import javax.swing.JOptionPane;

public class NumerosRectangulares {


    public ArrayList<Float> congruencialMixto(int m, int c, int a, int inicio){

        ArrayList<Float> nums = new ArrayList<Float>();

        int r=inicio;
        int aux=inicio;
        int i=0;
        int aux2=0;
        int aux3=0;
        do{
            try{
            r =(r*a + c)%m;
            if(r==aux3||i>=m)
                break;
            if(i==0)
                aux2=r;
            else{
                aux=aux2;
                aux3=r;
            }
            
            
//            System.out.println(i+ ": "+r);

            float numReal =(float) r/m;
            System.out.println(numReal);
            nums.add(new Float(numReal));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se puede dividir entre 0\n"+e);
            }
            //System.out.println(nums.toString());
            i++;
        }while(r!=aux);
//        System.out.println(i);

        return nums;
    }


    public ArrayList<Float> congruencialMixtoValidado(int m, int c, int a, int inicio){
        
        ArrayList<Float> nums = new ArrayList<Float>();
//          && m>inicio &&
//                && m>c && Auxiliares.esPrimo(m)&&a>c){
        if(inicio>0){
            if(a>0){
                if(Auxiliares.esImpar(a)){
                    if(!Auxiliares.esDivisible(a, 5)&&!Auxiliares.esDivisible(a, 3)){
                        if(c>0){
                            if((c%8)==5){
                                if(m>inicio ){
                                    if(m>a){
                                        if(Auxiliares.esPrimo(m)){
                                            if(a>c){
                                                int r=inicio;
                                                int i=0;
                                                do{
                                                    i++;
                                                    r =(r*a + c)%m;
                                    //                System.out.println(i+ ": "+r);

                                                    float numReal =(float) r/m;
                                                    System.out.println(numReal);
                                                    nums.add(new Float(numReal));
                                                    //System.out.println(nums.toString());
                                                }while(r!=inicio);
                                    //            System.out.println(i);
                                            }else{
                                                JOptionPane.showMessageDialog(null, "a<c", "Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null, "m no es primo", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "m < a", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "m < inicio", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "(c%8)!=5", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "c < 0", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "a es divisible por 5 o por 3", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "a es par", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "a < 0", "Error", JOptionPane.ERROR_MESSAGE);
            }           
        }else{
            JOptionPane.showMessageDialog(null, "Inicio debe ser mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
        }

       
        return nums;
    }

     public ArrayList<Float> congruencialMultiplicativo(int m, int a, int inicio){
        ArrayList<Float> nums = new ArrayList<Float>();
        String error="";
        int r=inicio;
        int i=0;

        do{
            try{
            if(i==1)
                inicio=r;
            r=(a*r)%m;
            float numReal=(float)r/m;
            System.out.println(i+ ": "+numReal);
            nums.add(new Float(numReal));
            i++;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se puede dividir entre 0\n"+e);
            }
        }while(i<(m/4));

        System.out.println(error);
        return nums;
    }


    public ArrayList<Float> congruencialMultiplicativoValidado(int m, int a, int inicio){
        ArrayList<Float> nums = new ArrayList<Float>();
        String error="";
        int r=inicio;
        int i=0;
        if(Auxiliares.esImpar(inicio)){
            if(Auxiliares.primoRelativo(inicio, m)){
                if(!Auxiliares.esImpar(m)){
                    do{
                        r=(a*r)%m;                        
                        float numReal=(float)r/m;
                        System.out.println(i+ ": "+numReal);
                        nums.add(new Float(numReal));
                        i++;
                    }while(i!=(m/4));
                }else{
                    JOptionPane.showMessageDialog(null, "El m ingresado  es impar. Y deberia de ser par", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "\nLa semilla ingresada no es primo relativo de m. Y deberia de serlo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "La semilla ingresada es par. Y deberia de ser impar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(error);
        return nums;
    }

    public ArrayList<Float> congruencialCuadraticoValidado( int m,int d,int a, int c,int inicio){
        ArrayList<Float> nums = new ArrayList<Float>();
        String error="";
        int r = inicio;
        System.out.println("metodo cuadratico");
        if(Auxiliares.primoRelativo(c, m)&&Auxiliares.validarVariablesAuxiliaresMC(a, d, m)&&Auxiliares.ValidarDyA_MC(m, a, d, c)){
            int i=0;
            
            do{
                i++;
                r=((d*(r*r))+(a*r)+c)%m;

                float resultado =(float) r/m;
                nums.add(new Float(resultado));
                System.out.println(resultado);
            }while(i<m);
//            System.out.println(i);
        }else{
           JOptionPane.showMessageDialog(null, "Hay errores en los elementos ingresados.\nverifique la ayuda para mayor información");
        }
        return nums;
    }

    public ArrayList<Float> congruencialCuadratico( int m,int d,int a, int c,int inicio){
        ArrayList<Float> nums = new ArrayList<Float>();
        String error="";
        int r = inicio;
        System.out.println("metodo cuadratico");

            int i=0;

            do{
                try{
                i++;
                r=((d*(r*r))+(a*r)+c)%m;

                float resultado =(float) r/m;
                nums.add(new Float(resultado));
                System.out.println(resultado);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se puede dividir entre cero\n"+e);
                }
            }while(i<m);
//            System.out.println(i);
        
        return nums;
    }

    public ArrayList<Float> metodoAditivoFibonacci(int m,int x, int x0){
        ArrayList<Float> nums = new ArrayList<Float>();
        int i=0;
        if(m>0 && (x>0 || x0>0)){
            do{
                int aux=x;
                int r = (x0+x)%m;
                x0=aux;
                x=r;
                float resultado=(float)r/m;
                nums.add(new Float(resultado));
                //System.out.println(i);
                i++;
            }while(i<m);
        }
        return nums;
    }

    public ArrayList<Float> metodoAditivoGreen(int m,int k){
        ArrayList<Float> nums = new ArrayList<Float>();
//        Calendar cal= Calendar.getInstance();
        ArrayList<Float> vectorGreen=new ArrayList<Float> ();
//        vectorGreen.addAll(metodoAditivoFibonacci(k, cal.get(Calendar.MILLISECOND)/1000, cal.get(Calendar.SECOND)/60));
        vectorGreen.addAll(metodoAditivoFibonacci(m, 1, 0));
//        System.out.println(vectorGreen.size());
        if(m>k&&k>=16){
            for(int i=0;i<m;i++){
                int r =0;
                int xn = (int) (vectorGreen.get(vectorGreen.size() - k) * m);
                int xnk = (int) (vectorGreen.get(i)*m);
                r= (xn+xnk)%m;
//                System.out.println("x: "+xn);
                float resultado=(float)r/m;
                vectorGreen.add(new Float(resultado));
                nums.add(new Float(resultado));
    //            System.out.println(nums.size());
            }
        }else{
            JOptionPane.showMessageDialog(null, "k debe de ser >= 16 y m > k");
        }

        return nums;
    }

    public ArrayList<Float> MetodoAditivoMichellMoore(int m, int n){
        ArrayList<Float> nums = new ArrayList<Float>();
        ArrayList<Float> vectorMoore=new ArrayList<Float> ();
        vectorMoore.addAll(metodoAditivoFibonacci(n, 1, 0));
        if(n>54)
        for(int i=0;i<m;i++) {
            int xn24 = (int) ((vectorMoore.get((vectorMoore.size()-1) - 24))*n);
//            System.out.println(xn24);
            int xnn = (int)((vectorMoore.get(vectorMoore.size()-n))*n);
            int r = (xn24+xnn)%m;
            float resultado =(float) r/m;
            vectorMoore.add(new Float(resultado));
            nums.add(new Float(resultado));
//            System.out.println(resultado);
        }else{
            JOptionPane.showMessageDialog(null, "n debe de ser > 54");
        }
        return nums;
    }

    public ArrayList<Float> metodoMixto(int m, int k,int n){
        ArrayList<Float> nums = new ArrayList<Float>();
        ArrayList<Float> numsGreen = new ArrayList<Float>();
        ArrayList<Float> numsMichell = new ArrayList<Float>();
        numsGreen.addAll(metodoAditivoGreen(m, k));
        numsMichell.addAll(MetodoAditivoMichellMoore(m, n));
        if(!numsMichell.isEmpty()&&!numsGreen.isEmpty()){
            for(int i=0;i<m;i++){
                int r = (int) (((numsGreen.get(i) * m) + (numsMichell.get(i) * m)) % m);
                float resultado=(float) r/m;
                nums.add(new Float(resultado));
                System.out.println(resultado);
            }
        }

        return nums;
    }

    public ArrayList<Float> metodoMezcla1(int m,int k){
        ArrayList<Float> nums = new ArrayList<Float>();
        if(m>k&&k>16){

            ArrayList<Float> numsGreen = new ArrayList<Float>();
            ArrayList<Float> numsGreen2 = new ArrayList<Float>();
            numsGreen.addAll(metodoAditivoGreen(m, k));
            numsGreen2.addAll(metodoAditivoGreen(m, k));
            ArrayList<Float> vector = new ArrayList<Float>();
            for(int i=0;i<k;i++){
                vector.add(numsGreen2.get(i));
            }
            for(int i=0;i<m;i++){
                int j= (int) (k * numsGreen2.get(i)) ;
                nums.add(numsGreen.get(j));
//                System.out.println(j);
            }
        }else{
            JOptionPane.showMessageDialog(null, "M debe ser mayor que K y k>16");
        }
        return nums;
    }

    public ArrayList<Float> metodoMezcla2(int m,int k){
        ArrayList<Float> nums = new ArrayList<Float>();
        if(m>k&&k>16){
            ArrayList<Float> numsGreen = new ArrayList<Float>();
            numsGreen.addAll(metodoAditivoGreen(m, k));
            ArrayList<Float> vector = new ArrayList<Float>();
            for(int i=0;i<k;i++){
                vector.add(numsGreen.get(i));
            }
            for(int i=0;i<m;i++){
                int j= (int) (k * numsGreen.get(i)) ;
                nums.add(numsGreen.get(j));
//                System.out.println(j);
            }
        }else{
            JOptionPane.showMessageDialog(null, "M debe ser mayor que K y k>16");
        }
        return nums;
    }
}


