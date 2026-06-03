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
    public void agregarNeurona(Neurona nuevaNeurona){
        if(cantidad == this.neuronas.length){
            System.out.println("No se puede agregar");
            return;
    }
        this.neuronas[cantidad]=nuevaNeurona;
        this.cantidad++;
        
    }
    public Neurona buscarNeurona(String id){
       for(int i=0; i<cantidad; i++){ 
           if (this.neuronas[i].getId().equals(id)){
               return this.neuronas[i];
            }
    
        }
      return null;
    }
    
    public void conectar(String idOrigen, String idDestino,double distancia,double coeficiente){
        Neurona origen = buscarNeurona(idOrigen);
        Neurona destino = buscarNeurona(idDestino);
        if(origen==null||destino==null){
            System.out.println("Alguna de las dos neuronas no existe");
            return;
        }
        Sinapsis nuevaSinapsis = new Sinapsis(origen,destino,distancia,coeficiente);
        origen.agregarSinapsis(nuevaSinapsis);
    }
   public void mostrarRed() {
    System.out.println("--- ESTADO DE LA RED NEURONAL ---");
    
    // Recorremos todas las neuronas
    for (int i = 0; i < cantidad; i++) {
        Neurona actual = this.neuronas[i];
        System.out.print("Neurona: " + actual.getId());
        
        // Obtenemos su lista de conexiones
        ListaSinapsis susConexiones = actual.getConexiones();
        
        // Si tiene conexiones, las recorremos
        if (susConexiones.getTamaño() > 0) {
            System.out.println("  --> Conectada con:");
            for (int j = 0; j < susConexiones.getTamaño(); j++) {
                Sinapsis enlace = susConexiones.obtener(j);
                
                // Imprimimos el destino, distancia y coeficiente
                // (Asumiendo que tu clase Sinapsis tiene estos métodos get)
                System.out.println("      - " + enlace.getDestino().getId() + 
                                   " (Distancia: " + enlace.getDistancia() + 
                                   ", Coef: " + enlace.getCoeficiente() + ")");
            }
        } else {
            System.out.println("  --> (Sin conexiones)");
        }
    }
    System.out.println("---------------------------------");
}
}