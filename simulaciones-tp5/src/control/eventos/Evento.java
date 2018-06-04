/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.eventos;

/**
 *
 * @author heftyn
 */
public abstract class Evento 
{
    public static final Evento Inicial = new EventoInicial("Inicial");
    public static final Evento FinInscripcion = new EventoFinInscripcion("Fin inscripcion");
    public static final Evento FinMantenimiento = new EventoFinMantenimiento("Fin mantenimiento");
    public static final Evento InicioMantenimiento = new EventoInicioMantenimiento("Inicio ronda mantenimiento");
    public static final Evento LlegadaAlumno = new EventoLlegadaAlumno("Llegada Alumno");
    public static final Evento RegresoAlumno = new EventoRegresoAlumno("Regreso Alumno");
    
    private double horaEvento;
    private String nombre;
    
    public Evento(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    public void setHoraEvento(double hora)
    {
        horaEvento = hora;
    }
    
    public double getHoraEvento()
    {
        return horaEvento;
    }
    
    public abstract void actualizarEstadoVector();
}
