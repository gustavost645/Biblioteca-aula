/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.editoras;

import dao.EditoraDAO;
import entidade.Editora;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import util.BibliotecaUtil;

/**
 *
 * @author gusteinhoefel
 */
public class IfrCadEditoras extends javax.swing.JDialog {

    /**
     * Creates new form IfrCadCidades
     *
     * @param parent
     * @param modal
     */
    private EditoraDAO editoraDAO = new EditoraDAO();
    private String retorno;
    private String nomeEditora;

    public IfrCadEditoras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Cadastro de Editoras");
    }

    public IfrCadEditoras(java.awt.Frame parent, boolean modal, Editora editora) {
        super(parent, modal);
        initComponents();
        setTitle("Alteração de Editoras");

        txtCodigo.setText(String.valueOf(editora.getId()));
        nomeEditora = editora.getDescricao();
        txtNome.setText(nomeEditora);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Código:");

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);
        txtCodigo.setFocusable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Nome da Editora:");

        txtNome.setBackground(java.awt.Color.lightGray);
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1480357534_free-05.png"))); // NOI18N
        jButton2.setText("Salvar");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1479862814_Cancel.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 420, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNome))))
                .addGap(13, 13, 13))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!txtNome.getText().trim().isEmpty()) {
            Salvar();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios com a cor cinza!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        BibliotecaUtil.eventoSemNumeros(evt);
    }//GEN-LAST:event_txtNomeKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private void Salvar() {
        Editora c = new Editora();

        c.setDescricao(txtNome.getText().trim().toUpperCase());

        if (txtCodigo.getText().trim().equals("")) {

            ArrayList list = editoraDAO.consultarEditora(txtNome.getText().trim());
            if (!list.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Esta editora já se encontra cadastrada!");
                txtNome.requestFocusInWindow();
                txtNome.selectAll();
            } else {
                retorno = editoraDAO.salvar(c);

                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "Editora salva com sucesso");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Deu erro: \n\nMensagem técnica:" + retorno);
                }
            }

        } else {

            c.setId(Integer.parseInt(txtCodigo.getText().trim()));

            if (!nomeEditora.toLowerCase().equalsIgnoreCase(txtNome.getText().toLowerCase().trim())) {
                ArrayList list = editoraDAO.consultarEditora(txtNome.getText().trim());
                if (!list.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Esta editora já se encontra cadastrada!");
                    txtNome.requestFocusInWindow();
                    txtNome.selectAll();
                } else {
                    retorno = editoraDAO.atualizar(c);

                    if (retorno == null) {
                        JOptionPane.showMessageDialog(null, "Editora alterada com sucesso");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Deu erro: \n\nMensagem técnica:" + retorno);
                    }
                }
            } else {
                retorno = editoraDAO.atualizar(c);

                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "Editora alterada com sucesso");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Deu erro: \n\nMensagem técnica:" + retorno);
                }
            }
        }
    }

}
