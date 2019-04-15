/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Autor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gusteinhoefel
 */
public class AutorDAO implements IDAO_T<Autor>{

    private ResultSet resultadoQ;

    @Override
    public String salvar(Autor c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO autor VALUES "
                    + "(DEFAULT, "
                    + "'" + c.getNome() + "'"
                    + ")";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao salvar autor = " + e);
            return e.toString();
        }
        
    }

    @Override
    public String atualizar(Autor c) {
       try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE autor "
                       + "SET nome = '"+c.getNome()+"'"
                       + "WHERE id = '"+c.getId()+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao alterar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao alterar autor = " + e);
            return e.toString();
        } 
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM autor WHERE id='"+id+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao deletar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar autor = " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Autor> consultarTodos() {
        ArrayList<Autor> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM autor "
                       + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Autor autor = new Autor();
                
                autor.setId(resultadoQ.getInt("id"));
                autor.setNome(resultadoQ.getString("nome"));
                
                cid.add(autor);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar autor = " + e);
        }

        return cid;
    }

    @Override
    public ArrayList<Autor> consultar(String criterio) {
        ArrayList<Autor> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM autor "
                       + "WHERE nome ILIKE '%"+criterio+"%'"
                       + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Autor autor = new Autor();
                
                autor.setId(resultadoQ.getInt("id"));
                autor.setNome(resultadoQ.getString("nome"));
                
                cid.add(autor);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar autor = " + e);
        }

        return cid;
    }

    @Override
    public Autor consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ArrayList<Autor> consultarAutor(String criterio) {
        ArrayList<Autor> cid = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM autor "
                       + "WHERE nome ILIKE '"+criterio+"'"
                       + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Autor autor = new Autor();
                
                autor.setId(resultadoQ.getInt("id"));
                autor.setNome(resultadoQ.getString("nome"));
                
                cid.add(autor);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar autor = " + e);
        }

        return cid;
    }
    
    
}
