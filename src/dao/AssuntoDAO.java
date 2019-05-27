/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Assunto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gusteinhoefel
 */
public class AssuntoDAO implements IDAO_T<Assunto>{

    private ResultSet resultadoQ;

    @Override
    public String salvar(Assunto c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO assunto VALUES "
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
            System.out.println("Erro salvar assunto = " + e);
            return e.toString();
        }
        
    }

    @Override
    public String atualizar(Assunto c) {
       try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE assunto "
                       + "SET descricao = '"+c.getDescricao()+"'"
                       + "WHERE id = '"+c.getId()+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao alterar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro alterar assunto = " + e);
            return e.toString();
        } 
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM assunto WHERE id='"+id+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao deletar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar assunto = " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Assunto> consultarTodos() {
        ArrayList<Assunto> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM assunto "
                       + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Assunto assunto = new Assunto();
                
                assunto.setId(resultadoQ.getInt("id"));
                assunto.setDescricao(resultadoQ.getString("descricao"));
                
                cid.add(assunto);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar assunto = " + e);
        }

        return cid;
    }

    @Override
    public ArrayList<Assunto> consultar(String criterio) {
        ArrayList<Assunto> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM assunto "
                       + "WHERE descricao ILIKE '%"+criterio+"%'"
                       + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Assunto assunto = new Assunto();
                
                assunto.setId(resultadoQ.getInt("id"));
                assunto.setDescricao(resultadoQ.getString("descricao"));
                
                cid.add(assunto);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar assunto = " + e);
        }

        return cid;
    }

    @Override
    public Assunto consultarId(int id) {
         Assunto assunto = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM assunto "
                       + "WHERE id = '"+id+"'"
                       + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                assunto = new Assunto();
                assunto.setId(resultadoQ.getInt("id"));
                assunto.setDescricao(resultadoQ.getString("descricao"));
                                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar assunto = " + e);
        }

        return assunto;
    }
    
    public ArrayList<Assunto> consultarAssunto(String criterio) {
         ArrayList<Assunto> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM assunto "
                       + "WHERE descricao ILIKE '"+criterio+"'"
                       + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Assunto assunto = new Assunto();
                
                assunto.setId(resultadoQ.getInt("id"));
                assunto.setDescricao(resultadoQ.getString("descricao"));
                
                cid.add(assunto);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar assunto = " + e);
        }

        return cid;
    }
    
}
