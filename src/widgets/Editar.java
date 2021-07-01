package widgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import basico.Alistamento;
import basico.CarteiraDeTrabalho;
import basico.Dependente;
import basico.Endereco;
import basico.Ferias;
import basico.Funcionario;
import basico.Identidade;
import basico.Licenca;
import basico.Naturalidade;
import basico.TituloEleitoral;
import basico.VidaFuncional;
import controle.ControleAlistamento;
import controle.ControleCarteiraDeTrabalho;
import controle.ControleDependente;
import controle.ControleEndereco;
import controle.ControleFerias;
import controle.ControleFuncionario;
import controle.ControleIdentidade;
import controle.ControleLicenca;
import controle.ControleNaturalidade;
import controle.ControleTipoLicenca;
import controle.ControleTitulo;
import controle.ControleVidaFuncional;

public class Editar extends Cadastrar{


	private static final long serialVersionUID = 1L;
	private int idFunc;
	private Funcionario func;
	private Naturalidade nat;
	private Endereco end;
	private Identidade ident;
	private TituloEleitoral titulo;
	private Alistamento alist;
	private CarteiraDeTrabalho trab;
	private ArrayList<VidaFuncional> hist;
	private ArrayList<Licenca> licen;
	private ArrayList<Ferias> ferias;
	private ArrayList<Dependente> dep;
	private ControleFuncionario dataFunc;
	private ControleNaturalidade dataNat;
	private ControleEndereco dataEnd;
	private ControleIdentidade dataIdent;
	private ControleTitulo dataTitle ;
	private ControleAlistamento dataAlist;
	private ControleCarteiraDeTrabalho dataTrab;
	private ControleVidaFuncional dataHist;
	private ControleLicenca dataLicen;
	private ControleTipoLicenca dataLicenTipo;
	private ControleFerias dataFerias;
	private ControleDependente dataDep;
	private JButton btnEditar_1, btnEditar_2, btnEditar_3, btnEditarDep;
	
	public Editar(int idFunc) {
		super();
		setTitle("Editar Funcionário");
		
		this.idFunc = idFunc;
		
		this.dataFunc = new ControleFuncionario();
		this.dataNat = new ControleNaturalidade();
		this.dataEnd = new ControleEndereco();
		this.dataIdent = new ControleIdentidade();
		this.dataTitle = new ControleTitulo();
		this.dataAlist = new ControleAlistamento();
		this.dataTrab = new ControleCarteiraDeTrabalho();
		this.dataHist = new ControleVidaFuncional();
		this.dataLicen = new ControleLicenca();
		this.dataLicenTipo = new ControleTipoLicenca();
		this.dataFerias = new ControleFerias();
		this.dataDep = new ControleDependente();
		
		this.func = new Funcionario();
		this.nat = new Naturalidade();
		this.end = new Endereco();
		this.ident = new Identidade();
		this.titulo = new TituloEleitoral();
		this.alist = new Alistamento();
		this.trab = new CarteiraDeTrabalho();
		this.hist = new ArrayList<VidaFuncional>();
		this.licen = new ArrayList<Licenca>();
		this.ferias = new ArrayList<Ferias>();
		this.dep = new ArrayList<Dependente>();
		
		this.func = (Funcionario) dataFunc.buscar(idFunc);
		this.nat = (Naturalidade) dataNat.buscar(idFunc);
		this.end = (Endereco) dataEnd.buscar(idFunc);
		this.ident = (Identidade) dataIdent.buscar(idFunc);
		this.titulo = (TituloEleitoral) dataTitle.buscar(idFunc);
		this.alist = (Alistamento) dataAlist.buscar(idFunc);
		this.trab = (CarteiraDeTrabalho) dataTrab.buscar(idFunc);
		this.hist = dataHist.buscar(idFunc);
		this.licen = dataLicen.buscar(idFunc);
		this.ferias = dataFerias.buscar(idFunc);
		this.dep = dataDep.buscar(idFunc);
		
		carregarFichaFuncional();
		carregarHistorico();
		carregarDependentes();
		
	}

