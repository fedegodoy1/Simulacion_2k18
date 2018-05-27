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
    public static final Evento Inicial = new EventoInicial();
    public static final Evento FinInscripcion = new EventoFinInscripcion();
    public static final Evento FinMantenimiento = new EventoFinMantenimiento();
    public static final Evento InicioMantenimiento = new EventoInicioMantenimiento();
    public static final Evento LlegadaAlumno = new EventoLlegadaAlumno();
    public static final Evento RegresoAlumno = new EventoRegresoAlumno();
    
    public abstract void actualizarEstadoVector();
}
