package widgets;

import javax.swing.JDesktopPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import controle.ControleFerias;
import controle.ControleLicenca;
import controle.ControleTipoLicenca;
import controle.ControleVidaFuncional;
import controle.classes_complementares.UpperCaseDocument;
import controle.interfaceControle.I_ControleTipoLicenca;

import widgets.interfaceWidgets.ControleComponentes;

public class Historico extends JDesktopPane implements ActionListener, ControleComponentes{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_atoFunc;
	private JFormattedTextField textField_nom;
	private JFormattedTextField textField_exer;
	private JFormattedTextField textField_licen;
	private JFormattedTextField textField_alt;
	private JTextField textField_carg;
	private JTextField textField_fs;
	private JTextField textField_p;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_ferias, scrollPane_2;
	private JScrollPane scrollPane_licenca;
	private JFormattedTextField textField_inicio;
	private JFormattedTextField textField_term;
	private JTextField textField_pAq;
	private JTextField textField_pGozo;
	private JTextField textField_portFerias;
	private JTextField textField_portLicen;
	private JLabel lblVidaFuncional, lblAtoport, lblNomeao, lblExerccio, lblLicena, lblAlterao, lblCargo;
	private JLabel lblFs, lblP, lblLicenas, lblIncio, lblTrmino, lblTipo, lblFrias, lblPerodoAq, lblPerodoDeGozo;
	private JLabel lblPortariadata, lblPortariadata_1; 
	private JComboBox<String> comboBox;
	private JScrollPane scrollPane_1;
	private JTextArea textArea_licen, textArea_vidaFunc;
	private JButton buttonAdd_1, buttonAdd_2, buttonAdd_3;
	private JButton salvar_1, salvar_2, salvar_3;
	private JButton deletar_1, deletar_2, deletar_3;
	private DefaultTableModel modelo_vidaFunc, modelo_Ferias, modelo_Licenca;
	private JTable table_vidaFunc, table_ferias, table_licenca;
	private MaskFormatter maskDate;

