package controle;

import java.util.ArrayList;

import basico.Tipo_Licenca;
import admBanco.DAOs.Tipo_LicencaDAO;
import controle.interfaceControle.I_ControleTipoLicenca;

public class ControleTipoLicenca implements I_ControleTipoLicenca{

	public String salvar(int idTipo, String nomeTipo) {
		
		Tipo_LicencaDAO salvar = new Tipo_LicencaDAO();
		
		String retorno = salvar.inserir(new Tipo_Licenca(idTipo, nomeTipo));
		
		return retorno;
	}

	public String[] listar(String nomePesquisa) {
	
		Tipo_LicencaDAO list = new Tipo_LicencaDAO();
		Tipo_Licenca licenca = new Tipo_Licenca();
		ArrayList<Object> temp = new ArrayList<Object>();
		String[] listarLicenca;
		
		temp = list.listar_1(nomePesquisa, nomePesquisa, nomePesquisa);
		listarLicenca = new String[(temp.size())];
		
		for (int i = 0; i < temp.size(); i++) {
			licenca = (Tipo_Licenca) temp.get(i);
			listarLicenca[i] = licenca.getNomeTipo();
		}
		
		
		return listarLicenca;
		
	}

	public String buscar(int id) {
		
		Tipo_LicencaDAO buscarTipo = new Tipo_LicencaDAO();
		
		String retorno = (String) buscarTipo.buscar(id);
		
		return retorno;
	}
	
	

}
