package Entidades.Acervos;

import java.time.Instant;

import Enumeracoes.StatusExemplar;

public final class Livro extends ItemAcervo{
    String autor;
    String isbn;
    Integer paginas;
    
    public Livro(Integer id, String titulo, Integer ano, StatusExemplar status, Instant dataCadastro, String autor,
            String isbn, Integer paginas) {
        super(id, titulo, ano, status, dataCadastro);
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

    

    
}
