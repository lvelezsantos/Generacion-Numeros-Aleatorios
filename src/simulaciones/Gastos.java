/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulaciones;

/**
 *
 * @author warlock
 */
public class Gastos {
    int cantidadOrdenar, nivelReorden;
    int gastoTotal;

    public Gastos(int cantidadOrdenar, int nivelReorden, int gastoTotal) {
        this.cantidadOrdenar = cantidadOrdenar;
        this.nivelReorden = nivelReorden;
        this.gastoTotal = gastoTotal;
    }

    public int getCantidadOrdenar() {
        return cantidadOrdenar;
    }

    public void setCantidadOrdenar(int cantidadOrdenar) {
        this.cantidadOrdenar = cantidadOrdenar;
    }

    public int getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(int gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public int getNivelReorden() {
        return nivelReorden;
    }

    public void setNivelReorden(int nivelReorden) {
        this.nivelReorden = nivelReorden;
    }
    
}
