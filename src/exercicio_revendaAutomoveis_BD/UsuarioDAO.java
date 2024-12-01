package exercicio_revendaAutomoveis_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() {
        this.conexao = Conexao.getConexao();
    }

   
    public LinkedList<String> listarNomesUsuarios() {
        String sql = "SELECT nome FROM usuario";
        LinkedList<String> nomes = new LinkedList<>();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }
            ps.close();
            rs.close();
            return nomes;
        } catch (SQLException e) {
            System.out.println("Erro ao listar nomes de usuários: " + e.getMessage());
            return null;
        }
    }


    public boolean inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, telefone, senha) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getTelefone());
            ps.setString(4, usuario.getSenha());
            boolean retorno = ps.execute();
            ps.close();
            return retorno;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
            return false;
        }
    }

   
    public Usuario consultarPorNome(String nome) {
        String sql = "SELECT * FROM usuario WHERE nome = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("senha")
                );
                usuario.setId(rs.getInt("id"));
                return usuario;
            }
            ps.close();
            return null;
        } catch (SQLException e) {
            System.out.println("Erro ao consultar usuário por nome: " + e.getMessage());
            return null;
        }
    }

    
    public LinkedList<Usuario> listar() {
        String sql = "SELECT * FROM usuario";
        LinkedList<Usuario> usuarios = new LinkedList<>();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("senha")
                );
                usuario.setId(rs.getInt("id"));
                usuarios.add(usuario);
            }
            ps.close();
            return usuarios;
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
            return null;
        }
    }
}
