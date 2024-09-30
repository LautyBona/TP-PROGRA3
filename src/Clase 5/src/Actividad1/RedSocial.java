package Actividad1;

import java.util.List;
import java.util.ArrayList;

public class RedSocial {
    List<Usuario> usuarios;
    int largo= usuarios.size();
    List<List<Usuario>> grafo = new ArrayList<>();

    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void mostrarListaDeAdyacencia() {
        for (Usuario usuario : usuarios) {
            System.out.print(usuario.getNombre() + " sigue a: ");
            List<Usuario> seguidos = usuario.getSeguidos();
            if (seguidos.isEmpty()) {
                System.out.println("No sigue a nadie.");
            } else {
                for (Usuario seguido : seguidos) {
                    System.out.print(seguido.getNombre() + " ");
                }
                System.out.println();
            }
        }
    }
}
