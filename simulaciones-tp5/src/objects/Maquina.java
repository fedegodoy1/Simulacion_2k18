package objects;

public class Maquina {
    
    private int id_maquina;
    private float ac_inscriptos;
    private String estado;
    private boolean fue_atendida;
        
    public enum estado{
        LIBRE,
        OCUPADA,
        SIENDO_MANTENIDA
    };

    public Maquina(int id_maquina, float ac_inscriptos, String estado, boolean fue_atendida) {
        this.id_maquina = id_maquina;
        this.ac_inscriptos = ac_inscriptos;
        this.estado = estado;
        this.fue_atendida = fue_atendida;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean fueAtendida() {
        return fue_atendida;
    }

    public void setFueAtendida(boolean fue_atendida) {
        this.fue_atendida = fue_atendida;
    }
    
}
