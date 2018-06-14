
package objects;

import control.VectorEstado;
import eventos.FinMantenimiento;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Configuracion;


public class Distribuciones {
    
    public static double calcular_uniforme(double a, double b, double rnd) {
        return a + (rnd* (b-a));
    }
             
    
    public static void calcularEuler(VectorEstado actual, FinMantenimiento finMantenimiento)
    {
       finMantenimiento.setRnd(new Random().nextDouble());
       List<CantidadDeArchivos> archivos = Configuracion.getConfiguracion().getCantidadArchivos();
       for (int i = 0; i < archivos.size(); i++)
       {
           if (archivos.get(i).esRNDMenorAProbabilidadAcumulada(finMantenimiento.getRnd()))
           {
               finMantenimiento.setCantidadDeArchivos(archivos.get(i).getCantidad());
               break;
           }
       }
       double Ao = finMantenimiento.getCantidadDeArchivos();
       List<Euler> listaEuler = new ArrayList<>();
       //Agrego el primer Euler:
       Euler eulerActual = new Euler();
       eulerActual.setTiempoActual(0);
       eulerActual.set_A_CantidadArchivosRestantesActuales(0);
       eulerActual.setTiempoSiguiente(0);
       eulerActual.set_A_sigiente(Ao);
       eulerActual.setDerivada(0);
       
       listaEuler.add(eulerActual);
       Euler eulerAnterior = eulerActual;
       
       do
       {
           eulerActual = new Euler();
           eulerActual.setTiempoActual(eulerAnterior.getTiempoSiguiente());
           eulerActual.set_A_CantidadArchivosRestantesActuales(eulerAnterior.get_A_sigiente());
           derivarEuler(eulerActual, Ao);
           listaEuler.add(eulerActual);
           eulerAnterior = eulerActual;
       }while (eulerActual.get_A_CantidadArchivosRestantesActuales() >= 0);
       finMantenimiento.setTMatenimiento(eulerActual.getTiempoActual());
       actual.setEuler(listaEuler);
    }
    
    private static void derivarEuler(Euler euler, double Ao)
    {
        //-68-(pow(A)/Ao)
        double A = euler.get_A_CantidadArchivosRestantesActuales();
        euler.setDerivada((double) (-68-(Math.pow(A, 2)/Ao)));
        // t + h
        euler.setTiempoSiguiente(euler.getTiempoActual() + Configuracion.getConfiguracion().getPasoEuler());
        // A(t+1) = A + h * (dA/dt)
        // y(t+1) = y + h * y'
        euler.set_A_sigiente(A + (Configuracion.getConfiguracion().getPasoEuler() * euler.getDerivada()));
        
    }
    
    public static double calcular_exponencial(double media, double rnd) {
        return (media*-1) * Math.log(1-rnd);
    }
   
}
