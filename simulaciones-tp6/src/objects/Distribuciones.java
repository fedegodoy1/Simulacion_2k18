
package objects;

import control.VectorEstado;
import eventos.FinMantenimiento;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.log;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
import model.Configuracion;


public class Distribuciones {
    public static final String COS = "Coseno";
    public static final String SENO = "Seno";
    
    public static double calcular_uniforme(double a, double b, double rnd) {
        return a + (rnd* (b-a));
    }
             
    
    public static void calcularEuler(VectorEstado actual, FinMantenimiento finMantenimiento)
    {
       List<Euler> listaEuler = new ArrayList<>();
       //Agrego el primer Euler:
       Euler eulerActual = new Euler();
       eulerActual.setTiempoActual(0);
       eulerActual.set_A_CantidadArchivosRestantesActuales(0);
       eulerActual.setTiempoSiguiente(0);
       eulerActual.set_A_sigiente(Configuracion.getConfiguracion().getCantidadArchivos());
       eulerActual.setDerivada(0);
       
       listaEuler.add(eulerActual);
       Euler eulerAnterior = eulerActual;
       
       do
       {
           eulerActual = new Euler();
           eulerActual.setTiempoActual(eulerAnterior.getTiempoSiguiente());
           eulerActual.set_A_CantidadArchivosRestantesActuales(eulerAnterior.get_A_sigiente());
           derivarEuler(eulerActual);
           listaEuler.add(eulerActual);
           eulerAnterior = eulerActual;
       }while (eulerActual.get_A_CantidadArchivosRestantesActuales() >= 0);
       finMantenimiento.setTMatenimiento(eulerActual.getTiempoActual());
       actual.setEuler(listaEuler);
    }
    
    private static void derivarEuler(Euler euler)
    {
        //-68-(pow(A)/Ao)
        double A = euler.get_A_CantidadArchivosRestantesActuales();
        euler.setDerivada((double) (-68-(Math.pow(A, 2)/Configuracion.getConfiguracion().getCantidadArchivos())));
        // t + h
        euler.setTiempoSiguiente(euler.getTiempoActual() + Configuracion.getConfiguracion().getPasoEuler());
        // A(t+1) = A + h * (dA/dt)
        euler.set_A_sigiente(A + (Configuracion.getConfiguracion().getPasoEuler() * euler.getDerivada()));
        
    }
    
    public static double calcular_exponencial(double media, double rnd) {
        return (media*-1) * Math.log(1-rnd);
    }
   
}
