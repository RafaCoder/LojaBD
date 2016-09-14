/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Utilitários.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author Jorge
 */
public class TelaClientes extends javax.swing.JFrame {

    /**
     * Creates new form TelaClientes
     */
    public TelaClientes() {
        initComponents();
        preencherTabela("select * from Pessoa order by nomePessoa;");
        campoID.addCaretListener(listener);
    }

    ConectaBanco conecta = new ConectaBanco();
    
    private void preencherTabela(String SQL){
    ArrayList dados = new ArrayList();
     
    String [] Colunas = new String[]{"ID","Nome","Nascimento","Gênero","CPF",
                                     "Email","Telefone","Celular",
                                     "Numero","Rua","Bairro","Cidade","Estado","CEP"};
     
    conecta.executaSQL(SQL);
     
        try {
            conecta.rs.first();
            
            do{
                dados.add(new Object[]{conecta.rs.getInt("idPessoa"),
                                       conecta.rs.getString("nomePessoa"),
                                       conecta.rs.getDate("nascimento"),
                                       conecta.rs.getString("genero"),
                                       conecta.rs.getString("cpfPessoa"),
                                       conecta.rs.getString("email"),
                                       conecta.rs.getString("numeroTelefone"),
                                       conecta.rs.getString("numeroCelular"),
                                       conecta.rs.getInt("numero"),
                                       conecta.rs.getString("rua"),
                                       conecta.rs.getString("bairro"),
                                       conecta.rs.getString("cidade"),
                                       conecta.rs.getString("estado"),
                                       conecta.rs.getString("cep")});
            }while(conecta.rs.next());
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao preencher ArrayList! Erro:" + ex);
        }
     
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        Tabela.setModel(modelo);
        Tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        Tabela.getColumnModel().getColumn(0).setResizable(false);
        Tabela.getColumnModel().getColumn(1).setPreferredWidth(180);
        Tabela.getColumnModel().getColumn(1).setResizable(false);
        Tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
        Tabela.getColumnModel().getColumn(2).setResizable(false);
        Tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
        Tabela.getColumnModel().getColumn(3).setResizable(false);
        Tabela.getColumnModel().getColumn(4).setPreferredWidth(90);
        Tabela.getColumnModel().getColumn(4).setResizable(false);
        Tabela.getColumnModel().getColumn(5).setPreferredWidth(160);
        Tabela.getColumnModel().getColumn(5).setResizable(false);
        Tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(6).setResizable(false);
        Tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
        Tabela.getColumnModel().getColumn(7).setResizable(false);
        Tabela.getColumnModel().getColumn(8).setPreferredWidth(60);
        Tabela.getColumnModel().getColumn(8).setResizable(false);
        Tabela.getColumnModel().getColumn(9).setPreferredWidth(90);
        Tabela.getColumnModel().getColumn(9).setResizable(false);
        Tabela.getColumnModel().getColumn(10).setPreferredWidth(90);
        Tabela.getColumnModel().getColumn(10).setResizable(false);
        Tabela.getColumnModel().getColumn(11).setPreferredWidth(90);
        Tabela.getColumnModel().getColumn(11).setResizable(false);
        Tabela.getColumnModel().getColumn(12).setPreferredWidth(90);
        Tabela.getColumnModel().getColumn(12).setResizable(false);
        Tabela.getTableHeader().setReorderingAllowed(false);
        Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        Tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
        CaretListener listener = new CaretListener() {
        @Override
        public void caretUpdate(final CaretEvent e) {
            //faz as verificações necessárias.. tamanho de campo, validação, etc.
            if(campoID.getText().length() > 0){
                botaoExcluir.setEnabled(true);
                botaoAlterar.setEnabled(true);
                botaoAdicionar.setEnabled(false);
            }
            else{
                botaoExcluir.setEnabled(false);
                botaoAlterar.setEnabled(false);
                botaoAdicionar.setEnabled(true);
            }
        }
    };
    
    private void limparCampos(){
        campoID.setText("");
        campoNome.setText("");
        campoNascimento.setText("");
        campoGenero.setSelectedItem(0);
        campoCPF.setText("");
        campoEmail.setText("");
        campoTelefone.setText("");
        campoCelular.setText("");
        campoNumero.setText("");
        campoRua.setText("");
        campoBairro.setText("");
        campoCidade.setText("");
        campoEstado.setText("");
        campoCEP.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        separadorCabecalho = new javax.swing.JSeparator();
        campoDeBusca = new javax.swing.JTextField();
        botaoBuscar = new javax.swing.JButton();
        separadorRodape = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        labelNome = new javax.swing.JLabel();
        campoID = new javax.swing.JTextField();
        labelID = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        labelGenero = new javax.swing.JLabel();
        labelNascimento = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        campoCPF = new javax.swing.JFormattedTextField();
        campoGenero = new javax.swing.JComboBox<>();
        campoNascimento = new javax.swing.JFormattedTextField();
        labelTelefone = new javax.swing.JLabel();
        campoCelular = new javax.swing.JFormattedTextField();
        campoTelefone = new javax.swing.JFormattedTextField();
        labelCelular = new javax.swing.JLabel();
        botaoLimpar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoAdicionar = new javax.swing.JButton();
        labelCEP = new javax.swing.JLabel();
        campoCEP = new javax.swing.JFormattedTextField();
        labelEstado = new javax.swing.JLabel();
        campoEstado = new javax.swing.JTextField();
        labelCidade = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        labelRua = new javax.swing.JLabel();
        campoRua = new javax.swing.JTextField();
        labelNumero = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        labelBairro = new javax.swing.JLabel();
        campoBairro = new javax.swing.JTextField();
        labelData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        campoDeBusca.setText("Pesquise pelo nome do cliente");
        campoDeBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoDeBuscaMouseClicked(evt);
            }
        });
        campoDeBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDeBuscaActionPerformed(evt);
            }
        });

        botaoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/magnifier.png"))); // NOI18N
        botaoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoBuscarMouseClicked(evt);
            }
        });

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMouseClicked(evt);
            }
        });
        Tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela);

        labelNome.setText("Nome:");

        campoID.setEditable(false);

        labelID.setText("ID:");

        labelCPF.setText("CPF:");

        labelGenero.setText("Genêro:");

        labelNascimento.setText("Nasc:");

        labelEmail.setText("Email:");

        try {
            campoCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPF.setToolTipText("");
        campoCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCPFActionPerformed(evt);
            }
        });

        campoGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indefinido", "Masculino", "Feminino" }));
        campoGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoGeneroActionPerformed(evt);
            }
        });

        try {
            campoNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelTelefone.setText("Telefone:");

        try {
            campoCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelCelular.setText("Celular:");

        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.setEnabled(false);
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoAlterar.setText("Alterar");
        botaoAlterar.setEnabled(false);
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        labelCEP.setText("CEP:");

        try {
            campoCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelEstado.setText("Estado:");

        labelCidade.setText("Cidade:");

        labelRua.setText("Rua:");

        labelNumero.setText("Número:");

        labelBairro.setText("Bairro:");

        labelData.setText("AAAA-MM-DD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separadorRodape, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(separadorCabecalho)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoDeBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCidade))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelCEP)
                                .addGap(18, 18, 18)
                                .addComponent(campoCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEmail)
                            .addComponent(labelRua))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoEmail)
                            .addComponent(campoRua)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelNome)
                                        .addComponent(labelNascimento))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(133, 133, 133)
                                            .addComponent(labelData))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(labelBairro)
                                    .addGap(15, 15, 15)
                                    .addComponent(campoBairro)
                                    .addGap(68, 68, 68)))
                            .addGap(18, 18, 18)
                            .addComponent(labelID)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelGenero)
                                        .addComponent(labelCPF))
                                    .addGap(8, 8, 8)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(campoNascimento)
                                        .addComponent(campoCPF)
                                        .addComponent(campoGenero, 0, 105, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelTelefone)
                                        .addComponent(labelCelular))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoTelefone)
                                        .addComponent(campoCelular)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)
                                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)
                                    .addComponent(botaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)
                                    .addComponent(botaoAdicionar))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(separadorCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoDeBusca)
                            .addComponent(botaoBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelData))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(labelCelular))
                            .addComponent(campoCelular))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(separadorRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoGeneroActionPerformed

    private void campoCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCPFActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        if(campoID.getText().length() > 0){
            try {
                PreparedStatement pst = ConectaBanco.conn.prepareStatement("update Pessoa set nomePessoa = ?, nascimento = ?, genero = ?, "
                                                                         + "cpfPessoa = ?, email = ?, numeroTelefone = ?, numeroCelular = ?, "
                                                                         + "numero = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, cep = ? where idPessoa = ?;");
                pst.setString(1, campoNome.getText());
                pst.setString(2, campoNascimento.getText());
                pst.setString(3, campoGenero.getSelectedItem().toString());
                pst.setString(4, campoCPF.getText());
                pst.setString(5, campoEmail.getText());
                pst.setString(6, campoTelefone.getText());
                pst.setString(7, campoCelular.getText());
                pst.setString(8, campoNumero.getText());
                pst.setString(9, campoRua.getText());
                pst.setString(10, campoBairro.getText());
                pst.setString(11, campoCidade.getText());
                pst.setString(12, campoEstado.getText());
                pst.setString(13, campoCEP.getText());
                pst.setString(14, campoID.getText());
                pst.execute();

                JOptionPane.showMessageDialog(rootPane, "Alterado com Sucesso!");
                preencherTabela("select * from Pessoa order by nomePessoa;");
                limparCampos();
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane,"Erro ao Alterar!\n ERRO: " + ex);
            }
        }
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
         try {
            PreparedStatement pst = ConectaBanco.conn.prepareStatement("insert into Pessoa (nomePessoa, nascimento, genero, cpfPessoa,"
                    + " email, numeroTelefone, numeroCelular, "
                    + "numero, rua, bairro, cidade, estado, cep) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            pst.setString(1, campoNome.getText() );
            pst.setString(2, campoNascimento.getText());
            pst.setString(3, campoGenero.getSelectedItem().toString());
            pst.setString(4, campoCPF.getText());
            pst.setString(5, campoEmail.getText() );
            pst.setString(6, campoTelefone.getText());
            pst.setString(7, campoCelular.getText());
            pst.setString(8, campoNumero.getText() );
            pst.setString(9, campoRua.getText());
            pst.setString(10, campoBairro.getText());
            pst.setString(11, campoCidade.getText() );
            pst.setString(12, campoEstado.getText());
            pst.setString(13, campoCEP.getText());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(rootPane, "Adicionado com Sucesso!");
            preencherTabela("select * from Pessoa order by nomePessoa;");
            limparCampos();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao Adicionar!\n ERRO: " + ex);
        }                                              
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void campoDeBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDeBuscaActionPerformed

    }//GEN-LAST:event_campoDeBuscaActionPerformed

    private void campoDeBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoDeBuscaMouseClicked
        campoDeBusca.setText("");
    }//GEN-LAST:event_campoDeBuscaMouseClicked

    private void botaoBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoBuscarMouseClicked
       if(campoDeBusca.getText().length()> 0){
            for(int i = 0; i < Tabela.getRowCount();i++){
                if(campoDeBusca.getText().equals(Tabela.getValueAt(i, 1))){
                    campoID.setText(Tabela.getValueAt(i, 0).toString());
                    campoNome.setText(Tabela.getValueAt(i, 1).toString());
                    campoNascimento.setText(Tabela.getValueAt(i, 2).toString());
                    campoGenero.setSelectedItem(Tabela.getValueAt(i, 3).toString());                    
                    campoCPF.setText(Tabela.getValueAt(i, 4).toString());
                    campoEmail.setText(Tabela.getValueAt(i, 5).toString());
                    campoTelefone.setText(Tabela.getValueAt(i, 6).toString());
                    campoCelular.setText(Tabela.getValueAt(i, 7).toString());
                    campoNumero.setText(Tabela.getValueAt(i, 8).toString());
                    campoRua.setText(Tabela.getValueAt(i, 9).toString());
                    campoBairro.setText(Tabela.getValueAt(i, 10).toString());
                    campoCidade.setText(Tabela.getValueAt(i, 11).toString());
                    campoEstado.setText(Tabela.getValueAt(i, 12).toString());
                    campoCEP.setText(Tabela.getValueAt(i, 13).toString());
                }
            }
        }
       
