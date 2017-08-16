package com.ifpb.ads.bdnc.banco;

import com.ifpb.ads.bdnc.jedis.Pedido;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 16/08/2017 , 13:22:45
 */
public class MongoClient {

    public MongoClient() {
    }
    
   public void adiciona(Pedido p) {
        com.mongodb.MongoClient client= new com.mongodb.MongoClient("localhost", 27017);
        
        MongoDatabase database = client.getDatabase("pedido");
        MongoCollection<Document> colecao= database.getCollection("pedido");
        colecao.insertOne(p.toDocument());
        
        Block<Document> printBlock = (final Document document)->{
            Pedido pedido= new Pedido().fromDocument(document);
            System.out.println(pedido);
        };
        
        colecao.find(new Document("id",0))
                .forEach(printBlock);
        client.close();
    }
}
