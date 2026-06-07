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
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

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
    
    public String rutaDijkstra(String idOrigen, String idDestino, String idNeuro){
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
                return "ZONA AISLADA: No hay ruta posible hacia la neurona " + idDestino;
            }
            String resultado = "Tiempo total de transmisión: " + distancias[indiceDestino] + "\n";
            
            
          String ruta = "";
          int actual = indiceDestino;
          
          while(actual != -1){
              if(ruta.equals("")) {
            ruta = grafo.getNeuronas()[actual].getId();
        }     
              else {
            ruta = grafo.getNeuronas()[actual].getId() + " -> " + ruta;
        }
        actual = previos[actual];
          }
           resultado += "Ruta óptima: " + ruta;
    return resultado;
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
    
    public String BFS(String idOrigen){
        int n = grafo.getCantidad();
        boolean[] visitados = new boolean[n];
        int[] cola = new int[n];
        int frente = 0;
        int fin = 0;
        int indiceOrigen = obtenerIndice(idOrigen);
        visitados[indiceOrigen] = true;
        String reporte = "Propagación inicia en: " + idOrigen + "\nAlcance de la señal: ";
        cola[fin] = indiceOrigen;
        fin++;
        while(frente < fin){
            int u = cola[frente];
            frente++;
            Neurona actual = grafo.getNeuronas()[u];
            ListaSinapsis conexiones = actual.getConexiones();
            for(int j=0;j<conexiones.getTamaño();j++){
                Sinapsis enlace = conexiones.obtener(j);
                int v = obtenerIndice(enlace.getDestino().getId());
                if(visitados[v] == false){
                    visitados[v] = true;
                    reporte += enlace.getDestino().getId() + "  ";
                    cola[fin] = v;
                    fin++;
                }
            }
        }
        return reporte;
    }
    
    public String simularFatiga() {
    int n = grafo.getCantidad();
    for (int i = 0; i < n; i++) {
        Neurona actual = grafo.getNeuronas()[i];
        ListaSinapsis conexiones = actual.getConexiones();
        for (int j = 0; j < conexiones.getTamaño(); j++) {
            Sinapsis enlace = conexiones.obtener(j);
            double nuevoK = enlace.getCoeficiente() * 1.2;
            enlace.setCoeficiente(nuevoK); 
        }
    }
    return "no Todos los coeficientes sinápticos han aumentado un 20%.";
}
    public void graficarRed() {
        System.setProperty("org.graphstream.ui", "swing");
         Graph lienzo = new SingleGraph("Cerebro Artificial");

        String estilos = 
            "node {" +
            "   fill-color: #2ecc71;" + 
            "   size: 30px;" +
            "   text-alignment: center;" +
            "   text-color: white;" +
            "   text-style: bold;" +
            "   text-size: 13px;" +
            "   stroke-mode: plain;" +
            "   stroke-color: #27ae60;" +
            "   stroke-width: 2px;" +
            "}" +
            "edge {" +
            "   fill-color: #bdc3c7;" + 
            "   width: 2px;" +
            "   arrow-size: 10px, 5px;" + 
            "   text-size: 11px;" +
            "   text-color: #e67e22;" +
            "}";
        lienzo.setAttribute("ui.stylesheet", estilos);

        int total = this.grafo.getCantidad();
        Neurona[] lista = this.grafo.getNeuronas();

        for (int i = 0; i < total; i++) {
            String idNeurona = lista[i].getId();
            if (lienzo.getNode(idNeurona) == null) {
                lienzo.addNode(idNeurona);
                lienzo.getNode(idNeurona).setAttribute("ui.label", idNeurona); // Texto adentro del nodo
            }
        }
        for (int i = 0; i < total; i++) {
            Neurona origen = lista[i];
            ListaSinapsis conexiones = origen.getConexiones();
            for (int j = 0; j < conexiones.getTamaño(); j++) {
                Sinapsis enlace = conexiones.obtener(j);
                String idOrigen = origen.getId();
                String idDestino = enlace.getDestino().getId();
                String idArista = idOrigen + "->" + idDestino;
                if (lienzo.getEdge(idArista) == null) {
                    lienzo.addEdge(idArista, idOrigen, idDestino, true);
                    lienzo.getEdge(idArista).setAttribute("ui.label", "d: " + enlace.getDistancia());
                }
            }
        }
        lienzo.display();
    }
}
