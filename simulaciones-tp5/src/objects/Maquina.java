package objects;

public class Maquina {
    
    private int id_maquina;
    private float ac_inscriptos;
    private Estado estado;
    private boolean fue_atendida;
    private double fin_inscripcion;
        
    public enum Estado{
        LIBRE,
        OCUPADA,
        SIENDO_MANTENIDA
    };

    public Maquina(int id_maquina, float ac_inscriptos, Estado estado, boolean fue_atendida, double fin_inscripcion) {
        this.id_maquina = id_maquina;
        this.ac_inscriptos = ac_inscriptos;
        this.estado = estado;
        this.fue_atendida = fue_atendida;
        this.fin_inscripcion = fin_inscripcion;
    }

    public int getId() {
        return id_maquina;
    }

    protected void setId(int id_maquina) {
        this.id_maquina = id_maquina;
    }

    public float getAcumuladoInscriptos() {
        return ac_inscriptos;
    }

    public void setAcumuladoInscriptos(float ac_inscriptos) {
        this.ac_inscriptos = ac_inscriptos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean fueAtendida() {
        return fue_atendida;
    }

    public void setFueAtendida(boolean fue_atendida) {
        this.fue_atendida = fue_atendida;
    }
    
    public double getFinInscripcion() {
        return fin_inscripcion;
    }
    
    public void setFinInscripcion(double fin_inscripcion) {
        this.fin_inscripcion = fin_inscripcion;
    }
}
