package exercicio_revendaAutomoveis_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class FuncionarioDAO {
	
	private Connection conexao;

	public FuncionarioDAO() {
		this.conexao = Conexao.getConexao();
	}
	
	public LinkedList<String> listarNomes(){
		String sql = "select nome from funcionario";
		LinkedList<String> nomes = new LinkedList<String>();
		try {
			PreparedStatement ps = (PreparedStatement) 
					conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			
			while(rs.next()) {				
				nomes.add(rs.getString("nome"));
			}		
			ps.close();
			rs.close();
			return nomes;
		} catch (SQLException e) {
			System.out.println("Erro ao consultar Funcion�rios");
			return null;
		}
		
	}
	
	public boolean inserir(Funcionario f) {
		
		String sql = "insert into funcionario (nome, email, cargo) values (?, ?, ?)";		
		
		try {
			PreparedStatement ps = (PreparedStatement)
					conexao.prepareStatement(sql);
			ps.setString(1, f.getNome());
			ps.setString(2, f.getEmail());
			ps.setString(3, f.getCargo());
			boolean retorno = ps.execute();				
			ps.close();
			return retorno;
		} catch (SQLException e) {
			System.out.println("Erro ao Inserir Funcion�rios");
			return false;
		}
		
	}
	
	
	public Funcionario consultarNome(String nome){
		String sql = "select * from funcionario where nome = ?";		
		try {
			PreparedStatement ps = (PreparedStatement) 
					conexao.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Funcionario f = new Funcionario(rs.getString("nome"),
						rs.getString("email"),rs.getString("cargo"));
				f.setId(rs.getInt("id"));
				return f;
			}		
			ps.close();
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao consultar Funcion�rios");
			return null;
		}
		
	}
	
	
	public LinkedList<Funcionario> listar(){
		String sql = "select * from funcionario";
		LinkedList<Funcionario> lista = new LinkedList<Funcionario>();
		try {
			PreparedStatement ps = (PreparedStatement) 
					conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Funcionario f = new Funcionario(rs.getString("nome"),
						rs.getString("email"),rs.getString("cargo"));
				f.setId(rs.getInt("id"));
				lista.add(f);
			}		
			ps.close();
			return lista;
		} catch (SQLException e) {
			System.out.println("Erro ao consultar Funcion�rios");
			return null;
		}
		
	}
	
	
}
