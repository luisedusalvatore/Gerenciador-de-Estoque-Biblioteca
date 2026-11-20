package Entidades.Acervos;

import java.time.Instant;


public final class Revista extends ItemAcervo{
    private Integer edicao;
    public Revista(String titulo, Integer ano, Instant dataCadastro, Integer edicao) {
        super(titulo, ano, dataCadastro);
        this.edicao = edicao;
    }
    public Integer getEdicao() {
        return edicao;
    }
    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }
    @Override
    public double calcularMultaDiaria(int dias) {
        return 0.5*dias;
    }
    
}
