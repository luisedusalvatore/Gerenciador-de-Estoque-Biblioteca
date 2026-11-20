package Entidades.Emprestimos;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private List<Usuario> lista = new ArrayList<>();

    public Usuarios(List<Usuario> lista) {
        this.lista = lista;
    }
    public void addUsuario(Usuario u){
        lista.add(u);
    }
    public void removeUsuario(Usuario u){
        lista.remove(u);
    }
}
