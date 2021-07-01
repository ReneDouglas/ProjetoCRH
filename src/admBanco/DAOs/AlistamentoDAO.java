package admBanco.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import basico.Alistamento;
import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class AlistamentoDAO implements InterfaceBanco{

	
	public String inserir(Object objct) {
		
		Alistamento alistamento = (Alistamento)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO alistamento (chaveFunc, situacaoMilitar , serie, esp) VALUES (?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, alistamento.getChaveFunc());
			ps.setString(2, alistamento.getSituacaoMilitar());
			ps.setString(3, alistamento.getSerie());
			ps.setString(4, alistamento.getEsp());

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
		
		Alistamento alistamento = (Alistamento)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE alistamento SET situacaoMilitar=?, serie=?," +
					"esp=? WHERE chaveFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, alistamento.getSituacaoMilitar());
			ps.setString(2, alistamento.getSerie());
			ps.setString(3, alistamento.getEsp());
			ps.setInt(4, alistamento.getChaveFunc());
			
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
		Alistamento alistamento=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM alistamento WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					String situacaoMilitar = result.getString("situacaoMilitar");
					String serie = result.getString("serie");
					String esp = result.getString("esp");
					
					alistamento = new Alistamento(0, situacaoMilitar, serie, esp);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Alistamento n"+(char)227+"o encontrado");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return alistamento;
		
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
