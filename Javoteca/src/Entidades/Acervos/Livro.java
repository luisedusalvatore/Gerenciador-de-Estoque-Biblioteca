package Entidades.Acervos;

import java.time.Instant;

public final class Livro extends ItemAcervo{
    String autor;
    String isbn;
    Integer paginas;
    
    public Livro(String titulo, Integer ano, Instant dataCadastro, String autor,
            String isbn, Integer paginas) {
        super(titulo, ano, dataCadastro);
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }
    @Override
    public double calcularMultaDiaria(int dias) {
        return 2*dias;
    }
}