//       "ID","Nome","Nascimento","Gênero","CPF",
//                                     "Email","Telefone","Celular",
//                                     "Numero","Rua","Bairro","Cidade","Estado","CEP"};
//       
    }//GEN-LAST:event_botaoBuscarMouseClicked

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        if(campoID.getText().length() > 0){
            try {
                PreparedStatement pst = ConectaBanco.conn.prepareStatement("delete from  Pessoa where idPessoa = ?;");
                pst.setString(1, campoID.getText());
                pst.execute();

                JOptionPane.showMessageDialog(rootPane, "Excluído com Sucesso!");
                preencherTabela("select * from Pessoa order by nomePessoa;");
                limparCampos();
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane,"Erro ao Excluir!\n ERRO: " + ex);
            }
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void TabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaKeyReleased
        int i = Tabela.getSelectedRow();
        campoID.setText(Tabela.getValueAt(i, 0).toString());
        campoNome.setText(Tabela.getValueAt(i, 1).toString());
        campoNascimento.setText(Tabela.getValueAt(i, 2).toString());
        campoGenero.setSelectedItem(Tabela.getValueAt(i, 3).toString());                    
        campoCPF.setText(Tabela.getValueAt(i, 4).toString());
        campoEmail.setText(Tabela.getValueAt(i, 5).toString());
        campoTelefone.setText(Tabela.getValueAt(i, 6).toString());
        campoCelular.setText(Tabela.getValueAt(i, 7).toString());
        campoNumero.setText(Tabela.getValueAt(i, 8).toString());
        campoRua.setText(Tabela.getValueAt(i, 9).toString());
        campoBairro.setText(Tabela.getValueAt(i, 10).toString());
        campoCidade.setText(Tabela.getValueAt(i, 11).toString());
        campoEstado.setText(Tabela.getValueAt(i, 12).toString());
        campoCEP.setText(Tabela.getValueAt(i, 13).toString());
    }//GEN-LAST:event_TabelaKeyReleased

    private void TabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseClicked
        int i = Tabela.getSelectedRow();
        campoID.setText(Tabela.getValueAt(i, 0).toString());
        campoNome.setText(Tabela.getValueAt(i, 1).toString());
        campoNascimento.setText(Tabela.getValueAt(i, 2).toString());
        campoGenero.setSelectedItem(Tabela.getValueAt(i, 3).toString());                    
        campoCPF.setText(Tabela.getValueAt(i, 4).toString());
        campoEmail.setText(Tabela.getValueAt(i, 5).toString());
        campoTelefone.setText(Tabela.getValueAt(i, 6).toString());
        campoCelular.setText(Tabela.getValueAt(i, 7).toString());
        campoNumero.setText(Tabela.getValueAt(i, 8).toString());
        campoRua.setText(Tabela.getValueAt(i, 9).toString());
        campoBairro.setText(Tabela.getValueAt(i, 10).toString());
        campoCidade.setText(Tabela.getValueAt(i, 11).toString());
        campoEstado.setText(Tabela.getValueAt(i, 12).toString());
        campoCEP.setText(Tabela.getValueAt(i, 13).toString());
    }//GEN-LAST:event_TabelaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JFormattedTextField campoCEP;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JFormattedTextField campoCelular;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoDeBusca;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoEstado;
    private javax.swing.JComboBox<String> campoGenero;
    private javax.swing.JTextField campoID;
    private javax.swing.JFormattedTextField campoNascimento;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoRua;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCEP;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelCelular;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelGenero;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelNascimento;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelRua;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JSeparator separadorCabecalho;
    private javax.swing.JSeparator separadorRodape;
    // End of variables declaration//GEN-END:variables
}