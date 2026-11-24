package Entidades.Emprestimos;

import java.time.Instant;
import java.time.temporal.ChronoUnit;



import Entidades.Acervos.ItemAcervo;

public class Emprestimo {
    private Usuario usuario;
    private ItemAcervo item;
    private Instant dataEmprestimo;
    private Instant dataPrevistaDevolucao;
    private Instant dataDevolucao;
    
    
    public Emprestimo(Usuario usuario, ItemAcervo item, Instant dataEmprestimo, Instant dataPrevistaDevolucao) {
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = null;
    }

    public void registrarDevolucao(Instant dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer diasAtraso(){
        if(dataDevolucao.isAfter(dataPrevistaDevolucao)){
            return (int) ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataDevolucao);
        }
        
        return 0;
    }

    public Double acessarValorMulta(int dias){
        return this.item.calcularMultaDiaria(dias);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ItemAcervo getItem() {
        return item;
    }

    public void setItem(ItemAcervo item) {
        this.item = item;
    }

    public Instant getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Instant dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Instant getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(Instant dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public Instant getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Instant dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    





}
