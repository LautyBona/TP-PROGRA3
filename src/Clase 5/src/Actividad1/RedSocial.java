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
}
