package print;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;

public class Construtor extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
	private JScrollPane scrollPane;
	private JButton btnNewButton ;
	private JLabel lblFichaFuncional;

	public Construtor() {
		super("Impressão");
		
		UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
		
		try {

			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//setSize(2480, 3508);
		setSize(1356, 736);
		getContentPane().setLayout(null);
		//setSize(800, 627);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1356, 736);
		//desktopPane.setPreferredSize(new Dimension(2480,3508));
		getContentPane().add(desktopPane);
		
		JLabel lblSecretariaMunicipalDe = new JLabel("SECRETARIA MUNICIPAL DE SA\u00DADE DE AFOGADOS DA INGAZEIRA");
		lblSecretariaMunicipalDe.setFont(new Font("Dialog", Font.BOLD, 30));
		lblSecretariaMunicipalDe.setBounds(88, 38, 1022, 26);
		desktopPane.add(lblSecretariaMunicipalDe);
		
		lblFichaFuncional = new JLabel("FICHA FUNCIONAL");
		lblFichaFuncional.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFichaFuncional.setBounds(40, 124, 181, 16);
		desktopPane.add(lblFichaFuncional);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 774, 551);
		//getContentPane().add(scrollPane);
		//scrollPane.setViewportView(desktopPane);
		
		btnNewButton = new JButton("Imprimir");
		btnNewButton.setBounds(368, 566, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				Printer.printComponent(desktopPane);
			}
		});
		desktopPane.add(btnNewButton);
		
		
		
		
		
		
		
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Construtor();
	}
}
