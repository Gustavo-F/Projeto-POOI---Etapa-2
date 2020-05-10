package kindle.entidades;

public class Cliente extends Usuario{
	
	private Biblioteca biblioteca;

	public Cliente(String nome, String email, String login, String senha, Biblioteca biblioteca) {
		super(nome, email, "Cliente", login, senha);
		this.setBiblioteca(biblioteca);
	}
	
	public Cliente(String nome, String login, String senha, Biblioteca biblioteca) {
		super(nome, null, "Cliente", login, senha);
		this.biblioteca = biblioteca;
	}
	
	public void setLogin(String login) {
		if(login.length() < 6) {
			System.out.println("A login deve ter no minímo 6 caracteres.");
			return;
		}
		this.login = login;
	}
	
	public void setSenha(String senha) {
		if(senha.length() < 6){
			System.out.println("A senha deve ter no minímo 6 caracteres.");
			return;
		}
		this.senha = senha;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	@Override
	public boolean verificaUsuario(String login, String senha) {
		if(this.login.equals(login) && this.senha.equals(senha) && this.getTipoDeConta().equals("Cliente"))
			return true;
		
		return false;
	}
	
}
