package controle.interfaceControle;

public interface I_ControleNaturalidade {

	public String salvar(String cidade, String estado);
	public String alterar(int chaveFunc, String cidade, String estado);
	public Object buscar(int id);
}
