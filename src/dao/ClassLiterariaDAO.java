/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.ClassLiteraria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gusteinhoefel
 */
public class ClassLiterariaDAO implements IDAO_T<ClassLiteraria> {

    private ResultSet resultadoQ;

    @Override
    public String salvar(ClassLiteraria c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO class_literaria VALUES "
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
            System.out.println("Erro salvar Classificação Literária = " + e);
            return e.toString();
        }

    }

    @Override
    public String atualizar(ClassLiteraria c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE class_literaria "
                    + "SET descricao = '" + c.getDescricao() + "'"
                    + "WHERE id = '" + c.getId() + "'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao alterar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro alterar Classificação Literária = " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM class_literaria WHERE id='" + id + "'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao deletar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar Classificação Literária = " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<ClassLiteraria> consultarTodos() {
        ArrayList<ClassLiteraria> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM class_literaria "
                    + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                ClassLiteraria cidade = new ClassLiteraria();

                cidade.setId(resultadoQ.getInt("id"));
                cidade.setDescricao(resultadoQ.getString("descricao"));

                cid.add(cidade);

            }

        } catch (SQLException e) {
            System.out.println("Erro consultar Classificação Literária = " + e);
        }

        return cid;
    }

    @Override
    public ArrayList<ClassLiteraria> consultar(String criterio) {
        ArrayList<ClassLiteraria> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM class_literaria "
                    + "WHERE descricao ILIKE '%" + criterio + "%'"
                    + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                ClassLiteraria cidade = new ClassLiteraria();

                cidade.setId(resultadoQ.getInt("id"));
                cidade.setDescricao(resultadoQ.getString("descricao"));

                cid.add(cidade);

            }

        } catch (SQLException e) {
            System.out.println("Erro consultar Classificação Literária = " + e);
        }

        return cid;
    }

    @Override
    public ClassLiteraria consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList consultarClassLiteraria(String criterio) {
        ArrayList<ClassLiteraria> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM class_literaria "
                    + "WHERE descricao ILIKE '" + criterio + "'"
                    + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                ClassLiteraria cidade = new ClassLiteraria();

                cidade.setId(resultadoQ.getInt("id"));
                cidade.setDescricao(resultadoQ.getString("descricao"));

                cid.add(cidade);

            }

        } catch (SQLException e) {
            System.out.println("Erro consultar Classificação Literária = " + e);
        }

        return cid;
    }

}
