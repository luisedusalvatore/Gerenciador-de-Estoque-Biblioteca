package Entidades.Acervos;

import java.time.Instant;

import Enumeracoes.StatusExemplar;

public class Revista extends ItemAcervo{
    private Integer edicao;
    private String issn;
    public Revista(Integer id, String titulo, Integer ano, StatusExemplar status, Instant dataCadastro, Integer edicao,
            String issn) {
        super(id, titulo, ano, status, dataCadastro);
        this.edicao = edicao;
        this.issn = issn;
    }
    public Integer getEdicao() {
        return edicao;
    }
    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }
    public String getIssn() {
        return issn;
    }
    public void setIssn(String issn) {
        this.issn = issn;
    }
    
}
