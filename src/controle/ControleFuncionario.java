package controle;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import basico.ConsultaFuncionario;
import basico.Funcionario;
import admBanco.DAOs.ConsultarFuncionariosDAO;
import admBanco.DAOs.FuncionarioDAO;
import controle.interfaceControle.I_ControleFuncionario;

public class ControleFuncionario implements I_ControleFuncionario{

	
	public String salvar(String nome, String nomePai,
			String nomeMae, Date dataNasc, String sexo, String estCivil,
			String pasep, String matricula, String cpf, String grauDeInst) {
		System.out.println("entrou");
		FuncionarioDAO salvarFuncionario = new FuncionarioDAO();
		
		String retorno = salvarFuncionario.inserir(new Funcionario(0, nome, nomePai, nomeMae, dataNasc, sexo, estCivil, pasep, matricula, cpf, grauDeInst));
		System.out.println(retorno);
		return retorno;
	}


	public String alterar(int idFunc, String nome, String nomePai,
			String nomeMae, Date dataNasc, String sexo, String estCivil,
			String pasep, String matricula, String cpf, String grauDeInst) {
		
		FuncionarioDAO alterarFuncionario = new FuncionarioDAO();
	
		String retorno = alterarFuncionario.alterar(new Funcionario(idFunc, nome, nomePai, nomeMae, dataNasc, sexo, estCivil, pasep, matricula, cpf, grauDeInst));
		System.out.println(retorno);
		return retorno;
	}

	
	public String excluir(int id, String nome) {

		FuncionarioDAO excluirFunc = new FuncionarioDAO();
		String retorno = null;
		
		retorno = excluirFunc.excluir(id, nome);
		
		return retorno;
	}


	public String[] listar(String nomePesquisa) {

		return null;
	}


	
	public JTable construirTabela_1(String organizarPor) {
		
		ConsultarFuncionariosDAO list_hist = new ConsultarFuncionariosDAO();
		ArrayList<Object> array_func = new ArrayList<Object>();
		ConsultaFuncionario listaFuncionarios = new ConsultaFuncionario();
		String[] colunas = new String[4];
		
		colunas[0] = "ID";
		colunas[1] = "Nome";
		colunas[2] = "CPF";
		colunas[3] = "Cargo Atual";

		DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, colunas);
		
		JTable table = new JTable(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(191);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		
		array_func = list_hist.listar_1(organizarPor);
		
		for (int i = 0; i < array_func.size(); i++) {
			
			listaFuncionarios = (ConsultaFuncionario) array_func.get(i);
			modelo.addRow(new String[]{""+listaFuncionarios.getIdFunc(),listaFuncionarios.getNome(),
					listaFuncionarios.getCpf(),listaFuncionarios.getCargo()});
		}
		
		return table;
	}


	public JTable atualizarTabela_1(String organizarPor, String pesquisarPor,
			String textoPesquisa) {
		
		
		ConsultarFuncionariosDAO list_hist = new ConsultarFuncionariosDAO();
		ArrayList<Object> array_func = new ArrayList<Object>();
		ConsultaFuncionario listaFuncionarios = new ConsultaFuncionario();
		String[] colunas = new String[4];
		
		colunas[0] = "ID";
		colunas[1] = "Nome";
		colunas[2] = "CPF";
		colunas[3] = "Cargo Atual";

		DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, colunas);
		
		JTable table = new JTable(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(191);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		
		array_func = list_hist.listar_1(organizarPor, pesquisarPor, textoPesquisa);
		
		for (int i = 0; i < array_func.size(); i++) {
			
			listaFuncionarios = (ConsultaFuncionario) array_func.get(i);
			modelo.addRow(new String[]{""+listaFuncionarios.getIdFunc(),listaFuncionarios.getNome(),
					listaFuncionarios.getCpf(),listaFuncionarios.getCargo()});
		}
		
		return table;
		
	}

	
	public Object buscar(int id) {
		
		FuncionarioDAO buscarFunc = new FuncionarioDAO();
		
		return buscarFunc.buscar(id);
		
	}


	public JTable construirTabela_2(String organizarPor) {
		
		ConsultarFuncionariosDAO list_hist = new ConsultarFuncionariosDAO();
		ArrayList<Object> array_func = new ArrayList<Object>();
		ConsultaFuncionario listaFuncionarios = new ConsultaFuncionario();
		String[] colunas = new String[4];
		
		colunas[0] = "ID";
		colunas[1] = "Nome";
		colunas[2] = "Data de Nasc.";
		colunas[3] = "CPF";

		DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, colunas);
		
		JTable table = new JTable(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(191);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		
		array_func = list_hist.listar_2(organizarPor);
		
		for (int i = 0; i < array_func.size(); i++) {
			
			listaFuncionarios = (ConsultaFuncionario) array_func.get(i);
			modelo.addRow(new String[]{""+listaFuncionarios.getIdFunc(),listaFuncionarios.getNome(), 
					new SimpleDateFormat("dd/MM/yyyy").format(listaFuncionarios.getDataNasc()), listaFuncionarios.getCpf()});
		}
		
		return table;
	}


	public JTable atualizarTabela_2(String organizarPor, String pesquisarPor,
			String textoPesquisa) {
		
		ConsultarFuncionariosDAO list_hist = new ConsultarFuncionariosDAO();
		ArrayList<Object> array_func = new ArrayList<Object>();
		ConsultaFuncionario listaFuncionarios = new ConsultaFuncionario();
		String[] colunas = new String[4];
		
		colunas[0] = "ID";
		colunas[1] = "Nome";
		colunas[2] = "Data Nasc.";
		colunas[3] = "CPF";

		DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, colunas);
		
		JTable table = new JTable(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(191);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		
		array_func = list_hist.listar_2(organizarPor, pesquisarPor, textoPesquisa);
		
		for (int i = 0; i < array_func.size(); i++) {
			
			listaFuncionarios = (ConsultaFuncionario) array_func.get(i);
			modelo.addRow(new String[]{""+listaFuncionarios.getIdFunc(),listaFuncionarios.getNome(), 
					new SimpleDateFormat("dd/MM/yyyy").format(listaFuncionarios.getDataNasc()), listaFuncionarios.getCpf()});
		}
		
		return table;
		
	}



}
