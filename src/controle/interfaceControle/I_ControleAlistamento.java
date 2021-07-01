package controle.interfaceControle;

public interface I_ControleAlistamento {

	public String salvar(String situacaoMilitar, String serie, String esp);
	public String alterar(int chaveFunc, String situacaoMilitar, String serie, String esp);
	public Object buscar(int id);
	
}
