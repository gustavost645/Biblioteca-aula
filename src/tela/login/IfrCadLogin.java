/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.login;

import dao.LoginDAO;
import entidade.Login;
import javax.swing.JOptionPane;
import util.BibliotecaUtil;

/**
 *
 * @author gusteinhoefel
 */
public class IfrCadLogin extends javax.swing.JDialog {

    /**
     * Creates new form IfrCadCidades
     *
     * @param parent
     * @param modal
     */
    private LoginDAO dao = new LoginDAO();
    private String userPassword;

    public IfrCadLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Cadastro de Usuários");
        txtNome.requestFocusInWindow();
    }

    public IfrCadLogin(java.awt.Frame parent, boolean modal, Login login) {
        super(parent, modal);
        initComponents();
        this.setTitle("Alteração de Usuários");
        System.out.println(login.toString());
        txtNome.requestFocusInWindow();
        txtCodigo.setText(String.valueOf(login.getId()));
        txtNome.setText(login.getNome());
        txtLogin.setText(login.getLogin());
        userPassword = login.getPassword();
        txtLogin.setEditable(false);
        txtLogin.setFocusable(false);
        selStatus.setSelected(login.getStatus()==1);
        role.setSelected(login.getRole()==0);

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
        jLabel3 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        selStatus = new javax.swing.JCheckBox();
        role = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Código:");

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);
        txtCodigo.setFocusable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Nome do Usuário:");

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

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Nome do Login:");

        txtLogin.setBackground(java.awt.Color.lightGray);
        txtLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoginFocusLost(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Senha:");

        txtPassword.setBackground(java.awt.Color.lightGray);

        selStatus.setText("Inativo");
        selStatus.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        role.setText("Administrador");
        role.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        role.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(role))
                    .addComponent(txtNome)
                    .addComponent(txtLogin)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                        .addComponent(selStatus)))
                .addGap(13, 13, 13))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(role))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtCodigo.getText().trim().equals("")) {
            if (!txtNome.getText().trim().isEmpty() && !txtLogin.getText().trim().isEmpty() && !txtPassword.getText().trim().isEmpty()) {
                if (dao.consultarUsuario(txtLogin.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "Favor utilizar outro nome de login!\nPois este já se encontra em uso.");
                    txtLogin.requestFocusInWindow();
                    txtLogin.selectAll();
                } else {
                    System.out.println(txtPassword.getText().trim().length());
                    if (txtPassword.getText().trim().length() < 4) {
                        JOptionPane.showMessageDialog(null, "A senha deve possuir mais que 4 dígitos!");
                        txtPassword.requestFocusInWindow();
                        txtPassword.selectAll();
                    } else {
                        Salvar();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios com a cor cinza!");
            }
        } else {
            if (!txtNome.getText().trim().isEmpty() && !txtLogin.getText().trim().isEmpty()) {
                Alterar();
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios com a cor cinza!");
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusLost

    }//GEN-LAST:event_txtLoginFocusLost

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        BibliotecaUtil.eventoSemNumeros(evt);
    }//GEN-LAST:event_txtNomeKeyTyped

    private void roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JCheckBox role;
    private javax.swing.JCheckBox selStatus;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    private void Salvar() {
        Login c = new Login();

        c.setNome(txtNome.getText().trim().toUpperCase());
        c.setLogin(txtLogin.getText().trim());
        c.setPassword(BibliotecaUtil.MD5(txtPassword.getText().trim()));
        c.setStatus((selStatus.isSelected()) ? 1 : 0);
        c.setRole((role.isSelected()) ? 1 : 0);
        c.setDel(0);

        String retorno = dao.salvar(c);

        if (retorno == null) {
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Deu erro: \n\nMensagem técnica:" + retorno);
        }

    }

    private void Alterar() {
        
        Login c = new Login();

        c.setId(Integer.parseInt(txtCodigo.getText().trim()));
        c.setNome(txtNome.getText().trim().toUpperCase());
        c.setLogin(txtLogin.getText().trim());
        c.setStatus((selStatus.isSelected()) ? 1 : 0);
        c.setRole((role.isSelected()) ? 0 : 1);

        if (txtPassword.getText().trim().isEmpty()) {
            c.setPassword(userPassword);
        } else {
            c.setPassword(BibliotecaUtil.MD5(txtPassword.getText().trim()));
        }
        
        String retorno = dao.atualizar(c);

        if (retorno == null) {
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Deu erro: \n\nMensagem técnica:" + retorno);
        }

    }

}
