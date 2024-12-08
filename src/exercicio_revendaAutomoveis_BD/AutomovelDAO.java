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

	public LinkedList<String> listarMarcas() {
		String sql = "SELECT DISTINCT marca FROM automovel";
		LinkedList<String> marcas = new LinkedList<String>();
		try {
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				marcas.add(rs.getString("marca"));
			}
			ps.close();
			rs.close();
			return marcas;
		} catch (SQLException e) {
			return null;
		}
	}

	public LinkedList<String> listarModelos() {
		String sql = "SELECT DISTINCT modelo FROM automovel";
		LinkedList<String> modelos = new LinkedList<String>();
		try {
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				modelos.add(rs.getString("modelo"));
			}
			ps.close();
			rs.close();
			return modelos;
		} catch (SQLException e) {
			return null;
		}
	}

	public LinkedList<String> listarAnos() {
		LinkedList<String> anos = new LinkedList<>();
		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = Conexao.getConexao();
			String sql = "SELECT DISTINCT ano FROM automovel ORDER BY ano";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				anos.add(rs.getString("ano"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conexao != null)
					conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return anos;
	}

	public boolean inserir(Automovel A) {
		String sql = "INSERT INTO automovel (marca, modelo, ano, cor, combustivel) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
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

	public Automovel consultarMarca(String marca) {
		String sql = "SELECT * FROM automovel WHERE marca = ?";
		try {
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
			ps.setString(1, marca);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Automovel A = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getString("ano"),
						rs.getString("cor"), rs.getString("combustivel"));
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

			while (rs.next()) {
				Automovel A = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getString("ano"),
						rs.getString("cor"), rs.getString("combustivel"));
				lista.add(A);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public LinkedList<Automovel> listar() {
		String sql = "SELECT * FROM automovel";
		LinkedList<Automovel> lista = new LinkedList<Automovel>();
		try {
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Automovel A = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getString("ano"),
						rs.getString("cor"), rs.getString("combustivel"));
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

	public Automovel buscarPorId(int id) {
		String sql = "SELECT * FROM automovel WHERE id = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Automovel automovel = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getString("ano"),
						rs.getString("cor"), rs.getString("combustivel"));
				automovel.setId(rs.getInt("id"));
				return automovel;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean atualizar(Automovel automovel) {
		String sql = "UPDATE automovel SET marca = ?, modelo = ?, ano = ?, cor = ?, combustivel = ? WHERE id = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, automovel.getMarca());
			stmt.setString(2, automovel.getModelo());
			stmt.setString(3, automovel.getAno());
			stmt.setString(4, automovel.getCor());
			stmt.setString(5, automovel.getCombustivel());
			stmt.setInt(6, automovel.getId());

			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean remover(String id) {
		String sql = "DELETE FROM automovel WHERE id = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setInt(1, Integer.parseInt(id));

			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
