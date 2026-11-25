package Entidades.Emprestimos;

import java.util.ArrayList;
import java.util.List;

public class Emprestimos {
    // Lista que mantém todos os empréstimos ativos em memória.
    private List<Emprestimo> emprestimos = new ArrayList<>();

    // Inicializa a coleção vazia para receber novos empréstimos.
    public Emprestimos() {
    }

    // Retorna a lista de empréstimos cadastrados.
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    // Substitui a lista atual de empréstimos por outra coleção.
    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    // Adiciona um novo empréstimo à coleção.
    public void addEmprestimo(Emprestimo e){
        emprestimos.add(e);
    }

    // Remove um empréstimo da coleção.
    public void removeEmprestimo(Emprestimo e){
        emprestimos.remove(e);
    }

    // Localiza um empréstimo pelo usuário e pelo título do item emprestado.
    public Emprestimo buscaEmprestimo(Usuario user, String item){
        for(Emprestimo e: emprestimos){
            if(user.getEmail().equals(e.getUsuario().getEmail()) && item.equals(e.getItem().getTitulo())){
                return e;
            } 
            
                

        }
        return null;
    }

    
}
