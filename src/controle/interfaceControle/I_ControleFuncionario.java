package controle.interfaceControle;

import java.sql.Date;

import javax.swing.JTable;

public interface I_ControleFuncionario {

	public String salvar(String nome, String nomePai, String nomeMae, Date dataNasc, String sexo, 
			String estCivil, String pasep, String matricula, String cpf, String grauDeInst);
	
	public String alterar(int idFunc, String nome, String nomePai, String nomeMae, Date dataNasc, String sexo, 
			String estCivil, String pasep, String matricula, String cpf, String grauDeInst);
	
	public String excluir(int id, String nome);
	
	public String[] listar(String nomePesquisa);
	
	public JTable atualizarTabela_1(String organizarPor, String pesquisarPor, String textoPesquisa);
	
	public JTable construirTabela_1(String organizarPor);
	
	public JTable construirTabela_2(String organizarPor);
	
	public JTable atualizarTabela_2(String organizarPor, String pesquisarPor, String textoPesquisa);
	
	public Object buscar(int id);
	
}
