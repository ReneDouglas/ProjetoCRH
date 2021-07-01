package controle.interfaceControle;

import java.util.ArrayList;

import basico.Usuario;

public interface I_ControleLogin {

	public String salvar(String login, String senha, String confirmSenha);
	public String alterar(int id, String login, String senha);
	public String verificar(String login, String senha);
	public ArrayList<Usuario> listar();
	public String excluir(int id);
	
}
