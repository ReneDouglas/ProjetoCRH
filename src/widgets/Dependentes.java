package widgets;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.ControleDependente;
import controle.classes_complementares.UpperCaseDocument;

import widgets.interfaceWidgets.ControleComponentes;

public class Dependentes extends JDesktopPane implements ActionListener, ControleComponentes{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JFormattedTextField textField_2;
	private JFormattedTextField textField_3;
	private JFormattedTextField textField_4;
	private JLabel lblSalrioFamlia, lblTrmino, lblNome, lblParentesco, lblDataDeNasc, lblInicio;
	private JScrollPane scrollPane;
	private JButton bAdicionar, bSalvar, bDeletar;
	private DefaultTableModel modelo;
	private JTable table;
	private MaskFormatter maskDate;


	public Dependentes() {
		
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
		
		lblSalrioFamlia = new JLabel("SAL\u00C1RIO FAM\u00CDLIA");
		lblSalrioFamlia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSalrioFamlia.setBounds(18, 30, 192, 22);
		add(lblSalrioFamlia);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(62, 92, 36, 14);
		add(lblNome);
		
		textField = new JTextField();
		textField.setDocument(new UpperCaseDocument());
		textField.setBounds(108, 86, 314, 26);
		add(textField);
		textField.setColumns(10);
		
		lblParentesco = new JLabel("Parentesco:");
		lblParentesco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblParentesco.setBounds(33, 129, 65, 14);
		add(lblParentesco);
		
		textField_1 = new JTextField();
		textField_1.setDocument(new UpperCaseDocument());
		textField_1.setBounds(108, 123, 170, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblDataDeNasc = new JLabel("Data de Nasc.:");
		lblDataDeNasc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeNasc.setBounds(18, 165, 80, 16);
		add(lblDataDeNasc);
		
		textField_2 = new JFormattedTextField(maskDate);
		textField_2.setBounds(108, 160, 98, 26);
		add(textField_2);
		
		textField_3 = new JFormattedTextField(maskDate);
		textField_3.setBounds(108, 197, 98, 26);
		add(textField_3);
		
		lblInicio = new JLabel("Inicio:");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicio.setBounds(66, 202, 32, 16);
		add(lblInicio);
		
		textField_4 = new JFormattedTextField(maskDate);
		textField_4.setBounds(108, 234, 98, 26);
		add(textField_4);
		
		lblTrmino = new JLabel("T\u00E9rmino:");
		lblTrmino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTrmino.setBounds(49, 239, 49, 16);
		add(lblTrmino);
		
		bAdicionar = new JButton("Adicionar");
		bAdicionar.setBounds(513, 290, 100, 30);
		bAdicionar.addActionListener(this);
		add(bAdicionar);
		
		bSalvar = new JButton("Salvar");
		bSalvar.setBounds(618, 290, 100, 30);
		bSalvar.addActionListener(this);
		add(bSalvar);
		
		bDeletar = new JButton("Deletar");
		bDeletar.setBounds(723, 290, 100, 30);
		bDeletar.addActionListener(this);
		add(bDeletar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(108, 344-20, 716, 301-30);
		add(scrollPane);
		
		
		construir_Tabela();
		
		
	}
	
	private void construir_Tabela(){
		
		String[] colunas = new String[6];
		
		colunas[0] = "Nº";
		colunas[1] = "Nome";
		colunas[2] = "Parentesco";
		colunas[3] = "Data de Nasc.";
		colunas[4] = "Inicio";
		colunas[5] = "Término";
		
		modelo = new DefaultTableModel(new Object[][]{}, colunas);
		
		table = new JTable(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(LIVE_DRAG_MODE);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);

		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		
		scrollPane.setViewportView(table);		
		
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
		
		if(e.getSource() == bAdicionar){
			
			modelo.addRow(new String[]{""+(table.getRowCount()+1), textField.getText(), textField_1.getText(), textField_2.getText(),
					textField_3.getText(), textField_4.getText()});
			
			limpar_form(this);
		}
		else if(e.getSource() == bSalvar){
			
			ControleDependente salvarForm = new ControleDependente();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String retorno = "";
			
			if(table.getRowCount() > 0){
				for (int i = 0; i < table.getRowCount(); i++) {
					
					try {
						retorno = salvarForm.salvar(0, table.getValueAt(i, 1).toString(), table.getValueAt(i, 2).toString(),
								new java.sql.Date((formatter.parse(table.getValueAt(i, 3).toString())).getTime()),
								new java.sql.Date((formatter.parse(table.getValueAt(i, 4).toString())).getTime()),
								new java.sql.Date((formatter.parse(table.getValueAt(i, 5).toString())).getTime()), 1);
						
						
						
						if(retorno.substring(0, 4).equals("Erro"))break;
						
					} catch (ParseException e1) {
						e1.printStackTrace();
					}			
				}	
			JOptionPane.showMessageDialog(null, retorno, "Informação", JOptionPane.INFORMATION_MESSAGE);
			limpar_tabela(modelo);
			
			} else JOptionPane.showMessageDialog(null, "Tabela Vazia!");
		}
		
		else if(e.getSource() == bDeletar){
			
			if(table.getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione uma linha.");	
			else{
				modelo.removeRow(table.getSelectedRow());
				if(table.getRowCount() > table.getSelectedRow()){
					
					for (int i = table.getSelectedRow()+1; i < table.getRowCount(); i++) {
						table.setValueAt(i+1, i, 0);
					}
				}
			}
			
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

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JFormattedTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JFormattedTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JFormattedTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JFormattedTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JFormattedTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JFormattedTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JLabel getLblSalrioFamlia() {
		return lblSalrioFamlia;
	}

	public void setLblSalrioFamlia(JLabel lblSalrioFamlia) {
		this.lblSalrioFamlia = lblSalrioFamlia;
	}

	public JLabel getLblTrmino() {
		return lblTrmino;
	}

	public void setLblTrmino(JLabel lblTrmino) {
		this.lblTrmino = lblTrmino;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblParentesco() {
		return lblParentesco;
	}

	public void setLblParentesco(JLabel lblParentesco) {
		this.lblParentesco = lblParentesco;
	}

	public JLabel getLblDataDeNasc() {
		return lblDataDeNasc;
	}

	public void setLblDataDeNasc(JLabel lblDataDeNasc) {
		this.lblDataDeNasc = lblDataDeNasc;
	}

	public JLabel getLblInicio() {
		return lblInicio;
	}

	public void setLblInicio(JLabel lblInicio) {
		this.lblInicio = lblInicio;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JButton getbAdicionar() {
		return bAdicionar;
	}

	public void setbAdicionar(JButton bAdicionar) {
		this.bAdicionar = bAdicionar;
	}

	public JButton getbSalvar() {
		return bSalvar;
	}

	public void setbSalvar(JButton bSalvar) {
		this.bSalvar = bSalvar;
	}

	public JButton getbDeletar() {
		return bDeletar;
	}

	public void setbDeletar(JButton bDeletar) {
		this.bDeletar = bDeletar;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public MaskFormatter getMaskDate() {
		return maskDate;
	}

	public void setMaskDate(MaskFormatter maskDate) {
		this.maskDate = maskDate;
	}
	

}
