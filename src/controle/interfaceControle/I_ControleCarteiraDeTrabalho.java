package controle.interfaceControle;

import java.sql.Date;

public interface I_ControleCarteiraDeTrabalho {

	public String salvar(String numero, String serie, Date data);
	public String alterar(int chaveFunc, String numero, String serie, Date data);
	public Object buscar(int id);
	
}
