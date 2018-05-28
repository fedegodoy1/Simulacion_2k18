/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.eventos.Evento;
import eventos.FinInscripcion;
import eventos.FinMantenimiento;
import eventos.InicioMantenimiento;
import eventos.LlegadaAlumno;
import java.util.List;
import model.VectorEstadoUI;
import objects.Alumno;
import objects.ColaAlumnos;
import objects.Encargado;
import objects.Maquina;

/**
 *
 * @author heftyn
 */
public class VectorEstado implements VectorEstadoUI
{

    private double reloj;
    
    private Evento evento;
    
    private LlegadaAlumno llegadaAlumno;
    
    private InicioMantenimiento inicioMantenimiento;
    
    private FinMantenimiento finMantenimiento;
    
    private ColaAlumnos colaAlumnos;
    
    private FinInscripcion finInscripcion;
    
    private List<Maquina> maquinas;
    
    private int acumuladoInscripciones;
    
    private int acumuladoAlumnosQueLlegan;
    
    private int acumuladoAlumnosQueLleganYSeVan;
    
    private Encargado encargado;
    
    private List<Alumno> alumnos;
    
    private List<Alumno> alumnosInscribiendose;
    
    private List<Alumno> alumnosEnCola;
    
    @Override
    public double getReloj() {
        return reloj;
    }

    @Override
    public Evento getEvento() {
        return evento;
    }

    @Override
    public LlegadaAlumno getLlegadaAlumno() {
        return llegadaAlumno;
    }

    @Override
    public InicioMantenimiento getInicioMantenimiento() {
        return inicioMantenimiento;
    }

    @Override
    public FinMantenimiento getFinMantenimiento() {
        return finMantenimiento;
    }

    @Override
    public ColaAlumnos getColaAlumnos() {
        return colaAlumnos;
    }

    @Override
    public FinInscripcion getFinInscripcion() {
        return finInscripcion;
    }

    @Override
    public List<Maquina> getMaquinasList() {
        return maquinas;
    }

    @Override
    public int getAcumuladoInscripciones() {
        return acumuladoInscripciones;
    }

    @Override
    public int getAcumuladoAlumnosQueLlegan() {
        return acumuladoAlumnosQueLlegan;
    }

    @Override
    public int getAcumuladoAlumnosQueLleganYSeVan() {
        return acumuladoAlumnosQueLleganYSeVan;
    }

    @Override
    public Encargado getEncargado() {
        return encargado;
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setReloj(double reloj) {
        this.reloj = reloj;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setLlegadaAlumno(LlegadaAlumno llegadaAlumno) {
        this.llegadaAlumno = llegadaAlumno;
    }

    public void setInicioMantenimiento(InicioMantenimiento inicioMantenimiento) {
        this.inicioMantenimiento = inicioMantenimiento;
    }

    public void setFinMantenimiento(FinMantenimiento finMantenimiento) {
        this.finMantenimiento = finMantenimiento;
    }

    public void setColaAlumnos(ColaAlumnos colaAlumnos) {
        this.colaAlumnos = colaAlumnos;
    }

    public void setFinInscripcion(FinInscripcion finInscripcion) {
        this.finInscripcion = finInscripcion;
    }

    public void setMaquinas(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public void setAcumuladoInscripciones(int acumuladoInscripciones) {
        this.acumuladoInscripciones = acumuladoInscripciones;
    }

    public void setAcumuladoAlumnosQueLlegan(int acumuladoAlumnosQueLlegan) {
        this.acumuladoAlumnosQueLlegan = acumuladoAlumnosQueLlegan;
    }

    public void setAcumuladoAlumnosQueLleganYSeVan(int acumuladoAlumnosQueLleganYSeVan) {
        this.acumuladoAlumnosQueLleganYSeVan = acumuladoAlumnosQueLleganYSeVan;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    public void addAlumno(Alumno a) {
        alumnos.add(a);
    }
    
    public void agregarAlumnoACola(Alumno newAlumno) {
        alumnosEnCola.add(newAlumno);
        colaAlumnos.agregarAlumnoCola();
    }
    
    public void acumularAlumnoQueLlega() {
        acumuladoAlumnosQueLlegan ++;
    }
    
    public void acumularAlumnoQueLlegaYSeVa() {
        acumuladoAlumnosQueLleganYSeVan ++;
    }

    public List<Alumno> getAlumnosInscribiendose() {
        return alumnosInscribiendose;
    }

    public void setAlumnosInscribiendose(List<Alumno> alumnosInscribiendose) {
        this.alumnosInscribiendose = alumnosInscribiendose;
    }

    public List<Alumno> getAlumnosEnCola() {
        return alumnosEnCola;
    }

    public void setAlumnosEnCola(List<Alumno> alumnosEnCola) {
        this.alumnosEnCola = alumnosEnCola;
    }
    
    public void setearFinInscripcionEnMaquina(int idMaquina, double finInscripcion) {
        Maquina old = maquinas.get(idMaquina-1);
        old.setEstado(Maquina.Estado.OCUPADA);
        old.setFinInscripcion(finInscripcion);
        
        maquinas.set(idMaquina-1, old);
    }
    
    public void setearFinMantenimientoEnMaquina(Maquina m) {
        maquinas.set(m.getId()-1, m);
    }
    
    public void setearAcInscripcionEnMaquina(int idMaquina) {
        Maquina old = maquinas.get(idMaquina-1);
        old.agregarInscripto();
        
        maquinas.set(idMaquina-1, old);
    }
    
    public void acumularInscripcion() {
        acumuladoInscripciones ++;
    }
    
    public void disminuirColaAlumnos() {
        Alumno alumnoQueSigue = alumnosEnCola.get(0);
        alumnosEnCola.remove(0);
        colaAlumnos.setCantidad(colaAlumnos.getColaAlumnos() - 1);
        alumnoQueSigue.setEstado(Alumno.Estado.INSCRIBIENDOSE);
        alumnosInscribiendose.add(alumnoQueSigue);
    }
    
    public void agregarAlumnosEnInscripcion(Alumno a) {
        alumnosInscribiendose.add(a);
    }
    
}
