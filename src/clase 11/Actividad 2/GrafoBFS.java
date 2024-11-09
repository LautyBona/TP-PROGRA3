import java.util.*;

public class GrafoBFS {
    private List<List<Integer>> adjList; // Lista de adyacencia para representar el grafo
    private boolean[] visitado; // Array para marcar los nodos visitados

    public GrafoBFS(int numNodos) {
        adjList = new ArrayList<>();
        visitado = new boolean[numNodos];
        for (int i = 0; i < numNodos; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Método para añadir arista
    public void addEdge(int origen, int destino) {
        adjList.get(origen).add(destino);
        adjList.get(destino).add(origen); // Como el grafo es no dirigido, añadimos ambas conexiones
    }

    // Método BFS iterativo
    public void bfs(int inicio) {
        Queue<Integer> cola = new LinkedList<>();
        visitado[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.print(nodo + " ");

            for (int vecino : adjList.get(nodo)) {
                if (!visitado[vecino]) {
                    visitado[vecino] = true;
                    cola.add(vecino);
                }
            }
        }
    }

    public static void main(String[] args) {
        GrafoBFS grafo = new GrafoBFS(9); // Crea el grafo con 9 nodos (0 a 8)

        // Añade las aristas según el grafo de la imagen
        grafo.addEdge(0, 1);
        grafo.addEdge(0, 2);
        grafo.addEdge(1, 3);
        grafo.addEdge(1, 4);
        grafo.addEdge(2, 5);
        grafo.addEdge(3, 6);
        grafo.addEdge(4, 7);
        grafo.addEdge(4, 8);

        System.out.println("Recorrido BFS a partir del nodo 0:");
        grafo.bfs(0); // Inicia BFS desde el nodo 0
    }
}
