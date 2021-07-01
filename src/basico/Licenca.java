package basico;

import java.sql.Date;

public class Licenca {

	private int chaveFuncionario;
	private int tipoLicenca;
	private Date inicio;
	private Date termino;
	private String portaria;
	private String observ;
	
	public Licenca(int chaveFunc, int tipoLicenca, Date inicio, Date termino, String portaria, String observ) {
		
		this.chaveFuncionario = chaveFunc;
		this.tipoLicenca = tipoLicenca;
		this.inicio = inicio;
		this.termino = termino;
		this.portaria = portaria;
		this.observ = observ;
		
	}
	
	public Licenca() {
		// TODO Auto-generated constructor stub
	}

	public int getChaveFuncionario() {
		return chaveFuncionario;
	}

	public void setChaveFuncionario(int idLicen) {
		this.chaveFuncionario = idLicen;
	}

	public int getTipoLicenca() {
		return tipoLicenca;
	}

	public void setTipoLicenca(int tipoLicenca) {
		this.tipoLicenca = tipoLicenca;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public String getPortaria() {
		return portaria;
	}

	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}

	public String getObserv() {
		return observ;
	}

	public void setObserv(String observ) {
		this.observ = observ;
	}
	
	
	
}
