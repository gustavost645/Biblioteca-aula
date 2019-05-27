/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.acervo;

import entidade.Assunto;
import entidade.Autor;
import entidade.ClassLiteraria;
import entidade.Colecao;
import entidade.Editora;
import entidade.Livro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import util.BibliotecaUtil;
import util.LoggerUtil;

/**
 *
 * @author gustavo
 */
public class ListLibraryColletionTableModel extends AbstractTableModel {
    
    

    private final String colunas[] = {"Cód Livro", "Título", "SubTítulo", "Data Aquisição", "Autores",
        "Editora", "Assuntos", "Class. Literária", "Volume", "Edição", "Tombo", "CDD",
        "CDU", "Cutter", "ISBN", "Ano Edição", "Status"};
    
    private List<Livro> dados;

    @Override
    public int getRowCount() {
        if (dados == null) {
            return 0;
        }
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        try {
            Livro l = dados.get(r);
            switch (c) {
                case 0:
                    return l.getId();
                case 1:
                    return l.getTitulo();
                case 2:
                    return l.getSubtitulo();
                case 3:
                    return BibliotecaUtil.formatarData(l.getData_aquisicao().toString());
                case 4:
                    return mostraAutores(l.getAutor());
                case 5:
                    return mostraEditora(l.getEditora());
                case 6:
                    return mostraAssuntos(l.getAssunto());
                case 7:
                    return mostraClassiLit(l.getClassLiteraria());
                case 8:
                    return l.getVolume();
                case 9:
                    return l.getEdicao();
                case 10:
                    return l.getTombo();
                case 11:
                    return l.getCdd();
                case 12:
                    return l.getCdu();
                case 13:
                    return l.getCutter();
                case 14:
                    return l.getIsbn();
                case 15:
                    return l.getAnoEdicao();
                case 16:
                    return (l.getStatus()==1) ? "Emprestado" : "Disponível";
                default:
                    throw new IndexOutOfBoundsException("Coluna inexistente!");
            }
        } catch (IndexOutOfBoundsException ex) {
            LoggerUtil.log(ListLibraryColletionTableModel.class, ex.getMessage());
        }
        return null;
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public Livro getRowValue(int l) {
        return dados.get(l);
    }

    private String mostraAutores(List<Autor> autores) {
        String ret = "";
        for (int i = 0; i < autores.size(); i++) {
            ret += autores.get(i).getNome()+ ",";
        }
        return ret.substring(0, ret.length() - 1);
    }

    private Object mostraAssuntos(List<Assunto> assuntos) {
        String ret = "";
        for (int i = 0; i < assuntos.size(); i++) {
            ret += assuntos.get(i).getDescricao() + ",";
        }
        return ret.substring(0, ret.length() - 1);
    }
    
    private Object mostraEditora(Editora editora) {

        return editora.getDescricao();
    }

    private Object mostraClassiLit(ClassLiteraria classLiteraria) {
        return classLiteraria.getDescricao();
    }

    private Object mostraColecao(List<Colecao> colecao) {
        return colecao.get(0).getDescricao();
    }

    public void setDados(ArrayList<Livro> dados, JTable jTable) {
        this.dados = dados;
        pinta_tabela(jTable);
        fireTableDataChanged();
        
    }
    public void setDados1(ArrayList<Livro> dados, JTable jTable) {
        
        this.dados = dados;
        fireTableDataChanged();

    }

    private void pinta_tabela(JTable table) {
        table.setDefaultRenderer(Object.class, new ListLibraryColletionTableRender());
    }

}
