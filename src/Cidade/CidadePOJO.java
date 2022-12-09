package Cidade;

public class CidadePOJO {
//	2. Represente a tabela cidade(ddd*, nome, nro_habitantes, renda_per_capita, capital**, 
//			estado, nome_prefeito) com um POJO. 
//			*PK 
//			**capital é um booleano.
	
	private int ddd;
	private String nome;
	private int nro_habitantes;
	private float renda_per_capita;
	private boolean capital;
	
	public CidadePOJO(int ddd, String nome, int nro_habitantes, float renda_per_capita, boolean capital) {
		this.ddd = ddd;
		this.nome = nome;
		this.nro_habitantes = nro_habitantes;
		this.renda_per_capita = renda_per_capita;
		this.capital = capital;
	}

	public CidadePOJO() {
	}

	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNro_habitantes() {
		return nro_habitantes;
	}
	public void setNro_habitantes(int nro_habitantes) {
		this.nro_habitantes = nro_habitantes;
	}
	public float getRenda_per_capita() {
		return renda_per_capita;
	}
	public void setRenda_per_capita(float renda_per_capita) {
		this.renda_per_capita = renda_per_capita;
	}
	public boolean isCapital() {
		return capital;
	}
	public void setCapital(boolean capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return ddd + " | " + nome + " | " + nro_habitantes + " | " + renda_per_capita + " | " + capital + "\n";
	}
	
}
