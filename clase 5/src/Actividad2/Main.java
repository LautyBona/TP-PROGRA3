package Actividad2;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 0);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 3);
        grafo.mostrarMatriz();
    }
}