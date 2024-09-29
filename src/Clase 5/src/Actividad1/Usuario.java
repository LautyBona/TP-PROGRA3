package Actividad1;

import java.util.List;

public class Usuario {
    private int id;
    private String nombre;
    private List<Usuario> seguidos;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarSeguido(Usuario seguido){
        seguidos.add(seguido);
    }
    public List<Usuario> getSeguidos() {
        return seguidos;
    }
}
