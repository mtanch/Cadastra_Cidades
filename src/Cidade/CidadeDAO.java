package Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
	private Connection conexao;

	public CidadeDAO() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	public boolean insereCidade(CidadePOJO cidade) {
		String sql = "INSERT INTO cidade (ddd, nome, nro_habitantes, renda_per_capita, capital) VALUES (?, ?, ?, ?, ?);";

		try {
			PreparedStatement state = this.conexao.prepareStatement(sql);
			state.setInt(1, cidade.getDdd());
			state.setString(2, cidade.getNome());
			state.setInt(3, cidade.getNro_habitantes());
			state.setFloat(4, cidade.getRenda_per_capita());
			state.setBoolean(5, cidade.isCapital());
			state.execute();
			state.close();
			System.out.println("\n[Dados enviados]\n");
			return true;
		} catch (SQLException e) {
			System.err.println("\nErro");
			return false;
		}
		
	}
	
	public boolean removeCidade(int ddd) {
		String sql = "DELETE FROM cidade WHERE ddd = " + ddd + ";";
		try {
			PreparedStatement state = this.conexao.prepareStatement(sql);
			state.execute();
			state.close();
			System.out.println("\n[Cidade removida]\n");
			return true;
		} catch (SQLException e) {
			System.err.println("\nErro na remoção");
			return false;
		}
	}
	
	public List<CidadePOJO> listarTodasAsCidades() {
		
		List<CidadePOJO> cidades = new ArrayList<>();
		
		String sql = "SELECT * FROM cidade";
		
		try {
			PreparedStatement state = conexao.prepareStatement(sql);
			
			ResultSet result = state.executeQuery();
			
			while (result.next()) {
				CidadePOJO cidade = new CidadePOJO();
				
				cidade.setDdd(result.getInt("ddd"));
				cidade.setNome(result.getString("nome"));
				cidade.setNro_habitantes(result.getInt("nro_habitantes"));
				cidade.setRenda_per_capita(result.getFloat("renda_per_capita"));
				cidade.setCapital(result.getBoolean("capital"));
				
				cidades.add(cidade);
			}
			
			state.close();
		} catch (SQLException e) {
			System.err.println("\nErro ao listar cidades");
			e.printStackTrace();
		}
		return cidades;
	}
	
	public List<CidadePOJO> buscarPorDdd(int ddd) {
		List<CidadePOJO> cidades = new ArrayList<>();
		
		String sql = "SELECT * FROM cidade WHERE ddd = ?";
		
		try {
			PreparedStatement state = conexao.prepareStatement(sql);
			
			state.setInt(1, ddd);
			
			ResultSet result = state.executeQuery();
			
			result.next();
			
			CidadePOJO cidade = new CidadePOJO();
			
			cidade.setDdd(result.getInt("ddd"));
			cidade.setNome(result.getString("nome"));
			cidade.setNro_habitantes(result.getInt("nro_habitantes"));
			cidade.setRenda_per_capita(result.getFloat("renda_per_capita"));
			cidade.setCapital(result.getBoolean("capital"));
			
			cidades.add(cidade);
				
			state.close();
		} catch (SQLException e) {
			System.err.println("\nErro na busca por cidade");
			e.printStackTrace();
		}
		return cidades;
	}
	
	public List<CidadePOJO> buscarPorNome(String palavra) {
		List<CidadePOJO> cidades = new ArrayList<>();
		
		String sql = "SELECT * FROM cidade WHERE nome LIKE '" + palavra + "%';";
		System.out.println(sql);
		try {
			PreparedStatement state = conexao.prepareStatement(sql);
			
			ResultSet result = state.executeQuery();
			
			while (result.next()) {
				CidadePOJO cidade = new CidadePOJO();
				
				cidade.setDdd(result.getInt("ddd"));
				cidade.setNome(result.getString("nome"));
				cidade.setNro_habitantes(result.getInt("nro_habitantes"));
				cidade.setRenda_per_capita(result.getFloat("renda_per_capita"));
				cidade.setCapital(result.getBoolean("capital"));
				
				cidades.add(cidade);
			}
		
			state.close();
		} catch (SQLException e) {
			System.err.println("\nErro na busca por cidade");
			e.printStackTrace();
		}
		return cidades;
	}
	
}
