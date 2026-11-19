package Entidades.Acervos;

import java.time.Instant;

import Enumeracoes.StatusExemplar;

public final class Dvd extends ItemAcervo{
    private Integer duracaoMinutos;

    public Dvd(Integer id, String titulo, Integer ano, StatusExemplar status, Instant dataCadastro,
            Integer duracaoMinutos) {
        super(id, titulo, ano, status, dataCadastro);
        this.duracaoMinutos = duracaoMinutos;
    }

    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
    
}
