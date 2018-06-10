
package objects;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.log;
import static java.lang.Math.sqrt;


public class Distribuciones {
    public static final String COS = "Coseno";
    public static final String SENO = "Seno";
    
    public static double calcular_uniforme(double a, double b, double rnd) {
        return a + (rnd* (b-a));
    }
             
    public static double calcular_normal(double media, double desviacion, double rnd1, double rnd2, String cosOSin) {
        
        double raiz = sqrt((-2)* log(rnd1));
        
        double segundo_miembro = -1;
        
        if(COS.equals(cosOSin))
        {
            segundo_miembro = cos(2*PI*rnd2);
        }
        else if (SENO.equals(cosOSin))
        {
            segundo_miembro = sin(2*PI*rnd2);
        }
        else
        {
            throw new NullPointerException ("No se pasó si seno o coseno");
        }
        
        return ((raiz * segundo_miembro) * desviacion + media);
        
    }
    
    public static double calcular_exponencial(double media, double rnd) {
        return (media*-1) * Math.log(1-rnd);
    }
   
}
