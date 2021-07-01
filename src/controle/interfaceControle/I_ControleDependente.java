package controle.interfaceControle;

import java.sql.Date;

public interface I_ControleDependente {

	public String salvar(int chaveFunc, String nome, String parentesco, Date dataNasc, Date inicio, Date termino, int seletor);
	public String alterar(int chaveFunc, String nome, String parentesco, Date dataNasc, Date inicio, Date termino);
	public Object buscar(int id);
	public String excluir(int chaveFunc, String nome);
}
