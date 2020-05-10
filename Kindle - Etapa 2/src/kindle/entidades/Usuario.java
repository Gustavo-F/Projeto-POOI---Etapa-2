package kindle.entidades;

public abstract class Usuario extends Pessoa {

	private String tipoDeConta; //Define se é uma conta de um ADM ou Cliente
	protected String login;
	protected String senha;
	
	public Usuario(String nome, String email, String tipoDeConta, String login, String senha) {
		super(nome, email);
		this.tipoDeConta = tipoDeConta;
		this.login = login;
		this.senha = senha;
	}
	
	public String getTipoDeConta() {
		return tipoDeConta;
	}
	
	public String getLogin() {
		return login;
	}
	
	public abstract boolean verificaUsuario(String login, String senha);
	
}
