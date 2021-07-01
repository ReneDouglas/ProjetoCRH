package widgets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controle.ControleLogin;
import controle.classes_complementares.UpperCaseDocument;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Login extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField textField_1;
	private JButton btnEntrar;
	private JLabel folder;
	private ImageIcon imgFolder;
	
	public Login() {
		super("Acesso ao Sistema");
		
		try {

			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		setSize(705, 525);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 700, 500);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		imgFolder = new ImageIcon(getClass().getClassLoader().getResource("CRHCurvasLogin.png"));
		folder = new JLabel();
		folder.setIcon(imgFolder);
		folder.setBounds(0, 0, imgFolder.getIconWidth(), imgFolder.getIconHeight());
		
		
		JLabel lblLogin = new JLabel("LOGIN:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblLogin.setBounds(214, 213, 51, 14);
		panel.add(lblLogin);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSenha.setBounds(214, 259, 51, 14);
		panel.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(214, 229, 237, 28);
		textField.setDocument(new UpperCaseDocument());
		textField.addActionListener(this);
		panel.add(textField);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(214, 275, 237, 28);
		textField_1.setDocument(new UpperCaseDocument());
		textField_1.addActionListener(this);
		panel.add(textField_1);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(285, 322, 90, 28);
		btnEntrar.addActionListener(this);
		panel.add(btnEntrar);
		
		panel.add(folder);
		
		setVisible(true);
		
	}
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		if(textField.getText().equalsIgnoreCase("")||textField_1.getText().equalsIgnoreCase(""))JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
		else{
			ControleLogin login = new ControleLogin();
			String retorno = login.verificar(textField.getText(), textField_1.getText());
			
			if(retorno.equalsIgnoreCase("Sucesso"))
			{
				dispose();
				new Aplicacao();
			}
			else{
				JOptionPane.showMessageDialog(null, "Usuário n"+(char)227+"o encontrado.\nLogin ou Senha inválidos.");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Login();
	}
	
}
