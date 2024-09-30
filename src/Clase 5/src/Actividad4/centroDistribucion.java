package Actividad4;
import java.util.*;

// Clase que representa un centro de distribución
class CentroDistribucion {
    int id;
    String nombre;

    public CentroDistribucion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}

// Clase que representa una arista con un centro destino y el tiempo de viaje
class Arista {
    int destino;
    int tiempo;

    public Arista(int destino, int tiempo) {
        this.destino = destino;
        this.tiempo = tiempo;
    }
}

// Clase que representa el grafo
class Grafo {
    private final List<List<Arista>> adyacencia;
    private final List<CentroDistribucion> centros;

    public Grafo(int numCentros) {
        adyacencia = new ArrayList<>();
        centros = new ArrayList<>();
        for (int i = 0; i < numCentros; i++) {
            adyacencia.add(new ArrayList<>());
        }
    }

    // Método para agregar un centro de distribución
    public void agregarCentro(int id, String nombre) {
        centros.add(new CentroDistribucion(id, nombre));
    }

    // Método para agregar una carretera entre dos centros con el tiempo de viaje
    public void agregarCarretera(int origen, int destino, int tiempo) {
        adyacencia.get(origen).add(new Arista(destino, tiempo));
        adyacencia.get(destino).add(new Arista(origen, tiempo)); // Si es bidireccional
    }

    // Algoritmo de Dijkstra para encontrar el tiempo mínimo desde un centro principal
    public void dijkstra(int centroPrincipal) {
        int numCentros = adyacencia.size();
        int[] tiempos = new int[numCentros];
        Arrays.fill(tiempos, Integer.MAX_VALUE);
        tiempos[centroPrincipal] = 0;

        PriorityQueue<Arista> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.tiempo));
        pq.add(new Arista(centroPrincipal, 0));

        while (!pq.isEmpty()) {
            Arista actual = pq.poll();
            int centroActual = actual.destino;

            for (Arista vecino : adyacencia.get(centroActual)) {
                int nuevoTiempo = tiempos[centroActual] + vecino.tiempo;
                if (nuevoTiempo < tiempos[vecino.destino]) {
                    tiempos[vecino.destino] = nuevoTiempo;
                    pq.add(new Arista(vecino.destino, nuevoTiempo));
                }
            }
        }

        // Imprimir los tiempos mínimos
        for (int i = 0; i < numCentros; i++) {
            if (tiempos[i] == Integer.MAX_VALUE) {
                System.out.println("No hay ruta desde el centro " + centros.get(centroPrincipal).nombre + " al centro " + centros.get(i).nombre);
            } else {
                System.out.println("Tiempo mínimo desde " + centros.get(centroPrincipal).nombre + " hasta " + centros.get(i).nombre + " es: " + tiempos[i] + " minutos.");
            }
        }
    }
}
