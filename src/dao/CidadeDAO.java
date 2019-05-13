/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Cidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gusteinhoefel
 */
public class CidadeDAO implements IDAO_T<Cidade>{

    private ResultSet resultadoQ;

    @Override
    public String salvar(Cidade c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO cidade VALUES "
                    + "(DEFAULT, "
                    + "'" + c.getNome() + "',"
                    + "'" + c.getUf() + "'"
                    + ")";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro salvar cidade = " + e);
            return e.toString();
        }
        
    }

    @Override
    public String atualizar(Cidade c) {
       try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cidade "
                       + "SET nome = '"+c.getNome()+"', "
                       + "uf='"+c.getUf()+"' "
                       + "WHERE id = '"+c.getId()+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao alterar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro alterar cidade = " + e);
            return e.toString();
        } 
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM cidade WHERE id='"+id+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao deletar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar cidade = " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Cidade> consultarTodos() {
        ArrayList<Cidade> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM cidade "
                       + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Cidade cidade = new Cidade();
                
                cidade.setId(resultadoQ.getInt("id"));
                cidade.setNome(resultadoQ.getString("nome"));
                cidade.setUf(resultadoQ.getString("uf"));
                cid.add(cidade);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar cidade = " + e);
        }

        return cid;
    }

    @Override
    public ArrayList<Cidade> consultar(String criterio) {
        ArrayList<Cidade> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM cidade "
                       + "WHERE nome ILIKE '%"+criterio+"%'"
                       + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Cidade cidade = new Cidade();
                
                cidade.setId(resultadoQ.getInt("id"));
                cidade.setNome(resultadoQ.getString("nome"));
                cidade.setUf(resultadoQ.getString("uf"));
                cid.add(cidade);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar cidade = " + e);
        }

        return cid;
    }

    @Override
    public Cidade consultarId(int id) {
        Cidade cidade = new Cidade();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM cidade "
                       + "WHERE id = '"+id+"'";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);
            
            
            while (resultadoQ.next()) {

                cidade.setId(resultadoQ.getInt("id"));
                cidade.setNome(resultadoQ.getString("nome"));
                cidade.setUf(resultadoQ.getString("uf"));
                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar cidade = " + e);
        }
        return cidade;
    }
    
    public ArrayList<Cidade> consultarCidade(String criterio) {
        ArrayList<Cidade> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM cidade "
                       + "WHERE nome ILIKE '"+criterio+"'"
                       + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Cidade cidade = new Cidade();
                
                cidade.setId(resultadoQ.getInt("id"));
                cidade.setNome(resultadoQ.getString("nome"));
                cidade.setUf(resultadoQ.getString("uf"));
                cid.add(cidade);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar cidade = " + e);
        }

        return cid;
    }
}
