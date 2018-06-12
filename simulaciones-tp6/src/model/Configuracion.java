/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import objects.CantidadDeArchivos;

/**
 *
 * @author heftyn
 */
public class Configuracion {
    
    private static Configuracion instancia;

    //Demora inscripcion desde
    //hasta
    //UNIFORME
    private double tiempoInscripcionDesde;
    private double tiempoInscripcionHasta;
    
    //Llegada alumnos media
    //Exponencial Negativa
    private double mediaLlegadaAlumnos;
    
    //Incio Mantenimiento desde
    //hasta
    //UNIFORME
    private double inicioMantenimientoDesde;
    private double inicioMantenimientoHasta;
    
    //Tiempo Mantenimiento desde
    //hasta
    //NORMAL
    private double tiempoMantenimientoMedio;
    private double tiempoMantenimientoDesviacion;
    
    private int minutosASimular;
    private int minutoDesde;
    private int iteracionesAMostrar;
    
    private double pasoEuler;
    private List<CantidadDeArchivos> cantidadDeArchivosList;
    
    
    private Configuracion()
    {
        this.inicioMantenimientoDesde = 57;
        this.inicioMantenimientoHasta = 63;
        this.mediaLlegadaAlumnos = 2;
        this.tiempoInscripcionDesde = 5;
        this.tiempoInscripcionHasta = 8;
        this.tiempoMantenimientoDesviacion = 0.0027;
        this.tiempoMantenimientoMedio = 3;
        //////////////////////////////////////////////
        this.minutosASimular = 120;
        this.minutoDesde = 0;
        this.iteracionesAMostrar = 1000000;
        
        this.pasoEuler = 0.1;
        this.cantidadDeArchivosList = new ArrayList<>();
        cantidadDeArchivosList.add(new CantidadDeArchivos(1000, 0.3333333, 0.3333333));
        cantidadDeArchivosList.add(new CantidadDeArchivos(1500, 0.3333333, 0.6666666));
        cantidadDeArchivosList.add(new CantidadDeArchivos(2000, 0.3333333, 0.9999999));
        
    }

    public double getTiempoInscripcionDesde() {
        return tiempoInscripcionDesde;
    }

    public void setTiempoInscripcionDesde(double tiempoInscripcionDesde) {
        this.tiempoInscripcionDesde = tiempoInscripcionDesde;
    }

    public double getTiempoInscripcionHasta() {
        return tiempoInscripcionHasta;
    }

    public void setTiempoInscripcionHasta(double tiempoInscripcionHasta) {
        this.tiempoInscripcionHasta = tiempoInscripcionHasta;
    }

    public double getMediaLlegadaAlumnos() {
        return mediaLlegadaAlumnos;
    }

    public void setMediaLlegadaAlumnos(double mediaLlegadaAlumnos) {
        this.mediaLlegadaAlumnos = mediaLlegadaAlumnos;
    }

    public double getInicioMantenimientoDesde() {
        return inicioMantenimientoDesde;
    }

    public void setInicioMantenimientoDesde(double inicioMantenimientoDesde) {
        this.inicioMantenimientoDesde = inicioMantenimientoDesde;
    }

    public double getInicioMantenimientoHasta() {
        return inicioMantenimientoHasta;
    }

    public void setInicioMantenimientoHasta(double inicioMantenimientoHasta) {
        this.inicioMantenimientoHasta = inicioMantenimientoHasta;
    }

    public double getTiempoMantenimientoMedio() {
        return tiempoMantenimientoMedio;
    }

    public void setTiempoMantenimientoMedio(double tiempoMantenimientoMedio) {
        this.tiempoMantenimientoMedio = tiempoMantenimientoMedio;
    }

    public double getTiempoMantenimientoDesviacion() {
        return tiempoMantenimientoDesviacion;
    }

    public void setTiempoMantenimientoDesviacion(double tiempoMantenimientoDesviacion) {
        this.tiempoMantenimientoDesviacion = tiempoMantenimientoDesviacion;
    }
    
    public static Configuracion getConfiguracion()
    {
        if (instancia == null)
        {
            instancia = new Configuracion();
        }
        return instancia;
    }
    
    public static Configuracion getConfiguracionPorDefecto() 
    {
        instancia = new Configuracion();
        return instancia;
    }

    public int getMinutosASimular() {
        return this.minutosASimular;
    }
    
    public void setMinutosASimular(int minutosASimular)
    {
        this.minutosASimular = minutosASimular;
    }
    
    public void setMinutoDesde(int minutoDesde){
        this.minutoDesde = minutoDesde;
    }
    
    public int getMinutoDesde(){
       return this.minutoDesde;
    }
    
    public int getIteracionesAMostrar(){
        return this.iteracionesAMostrar;
    }
    
    public void setIteracionesAMostrar(int iteracionesAMostrar){
        this.iteracionesAMostrar = iteracionesAMostrar;
    }

    public List<CantidadDeArchivos> getCantidadArchivos() 
    {
        return this.cantidadDeArchivosList;
    }
    
    public void setCantidadArchivos(List<CantidadDeArchivos> cant)
    {
        this.cantidadDeArchivosList = cant;
    }

    public void setPasoEulerH(Double pasoEuler) {
        this.pasoEuler = pasoEuler;
    }
    
    public double getPasoEuler()
    {
        return this.pasoEuler;
    }
}
