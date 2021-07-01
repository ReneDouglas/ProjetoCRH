package controle.interfaceControle;

import java.sql.Date;

public interface I_ControleLicenca {

	public String salvar(int chaveFunc, String tipoLicenca, Date inicio, Date termino, String port, String observ, int seletor);
	//public String salvarLicendaFuncionario(int chaveFuncionario, int chaveLicenca);
	public Object buscar(int id);
	public String excluir(int chaveFunc, String portaria);
	public String alterar(int chaveFunc, String tipoLicenca, Date inicio, Date termino, String port, String observ);
	
}
