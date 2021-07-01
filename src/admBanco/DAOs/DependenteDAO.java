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
import basico.Dependente;

public class DependenteDAO implements InterfaceBanco{
	
	public String inserir(Object objct) {
		
		Dependente dependente = (Dependente) objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO dependente (chaveFunc, nome , parentesco, dataNasc, inicio, termino) VALUES (?,?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, dependente.getChaveFunc());
			ps.setString(2, dependente.getNome());
			ps.setString(3, dependente.getParentesco());
			ps.setDate(4, dependente.getDataNasc());
			ps.setDate(5, dependente.getInicio());
			ps.setDate(6, dependente.getTermino());

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
			ps = conn.prepareStatement("DELETE FROM dependente WHERE chaveFunc = ? AND nome=?");
			ps.setInt(1, id);
			ps.setString(2, nome);
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0)
				retorno="Erro!!\nN"+(char)227+"o foi poss"+(char)237+"vel encontrar o dependente: "+nome;
			
			else if (statusExclusao==1)
				retorno="Dado excluido com sucesso. Exclus"+(char)227+"o do dependente: "+nome;
				
				
		} catch (SQLException sqle) {
			retorno="Erro durante a exclus"+(char)227+"o\n"+sqle.getMessage();

		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
		return retorno;
		
	}
	
	public String alterar(Object objct) {
		Dependente dependente = (Dependente) objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE dependente SET parentesco=?,dataNasc=?, inicio=?, termino=? WHERE chaveFunc=? AND nome=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			
			ps.setString(1, dependente.getParentesco());
			ps.setDate(2, dependente.getDataNasc());
			ps.setDate(3, dependente.getInicio());
			ps.setDate(4, dependente.getTermino());
			ps.setInt(5, dependente.getChaveFunc());
			ps.setString(6, dependente.getNome());
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0){
				retorno = "N"+(char)227+"o foi poss"+(char)237+"vel encontrar: "+dependente.getNome();
				
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
			ps = conn.prepareStatement("SELECT * FROM dependente WHERE "+pesquisarColuna+" LIKE '%"+textoPesquisa+"%' ORDER BY "+organizarPor);
			result = ps.executeQuery();
			while( result.next() )
			{
				int chaveFunc = result.getInt("chaveFunc");
				String nome = result.getString("nome");
				String parentesco = result.getString("parentesco");
				Date dataNasc = result.getDate("dataNasc");
				Date inicio = result.getDate("inicio");
				Date termino = result.getDate("termino");
				
				list.add(new Dependente(chaveFunc, nome, parentesco, dataNasc, inicio, termino));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Erro durante a consulta!!\n"+sqle.getMessage());
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return list;
		
	}

	
	public ArrayList<Dependente> buscar(int id) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		ArrayList<Dependente>dependentes = new ArrayList<Dependente>();
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM dependente WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int chaveFunc = result.getInt("chaveFunc");
					String nome = result.getString("nome");
					String parentesco = result.getString("parentesco");
					Date dataNasc = result.getDate("dataNasc");
					Date inicio = result.getDate("inicio");
					Date termino = result.getDate("termino");
					
					dependentes.add(new Dependente(chaveFunc, nome, parentesco, dataNasc, inicio, termino));
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Dependente n"+(char)227+"o encontrado");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return dependentes;
		
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
