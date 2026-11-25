package Entidades.Acervos;

import java.time.Instant;

// Representa um livro no acervo e herda os dados comuns de ItemAcervo.
public final class Livro extends ItemAcervo{
    // Informações específicas de identificação e descrição do livro.
    private String autor;
    private String isbn;
    private Integer paginas;
    
    // Inicializa os dados comuns do acervo e os atributos exclusivos do livro.
    public Livro(String titulo, Integer ano, Instant dataCadastro, String autor,
            String isbn, Integer paginas) {
        super(titulo, ano, dataCadastro);
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
    }

    // Retorna o autor do livro.
    public String getAutor() {
        return autor;
    }

    // Atualiza o autor do livro.
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Retorna o código ISBN do livro.
    public String getIsbn() {
        return isbn;
    }

    // Atualiza o código ISBN do livro.
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Retorna a quantidade de páginas do livro.
    public Integer getPaginas() {
        return paginas;
    }

    // Atualiza a quantidade de páginas do livro.
    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    // Calcula a multa do livro: R$ 0,50 por dia de atraso.
    @Override
    public double calcularMultaDiaria(int dias) {
        return 0.5 * dias;
    }
}
