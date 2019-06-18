/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Assunto;
import entidade.Autor;
import entidade.ClassLiteraria;
import entidade.Editora;
import entidade.Livro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.LoggerUtil;

/**
 * @brief Classe LivroDAO
 * @author Gustavo.Steinhoefel
 * @date 20/05/2019
 */
public class LivroDAO implements IDAO_T<Livro> {

    private ResultSet rs;
    private Assunto s;
    private Autor a;
    private int IdBook;

    @Override
    public String salvar(Livro o) {
        int resultado = 0;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO livro"
                    + "(titulo, subtitulo, isbn, volume, anoedicao, edicao, tombo, cdu, cdd, cutter,"
                    + " id_editora, id_class_literaria, id_colecao, data_aquisicao, status, del) "
                    + "VALUES ( '" + o.getTitulo() + "', '" + o.getSubtitulo() + "',"
                    + " '" + o.getIsbn() + "', '" + o.getVolume() + "', '" + o.getAnoEdicao() + "', "
                    + " '" + o.getEdicao() + "', '" + o.getTombo() + "', '" + o.getCdu() + "', "
                    + " '" + o.getCdd() + "', '" + o.getCutter() + "', '" + o.getEditora().getId() + "',"
                    + " '" + o.getClassLiteraria().getId() + "', '" + o.getColecao().getId() + "',"
                    + " '" + o.getData_aquisicao() + "','" + o.getStatus() + "',0) returning id";

            System.out.println("Sql: " + sql);

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                IdBook = rs.getInt("id");
            }

            for (Assunto iv : o.getAssunto()) {
                String SQL = "INSERT INTO livro_assunto"
                        + "(id_livro, id_assunto) "
                        + "VALUES ('" + IdBook + "', '" + iv.getId() + "')";
                resultado = st.executeUpdate(SQL);

            }

