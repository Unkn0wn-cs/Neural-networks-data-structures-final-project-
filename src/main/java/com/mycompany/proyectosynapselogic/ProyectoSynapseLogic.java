/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectosynapselogic;

import Estructuras.Neurona;
import Estructuras.RedNeuronal;

/**
 *
 * @author snogu
 */
public class ProyectoSynapseLogic {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        RedNeuronal miRed = new RedNeuronal(10);

Neurona n1 = new Neurona("A", 1.0);
Neurona n2 = new Neurona("B", 1.0);
Neurona n3 = new Neurona("C", 1.0);

miRed.agregarNeurona(n1);
miRed.agregarNeurona(n2);
miRed.agregarNeurona(n3);

miRed.conectar("A", "B", 5.5, 1.2);
miRed.conectar("A", "C", 3.0, 0.8);

miRed.mostrarRed();
    }
    
}
