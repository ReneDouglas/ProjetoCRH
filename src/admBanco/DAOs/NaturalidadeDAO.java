package admBanco.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import basico.Naturalidade;
import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class NaturalidadeDAO implements InterfaceBanco{

	
	public String inserir(Object objct) {
		
		Naturalidade naturalidade = (Naturalidade) objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO naturalidade (chaveFunc, cidadeNat , estadoNat) VALUES (?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, naturalidade.getChaveFunc());
			ps.setString(2, naturalidade.getCidade());
			ps.setString(3, naturalidade.getEstado());

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
	
		Naturalidade naturalidade = (Naturalidade)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE naturalidade SET cidadeNat=?, estadoNat=? WHERE chaveFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, naturalidade.getCidade());
			ps.setString(2, naturalidade.getEstado());
			
			ps.setInt(3, naturalidade.getChaveFunc());
			
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
		Naturalidade naturalidade=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM naturalidade WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					String cidadeNat = result.getString("cidadeNat");
					String estadoNat = result.getString("estadoNat");
					
					naturalidade = new Naturalidade(0, cidadeNat, estadoNat);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Naturalidade n"+(char)227+"o encontrada");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return naturalidade;
		
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
