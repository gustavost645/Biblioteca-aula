/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.livro;

import tela.acervo.*;
import entidade.Assunto;
import entidade.Autor;
import entidade.ClassLiteraria;
import entidade.Colecao;
import entidade.Editora;
import entidade.Livro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import util.BibliotecaUtil;
import util.LoggerUtil;

/**
 *
 * @author gustavo
 */
public class LivroTableModel extends AbstractTableModel {

    private final String colunas[] = {"Cód Livro","Cod Barras","Título","Autor(es)","Edição"};
    private List<Livro> dados;

    public LivroTableModel() {
        dados = new ArrayList<>();
    }

    // Cria uma lista recebida por parâmetro
    public LivroTableModel(List<Livro> listaLivros) {
        dados = new ArrayList<>(listaLivros);
    }

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
                    return l.getCodbarras();
                case 2:
                    return l.getTitulo();
                case 3:
                    return mostraAutores(l.getAutor());
                case 4:
                    return l.getEdicao();
                case 5:
                    return mostraEditora(l.getEditora());
                case 6:
                    return mostraAssuntos(l.getAssunto());
                case 7:
                    return mostraClassiLit(l.getClassLiteraria());
                case 8:
                    return l.getVolume();
                case 9:
                    return BibliotecaUtil.formatarData(l.getData_aquisicao().toString());
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
                    return l.getStatus() == 1 ? "Emprestado" : "Disponível";
                case 17:
                    return l.getDel();
                case 18:
                    return mostraColecao(l.getColecao());
                case 19:
                    return l.getSubtitulo();
                default:
                    throw new IndexOutOfBoundsException("Coluna inexistente!");
            }
        } catch (IndexOutOfBoundsException ex) {
            LoggerUtil.log(LivroTableModel.class, ex.getMessage());
        }
        return null;
    }
    
    
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        // Pega a linha especificada.
//        Livro c = (Livro) dados.get(rowIndex);
//
//        switch (columnIndex) {
//            case 0:
//                c.setId((Integer) aValue);
//                break;
//            case 1:
//                c.setDescricao((String) aValue);
//                break;
//            default:
//                throw new IndexOutOfBoundsException("Fora dos limites das colunas");
//        }
//
//        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
//
//    }
    

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
            ret += autores.get(i).getNome() + ",";
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

    private Object mostraColecao(Colecao colecao) {
        return colecao.getDescricao();
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
