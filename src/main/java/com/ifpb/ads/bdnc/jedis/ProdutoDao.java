package com.ifpb.ads.bdnc.jedis;

import com.ifpb.ads.bdnc.banco.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 27/07/2017 , 09:05:37
 */
public class ProdutoDao {

    private final ConexaoBD conex = new ConexaoBD();

    private final Connection connection;

    public ProdutoDao() {
        connection = conex.getConnection();
    }

    public boolean salvar(Produto produto) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT into produto(descricao,preco)VALUES (?,?)");
            prepareStatement.setString(1, produto.getDescrição());
            prepareStatement.setDouble(2, produto.getPreco());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean remover(Produto produto) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM produto WHERE codigo=?");
            prepareStatement.setInt(1, produto.getCodigo());
            prepareStatement.execute();
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     public boolean atualizar(Produto produto) {
          try {
            PreparedStatement prepareStatement = connection.prepareStatement("UPDATE produto set descricao=?, preco=? WHERE codigo=?");
            prepareStatement.setString(1, produto.getDescrição());
            prepareStatement.setDouble(2, produto.getPreco());
            prepareStatement.setInt(3, produto.getCodigo());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public List<Produto> todosOsProdutos() {
        try {
            List<Produto> produtos = new ArrayList<>();

            ResultSet result = consultarTodosOsProdutos();

            while (result.next()) {
               produtos.add(criarAutor(result));
            }
            return produtos;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    private ResultSet consultarTodosOsProdutos() throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("Select * from produto");
        ResultSet result = prepareStatement.executeQuery();
        return result;
    }
    
    private Produto criarAutor(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        String cpf=result.getString("cpf");
        String email=result.getString("email");
        return new Produto();
    }
}


