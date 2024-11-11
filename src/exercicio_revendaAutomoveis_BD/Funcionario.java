package exercicio_revendaAutomoveis_BD;


public class Funcionario {
	
	private int id;
	private String nome;
	private String email;
	private String cargo;
	
	public Funcionario() { }
	
	public Funcionario(String nome, String email, String cargo) {	
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String toString() {
		return "ID: " + this.id + "\nNOME: " + this.nome +
				"\nEMAIL: " + this.email + "\nCARGO: " +
				this.cargo +"\n\n";
	}
	

}
