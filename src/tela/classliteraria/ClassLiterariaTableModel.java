/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.classliteraria;

import entidade.ClassLiteraria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gusteinhoefel
 */
public class ClassLiterariaTableModel extends AbstractTableModel {

    // Lista de ClassLiteraria a serem exibidos na tabela
    private List<ClassLiteraria> dados;

    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"Código", "Nome da Class. Literária"};

    // Cria um CidadeTableModel sem nenhuma linha
    public ClassLiterariaTableModel() {
        dados = new ArrayList<>();
    }

    // Cria um CidadeTableModel contendo a lista recebida por parâmetro
    public ClassLiterariaTableModel(List<ClassLiteraria> lista) {
        dados = new ArrayList<>(lista);
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
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public ClassLiteraria getRowValue(int l) {
        return dados.get(l);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ClassLiteraria c = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getDescricao();
            default:
                throw new IndexOutOfBoundsException("Fora dos limites das colunas");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega a cidade referente a linha especificada.
        ClassLiteraria c = (ClassLiteraria) dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                c.setId((Integer) aValue);
                break;
            case 1:
                c.setDescricao((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Fora dos limites das colunas");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula

    }

}
