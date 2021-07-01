package basico;

public class Endereco {

	private int chaveFunc;
	private String rua;
	private String numero;
	private String bairro;
	
	public Endereco(int chaveFunc, String rua, String numero, String bairro) {
		
		this.chaveFunc = chaveFunc;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		
	}
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public int getChaveFunc() {
		return chaveFunc;
	}

	public void setChaveFunc(int chaveFunc) {
		this.chaveFunc = chaveFunc;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
