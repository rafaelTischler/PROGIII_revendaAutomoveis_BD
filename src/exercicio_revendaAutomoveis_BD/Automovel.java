package exercicio_revendaAutomoveis_BD;


public class Automovel {
	
	private int id;
	private String marca;
	private String modelo;
	private String ano;
	private String cor;
	private String combustivel;
	
	public Automovel() {
		
	}
	
	public Automovel(String marca, String modelo, String ano, String cor, String combustivel) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.combustivel = combustivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String toString() {
		return "ID: " + this.id + "\nNOME: " + this.marca +
				"\nEMAIL: " + this.modelo + "\nCARGO: " +
				this.ano +"\n\n";
	}
	

}
