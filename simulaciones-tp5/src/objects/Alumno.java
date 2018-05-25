package objects;

public class Alumno {
    
    private float hora_regreso_sistema;
    
    public enum estado {
        ESPERANDO_MAQUINA,
        INSCRIBIENDOSE,
        ESPERANDO_PARA_REGRESAR
    };
    
    private String estado;

    public Alumno(float hora_regreso_sistema, String estado) {
        this.hora_regreso_sistema = hora_regreso_sistema;
        this.estado = estado;
    }

    public float getHora_regreso_sistema() {
        return hora_regreso_sistema;
    }

    public void setHora_regreso_sistema(float hora_regreso_sistema) {
        this.hora_regreso_sistema = hora_regreso_sistema;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
}
