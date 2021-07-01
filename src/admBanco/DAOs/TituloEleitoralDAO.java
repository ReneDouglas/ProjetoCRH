package admBanco.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import basico.TituloEleitoral;
import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class TituloEleitoralDAO implements InterfaceBanco{

	
	public String inserir(Object objct) {
		
	TituloEleitoral tituloeleitoral = (TituloEleitoral)objct;
	
	String retorno = "";
	PreparedStatement ps = null;
	Connection conn = null;
	
	try{
		String stringSQL="INSERT INTO tituloeleitoral (chaveFunc, numero, zona, secao) VALUES (?,?,?,?)";
		
		conn = AdmBancoSql.getConnection();
		ps = conn.prepareStatement(stringSQL);
		
		ps.setInt(1, tituloeleitoral.getChaveFunc());
		ps.setString(2, tituloeleitoral.getNumero());
		ps.setString(3, tituloeleitoral.getZona());
		ps.setString(4, tituloeleitoral.getSecao());

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
			ps = conn.prepareStatement("DELETE FROM tituloeleitoral WHERE chaveFunc = ?");
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
		
		TituloEleitoral tituloeleitoral = (TituloEleitoral)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE tituloeleitoral SET numero=?,zona=?,secao=? WHERE chaveFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, tituloeleitoral.getNumero());
			ps.setString(2, tituloeleitoral.getZona());
			ps.setString(3, tituloeleitoral.getSecao());
			ps.setInt(4, tituloeleitoral.getChaveFunc());
			
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
			ps = conn.prepareStatement("SELECT * FROM tituloeleitoral WHERE "+pesquisarColuna+" LIKE '%"+textoPesquisa+"%' ORDER BY "+organizarPor);
			result = ps.executeQuery();
			while( result.next() )
			{
				int idTitulo = result.getInt("chaveFunc");
				String numero = result.getString("numero");
				String zona = result.getString("zona");
				String secao = result.getString("secao");
				
				list.add(new TituloEleitoral(idTitulo, numero, zona, secao));
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
		TituloEleitoral titulo=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM tituloeleitoral WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					String numero = result.getString("numero");
					String zona = result.getString("zona");
					String secao = result.getString("secao");
					
					titulo = new TituloEleitoral(0, numero, zona, secao);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Alistamento n"+(char)227+"o encontrado");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return titulo;
		
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
