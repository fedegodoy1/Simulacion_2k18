package objects;

public class Encargado {
  
    private String estado;
    
    public enum estado{
        REPARANDO_MAQUINA,
        ESPERANDO_MAQUINA_LIBRE,
        ESPERANDO_PROX_RONDA_MANTENIMIENTO
    };

    public Encargado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }    
    
}
