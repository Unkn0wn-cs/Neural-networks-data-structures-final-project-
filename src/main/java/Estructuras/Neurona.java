/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author snogu
 */
public class Neurona {
    private String id;
    private double potencial;
    private ListaSinapsis conexiones;

    public Neurona(String id, double potencial) {
        this.id = id;
        this.potencial = potencial;
        this.conexiones = new ListaSinapsis();
    }
    
    public void agregarSinapsis(Sinapsis nuevaSinapsis){
        this.conexiones.agregar(nuevaSinapsis);
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPotencial() {
        return potencial;
    }

    public void setPotencial(double potencial) {
        this.potencial = potencial;
    }
    public ListaSinapsis getConexiones() {
    return conexiones;
}
}
