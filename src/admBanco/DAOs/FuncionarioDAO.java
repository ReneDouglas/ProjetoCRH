package admBanco.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import basico.Funcionario;
import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class FuncionarioDAO implements InterfaceBanco{

	
	public String inserir(Object objct) {

		Funcionario funcionario = (Funcionario)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO funcionario (idFunc, nome, nomePai," +
					"nomeMae, dataNasc, sexo, estCivil, pasep, matricula, cpf, grauDeInst) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, funcionario.getIdFunc());
			ps.setString(2, funcionario.getNome());
			ps.setString(3, funcionario.getNomePai());
			ps.setString(4, funcionario.getNomeMae());
			ps.setDate(5, funcionario.getDataNasc());
			ps.setString(6, funcionario.getSexo());
			ps.setString(7, funcionario.getEstCivil());
			ps.setString(8, funcionario.getPasep());
			ps.setString(9, funcionario.getMatricula());
			ps.setString(10, funcionario.getCpf());
			ps.setString(11, funcionario.getGrauDeInst());

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
			ps = conn.prepareStatement("DELETE FROM funcionario WHERE idFunc = ?");
			ps.setInt(1, id);
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0)
				retorno="Erro!!\nN"+(char)227+"o foi poss"+(char)237+"vel encontrar o funcionário: "+nome;
			
			else if (statusExclusao==1)
				retorno="Dado excluido com sucesso. Exclus"+(char)227+"o do funcionário: "+nome;
				
				
		} catch (SQLException sqle) {
			retorno="Erro durante a exclus"+(char)227+"o\n"+sqle.getMessage();

		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
		return retorno;
	}

	@Override
	public String alterar(Object objct) {
		
		Funcionario funcionario = (Funcionario)objct;
		
		String retorno = "";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE funcionario SET nome=?, nomePai=?," +
					"nomeMae=?, dataNasc=?, sexo=?, estCivil=?, pasep=?, matricula=?, cpf=?, grauDeInst=? WHERE idFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getNomePai());
			ps.setString(3, funcionario.getNomeMae());
			ps.setDate(4, funcionario.getDataNasc());
			ps.setString(5, funcionario.getSexo());
			ps.setString(6, funcionario.getEstCivil());
			ps.setString(7, funcionario.getPasep());
			ps.setString(8, funcionario.getMatricula());
			ps.setString(9, funcionario.getCpf());
			ps.setString(10, funcionario.getGrauDeInst());
			ps.setInt(11, funcionario.getIdFunc());
			
			int statusExclusao=ps.executeUpdate();
			
			if (statusExclusao==0){
				retorno = "N"+(char)227+"o foi poss"+(char)237+"vel encontrar o funcionario: "+funcionario.getNome();
				
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
			ps = conn.prepareStatement("SELECT * FROM funcionario ORDER BY "+organizarPor);
			result = ps.executeQuery();
			while( result.next() )
			{
				int idFunc = result.getInt("idFunc");
				String nome = result.getString("nome");
				String nomePai = result.getString("nomePai");
				String nomeMae = result.getString("nomeMae");
				Date dataNasc = result.getDate("dataNasc");
				String sexo = result.getString("sexo");
				String estCivil = result.getString("estCivil");
				String pasep = result.getString("pasep");
				String matricula = result.getString("matricula");
				String cpf = result.getString("cpf");
				String grauDeInst = result.getString("grauDeInst");
				
				list.add(new Funcionario(idFunc,  nome, nomePai, nomeMae, dataNasc, sexo, estCivil, pasep, matricula, cpf, grauDeInst));
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
			ps = conn.prepareStatement("SELECT MAX(idFunc) FROM Funcionario");
			result = ps.executeQuery();
			
			while(result.next()){
				idFunc = result.getInt("MAX(idFunc)");
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
		Funcionario funcionario=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM funcionario WHERE idFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
					int idFunc = result.getInt("idFunc");
					String nome = result.getString("nome");
					String nomePai = result.getString("nomePai");
					String nomeMae = result.getString("nomeMae");
					Date dataNasc = result.getDate("dataNasc");
					String sexo = result.getString("sexo");
					String estCivil = result.getString("estCivil");
					String pasep = result.getString("pasep");
					String matricula = result.getString("matricula");
					String cpf = result.getString("cpf");
					String grauDeInst = result.getString("grauDeInst");
					
					funcionario = new Funcionario(idFunc, nome, nomePai, nomeMae, dataNasc, sexo, estCivil, pasep, matricula, cpf, grauDeInst);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Funcionário n"+(char)227+"o encontrado");
				
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a busca!!");
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return funcionario;
		
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
