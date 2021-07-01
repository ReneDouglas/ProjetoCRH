package controle;

import java.sql.Date;

import basico.CarteiraDeTrabalho;

import admBanco.DAOs.CarteiraDeTrabalhoDAO;
import admBanco.DAOs.FuncionarioDAO;

import controle.interfaceControle.I_ControleCarteiraDeTrabalho;

public class ControleCarteiraDeTrabalho implements I_ControleCarteiraDeTrabalho{

	
	public String salvar(String numero, String serie, Date data) {
		
		CarteiraDeTrabalhoDAO salvarCarteira = new CarteiraDeTrabalhoDAO();
		FuncionarioDAO func = new FuncionarioDAO();
		
		String retorno = salvarCarteira.inserir(new CarteiraDeTrabalho(func.listar(), numero, serie, data));
		
		return retorno;
	}

	
	public Object buscar(int id) {
		
		CarteiraDeTrabalhoDAO buscarTrab = new CarteiraDeTrabalhoDAO();
		
		return buscarTrab.buscar(id);
		
	}


	@Override
	public String alterar(int chaveFunc, String numero, String serie, Date data) {
		
		CarteiraDeTrabalhoDAO alterarCarteira = new CarteiraDeTrabalhoDAO();
		
		String retorno = alterarCarteira.alterar(new CarteiraDeTrabalho(chaveFunc, numero, serie, data));
		
		return retorno;
	}

}
