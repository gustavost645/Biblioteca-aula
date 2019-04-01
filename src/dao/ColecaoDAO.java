/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Colecao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gusteinhoefel
 */
public class ColecaoDAO implements IDAO_T<Colecao>{

    private ResultSet resultadoQ;

    @Override
    public String salvar(Colecao c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO colecao VALUES "
                    + "(DEFAULT, "
                    + "'" + c.getDescricao() + "'"
                    + ")";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro salvar colecao = " + e);
            return e.toString();
        }
        
    }

    @Override
    public String atualizar(Colecao c) {
       try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE colecao "
                       + "SET descricao = '"+c.getDescricao()+"' "
                       + "WHERE id = '"+c.getId()+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao alterar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro alterar colecao = " + e);
            return e.toString();
        } 
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM colecao WHERE id='"+id+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao deletar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar colecao = " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Colecao> consultarTodos() {
        ArrayList<Colecao> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM colecao "
                       + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Colecao cidade = new Colecao();
                
                cidade.setId(resultadoQ.getInt("id"));
                cidade.setDescricao(resultadoQ.getString("descricao"));
                
                cid.add(cidade);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar colecao = " + e);
        }

        return cid;
    }

    @Override
    public ArrayList<Colecao> consultar(String criterio) {
        ArrayList<Colecao> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM colecao "
                       + "WHERE descricao ILIKE '%"+criterio+"%'"
                       + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Colecao cidade = new Colecao();
                
                cidade.setId(resultadoQ.getInt("id"));
                cidade.setDescricao(resultadoQ.getString("descricao"));
                
                cid.add(cidade);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar colecao = " + e);
        }

        return cid;
    }

    @Override
    public Colecao consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
