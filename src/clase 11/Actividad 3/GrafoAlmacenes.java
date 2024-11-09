import java.util.*;

public class GrafoAlmacenes {
    private Map<Almacen, List<Almacen>> adyacencia;

    public GrafoAlmacenes() {
        adyacencia = new HashMap<>();
    }

    public void agregarAlmacen(Almacen almacen) {
        adyacencia.putIfAbsent(almacen, new ArrayList<>());
    }

    public void conectarAlmacenes(Almacen origen, Almacen destino) {
        adyacencia.get(origen).add(destino);
        adyacencia.get(destino).add(origen);  // Conexión bidireccional
    }

    public List<String> dfs(Almacen inicio) {
        Set<Almacen> visitados = new HashSet<>();
        List<String> recorrido = new ArrayList<>();
        dfsRecursivo(inicio, visitados, recorrido);
        return recorrido;
    }

    private void dfsRecursivo(Almacen almacen, Set<Almacen> visitados, List<String> recorrido) {
        visitados.add(almacen);
        recorrido.add(almacen.getNombre());
        for (Almacen vecino : adyacencia.get(almacen)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados, recorrido);
            }
        }
    }

    public List<String> bfs(Almacen inicio) {
        Set<Almacen> visitados = new HashSet<>();
        Queue<Almacen> cola = new LinkedList<>();
        List<String> recorrido = new ArrayList<>();
        
        visitados.add(inicio);
        cola.add(inicio);
        
        while (!cola.isEmpty()) {
            Almacen almacen = cola.poll();
            recorrido.add(almacen.getNombre());
            for (Almacen vecino : adyacencia.get(almacen)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        return recorrido;
    }
}
