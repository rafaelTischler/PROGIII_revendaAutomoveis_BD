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
	
	public LinkedList<String> listarMarcas(){
		String sql = "SELECT DISTINCT marca FROM automovel";
		LinkedList<String> marcas = new LinkedList<String>();
		try {
			PreparedStatement ps = (PreparedStatement) 
					conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			
			while(rs.next()) {			
				System.out.println("marca: " + marcas);
				marcas.add(rs.getString("marca"));
			}		
			ps.close();
			rs.close();
			return marcas;
		} catch (SQLException e) {
			System.out.println("Erro ao consultar automoveis");
			return null;
		}
		
	}
	
	public boolean inserir(Automovel A) {
		
		String sql = "INSERT INTO automovel (marca, modelo, ano, cor, combustivel) VALUES (?, ?, ?, ?, ?)";		
		
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
			System.out.println("Erro ao Inserir automoveis");
			return false;
		}
		
	}
	
	
	public Automovel consultarMarca(String marca){
		String sql = "SELECT * FROM automovel WHERE marca = ?";		
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
			System.out.println("Erro ao consultar automoveis");
			return null;
		}
		
	}
	
	public LinkedList<Automovel> consultarAutomoveis(String marca, String modelo, Integer ano) {
	    String sql = "SELECT * FROM automovel WHERE marca LIKE ? AND (modelo LIKE ? OR ? IS NULL) AND (ano = ? OR ? IS NULL)";
	    LinkedList<Automovel> lista = new LinkedList<>();
	    try {
	        PreparedStatement ps = conexao.prepareStatement(sql);
	        ps.setString(1, "%" + marca + "%");
	        ps.setString(2, "%" + modelo + "%");
	        ps.setObject(3, modelo.isEmpty() ? null : modelo);
	        ps.setObject(4, ano != null ? ano : null);
	        ps.setObject(5, ano);
	        ResultSet rs = ps.executeQuery();
	        
	        while(rs.next()) {
	            Automovel A = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getString("ano"), rs.getString("cor"), rs.getString("combustivel"));
	            lista.add(A);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return lista;
	}
	
	
	public LinkedList<Automovel> listar(){
		String sql = "SELECT * FROM automovel";
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
