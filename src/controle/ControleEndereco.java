package controle;

import basico.Endereco;
import admBanco.DAOs.EnderecoDAO;
import admBanco.DAOs.FuncionarioDAO;
import controle.interfaceControle.I_ControleEndereco;

public class ControleEndereco implements I_ControleEndereco{

	
	public String salvar(String bairro, String rua, String numero) {
		
		EnderecoDAO salvarEnd = new EnderecoDAO();
		FuncionarioDAO func = new FuncionarioDAO();
		
		String retorno = salvarEnd.inserir(new Endereco(func.listar(), rua, numero, bairro));
		
		return retorno;
	}


	public Object buscar(int id) {
		
		EnderecoDAO buscarEnd = new EnderecoDAO();
		
		return buscarEnd.buscar(id);
		
	}


	@Override
	public String alterar(int chaveFunc, String bairro, String rua, String numero) {
		
		EnderecoDAO alterarEnd = new EnderecoDAO();
		
		String retorno = alterarEnd.alterar(new Endereco(chaveFunc, rua, numero, bairro));
		
		return retorno;
	}

}
