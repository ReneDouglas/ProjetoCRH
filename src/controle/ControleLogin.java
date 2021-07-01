package controle;

import java.util.ArrayList;

import basico.Usuario;
import admBanco.DAOs.UsuarioDAO;
import controle.interfaceControle.I_ControleLogin;

public class ControleLogin implements I_ControleLogin{

	public String salvar(String login, String senha, String confirmSenha) {
		
		UsuarioDAO salvar = new UsuarioDAO();
		String retorno = "";
		
		if(login.equals("") || senha.equals("") || confirmSenha.equals("")){
			return retorno = "Preencha todos os campos.";
		}
		else{
			if(senha.equals(confirmSenha)){
				retorno = salvar.inserir(new Usuario(0, login, senha));
			}
			else{
				return retorno = "A senha confirmada é diferente";
			}
			
		}
		
		return retorno;
	}

	public String alterar(int id, String login, String senha) {
		
		UsuarioDAO alterarLogin = new UsuarioDAO();
		
		String retorno = alterarLogin.alterar(new Usuario(id, login, senha));
		
		return retorno;
	}

	
	public String verificar(String login, String senha) {
		
		UsuarioDAO verificar = new UsuarioDAO();
		Usuario user = null;
		String retorno = "Erro";
		
		user = (Usuario) verificar.buscar(login, senha);
		
		if(user!=null) retorno = "Sucesso";
		
		return retorno;

	}

	public String excluir(int id) {
		
		UsuarioDAO excluirUser = new UsuarioDAO();
		
		String retorno = excluirUser.excluir(id, null);
		
		return retorno;
	}


	public ArrayList<Usuario> listar() {
		
		UsuarioDAO listarUser = new UsuarioDAO();
		
		return listarUser.listar();
	}

}
