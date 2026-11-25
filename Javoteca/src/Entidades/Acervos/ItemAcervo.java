package Entidades.Acervos;


import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

// Classe abstrata que concentra os dados comuns aos itens do acervo.
public abstract class ItemAcervo{

    // Dados básicos compartilhados por livros, revistas e DVDs.
    protected String titulo;
    protected Integer ano;
    protected Instant dataCadastro;

    
    // Construtor vazio necessário para permitir a construção inicial dos objetos.
    public ItemAcervo() {
    }

    // Inicializa um item com suas informações básicas de identificação e cadastro.
    public ItemAcervo(String titulo, Integer ano, Instant dataCadastro) {
        
        this.titulo = titulo;
        this.ano = ano;
        this.dataCadastro = dataCadastro;
    }
    
    // Retorna o título do item.
    public String getTitulo() {
        return titulo;
    }

    // Atualiza o título do item.
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Retorna o ano de criação do item.
    public Integer getAno() {
        return ano;
    }

    // Atualiza o ano de criação do item.
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    // Retorna a data em que o item foi cadastrado.
    public Instant getDataCadastro() {
        return dataCadastro;
    }

    // Atualiza a data de cadastro do item.
    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // Cada tipo de acervo deve definir como calcula sua multa a partir dos dias de atraso.
    public abstract double calcularMultaDiaria(int dias);

    @Override
    public String toString() {
        // Formata a data de cadastro no padrão brasileiro e no fuso horário local do sistema.
        DateTimeFormatter formato =  DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.of("America/Sao_Paulo"));

        return "Titulo: " + titulo + " || Ano: " + ano + " || data de cadastro: " + formato.format(dataCadastro) + " || ";
    }
}
