package Entidades.Acervos;

import java.time.Instant;


// Representa uma revista no acervo e herda os dados comuns de ItemAcervo.
public final class Revista extends ItemAcervo{
    // Armazena o número da edição da revista.
    private Integer edicao;

    // Inicializa os dados comuns do acervo e a edição específica da revista.
    public Revista(String titulo, Integer ano, Instant dataCadastro, Integer edicao) {
        super(titulo, ano, dataCadastro);
        this.edicao = edicao;
    }

    // Retorna o número da edição.
    public Integer getEdicao() {
        return edicao;
    }

    // Atualiza o número da edição.
    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    // Calcula a multa da revista: R$ 0,25 por dia de atraso.
    @Override
    public double calcularMultaDiaria(int dias) {
        return 0.25 * dias;
    }
    
}
