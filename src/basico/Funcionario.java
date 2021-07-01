package basico;

import java.sql.Date;

public class Funcionario {

	private int idFunc;
	private int chaveHistorico;
	private String nome;
	private String nomePai;
	private String nomeMae;
	private Date dataNasc;
	private String sexo;
	private String estCivil;
	private String pasep;
	private String matricula;
	private String cpf;
	private String grauDeInst;
	
	public Funcionario(){
		
		
	}
	
	public Funcionario(int idFunc, String nome, String nomePai, String nomeMae, Date dataNasc, String sexo, 
			String estCivil, String pasep, String matricula, String cpf, String grauDeInst) {
		
		this.idFunc = idFunc;
		this.nome = nome;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.estCivil = estCivil;
		this.pasep = pasep;
		this.matricula = matricula;
		this.cpf = cpf;
		this.grauDeInst = grauDeInst;
		
	}
	
	public Funcionario(int idFunc, int chaveHistorico){
		
		this.idFunc = idFunc;
		this.chaveHistorico = chaveHistorico;
		
	}
		
	public int getIdFunc() {
		return idFunc;
	}

	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}
		
	public int getChaveHistorico() {
		return chaveHistorico;
	}

	public void setChaveHistorico(int chaveHistorico) {
		this.chaveHistorico = chaveHistorico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}

	public String getPasep() {
		return pasep;
	}

	public void setPasep(String pasep) {
		this.pasep = pasep;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGrauDeInst() {
		return grauDeInst;
	}


	public void setGrauDeInst(String grauDeInst) {
		this.grauDeInst = grauDeInst;
	}	
	
}
