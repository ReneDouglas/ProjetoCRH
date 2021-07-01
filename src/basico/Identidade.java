package basico;

import java.sql.Date;

public class Identidade {

	private int chaveFunc;
	private String numero;
	private String ssp;
	private Date data;
	
	public Identidade(int chaveFunc, String numero, String ssp, Date data) {
		
		this.chaveFunc = chaveFunc;
		this.numero = numero;
		this.ssp = ssp;
		this.data = data;
		
	}
	
	public Identidade() {
		// TODO Auto-generated constructor stub
	}

	public int getChaveFunc() {
		return chaveFunc;
	}

	public void setChaveFunc(int chaveFunc) {
		this.chaveFunc = chaveFunc;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSsp() {
		return ssp;
	}

	public void setSsp(String ssp) {
		this.ssp = ssp;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
		
}
