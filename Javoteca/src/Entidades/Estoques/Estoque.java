package Entidades.Estoques;

import java.util.List;

import Entidades.Acervos.ItemAcervo;
import Enumeracoes.operacaoAlteracao;

import java.util.ArrayList;


public class Estoque {
    private List<ItemEstoque> listaEstoque= new ArrayList<ItemEstoque>();


    public Estoque() {
    }
    public void addItem(ItemEstoque Item) {
        listaEstoque.add(Item);
    }
    public void removeItem(ItemEstoque Item){
        listaEstoque.remove(Item);
    }

    public int totalExemplares(){
        return listaEstoque.size();
    }
    public ItemEstoque buscarPorTitulo(String nome){
        for(ItemEstoque i : listaEstoque){
            if(i.itemAcervo.getTitulo() == nome) return i;
        }
        return null;
    }
    public int alteraQuantidade(String nome, int quantidade, operacaoAlteracao operacao){
        if(operacao == operacaoAlteracao.AUMENTAR){
            for(ItemEstoque i : listaEstoque){
            if(i.itemAcervo.getTitulo() == nome){
                i.quantidade += quantidade;
                return 1;
            }
        }
        }
        else if(operacao == operacaoAlteracao.DIMINUIR){
            for(ItemEstoque i : listaEstoque){
            if(i.itemAcervo.getTitulo() == nome){
                i.quantidade -= quantidade;
                return 1;
            }
        }
        }
        else if(operacao == operacaoAlteracao.ALTERAR){
            for(ItemEstoque i : listaEstoque){
            if(i.itemAcervo.getTitulo() == nome){
                i.quantidade = quantidade;
                return 1;
            }
        }
        }
        return 0;
    }

    public ItemAcervo realizaEmprestimo(String nome){
        for(ItemEstoque i : listaEstoque){
            if(i.getItemAcervo().getTitulo().equals(nome)){
                if(i.quantidade >= 0){
                    i.quantidade -= 1;
                    return i.getItemAcervo();
                }
                else{
                    System.out.println("Item indisponível do acervo");
                    
                }
            }
            else{
                System.out.println("Item não encontrado no acervo");
            }
        }
        return null;
    }
    public void ordenar(){
        listaEstoque.sort(null);
    }
    public List<ItemEstoque> getItens() {
        return listaEstoque;
    }
    
    
}
