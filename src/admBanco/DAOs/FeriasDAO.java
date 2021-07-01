package admBanco.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import basico.Ferias;
import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class FeriasDAO implements InterfaceBanco{

	
	public String inserir(Object objct) {
		
		Ferias ferias = (Ferias)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO ferias (chaveFunc, periodoAq , periodoGozo, portaria) VALUES (?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, ferias.getChaveFuncionario());
			ps.setString(2, ferias.getPeriodoAq());
			ps.setString(3, ferias.getPeriodoGozo());
			ps.setString(4, ferias.getPortaria());

			ps.executeUpdate();
			
			retorno = "Dados registrados com sucesso.";
		} catch (SQLException sqle) {
			retorno = "Erro ao registrar os dados\n"+sqle.getMessage();
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		return retorno;
	}

	@Override
	public String excluir(int id, String nome) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		String retorno=null;
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("DELETE FROM ferias WHERE chaveFunc = ? AND portaria = ?");
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

		Ferias ferias = (Ferias) objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE ferias SET periodoAq=?,periodoGozo=? WHERE chaveFunc=? AND portaria=?";
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, ferias.getPeriodoAq());
			ps.setString(2, ferias.getPeriodoGozo());
			ps.setInt(3, ferias.getChaveFuncionario());
			ps.setString(4, ferias.getPortaria());
			
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
			ps = conn.prepareStatement("SELECT * FROM ferias WHERE "+pesquisarColuna+" LIKE '%"+textoPesquisa+"%' ORDER BY "+organizarPor);
			result = ps.executeQuery();
			while( result.next() )
			{
				int idFerias = result.getInt("chaveFunc");
				String periodoAq = result.getString("periodoAq");
				String periodoGozo = result.getString("periodoGozo");
				String portaria = result.getString("portaria");
				
				list.add(new Ferias(idFerias, periodoAq, periodoGozo, portaria));
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
			ps = conn.prepareStatement("SELECT MAX(idFerias) FROM Ferias");
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
		Ferias ferias=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM ferias WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int chaveFunc = result.getInt("chaveFunc");
					String periodoAq = result.getString("periodoAq");
					String periodoGozo = result.getString("periodoGozo");
					String portaria = result.getString("portaria");
					
					ferias = new Ferias(chaveFunc, periodoAq, periodoGozo, portaria);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Férias n"+(char)227+"o encontradas");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return ferias;	
		
	}
	
	public ArrayList<Ferias> buscarArray(int id) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		ArrayList<Ferias> ferias=new ArrayList<Ferias>();
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM ferias WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int chaveFunc = result.getInt("chaveFunc");
					String periodoAq = result.getString("periodoAq");
					String periodoGozo = result.getString("periodoGozo");
					String portaria = result.getString("portaria");
					
					ferias.add(new Ferias(chaveFunc, periodoAq, periodoGozo, portaria));
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Férias n"+(char)227+"o encontradas");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return ferias;
		
	}

	public Object buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object buscar(int chaveFunc, String nome) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Ferias ferias=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM ferias WHERE chaveFunc=? AND portaria=?");
			ps.setInt(1, chaveFunc);
			ps.setString(2, nome);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int chaveFunc1 = result.getInt("chaveFunc");
					String periodoAq = result.getString("periodoAq");
					String periodoGozo = result.getString("periodoGozo");
					String portaria = result.getString("portaria");
					
					ferias = new Ferias(chaveFunc1, periodoAq, periodoGozo, portaria);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Férias n"+(char)227+"o encontradas");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return ferias;	
		
	}

	
}
