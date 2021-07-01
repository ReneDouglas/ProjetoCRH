package basico;

public class TituloEleitoral {

	private int chaveFunc;
	private String numero;
	private String zona;
	private String secao;
	
	public TituloEleitoral(int chaveFunc, String numero, String zona, String secao) {
		
		this.chaveFunc = chaveFunc;
		this.numero = numero;
		this.zona = zona;
		this.secao = secao;
		
	}
	
	public TituloEleitoral() {
		// TODO Auto-generated constructor stub
	}

	public int getChaveFunc() {
		return chaveFunc;
	}

	public void setChaveFunc(int idTitulo) {
		this.chaveFunc = idTitulo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}
	
	
}
