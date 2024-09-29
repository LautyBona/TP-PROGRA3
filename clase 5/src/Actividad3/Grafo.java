package Actividad3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Grafo {
    private List<List<Arista>> listaAdyacencia;
    private int numEstaciones;

    public Grafo(int numEstaciones) {
        this.numEstaciones = numEstaciones;
        listaAdyacencia = new ArrayList<>(numEstaciones);
        for (int i = 0; i < numEstaciones; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }
    
    public void agregarArista(int origen, int destino, int costo) {
        listaAdyacencia.get(origen).add(new Arista(destino, costo));
        listaAdyacencia.get(destino).add(new Arista(origen, costo));
    }

    public void prim() {
        boolean[] enMST = new boolean[numEstaciones];
        int[] costoMinimo = new int[numEstaciones];
        int[] padre = new int[numEstaciones];

        for (int i = 0; i < numEstaciones; i++) {
            costoMinimo[i] = Integer.MAX_VALUE;
            padre[i] = -1;
        }

        PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>((a, b) -> a.costo - b.costo);

        costoMinimo[0] = 0;
        colaPrioridad.add(new Arista(0, 0));

        while (!colaPrioridad.isEmpty()) {
            int actual = colaPrioridad.poll().destino;

            if (enMST[actual]) continue;

            enMST[actual] = true;

            for (Arista arista : listaAdyacencia.get(actual)) {
                if (!enMST[arista.destino] && arista.costo < costoMinimo[arista.destino]) {
                    costoMinimo[arista.destino] = arista.costo; // Actualizamos el costo mínimo
                    padre[arista.destino] = actual; // Actualizamos el padre
                    colaPrioridad.add(new Arista(arista.destino, arista.costo)); // Agregamos a la cola
                }
            }
        }

        mostrarResultado(padre, costoMinimo);
    }

    private void mostrarResultado(int[] padre, int[] costoMinimo) {
        int costoTotal = 0;
        System.out.println("Conexiones en el Árbol de Recubrimiento Mínimo:");
        for (int i = 1; i < numEstaciones; i++) {
            System.out.println("Estación " + padre[i] + " - Estación " + i + ": Costo " + costoMinimo[i]);
            costoTotal += costoMinimo[i];
        }
        System.out.println("Costo total del MST: " + costoTotal);
    }
}