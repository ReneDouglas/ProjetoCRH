package admBanco.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import basico.Identidade;
import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class IdentidadeDAO implements InterfaceBanco{

	
	public String inserir(Object objct) {
		
		Identidade identidade = (Identidade)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO identidade (chaveFunc, numero , ssp, data) VALUES (?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, identidade.getChaveFunc());
			ps.setString(2, identidade.getNumero());
			ps.setString(3, identidade.getSsp());
			ps.setDate(4, identidade.getData());

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterar(Object objct) {
		
		Identidade identidade = (Identidade)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE identidade SET numero=?, ssp=?," +
					"data=? WHERE chaveFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, identidade.getNumero());
			ps.setString(2, identidade.getSsp());
			ps.setDate(3, identidade.getData());
			ps.setInt(4, identidade.getChaveFunc());
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0){
				retorno = "N"+(char)227+"o foi poss"+(char)237+"vel alterar os dados.";
				
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
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object buscar(int id) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Identidade identidade=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM identidade WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					String numero = result.getString("numero");
					String ssp = result.getString("ssp");
					Date data = result.getDate("data");
					
					identidade = new Identidade(0, numero, ssp, data);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Identidade n"+(char)227+"o encontrada");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return identidade;
		
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

	@Override
	public Object buscar(int chaveFunc, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
