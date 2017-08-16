package com.ifpb.ads.bdnc.jedis;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 26/07/2017 , 13:29:17
 */
public class ItemCarrinho {

    private Produto produto;
    private int quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public double getSubTotal(){
        return quantidade*produto.getPreco();
    }

    @Override
    public String toString() {
        return "ItemCarrinho{" + "produto=" + produto + ", quantidade=" + quantidade + '}';
    }
}
