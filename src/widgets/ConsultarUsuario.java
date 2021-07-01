package widgets;

import javax.swing.JDialog;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import widgets.interfaceWidgets.ControleComponentes;

import basico.Usuario;

import controle.ControleLogin;
import controle.classes_complementares.UpperCaseDocument;

public class ConsultarUsuario extends JDialog implements ActionListener, ControleComponentes{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private DefaultTableModel modelo;
	JDesktopPane desktopPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblConfirmarSenha;
	private JButton btnAlterar;
	private JButton btnDeletar;
	private JButton button;
	private int idUser;

	public ConsultarUsuario() {

		setTitle("Consultar Usuários");
		setSize(400, 300);
		getContentPane().setLayout(null);
		setModal(true);
		
		UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
		
		try {

			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 11, 374, 250);
		desktopPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(desktopPane);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(6, 13, 151, 224);
		panel.setLayout(null);
		desktopPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(170, 13, 198, 225);
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		desktopPane.add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 88, 192, 134);
		panel_1.add(scrollPane);
		
		construirTable();
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogin.setBounds(8, 6, 55, 16);
		panel.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(6, 24, 122, 28);
		textField.setDocument(new UpperCaseDocument());
		panel.add(textField);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(8, 64, 55, 16);
		panel.add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setBounds(6, 82, 122, 28);
		textField_1.setDocument(new UpperCaseDocument());
		panel.add(textField_1);
		
		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmarSenha.setBounds(8, 122, 122, 16);
		panel.add(lblConfirmarSenha);
		
		textField_2 = new JTextField();
		textField_2.setBounds(6, 140, 122, 28);
		textField_2.setDocument(new UpperCaseDocument());
		panel.add(textField_2);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(38, 180, 90, 28);
		btnAlterar.addActionListener(this);
		panel.add(btnAlterar);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(105, 60, 90, 28);
		btnDeletar.addActionListener(this);
		panel_1.add(btnDeletar);
		
		button = new JButton("<<<");
		button.setBounds(3, 60, 90, 28);
		button.addActionListener(this);
		panel_1.add(button);
		
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
	}
	
	private void construirTable(){
		
		String[] colunas = new String[3];
		
		colunas[0] = "ID";
		colunas[1] = "Login";
		colunas[2] = "Senha";

		modelo = new DefaultTableModel(new Object[][]{}, colunas);
		table = new JTable(modelo);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		
		ControleLogin carregar = new ControleLogin();
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		
		users = carregar.listar();
		
		for (int i = 0; i < users.size(); i++) {
			
			modelo.addRow(new String[]{""+users.get(i).getIdUsuario(),users.get(i).getLogin(),users.get(i).getSenha()});
		}
		
		scrollPane.setViewportView(table);
		
	}

	@Override
	public void carregar_mascaras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpar_form(JDesktopPane pane) {
		
		
	}
	
	public void limpar_form(JPanel pane) {       
    
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
	public void limpar_tabela(DefaultTableModel modelo) {
		
		
	}
	
    public void actionPerformed(ActionEvent e) {
		
		if(btnAlterar == e.getSource()){
			
			ControleLogin alterarUser = new ControleLogin();
			
			if(textField_1.getText().equals(textField_2.getText())){
				String retorno = alterarUser.alterar(idUser, textField.getText(), textField_1.getText());
				
				JOptionPane.showMessageDialog(null, retorno);
				limpar_form(panel);
			}
			else JOptionPane.showMessageDialog(null, "A senha confirmada é diferente");
			
		}
		else if(button == e.getSource()){
			
			if(table.getSelectedRow() > -1){
				

				idUser = Integer.valueOf((String) modelo.getValueAt(table.getSelectedRow(), 0));
				textField.setText(""+modelo.getValueAt(table.getSelectedRow(), 1));
				textField_1.setText(""+modelo.getValueAt(table.getSelectedRow(), 2));
				textField_2.setText(""+modelo.getValueAt(table.getSelectedRow(), 2));
				
				modelo.removeRow(table.getSelectedRow());
			}
			else JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);
			
			
		}
		else if(btnDeletar == e.getSource()){
			
			if(table.getSelectedRow() > -1){
				
				ControleLogin excluirUser = new ControleLogin();
				
				if(JOptionPane.showConfirmDialog(null, "Ao excluir este usuário ele não poderá mais logar no sistema. Deseja continuar?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					
					idUser = Integer.valueOf((String) modelo.getValueAt(table.getSelectedRow(), 0));
					String retorno = excluirUser.excluir(idUser);
					
					modelo.removeRow(table.getSelectedRow());
					
					JOptionPane.showMessageDialog(null, retorno);
				}	
				
				
			}
			
		}
		
	}
}
