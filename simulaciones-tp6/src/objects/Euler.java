/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author heftyn
 */
public class Euler 
{

    private double t;
    private double A;
    private double derivada;
    private double tiempo_siguiente;
    private double A_sigiente;

    public double getTiempoActual() {
        return t;
    }

    public void setTiempoActual(double t) {
        this.t = t;
    }

    public double get_A_CantidadArchivosRestantesActuales() {
        return A;
    }

    public void set_A_CantidadArchivosRestantesActuales(double A) {
        this.A = A;
    }

    public double getDerivada() {
        return derivada;
    }

    public void setDerivada(double derivada) {
        this.derivada = derivada;
    }

    public double getTiempoSiguiente() {
        return tiempo_siguiente;
    }

    public void setTiempoSiguiente(double tiempo_siguiente) {
        this.tiempo_siguiente = tiempo_siguiente;
    }

    public double get_A_sigiente() {
        return A_sigiente;
    }

    public void set_A_sigiente(double A_sigiente) {
        this.A_sigiente = A_sigiente;
    }
}
