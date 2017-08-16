package com.ifpb.ads.bdnc.jedis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 25/07/2017 , 14:25:59
 */
public class App {

    public static void main(String[] args) {
//        Gson gson= new Gson();
//        
//        Jedis jedis= new Jedis("127.0.0.1", 6379);
//      
//        Pessoa a= new Pessoa(1,22,"Joseph");
//       
//        System.out.println(gson.toJson(a));
//        
//        String json=gson.toJson(a);
//       
//        jedis.set(""+a.getId(), json);
//        
//        Pessoa b= gson.fromJson(jedis.get("1"),Pessoa.class);
//        
//        jedis.del("1");
//        
//        System.out.println(b);
        
//          Gson gson=new Gson();
//          
//          Jedis jedis= new Jedis("127.0.0.1", 6379);
//          
          Produto p= new Produto();
          
          p.setCodigo(1);
          
          p.setDescrição("coca cola");
          
          p.setPreco(4);
          
          ItemCarrinho item= new ItemCarrinho();
          
          item.setProduto(p);
          
          item.setQuantidade(2);
          
          CarrinhoCompras carrinho = new CarrinhoCompras();
          
          carrinho.adicionarItens(item);
          
          carrinho.calcularTotal();
          
          Pedido pedido = new Pedido();
          
          pedido.setCarrinho(carrinho);
          
          pedido.setId(1);
          
          System.out.println(pedido);
          
    }
}
