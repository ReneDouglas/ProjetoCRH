package controle;

import java.sql.Date;
import java.util.ArrayList;

import basico.Licenca;

import admBanco.DAOs.FuncionarioDAO;
import admBanco.DAOs.LicencaDAO;
import admBanco.DAOs.Tipo_LicencaDAO;

import controle.interfaceControle.I_ControleLicenca;

public class ControleLicenca implements I_ControleLicenca{

	
	public String salvar(int chaveFunc, String tipoLicenca, Date inicio,
			Date termino, String port, String observ, int seletor) {
		
		LicencaDAO salvarLicenca = new LicencaDAO();
		Tipo_LicencaDAO tipo = new Tipo_LicencaDAO();
		FuncionarioDAO chaveFuncionario = new FuncionarioDAO();
		String retorno = null;
		
		if(seletor == 1){
			retorno = salvarLicenca.inserir(new Licenca(chaveFuncionario.listar(), (int) tipo.buscar(tipoLicenca), inicio, termino, port, observ));
		}
		else if(seletor == 2){
			retorno = salvarLicenca.inserir(new Licenca(chaveFunc, (int) tipo.buscar(tipoLicenca), inicio, termino, port, observ));
		}
		
		return retorno;
		
	}

	
	public ArrayList<Licenca> buscar(int id) {
		
		LicencaDAO buscarLicenFunc = new LicencaDAO();
		ArrayList<Licenca> licenFunc = new ArrayList<Licenca>();
		
		licenFunc = buscarLicenFunc.buscarArray(id);
		
		return licenFunc;
		
	}

	
	public String excluir(int chaveFunc, String portaria) {
		
		LicencaDAO excluirLicen = new LicencaDAO();
		
		String resultado = excluirLicen.excluir(chaveFunc, portaria);
		
		return resultado;
	}

	public String alterar(int chaveFunc, String tipoLicenca, Date inicio,
			Date termino, String port, String observ) {
		
		LicencaDAO alterarLicen = new LicencaDAO();
		Tipo_LicencaDAO tipo = new Tipo_LicencaDAO();
		String retorno = null;
		String returnBusca = alterarLicen.alterar(new Licenca(chaveFunc,(int) tipo.buscar(tipoLicenca), inicio, termino, port, observ));
		
		if(returnBusca.substring(0, 3).equalsIgnoreCase("Não")){
			retorno = salvar(chaveFunc, tipoLicenca, inicio, termino, port, observ, 2);
			return retorno;
		}
		
		
		return returnBusca;
	}

}
