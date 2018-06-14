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
public class CantidadDeArchivos 
{

    private double cantidad;
    private double probabilidad;
    private double probabilidadAcumulada;
    
    public CantidadDeArchivos()
    {
        cantidad = probabilidad = probabilidadAcumulada = Double.NaN;
    }
    
    public CantidadDeArchivos(double cant, double prob, double probAc)
    {
        this.cantidad = cant;
        this.probabilidad = prob;
        this.probabilidadAcumulada = probAc;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(double probabilidad) {
        this.probabilidad = probabilidad;
    }

    public double getProbabilidadAcumulada() {
        return probabilidadAcumulada;
    }

    public void setProbabilidadAcumulada(double probabilidadAcumulada) {
        this.probabilidadAcumulada = probabilidadAcumulada;
    }
    
    
    public boolean esRNDMenorAProbabilidadAcumulada(double rnd)
    {
        return rnd < probabilidadAcumulada;
    }
}
