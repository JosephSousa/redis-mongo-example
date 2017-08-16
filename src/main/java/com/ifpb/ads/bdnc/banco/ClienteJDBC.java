package com.ifpb.ads.bdnc.banco;

import com.ifpb.ads.bdnc.jedis.Cliente;
import com.ifpb.ads.bdnc.jedis.Produto;
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
 * @since 15/08/2017 , 13:25:39
 */
public class ClienteJDBC {

    private final ConexaoBD conex = new ConexaoBD();

    private final Connection connection;
    
     public ClienteJDBC() {
        connection = conex.getConnection();
    }
     
     public boolean salvar(Cliente cliente) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT into cliente(nome,email)VALUES (?,?)");
            prepareStatement.setString(1, cliente.getNome());
            prepareStatement.setString(2, cliente.getEmail());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean remover(Cliente cliente) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM cliente WHERE id=?");
            prepareStatement.setInt(1, cliente.getId());
            prepareStatement.execute();
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean atualizar(Cliente cliente) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("UPDATE cliente set nome=?, email=? WHERE id=?");
            prepareStatement.setString(1, cliente.getNome());
            prepareStatement.setString(2, cliente.getEmail());
            prepareStatement.setInt(3, cliente.getId());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Cliente> todosOsProdutos() {
        try {
            List<Cliente> clientes = new ArrayList<>();

            ResultSet result = consultarTodosOsClientes();

            while (result.next()) {
                clientes.add(criarCliente(result));
            }
            return clientes;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    private ResultSet consultarTodosOsClientes() throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("Select * from cliente");
        ResultSet result = prepareStatement.executeQuery();
        return result;
    }

    private Cliente criarCliente(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        String email = result.getString("email");
        return new Cliente(id, nome, email);
    }
}
