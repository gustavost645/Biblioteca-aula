/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.relatorios;

import entidade.Leitor;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import util.BibliotecaUtil;

/**
 *
 * @author gustavo
 */

public class CarteirinhasTableModel extends AbstractTableModel {

    // Constantes representando o índice das colunas
    private static final int CHECKBOX = 0;

    // Lista a serem exibidos na tabela
    private final List<Object> linhas;


    // Array com os nomes das colunas.
    private final String colunas[] = {"", "Código", "Nome", "Turma", "Turno",
        "Data Entrada"};
    

    public CarteirinhasTableModel() {
        linhas = new ArrayList<>();
    }

    public CarteirinhasTableModel(List<?> lista) {
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
        Leitor l = (Leitor) linhas.get(rowIndex);
        
        System.out.println(l.toString());
        
        switch (columnIndex) {
            case CHECKBOX:
                return l.isSelecionado();
            case 1:
                return l.getId();
            case 2:
                return l.getNome();
            case 3:
                return l.getTurma();
            case 4:
                return l.getTurno();
            case 5:
                return BibliotecaUtil.formatarData(l.getData_registro().toString());
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");                
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        Leitor l = (Leitor) linhas.get(rowIndex);

        switch (columnIndex) {
            case CHECKBOX:
                l.setSelecionado((Boolean) aValue);
                break;
            case 1:
               l.setId((Integer) aValue);
               break;
            case 2:
               l.setNome((String) aValue);
               break;
            case 3:
               l.setTurma((String) aValue);
               break;
            case 4:
               l.setTurno((String) aValue);
               break;
            case 5:
                l.setData_registro((Date) aValue);
               break;
            default:
                // Não deve ocorrer, pois só existem 4 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
        
    }
}
