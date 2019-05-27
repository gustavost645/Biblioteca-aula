/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.leitor;

import entidade.Cidade;
import entidade.Leitor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import util.LeitorTipoEnum;
import util.ValidaCPF;

/**
 *
 * @author gusteinhoefel
 */
public class LeitorTableModel extends AbstractTableModel {

    // Lista de Leitor a serem exibidos na tabela
    private List<Leitor> dados;

    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"CGC", "Nome da Leitor",
        "Endereço", "Cidade",
        "Tipo", "Limite Livros",
        "Status"};

    // Cria um CidadeTableModel sem nenhuma linha
    public LeitorTableModel() {
        dados = new ArrayList<>();
    }

    // Cria um CidadeTableModel contendo a lista recebida por parâmetro
    public LeitorTableModel(List<Leitor> listaDeCidades) {
        dados = new ArrayList<>(listaDeCidades);
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

    public Leitor getRowValue(int l) {
        return dados.get(l);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Leitor l = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return ValidaCPF.imprimeCPF(l.getNum_cgc());
            case 1:
                return l.getNome();
            case 2:
                return l.getEndereco();
            case 3:
                return l.getCidade().getNome();
            case 4:
                return LeitorTipoEnum.getByCodigoTipo(String.valueOf(l.getTipo())).getNomeTipo();
            case 5:
                return l.getLimite_livros();
            case 6:
                return (l.getStatus() == 0) ? "Ativo" : "Inativo";
            default:
                throw new IndexOutOfBoundsException("Fora dos limites das colunas");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega a cidade referente a linha especificada.
        Leitor l = (Leitor) dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                l.setId((Integer) aValue);
                break;
            case 1:
                l.setNome((String) aValue);
                break;
            case 2:
                l.setEndereco((String) aValue);
                break;
            case 3:
                l.setCidade((Cidade) aValue);
                break;
            case 4:
                l.setTipo((int) aValue);
                break;
            case 5:
                l.setDt_nscimento((Date) aValue);
                break;
            case 6:
                l.setMatricula((String) aValue);
                break;
            case 7:
                l.setTurma((String) aValue);
                break;
            case 8:
                l.setTurno((String) aValue);
                break;
            case 9:
                l.setLimite_livros((int) aValue);
                break;
            case 10:
                l.setStatus((int) aValue);
                break;
            case 11:
                l.setDel((int) aValue);
                break;
            case 12:
                l.setNum_cgc((String) aValue);
                break;
            case 13:
                l.setEmail((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Fora dos limites das colunas");
        }
        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula

    }

}
