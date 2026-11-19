package Entidades.Acervos;

import Enumeracoes.StatusExemplar;
import java.time.Instant;

public abstract class ItemAcervo{

    protected Integer id;
    protected String titulo;
    protected Integer ano;
    protected StatusExemplar status;
    protected Instant dataCadastro;

    
    public ItemAcervo(Integer id, String titulo, Integer ano, StatusExemplar status, Instant dataCadastro) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.status = status;
        this.dataCadastro = dataCadastro;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public StatusExemplar getStatus() {
        return status;
    }
    public void setStatus(StatusExemplar status) {
        this.status = status;
    }
    public Instant getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public abstract double calcularMultaDiaria(int dias);

}