            for (Autor iv : o.getAutor()) {
                String SQL = "INSERT INTO livro_autor(\n"
                        + "id_livro, id_autor)\n"
                        + "VALUES ('" + IdBook + "', '" + iv.getId() + "')";
                resultado = st.executeUpdate(SQL);
            }

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
    public String atualizar(Livro o) {

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st2 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st3 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st4 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st5 = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE livro "
                    + "SET titulo = '" + o.getTitulo() + "', subtitulo = '" + o.getSubtitulo() + "', isbn = '" + o.getIsbn() + "', "
                    + "volume = '" + o.getVolume() + "', anoedicao = '" + o.getAnoEdicao() + "', edicao = '" + o.getEdicao() + "', "
                    + "tombo = '" + o.getTombo() + "', cdu = '" + o.getCdu() + "', cdd = '" + o.getCdd() + "', cutter = '" + o.getCutter() + "',"
                    + "id_editora = '" + o.getEditora().getId() + "', id_class_literaria = '" + o.getClassLiteraria().getId() + "', "
                    + "id_colecao = '" + o.getColecao().getId() + "', data_aquisicao = '" + o.getData_aquisicao() + "', status = '" + o.getStatus() + "'"
                    + "WHERE id = '" + o.getId() + "'";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return "Erro ao alterar";
            } else {
                //deletar livro_assunto
                String SQL1 = "DELETE FROM livro_assunto WHERE id_livro='" + o.getId() + "'";
                System.out.println("Sql Gerado:\n" + SQL1);
                int resultado1 = st2.executeUpdate(SQL1);

                //inserir novamente livro assunto
                for (Assunto iv : o.getAssunto()) {
                    String SQL2 = "INSERT INTO livro_assunto(\n"
                            + "id_livro, id_assunto)\n"
                            + "VALUES ('" + o.getId() + "', '" + iv.getId() + "')";
                    System.out.println("Sql Gerado:\n" + SQL2);
                    int resultado2 = st3.executeUpdate(SQL2);

                }

                //deletar livro autor
                String SQL3 = "DELETE FROM livro_autor WHERE id_livro='" + o.getId() + "'";
                System.out.println("Sql Gerado:\n" + SQL3);
                int resultado3 = st4.executeUpdate(SQL3);

                //inserir novamente livro autor
                for (Autor iv : o.getAutor()) {
                    String SQL4 = "INSERT INTO livro_autor(\n"
                            + "id_livro, id_autor)\n"
                            + "VALUES ('" + o.getId() + "', '" + iv.getId() + "')";
                    System.out.println("Sql Gerado:\n" + SQL4);

                    int resultado4 = st5.executeUpdate(SQL4);
                }

                return null;
            }

        } catch (SQLException e) {
            LoggerUtil.log(LeitorDAO.class, e.getMessage());
            System.out.println("Erro ao inserir leitor = " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE LIVRO SET del='1' WHERE id='" + id + "'";

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
    public ArrayList<Livro> consultarTodos() {
        ArrayList<Livro> livros = null;

        try {

            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st1 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st2 = ConexaoBD.getInstance().getConnection().createStatement();

            livros = new ArrayList<>();

            String sql = "SELECT * FROM livro "
                    + "WHERE del='0'"
                    + "ORDER BY titulo ASC,id";

            rs = st.executeQuery(sql);

            while (rs.next()) {

                Livro l = new Livro();

                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setSubtitulo(rs.getString("subtitulo"));
                l.setIsbn(rs.getString("isbn"));
                l.setVolume(rs.getInt("volume"));
                l.setAnoEdicao(rs.getInt("anoEdicao"));
                l.setEdicao(rs.getInt("edicao"));
                l.setTombo(rs.getString("tombo"));
                l.setCdu(rs.getString("cdu"));
                l.setCdd(rs.getString("cdd"));
                l.setCutter(rs.getString("cutter"));
                l.setEditora(new EditoraDAO().consultarId(Integer.parseInt(rs.getString("id_editora"))));
                l.setClassLiteraria(new ClassLiterariaDAO().consultarId(Integer.parseInt(rs.getString("id_class_literaria"))));
                l.setColecao(new ColecaoDAO().consultarId(Integer.parseInt(rs.getString("id_colecao"))));
                l.setData_aquisicao(rs.getDate("data_aquisicao"));
                l.setStatus(rs.getInt("status"));
                l.setCodbarras(rs.getString("codBarras"));

                System.out.println(l.toString());

                String rsAL = "SELECT a.id,a.nome\n"
                        + "FROM autor a INNER JOIN livro_autor la ON la.id_autor=a.id \n"
                        + "WHERE la.id_livro='" + l.getId() + "'";

                ResultSet rs1 = st1.executeQuery(rsAL);

                while (rs1.next()) {
                    Autor a = new Autor();
                    a.setId(rs1.getInt("id"));
                    a.setNome(rs1.getString("nome"));
                    l.addAutor(a);
                }

                String psAsL = "SELECT a.id,a.descricao\n"
                        + "FROM assunto a INNER JOIN livro_assunto la ON la.id_assunto=a.id \n"
                        + "WHERE la.id_livro='" + l.getId() + "'";

                ResultSet rs2 = st2.executeQuery(psAsL);

                while (rs2.next()) {
                    Assunto s = new Assunto();
                    s.setId(rs2.getInt("id"));
                    s.setDescricao(rs2.getString("descricao"));
                    l.addAssunto(s);
                }

                livros.add(l);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }

    @Override
    public ArrayList<Livro> consultar(String criterio) {
        ArrayList<Livro> livros = null;

        try {

            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st1 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st2 = ConexaoBD.getInstance().getConnection().createStatement();

            livros = new ArrayList<>();

            String sql = "SELECT * FROM livro "
                    + "WHERE del='0' AND titulo ILIKE '%" + criterio + "%'"
                    + "ORDER BY titulo ASC,id";

            rs = st.executeQuery(sql);

            while (rs.next()) {

                Livro l = new Livro();

                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setSubtitulo(rs.getString("subtitulo"));
                l.setIsbn(rs.getString("isbn"));
                l.setVolume(rs.getInt("volume"));
                l.setAnoEdicao(rs.getInt("anoEdicao"));
                l.setEdicao(rs.getInt("edicao"));
                l.setTombo(rs.getString("tombo"));
                l.setCdu(rs.getString("cdu"));
                l.setCdd(rs.getString("cdd"));
                l.setCutter(rs.getString("cutter"));
                l.setEditora(new EditoraDAO().consultarId(Integer.parseInt(rs.getString("id_editora"))));
                l.setClassLiteraria(new ClassLiterariaDAO().consultarId(Integer.parseInt(rs.getString("id_class_literaria"))));
                l.setColecao(new ColecaoDAO().consultarId(Integer.parseInt(rs.getString("id_colecao"))));
                l.setData_aquisicao(rs.getDate("data_aquisicao"));
                l.setStatus(rs.getInt("status"));
                l.setCodbarras(rs.getString("codBarras"));

                String rsAL = "SELECT a.id,a.nome\n"
                        + "FROM autor a INNER JOIN livro_autor la ON la.id_autor=a.id \n"
                        + "WHERE la.id_livro='" + l.getId() + "'";

                ResultSet rs1 = st1.executeQuery(rsAL);

                while (rs1.next()) {
                    Autor a = new Autor();
                    a.setId(rs1.getInt("id"));
                    a.setNome(rs1.getString("nome"));
                    l.addAutor(a);
                }

                String psAsL = "SELECT a.id,a.descricao\n"
                        + "FROM assunto a INNER JOIN livro_assunto la ON la.id_assunto=a.id \n"
                        + "WHERE la.id_livro='" + l.getId() + "'";

                ResultSet rs2 = st2.executeQuery(psAsL);

                while (rs2.next()) {
                    Assunto s = new Assunto();
                    s.setId(rs2.getInt("id"));
                    s.setDescricao(rs2.getString("descricao"));
                    l.addAssunto(s);
                }

                livros.add(l);
                System.out.println(l.toString());
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }

    public ArrayList<Livro> listarbyId(String cod) {
        ArrayList<Livro> livros = null;

        try {

            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st1 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st2 = ConexaoBD.getInstance().getConnection().createStatement();

            livros = new ArrayList<>();

            String sql = "SELECT * FROM livro "
                    + "WHERE del='0' AND (id='" + cod + "' OR codBarras='" + cod + "')"
                    + "ORDER BY titulo ASC,id";

            rs = st.executeQuery(sql);

            while (rs.next()) {

                Livro l = new Livro();

                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setSubtitulo(rs.getString("subtitulo"));
                l.setIsbn(rs.getString("isbn"));
                l.setVolume(rs.getInt("volume"));
                l.setAnoEdicao(rs.getInt("anoEdicao"));
                l.setEdicao(rs.getInt("edicao"));
                l.setTombo(rs.getString("tombo"));
                l.setCdu(rs.getString("cdu"));
                l.setCdd(rs.getString("cdd"));
                l.setCutter(rs.getString("cutter"));
                l.setEditora(new EditoraDAO().consultarId(Integer.parseInt(rs.getString("id_editora"))));
                l.setClassLiteraria(new ClassLiterariaDAO().consultarId(Integer.parseInt(rs.getString("id_class_literaria"))));
                l.setColecao(new ColecaoDAO().consultarId(Integer.parseInt(rs.getString("id_colecao"))));
                l.setData_aquisicao(rs.getDate("data_aquisicao"));
                l.setStatus(rs.getInt("status"));
                l.setCodbarras(rs.getString("codBarras"));

                String rsAL = "SELECT a.id,a.nome\n"
                        + "FROM autor a INNER JOIN livro_autor la ON la.id_autor=a.id \n"
                        + "WHERE la.id_livro='" + cod + "'";

                ResultSet rs1 = st1.executeQuery(rsAL);

                while (rs1.next()) {
                    Autor a = new Autor();
                    a.setId(rs1.getInt("id"));
                    a.setNome(rs1.getString("nome"));
                    l.addAutor(a);
                }

                String psAsL = "SELECT a.id,a.descricao\n"
                        + "FROM assunto a INNER JOIN livro_assunto la ON la.id_assunto=a.id \n"
                        + "WHERE la.id_livro='" + cod + "'";

                ResultSet rs2 = st2.executeQuery(psAsL);

                while (rs2.next()) {
                    Assunto s = new Assunto();
                    s.setId(rs2.getInt("id"));
                    s.setDescricao(rs2.getString("descricao"));
                    l.addAssunto(s);
                }

                System.out.println(l.toString());

                livros.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }

    @Override
    public Livro consultarId(int id) {
        Livro livro = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM livro "
                    + "WHERE (id='" + id + "' OR codbarras='" + id + "')"
                    + "AND del <> '1'";

            System.out.println("Sql: " + sql);

            rs = st.executeQuery(sql);

            while (rs.next()) {
                livro = new Livro();

                livro.setId(rs.getInt(1));
                livro.setTitulo(rs.getString(2));
                livro.setSubtitulo(rs.getString(3));
                livro.setIsbn(rs.getString(4));
                livro.setVolume(rs.getInt(5));
                livro.setAnoEdicao(rs.getInt(6));
                livro.setEdicao(rs.getInt(7));
                livro.setTombo(rs.getString(8));
                livro.setCdu(rs.getString(9));
                livro.setCdd(rs.getString(10));
                livro.setCutter(rs.getString(11));
                livro.setEditora(new EditoraDAO().consultarId(Integer.parseInt(rs.getString(12))));
                livro.setClassLiteraria(new ClassLiterariaDAO().consultarId(Integer.parseInt(rs.getString(13))));
                livro.setColecao(new ColecaoDAO().consultarId(Integer.parseInt(rs.getString(14))));
                livro.setData_aquisicao(rs.getDate(15));
                livro.setStatus(rs.getInt(16));
                livro.setDel(rs.getInt(17));
                livro.setCodbarras(rs.getString(18));

                //livro.getAutor().addAll(new AutorDAO().consultarId(id));
                livro.setAutor(Collections.singletonList(new AutorDAO().consultarId(id)));
                livro.setAssunto(Collections.singletonList(new AssuntoDAO().consultarId(id)));

                //printa resultados 
                System.out.print(livro.toString());
            }

        } catch (SQLException e) {
            LoggerUtil.log(LivroDAO.class, e.getMessage());
            System.out.println("Erro consultar livro = " + e);
        }

        return livro;
    }

    public ArrayList<Livro> consultaPersonalizada(int comboIndex, String pesq) {
        ArrayList<Livro> livros = null;
        try {
            String sqlPerson = null;

            switch (comboIndex) {
                case 0:
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.id = '" + pesq + "'\n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";

                    break;
                case 1:
                    
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.titulo ILIKE '%" + pesq + "%' \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
                    
                    break;
                case 2:
                    
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.subtitulo ILIKE '%" + pesq + "%'  \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
                    
                    break;
                case 3:
                    
                     sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.id IN (SELECT la.id_livro FROM livro_autor la INNER JOIN autor a ON la.id_autor=a.id "
                            + "WHERE a.nome ILIKE '%" + pesq + "%') \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
//                    sqlPerson = "SELECT * FROM livro "
//                            + "WHERE del='0' AND id IN (SELECT la.id_livro FROM livro_autor la INNER JOIN autor a ON la.id_autor=a.id "
//                            + "WHERE  LOWER(a.descricao) LIKE '%" + pesq + "%') "
//                            + "ORDER BY titulo ASC";//autor
                    break;
                case 4:
                    
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.id_editora IN (SELECT id FROM editora WHERE  descricao ILIKE '%" + pesq + "%')  \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
//                    sqlPerson = "SELECT * FROM livro "
//                            + "WHERE del='0' AND id_editora IN (SELECT id FROM editora WHERE LOWER(descricao) LIKE '%" + pesq + "%') "
//                            + "ORDER BY titulo ASC";//editora
                    break;
                case 5:
                    
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.id_class_literaria IN (SELECT id FROM class_literaria WHERE descricao ILIKE '%" + pesq + "%') \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
//                    sqlPerson = "SELECT * FROM livro "
//                            + "WHERE del='0' AND id_class_literaria IN (SELECT id FROM class_literaria WHERE LOWER(descricao) LIKE '%" + pesq + "%') "
//                            + "ORDER BY titulo ASC";//class literaria
                    break;
                case 6:
                    
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.tombo = '" + pesq + "' \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
                    
//                    sqlPerson = "SELECT * FROM livro "
//                            + "WHERE del='0' AND tombo = '" + pesq + "' "
//                            + "ORDER BY titulo ASC";//tombo
                    break;
                case 7:
                    
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.cdd = '" + pesq + "' \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
//                    sqlPerson = "SELECT * FROM livro "
//                            + "WHERE del='0' AND cdd = '" + pesq + "' "
//                            + "ORDER BY titulo ASC";//cdd
                    break;
                case 8:
                    
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.cdu = '" + pesq + "' \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
//                    sqlPerson = "SELECT * FROM livro "
//                            + "WHERE del='0' AND cdu = '" + pesq + "' "
//                            + "ORDER BY titulo ASC";//cdu
                    break;
                case 9:
                    
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.cutter = '" + pesq + "' \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
//                    sqlPerson = "SELECT * FROM livro "
//                            + "WHERE del='0' AND cutter = '" + pesq + "' "
//                            + "ORDER BY titulo ASC";//cutter
                    break;
                case 10:
                    
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND id_colecao IN (SELECT id FROM colecao WHERE descricao ILIKE '%" + pesq + "%')  \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
//                    sqlPerson = "SELECT * FROM livro "
//                            + "WHERE del='0' AND id_colecao IN (SELECT id FROM colecao WHERE LOWER(descricao) LIKE '%" + pesq + "%') "
//                            + "ORDER BY titulo ASC";//coleções
                    break;
                case 11:
                    
                    sqlPerson = "SELECT count(titulo) as numlivros,coalesce(emp.num_emprestimos, 0) as numemprestimos,l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,l.id_colecao,l.data_aquisicao,l.del\n"
                            + "FROM livro l LEFT JOIN (select count(titulo) as num_emprestimos,titulo as tit\n"
                            + "from emprestimo e inner join livro l on e.id_livro=l.id and e.datachegada isnull\n"
                            + "group by l.titulo) emp on l.titulo=emp.tit\n"
                            + "WHERE\n"
                            + "l.del<>'1' AND l.id IN (SELECT la.id_livro FROM livro_assunto la INNER JOIN assunto a ON la.id_assunto=a.id "
                            + "WHERE a.descricao ILIKE '%" + pesq + "%') \n"
                            + "GROUP BY l.titulo,l.subtitulo,l.isbn,l.volume,l.anoedicao\n"
                            + ",l.edicao,l.tombo,l.cdu,l.cdd,l.cutter,l.id_editora,l.id_class_literaria,\n"
                            + "l.id_colecao,l.data_aquisicao,l.del,emp.num_emprestimos\n"
                            + "ORDER BY l.titulo asc";
                    
//                    sqlPerson = "SELECT * FROM livro "
//                            + "WHERE del='0' AND id IN (SELECT la.id_livro FROM livro_assunto la INNER JOIN assunto a ON la.id_assunto=a.id "
//                            + "WHERE  LOWER(a.descricao) LIKE '%" + pesq + "%') "
//                            + "ORDER BY titulo ASC";//assuntos
                    break;
            }

            livros = new ArrayList<>();

            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st1 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st2 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st3 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st4 = ConexaoBD.getInstance().getConnection().createStatement();

            rs = st.executeQuery(sqlPerson);

            while (rs.next()) {

                Livro l = new Livro();

                l.setNumLivros(rs.getString(1));
                l.setNumEmprestimos(rs.getString(2));
                l.setTitulo(rs.getString("titulo"));
                l.setSubtitulo(rs.getString("subtitulo"));
                l.setIsbn(rs.getString("isbn"));
                l.setVolume(rs.getInt("volume"));
                l.setAnoEdicao(rs.getInt("anoEdicao"));
                l.setEdicao(rs.getInt("edicao"));
                l.setTombo(rs.getString("tombo"));
                l.setCdu(rs.getString("cdu"));
                l.setCdd(rs.getString("cdd"));
                l.setCutter(rs.getString("cutter"));
                l.setEditora(new EditoraDAO().consultarId(Integer.parseInt(rs.getString("id_editora"))));
                l.setClassLiteraria(new ClassLiterariaDAO().consultarId(Integer.parseInt(rs.getString("id_class_literaria"))));
                l.setColecao(new ColecaoDAO().consultarId(Integer.parseInt(rs.getString("id_colecao"))));
                l.setData_aquisicao(rs.getDate("data_aquisicao"));
                //l.setStatus(rs.getInt("status"));
                //l.setCodbarras(rs.getString("codBarras"));

                String psAL = "SELECT DISTINCT a.id,a.nome\n"
                        + "FROM autor a INNER JOIN livro_autor la ON la.id_autor=a.id "
                        + "INNER JOIN livro li on la.id_livro=li.id "
                        + "WHERE li.titulo like '" + l.getTitulo() + "'";

                ResultSet rsAL = st1.executeQuery(psAL);
                while (rsAL.next()) {
                    Autor a = new Autor();
                    a.setId(rsAL.getInt("id"));
                    a.setNome(rsAL.getString("nome"));
                    l.addAutor(a);
                }
                
                
                
                String psAsL = "SELECT DISTINCT a.id,a.descricao FROM assunto a "
                        + "INNER JOIN livro_assunto la ON la.id_assunto=a.id "
                        + "INNER JOIN livro li on la.id_livro=li.id "
                        + "WHERE lI.titulo like '" + l.getTitulo() + "'";

                ResultSet rsAsL = st2.executeQuery(psAsL);
                while (rsAsL.next()) {
                    Assunto s = new Assunto();
                    s.setId(rsAsL.getInt("id"));
                    s.setDescricao(rsAsL.getString("descricao"));
                    l.addAssunto(s);
                }

                //consulta classificacao
                String psCL = "SELECT DISTINCT a.id,a.descricao \n" +
                              "FROM class_literaria a INNER JOIN livro la ON la.id_class_literaria=a.id \n" +
                              "WHERE la.titulo like '"+l.getTitulo()+"'";

                System.out.println(psCL);
                
                ResultSet rsCL = st3.executeQuery(psCL);

                while (rsCL.next()) {
                    ClassLiteraria c = new ClassLiteraria();
                    c.setId(rsCL.getInt("id"));
                    c.setDescricao(rsCL.getString("descricao"));
                    l.setClassLiteraria(c);
                }

                //consulta editora
                String psED = "SELECT DISTINCT a.id,a.descricao "
                            + "FROM editora a INNER JOIN livro la ON la.id_editora=a.id "
                            + "WHERE la.titulo like '" + l.getTitulo() + "'";

                ResultSet rsED = st4.executeQuery(psED);

                System.out.println("SQL .:" + psED + "\n");

                while (rsED.next()) {
                    Editora e = new Editora();
                    e.setId(rsED.getInt("id"));
                    e.setDescricao(rsED.getString("descricao"));
                    l.setEditora(e);
                }

                livros.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }
    
    public ArrayList<Livro> consultaPersonalizada2(int comboIndex, String pesq) {
        ArrayList<Livro> livros = null;
        try {
            String sqlPerson = null;

            switch (comboIndex) {
                case 0:
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND id = '" + pesq + "' "
                            + "ORDER BY titulo ASC";
                    break;
                case 1:
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND titulo ILIKE '%" + pesq + "%' "
                            + "ORDER BY titulo ASC";
                    break;
                case 2:
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND subtitulo ILIKE '%" + pesq + "%' "
                            + "ORDER BY titulo ASC";
                    break;
                case 3:                    
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND id IN (SELECT la.id_livro FROM livro_autor la INNER JOIN autor a ON la.id_autor=a.id "
                            + "WHERE  LOWER(a.descricao) LIKE '%" + pesq + "%') "
                            + "ORDER BY titulo ASC";//autor
                    break;
                case 4:
                    
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND id_editora IN (SELECT id FROM editora WHERE LOWER(descricao) LIKE '%" + pesq + "%') "
                            + "ORDER BY titulo ASC";//editora
                    break;
                case 5:                  
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND id_class_literaria IN (SELECT id FROM class_literaria WHERE LOWER(descricao) LIKE '%" + pesq + "%') "
                            + "ORDER BY titulo ASC";//class literaria
                    break;
                case 6:
                                        
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND tombo = '" + pesq + "' "
                            + "ORDER BY titulo ASC";//tombo
                    break;
                case 7:
                                       
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND cdd = '" + pesq + "' "
                            + "ORDER BY titulo ASC";//cdd
                    break;
                case 8:
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND cdu = '" + pesq + "' "
                            + "ORDER BY titulo ASC";//cdu
                    break;
                case 9:
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND cutter = '" + pesq + "' "
                            + "ORDER BY titulo ASC";//cutter
                    break;
                case 10:
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND id_colecao IN (SELECT id FROM colecao WHERE LOWER(descricao) LIKE '%" + pesq + "%') "
                            + "ORDER BY titulo ASC";//coleções
                    break;
                case 11:
                    
                    sqlPerson = "SELECT * FROM livro "
                            + "WHERE del='0' AND id IN (SELECT la.id_livro FROM livro_assunto la INNER JOIN assunto a ON la.id_assunto=a.id "
                            + "WHERE  LOWER(a.descricao) LIKE '%" + pesq + "%') "
                            + "ORDER BY titulo ASC";//assuntos
                    break;
            }

            livros = new ArrayList<>();

            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st1 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st2 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st3 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st4 = ConexaoBD.getInstance().getConnection().createStatement();

            rs = st.executeQuery(sqlPerson);

            while (rs.next()) {

                Livro l = new Livro();

                l.setId(rs.getInt(1));
                l.setTitulo(rs.getString("titulo"));
                l.setSubtitulo(rs.getString("subtitulo"));
                l.setIsbn(rs.getString("isbn"));
                l.setVolume(rs.getInt("volume"));
                l.setAnoEdicao(rs.getInt("anoEdicao"));
                l.setEdicao(rs.getInt("edicao"));
                l.setTombo(rs.getString("tombo"));
                l.setCdu(rs.getString("cdu"));
                l.setCdd(rs.getString("cdd"));
                l.setCutter(rs.getString("cutter"));
                l.setEditora(new EditoraDAO().consultarId(Integer.parseInt(rs.getString("id_editora"))));
                l.setClassLiteraria(new ClassLiterariaDAO().consultarId(Integer.parseInt(rs.getString("id_class_literaria"))));
                l.setColecao(new ColecaoDAO().consultarId(Integer.parseInt(rs.getString("id_colecao"))));
                l.setData_aquisicao(rs.getDate("data_aquisicao"));
                l.setStatus(rs.getInt("status"));
                l.setCodbarras(rs.getString("codBarras"));

                String psAL = "SELECT a.id,a.nome\n"
                        + "FROM autor a INNER JOIN livro_autor la ON la.id_autor=a.id \n"
                        + "WHERE la.id_livro='" + l.getId() + "'";

                ResultSet rsAL = st1.executeQuery(psAL);
                while (rsAL.next()) {
                    Autor a = new Autor();
                    a.setId(rsAL.getInt("id"));
                    a.setNome(rsAL.getString("nome"));
                    l.addAutor(a);
                }

                String psAsL = "SELECT a.id,a.descricao FROM assunto a "
                        + "INNER JOIN livro_assunto la ON la.id_assunto=a.id "
                        + "WHERE la.id_livro='" + l.getId() + "'";

                ResultSet rsAsL = st2.executeQuery(psAsL);
                while (rsAsL.next()) {
                    Assunto s = new Assunto();
                    s.setId(rsAsL.getInt("id"));
                    s.setDescricao(rsAsL.getString("descricao"));
                    l.addAssunto(s);
                }

                //consulta classificacao
                String psCL = "SELECT a.id,a.descricao\n"
                        + "FROM class_literaria a INNER JOIN livro la ON la.id_class_literaria=a.id \n"
                        + "WHERE la.id='" + l.getId() + "'";

                ResultSet rsCL = st3.executeQuery(psCL);

                while (rsCL.next()) {
                    ClassLiteraria c = new ClassLiteraria();
                    c.setId(rsCL.getInt("id"));
                    c.setDescricao(rsCL.getString("descricao"));
                    l.setClassLiteraria(c);
                }

                //consulta editora
                String psED = "SELECT a.id,a.descricao\n"
                        + "FROM editora a INNER JOIN livro la ON la.id_editora=a.id \n"
                        + "WHERE la.id='" + l.getId() + "'";

                ResultSet rsED = st4.executeQuery(psED);

                System.out.println("SQL .:" + psED + "\n");

                while (rsED.next()) {
                    Editora e = new Editora();
                    e.setId(rsED.getInt("id"));
                    e.setDescricao(rsED.getString("descricao"));
                    l.setEditora(e);
                }

                livros.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }

    public ArrayList<Livro> listarEmprestimobyId(String cod) {
        ArrayList<Livro> livros = null;

        try {

            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st1 = ConexaoBD.getInstance().getConnection().createStatement();
            Statement st2 = ConexaoBD.getInstance().getConnection().createStatement();

            livros = new ArrayList<>();
            
            
            String sql1 = "SELECT e.datavencimento,l.* "
                        + "FROM emprestimo e INNER JOIN livro l ON e.id_livro=l.id AND e.id_leitor='"+cod+"'"
                        + "WHERE e.datachegada isnull";
            
            

            String sql = "SELECT * FROM livro "
                    + "WHERE del='0' AND (id='" + cod + "' OR codBarras='" + cod + "')"
                    + "ORDER BY titulo ASC,id";

            rs = st.executeQuery(sql1);

            while (rs.next()) {

                Livro l = new Livro();

                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setSubtitulo(rs.getString("subtitulo"));
                l.setIsbn(rs.getString("isbn"));
                l.setVolume(rs.getInt("volume"));
                l.setAnoEdicao(rs.getInt("anoEdicao"));
                l.setEdicao(rs.getInt("edicao"));
                l.setTombo(rs.getString("tombo"));
                l.setCdu(rs.getString("cdu"));
                l.setCdd(rs.getString("cdd"));
                l.setCutter(rs.getString("cutter"));
                l.setEditora(new EditoraDAO().consultarId(Integer.parseInt(rs.getString("id_editora"))));
                l.setClassLiteraria(new ClassLiterariaDAO().consultarId(Integer.parseInt(rs.getString("id_class_literaria"))));
                l.setColecao(new ColecaoDAO().consultarId(Integer.parseInt(rs.getString("id_colecao"))));
                l.setData_aquisicao(rs.getDate("datavencimento"));
                l.setStatus(rs.getInt("status"));
                l.setCodbarras(rs.getString("codBarras"));

                String rsAL = "SELECT a.id,a.nome\n"
                        + "FROM autor a INNER JOIN livro_autor la ON la.id_autor=a.id \n"
                        + "WHERE la.id_livro='" + cod + "'";

                ResultSet rs1 = st1.executeQuery(rsAL);

                while (rs1.next()) {
                    Autor a = new Autor();
                    a.setId(rs1.getInt("id"));
                    a.setNome(rs1.getString("nome"));
                    l.addAutor(a);
                }

                String psAsL = "SELECT a.id,a.descricao\n"
                        + "FROM assunto a INNER JOIN livro_assunto la ON la.id_assunto=a.id \n"
                        + "WHERE la.id_livro='" + cod + "'";

                ResultSet rs2 = st2.executeQuery(psAsL);

                while (rs2.next()) {
                    Assunto s = new Assunto();
                    s.setId(rs2.getInt("id"));
                    s.setDescricao(rs2.getString("descricao"));
                    l.addAssunto(s);
                }

                System.out.println(l.toString());

                livros.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }

}
