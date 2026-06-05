/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Estructuras.DiccionarioHash;
import Estructuras.ListaSinapsis;
import Estructuras.Neurona;
import Estructuras.Neurotransmisor;
import Estructuras.RedNeuronal;
import Estructuras.Sinapsis;

/**
 *
 * @author snogu
 */
public class Analizador {
    private RedNeuronal grafo;
    private DiccionarioHash velocidad;

    public Analizador(RedNeuronal grafo, DiccionarioHash velocidad) {
        this.grafo = grafo;
        this.velocidad = velocidad;
    }
    
    public double calcularPeso(Sinapsis enlace, String idNeuro){
    Neurotransmisor neuroActual = velocidad.buscar(idNeuro);
    if(neuroActual== null){
        return Double.MAX_VALUE;
    }
    else{
        double d = enlace.getDistancia();
        double k = enlace.getCoeficiente();
        double v = neuroActual.getVelocidad();
        return d / (v * k);
        }
    
    }
    
    public void rutaDijkstra(String idOrigen, String idDestino, String idNeuro){
        int n = grafo.getCantidad();
        double[] distancias = new double[n];
        int[] previos = new int[n];
        boolean[] visitados = new boolean[n];
        for(int i=0;i<n;i++){
        distancias[i]= Double.MAX_VALUE;
        previos[i]= -1;
        }
        int indiceOrigen = obtenerIndice(idOrigen);
        distancias[indiceOrigen] = 0;
        
        for(int i=0;i<n;i++){
            int u = Minimo(distancias, visitados, n);
            if(u == -1 || distancias[u] == Double.MAX_VALUE)
                break;
            
            visitados[u] = true;
            Neurona actual = grafo.getNeuronas()[u];
            ListaSinapsis conexiones = actual.getConexiones();
            
            for(int j=0;j<conexiones.getTamaño();j++){
               Sinapsis enlace = conexiones.obtener(j); 
               int v = obtenerIndice(enlace.getDestino().getId());
               double peso = calcularPeso(enlace, idNeuro);
               
               if(visitados[v] == false && distancias[u]+peso<distancias[v]){
                   distancias[v] = distancias[u] + peso;
                   previos[v] = u;
               }
}
}
        
            
            int indiceDestino = obtenerIndice(idDestino);
            
            if(distancias[indiceDestino] == Double.MAX_VALUE){
                System.out.println("No hay ruta posible.");
                return;
            }
            else{
                System.out.println("El tiempo total es: " + distancias[indiceDestino]);
            }
            
            
          String ruta = "";
          int actual = indiceDestino;
          
          while(actual != -1){
              ruta = grafo.getNeuronas()[actual].getId() + " <- " + ruta;
              actual = previos[actual];
          }
           System.out.println("Ruta: " + ruta); 
        }
    
    
    
    private int obtenerIndice(String id){
       for(int i=0; i<grafo.getCantidad(); i++){ 
           if (grafo.getNeuronas()[i].getId().equals(id)){
               return i;
            }
    
        }
      return -1;
    }
    
    private int Minimo(double[] distancias, boolean[] visitados, int n){
        double minimo = Double.MAX_VALUE;
        int indiceMinimo = -1;
        
        for(int i=0;i<n;i++){
            if(visitados[i] == false && distancias[i] <= minimo){
                minimo = distancias[i];
                indiceMinimo = i;
                
            
            }
        }
        return indiceMinimo;
            
    
    }
}
