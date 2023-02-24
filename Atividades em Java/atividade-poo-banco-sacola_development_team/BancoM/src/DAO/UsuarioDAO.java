package DAO;

import Entidades.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    Connection conn;

    public ResultSet autenticarUsuario(Usuario objUsuario) {
        conn = new ConexaoDAO().conectarBD();

        try {

            String sql = "Select * from usuarios where nome_usuario = ? and senha_usuario = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsuario.getNomeUsuario());
            pstm.setString(2, objUsuario.getSenhaUsuario());


            return pstm.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO - Erro ao autenticar usuário: "
                    + e.getMessage());
            return null;
        }
    }
}
