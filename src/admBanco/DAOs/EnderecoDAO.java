package admBanco.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import basico.Endereco;

import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class EnderecoDAO implements InterfaceBanco{


	public String inserir(Object objct) {
		Endereco endereco = (Endereco) objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO endereco (chaveFunc, rua , numero, bairro) VALUES (?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, endereco.getChaveFunc());
			ps.setString(2, endereco.getRua());
			ps.setString(3, endereco.getNumero());
			ps.setString(4, endereco.getBairro());

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
		// TODO Auto-generated method stub
		return null;
	}


	public String alterar(Object objct) {
		
		Endereco endereco = (Endereco) objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE endereco SET rua=?,numero=?,bairro=? WHERE chaveFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getNumero());
			ps.setString(3, endereco.getBairro());
			ps.setInt(4, endereco.getChaveFunc());
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0){
				retorno = "N"+(char)227+"o foi poss"+(char)237+"vel encontrar o endereco";
				
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


	public ArrayList<Object> listar_1(String pesquisarColuna,
			String organizarPor, String textoPesquisa) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;	
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM endereco WHERE "+pesquisarColuna+" LIKE '%"+textoPesquisa+"%' ORDER BY "+organizarPor);
			result = ps.executeQuery();
			while( result.next() )
			{
				int chaveFunc = result.getInt("chaveFunc");
				String rua = result.getString("rua");
				String numero = result.getString("numero");
				String bairro = result.getString("bairro");
				
				list.add(new Endereco(chaveFunc, rua, numero, bairro));
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
		Endereco endereco=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM endereco WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					String rua = result.getString("rua");
					String numero = result.getString("numero");
					String bairro = result.getString("bairro");
					
					endereco = new Endereco(0, rua, numero, bairro);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Endereço n"+(char)227+"o encontrado");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return endereco;
		
		
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
