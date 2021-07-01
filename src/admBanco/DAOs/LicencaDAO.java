package admBanco.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import basico.Licenca;
import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class LicencaDAO implements InterfaceBanco{

	
	public String inserir(Object objct) {
		
		Licenca licenca = (Licenca)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO licenca (chaveFunc, tipoLicenca , inicio, termino, portaria, observ) VALUES (?,?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, licenca.getChaveFuncionario());
			ps.setInt(2, licenca.getTipoLicenca());
			ps.setDate(3, licenca.getInicio());
			ps.setDate(4, licenca.getTermino());
			ps.setString(5, licenca.getPortaria());
			ps.setString(6, licenca.getObserv());

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
			ps = conn.prepareStatement("DELETE FROM licenca WHERE chaveFunc = ? AND portaria = ?");
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
		
		Licenca licenca = (Licenca)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE licenca SET tipoLicenca=?,inicio=?,termino=?, observ=? WHERE chaveFunc=? AND portaria=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, licenca.getTipoLicenca());
			ps.setDate(2, licenca.getInicio());
			ps.setDate(3, licenca.getTermino());
			ps.setString(4, licenca.getObserv());
			ps.setInt(5, licenca.getChaveFuncionario());
			ps.setString(6, licenca.getPortaria());
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0){
				retorno = "N"+(char)227+"o foi poss"+(char)237+"vel encontrar os dados";
				
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
			ps = conn.prepareStatement("SELECT * FROM licenca WHERE "+pesquisarColuna+" LIKE '%"+textoPesquisa+"%' ORDER BY "+organizarPor);
			result = ps.executeQuery();
			while( result.next() )
			{
				int idLicen = result.getInt("chaveFunc");
				int tipoLicenca = result.getInt("tipoLicenca");
				Date inicio = result.getDate("inicio");
				Date termino = result.getDate("termino");
				String portaria = result.getString("portaria");
				String observ = result.getString("observ");
				
				list.add(new Licenca(idLicen, tipoLicenca, inicio, termino, portaria, observ));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Erro durante a consulta!!\n"+sqle.getMessage());
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return list;
		
	}

	
	public Object buscar(int id) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Licenca licenca = null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM licenca WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int chaveFunc = result.getInt("chaveFunc");
					int tipoLicenca = result.getInt("tipoLicenca");
					String portaria = result.getString("portaria");
					Date inicio = result.getDate("inicio");
					Date termino = result.getDate("termino");
					String observ = result.getString("observ");
					
					licenca = new Licenca(chaveFunc, tipoLicenca, inicio, termino, portaria, observ);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Licença n"+(char)227+"o encontrada");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return licenca;
		
	}
	
	public ArrayList<Licenca> buscarArray(int id) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		ArrayList<Licenca> licenca = new ArrayList<Licenca>();
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM licenca WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int chaveFunc = result.getInt("chaveFunc");
					int tipoLicenca = result.getInt("tipoLicenca");
					String portaria = result.getString("portaria");
					Date inicio = result.getDate("inicio");
					Date termino = result.getDate("termino");
					String observ = result.getString("observ");
					
					licenca.add(new Licenca(chaveFunc, tipoLicenca, inicio, termino, portaria, observ));
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Licença n"+(char)227+"o encontrada");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return licenca;
		
	}

	@Override
	public Object buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir() {
		// TODO Auto-generated method stub
		return null;
	}

	public int listar() {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		
		int idFunc = 0;
		
		try {
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT MAX(idLicen) FROM Licenca");
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


	public Object buscar(int chaveFunc, String nome) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Licenca licenca = null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM licenca WHERE chaveFunc=? AND portaria=?");
			ps.setInt(1, chaveFunc);
			ps.setString(2, nome);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int chaveFunc1 = result.getInt("chaveFunc");
					int tipoLicenca = result.getInt("tipoLicenca");
					String portaria = result.getString("portaria");
					Date inicio = result.getDate("inicio");
					Date termino = result.getDate("termino");
					String observ = result.getString("observ");
					
					licenca = new Licenca(chaveFunc1, tipoLicenca, inicio, termino, portaria, observ);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Licença n"+(char)227+"o encontrada");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return licenca;
		
	}
	
	
}
