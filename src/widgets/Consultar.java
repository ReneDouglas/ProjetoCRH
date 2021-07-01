package widgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

import admBanco.AdmBancoSql;
import controle.ControleFuncionario;
import controle.classes_complementares.Background;
import javax.swing.border.EtchedBorder;

import javax.swing.JRadioButton;


public class Consultar extends JDialog implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxPesquisa;
	private JComboBox<String> comboBoxOrganiza;
	private JTextField textFieldPesquisa;
	private JLabel lblOrganizarPor;
	private JButton btnImprimir;
	private JButton btnEditar;
	private JButton btnDeletar;
	private JRadioButton rdbtnConsultaSemHistrico;
	private JScrollPane scrollPane;
	private JDesktopPane desktopPane;
	private JTable table_1, table_2;
	private ControleFuncionario data = new ControleFuncionario();
	private Background bg;
	

	public Consultar() {
		
		UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 11, 793, 483);
		desktopPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		getContentPane().add(desktopPane);
		
		JLabel lblPesquisarPor = new JLabel("Pesquisar por:");
		lblPesquisarPor.setBounds(6, 8, 89, 20);
		desktopPane.add(lblPesquisarPor);
		
		comboBoxPesquisa = new JComboBox<String>();
		comboBoxPesquisa.setBounds(99, 6, 89, 25);
		desktopPane.add(comboBoxPesquisa);
		
		comboBoxPesquisa.addItem("ID");
		comboBoxPesquisa.addItem("Nome");
		comboBoxPesquisa.addItem("CPF");
		comboBoxPesquisa.addItem("Cargo");
		comboBoxPesquisa.setSelectedIndex(0);
		
		lblOrganizarPor = new JLabel("Organizar por:");
		lblOrganizarPor.setBounds(581, 43, 77, 20);
		desktopPane.add(lblOrganizarPor);
		
		comboBoxOrganiza = new JComboBox<String>();
		comboBoxOrganiza.setBounds(666, 41, 117, 25);
		desktopPane.add(comboBoxOrganiza);
		
		comboBoxOrganiza.addItem("ID");
		comboBoxOrganiza.addItem("Nome");
		comboBoxOrganiza.addItem("CPF");
		comboBoxOrganiza.addItem("Cargo");
		comboBoxOrganiza.setSelectedIndex(1);
		comboBoxOrganiza.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
						
				construirTabela_1();
				
			}
		});
		
		textFieldPesquisa = new JTextField();
		textFieldPesquisa.setBounds(198, 5, 251, 26);
		desktopPane.add(textFieldPesquisa);
		textFieldPesquisa.addKeyListener(this);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(459, 5, 100, 27);
		btnImprimir.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnConsultaSemHistrico.isSelected()){
					if(table_2.getSelectedRow() > -1){
						
						/**
						try {    
				           URL arquivo = getClass().getResource("Aqui dentro você adiciona o caminho do seu relatorio");             
				           Map<String, Object> map = new HashMap<String, Object>();  
				           map.put("Se vc tiver criado algum paramentro no seu ireport vc adicionara aqui", ); //Filtro  
				           JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);    
				           JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, Conexao.getConnection());   
				           JasperViewer jrviewer = new JasperViewer(jasperPrint, false);    
				           jrviewer.setVisible(true);   
				           jrviewer.toFront();  
				         }catch (Exception ex) {    
				            JOptionPane.showMessageDialog(null, ex);   
				        }  
				
						 */
						
						Connection conn = AdmBancoSql.getConnection();
						String jasperFile = "src/relatorio/relatorio.jasper";
						HashMap parametro = new HashMap();
						parametro.put("idFunc", table_2.getValueAt(table_2.getSelectedRow(), 0));
						
						//String idFunc = 
						
					}else JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					if(table_1.getSelectedRow() > -1){
						
						
					}else JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		desktopPane.add(btnImprimir);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(683, 5, 100, 27);
		btnDeletar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				ControleFuncionario excluirFunc = new ControleFuncionario();
				String resultado = null;
				
				int decisao = JOptionPane.showConfirmDialog(null, "Ao excluir o funcionário todos os dados relacionados a ele serão excluídos.", "Confirmação", JOptionPane.YES_NO_OPTION);
				
				if(decisao == JOptionPane.YES_OPTION){
					if(rdbtnConsultaSemHistrico.isSelected()){
						if(table_2.getSelectedRow() > -1){
							
							resultado = excluirFunc.excluir(Integer.valueOf((String)table_2.getValueAt(table_2.getSelectedRow(), 0)), (String)table_2.getValueAt(table_2.getSelectedRow(), 1));
							
							JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
							
							atualizarTabela_2((String)comboBoxPesquisa.getSelectedItem(), (String)comboBoxOrganiza.getSelectedItem(), textFieldPesquisa.getText());
						}
						else JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);
					}
					else{
						if(table_1.getSelectedRow() > -1){
									
							resultado = excluirFunc.excluir(Integer.valueOf((String)table_1.getValueAt(table_1.getSelectedRow(), 0)), (String)table_1.getValueAt(table_1.getSelectedRow(), 1));
							
							JOptionPane.showMessageDialog(null, resultado, "Informação", JOptionPane.INFORMATION_MESSAGE);
							
							atualizarTabela_1((String)comboBoxPesquisa.getSelectedItem(), (String)comboBoxOrganiza.getSelectedItem(), textFieldPesquisa.getText());
						}
						else JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		desktopPane.add(btnDeletar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 75, 777, 402);
		desktopPane.add(scrollPane);
		
		construirTabela_1();
		
		rdbtnConsultaSemHistrico = new JRadioButton("Consulta sem hist\u00F3rico");
		rdbtnConsultaSemHistrico.setBounds(409, 44, 150, 18);
		rdbtnConsultaSemHistrico.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnConsultaSemHistrico.isSelected()){
					
					atualizarComboBox();
					construirTabela_2();
					
					
				}
				else{
					
					atualizarComboBox();
					construirTabela_1();
				}
				repaint();
				scrollPane.repaint();
			}
		});
		desktopPane.add(rdbtnConsultaSemHistrico);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
						
					if(rdbtnConsultaSemHistrico.isSelected() == false){
						if(table_1.getSelectedRow() > -1){
									
							new Editar(Integer.valueOf((String) table_1.getValueAt(table_1.getSelectedRow(), 0)));
									
						}
						else JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						if(table_2.getSelectedRow() > -1){
							
							new Editar(Integer.valueOf((String) table_2.getValueAt(table_2.getSelectedRow(), 0)));
								
						}
						else JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnEditar.setBounds(571, 5, 100, 27);
		//btnEditar.addActionListener(this);
		desktopPane.add(btnEditar);
			
		bg = new Background("CRHCurvasBG_2.png");
		bg.setSize(815, 532);
		getContentPane().add(bg);
		
		setTitle("Consulta de Funcionários");
		setSize(815, 532);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		setVisible(true);
	}
	
	private void construirTabela_1(){
		
		if(comboBoxOrganiza.getItemCount() == 0){
			table_1 = data.construirTabela_1("Nome");
		}
		else{
			table_1 = data.construirTabela_1(((String) comboBoxOrganiza.getSelectedItem()));
		}
		
		
		scrollPane.setViewportView(table_1);		
		
	}
	
	private void construirTabela_2(){
		
		table_2 = data.construirTabela_2(((String) comboBoxOrganiza.getSelectedItem()));
		
		scrollPane.setViewportView(table_2);
		
	}
	
	private void atualizarTabela_1(String pesquisa, String organiza, String texto){
		
		table_1 = data.atualizarTabela_1(pesquisa, organiza, texto);
		scrollPane.setViewportView(table_1);
		
	}
	
	private void atualizarTabela_2(String pesquisa, String organiza, String texto){
		
		table_2 = data.atualizarTabela_2(pesquisa, organiza, texto);
		scrollPane.setViewportView(table_2);
		
	}
	
	private void atualizarComboBox(){
		
		comboBoxPesquisa.removeAllItems();
		comboBoxOrganiza.removeAllItems();
		
		if(rdbtnConsultaSemHistrico.isSelected() == false){
			
			comboBoxPesquisa.addItem("ID");
			comboBoxPesquisa.addItem("Nome");
			comboBoxPesquisa.addItem("CPF");
			comboBoxPesquisa.addItem("Cargo");
			comboBoxPesquisa.setSelectedIndex(0);
			
			comboBoxOrganiza.addItem("ID");
			comboBoxOrganiza.addItem("Nome");
			comboBoxOrganiza.addItem("CPF");
			comboBoxOrganiza.addItem("Cargo");
			comboBoxOrganiza.setSelectedIndex(1);
			
		}
		
		else{
			
			comboBoxPesquisa.addItem("ID");
			comboBoxPesquisa.addItem("Nome");
			comboBoxPesquisa.addItem("Data de Nasc.");
			comboBoxPesquisa.addItem("CPF");
			comboBoxPesquisa.setSelectedIndex(0);
			
			comboBoxOrganiza.addItem("ID");
			comboBoxOrganiza.addItem("Nome");
			comboBoxOrganiza.addItem("Data de Nasc.");
			comboBoxOrganiza.addItem("CPF");
			comboBoxOrganiza.setSelectedIndex(1);
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		
		if((e.getSource() == textFieldPesquisa) && (rdbtnConsultaSemHistrico.isSelected())){
			
			atualizarTabela_2((String)comboBoxPesquisa.getSelectedItem(), (String)comboBoxOrganiza.getSelectedItem(), textFieldPesquisa.getText());
			
		}
		else if((e.getSource() == textFieldPesquisa) && !(rdbtnConsultaSemHistrico.isSelected())){
			
			atualizarTabela_1((String)comboBoxPesquisa.getSelectedItem(), (String)comboBoxOrganiza.getSelectedItem(), textFieldPesquisa.getText());
		
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
