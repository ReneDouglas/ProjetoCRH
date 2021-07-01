package controle;

import basico.Naturalidade;
import admBanco.DAOs.FuncionarioDAO;
import admBanco.DAOs.NaturalidadeDAO;
import controle.interfaceControle.I_ControleNaturalidade;

public class ControleNaturalidade implements I_ControleNaturalidade{

	
	public String salvar(String cidade, String estado) {
		
		NaturalidadeDAO salvarNat = new NaturalidadeDAO();
		FuncionarioDAO func = new FuncionarioDAO();
		
		String retorno = salvarNat.inserir(new Naturalidade(func.listar(), cidade, estado));
				
		return retorno;
	}

	
	public Object buscar(int id) {
		
		NaturalidadeDAO buscarNaturalidade = new NaturalidadeDAO();
		
		return buscarNaturalidade.buscar(id);
		
	}


	@Override
	public String alterar(int chaveFunc, String cidade, String estado) {
		
		NaturalidadeDAO alterarNat = new NaturalidadeDAO();
		
		String retorno = alterarNat.alterar(new Naturalidade(chaveFunc, cidade, estado));
		
		return retorno;
	}

}
