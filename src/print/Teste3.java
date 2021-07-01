package print;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Teste3 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Teste3() {
		super("teste");
		setSize(350, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 250, 250);
		panel.setBackground(new Color(255, 255, 255));
		this.add(panel);
		
		JLabel l = new JLabel("Teste");
		JLabel lblNome = new JLabel("NOME:");
		JLabel lblPai = new JLabel("PAI:");
		JLabel lblMae = new JLabel("MAE:");
		JLabel lblReneDouglasNobre = new JLabel("RENE DOUGLAS NOBRE DE MORAIS");
		panel.add(l);
		panel.add(lblNome);
		panel.add(lblPai);
		panel.add(lblMae);
		panel.add(lblReneDouglasNobre);
		
		int largura = panel.getWidth();  
		int altura = panel.getHeight();  
		BufferedImage imgPanel = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);  
		Graphics2D img = imgPanel.createGraphics();  
		panel.paint(img);
		
		
		Printer.printComponent(panel);
		
		
		
	}
	
	public static void main(String[] args) {
		new Teste3();
	}
	
}
