/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author snogu
 */
public class ListaSinapsis {
    private NodoSinapsis cabeza;
    private int tamaño;
    
    public ListaSinapsis(){
        this.cabeza = null;
        this.tamaño = 0;           
    }
    public void agregar(Sinapsis nuevaSinapsis) {
        NodoSinapsis nuevoNodo = new NodoSinapsis(nuevaSinapsis);
        
        if (this.cabeza == null) {
            this.cabeza = nuevoNodo;
        } else {
            NodoSinapsis actual = this.cabeza;
            
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            
            actual.setSiguiente(nuevoNodo);
        }
        
        this.tamaño++;
    }
    public Sinapsis obtener(int indice){
        if(indice < 0 || indice >= tamaño){
            return null;
        }
        NodoSinapsis actual = cabeza;
        for(int i=0; i<indice; i++){
            actual =actual.getSiguiente();
        }
        return actual.getDato();
    }
    public NodoSinapsis getCabeza(){
        return cabeza; 
    }
    public int getTamaño(){
        return tamaño;
    }
}