	private void carregarFichaFuncional(){
		
		this.getFichaFuncional().getTextField_nome().setText(func.getNome());
		this.getFichaFuncional().getTextField_pai().setText(func.getNomePai());
		this.getFichaFuncional().getTextField_mae().setText(func.getNomeMae());
		this.getFichaFuncional().getTextField_nasc().setText(new SimpleDateFormat("dd/MM/yyyy").format(func.getDataNasc()));
		this.getFichaFuncional().getTextField_civil().setText(func.getEstCivil());
		this.getFichaFuncional().getTextField_pasep().setText(func.getPasep());
		this.getFichaFuncional().getTextField_matr().setText(func.getMatricula());
		this.getFichaFuncional().getTextField_grau().setText(func.getGrauDeInst());
		this.getFichaFuncional().getTextField_cpf().setText(func.getCpf());
		
		String sexo = func.getSexo();
		
		if(sexo.equalsIgnoreCase("Masculino"))
			this.getFichaFuncional().getRdbtnMasc().setSelected(true);
		else
			this.getFichaFuncional().getRdbtnFem().setSelected(true);
		
		this.getFichaFuncional().getTextField_cidade().setText(nat.getCidade());
		this.getFichaFuncional().getComboBox().setSelectedItem(nat.getEstado());
		this.getFichaFuncional().getTextField_bairro().setText(end.getBairro());
		this.getFichaFuncional().getTextField_rua().setText(end.getRua());
		this.getFichaFuncional().getTextField_numero().setText(end.getNumero());
		this.getFichaFuncional().getTextField_identNum().setText(ident.getNumero());
		this.getFichaFuncional().getTextField_ssp().setText(ident.getSsp());
		this.getFichaFuncional().getTextField_dataIdent().setText(new SimpleDateFormat("dd/MM/yyyy").format(ident.getData()));
		this.getFichaFuncional().getTextField_numTitulo().setText(titulo.getNumero());
		this.getFichaFuncional().getTextField_zona().setText(titulo.getZona());
		this.getFichaFuncional().getTextField_secao().setText(titulo.getSecao());
		
		if(func.getSexo().equalsIgnoreCase("Masculino")){	
			this.getFichaFuncional().getTextField_situacaoMil().setText(alist.getSituacaoMilitar());
			this.getFichaFuncional().getTextField_serieMil().setText(alist.getSerie());
			this.getFichaFuncional().getTextField_esp().setText(alist.getEsp());
		}
		
		this.getFichaFuncional().getTextField_ctps().setText(trab.getCtpsNumero());
		this.getFichaFuncional().getTextField_dataCtps().setText(new SimpleDateFormat("dd/MM/yyyy").format(trab.getData()));
		this.getFichaFuncional().getTextField_serieCtps().setText(trab.getSerie());
		
		try {
			this.getFichaFuncional().getTextField_nasc().commitEdit();
			this.getFichaFuncional().getTextField_cpf().commitEdit();
			this.getFichaFuncional().getTextField_dataIdent().commitEdit();
			this.getFichaFuncional().getTextField_dataCtps().commitEdit();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.getFichaFuncional().getBtnSalvar().removeActionListener(getFichaFuncional());
		
		this.getFichaFuncional().getBtnSalvar().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				String sexo = (getFichaFuncional().getRdbtnMasc().isSelected())?"Masculino":"Feminino";
	
				
				ControleAlistamento salvarFormAlist = null;
				if(sexo == "Masculino") salvarFormAlist = new ControleAlistamento();
				
				ControleCarteiraDeTrabalho salvarFormTrab = new ControleCarteiraDeTrabalho();
				
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				
				try {
					
					String salvar = dataFunc.alterar(idFunc, getFichaFuncional().getTextField_nome().getText(), getFichaFuncional().getTextField_pai().getText(), getFichaFuncional().getTextField_mae().getText(),
							new java.sql.Date((formatter.parse(getFichaFuncional().getTextField_nasc().getText())).getTime()), sexo, getFichaFuncional().getTextField_civil().getText(), getFichaFuncional().getTextField_pasep().getText(),
							getFichaFuncional().getTextField_matr().getText(), getFichaFuncional().getTextField_cpf().getText(), getFichaFuncional().getTextField_grau().getText());
					
					String salvarNat = dataNat.alterar(idFunc, getFichaFuncional().getTextField_cidade().getText(), getFichaFuncional().getComboBox().getSelectedItem().toString());
					
					String salvarEnd = dataEnd.alterar(idFunc, getFichaFuncional().getTextField_bairro().getText(), getFichaFuncional().getTextField_rua().getText(), getFichaFuncional().getTextField_numero().getText());
					
					String salvarIdent = dataIdent.alterar(idFunc, getFichaFuncional().getTextField_identNum().getText(), getFichaFuncional().getTextField_ssp().getText(), new java.sql.Date((formatter.parse(getFichaFuncional().getTextField_dataIdent().getText())).getTime()));
					
					String salvarTitulo = dataTitle.alterar(idFunc, getFichaFuncional().getTextField_numTitulo().getText(), getFichaFuncional().getTextField_zona().getText(), getFichaFuncional().getTextField_secao().getText());
					
					String salvarAlist = null;
					
					if(salvarFormAlist != null) salvarAlist = salvarFormAlist.alterar(idFunc, getFichaFuncional().getTextField_situacaoMil().getText(), getFichaFuncional().getTextField_serieMil().getText(), getFichaFuncional().getTextField_esp().getText());
					
					String salvarTrab = salvarFormTrab.alterar(idFunc, getFichaFuncional().getTextField_ctps().getText(), getFichaFuncional().getTextField_serieCtps().getText(), new java.sql.Date((formatter.parse(getFichaFuncional().getTextField_dataCtps().getText())).getTime()));
					
					if(salvar.substring(22, 29).equals("sucesso") && salvarNat.substring(22, 29).equals("sucesso") &&
							salvarEnd.substring(22, 29).equals("sucesso") && salvarIdent.substring(22, 29).equals("sucesso")
							&& salvarTitulo.substring(22, 29).equals("sucesso") && salvarTrab.substring(22, 29).equals("sucesso")){
						
						 if(salvarAlist != null){
							 if(salvarAlist.substring(22, 29).equals("sucesso")){
								 JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
							 }
							 else{
								 JOptionPane.showMessageDialog(null, "Erro ao alterar os Dados!\n"+salvar+"\n"+salvarNat+"\n"+salvarEnd+"\n"+salvarIdent+"\n"+salvarTitulo+"\n"+salvarAlist+"\n"+salvarTrab, "Atenção", JOptionPane.ERROR_MESSAGE);
							 }
						 }
						 else JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
						
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Erro ao alterar os Dados!\n"+salvar+"\n"+salvarNat+"\n"+salvarEnd+"\n"+salvarIdent+"\n"+salvarTitulo+"\n"+salvarAlist+"\n"+salvarTrab, "Atenção", JOptionPane.ERROR_MESSAGE);
						
						
					}
					
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		
	}
	
	private void carregarHistorico(){
		
		carregarNovosComponentesHistorico();
		
		for (int a = 0; a < hist.size(); a++) {
			
			this.getHistorico().getModelo_vidaFunc().addRow(
					
					new String[]{
							hist.get(a).getPort(), 
							""+new SimpleDateFormat("dd/MM/yyyy").format(hist.get(a).getDataNomeacao()),
							""+new SimpleDateFormat("dd/MM/yyyy").format(hist.get(a).getDataExercicio()),
							""+new SimpleDateFormat("dd/MM/yyyy").format(hist.get(a).getDataLicenca()),
							""+new SimpleDateFormat("dd/MM/yyyy").format(hist.get(a).getDataAlteracao()), hist.get(a).getCargo(), 
							hist.get(a).getFs(), hist.get(a).getP(), hist.get(a).getSecretaria(), hist.get(a).getLocalizacao(),
							hist.get(a).getObservacao()
					});
			
		}
		
		for (int b = 0; b < licen.size(); b++) {
			
			this.getHistorico().getModelo_Licenca().addRow(
					
					new String[]{
							""+new String(dataLicenTipo.buscar(licen.get(b).getTipoLicenca())),
							""+new SimpleDateFormat("dd/MM/yyyy").format(licen.get(b).getInicio()),
							""+new SimpleDateFormat("dd/MM/yyyy").format(licen.get(b).getTermino()),
							licen.get(b).getPortaria(),
							licen.get(b).getObserv()
			});
			
		}
		
		for (int c = 0; c < ferias.size(); c++) {
			
			this.getHistorico().getModelo_Ferias().addRow(
					
					new String[]{
							ferias.get(c).getPeriodoAq(),
							ferias.get(c).getPeriodoGozo(),
							ferias.get(c).getPortaria()		
					});
			
		}
		
	}
	
	private void carregarDependentes(){
		
		getDependentes().getbDeletar().removeActionListener(getDependentes());
		getDependentes().getbSalvar().removeActionListener(getDependentes());
		getDependentes().getbAdicionar().setBounds(408, 290, 100, 30);
		
		btnEditarDep = new JButton("Editar");
		btnEditarDep.setBounds(513, 290, 100, 30);
		btnEditarDep.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(getDependentes().getTable().getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				else{
					
					getDependentes().getTextField().setText((String)getDependentes().getModelo().getValueAt(getDependentes().getTable().getSelectedRow(), 1));
					getDependentes().getTextField_1().setText((String)getDependentes().getModelo().getValueAt(getDependentes().getTable().getSelectedRow(), 2));
					getDependentes().getTextField_2().setText((String)getDependentes().getModelo().getValueAt(getDependentes().getTable().getSelectedRow(), 3));
					getDependentes().getTextField_3().setText((String)getDependentes().getModelo().getValueAt(getDependentes().getTable().getSelectedRow(), 4));
					getDependentes().getTextField_4().setText((String)getDependentes().getModelo().getValueAt(getDependentes().getTable().getSelectedRow(), 5));
				
					getDependentes().getModelo().removeRow(getDependentes().getTable().getSelectedRow());
														   
					
					try {
						getDependentes().getTextField_2().commitEdit();
						getDependentes().getTextField_3().commitEdit();
						getDependentes().getTextField_4().commitEdit();
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		getDependentes().add(btnEditarDep);
		
		getDependentes().getbDeletar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(getDependentes().getTable().getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				else{
					
					int decisao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir os dados selecionados?", "Confirmação", JOptionPane.YES_NO_OPTION);
					
					if(decisao == JOptionPane.YES_OPTION){
						
						String resultado = dataDep.excluir(idFunc, (String) getDependentes().getTable().getValueAt(getDependentes().getTable().getSelectedRow(), 1));
						
						JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
						
						getDependentes().getModelo().removeRow(getDependentes().getTable().getSelectedRow());
					}
			
				}
				
			}
		});
		
		getDependentes().getbSalvar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				ControleDependente salvarForm = new ControleDependente();
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String retorno = "";
				
				if(getDependentes().getTable().getRowCount() > 0){
					for (int i = 0; i < getDependentes().getTable().getRowCount(); i++) {
						
						try {
							retorno = salvarForm.alterar(idFunc, getDependentes().getTable().getValueAt(i, 1).toString(), getDependentes().getTable().getValueAt(i, 2).toString(),
									new java.sql.Date((formatter.parse(getDependentes().getTable().getValueAt(i, 3).toString())).getTime()),
									new java.sql.Date((formatter.parse(getDependentes().getTable().getValueAt(i, 4).toString())).getTime()),
									new java.sql.Date((formatter.parse(getDependentes().getTable().getValueAt(i, 5).toString())).getTime()));
							
							
							
							if(retorno.substring(0, 4).equals("Erro"))break;
							
						} catch (ParseException e1) {
							e1.printStackTrace();
						}			
					}	
				JOptionPane.showMessageDialog(null, retorno, "Informação", JOptionPane.INFORMATION_MESSAGE);
				getDependentes().limpar_tabela((getDependentes().getModelo()));
				
				} else JOptionPane.showMessageDialog(null, "Tabela Vazia!");
				
			}
		});
		
		for (int j = 0; j < dep.size(); j++) {
			
			this.getDependentes().getModelo().addRow(
					
					new String[]{
							""+(j+1),
							dep.get(j).getNome(),
							dep.get(j).getParentesco(),
							""+new SimpleDateFormat("dd/MM/yyyy").format(dep.get(j).getDataNasc()),
							""+new SimpleDateFormat("dd/MM/yyyy").format(dep.get(j).getInicio()),
							""+new SimpleDateFormat("dd/MM/yyyy").format(dep.get(j).getTermino()),
					});
			
		}
		
	}
	
