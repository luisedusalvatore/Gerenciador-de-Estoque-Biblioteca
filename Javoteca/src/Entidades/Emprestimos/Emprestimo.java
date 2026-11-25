package Entidades.Emprestimos;

import java.time.Instant;
import java.time.temporal.ChronoUnit;



import Entidades.Acervos.ItemAcervo;

public class Emprestimo {
    // Usuário responsável pelo empréstimo.
    private Usuario usuario;
    // Item retirado do acervo.
    private ItemAcervo item;
    // Datas relacionadas ao empréstimo e à devolução.
    private Instant dataEmprestimo;
    private Instant dataPrevistaDevolucao;
    private Instant dataDevolucao;
    
    
    // Cria um empréstimo ativo; a data de devolução ainda não existe.
    public Emprestimo(Usuario usuario, ItemAcervo item, Instant dataEmprestimo, Instant dataPrevistaDevolucao) {
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = null;
    }

    // Registra a data efetiva em que o item foi devolvido.
    public void registrarDevolucao(Instant dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    // Calcula quantos dias passaram da data prevista até a devolução.
    public Integer diasAtraso(){
        if(dataDevolucao.isAfter(dataPrevistaDevolucao)){
            return (int) ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataDevolucao);
        }
        
        return 0;
    }

    // Delega o cálculo da multa à classe específica do item emprestado.
    public Double acessarValorMulta(int dias){
        return this.item.calcularMultaDiaria(dias);
    }

    // Retorna o usuário associado ao empréstimo.
    public Usuario getUsuario() {
        return usuario;
    }

    // Atualiza o usuário associado ao empréstimo.
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Retorna o item emprestado.
    public ItemAcervo getItem() {
        return item;
    }

    // Atualiza o item associado ao empréstimo.
    public void setItem(ItemAcervo item) {
        this.item = item;
    }

    // Retorna a data em que o empréstimo foi realizado.
    public Instant getDataEmprestimo() {
        return dataEmprestimo;
    }

    // Atualiza a data em que o empréstimo foi realizado.
    public void setDataEmprestimo(Instant dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    // Retorna a data prevista para a devolução.
    public Instant getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    // Atualiza a data prevista para a devolução.
    public void setDataPrevistaDevolucao(Instant dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    // Retorna a data efetiva da devolução.
    public Instant getDataDevolucao() {
        return dataDevolucao;
    }

    // Atualiza a data efetiva da devolução.
    public void setDataDevolucao(Instant dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    





}
