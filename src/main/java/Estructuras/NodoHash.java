/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author snogu
 */
public class NodoHash {
    private String id;
    private Neurotransmisor valor;
    private NodoHash siguiente;

    public NodoHash(String id, Neurotransmisor valor, NodoHash siguiente) {
        this.id = id;
        this.valor = valor;
        this.siguiente = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Neurotransmisor getValor() {
        return valor;
    }

    public void setValor(Neurotransmisor valor) {
        this.valor = valor;
    }

    public NodoHash getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }
    
}
