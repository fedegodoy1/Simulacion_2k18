package eventos;

public class FinInscripcion {
    
    private double rnd;
    private double tInscripcion;

    public FinInscripcion() {
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
    
    public FinInscripcion getFinInscripcion() {
        return this;
    }
}
