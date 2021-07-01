package basico;

public class Ferias {

	private int chaveFuncionario;
	private String periodoAq;
	private String periodoGozo;
	private String portaria;
	
	public Ferias(int chaveFunc, String periodoAq, String periodoGozo, String portaria) {
		
		this.chaveFuncionario = chaveFunc;
		this.periodoAq = periodoAq;
		this.periodoGozo = periodoGozo;
		this.portaria = portaria;
		
	}
	
	public Ferias() {
		// TODO Auto-generated constructor stub
	}

	public int getChaveFuncionario() {
		return chaveFuncionario;
	}

	public void setChaveFuncionario(int idFerias) {
		this.chaveFuncionario = idFerias;
	}

	public String getPeriodoAq() {
		return periodoAq;
	}

	public void setPeriodoAq(String periodoAq) {
		this.periodoAq = periodoAq;
	}

	public String getPeriodoGozo() {
		return periodoGozo;
	}

	public void setPeriodoGozo(String periodoGozo) {
		this.periodoGozo = periodoGozo;
	}

	public String getPortaria() {
		return portaria;
	}

	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}
	
	
}
