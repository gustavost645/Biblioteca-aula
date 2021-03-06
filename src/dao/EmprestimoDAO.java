/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Emprestimo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.LoggerUtil;

/**
 * @brief Classe EmprestimoDAO
 * @author Gustavo.Steinhoefel
 * @date 20/05/2019
 */
public class EmprestimoDAO implements IDAO_T<Emprestimo> {

    private ResultSet resultadoQ;

    @Override
    public String salvar(Emprestimo e) {
        try {

            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st2 = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO "
                    + "emprestimo(id_livro, dataemprestimo, datavencimento, id_leitor)"
                    + "VALUES ('" + e.getId_livro() + "', '" + e.getDataemprestimo() + "',"
                    + " '" + e.getDatavencimento() + "' , '" + e.getId_leitor() + "');";

           

            System.out.println(sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {

                return "Erro ao inserir";

            } else {
                String sql2 = "UPDATE livro SET status='1' WHERE id='" + e.getId_livro() + "'";
                
                System.out.println(sql2);
                
                int resultado2 = st2.executeUpdate(sql2);

                if (resultado2 != 0) {
                    return null;
                } else {
                    return "Erro ao inserir";
                }

            }

        } catch (SQLException ex) {
            LoggerUtil.log(EmprestimoDAO.class, ex.getMessage());
            return ex.toString();
        }
    }

    @Override
    public String atualizar(Emprestimo e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Emprestimo> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Emprestimo> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Emprestimo consultarId(int id){
        Emprestimo emprestimo = null;
        try {
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "SELECT * FROM emprestimo where (id_livro='"+id+"' AND datachegada isnull)";
            
            System.out.println("Sql: " + sql);
            
            resultadoQ = st.executeQuery(sql);
            
            while (resultadoQ.next()) {
                
                emprestimo = new Emprestimo();
                
                emprestimo.setId(resultadoQ.getInt("id"));
                emprestimo.setLeitor(new LeitorDAO().consultarId(resultadoQ.getInt("id_leitor")));
                emprestimo.setLivro(new LivroDAO().consultaPersonalizada2(0,String.valueOf(resultadoQ.getInt("id_livro"))));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
            LoggerUtil.log(EmprestimoDAO.class, ex.getMessage());
        }
        return emprestimo;
    }

    public ArrayList<Emprestimo> listarPendencias(int id) throws Exception {

        Statement st = ConexaoBD.getInstance().getConnection().createStatement();

        ArrayList<Emprestimo> emprestimo = new ArrayList<>();

        String sql = "SELECT * FROM emprestimo "
                + "WHERE ( CURRENT_DATE > datavencimento AND datachegada isnull) AND id_leitor='" + id + "'";

        System.out.println("Sql: " + sql);

        resultadoQ = st.executeQuery(sql);

        while (resultadoQ.next()) {

            Emprestimo m = new Emprestimo();

            m.setId(resultadoQ.getInt("id"));
            

            emprestimo.add(m);
        }

        return emprestimo;
    }

    public String devolver(Emprestimo e) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st1 = ConexaoBD.getInstance().getConnection().createStatement();

            String SQL = "UPDATE emprestimo SET datachegada = '" + e.getDatachegada() + "' \n"
                       + "WHERE id=(SELECT id FROM emprestimo WHERE datachegada ISNULL AND id_livro='" + e.getId_livro() + "')";

            System.out.println(SQL);
            
            int resultado = st.executeUpdate(SQL);

            if (resultado == 0) {

                return "Erro ao inserir";

            } else {

                String SQL2 = "UPDATE livro SET status='0' WHERE id='" + e.getId_livro() + "'";
                
                System.out.println(SQL2);
                
                int resultado2 = st1.executeUpdate(SQL2);

                if (resultado2 != 0) {
                    return null;
                } else {
                    return "Erro ao inserir";
                }
            }

        } catch (SQLException ex) {
            LoggerUtil.log(EmprestimoDAO.class, ex.getMessage());
            return ex.toString();
        }
    }

    public String atualizarVencimento(Emprestimo emprestimo) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            

            String SQL = "UPDATE emprestimo SET datavencimento='"+emprestimo.getDatavencimento()+"',num_renova='1' "
                       + "WHERE id_livro='"+emprestimo.getId_livro()+"' and id_leitor='"+emprestimo.getId_leitor()+"'";

            System.out.println(SQL);
            
            int resultado = st.executeUpdate(SQL);

            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                return null;
            }

        } catch (SQLException ex) {
            LoggerUtil.log(EmprestimoDAO.class, ex.getMessage());
            return ex.toString();
        }
    }

    public boolean consultarRenovacao(int idLivro, int idLeitor) throws SQLException {
        boolean ok = false;
        Statement st = ConexaoBD.getInstance().getConnection().createStatement();

        String sql = "SELECT * FROM emprestimo \n" +
                     "WHERE id_leitor ='"+idLeitor+"' AND id_livro='"+idLivro+"' \n" +
                     "AND num_renova <> 1 AND datachegada isnull;";

        System.out.println("Sql: " + sql);

        resultadoQ = st.executeQuery(sql);

        while (resultadoQ.next()) {

            ok = true;
        }

        return ok;
    }

}
