package controle;

import java.sql.Date;
import java.util.ArrayList;
import basico.VidaFuncional;
import admBanco.DAOs.FuncionarioDAO;
import admBanco.DAOs.VidaFuncionalDAO;

import controle.interfaceControle.I_ControleVidaFuncional;

public class ControleVidaFuncional implements I_ControleVidaFuncional{

	
	public String salvar(int chaveFunc, String portaria, Date dataNomeacao,
			Date dataExercicio, Date dataLicenca, Date dataAlteracao,
			String cargo, String fs, String p, String secretaria, String local,
			String obs, int seletor) {
		
		
		VidaFuncionalDAO salvarHistorico = new VidaFuncionalDAO();
		FuncionarioDAO func = new FuncionarioDAO();
		String retorno = null;
		
		if(seletor == 1){
			retorno = salvarHistorico.inserir(new VidaFuncional(func.listar(), portaria, dataNomeacao, 
					dataExercicio, dataLicenca, dataAlteracao, cargo, fs, p, secretaria, local, obs));
		}
		else if(seletor == 2){
			retorno = salvarHistorico.inserir(new VidaFuncional(chaveFunc, portaria, dataNomeacao, 
					dataExercicio, dataLicenca, dataAlteracao, cargo, fs, p, secretaria, local, obs));
		}
		
				
		return retorno;
	}


	public ArrayList<VidaFuncional> buscar(int id) {
		
		VidaFuncionalDAO buscarHist = new VidaFuncionalDAO();
		ArrayList<VidaFuncional> arrayHist = new ArrayList<VidaFuncional>();
		arrayHist = buscarHist.buscarArray(id);

		return arrayHist;
	}


	public String excluir(int chaveFunc, String portaria) {
		
		VidaFuncionalDAO excluirHist = new VidaFuncionalDAO();
		
		String retorno = excluirHist.excluir(chaveFunc, portaria);
		
		return retorno;
	}


	public String alterar(int chaveFunc, String portaria, Date dataNomeacao,
			Date dataExercicio, Date dataLicenca, Date dataAlteracao,
			String cargo, String fs, String p, String secretaria, String local,
			String obs) {
		
		VidaFuncionalDAO alterarHist = new VidaFuncionalDAO();
		String retorno = null;
		
		//CHAMA A FUNCAO ALTERAR, SE NAO EXISTIR, CHAMA A FUNCAO DE CADASTRAR !
	
		String retornoBusca = alterarHist.alterar(new VidaFuncional(chaveFunc, portaria, dataNomeacao, dataExercicio, dataLicenca, dataAlteracao, cargo, fs, p, obs));
		
		if(retornoBusca.substring(0, 3).equalsIgnoreCase("Não")){
			
			retorno = salvar(chaveFunc, portaria, dataNomeacao, dataExercicio, dataLicenca, dataAlteracao, cargo, fs, p, secretaria, local, obs, 2);
			return retorno;
			
		}
		
		return retornoBusca;
	}


	

}
