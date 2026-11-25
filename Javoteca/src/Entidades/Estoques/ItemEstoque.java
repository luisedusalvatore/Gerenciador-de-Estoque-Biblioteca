package Entidades.Estoques;

import Entidades.Acervos.ItemAcervo;

public class ItemEstoque {
    // Quantidade de exemplares disponíveis deste item.
    protected Integer quantidade;
    // Localização física ou área onde o item está armazenado.
    protected String localizacao;
    // Dados do item do acervo associado a este registro de estoque.
    protected ItemAcervo itemAcervo;

    // Associa um item do acervo à sua quantidade e localização no estoque.
    public ItemEstoque(Integer quantidade, String localizacao, ItemAcervo itemAcervo) {
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.itemAcervo = itemAcervo;
    }

    // Retorna a quantidade de exemplares disponíveis.
    public Integer getQuantidade() {
        return quantidade;
    }

    // Atualiza a quantidade de exemplares disponíveis.
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    // Retorna a localização do item no estoque.
    public String getLocalizacao() {
        return localizacao;
    }

    // Atualiza a localização do item no estoque.
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    // Retorna o item do acervo associado ao registro.
    public ItemAcervo getItemAcervo() {
        return itemAcervo;
    }

    // Atualiza o item do acervo associado ao registro.
    public void setItemAcervo(ItemAcervo itemAcervo) {
        this.itemAcervo = itemAcervo;
    }

    @Override
    public String toString() {
        // Inclui os dados do acervo, a quantidade e a localização em uma única descrição.
        return itemAcervo + "quantidade: " + quantidade + " || localizacao: " + localizacao + "\n";
    }
    
    
}
