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
}
