package kindle.entidades;

public abstract class Pessoa {
	
	private String nome;
	private String email;
	
	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}	
}