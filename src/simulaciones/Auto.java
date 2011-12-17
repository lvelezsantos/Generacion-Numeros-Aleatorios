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


public class Auto {

    int diasrenta;  
    
    public void setDiasrenta(int diasrenta) {
        this.diasrenta = diasrenta;
    }

    public int getDiasrenta() {
        return diasrenta;
    }
    
    
    public Auto(){
        this.diasrenta= 0;
        }
    public Auto(int diasrenta){
        this.diasrenta= diasrenta;
        }
    
}
