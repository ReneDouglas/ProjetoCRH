package basico;

import java.sql.Date;

public class Dependente {

	private int chaveFunc;
	private String nome;
	private String parentesco;
	private Date dataNasc;
	private Date inicio;
	private Date termino;
	
	
	public Dependente(int chaveFunc, String nome, String parentesco, Date dataNasc, Date inicio, Date termino) {
		
		this.chaveFunc = chaveFunc;
		this.nome = nome;
		this.parentesco = parentesco;
		this.dataNasc = dataNasc;
		this.inicio = inicio;
		this.termino = termino;
		
	}
	
	public Dependente() {
		// TODO Auto-generated constructor stub
	}


	public int getChaveFunc() {
		return chaveFunc;
	}


	public void setChaveFunc(int chaveFunc) {
		this.chaveFunc = chaveFunc;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getParentesco() {
		return parentesco;
	}


	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}


	public Date getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
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
	
	
	
}
