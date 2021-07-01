package controle.interfaceControle;

import java.sql.Date;

public interface I_ControleVidaFuncional {

	public String salvar(int chaveFunc, String portaria, Date dataNomeacao, Date dataExercicio, Date dataLicenca,
			Date dataAlteracao, String cargo, String fs, String p, String secretaria, String local, String obs, int seletor); // seletor(1) - salvar, seletor(2) - alterar
	public String excluir(int chaveFunc, String portaria);
	public Object buscar(int id);
	public String alterar(int chaveFunc, String portaria, Date dataNomeacao, Date dataExercicio, Date dataLicenca,
			Date dataAlteracao, String cargo, String fs, String p, String secretaria, String local, String obs);
}
