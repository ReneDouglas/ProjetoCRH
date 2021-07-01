package basico;

import java.sql.Date;

public class ConsultaFuncionario {

	private int idFunc;
	private String nome;
	private String cpf;
	private Date dataNasc;
	private String cargo;
	
	public ConsultaFuncionario(int idFunc, String nome, String cpf, String cargo) {
		
		this.idFunc = idFunc;
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		
	}
	
	public ConsultaFuncionario(int idFunc, String nome, Date dataNasc, String cpf){
		
		this.idFunc = idFunc;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		
	}
	
	public ConsultaFuncionario() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdFunc() {
		return idFunc;
	}


	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
