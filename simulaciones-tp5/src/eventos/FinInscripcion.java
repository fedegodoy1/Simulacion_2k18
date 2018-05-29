package eventos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FinInscripcion {
    
    private double rnd;
    private double tInscripcion;

    public FinInscripcion() {
        rnd = tInscripcion = Double.MAX_VALUE;
    }

    public FinInscripcion(double rnd, double tInscripcion) {
        this.rnd = rnd;
        this.tInscripcion = tInscripcion;
    }

    public double getRnd() {
        return rnd;
    }

    public void setRnd(double rnd) {
        this.rnd = rnd;
    }

    public double gettInscripcion() {
        return tInscripcion;
    }

    public void settInscripcion(double tInscripcion) {
        this.tInscripcion = tInscripcion;
    }
    
    @Override
    public FinInscripcion clone()
    {
        try {
            FinInscripcion clon = (FinInscripcion) super.clone();
            clon.rnd = Double.MAX_VALUE;
            clon.tInscripcion = Double.MAX_VALUE;
            return clon;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(FinInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new FinInscripcion();
    }
}
