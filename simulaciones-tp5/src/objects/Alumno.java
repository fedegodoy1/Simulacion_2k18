package objects;

public class Alumno {
    
    private double hora_regreso_sistema;
    
    public enum Estado {
        ESPERANDO_MAQUINA,
        INSCRIBIENDOSE,
        ESPERANDO_PARA_REGRESAR
    };
    
    private Estado estado;

    public Alumno() {
        
    }
    
    public Alumno(float hora_regreso_sistema, Estado estado) {
        this.hora_regreso_sistema = hora_regreso_sistema;
        this.estado = estado;
    }

    public double getHora_regreso_sistema() {
        return hora_regreso_sistema;
    }

    public void setHora_regreso_sistema(double hora_regreso_sistema) {
        this.hora_regreso_sistema = hora_regreso_sistema;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
        
}
