package admBanco;

import java.util.ArrayList;

public interface InterfaceBanco {
	
	public String inserir(Object objct);
	public String excluir(int id, String nome);
	public String excluir();
	public String alterar(Object objct);
	public ArrayList<Object> listar_1(String pesquisarColuna, String organizarPor, String textoPesquisa);
	public Object buscar(int id);
	public Object buscar(String nome);
	Object buscar(int chaveFunc, String nome);
	
}
