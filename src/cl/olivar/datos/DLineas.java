/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.olivar.datos;

/**
 *
 * @author DANIEL
 */
public class DLineas {
    
    private String Lineas;
    private int IdLineas;

    public String getLineas() {
        return Lineas;
    }

    public void setLineas(String Lineas) {
        this.Lineas = Lineas;
    }

    public DLineas() {
    }

    public DLineas(String Lineas, int IdLineas) {
        this.Lineas = Lineas;
        this.IdLineas = IdLineas;
    }

    public int getIdLineas() {
        return IdLineas;
    }

    public void setIdLineas(int IdLineas) {
        this.IdLineas = IdLineas;
    }
    
    
}
