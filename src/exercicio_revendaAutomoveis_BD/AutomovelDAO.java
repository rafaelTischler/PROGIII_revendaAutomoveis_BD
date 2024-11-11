package exercicio_revendaAutomoveis_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class AutomovelDAO {
	
	private Connection conexao;

	public AutomovelDAO() {
		this.conexao = Conexao.getConexao();
	}
	
	public LinkedList<String> listarNomes(){
		String sql = "select nome from automovel";
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
			System.out.println("Erro ao consultar Automoveis");
			return null;
		}
		
	}
	
	public boolean inserir(Automovel A) {
		
		String sql = "insert into automovel (marca, modelo, ano, cor, combustivel) values (?, ?, ?, ?, ?)";		
		
		try {
			PreparedStatement ps = (PreparedStatement)
					conexao.prepareStatement(sql);
			ps.setString(1, A.getMarca());
			ps.setString(2, A.getModelo());
			ps.setString(3, A.getAno());
			ps.setString(4, A.getCor());
			ps.setString(5, A.getCombustivel());
			boolean retorno = ps.execute();				
			ps.close();
			return retorno;
		} catch (SQLException e) {
			System.out.println("Erro ao Inserir Automoveis");
			return false;
		}
		
	}
	
	
	public Automovel consultarMarca(String marca){
		String sql = "select * from automovel where marca = ?";		
		try {
			PreparedStatement ps = (PreparedStatement) 
					conexao.prepareStatement(sql);
			ps.setString(1, marca);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Automovel A = new Automovel(rs.getString("marca"),rs.getString("modelo"),rs.getString("ano"), rs.getString("cor"), rs.getString("combustivel"));
				A.setId(rs.getInt("id"));
				return A;
			}		
			ps.close();
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao consultar Automoveis");
			return null;
		}
		
	}
	
	
	public LinkedList<Automovel> listar(){
		String sql = "select * from automovel";
		LinkedList<Automovel> lista = new LinkedList<Automovel>();
		try {
			PreparedStatement ps = (PreparedStatement) 
					conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Automovel A =new Automovel(rs.getString("marca"),rs.getString("modelo"),rs.getString("ano"), rs.getString("cor"), rs.getString("combustivel"));
				A.setId(rs.getInt("id"));
				lista.add(A);
			}		
			ps.close();
			return lista;
		} catch (SQLException e) {
			System.out.println("Erro ao consultar Automoveis");
			return null;
		}
		
	}
	
	
}
