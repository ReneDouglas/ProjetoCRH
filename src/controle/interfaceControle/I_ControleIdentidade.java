package controle.interfaceControle;

import java.sql.Date;

public interface I_ControleIdentidade {

	public String salvar(String numero, String ssp, Date data);
	public String alterar(int chaveFunc, String numero, String ssp, Date data);
	public Object buscar(int id);
	
}
