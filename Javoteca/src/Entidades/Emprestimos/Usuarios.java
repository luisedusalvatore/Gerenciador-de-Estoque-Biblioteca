package Entidades.Emprestimos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Usuarios {
    // Lista que mantém todos os usuários cadastrados em memória.
    private List<Usuario> lista = new ArrayList<>();

    // Inicializa a coleção vazia de usuários.
    public Usuarios() {
    }

    // Adiciona um usuário à lista.
    public void addUsuario(Usuario u){
        lista.add(u);
    }

    // Remove um usuário da lista.
    public void removeUsuario(Usuario u){
        lista.remove(u);
    }

    // Busca um usuário combinando nome e email informados.
    public Usuario buscaUsuario(String nome, String email){
        for(Usuario u : lista){
            if(u.getNome().equals(nome) && u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    // Retorna a coleção atual de usuários.
    public List<Usuario> getLista() {
        return lista;
    }

    // Substitui a coleção atual por outra lista de usuários.
    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    // Ordena os usuários pelo nome em ordem alfabética.
    public void ordenaNome(){
        lista.sort(Comparator.comparing(Usuario::getNome));
    }

    // Ordena os usuários pelo email em ordem alfabética.
    public void ordenaEmail(){
        lista.sort(Comparator.comparing(Usuario::getEmail));
    }
}
