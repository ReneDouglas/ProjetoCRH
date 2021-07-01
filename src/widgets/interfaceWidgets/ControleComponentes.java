package widgets.interfaceWidgets;

import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;

public interface ControleComponentes {

	public void carregar_mascaras();
	public void limpar_form(JDesktopPane pane);
	public void limpar_tabela(DefaultTableModel modelo);
	
}
