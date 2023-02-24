package DAO;

import Entidades.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends Cliente {
    public int checagemDeSucesso = 0;
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    public void cadastrarCliente(Cliente cliente) {
        // Conexão com o banco de dados
        String sql = "INSERT INTO clientes (nome_Cliente, cpf_Cliente, data_Nascimento) values (?, ?, ?)";
        String sql2 = "INSERT INTO usuarios (nome_Usuario, senha_Usuario, cod_Cliente) values (?, ?, ?)";
        String sql3 = "INSERT INTO endereco (logradouro, numero, cep, bairro, cidade, uf, cod_Cliente) values (?, ?, ?, ?, ?, ?, ?)";
        String sql4 = "select id_Clientes from clientes where cpf_Cliente = ?";

        conn = new ConexaoDAO().conectarBD();

        try {
            // Inserindo dados na tabela clientes
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cliente.getNomeClient());
            pstmt.setString(2, cliente.getCpfCliente());
            pstmt.setString(3, cliente.getDataNascimentoCliente());

            pstmt.execute();
            pstmt.close();

            // Pegando o id do cliente cadastrado
            pstmt = conn.prepareStatement(sql4);
            pstmt.setString(1, cliente.getCpfCliente());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                setIdCliente(rs.getInt("id_Clientes"));
            }

            // Inserindo dados na tabela usuários
            pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1, cliente.getUsuarioCliente().getNomeUsuario());
            pstmt.setString(2, cliente.getUsuarioCliente().getSenhaUsuario());
            pstmt.setInt(3, getIdCliente());


            pstmt.execute();
            pstmt.close();

            // Inserindo dados na tabela endereços
            pstmt = conn.prepareStatement(sql3);
            pstmt.setString(1, cliente.getEnderecoCliente().logradouro());
            pstmt.setInt(2, cliente.getEnderecoCliente().numero());
            pstmt.setString(3, cliente.getEnderecoCliente().cep());
            pstmt.setString(4, cliente.getEnderecoCliente().bairro());
            pstmt.setString(5, cliente.getEnderecoCliente().cidade());
            pstmt.setString(6, cliente.getEnderecoCliente().uf());
            pstmt.setInt(7, getIdCliente());

            pstmt.execute();
            pstmt.close();

            // Inserindo dados na tabela contas
            ContaDAO contaDAO = new ContaDAO();
            contaDAO.cadastrarConta(getIdCliente());

            checagemDeSucesso = 1; // Se chegar até aqui, o cadastro foi bem sucedido
        } catch (SQLException erro) {
            if (erro.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "CPF ou Apelido já cadastrado!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + erro.getMessage());
            }
        }
    }
}
