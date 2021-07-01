package controle;

import java.sql.Date;

import basico.Identidade;

import admBanco.DAOs.FuncionarioDAO;
import admBanco.DAOs.IdentidadeDAO;

import controle.interfaceControle.I_ControleIdentidade;

public class ControleIdentidade implements I_ControleIdentidade{

	
	public String salvar(String numero, String ssp, Date data) {

		IdentidadeDAO salvarIdent = new IdentidadeDAO();
		FuncionarioDAO func = new FuncionarioDAO();
		
		String retorno = salvarIdent.inserir(new Identidade(func.listar(), numero, ssp, data));		
		
		return retorno;
	}

	
	public Object buscar(int id) {
		
		IdentidadeDAO buscarIdent = new IdentidadeDAO();
		
		return buscarIdent.buscar(id);
		
	}


	@Override
	public String alterar(int chaveFunc, String numero, String ssp, Date data) {
		
		IdentidadeDAO alterarIdent = new IdentidadeDAO();
		
		String retorno = alterarIdent.alterar(new Identidade(chaveFunc, numero, ssp, data));
		
		return retorno;
	}

}
