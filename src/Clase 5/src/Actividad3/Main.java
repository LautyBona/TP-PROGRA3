package Actividad3;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5); // Crear un grafo con 5 estaciones

        // Agregar aristas con costo entre estaciones
        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 6);
        grafo.agregarArista(0, 3, 5);
        grafo.agregarArista(1, 3, 15);
        grafo.agregarArista(2, 3, 4);

        // Aplicar el algoritmo de Prim
        grafo.prim();
    }
}