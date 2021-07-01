package admBanco.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import basico.VidaFuncional;
import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class VidaFuncionalDAO implements InterfaceBanco{


	public String inserir(Object objct) {
		
		VidaFuncional historico = (VidaFuncional)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO historico (chaveFunc, portaria , dataNomeacao, dataExercicio," +
					"dataLicenca, dataAlteracao, cargo, fs, p, secretaria, localizacao, observacao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, historico.getChaveFuncionario());
			ps.setString(2, historico.getPort());
			ps.setDate(3, historico.getDataNomeacao());
			ps.setDate(4, historico.getDataExercicio());
			ps.setDate(5, historico.getDataLicenca());
			ps.setDate(6, historico.getDataAlteracao());
			ps.setString(7, historico.getCargo());
			ps.setString(8, historico.getFs());
			ps.setString(9, historico.getP());
			ps.setString(10, historico.getSecretaria());
			ps.setString(11, historico.getLocalizacao());
			ps.setString(12, historico.getObservacao());

			ps.executeUpdate();
			
			retorno = "Dados registrados com sucesso.";
		} catch (SQLException sqle) {
			retorno = "Erro ao registrar os dados\n"+sqle.getMessage();
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		return retorno;
	}

	
	public String excluir(int id, String nome) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		String retorno=null;
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("DELETE FROM historico WHERE chaveFunc = ? AND portaria = ?");
			ps.setInt(1, id);
			ps.setString(2, nome);
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0)
				retorno="Erro!!\nN"+(char)227+"o foi poss"+(char)237+"vel encontrar os dados";
			
			else if (statusExclusao==1)
				retorno="Dado excluido com sucesso.";
				
				
		} catch (SQLException sqle) {
			retorno="Erro durante a exclus"+(char)227+"o\n"+sqle.getMessage();

		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
		return retorno;
	}

	@Override
	public String alterar(Object objct) {

		VidaFuncional historico = (VidaFuncional)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE historico SET dataNomeacao=?, dataExercicio=?," +
					"dataLicenca=?, dataAlteracao=?, cargo=?, fs=?, p=?, observacao=? WHERE chaveFunc=? AND portaria=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setDate(1, historico.getDataNomeacao());
			ps.setDate(2, historico.getDataExercicio());
			ps.setDate(3, historico.getDataLicenca());
			ps.setDate(4, historico.getDataAlteracao());
			ps.setString(5, historico.getCargo());
			ps.setString(6, historico.getFs());
			ps.setString(7, historico.getP());
			ps.setString(8, historico.getObservacao());
			ps.setInt(9, historico.getChaveFuncionario());
			ps.setString(10, historico.getPort());

			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0){
				retorno = "N"+(char)227+"o foi poss"+(char)237+"vel encontrar o histórico";
				
			}
			
			else if (statusExclusao==1){
				retorno = "Dados atualizados com sucesso.";
			}
			
		} catch (SQLException sqle) {
			retorno = "Erro ao alterar os dados.\n"+sqle.getMessage();
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		return retorno;
	}

	@Override
	public ArrayList<Object> listar_1(String pesquisarColuna,
			String organizarPor, String textoPesquisa) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;	
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM historico WHERE chaveFunc="+pesquisarColuna);
			result = ps.executeQuery();
			while( result.next() )
			{
				int idHist = result.getInt("chaveFunc");
				String port = result.getString("portaria");
				Date dataNomeacao = result.getDate("dataNomeacao");
				Date dataExercicio = result.getDate("dataExercicio");
				Date dataLicenca = result.getDate("dataLicenca");
				Date dataAlteracao = result.getDate("dataAlteracao");
				String cargo = result.getString("cargo");
				String fs = result.getString("fs");
				String p = result.getString("p");
				String secretaria = result.getString("secretaria");
				String localizacao = result.getString("localizacao");
				String obs = result.getString("observacao");
				
				list.add(new VidaFuncional(idHist, port, dataNomeacao, dataExercicio, dataLicenca, dataAlteracao, cargo, fs, p, secretaria, localizacao, obs));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Erro durante a consulta!!\n"+sqle.getMessage());
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return list;
		
		
	}
	
	public int listar() {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		
		int idFunc = 0;
		
		try {
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT MAX(idHist) FROM historico");
			result = ps.executeQuery();
			
			while(result.next()){
				idFunc = result.getInt("MAX(chaveFunc)");
			}	
			
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Erro durante a consulta!!\n"+sqle.getMessage());
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return idFunc;
		
	}

	
	public Object buscar(int id) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		VidaFuncional vidaFuncional=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM historico WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					String port = result.getString("portaria");
					Date dataNomeacao = result.getDate("dataNomeacao");
					Date dataExercicio = result.getDate("dataExercicio");
					Date dataLicenca = result.getDate("dataLicenca");
					Date dataAlteracao = result.getDate("dataAlteracao");
					String cargo = result.getString("cargo");
					String fs = result.getString("fs");
					String p = result.getString("p");
					String secretaria = result.getString("secretaria");
					String localizacao = result.getString("localizacao");
					String obs = result.getString("observacao");
					
					
					vidaFuncional = new VidaFuncional(0, port, dataNomeacao, dataExercicio, dataLicenca, dataAlteracao,
							cargo, fs, p, secretaria, localizacao, obs);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Historico n"+(char)227+"o encontrado");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return vidaFuncional;
		
	}
	
	public ArrayList<VidaFuncional> buscarArray(int id) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		ArrayList<VidaFuncional> vidaFuncional = new ArrayList<VidaFuncional>();
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM historico WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int chaveFunc = result.getInt("chaveFunc");
					String port = result.getString("portaria");
					Date dataNomeacao = result.getDate("dataNomeacao");
					Date dataExercicio = result.getDate("dataExercicio");
					Date dataLicenca = result.getDate("dataLicenca");
					Date dataAlteracao = result.getDate("dataAlteracao");
					String cargo = result.getString("cargo");
					String fs = result.getString("fs");
					String p = result.getString("p");
					String secretaria = result.getString("secretaria");
					String localizacao = result.getString("localizacao");
					String obs = result.getString("observacao");
					
					
					vidaFuncional.add(new VidaFuncional(chaveFunc, port, dataNomeacao, dataExercicio, dataLicenca, dataAlteracao,
							cargo, fs, p, secretaria, localizacao, obs));
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Naturalidade n"+(char)227+"o encontrada");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return vidaFuncional;
		
	}
	
	public Object buscar(int chaveFunc, String nome) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		VidaFuncional vidaFuncional=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM historico WHERE chaveFunc=? AND portaria=?");
			ps.setInt(1, chaveFunc);
			ps.setString(2, nome);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int chaveFunc1 = result.getInt("chaveFunc");
					String port = result.getString("portaria");
					Date dataNomeacao = result.getDate("dataNomeacao");
					Date dataExercicio = result.getDate("dataExercicio");
					Date dataLicenca = result.getDate("dataLicenca");
					Date dataAlteracao = result.getDate("dataAlteracao");
					String cargo = result.getString("cargo");
					String fs = result.getString("fs");
					String p = result.getString("p");
					String secretaria = result.getString("secretaria");
					String localizacao = result.getString("localizacao");
					String obs = result.getString("observacao");
					
					System.out.println(chaveFunc1+" "+port+" "+dataNomeacao+" "+dataExercicio);
					
					vidaFuncional = new VidaFuncional(chaveFunc1, port, dataNomeacao, dataExercicio, dataLicenca, dataAlteracao,
							cargo, fs, p, secretaria, localizacao, obs);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Historico n"+(char)227+"o encontrado");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return vidaFuncional;
		
	}


	@Override
	public String excluir() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
