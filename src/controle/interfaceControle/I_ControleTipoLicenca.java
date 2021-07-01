package controle.interfaceControle;

public interface I_ControleTipoLicenca {

	public String salvar(int idTipo, String nomeTipo);
	public String[] listar(String nomePesquisa);
	public String buscar(int id);
	
}
