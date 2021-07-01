package admBanco.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;
import basico.CarteiraDeTrabalho;

public class CarteiraDeTrabalhoDAO implements InterfaceBanco{
	
	public String inserir(Object objct) {
		
		CarteiraDeTrabalho carteiraDeTrabalho = (CarteiraDeTrabalho) objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO carteira_de_trabalho (chaveFunc, ctpsNumero , serie, data) VALUES (?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, carteiraDeTrabalho.getChaveFunc());
			ps.setString(2, carteiraDeTrabalho.getCtpsNumero());
			ps.setString(3, carteiraDeTrabalho.getSerie());
			ps.setDate(4, carteiraDeTrabalho.getData());

			ps.executeUpdate();
			
			retorno = "Dados registrados com sucesso.";
		} catch (SQLException sqle) {
			retorno = "Erro ao registrar os dados\n"+sqle.getMessage();
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		return retorno;
	}
	
	public String excluir(int id, String ctpsNumero) {
		PreparedStatement ps = null;
		Connection conn = null;
		String retorno=null;
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("DELETE FROM carteira_de_trabalho WHERE idCart = ?");
			ps.setInt(1, id);
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0)
				retorno="Erro!!\nN"+(char)227+"o foi poss"+(char)237+"vel encontrar a carteira de numero: "+ctpsNumero;
			
			else if (statusExclusao==1)
				retorno="Dado excluido com sucesso. Exclus"+(char)227+"o da carteira de numero: "+ctpsNumero;
				
				
		} catch (SQLException sqle) {
			retorno="Erro durante a exclus"+(char)227+"o\n"+sqle.getMessage();

		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
		return retorno;
		
	}
	
	public String alterar(Object objct) {
		
		CarteiraDeTrabalho CarteiraDeTrabalho = (CarteiraDeTrabalho) objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE carteira_de_trabalho SET ctpsNumero=?,serie=?,data=? WHERE chaveFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, CarteiraDeTrabalho.getCtpsNumero());
			ps.setString(2, CarteiraDeTrabalho.getSerie());
			ps.setDate(3, CarteiraDeTrabalho.getData());
			ps.setInt(4, CarteiraDeTrabalho.getChaveFunc());

			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0){
				retorno = "N"+(char)227+"o foi poss"+(char)237+"vel encontrar a carteira de número: "+CarteiraDeTrabalho.getCtpsNumero();
				
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
			ps = conn.prepareStatement("SELECT * FROM carteira_de_trabalho WHERE "+pesquisarColuna+" LIKE '%"+textoPesquisa+"%' ORDER BY "+organizarPor);
			result = ps.executeQuery();
			while( result.next() )
			{
				int idCart = result.getInt("idCart");
				String ctpsNumero = result.getString("ctpsNumero");
				String serie = result.getString("serie");
				Date data = result.getDate("data");
				
				list.add(new CarteiraDeTrabalho(idCart, ctpsNumero, serie, data));
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
		CarteiraDeTrabalho cartTrab=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM carteira_de_trabalho WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					String ctpsNumero = result.getString("ctpsNumero");
					String serie = result.getString("serie");
					Date data = result.getDate("data");
					
					cartTrab = new CarteiraDeTrabalho(0, ctpsNumero, serie, data);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Carteira de Trabalho n"+(char)227+"o encontrada");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return cartTrab;
		
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
