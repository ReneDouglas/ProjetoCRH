package widgets;

import javax.swing.JDialog;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import controle.ControleLogin;
import controle.classes_complementares.Background;
import controle.classes_complementares.UpperCaseDocument;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import widgets.interfaceWidgets.ControleComponentes;

public class CadastrarUsuario extends JDialog implements ControleComponentes{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JDesktopPane desktopPane;
	private JLabel lblNome;
	private JLabel lblSenha;
	private JLabel lblConfirmeASenha;
	private JButton btnSalvar;
	private Background bg;

	public CadastrarUsuario() {
		
		setTitle("Cadastro de Usuário");
		getContentPane().setLayout(null);
		setSize(446, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
		
		try {

			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		desktopPane.setBounds(0, 60, 441, 212);
		//desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane);
		
		lblNome = new JLabel("Login");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(114, 28, 35, 20);
		desktopPane.add(lblNome);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(109, 71, 40, 14);
		desktopPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(159, 24, 146, 28);
		textField.setDocument(new UpperCaseDocument());
		desktopPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 64, 146, 28);
		textField_1.setDocument(new UpperCaseDocument());
		desktopPane.add(textField_1);
		
		lblConfirmeASenha = new JLabel("Confirme a senha");
		lblConfirmeASenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmeASenha.setBounds(37, 111, 112, 14);
		desktopPane.add(lblConfirmeASenha);
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 104, 146, 28);
		textField_2.setDocument(new UpperCaseDocument());
		desktopPane.add(textField_2);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(216, 155, 89, 28);
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				ControleLogin save = new ControleLogin();
				String retorno = save.salvar(textField.getText(), textField_1.getText(), textField_2.getText());
				JOptionPane.showMessageDialog(null, retorno);
				
				limpar_form(desktopPane);
			}
		});
		desktopPane.add(btnSalvar);
		
		bg = new Background("CRHCurvasBG_3.png");
		bg.setSize(446, 300);
		getContentPane().add(bg);
		
	}

	@Override
	public void carregar_mascaras() {
		// TODO Auto-generated method stub
		
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
	public void limpar_tabela(DefaultTableModel modelo) {
		// TODO Auto-generated method stub
		
	}
}
