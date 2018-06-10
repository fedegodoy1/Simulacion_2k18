/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.eventos.Evento;
import front.Estadisticas;
import front.VentanaPrincipal;
import front.tablemodel.SetearValores;
import java.util.*;
import model.Configuracion;
import model.VectorEstadoUI;
import objects.*;

/**
 *
 * @author heftyn
 */
public class ControladorSimulacion 
{
    VentanaPrincipal vistaAplicacion;
    Estadisticas estadisticas;
    
    private static VectorEstado actual;
    private static VectorEstado anterior;
    
    private List<VectorEstadoUI> modelo;
    
    ControladorSimulacion()
    {
        vistaAplicacion = new VentanaPrincipal(this);
        estadisticas = new Estadisticas();
        setLookAndFeel();
    }
    
    
    private void setLookAndFeel() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControladorSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControladorSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControladorSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControladorSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarVentanaPrincipal()
    {
        vistaAplicacion.setVisible(true);        
    }
    
    public Estadisticas mostrarEstadisticas() {
        return this.estadisticas;
    }

    public void simular() {
        /**
         * Ademas de simular aca vamos a actualizar la vista...
         * onda la SetarValores tiene que proveer un metodo para 
         * obtener el TableModel (VectorEstadoTableModel) asi 
         * nosotros le pasamos todos los datos y le informamos que cambio la data
         */
        int iteracionActual = 0;
        int iteracionesMostrando = 0;
        inicializar();
        double minutosASimular = new Double(Configuracion.getConfiguracion().getMinutosASimular());
        do
        {
            //Mover vector "actual" a "anterior"
            rotacionVector();
            Evento nuevoEvento = determinarProximoEvento();
            //Actualizar reloj a la hora de este evento.
            actual.setReloj(nuevoEvento.getHoraEvento());
            //Setear este evento dentro del vector actual y llamar al metodo polimorfico:
            actual.setEvento(nuevoEvento);
            actual.getEvento().actualizarEstadoVector();
            
            //Ademas de la validacion general, tmb se agrega cuando es la ultima fila
            if (seMuestra(iteracionesMostrando) || 
                    !(iteracionActual + 1 < 1000000 && actual.getReloj() < minutosASimular))
            {
                //Guardar en la lista a devolver
                guardarVectorParaVista();
                iteracionesMostrando++;
            }
            iteracionActual++;
            
        }while (iteracionActual < 1000000 && actual.getReloj() < minutosASimular);
        //Actualizar Vista
        vistaAplicacion.setearModelo(modelo);
        //Calculo de los estadisticos
        calculoEstadisticos();
        //Limpiamos el modelo
        modelo = new ArrayList<>();
    }
    
    public static VectorEstado getVectorActual()
    {
        return actual;
    }
    
    public static VectorEstado getVectorAnterior()
    {
        return anterior;
    }
    
    public Estadisticas getEstadisticas() {
        return estadisticas;
    }
    
    private void calculoEstadisticos() {
        estadisticas.setCapacidad_sistema((double)actual.getAcumuladoInscripciones() / (actual.getReloj() / 60 ));
        estadisticas.setCapacidad_maq1(actual.getMaquinasList().get(0).getAcumuladoInscriptos() / (actual.getReloj() / 60 ));
        estadisticas.setCapacidad_maq2(actual.getMaquinasList().get(1).getAcumuladoInscriptos() / (actual.getReloj() / 60 ));
        estadisticas.setCapacidad_maq3(actual.getMaquinasList().get(2).getAcumuladoInscriptos() / (actual.getReloj() / 60 ));
        estadisticas.setCapacidad_maq4(actual.getMaquinasList().get(3).getAcumuladoInscriptos() / (actual.getReloj() / 60 ));
        estadisticas.setCapacidad_maq5(actual.getMaquinasList().get(4).getAcumuladoInscriptos() / (actual.getReloj() / 60 ));
        double propQueSeVa = (double) actual.getAcumuladoAlumnosQueLleganYSeVan() / (double) actual.getAcumuladoAlumnosQueLlegan();
        estadisticas.setPorcentaje_alumnos_que_se_van(propQueSeVa * 100);
    }
    
