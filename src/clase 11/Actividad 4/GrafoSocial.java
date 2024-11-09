import java.util.*;

public class GrafoSocial {
    private Map<Usuario, List<Usuario>> adyacencia;

    public GrafoSocial() {
        adyacencia = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        adyacencia.putIfAbsent(usuario, new ArrayList<>());
    }

    public void conectarAmigos(Usuario usuario1, Usuario usuario2) {
        adyacencia.get(usuario1).add(usuario2);
        adyacencia.get(usuario2).add(usuario1);  // Conexión bidireccional
    }

    public List<String> dfs(Usuario inicio) {
        Set<Usuario> visitados = new HashSet<>();
        List<String> recorrido = new ArrayList<>();
        dfsRecursivo(inicio, visitados, recorrido);
        return recorrido;
    }

    private void dfsRecursivo(Usuario usuario, Set<Usuario> visitados, List<String> recorrido) {
        visitados.add(usuario);
        recorrido.add(usuario.getNombre());
        for (Usuario amigo : adyacencia.get(usuario)) {
            if (!visitados.contains(amigo)) {
                dfsRecursivo(amigo, visitados, recorrido);
            }
        }
    }

    public List<String> bfs(Usuario inicio) {
        Set<Usuario> visitados = new HashSet<>();
        Queue<Usuario> cola = new LinkedList<>();
        List<String> recorrido = new ArrayList<>();
        
        visitados.add(inicio);
        cola.add(inicio);
        
        while (!cola.isEmpty()) {
            Usuario usuario = cola.poll();
            recorrido.add(usuario.getNombre());
            for (Usuario amigo : adyacencia.get(usuario)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    cola.add(amigo);
                }
            }
        }
        return recorrido;
    }
}
