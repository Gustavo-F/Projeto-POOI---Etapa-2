package kindle.entidades;

public class Editora extends Pessoa {
	
	private String cnpj;
	
	public Editora(String nome, String email, String cnpj) {
		super(nome, email);
		this.cnpj = cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
}
