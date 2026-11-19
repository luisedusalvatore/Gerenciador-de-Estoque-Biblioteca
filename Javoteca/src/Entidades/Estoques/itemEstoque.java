package Entidades.Estoques;

import Entidades.Acervos.ItemAcervo;

public class itemEstoque {
    protected Integer quantidade;
    protected String localizacao;
    protected ItemAcervo itemAcervo;

    public itemEstoque(Integer quantidade, String localizacao) {
        this.quantidade = quantidade;
        this.localizacao = localizacao;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
}
