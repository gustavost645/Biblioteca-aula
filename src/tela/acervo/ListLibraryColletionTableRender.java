/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.acervo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author gustavo
 */
public class ListLibraryColletionTableRender implements TableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        //((JLabel) renderer).setOpaque(true);

            if (table.getValueAt(row, 16).toString().equals("Emprestado")) {

                renderer.setBackground(Color.RED);
                renderer.setForeground(Color.WHITE);
            }else{
                if (row % 2 == 0) {
                    renderer.setBackground(Color.WHITE); 
                    renderer.setForeground(Color.BLACK);
                } else {
                    renderer.setBackground(new Color(242, 242, 242));
                    renderer.setForeground(Color.BLACK);
                }
                
            }

        return renderer;
    }

}