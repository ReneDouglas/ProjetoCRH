package basico;

import java.sql.Date;

public class CarteiraDeTrabalho {

	private int chaveFunc;
	private String ctpsNumero;
	private String serie;
	private Date data;
	
	
	public CarteiraDeTrabalho(int chaveFunc, String ctpsNumero, String serie, Date data) {
		
		this.chaveFunc = chaveFunc;
		this.ctpsNumero = ctpsNumero;
		this.serie = serie;
		this.data = data;
		
	}

	public CarteiraDeTrabalho() {
		// TODO Auto-generated constructor stub
	}

	public int getChaveFunc() {
		return chaveFunc;
	}


	public void setIdCart(int idCart) {
		this.chaveFunc = idCart;
	}


	public String getCtpsNumero() {
		return ctpsNumero;
	}


	public void setCtpsNumero(String ctpsNumero) {
		this.ctpsNumero = ctpsNumero;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	
	
}
