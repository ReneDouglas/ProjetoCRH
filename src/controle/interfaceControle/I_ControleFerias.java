package controle.interfaceControle;

public interface I_ControleFerias {

	public String salvar(int chaveFunc, String periodoAq, String periodoGozo, String portaria, int seletor);
	public String alterar(int chaveFunc, String periodoAq, String periodoGozo, String portaria);
	public Object buscar(int id);
	public String excluir(int chaveFunc, String portaria);
}
