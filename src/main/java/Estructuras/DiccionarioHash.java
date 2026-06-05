/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

       
/**
 *
 * @author snogu
 */
public class DiccionarioHash {
    private NodoHash[]tabla;
    private int tamaño;

    public DiccionarioHash(int tamaño) {
       this.tamaño = tamaño;
       this.tabla = new NodoHash[tamaño];
       
       
    }
    private int funcion(String id){
        int suma = 0;
        for(int i=0; i<id.length();i++){
            suma= suma + id.charAt(i);
        }
        return suma % tamaño;
    }
    
    public void insertar(Neurotransmisor neuro){ 
    String id = neuro.getId();
    int posicion = funcion(id);
    NodoHash nuevoNodo = new NodoHash(id,neuro,null);
    if(tabla[posicion] == null ){
        tabla[posicion] = nuevoNodo;
    }
    else{
        NodoHash actual = tabla[posicion];
        while(actual.getSiguiente() !=null){
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevoNodo);
    }
   
}
    
    public Neurotransmisor buscar(String id){
        int posicion = funcion(id);
        NodoHash actual = tabla[posicion];
        while(actual !=null){
            if(actual.getId().equals(id)){
                return actual.getValor();
            }
            else{
                actual = actual.getSiguiente();
            }
        }
        return null;
    }
}
