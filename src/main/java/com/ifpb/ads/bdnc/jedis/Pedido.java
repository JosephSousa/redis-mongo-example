package com.ifpb.ads.bdnc.jedis;

import java.time.LocalDate;
import org.bson.Document;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 15/08/2017 , 13:21:40
 */
public class Pedido {
    
    private CarrinhoCompras carrinho;
    private int id=1;
    private LocalDate date;

    public Pedido(CarrinhoCompras carrinho, int id, LocalDate date) {
        this.carrinho = carrinho;
        this.id = id;
        this.date = LocalDate.now();
    }

    public Pedido() {
        this.date = LocalDate.now();
    }

    public CarrinhoCompras getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoCompras carrinho) {
        this.carrinho = carrinho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Document toDocument() {
        Document doc = new Document()
                .append("_id", id)
                .append("data", date.toString())
                .append("carrinho", carrinho.toString());
        return doc;
    }

    public Pedido fromDocument(Document doc) {
        id = doc.getInteger("_id");
        date = (LocalDate) doc.get("data");
        carrinho = doc.get("carrinho",CarrinhoCompras.class);
        return this;
    }
    @Override
    public String toString() {
        return "Pedido{" + "carrinho=" + carrinho + ", id=" + id + ", date=" + date + '}';
    }
}
