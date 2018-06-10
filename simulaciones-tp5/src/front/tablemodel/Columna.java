/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.tablemodel;

/**
 *
 * @author heftyn
 */
public class Columna {
    private String name;
    private Class tipo;
    private int size;

    public Columna(String name, Class tipo, int size) {
        this.name = name;
        this.tipo = tipo;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getTipo() {
        return tipo;
    }

    public void setTipo(Class tipo) {
        this.tipo = tipo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