	private void carregarNovosComponentesHistorico(){
		
		this.getHistorico().getSalvar_1().removeActionListener(getHistorico());
		this.getHistorico().getSalvar_2().removeActionListener(getHistorico());
		this.getHistorico().getSalvar_3().removeActionListener(getHistorico());
		this.getHistorico().getDeletar_1().removeActionListener(getHistorico());
		this.getHistorico().getDeletar_2().removeActionListener(getHistorico());
		this.getHistorico().getDeletar_3().removeActionListener(getHistorico());
		
		this.getHistorico().getButtonAdd_1().setBounds(345, 190, 100, 30);
		this.getHistorico().getButtonAdd_2().setBounds(345, 495, 100, 30);
		this.getHistorico().getButtonAdd_3().setBounds(345, 730, 100, 30);
		
		btnEditar_1 = new JButton("<< Editar   ");
		btnEditar_1.setBounds(345, 225, 100, 30);
		btnEditar_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(getHistorico().getTable_vidaFunc().getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				else{
					getHistorico().getTextField_atoFunc().setText((String) getHistorico().getTable_vidaFunc().getValueAt(getHistorico().getTable_vidaFunc().getSelectedRow(), 0));
					getHistorico().getTextField_nom().setText((String) getHistorico().getTable_vidaFunc().getValueAt(getHistorico().getTable_vidaFunc().getSelectedRow(), 1));
					getHistorico().getTextField_exer().setText((String) getHistorico().getTable_vidaFunc().getValueAt(getHistorico().getTable_vidaFunc().getSelectedRow(), 2));
					getHistorico().getTextField_licen().setText((String) getHistorico().getTable_vidaFunc().getValueAt(getHistorico().getTable_vidaFunc().getSelectedRow(), 3));
					getHistorico().getTextField_alt().setText((String) getHistorico().getTable_vidaFunc().getValueAt(getHistorico().getTable_vidaFunc().getSelectedRow(), 4));
					getHistorico().getTextField_carg().setText((String) getHistorico().getTable_vidaFunc().getValueAt(getHistorico().getTable_vidaFunc().getSelectedRow(), 5));
					getHistorico().getTextField_fs().setText((String) getHistorico().getTable_vidaFunc().getValueAt(getHistorico().getTable_vidaFunc().getSelectedRow(), 6));
					getHistorico().getTextField_p().setText((String) getHistorico().getTable_vidaFunc().getValueAt(getHistorico().getTable_vidaFunc().getSelectedRow(), 7));
					getHistorico().getTextArea_licen().setText((String) getHistorico().getTable_vidaFunc().getValueAt(getHistorico().getTable_vidaFunc().getSelectedRow(), 10));
				
					getHistorico().getModelo_vidaFunc().removeRow(getHistorico().getTable_vidaFunc().getSelectedRow());
					
					try {
						getHistorico().getTextField_nom().commitEdit();
						getHistorico().getTextField_exer().commitEdit();
						getHistorico().getTextField_licen().commitEdit();
						getHistorico().getTextField_alt().commitEdit();
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		this.getHistorico().add(btnEditar_1);
		
		btnEditar_2 = new JButton("<< Editar   ");
		btnEditar_2.setBounds(345, 530, 100, 30);
		btnEditar_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				if(getHistorico().getTable_licenca().getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				else{
					getHistorico().getComboBox().setSelectedItem(getHistorico().getModelo_Licenca().getValueAt(getHistorico().getTable_licenca().getSelectedRow(), 0));
					getHistorico().getTextField_inicio().setText((String) getHistorico().getModelo_Licenca().getValueAt(getHistorico().getTable_licenca().getSelectedRow(), 1));
					getHistorico().getTextField_term().setText((String) getHistorico().getModelo_Licenca().getValueAt(getHistorico().getTable_licenca().getSelectedRow(), 2));
					getHistorico().getTextField_portLicen().setText((String) getHistorico().getModelo_Licenca().getValueAt(getHistorico().getTable_licenca().getSelectedRow(), 3));
					getHistorico().getTextArea_licen().setText((String) getHistorico().getModelo_Licenca().getValueAt(getHistorico().getTable_licenca().getSelectedRow(), 4));
					
					getHistorico().getModelo_Licenca().removeRow(getHistorico().getTable_licenca().getSelectedRow());
					
					try {
						getHistorico().getTextField_inicio().commitEdit();
						getHistorico().getTextField_term().commitEdit();
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		this.getHistorico().add(btnEditar_2);
			
		btnEditar_3 = new JButton("<< Editar   ");
		btnEditar_3.setBounds(345, 765, 100, 30);
		btnEditar_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				if(getHistorico().getTable_ferias().getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				else{
					getHistorico().getTextField_pAq().setText((String)getHistorico().getModelo_Ferias().getValueAt(getHistorico().getTable_ferias().getSelectedRow(), 0));
					getHistorico().getTextField_pGozo().setText((String)getHistorico().getModelo_Ferias().getValueAt(getHistorico().getTable_ferias().getSelectedRow(), 1));
					getHistorico().getTextField_portFerias().setText((String)getHistorico().getModelo_Ferias().getValueAt(getHistorico().getTable_ferias().getSelectedRow(), 2));
					
					getHistorico().getModelo_Ferias().removeRow(getHistorico().getTable_ferias().getSelectedRow());
					
				}
			}
		});
		this.getHistorico().add(btnEditar_3);
		
		this.getHistorico().getDeletar_1().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(getHistorico().getTable_vidaFunc().getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				else{
					
					int decisao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir os dados selecionados?", "Confirmação", JOptionPane.YES_NO_OPTION);
					
					if(decisao == 0){
						
							String resultado = dataHist.excluir(idFunc, (String) getHistorico().getTable_vidaFunc().getValueAt(getHistorico().getTable_vidaFunc().getSelectedRow(), 0));
							
							JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
							
							getHistorico().getModelo_vidaFunc().removeRow(getHistorico().getTable_vidaFunc().getSelectedRow());
					}
				
				}
			}
		});
		
		this.getHistorico().getDeletar_2().addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent arg0) {
					
				if(getHistorico().getTable_licenca().getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				else{
					
					int decisao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir os dados selecionados?", "Confirmação", JOptionPane.YES_NO_OPTION);
					
					if(decisao == 0){
						
						String resultado = dataLicen.excluir(idFunc, (String) getHistorico().getTable_licenca().getValueAt(getHistorico().getTable_licenca().getSelectedRow(), 3));
						
						JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
						
						getHistorico().getModelo_Licenca().removeRow(getHistorico().getTable_licenca().getSelectedRow());
					}
			
				}
						
			}
		});

		this.getHistorico().getDeletar_3().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(getHistorico().getTable_ferias().getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				else{
					
					int decisao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir os dados selecionados?", "Confirmação", JOptionPane.YES_NO_OPTION);
					
					if(decisao == 0){
						
						String resultado = dataFerias.excluir(idFunc, (String) getHistorico().getTable_ferias().getValueAt(getHistorico().getTable_ferias().getSelectedRow(), 2));
						
						JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
						
						getHistorico().getModelo_Ferias().removeRow(getHistorico().getTable_ferias().getSelectedRow());
					}
				
				}
			}
		});
		
		
		/*
		 * 
		 * BOTÃO PARA ALTERAR COMEÇAR AQUI, FALTAM OS DOIS ULTIMOS DE SALVAR (Salvar_2,Salvar_3)
		 * 
		 */
		
		
		this.getHistorico().getSalvar_1().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				ControleVidaFuncional salvarForm = new ControleVidaFuncional();
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String resultado = "";
				
				if(getHistorico().getTable_vidaFunc().getRowCount() > 0){
					
					for (int i = 0; i < getHistorico().getTable_vidaFunc().getRowCount(); i++) {
						
						try {
							resultado = salvarForm.alterar(idFunc, getHistorico().getTable_vidaFunc().getValueAt(i, 0).toString(),new java.sql.Date((formatter.parse(getHistorico().getTable_vidaFunc().getValueAt(i, 1).toString())).getTime()),
									new java.sql.Date((formatter.parse(getHistorico().getTable_vidaFunc().getValueAt(i, 2).toString())).getTime()),new java.sql.Date((formatter.parse(getHistorico().getTable_vidaFunc().getValueAt(i, 3).toString())).getTime()),
									new java.sql.Date((formatter.parse(getHistorico().getTable_vidaFunc().getValueAt(i, 4).toString())).getTime()),getHistorico().getTable_vidaFunc().getValueAt(i, 5).toString(),getHistorico().getTable_vidaFunc().getValueAt(i, 6).toString(),
									getHistorico().getTable_vidaFunc().getValueAt(i, 7).toString(),getHistorico().getTable_vidaFunc().getValueAt(i, 8).toString(),getHistorico().getTable_vidaFunc().getValueAt(i, 9).toString(),
									getHistorico().getTable_vidaFunc().getValueAt(i, 10).toString());
																		
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						
						if(resultado.substring(0, 4).equals("Erro"))break;
						
					}
					JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
					
					getHistorico().limpar_tabela(getHistorico().getModelo_vidaFunc());
					
				}else JOptionPane.showMessageDialog(null, "Tabela Vazia!");
				
			}
		});
		
		this.getHistorico().getSalvar_2().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				ControleLicenca salvarForm = new ControleLicenca();
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String resultado = "";
				
				if(getHistorico().getTable_licenca().getRowCount() > 0){
					
					for (int i = 0; i < getHistorico().getTable_licenca().getRowCount(); i++) {
						
						try {
							resultado = salvarForm.alterar(idFunc, getHistorico().getTable_licenca().getValueAt(i, 0).toString(), 
									new java.sql.Date((formatter.parse(getHistorico().getTable_licenca().getValueAt(i, 1).toString())).getTime()),
									new java.sql.Date((formatter.parse(getHistorico().getTable_licenca().getValueAt(i, 2).toString())).getTime()),
									getHistorico().getTable_licenca().getValueAt(i, 3).toString(),
									getHistorico().getTable_licenca().getValueAt(i, 4).toString());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(resultado.substring(0, 4).equals("Erro"))break;
						
					}
					JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
					
					getHistorico().limpar_tabela(getHistorico().getModelo_Licenca());
					
				}else JOptionPane.showMessageDialog(null, "Tabela Vazia!");
				
			}
		});
		
		this.getHistorico().getSalvar_3().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				ControleFerias salvarForm = new ControleFerias();
				String resultado = "";
				
				if(getHistorico().getTable_ferias().getRowCount() > 0){
					
					for (int i = 0; i < getHistorico().getTable_ferias().getRowCount(); i++) {
						
						resultado = salvarForm.alterar(idFunc, getHistorico().getTable_ferias().getValueAt(i, 0).toString(), 
														getHistorico().getTable_ferias().getValueAt(i, 1).toString(), 
														getHistorico().getTable_ferias().getValueAt(i, 2).toString());
						
						if(resultado.substring(0, 4).equals("Erro"))break;
						
					}
					
					JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
					
					getHistorico().limpar_tabela(getHistorico().getModelo_Ferias());
					
				}else JOptionPane.showMessageDialog(null, "Tabela Vazia!");
				
			}
		});
		
		
	}

	public int getIdFunc() {
		return idFunc;
	}

	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}

	public Funcionario getFunc() {
		return func;
	}

	public void setFunc(Funcionario func) {
		this.func = func;
	}

	public Naturalidade getNat() {
		return nat;
	}

	public void setNat(Naturalidade nat) {
		this.nat = nat;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}

	public Identidade getIdent() {
		return ident;
	}

	public void setIdent(Identidade ident) {
		this.ident = ident;
	}

	public TituloEleitoral getTitulo() {
		return titulo;
	}

	public void setTitulo(TituloEleitoral titulo) {
		this.titulo = titulo;
	}

	public Alistamento getAlist() {
		return alist;
	}

	public void setAlist(Alistamento alist) {
		this.alist = alist;
	}

	public CarteiraDeTrabalho getTrab() {
		return trab;
	}

	public void setTrab(CarteiraDeTrabalho trab) {
		this.trab = trab;
	}

	public ArrayList<VidaFuncional> getHist() {
		return hist;
	}

	public void setHist(ArrayList<VidaFuncional> hist) {
		this.hist = hist;
	}

	public ArrayList<Licenca> getLicen() {
		return licen;
	}

	public void setLicen(ArrayList<Licenca> licen) {
		this.licen = licen;
	}

	public ArrayList<Ferias> getFerias() {
		return ferias;
	}

	public void setFerias(ArrayList<Ferias> ferias) {
		this.ferias = ferias;
	}

	public ArrayList<Dependente> getDep() {
		return dep;
	}

	public void setDep(ArrayList<Dependente> dep) {
		this.dep = dep;
	}

	public ControleFuncionario getSearch() {
		return dataFunc;
	}

	public void setSearch(ControleFuncionario search) {
		this.dataFunc = search;
	}

	public ControleNaturalidade getSearchNat() {
		return dataNat;
	}

	public void setSearchNat(ControleNaturalidade searchNat) {
		this.dataNat = searchNat;
	}

	public ControleEndereco getSearchEnd() {
		return dataEnd;
	}

	public void setSearchEnd(ControleEndereco searchEnd) {
		this.dataEnd = searchEnd;
	}

	public ControleIdentidade getSearchIdent() {
		return dataIdent;
	}

	public void setSearchIdent(ControleIdentidade searchIdent) {
		this.dataIdent = searchIdent;
	}

	public ControleTitulo getSearchTitle() {
		return dataTitle;
	}

	public void setSearchTitle(ControleTitulo searchTitle) {
		this.dataTitle = searchTitle;
	}

	public ControleAlistamento getSearchAlist() {
		return dataAlist;
	}

	public void setSearchAlist(ControleAlistamento searchAlist) {
		this.dataAlist = searchAlist;
	}

	public ControleCarteiraDeTrabalho getSearchTrab() {
		return dataTrab;
	}

	public void setSearchTrab(ControleCarteiraDeTrabalho searchTrab) {
		this.dataTrab = searchTrab;
	}

	public ControleVidaFuncional getSearchHist() {
		return dataHist;
	}

	public void setSearchHist(ControleVidaFuncional searchHist) {
		this.dataHist = searchHist;
	}

	public ControleLicenca getSearchLicen() {
		return dataLicen;
	}

	public void setSearchLicen(ControleLicenca searchLicen) {
		this.dataLicen = searchLicen;
	}

	public ControleFerias getSearchFerias() {
		return dataFerias;
	}

	public void setSearchFerias(ControleFerias searchFerias) {
		this.dataFerias = searchFerias;
	}

	public ControleDependente getSearchDep() {
		return dataDep;
	}

	public void setSearchDep(ControleDependente searchDep) {
		this.dataDep = searchDep;
	}
	
}
