package com.ifpb.ads.bdnc.jedis;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 26/07/2017 , 13:35:13
 */
public class CarrinhoCompras {

    private int id;
    private List<ItemCarrinho> itens;
    private double total = 0;

    public int getId() {
        return id;
    }

    public void setId() {
        this.id ++;
    }
    
    public CarrinhoCompras() {
        itens= new ArrayList<>();
    }
    
    public void adicionarItens(ItemCarrinho item){
        itens.add(item);
        System.out.println(itens);
    }
    
    public double calcularTotal(){
        total = 0d;
        for (ItemCarrinho venda : itens) {
            total = total + venda.getSubTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Carrinho:" + "id=" + id + ", itens=" + itens + ", total=" + total;
    }
    
    
}
