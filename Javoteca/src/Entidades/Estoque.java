package Entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class Estoque {
    private List<itemEstoque> listaEstoque= new ArrayList<itemEstoque>();

    public Estoque() {
    }
    public void addItem(itemEstoque Item) {
        listaEstoque.add(Item);
    }
    public void removeItem(itemEstoque Item){
        listaEstoque.remove(Item);
    }
    public int totalExemplares(){
        return listaEstoque.size();
    }
    //public itemEstoque buscarPorTitulo(Sting Nome) fazer quando tiver acervo

    public void ordenar(){
        listaEstoque.sort(null);
    }
    public List<itemEstoque> getItens() {
        return listaEstoque;
    }
    
}
