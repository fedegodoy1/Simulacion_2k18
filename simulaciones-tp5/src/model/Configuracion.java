/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    
    private Configuracion()
    {
        this.inicioMantenimientoDesde = 57;
        this.inicioMantenimientoHasta = 63;
        this.mediaLlegadaAlumnos = 2;
        this.tiempoInscripcionDesde = 5;
        this.tiempoInscripcionHasta = 8;
        this.tiempoMantenimientoDesviacion = 0.0027;
        this.tiempoMantenimientoMedio = 3;
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
}
