/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Editora;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gusteinhoefel
 */
public class EditoraDAO implements IDAO_T<Editora> {

    private ResultSet resultadoQ;

    @Override
    public String salvar(Editora c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO editora VALUES "
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
            System.out.println("Erro salvar editora = " + e);
            return e.toString();
        }

    }

    @Override
    public String atualizar(Editora c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE editora "
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
            System.out.println("Erro alterar editora = " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM editora WHERE id='" + id + "'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao deletar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar editora = " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Editora> consultarTodos() {
        ArrayList<Editora> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM editora "
                    + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Editora cidade = new Editora();

                cidade.setId(resultadoQ.getInt("id"));
                cidade.setDescricao(resultadoQ.getString("descricao"));

                cid.add(cidade);

            }

        } catch (SQLException e) {
            System.out.println("Erro consultar editora = " + e);
        }

        return cid;
    }

    @Override
    public ArrayList<Editora> consultar(String criterio) {
        ArrayList<Editora> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM editora "
                    + "WHERE descricao ILIKE '%" + criterio + "%'"
                    + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Editora cidade = new Editora();

                cidade.setId(resultadoQ.getInt("id"));
                cidade.setDescricao(resultadoQ.getString("descricao"));

                cid.add(cidade);

            }

        } catch (SQLException e) {
            System.out.println("Erro consultar editora = " + e);
        }

        return cid;
    }

    @Override
    public Editora consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList consultarEditora(String criterio) {
        ArrayList<Editora> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM editora "
                    + "WHERE descricao ILIKE '" + criterio + "'"
                    + "ORDER BY descricao ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Editora cidade = new Editora();

                cidade.setId(resultadoQ.getInt("id"));
                cidade.setDescricao(resultadoQ.getString("descricao"));

                cid.add(cidade);

            }

        } catch (SQLException e) {
            System.out.println("Erro consultar editora = " + e);
        }

        return cid;
    }

}
