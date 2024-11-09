public class MainRedSocial {
    public static void main(String[] args) {
        GrafoSocial redSocial = new GrafoSocial();

        Usuario u1 = new Usuario(1, "Alice");
        Usuario u2 = new Usuario(2, "Bob");
        Usuario u3 = new Usuario(3, "Charlie");
        Usuario u4 = new Usuario(4, "Diana");

        redSocial.agregarUsuario(u1);
        redSocial.agregarUsuario(u2);
        redSocial.agregarUsuario(u3);
        redSocial.agregarUsuario(u4);

        redSocial.conectarAmigos(u1, u2);
        redSocial.conectarAmigos(u2, u3);
        redSocial.conectarAmigos(u3, u4);

        System.out.println("DFS desde Alice: " + redSocial.dfs(u1));
        System.out.println("BFS desde Alice: " + redSocial.bfs(u1));
    }
}
