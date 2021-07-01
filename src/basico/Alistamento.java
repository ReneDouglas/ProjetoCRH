package basico;

public class Alistamento {
	
	private int chaveFunc;
	private String situacaoMilitar;
	private String serie;
	private String esp;
	
	public Alistamento(int chaveFunc, String situacaoMilitar, String serie, String esp) {
		
		this.chaveFunc = chaveFunc;
		this.situacaoMilitar = situacaoMilitar;
		this.serie = serie;
		this.esp = esp;
		
	}
	
	public Alistamento() {
		// TODO Auto-generated constructor stub
	}

	public int getChaveFunc() {
		return chaveFunc;
	}

	public void setChaveFunc(int chaveFunc) {
		this.chaveFunc = chaveFunc;
	}

	public String getSituacaoMilitar() {
		return situacaoMilitar;
	}

	public void setSituacaoMilitar(String situacaoMilitar) {
		this.situacaoMilitar = situacaoMilitar;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getEsp() {
		return esp;
	}

	public void setEsp(String esp) {
		this.esp = esp;
	}
	
		
}
