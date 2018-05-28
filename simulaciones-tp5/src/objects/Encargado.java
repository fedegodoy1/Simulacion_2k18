package objects;

public class Encargado {
  
    private Estado estado;
    
    public enum Estado{
        REPARANDO_MAQUINA,
        ESPERANDO_MAQUINA_LIBRE,
        ESPERANDO_PROX_RONDA_MANTENIMIENTO
    };

    public Encargado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }    
    
}
