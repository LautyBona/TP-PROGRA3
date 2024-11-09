package Clase12;

import java.util.List;

class Main {
    public static void main(String[] args) {
        GrafoVuelos grafo = new GrafoVuelos();

        // Crear nodos de destinos
        NodoDestino A = new NodoDestino("A");
        NodoDestino B = new NodoDestino("B");
        NodoDestino C = new NodoDestino("C");
        NodoDestino D = new NodoDestino("D");

        // Agregar destinos al grafo
        grafo.agregarDestino(A);
        grafo.agregarDestino(B);
        grafo.agregarDestino(C);
        grafo.agregarDestino(D);

        // Agregar vuelos (aristas) con precios
        grafo.agregarVuelo(A, B, 100);
        grafo.agregarVuelo(A, C, 300);
        grafo.agregarVuelo(B, C, 50);
        grafo.agregarVuelo(B, D, 200);
        grafo.agregarVuelo(C, D, 100);

        // Crear el sistema de selección de viajes y buscar la ruta de menor precio
        SistemaSeleccionViajes sistema = new SistemaSeleccionViajes();
        List<NodoDestino> ruta = sistema.encontrarRutaMenorPrecio(grafo, A, D);

        // Imprimir la ruta de menor precio encontrada
        if (ruta != null) {
            System.out.println("Ruta de menor precio: " + ruta);
        } else {
            System.out.println("No se encontró una ruta de A a D");
        }
    }
}