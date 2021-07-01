package admBanco.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import basico.Tipo_Licenca;
import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class Tipo_LicencaDAO implements InterfaceBanco{

	@Override
	public String inserir(Object objct) {
		
		Tipo_Licenca tipo_licenca = (Tipo_Licenca)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO tipolicenca (idTipo, nomeTipo) VALUES (?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, tipo_licenca.getIdTipo());
			ps.setString(2, tipo_licenca.getNomeTipo());
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
			ps = conn.prepareStatement("DELETE FROM tipolicenca WHERE idTipo = ?");
			ps.setInt(1, id);
			
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
	
		Tipo_Licenca tipo_licenca = (Tipo_Licenca)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE tipolicenca SET nomeTipo=? WHERE idTipo=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, tipo_licenca.getNomeTipo());
			ps.setInt(1, tipo_licenca.getIdTipo());
			
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
			ps = conn.prepareStatement("SELECT * FROM tipolicenca ORDER BY "+textoPesquisa);
			result = ps.executeQuery();
			while( result.next() )
			{
				int idTipo = result.getInt("idTipo");
				String nomeTipo = result.getString("nomeTipo");
				
				list.add(new Tipo_Licenca(idTipo, nomeTipo));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Erro durante a consulta!!\n"+sqle.getMessage());
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return list;
		
	}

	@Override
	public Object buscar(int id) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		String nomeTipo = null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM tipolicenca WHERE idTipo=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
					
					nomeTipo = result.getString("nomeTipo");
					
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Fornecedor n"+(char)227+"o encontrado");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return nomeTipo;
		
	}

	@Override
	public Object buscar(String nome) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		int idTipo = 0;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM tipolicenca WHERE nomeTipo=?");
			ps.setString(1, nome);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
					
					idTipo = result.getInt("idTipo");
					
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Fornecedor n"+(char)227+"o encontrado");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return idTipo;
		
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
