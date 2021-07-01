package basico;

import java.sql.Date;

public class VidaFuncional {

	private int chaveFuncionario;
	private String port;
	private Date dataNomeacao;
	private Date dataExercicio;
	private Date dataLicenca;
	private Date dataAlteracao;
	private String cargo;
	private String fs;
	private String p;
	private String secretaria;
	private String localizacao;
	private String observacao;
	
	public VidaFuncional(int chaveFunc, String port, Date dataNomeacao, Date dataExercicio, Date dataLicenca, Date dataAlteracao,
			String cargo, String fs, String p, String secretaria, String localizacao, String obs) {
		
		this.chaveFuncionario = chaveFunc;
		this.port = port;
		this.dataNomeacao = dataNomeacao;
		this.dataExercicio = dataExercicio;
		this.dataLicenca = dataLicenca;
		this.dataAlteracao = dataAlteracao;
		this.cargo = cargo;
		this.fs = fs;
		this.p = p;
		this.secretaria = secretaria;
		this.localizacao = localizacao;
		this.observacao = obs;
		
	}

	public VidaFuncional(int chaveFunc, String portaria, Date dataNomeacao,
			Date dataExercicio, Date dataLicenca, Date dataAlteracao,
			String cargo, String fs, String p, String obs) {
		
		this.chaveFuncionario = chaveFunc;
		this.port = portaria;
		this.dataNomeacao = dataNomeacao;
		this.dataExercicio = dataExercicio;
		this.dataLicenca = dataLicenca;
		this.dataAlteracao = dataAlteracao;
		this.cargo = cargo;
		this.fs = fs;
		this.p = p;
		this.observacao = obs;
		
	}
	
	
	public VidaFuncional(){
		
	}


	public int getChaveFuncionario() {
		return chaveFuncionario;
	}

	public void setChaveFuncionario(int idHist) {
		this.chaveFuncionario = idHist;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Date getDataNomeacao() {
		return dataNomeacao;
	}

	public void setDataNomeacao(Date dataNomeacao) {
		this.dataNomeacao = dataNomeacao;
	}

	public Date getDataExercicio() {
		return dataExercicio;
	}

	public void setDataExercicio(Date dataExercicio) {
		this.dataExercicio = dataExercicio;
	}

	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFs() {
		return fs;
	}

	public void setFs(String fs) {
		this.fs = fs;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}
	
	

	public String getSecretaria() {
		return secretaria;
	}


	public void setSecretaria(String secretaria) {
		this.secretaria = secretaria;
	}


	public String getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
		
}
