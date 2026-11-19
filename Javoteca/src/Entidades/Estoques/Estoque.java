package Entidades.Estoques;

import java.util.List;
import java.util.ArrayList;


public class Estoque {
    private List<ItemEstoque> listaEstoque= new ArrayList<ItemEstoque>();
    public List<String> listaLocalizacao = new ArrayList<>();

    public Estoque() {
    }
    public void addItem(ItemEstoque Item) {
        listaEstoque.add(Item);
    }
    public void removeItem(ItemEstoque Item){
        listaEstoque.remove(Item);
    }
    public void addLocal(String local){
        listaLocalizacao.add(local);
    }
    public void removeLocal(String local){
        listaLocalizacao.remove(local);
    }
    public int totalExemplares(){
        return listaEstoque.size();
    }
    //public itemEstoque buscarPorTitulo(Sting Nome) fazer quando tiver acervo

    public void ordenar(){
        listaEstoque.sort(null);
    }
    public List<ItemEstoque> getItens() {
        return listaEstoque;
    }
    
}
