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
import java.util.Date;
import util.LoggerUtil;

/**
 *
 * @author gusteinhoefel
 */
public class LeitorDAO implements IDAO_T<Leitor>{

    private ResultSet resultadoQ;

    @Override
    public String salvar(Leitor l) {
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO leitor (nome, endereco, cidade_id, tipo, dt_nascimento,matricula,turma, turno, limite_livros, status,del,num_cgc,email,data_registro) "
                    + "VALUES( '"+l.getNome()+"','"+l.getEndereco()+"',"
                    + "'"+l.getCidade().getId()+"', '"+l.getTipo()+"', "
                    + "'"+l.getDt_nscimento()+"','"+l.getMatricula()+"',"
                    + "'"+l.getTurma()+"','"+l.getTurno()+"',"
                    + "'"+l.getLimite_livros()+"','"+l.getStatus()+"', "
                    + "'"+l.getDel()+"','"+l.getNum_cgc()+"','"+l.getEmail()+"',"
                    + "'"+new Date()+"')";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                return null;
            }

        } catch (SQLException e) {
            LoggerUtil.log(LeitorDAO.class, e.getMessage());
            System.out.println("Erro ao inserir leitor = " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Leitor l) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update leitor set nome='"+l.getNome()+"', "
                    + " endereco='"+l.getEndereco()+"', "
                    + " cidade_id = '"+l.getCidade().getId().toString()+"', "
                    + " tipo='"+l.getTipo()+"',"
                    + " dt_nascimento='"+l.getDt_nscimento()+"',"
                    + " matricula='"+l.getMatricula()+"',"
                    + " turma='"+l.getTurma()+"',"
                    + " turno='"+l.getTurno()+"', "
                    + " limite_livros='"+l.getLimite_livros()+"', "
                    + " status='"+l.getStatus()+"',"
                    + " num_cgc='"+l.getNum_cgc()+"',"
                    + " email='"+l.getEmail()+"'"
                    + "WHERE id = '"+l.getId()+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao alterar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            LoggerUtil.log(LeitorDAO.class, e.getMessage());
            System.out.println("Erro ao alterar leitor = " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE leitor SET del='1' WHERE id='"+id+"'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao deletar";
            } else {
                return null;
            }

        } catch (SQLException e) {
            LoggerUtil.log(LeitorDAO.class, e.getMessage());
            System.out.println("Erro deletar leitor = " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Leitor> consultarTodos() {
        ArrayList<Leitor> lei = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT id,nome,endereco,cidade_id,tipo,"
                       + "dt_nascimento,matricula,turma,turno,limite_livros,status,del,num_cgc,email "
                       + "FROM leitor "
                       + "WHERE del<>'1'"
                       + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Leitor l = new Leitor();
                
                l.setId(resultadoQ.getInt("id"));
                l.setNome(resultadoQ.getString("nome"));
                l.setEndereco(resultadoQ.getString("endereco"));
                l.setCidade(new CidadeDAO().consultarId(resultadoQ.getInt("cidade_id")));
                l.setTipo(resultadoQ.getInt("tipo"));
                l.setDt_nscimento(resultadoQ.getDate("dt_nascimento"));
                l.setMatricula(resultadoQ.getString("matricula"));
                l.setTurma(resultadoQ.getString("turma"));
                l.setTurno(resultadoQ.getString("turno"));
                l.setLimite_livros(resultadoQ.getInt("limite_livros"));
                l.setStatus(resultadoQ.getInt("status"));
                l.setDel(resultadoQ.getInt("del"));
                l.setNum_cgc(resultadoQ.getString("num_cgc"));
                l.setEmail(resultadoQ.getString("email"));
                lei.add(l);
                
                //printa resultados 
                //System.out.print(l.toString());
            }

        } catch (SQLException e) {
            LoggerUtil.log(LeitorDAO.class, e.getMessage());
            System.out.println("Erro consultar leitor = " + e);
        }

        return lei;
    }

    @Override
    public ArrayList<Leitor> consultar(String criterio) {
        ArrayList<Leitor> lei = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT id,nome,endereco,cidade_id,tipo,"
                       + "dt_nascimento,matricula,turma,turno,limite_livros,status,del "
                       + "FROM leitor "
                       + "WHERE nome ILIKE '%"+criterio+"%'"
                       + "AND del<>'1'"
                       + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                Leitor l = new Leitor();
                
                l.setId(resultadoQ.getInt("id"));
                l.setNome(resultadoQ.getString("nome"));
                l.setEndereco(resultadoQ.getString("endereco"));
                l.setCidade(new CidadeDAO().consultarId(resultadoQ.getInt("cidade_id")));
                l.setTipo(resultadoQ.getInt("tipo"));
                l.setDt_nscimento(resultadoQ.getDate("dt_nascimento"));
                l.setMatricula(resultadoQ.getString("matricula"));
                l.setTurma(resultadoQ.getString("turma"));
                l.setTurno(resultadoQ.getString("turno"));
                l.setLimite_livros(resultadoQ.getInt("limite_livros"));
                l.setStatus(resultadoQ.getInt("status"));
                l.setDel(resultadoQ.getInt("del"));
                l.setNum_cgc(resultadoQ.getString("num_cgc"));
                l.setEmail(resultadoQ.getString("email"));
                lei.add(l);
                
                //printa resultados 
                //System.out.print(l.toString());
            }

        } catch (SQLException e) {
            LoggerUtil.log(LeitorDAO.class, e.getMessage());
            System.out.println("Erro consultar leitor = " + e);
         }

        return lei;
    }

    @Override
    public Leitor consultarId(int id) {
        Leitor l = null; 

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                       + "FROM leitor "
                       + "WHERE id = '"+id+"'"
                       + "and del<>'1'"
                       + "ORDER BY nome ASC";

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                l = new Leitor();
                
                l.setId(resultadoQ.getInt("id"));
                l.setNome(resultadoQ.getString("nome"));
                l.setEndereco(resultadoQ.getString("endereco"));
                l.setCidade(new CidadeDAO().consultarId(resultadoQ.getInt("cidade_id")));
                l.setTipo(resultadoQ.getInt("tipo"));
                l.setDt_nscimento(resultadoQ.getDate("dt_nascimento"));
                l.setMatricula(resultadoQ.getString("matricula"));
                l.setTurma(resultadoQ.getString("turma"));
                l.setTurno(resultadoQ.getString("turno"));
                l.setLimite_livros(resultadoQ.getInt("limite_livros"));
                l.setStatus(resultadoQ.getInt("status"));
                l.setDel(resultadoQ.getInt("del"));
                l.setNum_cgc(resultadoQ.getString("num_cgc"));
                l.setEmail(resultadoQ.getString("email"));
                
                
                //printa resultados 
                System.out.println(l.toString());
            }

        } catch (SQLException e) {
            LoggerUtil.log(LeitorDAO.class, e.getMessage());
            System.out.println("Erro consultar l = " + e);
        }

        return l;
    }

    public ArrayList<Leitor> consultaPersonalizada(int comboIndex, String pesq) {
        
         ArrayList<Leitor> lista = new ArrayList<>();
        
        try {
            String sqlPerson = null;
            
            switch (comboIndex) {
                case 0:
                    sqlPerson = "SELECT * FROM leitor "
                            + "WHERE status='0' and del <>'1' AND id = '" + pesq + "' "
                            + "ORDER BY nome,turma,turno ASC";
                    break;
                case 1:
                    sqlPerson = "SELECT * FROM leitor "
                            + "WHERE status='0' and del <>'1' AND LOWER(nome) like '%" + pesq + "%' "
                            + "ORDER BY nome,turma,turno ASC";
                    break;
                case 2:
                    sqlPerson = "SELECT * FROM leitor "
                            + "WHERE status='0' and del <>'1' AND LOWER(id_turma) like '%" + pesq + "%' "
                            + "ORDER BY nome,turma,turno ASC";
                    break;
            }
            
           
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            
            
            System.out.println("Sql: " + sqlPerson);

            resultadoQ = st.executeQuery(sqlPerson);
            
            
            while (resultadoQ.next()) {
                
                Leitor l = new Leitor();
                
                l.setId(resultadoQ.getInt("id"));
                l.setNome(resultadoQ.getString("nome"));
                l.setEndereco(resultadoQ.getString("endereco"));
                l.setCidade(new CidadeDAO().consultarId(resultadoQ.getInt("cidade_id")));
                l.setTipo(resultadoQ.getInt("tipo"));
                l.setDt_nscimento(resultadoQ.getDate("dt_nascimento"));
                l.setData_registro(resultadoQ.getDate("data_registro"));
                l.setMatricula(resultadoQ.getString("matricula"));
                l.setTurma(resultadoQ.getString("turma"));
                l.setTurno(resultadoQ.getString("turno"));
                l.setLimite_livros(resultadoQ.getInt("limite_livros"));
                l.setStatus(resultadoQ.getInt("status"));
                l.setDel(resultadoQ.getInt("del"));
                l.setNum_cgc(resultadoQ.getString("num_cgc"));
                l.setEmail(resultadoQ.getString("email"));
                
                lista.add(l);
                
            }
            
           
        } catch (SQLException ex) {
            LoggerUtil.log(LeitorDAO.class, ex.getMessage());
            System.out.println("Erro montar consulta person= " + ex);
        }
        
         return lista;
    }
    
}
