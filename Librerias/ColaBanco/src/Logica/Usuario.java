/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;


public class Usuario {
    private double TLlegada;
    private double TCaja;
    private double TGlobal;
    private double TFila;

    public Usuario(double TLlegada, double TCaja, double TGlobal, double TFila) {
        this.TLlegada = TLlegada;
        this.TCaja = TCaja;
        this.TGlobal = TGlobal;
        this.TFila = TFila;
    }



    public double getTCaja() {
        return TCaja;
    }

    public void setTCaja(double TCaja) {
        this.TCaja = TCaja;
    }

    public double getTFila() {
        return TFila;
    }

    public void setTFila(double TFila) {
        this.TFila = TFila;
    }

    public double getTGlobal() {
        return TGlobal;
    }

    public void setTGlobal(double TGlobal) {
        this.TGlobal = TGlobal;
    }

    public double getTLlegada() {
        return TLlegada;
    }

    public void setTLlegada(double TLlegada) {
        this.TLlegada = TLlegada;
    }
}
