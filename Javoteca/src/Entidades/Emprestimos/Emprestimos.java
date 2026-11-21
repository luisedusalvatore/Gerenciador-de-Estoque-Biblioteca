package Entidades.Emprestimos;

import java.util.ArrayList;
import java.util.List;

public class Emprestimos {
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Emprestimos() {
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    public void addEmprestimo(Emprestimo e){
        emprestimos.add(e);
    }
    public void removeEmprestimo(Emprestimo e){
        emprestimos.remove(e);
    }

    public Emprestimo buscaEmprestimo(Usuario user, String item){
        for(Emprestimo e: emprestimos){
            if(user.getEmail().equals(e.getUsuario().getEmail()) && item.equals(e.getItem().getTitulo())){
                return e;
            } 
            
                

        }
        return null;
    }

    
}
