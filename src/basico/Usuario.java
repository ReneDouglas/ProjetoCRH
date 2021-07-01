package basico;

public class Usuario {

	private int idUsuario;
	private String login;
	private String senha;
	
	public Usuario(int idUsuario, String login, String senha) {
		
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
