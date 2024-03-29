package org.example.Dao.UsuariosDAO;

import org.example.Entities.Usuarios.Endereco;
import org.example.Entities.Usuarios.Logins;
import org.example.Entities.Usuarios.Telefone;
import org.example.Entities.Usuarios.Usuario;
import org.example.Infra.ConnectionFactory;
import org.example.View.FuncionarioForm;
import org.example.View.UserForm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO {
    public static String tipoDeUsuarioGlobal;
    public static Long idUsuarioGlobal;

    public String getTipoDeUsuarioGlobal() {
        return tipoDeUsuarioGlobal;
    }


    public void saveUsuario(Usuario usuario) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO usuarios (nome, cpf, dataDeNascimento, email, tipoDeUsuario) VALUES (?, ?, ?, ?, ?)";

            assert connection != null;

            // Inserindo o Usuario

            PreparedStatement pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCpf());
            pstm.setDate(3, new java.sql.Date(usuario.getDataDeNascimento().getTime()));
            pstm.setString(4, usuario.getEmail());
            pstm.setString(5, usuario.getTipoDeUsuario());
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            rs.next();
            usuario.setIdUsuario(rs.getLong(1));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateUsuario(Usuario usuario) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE usuarios SET nome = ?, cpf = ?, dataDeNascimento = ?, email = ?, tipoDeUsuario = ? WHERE idUsuario = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCpf());
            pstm.setDate(3, new java.sql.Date(usuario.getDataDeNascimento().getTime()));
            pstm.setString(4, usuario.getEmail());
            pstm.setString(5, usuario.getTipoDeUsuario());
            pstm.setLong(6, usuario.getIdUsuario());

            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteUsuario(Long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM usuarios WHERE idUsuario = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, id);

            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> findAllUsuarios() {
        String sql = "SELECT * FROM usuarios";
        try (Connection connection = ConnectionFactory.getConnection()) {
            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                Long idUsuario = rs.getLong("idUsuario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date dataDeNascimento = rs.getDate("dataDeNascimento");
                String email = rs.getString("email");
                String tipoDeUsuario = rs.getString("tipoDeUsuario");

                Usuario usuario = new Usuario(idUsuario, nome, cpf, dataDeNascimento, email, tipoDeUsuario);
                usuarios.add(usuario);

            }
            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Usuario> findUsuarioById(Long id) {
        Usuario usuario = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE idUsuario = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Long idUsuario = rs.getLong("idUsuario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date dataDeNascimento = rs.getDate("dataDeNascimento");
                String email = rs.getString("email");
                String tipoDeUsuario = rs.getString("tipoDeUsuario");

                usuario = new Usuario(idUsuario, nome, cpf, dataDeNascimento, email, tipoDeUsuario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(usuario);
    }


    public void saveEndereco(Endereco endereco, Long idUsuario) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO enderecos (rua, num, bairro, cidade, estado, cep, idUsuario) VALUES (?, ?, ?, ?, ?, ?, ?)";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, endereco.rua());
            pstm.setString(2, endereco.numero());
            pstm.setString(3, endereco.bairro());
            pstm.setString(4, endereco.cidade());
            pstm.setString(5, endereco.estado());
            pstm.setString(6, endereco.cep());
            pstm.setLong(7, idUsuario);
            pstm.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEndereco(Endereco endereco, Long idUsuario) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE enderecos SET rua = ?, num = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE idUsuario = ?";
            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, endereco.rua());
            pstm.setString(2, endereco.numero());
            pstm.setString(3, endereco.bairro());
            pstm.setString(4, endereco.cidade());
            pstm.setString(5, endereco.estado());
            pstm.setString(6, endereco.cep());
            pstm.setLong(7, idUsuario);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Optional<Endereco> FindEnderecoByIdUsuario(Long idUsuario) {
        Endereco endereco = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM enderecos WHERE idUsuario = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, idUsuario);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Long idEndereco = rs.getLong("idEndereco");
                String rua = rs.getString("rua");
                String num = rs.getString("num");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String cep = rs.getString("cep");

                endereco = new Endereco(idEndereco, rua, num, bairro, cidade, estado, cep);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(endereco);
    }


    public void saveTelefone(Telefone telefone, Long idUsuario) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO telefones (idUsuario, numero) VALUES (?, ?)";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, idUsuario);
            pstm.setString(2, telefone.numero());
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateTelefone(Telefone telefone, Long idUsuario) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE telefones SET numero = ? WHERE idUsuario = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, telefone.numero());
            pstm.setLong(2, idUsuario);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Optional<Telefone> FindTelefoneByIdUsuario(Long idUsuario) {
        Telefone telefone = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM telefones WHERE idUsuario = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, idUsuario);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String numero = rs.getString("numero");

                telefone = new Telefone(numero);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(telefone);
    }

    // Métodos para o login

    public void CriarLogin(Usuario Idusuario, String usuario, String senha) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO logins (idUsuario, usuario, senha) VALUES (?, ?, ?)";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, Idusuario.getIdUsuario());
            pstm.setString(2, usuario);
            pstm.setString(3, senha);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateLogin(Long Idusuario, String usuario, String senha) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE logins SET usuario = ?, senha = ? WHERE idUsuario = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, senha);
            pstm.setLong(3, Idusuario);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet autenticarUsuario(String usuario, String senha) {
        ResultSet rs;
        Connection connection = ConnectionFactory.getConnection();
        try {
            String sql = "SELECT * FROM logins WHERE usuario = ? AND senha = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, senha);

            rs = pstm.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public void RealizarLogin(Long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE idUsuario = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                idUsuarioGlobal = rs.getLong("idUsuario");
                String tipoDeUsuario = rs.getString("tipoDeUsuario");
                switch (tipoDeUsuario) {
                    case "Funcionario" -> {
                        tipoDeUsuarioGlobal = "Funcionario";
                        FuncionarioForm funcionarioForm = new FuncionarioForm(null);
                        funcionarioForm.setVisible(true);
                    }
                    case "Professor" -> {
                        tipoDeUsuarioGlobal = "Professor";
                        UserForm userForm = new UserForm(null);
                        userForm.setVisible(true);
                    }
                    case "Aluno" -> {
                        tipoDeUsuarioGlobal = "Aluno";
                        UserForm userForm1 = new UserForm(null);
                        userForm1.setVisible(true);
                    }
                    case "Usuário Comum" -> {
                        tipoDeUsuarioGlobal = "Usuário Comum";
                        UserForm userForm2 = new UserForm(null);
                        userForm2.setVisible(true);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Logins> FindLoginByIdUsuario(Long idUsuario) {
        Logins login = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM logins WHERE idUsuario = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, idUsuario);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");

                login = new Logins(usuario, senha);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(login);
    }


    // Alteração geral do usuário

    public void alterarUsuario(Usuario ObjUsuario, Endereco ObjEndereco, Telefone ObjTelefone, long idUsuario) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE usuarios SET nome = ?, cpf = ?, dataDeNascimento = ?, tipoDeUsuario = ? WHERE idUsuario = ?";
            String sql2 = "UPDATE enderecos SET rua = ?, num = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE idUsuario = ?";
            String sql3 = "UPDATE telefones SET numero = ? WHERE idUsuario = ?";

            assert connection != null;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, ObjUsuario.getNome());
            pstm.setString(2, ObjUsuario.getCpf());
            pstm.setDate(3, ObjUsuario.getDataDeNascimento());
            pstm.setString(4, ObjUsuario.getTipoDeUsuario());
            pstm.setLong(5, idUsuario);
            pstm.executeUpdate();

            PreparedStatement pstm2 = connection.prepareStatement(sql2);
            pstm2.setString(1, ObjEndereco.rua());
            pstm2.setString(2, ObjEndereco.numero());
            pstm2.setString(3, ObjEndereco.bairro());
            pstm2.setString(4, ObjEndereco.cidade());
            pstm2.setString(5, ObjEndereco.estado());
            pstm2.setString(6, ObjEndereco.cep());
            pstm2.setLong(7, idUsuario);
            pstm2.executeUpdate();

            PreparedStatement pstm3 = connection.prepareStatement(sql3);
            pstm3.setString(1, ObjTelefone.numero());
            pstm3.setLong(2, idUsuario);
            pstm3.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

