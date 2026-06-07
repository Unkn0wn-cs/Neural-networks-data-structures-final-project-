Proyecto: Red Sináptica (Estructuras de Datos)
=============================================

https://github.com/Unkn0wn-cs/Neural-networks-data-structures-final-project-/blob/main/README.md

Resumen
------
Este proyecto implementa una red sináptica como grafo dirigido en Java, con interfaz gráfica (Swing + GraphStream). Cumple los requerimientos académicos: carga desde CSV, diccionario de neurotransmisores en tabla hash propia, BFS/DFS para detectar zonas aisladas, Dijkstra para la "ruta de mayor activación" (peso W = d / (v * k)), simulación de fatiga (multiplica k por 1.2), y operaciones para agregar/eliminar neuronas y sinapsis.

Estructura del código
---------------------
- src\estructuras\GrafoNeuronal.java
  - Representa el grafo dirigido usando ListaEnlazada de Neurona.
  - Operaciones: conectarNeuronas, eliminarNeurona, eliminarSinapsis, calcularRutaMasRapida (Dijkstra), simularDeterioroPorFatiga, guardarGrafoEnCSV.

- src\modelos\Neurona.java
  - Nodo con id y ListaEnlazada<Sinapsis> sinapsisSalientes.

- src\modelos\Sinapsis.java
  - Arista dirigida con distancia, idNeurotransmisor y coeficiente de eficiencia k.

- src\modelos\Neurotransmisor.java
  - Datos del neurotransmisor (id, nombre, efecto, velocidad, descripcion).

- src\estructuras\TablaHash.java
  - Implementación propia de tabla hash con buckets (ListaEnlazada) para almacenar Neurotransmisor. Métodos: put, get, remove, getAll.

- src\estructuras\ListaEnlazada.java
  - Implementación simple de lista enlazada (agregar, obtener, eliminar, getTamano) usada por la solución (evita java.util por consigna).

- src\control\AnalizadorAlgoritmico.java
  - Algoritmos: DFS, BFS, Dijkstra, detección de componentes, simulación de fatiga. Usa las estructuras del proyecto.

- src\control\GestorArchivo.java
  - Lógica para cargar CSV (diccionario y red). Usa JFileChooser. Formato CSV esperado:
    - Red: origen,destino,distancia,ID_Neurotransmisor,coeficiente_eficiencia
    - Diccionario: id,nombre,efecto,velocidad,descripcion

- src\vista\MonitorVisual.java
  - Encapsula GraphStream: crea grafo, aplica stylesheet y resalta nodos/edges (aislados, rutas).

- src\VentanaPrincipal.java
  - Interfaz Swing: botones para cargar red/diccionario, agregar/eliminar, buscar, ejecutar BFS/DFS, calcular ruta (Dijkstra), simular fatiga y guardar CSV. Integra GraphStream para visualización y resaltado de nodos y aristas.

Principales decisiones de diseño
--------------------------------
- Grafo dirigido implementado con lista de adyacencia (ListaEnlazada) para cumplir requisito técnico sin usar colecciones externas.
- Diccionario implementado con TablaHash propia para O(1) promedio en búsqueda de neurotransmisores.
- Pesos dinámicos: para cada Sinapsis, el peso W usado en Dijkstra se calcula en tiempo de visualización o cálculo: W = distancia / (velocidadNeurotransmisor * k).
- Simulación de fatiga: multiplica k por 1.2 en todas las sinapsis.
- Visualización: GraphStream (gs-core, gs-ui-swing, gs-algo) en libs a instalar. Estilos y clases UI permiten resaltar BFS/DFS/Dijkstra/search/isolated.

Cómo ejecutar
-------------
1. Abrir el proyecto en NetBeans.
2. Asegurarse de que los JARs de GraphStream estén en la carpeta "libs a instalar" y añadidos al classpath del proyecto.
3. Clean & Build desde NetBeans y Run.
4. Alternativamente, desde consola con JDK instalado:
   - Generar lista de fuentes: dir /s /b *.java > sources.txt
   - Compilar: javac -cp "libs a instalar/*" -d build\\classes @sources.txt
   - Ejecutar: java -cp "build\\classes;libs a instalar/*" VentanaPrincipal

Archivos de interés
-------------------
- docs\class_diagram.puml  -> PlantUML del diagrama de clases
- docs\generate_javadoc.bat
- docs\generate_diagram.bat
- src\ (código fuente Java)