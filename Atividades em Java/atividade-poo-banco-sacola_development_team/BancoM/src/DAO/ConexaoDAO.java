package DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    public Connection conectarBD() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://bancomaut-rds-mysql.c0z9tie9fbsp.sa-east-1.rds.amazonaws.com:3306/bancomaut?useSSL=false", "masterAdmin", "Postedeenergia3");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados: " + e.getMessage());
        }
        return conn;
    }
}
