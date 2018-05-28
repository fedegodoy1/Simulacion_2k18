package eventos;

public class LlegadaAlumno {
    
    private double rnd;
    private double tiempo_entre_llegadas;
    private double prox_llegada;

    public LlegadaAlumno() {
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
    
       
    public LlegadaAlumno getLlegadaAlumno() {
        return this;
    }
}
