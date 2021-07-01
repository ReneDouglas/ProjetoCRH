package controle;

import basico.Alistamento;
import admBanco.DAOs.AlistamentoDAO;
import admBanco.DAOs.FuncionarioDAO;
import controle.interfaceControle.I_ControleAlistamento;

public class ControleAlistamento implements I_ControleAlistamento{

	
	public String salvar(String situacaoMilitar, String serie, String esp) {
		
		AlistamentoDAO salvarAlist = new AlistamentoDAO();
		FuncionarioDAO func = new FuncionarioDAO();
		
		String retorno = salvarAlist.inserir(new Alistamento(func.listar(), situacaoMilitar, serie, esp));
		
		return retorno;
	}

	public Object buscar(int id) {
		
		AlistamentoDAO buscarAlist = new AlistamentoDAO();
		
		return buscarAlist.buscar(id);
		
	}

	@Override
	public String alterar(int chaveFunc, String situacaoMilitar, String serie, String esp) {
		
		AlistamentoDAO alterarAlist = new AlistamentoDAO();
		
		String retorno = alterarAlist.alterar(new Alistamento(chaveFunc, situacaoMilitar, serie, esp));
		
		return retorno;
		
	}

}
