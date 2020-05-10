package kindle.entidades;

public class Administrador extends Usuario {

	public Administrador(String nome, String email, String login, String senha) {
		super(nome, email, "ADM", login, senha);
	}
	
	public void setLogin(String login) {
		if(login.length() < 6) {
			System.out.println("A login deve ter no minímo 6 caracteres.");
			return;
		}
		this.login = login;
	}
	
	public int verificaLogin(String login) {
		if(this.login.equals(login)) {
			return 1;
		}
		return 0;
	}
	
	public void setSenha(String senha) {
		if(senha.length() < 6){
			System.out.println("A senha deve ter no minímo 6 caracteres.");
			return;
		}
		this.senha = senha;
	}

	@Override
	public boolean verificaUsuario(String login, String senha) {
		
		if(this.login.equals(login) && this.senha.equals(senha) && this.getTipoDeConta().equals("ADM"))
			return true;
		
		return false;
		
	}	
}
