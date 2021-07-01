package basico;

public class Tipo_Licenca {
	
	private int idTipo;
	private String nomeTipo;
	
	public Tipo_Licenca(int idTipo, String nomeTipo) {
		
		this.idTipo = idTipo;
		this.nomeTipo = nomeTipo;
		
	}
	
	public Tipo_Licenca() {
		
	}
	
	public int getIdTipo() {
		return this.idTipo;
	}


	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}


	public String getNomeTipo() {
		return this.nomeTipo;
	}


	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
	
	
}
