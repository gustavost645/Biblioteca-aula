/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.relatorios;

import entidade.Assunto;
import entidade.Autor;
import entidade.Livro;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import util.BibliotecaUtil;

/**
 *
 * @author gustavo
 */
public class EtiquetasTableModel extends AbstractTableModel {

    // Constantes representando o índice das colunas
    private static final int CHECKBOX = 0;

    // Lista a serem exibidos na tabela
    private final List<Object> linhas;

    // Array com os nomes das colunas.
    private final String colunas[] = {"", "Cód. Barras", "Título", "Data Aquisição", "Autores",
        "Editora", "Assuntos", "Class. Literária", "Status"};

    public EtiquetasTableModel() {
        linhas = new ArrayList<>();
    }

    public EtiquetasTableModel(List<?> lista) {
        linhas = new ArrayList<>(lista);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class klass = String.class;
        if (columnIndex == 0) {
            klass = Boolean.class;
        }
        return klass;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // apenas o campo "CHECKBOX" será editável
        return columnIndex == CHECKBOX;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o objeto referente a linha especificada.
        Livro l = (Livro) linhas.get(rowIndex);

        switch (columnIndex) {
            case CHECKBOX:
                return l.getSelecionado();
            case 1:
                return l.getCodbarras();
            case 2:
                return l.getTitulo();
            case 3:
                return BibliotecaUtil.formatarData(l.getData_aquisicao().toString());
            case 4:
                return mostraAutores(l.getAutor());
            case 5:
                return l.getEditora().getDescricao();
            case 6:
                return mostraAssuntos(l.getAssunto());
            case 7:
                return l.getClassLiteraria().getDescricao();
            case 8:
                return l.getStatus()==1 ? "Emprestado" : "Disponível";
            default:
                // Não deve ocorrer, pois só existem 17 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        Livro l = (Livro) linhas.get(rowIndex);

        switch (columnIndex) {
            case CHECKBOX:
                l.setSelecionado((Boolean) aValue);
                break;
            case 1:
                l.setId((Integer) aValue);
                break;
            case 2:
                l.setTitulo((String) aValue);
                break;
            case 3:
                l.setSubtitulo((String) aValue);
                break;
            case 4:
                l.setData_aquisicao((Date) aValue);
                break;
            case 5:
                l.setVolume((Integer) aValue);
                break;
            case 6:
                l.setVolume((Integer) aValue);
                break;
            case 7:
                l.setVolume((Integer) aValue);
                break;
            case 8:
                l.setVolume((Integer) aValue);
                break;
//            case 10:
//                l.setEdicao((Integer) aValue);
//                break;
//            case 11:
//                l.setTombo((String) aValue);
//                break;
//            case 12:
//                l.setCdd((String) aValue);
//                break;
//            case 13:
//                l.setCdu((String) aValue);
//                break;
//            case 14:
//                l.setCutter((String) aValue);
//                break;
//            case 15:
//                l.setIsbn((String) aValue);
//                break;
//            case 16:
//                l.setAnoEdicao((Integer) aValue);
//                break;
//            case 17:
//                l.setStatus((boolean) aValue);
//                break;
            default:
                // Não deve ocorrer, pois só existem 4 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula

    }

    private String mostraAutores(List<Autor> autores) {
        String ret = "";
        for(Autor autor : autores){
            ret += autor.getNome()+",";
        }
        return ret.substring(0, ret.length() - 1);
    }

    private Object mostraAssuntos(List<Assunto> assuntos) {
        String ret = "";
        for(Assunto assunto : assuntos){
            ret += assunto.getDescricao()+",";
        }
        return ret.substring(0, ret.length() - 1);
    }
}
