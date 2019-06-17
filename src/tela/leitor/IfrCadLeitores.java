/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.leitor;

import dao.CidadeDAO;
import dao.LeitorDAO;
import dao.LoginDAO;
import entidade.Cidade;
import entidade.Leitor;
import entidade.Login;
import java.awt.Color;
import javax.swing.JOptionPane;
import tela.cidades.ListCidade;
import util.BibliotecaUtil;

/**
 *
 * @author gusteinhoefel
 */
public class IfrCadLeitores extends javax.swing.JDialog {

    /**
     * Creates new form IfrCadCidades
     *
     * @param parent
     * @param modal
     */
    private LeitorDAO leitorDAO = new LeitorDAO();
    private String retorno;
    private boolean validaCGC;
    private boolean validaEmail;

    public IfrCadLeitores(java.awt.Frame parent, boolean modal, Leitor leitor) {
        super(parent, modal);
        initComponents();
        setTitle("Cadastro de Leitores");
        if (leitor != null) {
            setTitle("Alteração de Leitores");
            alimentaCampos(leitor);
        }
        txtNome.requestFocusInWindow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtIdLeitor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIdCidade = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtDescricaoCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboIdCategoria = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtIdMatricula = new javax.swing.JTextField();
        txtIdTurma = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboIdTurno = new javax.swing.JComboBox<>();
        txtNumLivros = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDataNascimento = new com.toedter.calendar.JDateChooser("dd/MM/yyyy", "##/##/####",'_');
        jLabel15 = new javax.swing.JLabel();
        checkAtivo = new javax.swing.JCheckBox();
        txtCGC = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtUserSystem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPasswordSystem = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        txtPasswordSystem2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Código:");

        txtIdLeitor.setEditable(false);
        txtIdLeitor.setFocusable(false);
        txtIdLeitor.setRequestFocusEnabled(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Nome do Leitor:");

        txtNome.setBackground(new java.awt.Color(204, 204, 204));
        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Endereço:");

        txtEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEnderecoFocusGained(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Cidade:");

        txtIdCidade.setBackground(new java.awt.Color(204, 204, 204));
        txtIdCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdCidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdCidadeFocusLost(evt);
            }
        });
        txtIdCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdCidadeKeyTyped(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1480357371_free-01.png"))); // NOI18N
        jButton3.setAlignmentY(0.0F);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMargin(new java.awt.Insets(0, 14, 0, 14));
        jButton3.setPreferredSize(new java.awt.Dimension(14, 24));
        jButton3.setRequestFocusEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtDescricaoCidade.setEditable(false);
        txtDescricaoCidade.setFocusable(false);
        txtDescricaoCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescricaoCidadeFocusGained(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("*Categoria:");

        comboIdCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudante", "Professor", "Profissional" }));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Matricula:");

        txtIdMatricula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdMatriculaFocusGained(evt);
            }
        });

        txtIdTurma.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdTurmaFocusGained(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Turma:");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Turno:");

        comboIdTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde", "Noite", "Não Informado" }));

        txtNumLivros.setBackground(new java.awt.Color(204, 204, 204));
        txtNumLivros.setText("5");
        txtNumLivros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumLivrosFocusGained(evt);
            }
        });
        txtNumLivros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumLivrosKeyTyped(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Nº de Livros:");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Email:");

        jLabel5.setText("Data Nascimento:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("CPF:");

        checkAtivo.setText("Inativo");

        txtCGC.setBackground(new java.awt.Color(204, 204, 204));
        try {
            txtCGC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCGC.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCGC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCGCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCGCFocusLost(evt);
            }
        });
        txtCGC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCGCKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário para Acesso ao Sistema"));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Usuário:");

        txtUserSystem.setBackground(new java.awt.Color(204, 204, 204));
        txtUserSystem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserSystemFocusGained(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Senha:");

        txtPasswordSystem.setBackground(new java.awt.Color(204, 204, 204));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Repitir Senha:");

        txtPasswordSystem2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPasswordSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPasswordSystem2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtUserSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPasswordSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtPasswordSystem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescricaoCidade)))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCGC, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdLeitor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkAtivo))
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(txtIdTurma, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(txtNumLivros, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(comboIdTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboIdCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdLeitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel5)
                                    .addComponent(txtCGC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDescricaoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtIdMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtIdTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(comboIdTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtNumLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if ((!txtNome.getText().trim().isEmpty())
                && (!txtCGC.getText().replaceAll("\\.", "").replaceAll("/", "").replaceAll("-", "").trim().isEmpty())
                && (txtDataNascimento.getDate() != null)
                && (!txtNumLivros.getText().trim().isEmpty())) {
            Salvar();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios com a cor cinza!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        txtNome.selectAll();
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtEnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnderecoFocusGained
        txtEndereco.selectAll();
    }//GEN-LAST:event_txtEnderecoFocusGained

    private void txtIdCidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdCidadeFocusGained
        txtIdCidade.selectAll();
    }//GEN-LAST:event_txtIdCidadeFocusGained

    private void txtIdCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdCidadeFocusLost
        if (!txtIdCidade.getText().trim().isEmpty()
                || !txtIdCidade.getText().trim().equals("")) {
            readIdCidade(txtIdCidade.getText().trim());
        }
    }//GEN-LAST:event_txtIdCidadeFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ListCidade lc = new ListCidade(null, true, this);
        lc.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtDescricaoCidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescricaoCidadeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoCidadeFocusGained

    private void txtIdMatriculaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdMatriculaFocusGained
        txtIdMatricula.selectAll();
    }//GEN-LAST:event_txtIdMatriculaFocusGained

    private void txtIdTurmaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdTurmaFocusGained
        txtIdTurma.selectAll();
    }//GEN-LAST:event_txtIdTurmaFocusGained

    private void txtNumLivrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumLivrosFocusGained
        txtNumLivros.selectAll();
    }//GEN-LAST:event_txtNumLivrosFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        txtEmail.selectAll();
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtCGCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCGCFocusLost
        ValidaCPF(txtCGC.getText().trim());
    }//GEN-LAST:event_txtCGCFocusLost

    private void txtCGCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCGCFocusGained
        txtCGC.selectAll();
    }//GEN-LAST:event_txtCGCFocusGained

    private void txtIdCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCidadeKeyTyped
        BibliotecaUtil.eventoSemCaracteres(evt);
    }//GEN-LAST:event_txtIdCidadeKeyTyped

    private void txtNumLivrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumLivrosKeyTyped
        BibliotecaUtil.eventoSemCaracteres(evt);
    }//GEN-LAST:event_txtNumLivrosKeyTyped

    private void txtCGCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCGCKeyTyped
        BibliotecaUtil.eventoSemCaracteres(evt);
    }//GEN-LAST:event_txtCGCKeyTyped

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (BibliotecaUtil.validaEmail(txtEmail.getText().trim())) {
            validaEmail = true;
            txtEmail.setForeground(Color.BLACK);
        } else {
            txtEmail.setForeground(Color.RED);
            validaEmail = false;

        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtUserSystemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserSystemFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserSystemFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkAtivo;
    private javax.swing.JComboBox<String> comboIdCategoria;
    private javax.swing.JComboBox<String> comboIdTurno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtCGC;
    private com.toedter.calendar.JDateChooser txtDataNascimento;
    private javax.swing.JTextField txtDescricaoCidade;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIdCidade;
    private javax.swing.JTextField txtIdLeitor;
    private javax.swing.JTextField txtIdMatricula;
    private javax.swing.JTextField txtIdTurma;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumLivros;
    private javax.swing.JPasswordField txtPasswordSystem;
    private javax.swing.JPasswordField txtPasswordSystem2;
    private javax.swing.JTextField txtUserSystem;
    // End of variables declaration//GEN-END:variables

    private void Salvar() {
        Leitor leitor = new Leitor();

        leitor.setNome(txtNome.getText().trim());
        leitor.setNum_cgc(txtCGC.getText().trim());
        leitor.setEndereco(txtEndereco.getText().trim());
        leitor.setCidade(new CidadeDAO().consultarId(Integer.parseInt(txtIdCidade.getText().trim())));
        leitor.setTipo(comboIdCategoria.getSelectedIndex());
        leitor.setDt_nscimento(txtDataNascimento.getDate());
        leitor.setMatricula(txtIdMatricula.getText().trim());
        leitor.setTurma(txtIdTurma.getText().trim());
        leitor.setTurno(comboIdTurno.getSelectedItem().toString());
        leitor.setLimite_livros(Integer.parseInt(txtNumLivros.getText().trim()));
        leitor.setEmail(txtEmail.getText().trim());
        leitor.setStatus((checkAtivo.isSelected() ? 1 : 0));
        leitor.setDel(0);

        Login user = new Login();

        user.setNome(txtNome.getText().trim().toUpperCase());
        user.setLogin(txtUserSystem.getText().trim());
        user.setPassword(BibliotecaUtil.MD5(txtPasswordSystem.getText().trim()));
        user.setStatus(0);
        user.setRole(1);
        user.setDel(0);

        if (txtIdLeitor.getText().trim().isEmpty()) {

            if (!txtUserSystem.getText().trim().isEmpty()) {
                if (txtPasswordSystem.getText().trim().equals(txtPasswordSystem2.getText().trim())) {
                    if (validaCGC) {
                        retorno = leitorDAO.salvar(leitor, user);
                        if (retorno == null) {
                            JOptionPane.showMessageDialog(null, "Leitor salvo com sucesso");
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Deu erro: \n\nMensagem técnica:" + retorno);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "O Numero do CPF não é valido!");
                        txtCGC.requestFocusInWindow();
                    }
                } else {
                    txtPasswordSystem.setText("");
                    txtPasswordSystem2.setText("");
                    txtPasswordSystem.requestFocusInWindow();
                    JOptionPane.showMessageDialog(null, "As senhas são diferentes");
                }
            } else {
                txtUserSystem.requestFocusInWindow();
                JOptionPane.showMessageDialog(null, "O usuário do sistema não pode estar em vazio!");

            }

        } else {
            leitor.setId(Integer.parseInt(txtIdLeitor.getText().trim()));

            if (validaCGC) {
                retorno = leitorDAO.atualizar(leitor);
                //retorno = leitorDAO.salvar(leitor,user);  
                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "Leitor alterado com sucesso");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Deu erro: \n\nMensagem técnica:" + retorno);
                }
            } else {
                JOptionPane.showMessageDialog(null, "O Numero do CPF não é valido!");
                txtCGC.requestFocusInWindow();
            }

        }

        //SalvarUsuario();
    }

    private void alimentaCampos(Leitor l) {

        txtIdLeitor.setText(String.valueOf(l.getId()));
        txtNome.setText(l.getNome());
        txtCGC.setText(l.getNum_cgc());
        ValidaCPF(l.getNum_cgc());
        txtEndereco.setText(l.getEndereco());
        txtIdCidade.setText(String.valueOf(l.getCidade().getId()));
        txtDescricaoCidade.setText(l.getCidade().getNome());
        txtDescricaoCidade.setText(l.getCidade().getNome());
        comboIdCategoria.setSelectedIndex(l.getTipo());
        txtDataNascimento.setDate(l.getDt_nscimento());
        txtIdMatricula.setText(l.getMatricula());
        txtIdTurma.setText(l.getTurma());
        comboIdTurno.setSelectedItem(l.getTurno());
        txtNumLivros.setText(String.valueOf(l.getLimite_livros()));
        if (l.getStatus() == 0) {
            checkAtivo.setSelected(false);
        } else {
            checkAtivo.setSelected(true);
        }
        txtEmail.setText(l.getEmail());
        txtUserSystem.setFocusable(false);
        txtPasswordSystem.setFocusable(false);
        txtPasswordSystem2.setFocusable(false);

    }

    private void readIdCidade(String idCidade) {
        Cidade listCid = new CidadeDAO().consultarId(Integer.parseInt(idCidade));
        if (listCid.getId() != null) {
            txtIdCidade.setText(String.valueOf(listCid.getId()));
            txtDescricaoCidade.setText(listCid.getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Código da cidade não localizado!");
            txtIdCidade.setText("");
            txtDescricaoCidade.setText("");
            txtIdCidade.requestFocusInWindow();
        }

    }

    public void setCidade(Cidade cidade) {
        txtIdCidade.setText(String.valueOf(cidade.getId()));
        txtDescricaoCidade.setText(cidade.getNome());
    }

    private void SalvarUsuario() {
        Login c = new Login();

        c.setNome(txtNome.getText().trim().toUpperCase());
        c.setLogin(txtUserSystem.getText().trim());
        c.setPassword(BibliotecaUtil.MD5(txtPasswordSystem.getText().trim()));
        c.setStatus(0);
        c.setRole(1);
        c.setDel(0);

        String retorno = new LoginDAO().salvarUsuario(c);

        if (retorno == null) {
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Deu erro: \n\nMensagem técnica:" + retorno);
        }
    }

    private void ValidaCPF(String cpf) {
        String numCGC = cpf.replace("-", "").replaceAll("\\.", "").trim();
        if (!numCGC.isEmpty() || !numCGC.equals("")) {
            if (numCGC.length() >= 11) {
                if (!BibliotecaUtil.validaCGC(numCGC)) {
                    txtCGC.setForeground(Color.RED);
                    validaCGC = false;
                } else {
                    validaCGC = true;
                    txtCGC.setForeground(Color.BLACK);
                }
            }
        }
    }
}
