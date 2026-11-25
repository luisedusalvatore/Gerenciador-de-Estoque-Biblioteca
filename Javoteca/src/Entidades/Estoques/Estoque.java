package Entidades.Estoques;

import java.util.List;

import Entidades.Acervos.ItemAcervo;
import Enumeracoes.operacaoAlteracao;
import Excecoes.ItemIndisponivel;
import Excecoes.ItemNaoEncontrado;

import java.util.ArrayList;


public class Estoque {
    // Lista os itens físicos cadastrados no estoque.
    private List<ItemEstoque> listaEstoque= new ArrayList<ItemEstoque>();


    // Inicializa o estoque sem itens.
    public Estoque() {
    }

    // Adiciona um item à lista do estoque.
    public void addItem(ItemEstoque Item) {
        listaEstoque.add(Item);
    }

    // Remove um item da lista do estoque.
    public void removeItem(ItemEstoque Item){
        listaEstoque.remove(Item);
    }

    // Retorna a quantidade de registros diferentes existentes no estoque.
    public int totalExemplares(){
        return listaEstoque.size();
    }

    // Localiza um registro pelo título do item do acervo.
    public ItemEstoque buscarPorTitulo(String nome){
        for(ItemEstoque i : listaEstoque){
            if(i.getItemAcervo().getTitulo().equals(nome)) return i;
        }
        return null;
    }

    // Aumenta, diminui ou redefine a quantidade de um item pelo título.
    public int alteraQuantidade(String nome, int quantidade, operacaoAlteracao operacao){
        if(operacao == operacaoAlteracao.AUMENTAR){
            for(ItemEstoque i : listaEstoque){
            if(i.getItemAcervo().getTitulo().equals(nome)){
                i.quantidade += quantidade;
                return 1;
            }
        }
        }
        else if(operacao == operacaoAlteracao.DIMINUIR){
            for(ItemEstoque i : listaEstoque){
            if(i.getItemAcervo().getTitulo().equals(nome)){
                i.quantidade -= quantidade;
                return 1;
            }
        }
        }
        else if(operacao == operacaoAlteracao.ALTERAR){
            for(ItemEstoque i : listaEstoque){
            if(i.getItemAcervo().getTitulo().equals(nome)){
                i.quantidade = quantidade;
                return 1;
            }
        }
        }
        return 0;
    }

       // Retira um exemplar do estoque para realizar um empréstimo.
       public ItemAcervo realizaEmprestimo(String nome)
            throws ItemNaoEncontrado, ItemIndisponivel {
        ItemEstoque i = buscarPorTitulo(nome);
        // Informa que o título não existe no acervo.
        if (i == null) {
            throw new ItemNaoEncontrado("Item '" + nome + "' não encontrado no acervo.");
        }
        // Impede o empréstimo quando não há exemplares disponíveis.
        if (i.getQuantidade() <= 0) {
            throw new ItemIndisponivel("Item '" + nome + "' sem exemplares disponíveis.");
        }
        // Reserva um exemplar e devolve o item emprestado.
        i.quantidade -= 1;
        return i.getItemAcervo();
    }

    // Ordena os itens do estoque usando a ordem definida por ItemEstoque.
    public void ordenar(){
        listaEstoque.sort(null);
    }

    // Retorna todos os itens cadastrados no estoque.
    public List<ItemEstoque> getItens() {
        return listaEstoque;
    }
    
    
}
