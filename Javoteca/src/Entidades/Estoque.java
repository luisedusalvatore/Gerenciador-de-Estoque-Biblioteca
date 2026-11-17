package Entidades;

import java.util.List;
import java.util.ArrayList;

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
    
}
