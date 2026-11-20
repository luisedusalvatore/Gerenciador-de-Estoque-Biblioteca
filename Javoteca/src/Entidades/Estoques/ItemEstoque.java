package Entidades.Estoques;

import Entidades.Acervos.ItemAcervo;

public class ItemEstoque {
    protected Integer quantidade;
    protected String localizacao;
    protected ItemAcervo itemAcervo;

    public ItemEstoque(Integer quantidade, String localizacao, ItemAcervo itemAcervo) {
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.itemAcervo = itemAcervo;
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
