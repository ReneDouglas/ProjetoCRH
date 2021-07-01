package widgets;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import backup.Backup;
//import javax.swing.UIManager;

public class Aplicacao extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menuArquivo, menuCadastrar, menuConsultar, menuBackup;
	private JMenuItem[] itensArquivo, itensCadastrar, itensConsultar, itensBackup;
	private JDesktopPane pane;
	private JLabel folder;
	private ImageIcon imgFolder;
	
	public Aplicacao() {
		super("Controle de Recursos Humanas"); // Controle de Recursos Humanas - CRH
		
		//UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
				
		try {

			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		pane = new JDesktopPane();
		pane.setBounds(0, 0, 700, 500);
		this.add(pane);
		
		CarregarMenu();
		
		imgFolder = new ImageIcon(getClass().getClassLoader().getResource("CRH.png"));
		folder = new JLabel();
		folder.setIcon(imgFolder);
		folder.setBounds(0, 0, imgFolder.getIconWidth(), imgFolder.getIconHeight());
		pane.add(folder);
				
		setSize(705, 550);
		setResizable(false);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		
	}
	
	private void CarregarMenu(){
		
		menuBar = new JMenuBar();
		menuBar.setBorderPainted(true);
		this.setJMenuBar(menuBar);
		
		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setFont(new Font("Arial", Font.BOLD, 13));
		
		menuCadastrar = new JMenu("Cadastrar");
		menuCadastrar.setFont(new Font("Arial", Font.BOLD, 13));
		
		menuConsultar = new JMenu("Consultar");
		menuConsultar.setFont(new Font("Arial", Font.BOLD, 13));
		
		menuBackup = new JMenu("Backup");
		menuBackup.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.menuBar.add(menuArquivo);
		this.menuBar.add(menuCadastrar);
		this.menuBar.add(menuConsultar);
		this.menuBar.add(menuBackup);
		
		this.itensArquivo = new JMenuItem[3];
		this.itensCadastrar = new JMenuItem[3];
		this.itensConsultar = new JMenuItem[3];
		this.itensBackup = new JMenuItem[3];
		
		for (int i = 0; i < 3; i++) {
			itensArquivo[i] = new JMenuItem();
			itensArquivo[i].setFont(new Font("Arial", Font.BOLD, 13));
			
			itensCadastrar[i] = new JMenuItem();
			itensCadastrar[i].setFont(new Font("Arial", Font.BOLD, 13));
			
			itensConsultar[i] = new JMenuItem();
			itensConsultar[i].setFont(new Font("Arial", Font.BOLD, 13));
			
			itensBackup[i] = new JMenuItem();
			itensBackup[i].setFont(new Font("Arial", Font.BOLD, 13));
		}
		
		itensArquivo[0].setText("Logoff");
		itensArquivo[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Login();
			}
		});
		
		menuArquivo.add(itensArquivo[0]);
		
		itensArquivo[1].setText("Sair");
		itensArquivo[1].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);			
			}
		});
		
		menuArquivo.add(itensArquivo[1]);
		
		itensCadastrar[0].setText("Funcionário");
		itensCadastrar[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//dispose();
				new Cadastrar();
			}
		});
		itensCadastrar[1].setText("Usuário");
		itensCadastrar[1].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				new CadastrarUsuario();
				
			}
		});
		
		itensCadastrar[2].setText("Licença");
		itensCadastrar[2].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
								
				new CadastrarLicenca();
			}
		});
		
		itensConsultar[0].setText("Funcionário");
		itensConsultar[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				new Consultar();				
			}
		});
		
		itensConsultar[1].setText("Usuário");
		itensConsultar[1].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				new ConsultarUsuario();				
			}
		});
		
		
		itensBackup[0].setText("Realizar Backup");

		itensBackup[1].setText("Restaurar Dados");
		
		menuCadastrar.add(itensCadastrar[0]);
		menuCadastrar.add(itensCadastrar[1]);
		menuCadastrar.add(itensCadastrar[2]);
		menuConsultar.add(itensConsultar[0]);
		menuConsultar.add(itensConsultar[1]);
		itensBackup[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				Backup backup = new Backup();

				backup.realizarBackup();
				
				
			}
		});
		menuBackup.add(itensBackup[0]);

		itensBackup[1].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				Backup backup = new Backup();
				try {
					backup.restaurarBackup();
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		menuBackup.add(itensBackup[1]);
		
		
	}
	
}
