/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author snogu
 */
public class RedNeuronal {
    private Neurona[] neuronas;
    private int cantidad;
    
    public RedNeuronal(int capacidad){
        this.neuronas = new Neurona[capacidad];
        this.cantidad = 0;
    }
    public void AgregarNeurona(Neurona nuevaNeurona){
        if(cantidad == this.neuronas.length){
            System.out.println("No se puede agregar");
            return;
    }
        this.neuronas[cantidad]=nuevaNeurona;
        this.cantidad++;
        
    }
}
