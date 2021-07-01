package basico;

public class Naturalidade {

	private int chaveFunc;
	private String cidade;
	private String estado;
	
	public Naturalidade(int chaveFunc, String cidade, String estado) {
		
		this.chaveFunc = chaveFunc;
		this.cidade = cidade;
		this.estado = estado;
		
	}
	
	public Naturalidade() {
		// TODO Auto-generated constructor stub
	}

	public int getChaveFunc() {
		return chaveFunc;
	}

	public void setChaveFunc(int idNat) {
		this.chaveFunc = idNat;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
		
}
