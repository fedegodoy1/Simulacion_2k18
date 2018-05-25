/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import objects.Alumno;
import objects.Encargado;
import eventos.*;
import objects.ColaAlumnos;
import objects.Maquina;


/**
 *
 * @author heftyn
 */
public interface VectorEstadoUI {
    
    double getReloj();
    
    Evento getEvento();
    
    LlegadaAlumno getLlegadaAlumno();
    
    InicioMantenimiento getInicioMantenimiento();
    
    FinMantenimiento getFinMantenimiento();
    
    ColaAlumnos getColaAlumnos();
    
    FinInscripcion getFinInscripcion();
    
    List<Maquina> getMaquinasList();
    
    int getAcumuladoInscripciones();
    
    int getAcumuladoAlumnosQueLlegan();
    
    int getAcumuladoAlumnosQueLleganYSeVan();
    
    Encargado getEncargado();
    
    List<Alumno> getAlumnos();
}
