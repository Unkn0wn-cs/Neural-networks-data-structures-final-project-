/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author snogu
 */
public class Sinapsis {
    private Neurona origen;
    private Neurona destino;
    private double distancia;
    private double coeficiente;

    public Sinapsis(Neurona origen, Neurona destino, double distancia, double coeficiente) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.coeficiente = coeficiente;
        
    }

    public Neurona getOrigen() {
        return origen;
    }

    public void setOrigen(Neurona origen) {
        this.origen = origen;
    }

    public Neurona getDestino() {
        return destino;
    }

    public void setDestino(Neurona destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }
    
}
