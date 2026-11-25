package Entidades.Acervos;

import java.time.Instant;


// Representa um DVD no acervo e reutiliza os dados comuns definidos em ItemAcervo.
public final class Dvd extends ItemAcervo{
    // Armazena a duração do filme em minutos.
    private Integer duracaoMinutos;

    // Recebe os dados comuns do item e a duração específica do DVD.
    public Dvd(String titulo, Integer ano, Instant dataCadastro,
            Integer duracaoMinutos) {
        super(titulo, ano, dataCadastro);
        this.duracaoMinutos = duracaoMinutos;
    }

    // Retorna a duração cadastrada do DVD.
    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    // Atualiza a duração cadastrada do DVD.
    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    // Calcula a multa diária do DVD: R$ 1,00 por dia de atraso.
    @Override
    public double calcularMultaDiaria(int dias) {
        return 1.0 * dias;
    }
    
}
