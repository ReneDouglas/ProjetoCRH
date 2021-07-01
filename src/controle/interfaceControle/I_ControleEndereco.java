package controle.interfaceControle;

public interface I_ControleEndereco {

	public String salvar(String bairro, String rua, String numero);
	public String alterar(int chaveFunc, String bairro, String rua, String numero);
	public Object buscar(int id);
	
}
