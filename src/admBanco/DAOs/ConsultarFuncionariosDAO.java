package admBanco.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import basico.ConsultaFuncionario;


import admBanco.AdmBancoSql;
import admBanco.InterfaceBanco;

public class ConsultarFuncionariosDAO implements InterfaceBanco{

        @Override
        public String inserir(Object objct) {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public String excluir(int id, String nome) {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public String excluir() {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public String alterar(Object objct) {
                // TODO Auto-generated method stub
                return null;
        }

        public ArrayList<Object> listar_1(String organizarPor) {
                PreparedStatement ps = null;
                Connection conn = null;
                ResultSet result = null;
                
                ArrayList<Object> list = new ArrayList<Object>();
                try {
                        conn = AdmBancoSql.getConnection();
                        
                        ps = conn.prepareStatement("SELECT F.idFunc, F.nome, F.cpf, H.cargo "+
                                                                                "FROM funcionario AS F "+
                                                                                "INNER JOIN historico AS H ON H.chaveFunc = F.idFunc "+
                                                                                "GROUP BY F.idFunc "+
                                                                                "HAVING MAX(H.dataNomeacao) "+
                                                                                "ORDER BY "+retornoColumn_1(organizarPor));
                        
                        result = ps.executeQuery();
                        while( result.next() )
                        {
                                int idFunc = result.getInt("F.idFunc");
                                String nome = result.getString("F.nome");
                                String cpf = result.getString("F.cpf");
                                String cargo = result.getString("H.cargo");
                                
                                list.add(new ConsultaFuncionario(idFunc, nome, cpf, cargo));
                        }
                } catch (SQLException sqle) {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a consulta!!");
                } finally {
                        AdmBancoSql.closeConnection(conn, ps, result);
                }
                return list;
                
        }
        
        public ArrayList<Object> listar_2(String organizarPor) {
                PreparedStatement ps = null;
                Connection conn = null;
                ResultSet result = null;
                
                ArrayList<Object> list = new ArrayList<Object>();
                try {
                        conn = AdmBancoSql.getConnection();
                        
                        ps = conn.prepareStatement("SELECT idFunc, nome, dataNasc, cpf "+
                                                                                "FROM funcionario "+
                                                                                "ORDER BY "+retornoColumn_2(organizarPor));
                        
                        result = ps.executeQuery();
                        while( result.next() )
                        {
                                int idFunc = result.getInt("idFunc");
                                String nome = result.getString("nome");
                                Date dataNasc = result.getDate("dataNasc");
                                String cpf = result.getString("cpf");
                                
                                list.add(new ConsultaFuncionario(idFunc, nome, dataNasc, cpf));
                        }
                } catch (SQLException sqle) {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a consulta!!");
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

        public ArrayList<Object> listar_1(String pesquisarColuna,
                        String organizarPor, String textoPesquisa) {
                
                PreparedStatement ps = null;
                Connection conn = null;
                ResultSet result = null;
                
                ArrayList<Object> list = new ArrayList<Object>();
                
                
                
                try {
                        conn = AdmBancoSql.getConnection();
                        
                        ps = conn.prepareStatement("SELECT F.idFunc, F.nome, F.cpf, H.cargo "+
                                        "FROM funcionario AS F "+
                                        "INNER JOIN historico AS H ON H.chaveFunc = F.idFunc "+
                                        "WHERE "+retornoColumn_1(pesquisarColuna)+
                                        " LIKE '%"+textoPesquisa+"%' "+
                                        "GROUP BY F.idFunc "+
                                        "HAVING MAX(H.dataNomeacao) "+
                                        "ORDER BY "+retornoColumn_1(organizarPor));
                        
                        result = ps.executeQuery();
                        while( result.next() )
                        {
                                int idFunc = result.getInt("F.idFunc");
                                String nome = result.getString("F.nome");
                                String cpf = result.getString("F.cpf");
                                String cargo = result.getString("H.cargo");
                                
                                list.add(new ConsultaFuncionario(idFunc, nome, cpf, cargo));
                        }
                } catch (SQLException sqle) {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a consulta!!");
                } finally {
                        AdmBancoSql.closeConnection(conn, ps, result);
                }
                return list;
                
                
        }
        
        public ArrayList<Object> listar_2(String pesquisarColuna,
                        String organizarPor, String textoPesquisa) {
                
                PreparedStatement ps = null;
                Connection conn = null;
                ResultSet result = null;
                
                ArrayList<Object> list = new ArrayList<Object>();
                
                
                try {
                        conn = AdmBancoSql.getConnection();
                        
                        ps = conn.prepareStatement("SELECT idFunc, nome, dataNasc, cpf "+
                                        "FROM funcionario "+
                                        "WHERE "+retornoColumn_2(pesquisarColuna)+
                                        " LIKE '%"+textoPesquisa+"%' "+
                                        "ORDER BY "+retornoColumn_2(organizarPor));

                        result = ps.executeQuery();
                        while( result.next() )
                        {
                                        int idFunc = result.getInt("idFunc");
                                        String nome = result.getString("nome");
                                        Date dataNasc = result.getDate("dataNasc");
                                        String cpf = result.getString("cpf");
                                        
                                        list.add(new ConsultaFuncionario(idFunc, nome, dataNasc, cpf));
                        }
                } catch (SQLException sqle) {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a consulta!!");
                } finally {
                        AdmBancoSql.closeConnection(conn, ps, result);
                }
                return list;
                
                
        }
        
        private String retornoColumn_1(String column){
                
                String coluna = column;
                
                if(column.equalsIgnoreCase("ID")){
                        return coluna = "F.idFunc";
                }
                else if(column.equalsIgnoreCase("Nome")){
                        return coluna = "F.nome";
                }
                else if(column.equalsIgnoreCase("CPF")){
                        return coluna = "F.cpf";
                }
                else if(column.equalsIgnoreCase("Cargo")){
                        return coluna = "H.cargo";
                }
                
                return coluna;
        }
        
        private String retornoColumn_2(String column){
                
                String coluna = column;
                
                if(column.equalsIgnoreCase("ID")){
                        return coluna = "idFunc";
                }
                else if(column.equalsIgnoreCase("Nome")){
                        return coluna = "nome";
                }
                else if(column.equalsIgnoreCase("Data de Nasc.")){
                        return coluna = "dataNasc";
                }
                else if(column.equalsIgnoreCase("CPF")){
                        return coluna = "cpf";
                }
                
                return coluna;
        }

        @Override
        public Object buscar(int chaveFunc, String nome) {
                // TODO Auto-generated method stub
                return null;
        }

        
}