package print;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Teste extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Teste() {
		getContentPane().setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(10, 11, 370, 258);
		panel.setLayout(null);
		getContentPane().add(panel);
		
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
		
		DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, colunas);
		
		JTable table = new JTable(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(58, 11, 80, 14);
		panel.add(lblNome);
		
		JLabel lblPai = new JLabel("PAI:");
		lblPai.setBounds(72, 36, 80, 14);
		panel.add(lblPai);
		
		JLabel lblMae = new JLabel("MAE:");
		lblMae.setBounds(66, 61, 80, 14);
		panel.add(lblMae);
		
		JLabel lblDataDeNasc = new JLabel("DATA DE NASC.:");
		lblDataDeNasc.setBounds(5, 86, 100, 14);
		panel.add(lblDataDeNasc);
		
		JLabel lblReneDouglasNobre = new JLabel("RENE DOUGLAS NOBRE DE MORAIS");
		lblReneDouglasNobre.setBounds(99, 11, 250, 14);
		panel.add(lblReneDouglasNobre);
		
		JLabel lblPedroVieiraMorais = new JLabel("PEDRO VIEIRA MORAIS");
		lblPedroVieiraMorais.setBounds(99, 36, 250, 14);
		panel.add(lblPedroVieiraMorais);
		
		JLabel lblErandiNobreMorais = new JLabel("ERANDI NOBRE MORAIS");
		lblErandiNobreMorais.setBounds(99, 61, 250, 14);
		panel.add(lblErandiNobreMorais);
		
		JLabel label = new JLabel("01/07/1992");
		label.setBounds(99, 86, 90, 14);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 131, 250, 100);
		panel.add(scrollPane);
		
		scrollPane.setViewportView(table);	
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(131, 280, 89, 23);
		btnImprimir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				Printer print = new Printer(panel);
				//print.pageSetup();
				print.print();

			}
		});
		getContentPane().add(btnImprimir);
		setSize(394,345);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Teste();
	}
}
