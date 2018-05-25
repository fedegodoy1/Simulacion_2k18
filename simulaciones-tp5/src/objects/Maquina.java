package objects;

public class Maquina {
    
    private float ac_inscriptos;
    private String estado;
    private boolean fue_atendida;
        
    public enum estado{
        LIBRE,
        OCUPADA,
        SIENDO_MANTENIDA
    };

    public Maquina(float ac_inscriptos, String estado, boolean fue_atendida) {
        this.ac_inscriptos = ac_inscriptos;
        this.estado = estado;
        this.fue_atendida = fue_atendida;
    }

    public float getAc_inscriptos() {
        return ac_inscriptos;
    }

    public void setAc_inscriptos(float ac_inscriptos) {
        this.ac_inscriptos = ac_inscriptos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isFue_atendida() {
        return fue_atendida;
    }

    public void setFue_atendida(boolean fue_atendida) {
        this.fue_atendida = fue_atendida;
    }
    
}
