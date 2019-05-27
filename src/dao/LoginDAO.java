/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.LoggerUtil;
import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gusteinhoefel
 */
public class LoginDAO implements IDAO_T<Login> {

    private ResultSet resultadoQ;

    @Override
    public String salvar(Login c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO login VALUES "
                    + "(DEFAULT, "
                    + "'" + c.getNome() + "',"
                    + "'" + c.getLogin() + "',"
                    + "'" + c.getPassword() + "',"
                    + "'" + c.getStatus() + "',"
                    + "'" + c.getDel() + "'"
                    + ")";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                return null;
            }

        } catch (SQLException e) {
            LoggerUtil.log(LoginDAO.class, e.getMessage());
            return e.toString();
        }

    }

    @Override
    public String atualizar(Login c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE login "
                    + "SET nome = '" + c.getNome() + "', "
                    + "login = '" + c.getLogin() + "',"
                    + "password = '" + c.getPassword() + "',"
                    + "status = '" + c.getStatus() + "' "
                    + "WHERE id = '" + c.getId() + "'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao alterar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            LoggerUtil.log(LoginDAO.class, e.getMessage());
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM login WHERE id='"+id+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao deletar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            LoggerUtil.log(LoginDAO.class, e.getMessage());
            return e.toString();
        }
    }

    @Override
    public ArrayList<Login> consultarTodos() {
        ArrayList<Login> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM login "
                    + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Login login = new Login();

                login.setId(resultadoQ.getInt("id"));
                login.setNome(resultadoQ.getString("nome"));
                login.setLogin(resultadoQ.getString("login"));
                login.setPassword(resultadoQ.getString("password"));
                login.setStatus(Integer.parseInt(resultadoQ.getString("status")));
                login.setDel(Integer.parseInt(resultadoQ.getString("del")));

                cid.add(login);

            }

        } catch (SQLException e) {
            LoggerUtil.log(LoginDAO.class, e.getMessage());
        }

        return cid;
    }

    @Override
    public ArrayList<Login> consultar(String criterio) {
        ArrayList<Login> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM login "
                    + "WHERE nome ILIKE '%" + criterio + "%'"
                    + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Login login = new Login();

                login.setId(resultadoQ.getInt("id"));
                login.setNome(resultadoQ.getString("nome"));
                login.setLogin(resultadoQ.getString("login"));
                login.setPassword(resultadoQ.getString("password"));
                login.setStatus(Integer.parseInt(resultadoQ.getString("status")));
                login.setDel(Integer.parseInt(resultadoQ.getString("del")));

                cid.add(login);

            }

        } catch (SQLException e) {
            LoggerUtil.log(LoginDAO.class, e.getMessage());
        }

        return cid;
    }

    @Override
    public Login consultarId(int id) {
        Login login = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM login "
                    + "WHERE id = '" + id + "'";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                login = new Login();

                login.setId(resultadoQ.getInt("id"));
                login.setNome(resultadoQ.getString("nome"));
                login.setLogin(resultadoQ.getString("login"));
                login.setPassword(resultadoQ.getString("password"));
                login.setStatus(Integer.parseInt(resultadoQ.getString("status")));
                login.setDel(Integer.parseInt(resultadoQ.getString("del")));

            }

        } catch (SQLException e) {
            LoggerUtil.log(LoginDAO.class, e.getMessage());
        }

        return login;
    }

    public boolean consultarUsuario(String nome) {
        boolean check = false;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM login "
                    + "WHERE login = '" + nome + "'";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                check = true;
            }

        } catch (SQLException e) {
            LoggerUtil.log(LoginDAO.class, e.getMessage());
        }

        return check;
    }

    public ArrayList<Login> validarUsuario(String nome, String senha) {
        ArrayList<Login> cid = new ArrayList<>();
        Login login = null;
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql =  "SELECT * "
                        + "FROM login "
                        + "WHERE login = '" + nome + "' AND "
                        + "password   = '"+ senha +"' AND "
                        + "status <> '1' AND "
                        + "del <> '1'";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                login = new Login();

                login.setId(resultadoQ.getInt(1));
                login.setLogin(resultadoQ.getString(2));
                login.setNome(resultadoQ.getString(3));                
                login.setPassword(resultadoQ.getString(4));
                login.setStatus(Integer.parseInt(resultadoQ.getString(5)));
                login.setDel(Integer.parseInt(resultadoQ.getString(6)));
                
                cid.add(login);
            }

        } catch (SQLException e) {
            LoggerUtil.log(LoginDAO.class, e.getMessage());
        }

        return cid;
    }

}
