package Actividad2;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private int[][] matrizAdyacencia;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino) {
        if (origen < numVertices && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;
        } else {
            System.out.println("Vertice fuera de rango.");
        }
    }

    public void eliminarArista(int origen, int destino) {
        if (origen < numVertices && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0; // Elimina la arista
        } else {
            System.out.println("Vertice fuera de rango.");
        }
    }

    public boolean verificarArista(int origen, int destino) {
        if (origen < numVertices && destino < numVertices) {
            return matrizAdyacencia[origen][destino] == 1; // Devuelve true si hay una arista
        } else {
            System.out.println("Vertice fuera de rango.");
            return false;
        }
    }

    public List<Integer> listarAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        if (vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    adyacentes.add(i);
                }
            }
        } else {
            System.out.println("Vertice fuera de rango.");
        }
        return adyacentes;
    }

    public int gradoSalida(int vertice) {
        int grado = 0;
        if (vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                grado += matrizAdyacencia[vertice][i];
            }
        } else {
            System.out.println("Vertice fuera de rango.");
        }
        return grado;
    }

    public int gradoEntrada(int vertice) {
        int grado = 0;
        if (vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                grado += matrizAdyacencia[i][vertice];
            }
        } else {
            System.out.println("Vertice fuera de rango.");
        }
        return grado;
    }

    public void mostrarMatriz() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
}