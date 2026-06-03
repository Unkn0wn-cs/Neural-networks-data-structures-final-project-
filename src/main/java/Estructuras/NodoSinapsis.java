/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author snogu
 */
public class NodoSinapsis {
    private Sinapsis dato;
    private NodoSinapsis siguiente;

    public NodoSinapsis(Sinapsis dato) {
        this.dato = dato;
    }

    public Sinapsis getDato() {
        return dato;
    }

    public void setDato(Sinapsis dato) {
        this.dato = dato;
    }

    public NodoSinapsis getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSinapsis siguiente) {
        this.siguiente = siguiente;
    }
    
}
