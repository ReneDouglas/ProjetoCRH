package controle.interfaceControle;

public interface I_ControleTitulo {

	public String salvar(String numero, String zona, String secao);
	public String alterar(int chaveFunc, String numero, String zona, String secao);
	public Object buscar(int id);
	
}
