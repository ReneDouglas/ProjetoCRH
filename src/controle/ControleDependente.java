package controle;

import java.sql.Date;
import java.util.ArrayList;

import basico.Dependente;

import admBanco.DAOs.DependenteDAO;
import admBanco.DAOs.FuncionarioDAO;

import controle.interfaceControle.I_ControleDependente;

public class ControleDependente implements I_ControleDependente{

	
	public String salvar(int chaveFunc, String nome, String parentesco,
			Date dataNasc, Date inicio, Date termino, int seletor) {
		
		DependenteDAO salvarDependente = new DependenteDAO();
		FuncionarioDAO func = new FuncionarioDAO();
		String retorno = null;
		
		if(seletor == 1){
			retorno = salvarDependente.inserir(new Dependente(func.listar(), nome, parentesco, dataNasc, inicio, termino));
		}
		else if(seletor == 2){
			retorno = salvarDependente.inserir(new Dependente(chaveFunc, nome, parentesco, dataNasc, inicio, termino));
		}	
		
		return retorno;
	}

	
	public ArrayList<Dependente> buscar(int id) {
		
		DependenteDAO buscarDep = new DependenteDAO();
		ArrayList<Dependente>lista = new ArrayList<Dependente>();
		
		lista = buscarDep.buscar(id);
		
		return lista;
		
	}


	public String excluir(int chaveFunc, String nome) {
		
		DependenteDAO excluirDep = new DependenteDAO();
		
		String retorno = excluirDep.excluir(chaveFunc, nome);
		
		return retorno;
	}


	public String alterar(int chaveFunc, String nome, String parentesco,
			Date dataNasc, Date inicio, Date termino) {
		
		DependenteDAO alterarDep = new DependenteDAO();
		String retorno = null;
		
		String returnBusca = alterarDep.alterar(new Dependente(chaveFunc, nome, parentesco, dataNasc, inicio, termino));
		
		if(returnBusca.substring(0, 3).equalsIgnoreCase("Não")){
			retorno = salvar(chaveFunc, nome, parentesco, dataNasc, inicio, termino, 2);
			return retorno;
		}
		
		return returnBusca;
	}

}
