/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Leitor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gusteinhoefel
 */
public class LeitorDAO implements IDAO_T<Leitor>{

    private ResultSet resultadoQ;

    @Override
    public String salvar(Leitor o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String atualizar(Leitor o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Leitor> consultarTodos() {
        ArrayList<Leitor> lei = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT id,nome,endereco,cidade_id,tipo,"
                       + "dt_nascimento,matricula,turma,turno,limite_livros,status,del "
                       + "FROM leitor "
                       + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Leitor leitor = new Leitor();
                
                leitor.setId(resultadoQ.getInt("id"));
                leitor.setNome(resultadoQ.getString("nome"));
                leitor.setEndereco(resultadoQ.getString("endereco"));
                leitor.setCidade(new CidadeDAO().consultarId(resultadoQ.getInt("cidade_id")));
                leitor.setTipo(resultadoQ.getInt("tipo"));
                leitor.setDt_nscimento(resultadoQ.getDate("dt_nascimento"));
                leitor.setMatricula(resultadoQ.getString("matricula"));
                leitor.setTurma(resultadoQ.getString("turma"));
                leitor.setTurno(resultadoQ.getString("turno"));
                leitor.setLimite_livros(resultadoQ.getInt("limite_livros"));
                leitor.setStatus(resultadoQ.getInt("status"));
                leitor.setDel(resultadoQ.getInt("del"));
                lei.add(leitor);
                
            }

        } catch (SQLException e) {
            System.out.println("Erro consultar leitor = " + e);
        }

        return lei;
    }

    @Override
    public ArrayList<Leitor> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Leitor consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
