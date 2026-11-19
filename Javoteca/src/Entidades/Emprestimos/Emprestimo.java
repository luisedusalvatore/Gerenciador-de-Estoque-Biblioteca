package Entidades.Emprestimos;

import java.time.Instant;

import java.time.Duration;


import Entidades.Acervos.ItemAcervo;

public class Emprestimo {
    Usuario usuario;
    ItemAcervo item;
    Instant dataEmprestimo;
    Instant dataPrevistaDevolucao;
    Instant dataDevolucao;
    
    
    public Emprestimo(Usuario usuario, ItemAcervo item, Instant dataEmprestimo, Instant dataPrevistaDevolucao,
            Instant dataDevolucao) {
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = dataDevolucao;
    }

    public void registrarDevolucao(Instant dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer diasAtraso(){
        if(dataDevolucao == null){
            return 0;
        }
        if(dataDevolucao.isAfter(dataPrevistaDevolucao)){
            Duration duracao = Duration.between(dataPrevistaDevolucao, dataDevolucao);
            return (int) duracao.toDays();
        }
        
        return 0;
    }

    





}
