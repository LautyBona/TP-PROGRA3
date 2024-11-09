public class MainAlmacenes {
    public static void main(String[] args) {
        GrafoAlmacenes grafo = new GrafoAlmacenes();

        Almacen a1 = new Almacen(1, "Almacen A");
        Almacen a2 = new Almacen(2, "Almacen B");
        Almacen a3 = new Almacen(3, "Almacen C");
        Almacen a4 = new Almacen(4, "Almacen D");

        grafo.agregarAlmacen(a1);
        grafo.agregarAlmacen(a2);
        grafo.agregarAlmacen(a3);
        grafo.agregarAlmacen(a4);

        grafo.conectarAlmacenes(a1, a2);
        grafo.conectarAlmacenes(a2, a3);
        grafo.conectarAlmacenes(a3, a4);

        System.out.println("DFS desde Almacen A: " + grafo.dfs(a1));
        System.out.println("BFS desde Almacen A: " + grafo.bfs(a1));
    }
}
