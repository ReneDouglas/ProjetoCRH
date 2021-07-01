package controle;

import java.util.ArrayList;

import admBanco.DAOs.FeriasDAO;
import admBanco.DAOs.FuncionarioDAO;
import basico.Ferias;
import controle.interfaceControle.I_ControleFerias;

public class ControleFerias implements I_ControleFerias{

	
	public String salvar(int chaveFunc, String periodoAq, String periodoGozo,
			String portaria, int seletor) {
		
		FeriasDAO salvarFerias = new FeriasDAO();
		FuncionarioDAO func = new FuncionarioDAO();
		String retorno = null;
		
		if(seletor == 1){
			retorno = salvarFerias.inserir(new Ferias(func.listar(), periodoAq, periodoGozo, portaria));
		}
		else if (seletor == 2){
			retorno = salvarFerias.inserir(new Ferias(chaveFunc, periodoAq, periodoGozo, portaria));
		}
		
		
		return retorno;
	}

	
	public ArrayList<Ferias> buscar(int id) {
		
		FeriasDAO buscarFeriasFunc = new FeriasDAO();
		ArrayList<Ferias> feriasFunc = new ArrayList<Ferias>();
		
		feriasFunc = buscarFeriasFunc.buscarArray(id);
		
		return feriasFunc;
		
	}


	public String excluir(int chaveFunc, String portaria) {
		
		FeriasDAO excluirFerias = new FeriasDAO();
		
		String retorno = excluirFerias.excluir(chaveFunc, portaria);
		
		return retorno;
	}

	public String alterar(int chaveFunc, String periodoAq, String periodoGozo,
			String portaria) {
	
		FeriasDAO alterarFerias = new FeriasDAO();
		String retorno = null;
		String returnBusca = alterarFerias.alterar(new Ferias(chaveFunc, periodoAq, periodoGozo, portaria));
		
		if(returnBusca.substring(0, 3).equalsIgnoreCase("Não")){
			System.out.println("Entrou");
			retorno = salvar(chaveFunc, periodoAq, periodoGozo, portaria, 2);
			return retorno;
		}
		
		
		return returnBusca;
	}

}
