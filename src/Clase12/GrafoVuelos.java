package Clase12;

import java.util.*;

class GrafoVuelos {
    private Map<NodoDestino, List<AristaVuelo>> grafo = new HashMap<>();

    public void agregarDestino(NodoDestino destino) {
        grafo.putIfAbsent(destino, new ArrayList<>());
    }

    public void agregarVuelo(NodoDestino origen, NodoDestino destino, int precio) {
        grafo.get(origen).add(new AristaVuelo(destino, precio));
    }

    public List<AristaVuelo> obtenerVuelosDesde(NodoDestino origen) {
        return grafo.get(origen);
    }
}
