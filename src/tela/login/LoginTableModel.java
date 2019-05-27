/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.login;

import entidade.Login;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gusteinhoefel
 */
public class LoginTableModel extends AbstractTableModel {

    // Lista de Login a serem exibidos na tabela
    private List<Login> dados;

    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"Código", "Nome do Usuário", "Login", "Status"};

    // Cria um CidadeTableModel sem nenhuma linha
    public LoginTableModel() {
        dados = new ArrayList<>();
    }

    // Cria um CidadeTableModel contendo a lista recebida por parâmetro
    public LoginTableModel(List<Login> lista) {
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

    public Login getRowValue(int l) {
        return dados.get(l);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Login c = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getNome();
            case 2:
                return c.getLogin();
            case 3:
                String resp = c.getStatus() == 0 ? "Ativo" : "Inativo";
                return resp;
            case 4:
                String resp1 = c.getRole() == 0 ? "Ativo" : "Inativo";
                return resp1;
            default:
                throw new IndexOutOfBoundsException("Fora dos limites das colunas");
        }
    }

    /*@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega a cidade referente a linha especificada.
        Login c = (Login) dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                c.setId((Integer) aValue);
                break;
            case 1:
                c.setNome((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Fora dos limites das colunas");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula

    }*/
}
