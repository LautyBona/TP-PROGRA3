package Clase12;

import java.util.*;

public class SistemaSeleccionViajes {

    public List<NodoDestino> encontrarRutaMenorPrecio(GrafoVuelos grafo, NodoDestino origen, NodoDestino destino) {
        Map<NodoDestino, Integer> preciosMinimos = new HashMap<>();
        Map<NodoDestino, NodoDestino> predecesores = new HashMap<>();
        PriorityQueue<NodoDestino> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(preciosMinimos::get));

        preciosMinimos.put(origen, 0);
        colaPrioridad.add(origen);

        while (!colaPrioridad.isEmpty()) {
            NodoDestino actual = colaPrioridad.poll();

            if (actual.equals(destino)) {
                return reconstruirCamino(predecesores, destino);
            }

            for (AristaVuelo vuelo : grafo.obtenerVuelosDesde(actual)) {
                NodoDestino vecino = vuelo.destino;
                int nuevoPrecio = preciosMinimos.get(actual) + vuelo.precio;

                if (nuevoPrecio < preciosMinimos.getOrDefault(vecino, Integer.MAX_VALUE)) {
                    preciosMinimos.put(vecino, nuevoPrecio);
                    predecesores.put(vecino, actual);
                    colaPrioridad.add(vecino);
                }
            }
        }

        return null;
    }

    private List<NodoDestino> reconstruirCamino(Map<NodoDestino, NodoDestino> predecesores, NodoDestino destino) {
        List<NodoDestino> camino = new ArrayList<>();
        for (NodoDestino at = destino; at != null; at = predecesores.get(at)) {
            camino.add(at);
        }
        Collections.reverse(camino);
        return camino;
    }
}
