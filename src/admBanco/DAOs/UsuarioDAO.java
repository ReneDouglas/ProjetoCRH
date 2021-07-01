package admBanco.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import basico.Usuario;
import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class UsuarioDAO implements InterfaceBanco{

	
	public String inserir(Object objct) {
		
		Usuario usuario = (Usuario) objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO usuario (login, senha) VALUES (?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());

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
			ps = conn.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
			ps.setInt(1, id);
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0)
				retorno="Erro!!\nN"+(char)227+"o foi poss"+(char)237+"vel encontrar o usuario";
			
			else if (statusExclusao==1)
				retorno="Dado excluido com sucesso. Exclus"+(char)227+"o do usuario de ID: "+id;
				
				
		} catch (SQLException sqle) {
			retorno="Erro durante a exclus"+(char)227+"o\n"+sqle.getMessage();

		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
		return retorno;
		
	}

	@Override
	public String excluir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterar(Object objct) {
		Usuario usuario = (Usuario) objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			
			String SQL = "UPDATE usuario SET login=?, senha=? WHERE idUsuario=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(3, usuario.getIdUsuario());
			
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0){
				retorno = "N"+(char)227+"o foi poss"+(char)237+"vel encontrar o usuário: "+usuario.getLogin();
				
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
			ps = conn.prepareStatement("SELECT * FROM usuario WHERE "+pesquisarColuna+" LIKE '%"+textoPesquisa+"%' ORDER BY "+organizarPor);
			result = ps.executeQuery();
			while( result.next() )
			{
				int idUsuario = result.getInt("idUsuario");
				String login = result.getString("login");
				String senha = result.getString("senha");
				
				list.add(new Usuario(idUsuario, login, senha));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Erro durante a consulta!!\n"+sqle.getMessage());
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return list;
		
		
	}
	
	public ArrayList<Usuario> listar(){
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;	
		ArrayList<Usuario> list = new ArrayList<Usuario>();
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM usuario");
			result = ps.executeQuery();
			while( result.next() )
			{
				int idUsuario = result.getInt("idUsuario");
				String login = result.getString("login");
				String senha = result.getString("senha");
				
				list.add(new Usuario(idUsuario, login, senha));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object buscar(String login, String senha){
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Usuario usuario=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM usuario WHERE login=? AND senha=?");
			ps.setString(1, login);
			ps.setString(2, senha);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int idUsuario = result.getInt("idUsuario");
					String loginUser = result.getString("login");
					String senhaUser = result.getString("senha");
					
					usuario = new Usuario(idUsuario, loginUser, senhaUser);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Usuário n"+(char)227+"o encontrado.\nLogin ou Senha inválidos.");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return usuario;
		
	}

	@Override
	public Object buscar(int chaveFunc, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
