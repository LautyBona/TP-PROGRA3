package Actividad1;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1,"juan");
        Usuario usuario2 =new Usuario(2,"Messi");
        Usuario usuario3 =new Usuario(3,"roman");
        Usuario usuario4 =new Usuario(4,"Alexis");
        usuario.agregarSeguido(usuario2);
        usuario.agregarSeguido(usuario3);
        usuario3.agregarSeguido(usuario);
        usuario4.agregarSeguido(usuario2);
        usuario3.agregarSeguido(usuario2);
        usuario.agregarSeguido(usuario4);
    }
}
