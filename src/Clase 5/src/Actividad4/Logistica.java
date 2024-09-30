package Actividad4;

public class Logistica {
    public static void main(String[] args) {
        // Crear un grafo con 5 centros de distribución
        Grafo grafo = new Grafo(5);

        // Agregar los centros de distribución
        grafo.agregarCentro(0, "Centro A");
        grafo.agregarCentro(1, "Centro B");
        grafo.agregarCentro(2, "Centro C");
        grafo.agregarCentro(3, "Centro D");
        grafo.agregarCentro(4, "Centro E");

        // Agregar las carreteras (con el tiempo en minutos)
        grafo.agregarCarretera(0, 1, 10);  // A-B
        grafo.agregarCarretera(0, 2, 5);   // A-C
        grafo.agregarCarretera(1, 2, 2);   // B-C
        grafo.agregarCarretera(1, 3, 1);   // B-D
        grafo.agregarCarretera(2, 3, 9);   // C-D
        grafo.agregarCarretera(3, 4, 4);   // D-E

        // Ejecutar Dijkstra desde el centro de distribución principal (Centro A, id 0)
        grafo.dijkstra(0);
    }
}