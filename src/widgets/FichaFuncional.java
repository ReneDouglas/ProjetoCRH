package widgets;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.ControleAlistamento;
import controle.ControleCarteiraDeTrabalho;
import controle.ControleEndereco;
import controle.ControleFuncionario;
import controle.ControleIdentidade;
import controle.ControleNaturalidade;
import controle.ControleTitulo;
import controle.classes_complementares.AutoCompletion;
import controle.classes_complementares.UpperCaseDocument;

import javax.swing.JButton;

import widgets.interfaceWidgets.ControleComponentes;

public class FichaFuncional extends JDesktopPane implements ControleComponentes, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_nome;
	private JTextField textField_pai;
	private JTextField textField_mae;
	private JFormattedTextField textField_nasc;
	private JTextField textField_civil;
	private JTextField textField_cidade;
	private JTextField textField_bairro;
	private JTextField textField_rua;
	private JTextField textField_numero;
	private JTextField textField_pasep;
	private JTextField textField_matr;
	private JFormattedTextField textField_cpf;
	private JTextField textField_identNum;
	private JTextField textField_ssp;
	private JFormattedTextField textField_dataIdent;
	private JTextField textField_numTitulo;
	private JTextField textField_zona;
	private JTextField textField_secao;
	private JLabel lblFichaFuncional, lblNome, lblPai, lblMae, lblDataDeNasc, lblSexo, lblEstCivil, lblCidade;
	private JLabel lblBairro, lblLogradouro, lblNmero, lblPasep, lblMatrcula, lblCpf, lblNDeIdentidade, lblSsp, grauDeInst;
	private JLabel lblData, lblNTtulo, lblZona, lblSeo, lblSituaoMilitar, lblSrie, lblEsp, lblCtpsN, lblSrie_1, lblData_1;
	private JRadioButton rdbtnMasc, rdbtnFem;
	private ButtonGroup group;
	private JComboBox<String> comboBox;
	private JTextField textField_situacaoMil;
	private JTextField textField_serieMil;
	private JTextField textField_esp;
	private JTextField textField_ctps;
	private JTextField textField_serieCtps;
	private JFormattedTextField textField_dataCtps;
	private JTextField textField_grau;
	private JButton btnSalvar;
	private MaskFormatter maskCpf, maskDate;
	private final String estados[] = {"PE", "PB", "RN", "AC", "AP", "BA", "AM", "CE", "DF", "SP",
			"ES", "GO", "MA", "MT", "MG", "MS", "PA", "PI", "RJ", "SE", "TO", "SC", "RO", "RR", "RS", "AL", "PR"};
	
	public FichaFuncional() {
		
		UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.setPreferredSize(new Dimension(996,710));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setLayout(null);
		
		carregar_mascaras();
		
		lblFichaFuncional = new JLabel("FICHA FUNCIONAL");
		lblFichaFuncional.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFichaFuncional.setBounds(23, 25, 175, 23);
		this.add(lblFichaFuncional);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(64, 85, 36, 14);
		this.add(lblNome);
		
		textField_nome = new JTextField();
		textField_nome.setDocument(new UpperCaseDocument());
		textField_nome.setBounds(112, 79, 314, 26);
		this.add(textField_nome);
		
		lblPai = new JLabel("Pai:");
		lblPai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPai.setBounds(81, 124, 19, 14);
		this.add(lblPai);
		
		textField_pai = new JTextField();
		textField_pai.setDocument(new UpperCaseDocument());
		textField_pai.setBounds(112, 118, 314, 26);
		this.add(textField_pai);
		
		lblMae = new JLabel("Mae:");
		lblMae.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMae.setBounds(74, 163, 26, 14);
		this.add(lblMae);
		
		textField_mae = new JTextField();
		textField_mae.setDocument(new UpperCaseDocument());
		textField_mae.setBounds(112, 157, 314, 26);
		this.add(textField_mae);
		
		lblDataDeNasc = new JLabel("Data de Nasc.:");
		lblDataDeNasc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeNasc.setBounds(20, 202, 80, 14);
		this.add(lblDataDeNasc);
		
		textField_nasc = new JFormattedTextField(maskDate);
		textField_nasc.setBounds(112, 196, 86, 26);
		this.add(textField_nasc);
		
		rdbtnMasc = new JRadioButton("Masc.");
		rdbtnMasc.setBounds(298, 198, 63, 23);
		rdbtnMasc.setSelected(true);
		this.add(rdbtnMasc);
		
		rdbtnFem = new JRadioButton("Fem.");
		rdbtnFem.setBounds(373, 198, 53, 23);
		this.add(rdbtnFem);
		
		group = new ButtonGroup();
		group.add(rdbtnMasc);
		group.add(rdbtnFem);
		
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(250, 202, 36, 14);
		this.add(lblSexo);
		
		lblEstCivil = new JLabel("Est. Civil:");
		lblEstCivil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstCivil.setBounds(52, 240, 48, 16);
		this.add(lblEstCivil);
		
		textField_civil = new JTextField();
		textField_civil.setDocument(new UpperCaseDocument());
		textField_civil.setBounds(112, 235, 145, 26);
		this.add(textField_civil);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCidade.setBounds(60, 279, 40, 16);
		this.add(lblCidade);
		
		textField_cidade = new JTextField();
		textField_cidade.setDocument(new UpperCaseDocument());
		textField_cidade.setBounds(112, 274, 249, 26);
		this.add(textField_cidade);
		
		Arrays.sort(estados);
		comboBox = new JComboBox<String>(estados);
		comboBox.setSelectedItem("PE");
		AutoCompletion.enable(comboBox);
		comboBox.setBounds(373, 274, 53, 26);
		this.add(comboBox);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(65, 318, 36, 16);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(lblBairro);
		
		textField_bairro = new JTextField();
		textField_bairro.setDocument(new UpperCaseDocument());
		textField_bairro.setBounds(112, 313, 249, 26);
		this.add(textField_bairro);
		
		textField_rua = new JTextField();
		textField_rua.setDocument(new UpperCaseDocument());
		textField_rua.setBounds(112, 352, 314, 26);
		this.add(textField_rua);
		
		lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(33, 357, 67, 16);
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(lblLogradouro);
		
		lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(52, 396, 48, 16);
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(lblNmero);
		
		textField_numero = new JTextField();
		textField_numero.setDocument(new UpperCaseDocument());
		textField_numero.setBounds(112, 391, 67, 26);
		this.add(textField_numero);
		
		lblPasep = new JLabel("PASEP:");
		lblPasep.setBounds(58, 434, 42, 16);
		lblPasep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(lblPasep);
		
		textField_pasep = new JTextField();
		textField_pasep.setDocument(new UpperCaseDocument());
		textField_pasep.setBounds(112, 429, 122, 26);
		this.add(textField_pasep);
		
		textField_matr = new JTextField();
		textField_matr.setDocument(new UpperCaseDocument());
		textField_matr.setBounds(326, 429, 100, 26);
		this.add(textField_matr);
		
		lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setBounds(262, 434, 52, 16);
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(lblMatrcula);
		
		textField_cpf = new JFormattedTextField(maskCpf);
		textField_cpf.setBounds(112, 467, 122, 26);
		this.add(textField_cpf);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(74, 472, 27, 16);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(lblCpf);
		
		lblNDeIdentidade = new JLabel("N\u00BA da Ident.:");
		lblNDeIdentidade.setBounds(26, 511, 86, 16);
		lblNDeIdentidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(lblNDeIdentidade);
		
		textField_identNum = new JTextField();
		textField_identNum.setDocument(new UpperCaseDocument());
		textField_identNum.setBounds(113, 505, 121, 26);
		this.add(textField_identNum);
		
		textField_ssp = new JTextField();
		textField_ssp.setDocument(new UpperCaseDocument());
		textField_ssp.setBounds(113, 543, 121, 26);
		this.add(textField_ssp);
		
		lblSsp = new JLabel("SSP:");
		lblSsp.setBounds(74, 548, 27, 16);
		lblSsp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(lblSsp);
		
		lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblData.setBounds(292, 548, 29, 16);
		this.add(lblData);
		
		textField_dataIdent = new JFormattedTextField(maskDate);
		textField_dataIdent.setBounds(333, 543, 93, 26);
		this.add(textField_dataIdent);
		
		lblNTtulo = new JLabel("N\u00BA T\u00EDtulo:");
		lblNTtulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNTtulo.setBounds(550, 84, 53, 16);
		this.add(lblNTtulo);
		
		textField_numTitulo = new JTextField();
		textField_numTitulo.setDocument(new UpperCaseDocument());
		textField_numTitulo.setBounds(615, 79, 122, 26);
		this.add(textField_numTitulo);
		
		lblZona = new JLabel("Zona:");
		lblZona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZona.setBounds(782, 84, 31, 16);
		this.add(lblZona);
		
		textField_zona = new JTextField();
		textField_zona.setDocument(new UpperCaseDocument());
		textField_zona.setBounds(825, 78, 93, 26);
		this.add(textField_zona);
		
		lblSeo = new JLabel("Se\u00E7\u00E3o:");
		lblSeo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeo.setBounds(566, 123, 37, 16);
		this.add(lblSeo);
		
		textField_secao = new JTextField();
		textField_secao.setDocument(new UpperCaseDocument());
		textField_secao.setBounds(615, 117, 63, 26);
		this.add(textField_secao);
		
		lblSituaoMilitar = new JLabel("Situa\u00E7\u00E3o Militar:");
		lblSituaoMilitar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSituaoMilitar.setBounds(519, 162, 84, 16);
		this.add(lblSituaoMilitar);
		
		textField_situacaoMil = new JTextField();
		textField_situacaoMil.setDocument(new UpperCaseDocument());
		textField_situacaoMil.setBounds(615, 155, 122, 26);
		this.add(textField_situacaoMil);
		
		lblSrie = new JLabel("S\u00E9rie:");
		lblSrie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSrie.setBounds(572, 198, 31, 15);
		this.add(lblSrie);
		
		textField_serieMil = new JTextField();
		textField_serieMil.setDocument(new UpperCaseDocument());
		textField_serieMil.setBounds(615, 191, 122, 26);
		this.add(textField_serieMil);
		
		lblEsp = new JLabel("Esp.:");
		lblEsp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEsp.setBounds(757, 197, 27, 16);
		this.add(lblEsp);
		
		textField_esp = new JTextField();
		textField_esp.setDocument(new UpperCaseDocument());
		textField_esp.setBounds(796, 192, 122, 26);
		this.add(textField_esp);
		
		lblCtpsN = new JLabel("CTPS N\u00BA:");
		lblCtpsN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCtpsN.setBounds(551, 236, 52, 16);
		this.add(lblCtpsN);
		
		textField_ctps = new JTextField();
		textField_ctps.setDocument(new UpperCaseDocument());
		textField_ctps.setBounds(615, 230, 122, 26);
		this.add(textField_ctps);
		
		lblSrie_1 = new JLabel("S\u00E9rie:");
		lblSrie_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSrie_1.setBounds(572, 275, 31, 16);
		this.add(lblSrie_1);
		
		textField_serieCtps = new JTextField();
		textField_serieCtps.setDocument(new UpperCaseDocument());
		textField_serieCtps.setBounds(615, 269, 122, 26);
		this.add(textField_serieCtps);
		
		lblData_1 = new JLabel("Data:");
		lblData_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblData_1.setBounds(755, 275, 29, 16);
		this.add(lblData_1);
		
		textField_dataCtps = new JFormattedTextField(maskDate);
		textField_dataCtps.setBounds(796, 269, 122, 26);
		this.add(textField_dataCtps);
		
		grauDeInst = new JLabel("Grau de Inst.:");
		grauDeInst.setFont(new Font("Tahoma", Font.PLAIN, 12));
		grauDeInst.setBounds(527, 312, 81, 16);
		this.add(grauDeInst);
		
		textField_grau = new JTextField();
		textField_grau.setDocument(new UpperCaseDocument());
		textField_grau.setBounds(615, 308, 303, 26);
		this.add(textField_grau);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(615, 384, 90, 28);
		btnSalvar.addActionListener(this);
		
		add(btnSalvar);
		
	}
	
	public void carregar_mascaras(){
		
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			maskDate = new MaskFormatter("##/##/####");
			maskCpf.setPlaceholderCharacter('_');
			maskDate.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar MaskFormatter CNPJ!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}


	public void limpar_form(JDesktopPane pane) {       
        
        
		for (int i=0; i < pane.getComponentCount(); i++) {     
                 
            Component c = pane.getComponent(i);  
           
            if(c instanceof JFormattedTextField){
            	JFormattedTextField field = (JFormattedTextField) c;
            	field.setValue(null);
            }
            else if (c instanceof JTextField) {                             
                JTextField field = (JTextField) c;     
                field.setText("");                        
            }
            
        }     
	}
	

	@Override
	public void limpar_tabela(DefaultTableModel model) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		String sexo = (rdbtnMasc.isSelected())?"Masculino":"Feminino";
		
		ControleFuncionario salvarForm = new ControleFuncionario();
		ControleNaturalidade salvarFormNat = new ControleNaturalidade();
		ControleEndereco salvarFormEnd = new ControleEndereco();
		ControleIdentidade salvarFormIdent = new ControleIdentidade();
		ControleTitulo salvarFormTitulo = new ControleTitulo();
		
		ControleAlistamento salvarFormAlist = null;
		if(sexo == "Masculino") salvarFormAlist = new ControleAlistamento();
		
		ControleCarteiraDeTrabalho salvarFormTrab = new ControleCarteiraDeTrabalho();
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			String salvar = salvarForm.salvar(textField_nome.getText(), textField_pai.getText(), textField_mae.getText(),
					new java.sql.Date((formatter.parse(textField_nasc.getText())).getTime()), sexo, textField_civil.getText(), textField_pasep.getText(),
					textField_matr.getText(), textField_cpf.getText(), textField_grau.getText());
			
			String salvarNat = salvarFormNat.salvar(textField_cidade.getText(), comboBox.getSelectedItem().toString());
			
			String salvarEnd = salvarFormEnd.salvar(textField_bairro.getText(), textField_rua.getText(), textField_numero.getText());
			
			String salvarIdent = salvarFormIdent.salvar(textField_identNum.getText(), textField_ssp.getText(), new java.sql.Date((formatter.parse(textField_dataIdent.getText())).getTime()));
			
			String salvarTitulo = salvarFormTitulo.salvar(textField_numTitulo.getText(), textField_zona.getText(), textField_secao.getText());
			
			String salvarAlist = null;
			
			if(salvarFormAlist != null) salvarAlist = salvarFormAlist.salvar(textField_situacaoMil.getText(), textField_serieMil.getText(), textField_esp.getText());
			
			String salvarTrab = salvarFormTrab.salvar(textField_ctps.getText(), textField_serieCtps.getText(), new java.sql.Date((formatter.parse(textField_dataCtps.getText())).getTime()));
			
			if(salvar.substring(22, 29).equals("sucesso") && salvarNat.substring(22, 29).equals("sucesso") &&
					salvarEnd.substring(22, 29).equals("sucesso") && salvarIdent.substring(22, 29).equals("sucesso")
					&& salvarTitulo.substring(22, 29).equals("sucesso")	&& salvarTrab.substring(22, 29).equals("sucesso")){
				
				 if(salvarAlist != null){
					 if(salvarAlist.substring(22, 29).equals("sucesso")){
						 JOptionPane.showMessageDialog(null, "Dados registrados com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
					 }
					 else{
						 JOptionPane.showMessageDialog(null, "Erro ao registrar os Dados!\n"+salvar+"\n"+salvarNat+"\n"+salvarEnd+"\n"+salvarIdent+"\n"+salvarTitulo+"\n"+salvarAlist+"\n"+salvarTrab, "Atenção", JOptionPane.ERROR_MESSAGE);
					 }
				 }
				 else JOptionPane.showMessageDialog(null, "Dados Cadastrados com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
				
				limpar_form(FichaFuncional.this);
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Erro ao Salvar os Dados!\n"+salvar+"\n"+salvarNat+"\n"+salvarEnd+"\n"+salvarIdent+"\n"+salvarTitulo+"\n"+salvarAlist+"\n"+salvarTrab, "Atenção", JOptionPane.ERROR_MESSAGE);
				
				
			}
			
			
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1);
		}
		
	}

	public JTextField getTextField_nome() {
		return textField_nome;
	}

	public void setTextField_nome(JTextField textField_nome) {
		this.textField_nome = textField_nome;
	}

	public JTextField getTextField_pai() {
		return textField_pai;
	}

	public void setTextField_pai(JTextField textField_pai) {
		this.textField_pai = textField_pai;
	}

	public JTextField getTextField_mae() {
		return textField_mae;
	}

	public void setTextField_mae(JTextField textField_mae) {
		this.textField_mae = textField_mae;
	}

	public JFormattedTextField getTextField_nasc() {
		return textField_nasc;
	}

	public void setTextField_nasc(JFormattedTextField textField_nasc) {
		this.textField_nasc = textField_nasc;
	}

	public JTextField getTextField_civil() {
		return textField_civil;
	}

	public void setTextField_civil(JTextField textField_civil) {
		this.textField_civil = textField_civil;
	}

	public JTextField getTextField_cidade() {
		return textField_cidade;
	}

	public void setTextField_cidade(JTextField textField_cidade) {
		this.textField_cidade = textField_cidade;
	}

	public JTextField getTextField_bairro() {
		return textField_bairro;
	}

	public void setTextField_bairro(JTextField textField_bairro) {
		this.textField_bairro = textField_bairro;
	}

	public JTextField getTextField_rua() {
		return textField_rua;
	}

	public void setTextField_rua(JTextField textField_rua) {
		this.textField_rua = textField_rua;
	}

	public JTextField getTextField_numero() {
		return textField_numero;
	}

	public void setTextField_numero(JTextField textField_numero) {
		this.textField_numero = textField_numero;
	}

	public JTextField getTextField_pasep() {
		return textField_pasep;
	}

	public void setTextField_pasep(JTextField textField_pasep) {
		this.textField_pasep = textField_pasep;
	}

	public JTextField getTextField_matr() {
		return textField_matr;
	}

	public void setTextField_matr(JTextField textField_matr) {
		this.textField_matr = textField_matr;
	}

	public JFormattedTextField getTextField_cpf() {
		return textField_cpf;
	}

	public void setTextField_cpf(JFormattedTextField textField_cpf) {
		this.textField_cpf = textField_cpf;
	}

	public JTextField getTextField_identNum() {
		return textField_identNum;
	}

	public void setTextField_identNum(JTextField textField_identNum) {
		this.textField_identNum = textField_identNum;
	}

	public JTextField getTextField_ssp() {
		return textField_ssp;
	}

	public void setTextField_ssp(JTextField textField_ssp) {
		this.textField_ssp = textField_ssp;
	}

	public JFormattedTextField getTextField_dataIdent() {
		return textField_dataIdent;
	}

	public void setTextField_dataIdent(JFormattedTextField textField_dataIdent) {
		this.textField_dataIdent = textField_dataIdent;
	}

	public JTextField getTextField_numTitulo() {
		return textField_numTitulo;
	}

	public void setTextField_numTitulo(JTextField textField_numTitulo) {
		this.textField_numTitulo = textField_numTitulo;
	}

	public JTextField getTextField_zona() {
		return textField_zona;
	}

	public void setTextField_zona(JTextField textField_zona) {
		this.textField_zona = textField_zona;
	}

	public JTextField getTextField_secao() {
		return textField_secao;
	}

	public void setTextField_secao(JTextField textField_secao) {
		this.textField_secao = textField_secao;
	}

	public JLabel getLblFichaFuncional() {
		return lblFichaFuncional;
	}

	public void setLblFichaFuncional(JLabel lblFichaFuncional) {
		this.lblFichaFuncional = lblFichaFuncional;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblPai() {
		return lblPai;
	}

	public void setLblPai(JLabel lblPai) {
		this.lblPai = lblPai;
	}

	public JLabel getLblMae() {
		return lblMae;
	}

	public void setLblMae(JLabel lblMae) {
		this.lblMae = lblMae;
	}

	public JLabel getLblDataDeNasc() {
		return lblDataDeNasc;
	}

	public void setLblDataDeNasc(JLabel lblDataDeNasc) {
		this.lblDataDeNasc = lblDataDeNasc;
	}

	public JLabel getLblSexo() {
		return lblSexo;
	}

	public void setLblSexo(JLabel lblSexo) {
		this.lblSexo = lblSexo;
	}

	public JLabel getLblEstCivil() {
		return lblEstCivil;
	}

	public void setLblEstCivil(JLabel lblEstCivil) {
		this.lblEstCivil = lblEstCivil;
	}

	public JLabel getLblCidade() {
		return lblCidade;
	}

	public void setLblCidade(JLabel lblCidade) {
		this.lblCidade = lblCidade;
	}

	public JLabel getLblBairro() {
		return lblBairro;
	}

	public void setLblBairro(JLabel lblBairro) {
		this.lblBairro = lblBairro;
	}

	public JLabel getLblLogradouro() {
		return lblLogradouro;
	}

	public void setLblLogradouro(JLabel lblLogradouro) {
		this.lblLogradouro = lblLogradouro;
	}

	public JLabel getLblNmero() {
		return lblNmero;
	}

	public void setLblNmero(JLabel lblNmero) {
		this.lblNmero = lblNmero;
	}

	public JLabel getLblPasep() {
		return lblPasep;
	}

	public void setLblPasep(JLabel lblPasep) {
		this.lblPasep = lblPasep;
	}

	public JLabel getLblMatrcula() {
		return lblMatrcula;
	}

	public void setLblMatrcula(JLabel lblMatrcula) {
		this.lblMatrcula = lblMatrcula;
	}

	public JLabel getLblCpf() {
		return lblCpf;
	}

	public void setLblCpf(JLabel lblCpf) {
		this.lblCpf = lblCpf;
	}

	public JLabel getLblNDeIdentidade() {
		return lblNDeIdentidade;
	}

	public void setLblNDeIdentidade(JLabel lblNDeIdentidade) {
		this.lblNDeIdentidade = lblNDeIdentidade;
	}

	public JLabel getLblSsp() {
		return lblSsp;
	}

	public void setLblSsp(JLabel lblSsp) {
		this.lblSsp = lblSsp;
	}

	public JLabel getGrauDeInst() {
		return grauDeInst;
	}

	public void setGrauDeInst(JLabel grauDeInst) {
		this.grauDeInst = grauDeInst;
	}

	public JLabel getLblData() {
		return lblData;
	}

	public void setLblData(JLabel lblData) {
		this.lblData = lblData;
	}

	public JLabel getLblNTtulo() {
		return lblNTtulo;
	}

	public void setLblNTtulo(JLabel lblNTtulo) {
		this.lblNTtulo = lblNTtulo;
	}

	public JLabel getLblZona() {
		return lblZona;
	}

	public void setLblZona(JLabel lblZona) {
		this.lblZona = lblZona;
	}

	public JLabel getLblSeo() {
		return lblSeo;
	}

	public void setLblSeo(JLabel lblSeo) {
		this.lblSeo = lblSeo;
	}

	public JLabel getLblSituaoMilitar() {
		return lblSituaoMilitar;
	}

	public void setLblSituaoMilitar(JLabel lblSituaoMilitar) {
		this.lblSituaoMilitar = lblSituaoMilitar;
	}

	public JLabel getLblSrie() {
		return lblSrie;
	}

	public void setLblSrie(JLabel lblSrie) {
		this.lblSrie = lblSrie;
	}

	public JLabel getLblEsp() {
		return lblEsp;
	}

	public void setLblEsp(JLabel lblEsp) {
		this.lblEsp = lblEsp;
	}

	public JLabel getLblCtpsN() {
		return lblCtpsN;
	}

	public void setLblCtpsN(JLabel lblCtpsN) {
		this.lblCtpsN = lblCtpsN;
	}

	public JLabel getLblSrie_1() {
		return lblSrie_1;
	}

	public void setLblSrie_1(JLabel lblSrie_1) {
		this.lblSrie_1 = lblSrie_1;
	}

	public JLabel getLblData_1() {
		return lblData_1;
	}

	public void setLblData_1(JLabel lblData_1) {
		this.lblData_1 = lblData_1;
	}

	public JRadioButton getRdbtnMasc() {
		return rdbtnMasc;
	}

	public void setRdbtnMasc(JRadioButton rdbtnMasc) {
		this.rdbtnMasc = rdbtnMasc;
	}

	public JRadioButton getRdbtnFem() {
		return rdbtnFem;
	}

	public void setRdbtnFem(JRadioButton rdbtnFem) {
		this.rdbtnFem = rdbtnFem;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public JTextField getTextField_situacaoMil() {
		return textField_situacaoMil;
	}

	public void setTextField_situacaoMil(JTextField textField_situacaoMil) {
		this.textField_situacaoMil = textField_situacaoMil;
	}

	public JTextField getTextField_serieMil() {
		return textField_serieMil;
	}

	public void setTextField_serieMil(JTextField textField_serieMil) {
		this.textField_serieMil = textField_serieMil;
	}

	public JTextField getTextField_esp() {
		return textField_esp;
	}

	public void setTextField_esp(JTextField textField_esp) {
		this.textField_esp = textField_esp;
	}

	public JTextField getTextField_ctps() {
		return textField_ctps;
	}

	public void setTextField_ctps(JTextField textField_ctps) {
		this.textField_ctps = textField_ctps;
	}

	public JTextField getTextField_serieCtps() {
		return textField_serieCtps;
	}

	public void setTextField_serieCtps(JTextField textField_serieCtps) {
		this.textField_serieCtps = textField_serieCtps;
	}

	public JFormattedTextField getTextField_dataCtps() {
		return textField_dataCtps;
	}

	public void setTextField_dataCtps(JFormattedTextField textField_dataCtps) {
		this.textField_dataCtps = textField_dataCtps;
	}

	public JTextField getTextField_grau() {
		return textField_grau;
	}

	public void setTextField_grau(JTextField textField_grau) {
		this.textField_grau = textField_grau;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public MaskFormatter getMaskCpf() {
		return maskCpf;
	}

	public void setMaskCpf(MaskFormatter maskCpf) {
		this.maskCpf = maskCpf;
	}

	public MaskFormatter getMaskDate() {
		return maskDate;
	}

	public void setMaskDate(MaskFormatter maskDate) {
		this.maskDate = maskDate;
	}

	public String[] getEstados() {
		return estados;
	}
	
	
	
	/*private void Rollback(String form_1, String form_2, String form_3, String form_4, String form_5,
			String form_6, String form_7){
		
		ControleFuncionario excluirForm = new ControleFuncionario();
		ControleNaturalidade excluirFormNat = new ControleNaturalidade();
		ControleEndereco excluirFormEnd = new ControleEndereco();
		ControleIdentidade excluirFormIdent = new ControleIdentidade();
		ControleTitulo excluirFormTitulo = new ControleTitulo();
		ControleAlistamento excluirFormAlist = new ControleAlistamento();
		ControleCarteiraDeTrabalho excluirFormTrab = new ControleCarteiraDeTrabalho();
		if(form_1.substring(22,29).equals("sucesso")){
			
			//excluirForm.
			
		}
		
		
	}*/
}
