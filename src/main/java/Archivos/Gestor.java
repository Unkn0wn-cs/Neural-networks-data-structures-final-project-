/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;
import Estructuras.DiccionarioHash;
import Estructuras.Neurona;
import Estructuras.Neurotransmisor;
import Estructuras.RedNeuronal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 *
 * @author snogu
 */
public class Gestor {
    public String cargarDiccionario(File archivo, DiccionarioHash diccionario) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            
            lector.readLine();
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",", 5);
                if (partes.length >= 5) {
                    String id = partes[0].trim();
                    String nombre = partes[1].trim();
                    String efecto = partes[2].trim();
                    double velocidad = Double.parseDouble(partes[3].trim());
                    String descripcion = partes[4].trim().replace("\"", "");
                    Neurotransmisor nuevoNeuro = new Neurotransmisor(id, nombre, efecto, velocidad, descripcion);
                    diccionario.insertar(nuevoNeuro);
} 
            }
            
            lector.close();
            return "¡Diccionario cargado exitosamente!";
            
        } catch (Exception e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
    }
    
    
    public String cargarRed(File archivo, RedNeuronal grafo) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            lector.readLine();            
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    String origen = partes[0].trim();
                    String destino = partes[1].trim();
                    double distancia = Double.parseDouble(partes[2].trim());
                    String idNeuro = partes[3].trim();
                    double coeficiente = Double.parseDouble(partes[4].trim());
                    if (grafo.buscarNeurona(origen) == null) {
                        Neurona nuevaOrigen = new Neurona(origen);
                        grafo.agregarNeurona(nuevaOrigen);
                    }
                    if (grafo.buscarNeurona(destino) == null) {
                        Neurona nuevaDestino = new Neurona(destino);
                        grafo.agregarNeurona(nuevaDestino);
                    }
                    grafo.conectar(origen, destino, distancia, idNeuro, coeficiente);
                }
            }
            lector.close();
            return "¡Red Neuronal cargada exitosamente!";            
        } catch (Exception e) {
            return "Error al leer el archivo de red: " + e.getMessage();
        }
    }
}