	public Historico() {
		
		UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.setPreferredSize(new Dimension(996,870));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));

		carregar_mascaras();
		carregar_componentes();
		construir_Tabela_Vida_Funcional();
		construir_tabela_Licenca();
		construir_tabela_Ferias();
		
		setVisible(true);
		
			
	}
	
	private void carregar_componentes(){
		
		lblVidaFuncional = new JLabel("VIDA FUNCIONAL");
		lblVidaFuncional.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVidaFuncional.setBounds(32, 32-8, 143, 14);
		this.add(lblVidaFuncional);
		
		lblAtoport = new JLabel("Ato/Port.:");
		lblAtoport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtoport.setBounds(30, 70, 56, 14);
		this.add(lblAtoport);
		
		textField_atoFunc = new JTextField();
		textField_atoFunc.setDocument(new UpperCaseDocument());
		textField_atoFunc.setBounds(96, 64, 116, 26);
		this.add(textField_atoFunc);
		
		lblNomeao = new JLabel("Nomea\u00E7\u00E3o:");
		lblNomeao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeao.setBounds(22, 106, 64, 16);
		this.add(lblNomeao);
		
		lblExerccio = new JLabel("Exerc\u00EDcio:");
		lblExerccio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblExerccio.setBounds(187, 106, 52, 16);
		this.add(lblExerccio);
		
		textField_nom = new JFormattedTextField(maskDate);
		textField_nom.setBounds(96, 101, 79, 26);
		this.add(textField_nom);
		
		textField_exer = new JFormattedTextField(maskDate);
		textField_exer.setBounds(247, 101, 79, 26);
		this.add(textField_exer);
		
		lblLicena = new JLabel("Licen\u00E7a:");
		lblLicena.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLicena.setBounds(42, 143, 44, 16);
		this.add(lblLicena);
		
		textField_licen = new JFormattedTextField(maskDate);
		textField_licen.setBounds(96, 138, 79, 26);
		this.add(textField_licen);
		
		lblAlterao = new JLabel("Altera\u00E7\u00E3o:");
		lblAlterao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAlterao.setBounds(185, 143, 55, 16);
		this.add(lblAlterao);
		
		textField_alt = new JFormattedTextField(maskDate);
		textField_alt.setBounds(247, 138, 79, 26);
		this.add(textField_alt);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCargo.setBounds(51, 180, 35, 16);
		this.add(lblCargo);
		
		textField_carg = new JTextField();
		textField_carg.setDocument(new UpperCaseDocument());
		textField_carg.setBounds(96, 175, 230, 26);
		this.add(textField_carg);
		textField_carg.setColumns(10);
		
		lblFs = new JLabel("F.S.:");
		lblFs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFs.setBounds(62, 217, 25, 16);
		this.add(lblFs);
		
		textField_fs = new JTextField();
		textField_fs.setDocument(new UpperCaseDocument());
		textField_fs.setBounds(96, 212, 35, 26);
		this.add(textField_fs);
		
		lblP = new JLabel("P.:");
		lblP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblP.setBounds(143, 217, 15, 18);
		this.add(lblP);
		
		textField_p = new JTextField();
		textField_p.setDocument(new UpperCaseDocument());
		textField_p.setBounds(167, 213, 35, 26);
		this.add(textField_p);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(461, 101, 507, 222);
		this.add(scrollPane);
		
		buttonAdd_1 = new JButton("Adicionar >>");
		buttonAdd_1.setBounds(345, 195, 100, 30);
		buttonAdd_1.addActionListener(this);
		this.add(buttonAdd_1);
		
		salvar_1 = new JButton("Salvar");
		salvar_1.setBounds(761, 70, 100, 30);
		salvar_1.addActionListener(this);
		this.add(salvar_1);
		
		deletar_1 = new JButton("Deletar");
		deletar_1.setBounds(867, 70, 100, 30);
		deletar_1.addActionListener(this);
		this.add(deletar_1);
		
		lblLicenas = new JLabel("LICEN\u00C7AS");
		lblLicenas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLicenas.setBounds(32, 394-25, 101, 16);
		this.add(lblLicenas);
		
		lblIncio = new JLabel("In\u00EDcio:");
		lblIncio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIncio.setBounds(54, 427, 32, 16);
		this.add(lblIncio);
		
		textField_inicio = new JFormattedTextField(maskDate);
		textField_inicio.setBounds(96, 422, 91, 26);
		this.add(textField_inicio);
		
		lblTrmino = new JLabel("T\u00E9rm.:");
		lblTrmino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTrmino.setBounds(191, 426, 37, 16);
		this.add(lblTrmino);
		
		textField_term = new JFormattedTextField(maskDate);
		textField_term.setBounds(235, 422, 91, 26);
		this.add(textField_term);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipo.setBounds(58, 503, 28, 16);
		this.add(lblTipo);
		
		comboBox = new JComboBox<String>(listarLicencas("nomeTipo"));
		comboBox.setBounds(96, 498, 122, 26);
		this.add(comboBox);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(96, 534, 230, 73);
		this.add(scrollPane_1);
		
		textArea_licen = new JTextArea("Observações:");
		textArea_licen.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_licen);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(96, 250, 230, 73);
		this.add(scrollPane_2);
		
		textArea_vidaFunc = new JTextArea("Observações:");
		textArea_vidaFunc.setLineWrap(true);
		scrollPane_2.setViewportView(textArea_vidaFunc);
		
		buttonAdd_2 = new JButton("Adicionar >>");
		buttonAdd_2.setBounds(345, 500, 100, 30);
		buttonAdd_2.addActionListener(this);
		this.add(buttonAdd_2);
		
		salvar_2 = new JButton("Salvar");
		salvar_2.setBounds(761, 391, 100, 30);
		salvar_2.addActionListener(this);
		this.add(salvar_2);
		
		deletar_2 = new JButton("Deletar");
		deletar_2.setBounds(867, 391, 100, 30);
		deletar_2.addActionListener(this);
		this.add(deletar_2);
		
		lblFrias = new JLabel("F\u00C9RIAS");
		lblFrias.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFrias.setBounds(32, 555+110-25, 61, 16);
		this.add(lblFrias);
		
		lblPerodoAq = new JLabel("P. Aquisitivo:");
		lblPerodoAq.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPerodoAq.setBounds(16, 588+110, 70, 16);
		this.add(lblPerodoAq);
		
		textField_pAq = new JTextField();
		textField_pAq.setDocument(new UpperCaseDocument());
		textField_pAq.setBounds(96, 582+110, 230, 28);
		this.add(textField_pAq);
		
		lblPerodoDeGozo = new JLabel("P. de Gozo:");
		lblPerodoDeGozo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPerodoDeGozo.setBounds(22, 628+110, 64, 16);
		this.add(lblPerodoDeGozo);
		
		textField_pGozo = new JTextField();
		textField_pGozo.setDocument(new UpperCaseDocument());
		textField_pGozo.setBounds(96, 622+110, 230, 28);
		this.add(textField_pGozo);
		
		lblPortariadata = new JLabel("Portaria/Data:");
		lblPortariadata.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPortariadata.setBounds(11, 667+110, 75, 16);
		this.add(lblPortariadata);
		
		textField_portFerias = new JTextField();
		textField_portFerias.setDocument(new UpperCaseDocument());
		textField_portFerias.setBounds(96, 662+110, 122, 26);
		this.add(textField_portFerias);
		
		scrollPane_licenca = new JScrollPane();
		scrollPane_licenca.setBounds(461, 422, 507, 185);
		this.add(scrollPane_licenca);
				
		scrollPane_ferias = new JScrollPane();
		scrollPane_ferias.setBounds(461, 691, 507, 132);
		this.add(scrollPane_ferias);
		
		textField_portLicen = new JTextField();
		textField_portLicen.setDocument(new UpperCaseDocument());
		textField_portLicen.setBounds(96, 460, 122, 26);
		this.add(textField_portLicen);
		
		lblPortariadata_1 = new JLabel("Portaria/Data:");
		lblPortariadata_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPortariadata_1.setBounds(11, 464, 75, 16);
		this.add(lblPortariadata_1);
		
		buttonAdd_3 = new JButton("Adicionar >>");
		buttonAdd_3.setBounds(345, 743, 100, 30);
		buttonAdd_3.addActionListener(this);
		this.add(buttonAdd_3);
		
		salvar_3 = new JButton("Salvar");
		salvar_3.setBounds(761, 660, 100, 30);
		salvar_3.addActionListener(this);
		this.add(salvar_3);
		
		deletar_3 = new JButton("Deletar");
		deletar_3.setBounds(867, 660, 100, 30);
		deletar_3.addActionListener(this);
		this.add(deletar_3);
		
	}
	
	private String[] listarLicencas(String nome){
		
		I_ControleTipoLicenca listar = new ControleTipoLicenca();
		return listar.listar(nome);
	}
	
	private void construir_Tabela_Vida_Funcional(){
		
		
		String[] colunas = new String[11];
		
		colunas[0] = "Ato/Port.";
		colunas[1] = "Nomeação";
		colunas[2] = "Exercício";
		colunas[3] = "Licença";
		colunas[4] = "Alteração";
		colunas[5] = "Cargo";
		colunas[6] = "FS";
		colunas[7] = "P";
		colunas[8] = "Secretaria";
		colunas[9] = "Localização";
		colunas[10] = "Observações";
		
		modelo_vidaFunc = new DefaultTableModel(new Object[][]{}, colunas);
		
		table_vidaFunc = new JTable(modelo_vidaFunc);
		table_vidaFunc.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_vidaFunc.setSelectionMode(LIVE_DRAG_MODE);
		table_vidaFunc.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_vidaFunc.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_vidaFunc.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_vidaFunc.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_vidaFunc.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_vidaFunc.getColumnModel().getColumn(5).setPreferredWidth(200);
		table_vidaFunc.getColumnModel().getColumn(6).setPreferredWidth(50);
		table_vidaFunc.getColumnModel().getColumn(7).setPreferredWidth(50);
		table_vidaFunc.getColumnModel().getColumn(8).setPreferredWidth(250);
		table_vidaFunc.getColumnModel().getColumn(9).setPreferredWidth(200);
		table_vidaFunc.getColumnModel().getColumn(10).setPreferredWidth(300);
		table_vidaFunc.setFillsViewportHeight(true);
		table_vidaFunc.getTableHeader().setReorderingAllowed(false);
		
		scrollPane.setViewportView(table_vidaFunc);		
		
	}
	
	private void construir_tabela_Licenca(){
		
		
		String[] colunas = new String[5];
		
		colunas[0] = "Tipo de Licença";
		colunas[1] = "Início";
		colunas[2] = "Término";
		colunas[3] = "Portaria/Data";
		colunas[4] = "Observações";
		
		modelo_Licenca = new DefaultTableModel(new Object[][]{}, colunas);
		
		table_licenca = new JTable(modelo_Licenca);
		table_licenca.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_licenca.setSelectionMode(LIVE_DRAG_MODE);
		table_licenca.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_licenca.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_licenca.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_licenca.getColumnModel().getColumn(3).setPreferredWidth(110);
		table_licenca.getColumnModel().getColumn(4).setPreferredWidth(200);
		table_licenca.setFillsViewportHeight(true);
		table_licenca.getTableHeader().setReorderingAllowed(false);
		
		scrollPane_licenca.setViewportView(table_licenca);
		
	}
	
	private void construir_tabela_Ferias(){
		
		
		String[] colunas = new String[3];
		
		colunas[0] = "Período Arquisitivo";
		colunas[1] = "Período de Gozo";
		colunas[2] = "Portaria/Data";
		
		modelo_Ferias = new DefaultTableModel(new Object[][]{}, colunas);
		
		table_ferias = new JTable(modelo_Ferias);
		table_ferias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_ferias.setSelectionMode(LIVE_DRAG_MODE);
		table_ferias.getColumnModel().getColumn(0).setPreferredWidth(200);
		table_ferias.getColumnModel().getColumn(1).setPreferredWidth(200);
		table_ferias.getColumnModel().getColumn(2).setPreferredWidth(105);
		table_ferias.setFillsViewportHeight(true);
		table_ferias.getTableHeader().setReorderingAllowed(false);
		
		scrollPane_ferias.setViewportView(table_ferias);
		
	}
	
	public void carregar_mascaras(){
		
		try {
			maskDate = new MaskFormatter("##/##/####");
			maskDate.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar MaskFormatter CNPJ!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}


	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == buttonAdd_1){
				
			modelo_vidaFunc.addRow(new String[]{textField_atoFunc.getText(), textField_nom.getText(), textField_exer.getText(),
					textField_licen.getText(), textField_alt.getText(), textField_carg.getText(), textField_fs.getText(),
					textField_p.getText(), "SECRETARIA MUNICIPAL DE SAÚDE", "AFOGADOS DA INGAZEIRA", textArea_vidaFunc.getText()});
			
			limpar_form(this);
			
		}
		
		else if(e.getSource() == salvar_1){
			
			ControleVidaFuncional salvarForm = new ControleVidaFuncional();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String resultado = "";
			
			if(table_vidaFunc.getRowCount() > 0){
				
				for (int i = 0; i < table_vidaFunc.getRowCount(); i++) {
					
					try {
						resultado = salvarForm.salvar(0, table_vidaFunc.getValueAt(i, 0).toString(),new java.sql.Date((formatter.parse(table_vidaFunc.getValueAt(i, 1).toString())).getTime()),
								new java.sql.Date((formatter.parse(table_vidaFunc.getValueAt(i, 2).toString())).getTime()),new java.sql.Date((formatter.parse(table_vidaFunc.getValueAt(i, 3).toString())).getTime()),
								new java.sql.Date((formatter.parse(table_vidaFunc.getValueAt(i, 4).toString())).getTime()),table_vidaFunc.getValueAt(i, 5).toString(),table_vidaFunc.getValueAt(i, 6).toString(),
								table_vidaFunc.getValueAt(i, 7).toString(),table_vidaFunc.getValueAt(i, 8).toString(),table_vidaFunc.getValueAt(i, 9).toString(),
								table_vidaFunc.getValueAt(i, 10).toString(), 1);
																	
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					if(resultado.substring(0, 4).equals("Erro"))break;
					
				}
				JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
				
				limpar_tabela(modelo_vidaFunc);
				
			}else JOptionPane.showMessageDialog(null, "Tabela Vazia!");
			
		}
		
		else if(e.getSource() == deletar_1){
			
			if(table_vidaFunc.getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
			else modelo_vidaFunc.removeRow(table_vidaFunc.getSelectedRow());
			
		}
		
		else if (e.getSource() == buttonAdd_2) {
			
			modelo_Licenca.addRow(new String[]{(String) comboBox.getSelectedItem(),textField_inicio.getText(), textField_term.getText(), textField_portLicen.getText(),
					textArea_licen.getText()});
			
			limpar_form(this);
		}
		
		else if (e.getSource() == salvar_2) {
			
			ControleLicenca salvarForm = new ControleLicenca();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String resultado = "";
			
			if(table_licenca.getRowCount() > 0){
				
				for (int j = 0; j < table_licenca.getRowCount(); j++) {
					
					try {
						resultado = salvarForm.salvar(0, table_licenca.getValueAt(j, 0).toString(), new java.sql.Date((formatter.parse(table_licenca.getValueAt(j, 1).toString())).getTime()),
								new java.sql.Date((formatter.parse(table_licenca.getValueAt(j, 2).toString())).getTime()), table_licenca.getValueAt(j, 3).toString(),
								table_licenca.getValueAt(j, 4).toString(), 1);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					if(resultado.substring(0, 4).equals("Erro"))break;
					
				}
				JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
				
				limpar_tabela(modelo_Licenca);
								
			}else JOptionPane.showMessageDialog(null, "Tabela Vazia!");
			
		}
		
		else if (e.getSource() == deletar_2) {
			
			if(table_licenca.getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
			else modelo_Licenca.removeRow(table_licenca.getSelectedRow());
			
		}
		
		else if (e.getSource() == buttonAdd_3) {
			
			modelo_Ferias.addRow(new String[]{textField_pAq.getText(), textField_pGozo.getText(), textField_portFerias.getText()});
			limpar_form(this);
		}
		
		else if (e.getSource() == salvar_3) {
			
			ControleFerias salvarForm = new ControleFerias();
			String resultado = "";
			
			if(table_ferias.getRowCount() > 0){
				for (int i = 0; i < table_ferias.getRowCount(); i++) {
		
					resultado = salvarForm.salvar(0, table_ferias.getValueAt(i, 0).toString(), table_ferias.getValueAt(i, 1).toString(),
							table_ferias.getValueAt(i, 2).toString(), 1);
						
				}			
				JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
				
				limpar_tabela(modelo_Ferias);
				
			}else JOptionPane.showMessageDialog(null, "Tabela Vazia!");
		}
		
		else if (e.getSource() == deletar_3) {
			
			if(table_ferias.getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");
			else modelo_Ferias.removeRow(table_ferias.getSelectedRow());
			
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

	public void limpar_tabela(DefaultTableModel model) {
		model.setNumRows(0); 
	}

	public JTextField getTextField_atoFunc() {
		return textField_atoFunc;
	}

	public void setTextField_atoFunc(JTextField textField_atoFunc) {
		this.textField_atoFunc = textField_atoFunc;
	}

	public JFormattedTextField getTextField_nom() {
		return textField_nom;
	}

	public void setTextField_nom(JFormattedTextField textField_nom) {
		this.textField_nom = textField_nom;
	}

	public JFormattedTextField getTextField_exer() {
		return textField_exer;
	}

	public void setTextField_exer(JFormattedTextField textField_exer) {
		this.textField_exer = textField_exer;
	}

	public JFormattedTextField getTextField_licen() {
		return textField_licen;
	}

	public void setTextField_licen(JFormattedTextField textField_licen) {
		this.textField_licen = textField_licen;
	}

	public JFormattedTextField getTextField_alt() {
		return textField_alt;
	}

	public void setTextField_alt(JFormattedTextField textField_alt) {
		this.textField_alt = textField_alt;
	}

	public JTextField getTextField_carg() {
		return textField_carg;
	}

	public void setTextField_carg(JTextField textField_carg) {
		this.textField_carg = textField_carg;
	}

	public JTextField getTextField_fs() {
		return textField_fs;
	}

	public void setTextField_fs(JTextField textField_fs) {
		this.textField_fs = textField_fs;
	}

	public JTextField getTextField_p() {
		return textField_p;
	}

	public void setTextField_p(JTextField textField_p) {
		this.textField_p = textField_p;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JScrollPane getScrollPane_ferias() {
		return scrollPane_ferias;
	}

	public void setScrollPane_ferias(JScrollPane scrollPane_ferias) {
		this.scrollPane_ferias = scrollPane_ferias;
	}

	public JScrollPane getScrollPane_2() {
		return scrollPane_2;
	}

	public void setScrollPane_2(JScrollPane scrollPane_2) {
		this.scrollPane_2 = scrollPane_2;
	}

	public JScrollPane getScrollPane_licenca() {
		return scrollPane_licenca;
	}

	public void setScrollPane_licenca(JScrollPane scrollPane_licenca) {
		this.scrollPane_licenca = scrollPane_licenca;
	}

	public JFormattedTextField getTextField_inicio() {
		return textField_inicio;
	}

	public void setTextField_inicio(JFormattedTextField textField_inicio) {
		this.textField_inicio = textField_inicio;
	}

	public JFormattedTextField getTextField_term() {
		return textField_term;
	}

	public void setTextField_term(JFormattedTextField textField_term) {
		this.textField_term = textField_term;
	}

	public JTextField getTextField_pAq() {
		return textField_pAq;
	}

	public void setTextField_pAq(JTextField textField_pAq) {
		this.textField_pAq = textField_pAq;
	}

	public JTextField getTextField_pGozo() {
		return textField_pGozo;
	}

	public void setTextField_pGozo(JTextField textField_pGozo) {
		this.textField_pGozo = textField_pGozo;
	}

	public JTextField getTextField_portFerias() {
		return textField_portFerias;
	}

	public void setTextField_portFerias(JTextField textField_portFerias) {
		this.textField_portFerias = textField_portFerias;
	}

	public JTextField getTextField_portLicen() {
		return textField_portLicen;
	}

	public void setTextField_portLicen(JTextField textField_portLicen) {
		this.textField_portLicen = textField_portLicen;
	}

	public JLabel getLblVidaFuncional() {
		return lblVidaFuncional;
	}

	public void setLblVidaFuncional(JLabel lblVidaFuncional) {
		this.lblVidaFuncional = lblVidaFuncional;
	}

	public JLabel getLblAtoport() {
		return lblAtoport;
	}

	public void setLblAtoport(JLabel lblAtoport) {
		this.lblAtoport = lblAtoport;
	}

	public JLabel getLblNomeao() {
		return lblNomeao;
	}

	public void setLblNomeao(JLabel lblNomeao) {
		this.lblNomeao = lblNomeao;
	}

	public JLabel getLblExerccio() {
		return lblExerccio;
	}

	public void setLblExerccio(JLabel lblExerccio) {
		this.lblExerccio = lblExerccio;
	}

	public JLabel getLblLicena() {
		return lblLicena;
	}

	public void setLblLicena(JLabel lblLicena) {
		this.lblLicena = lblLicena;
	}

	public JLabel getLblAlterao() {
		return lblAlterao;
	}

	public void setLblAlterao(JLabel lblAlterao) {
		this.lblAlterao = lblAlterao;
	}

	public JLabel getLblCargo() {
		return lblCargo;
	}

	public void setLblCargo(JLabel lblCargo) {
		this.lblCargo = lblCargo;
	}

	public JLabel getLblFs() {
		return lblFs;
	}

	public void setLblFs(JLabel lblFs) {
		this.lblFs = lblFs;
	}

	public JLabel getLblP() {
		return lblP;
	}

	public void setLblP(JLabel lblP) {
		this.lblP = lblP;
	}

	public JLabel getLblLicenas() {
		return lblLicenas;
	}

	public void setLblLicenas(JLabel lblLicenas) {
		this.lblLicenas = lblLicenas;
	}

	public JLabel getLblIncio() {
		return lblIncio;
	}

	public void setLblIncio(JLabel lblIncio) {
		this.lblIncio = lblIncio;
	}

	public JLabel getLblTrmino() {
		return lblTrmino;
	}

	public void setLblTrmino(JLabel lblTrmino) {
		this.lblTrmino = lblTrmino;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public void setLblTipo(JLabel lblTipo) {
		this.lblTipo = lblTipo;
	}

	public JLabel getLblFrias() {
		return lblFrias;
	}

	public void setLblFrias(JLabel lblFrias) {
		this.lblFrias = lblFrias;
	}

	public JLabel getLblPerodoAq() {
		return lblPerodoAq;
	}

	public void setLblPerodoAq(JLabel lblPerodoAq) {
		this.lblPerodoAq = lblPerodoAq;
	}

	public JLabel getLblPerodoDeGozo() {
		return lblPerodoDeGozo;
	}

	public void setLblPerodoDeGozo(JLabel lblPerodoDeGozo) {
		this.lblPerodoDeGozo = lblPerodoDeGozo;
	}

	public JLabel getLblPortariadata() {
		return lblPortariadata;
	}

	public void setLblPortariadata(JLabel lblPortariadata) {
		this.lblPortariadata = lblPortariadata;
	}

	public JLabel getLblPortariadata_1() {
		return lblPortariadata_1;
	}

	public void setLblPortariadata_1(JLabel lblPortariadata_1) {
		this.lblPortariadata_1 = lblPortariadata_1;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	public void setScrollPane_1(JScrollPane scrollPane_1) {
		this.scrollPane_1 = scrollPane_1;
	}

	public JTextArea getTextArea_licen() {
		return textArea_licen;
	}

	public void setTextArea_licen(JTextArea textArea_licen) {
		this.textArea_licen = textArea_licen;
	}

	public JTextArea getTextArea_vidaFunc() {
		return textArea_vidaFunc;
	}

	public void setTextArea_vidaFunc(JTextArea textArea_vidaFunc) {
		this.textArea_vidaFunc = textArea_vidaFunc;
	}

	public JButton getButtonAdd_1() {
		return buttonAdd_1;
	}

	public void setButtonAdd_1(JButton buttonAdd_1) {
		this.buttonAdd_1 = buttonAdd_1;
	}

	public JButton getButtonAdd_2() {
		return buttonAdd_2;
	}

	public void setButtonAdd_2(JButton buttonAdd_2) {
		this.buttonAdd_2 = buttonAdd_2;
	}

	public JButton getButtonAdd_3() {
		return buttonAdd_3;
	}

	public void setButtonAdd_3(JButton buttonAdd_3) {
		this.buttonAdd_3 = buttonAdd_3;
	}

	public JButton getSalvar_1() {
		return salvar_1;
	}

	public void setSalvar_1(JButton salvar_1) {
		this.salvar_1 = salvar_1;
	}

	public JButton getSalvar_2() {
		return salvar_2;
	}

	public void setSalvar_2(JButton salvar_2) {
		this.salvar_2 = salvar_2;
	}

	public JButton getSalvar_3() {
		return salvar_3;
	}

	public void setSalvar_3(JButton salvar_3) {
		this.salvar_3 = salvar_3;
	}

	public JButton getDeletar_1() {
		return deletar_1;
	}

	public void setDeletar_1(JButton deletar_1) {
		this.deletar_1 = deletar_1;
	}

	public JButton getDeletar_2() {
		return deletar_2;
	}

	public void setDeletar_2(JButton deletar_2) {
		this.deletar_2 = deletar_2;
	}

	public JButton getDeletar_3() {
		return deletar_3;
	}

	public void setDeletar_3(JButton deletar_3) {
		this.deletar_3 = deletar_3;
	}

	public DefaultTableModel getModelo_vidaFunc() {
		return modelo_vidaFunc;
	}

	public void setModelo_vidaFunc(DefaultTableModel modelo_vidaFunc) {
		this.modelo_vidaFunc = modelo_vidaFunc;
	}

	public DefaultTableModel getModelo_Ferias() {
		return modelo_Ferias;
	}

	public void setModelo_Ferias(DefaultTableModel modelo_Ferias) {
		this.modelo_Ferias = modelo_Ferias;
	}

	public DefaultTableModel getModelo_Licenca() {
		return modelo_Licenca;
	}

	public void setModelo_Licenca(DefaultTableModel modelo_Licenca) {
		this.modelo_Licenca = modelo_Licenca;
	}

	public JTable getTable_vidaFunc() {
		return table_vidaFunc;
	}

	public void setTable_vidaFunc(JTable table_vidaFunc) {
		this.table_vidaFunc = table_vidaFunc;
	}

	public JTable getTable_ferias() {
		return table_ferias;
	}

	public void setTable_ferias(JTable table_ferias) {
		this.table_ferias = table_ferias;
	}

	public JTable getTable_licenca() {
		return table_licenca;
	}

	public void setTable_licenca(JTable table_licenca) {
		this.table_licenca = table_licenca;
	}

	public MaskFormatter getMaskDate() {
		return maskDate;
	}

	public void setMaskDate(MaskFormatter maskDate) {
		this.maskDate = maskDate;
	}
	
	
}
