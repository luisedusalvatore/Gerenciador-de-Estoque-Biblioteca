package Entidades.Acervos;


import java.time.Instant;

public abstract class ItemAcervo{

    protected String titulo;
    protected Integer ano;
    protected Instant dataCadastro;

    
    public ItemAcervo() {
    }

    public ItemAcervo(String titulo, Integer ano, Instant dataCadastro) {
        
        this.titulo = titulo;
        this.ano = ano;
        this.dataCadastro = dataCadastro;
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
    public Instant getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public abstract double calcularMultaDiaria(int dias);

}
