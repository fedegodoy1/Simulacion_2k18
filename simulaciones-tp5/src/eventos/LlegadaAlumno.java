package eventos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LlegadaAlumno {
    
    private double rnd;
    private double tiempo_entre_llegadas;
    private double prox_llegada;

    public LlegadaAlumno() {
        rnd = tiempo_entre_llegadas = prox_llegada = Double.MAX_VALUE;
    }

    public LlegadaAlumno(double rnd, double tiempo_entre_llegadas, double prox_llegada) {
        this.rnd = rnd;
        this.tiempo_entre_llegadas = tiempo_entre_llegadas;
        this.prox_llegada = prox_llegada;
    }

    public double getRnd() {
        return rnd;
    }

    public void setRnd(double rnd) {
        this.rnd = rnd;
    }

    public double getTiempo_entre_llegadas() {
        return tiempo_entre_llegadas;
    }

    public void setTiempo_entre_llegadas(double tiempo_entre_llegadas) {
        this.tiempo_entre_llegadas = tiempo_entre_llegadas;
    }

    public double getProx_llegada() {
        return prox_llegada;
    }

    public void setProx_llegada(double prox_llegada) {
        this.prox_llegada = prox_llegada;
    }
    
    @Override
    public LlegadaAlumno clone() {
        try {
            LlegadaAlumno clon = (LlegadaAlumno) super.clone();
            clon.prox_llegada= this.prox_llegada;
            clon.rnd = Double.MAX_VALUE; //En la UI este valor no deberia mostrarse
            clon.tiempo_entre_llegadas = Double.MAX_VALUE; //Same as above

            return clon;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(LlegadaAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new LlegadaAlumno();
    }
}