    private void inicializar() 
    {
        actual = new VectorEstado();
        actual.setReloj(0);
        actual.setEvento(Evento.Inicial);
        actual.getEvento().actualizarEstadoVector();
        
        if (seMuestra(0))
        {
            //Guardar en la lista a devolver
            guardarVectorParaVista();
        }
        anterior = actual;
    }

    private Evento determinarProximoEvento() {
        //Aca lo que hacemos es obtener todas las horas que hay en el sistema que pueden generar el proximo evento
        //Elegir la menor, crear un objeto evento de ese, setearle la hora y devolverlo.
        HashMap<Double,Evento> mapaDeTiempos = new HashMap<>();
        
        if (anterior.getLlegadaAlumno() != null && 
                anterior.getLlegadaAlumno().getProx_llegada() > 0 && 
                anterior.getLlegadaAlumno().getProx_llegada() < Double.MAX_VALUE)
        {
            mapaDeTiempos.put(anterior.getLlegadaAlumno().getProx_llegada(), Evento.LlegadaAlumno);
        }
        if (anterior.getFinMantenimiento() != null &&
                anterior.getFinMantenimiento().getFinMantenimiento() > 0 &&
                anterior.getFinMantenimiento().getFinMantenimiento() < Double.MAX_VALUE)
        {
            mapaDeTiempos.put(anterior.getFinMantenimiento().getFinMantenimiento(), Evento.FinMantenimiento);
        }
        if (anterior.getInicioMantenimiento() != null &&
                anterior.getInicioMantenimiento().getProxInicioMantenimiento() > 0 &&
                anterior.getInicioMantenimiento().getProxInicioMantenimiento() < Double.MAX_VALUE)
        {
            mapaDeTiempos.put(anterior.getInicioMantenimiento().getProxInicioMantenimiento(), Evento.InicioMantenimiento);
        }
        if (anterior.getMaquinasList() != null && anterior.getMaquinasList().size() > 0)
        {
            for (Maquina maquina : anterior.getMaquinasList())
            {
                if (maquina.getFinInscripcion() > 0 && maquina.getFinInscripcion() < Double.MAX_VALUE)
                {
                    mapaDeTiempos.put(maquina.getFinInscripcion(), Evento.FinInscripcion);
                }
            }
        }
        if (anterior.getAlumnos() != null && anterior.getAlumnos().size() > 0)
        {
            for (Alumno alumno : anterior.getAlumnos())
            {
                if (alumno.getHora_regreso_sistema() > 0 &&
                        alumno.getHora_regreso_sistema() < Double.MAX_VALUE)
                {
                    mapaDeTiempos.put(alumno.getHora_regreso_sistema(), Evento.RegresoAlumno);
                }
            }
        }
        
        Set<Double> tiempos = mapaDeTiempos.keySet();
        Double tiempoSiguiente = Collections.min(tiempos);
        
        Evento returnValue = mapaDeTiempos.get(tiempoSiguiente);
        returnValue.setHoraEvento(tiempoSiguiente);
        
        return returnValue;
    }

    private boolean seMuestra(int iteracionActual) {
        //actual.getReloj() > Config &&
        // iteraciones < Config
        boolean seMuestra = false;
        if (actual != null)
        {
            seMuestra = actual.getReloj() >= Configuracion.getConfiguracion().getMinutoDesde();
            
        }
        if (seMuestra)
        {
            seMuestra = seMuestra && iteracionActual <= Configuracion.getConfiguracion().getIteracionesAMostrar();
        }
        return seMuestra;
    }

    private void rotacionVector() {
        anterior = actual;
        actual = new VectorEstado();
    }

    private void guardarVectorParaVista() {
        if (modelo == null)
        {
            modelo = new ArrayList<>();
        }
        
        modelo.add(actual);
        
    }
}
