package com.ifpb.ads.bdnc.jedis;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 26/07/2017 , 13:23:46
 */
public class Produto {
    private int codigo;
    private String descrição;
    private double preco;

    public Produto(int codigo, String descrição, double preco) {
        this.codigo = codigo;
        this.descrição = descrição;
        this.preco = preco;
    }

    public Produto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descri\u00e7\u00e3o=" + descrição + ", preco=" + preco + '}';
    }
}
