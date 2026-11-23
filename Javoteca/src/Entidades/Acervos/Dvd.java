package Entidades.Acervos;

import java.time.Instant;


public final class Dvd extends ItemAcervo{
    private Integer duracaoMinutos;

    public Dvd(String titulo, Integer ano, Instant dataCadastro,
            Integer duracaoMinutos) {
        super(titulo, ano, dataCadastro);
        this.duracaoMinutos = duracaoMinutos;
    }

    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
    @Override
    public double calcularMultaDiaria(int dias) {
        return 1.0 * dias;
    }
    
}
