package controle;

import basico.TituloEleitoral;
import admBanco.DAOs.FuncionarioDAO;
import admBanco.DAOs.TituloEleitoralDAO;
import controle.interfaceControle.I_ControleTitulo;

public class ControleTitulo implements I_ControleTitulo{

	
	public String salvar(String numero, String zona, String secao) {

		TituloEleitoralDAO salvarTitulo = new TituloEleitoralDAO();
		FuncionarioDAO func = new FuncionarioDAO();
		
		String retorno = salvarTitulo.inserir(new TituloEleitoral(func.listar(), numero, zona, secao));
		
		return retorno;
	}

	public Object buscar(int id) {
		
		TituloEleitoralDAO buscarTitulo = new TituloEleitoralDAO();
		
		return buscarTitulo.buscar(id);
	}

	@Override
	public String alterar(int chaveFunc, String numero, String zona, String secao) {
		
		TituloEleitoralDAO alterarTitulo = new TituloEleitoralDAO();
		
		String retorno = alterarTitulo.alterar(new TituloEleitoral(chaveFunc, numero, zona, secao));
		
		return retorno;
	}

}
