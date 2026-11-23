package Entidades.Emprestimos;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private List<Usuario> lista = new ArrayList<>();

    public Usuarios() {
    }
    public void addUsuario(Usuario u){
        lista.add(u);
    }
    public void removeUsuario(Usuario u){
        lista.remove(u);
    }
    public Usuario buscaUsuario(String nome, String email){
        for(Usuario u : lista){
            if(u.getNome().equals(nome) && u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
    public List<Usuario> getLista() {
        return lista;
    }
    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
}
