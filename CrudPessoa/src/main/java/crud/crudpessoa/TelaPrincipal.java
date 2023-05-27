/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package crud.crudpessoa;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    private PessoaDAOLista pessoaDAO;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        pessoaDAO = PessoaDAOLista.getInstancia();
        atualizarTabela(); 
    }
    
    //Verifica a entrada do usuário
    public boolean verificarEntradas(String nome, String idade, String sexo){
        if(nome.isEmpty() || idade.isEmpty() || sexo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "ERRO", JOptionPane.ERROR_MESSAGE);
              return false;
        }
        return true;
    }

    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) tabelaInfo.getModel();
        model.setRowCount(0);
        
        //Obtem a lista de pessoas do banco de dados 
        List<Pessoa> listaPessoas = pessoaDAO.buscarTodos();
        for(Pessoa pessoa : listaPessoas){
            Object[] row = {pessoa.getId(),pessoa.getNome(),pessoa.getIdade(),pessoa.getSexo()};
            model.addRow(row);
        }      
    }
    
    private void LimparCampos(){
        // esse metodo limpa os campos - ele adiciona um espaco vazio em cada um deles
        campoID.setText("");
        campoNome.setText("");
        campoIdade.setText("");
        campoSexo.setText("");
    }
    
    private void atualizarTabela(List<Pessoa> listaPessoas){
        DefaultTableModel model = (DefaultTableModel) tabelaInfo.getModel();
        model.setRowCount(0);
        
        List<Pessoa> listaPessoas1 = pessoaDAO.buscarTodos();
        
        for(Pessoa pessoa : listaPessoas){
            Object[] row = {pessoa.getId(), pessoa.getNome(), pessoa.getIdade(), pessoa.getSexo()};
            model.addRow(row);         
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoIdade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoSexo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaInfo = new javax.swing.JTable();
        botaoBuscar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoApagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 1000));

        jLabel1.setText("ID");

        campoID.setEditable(false);
        campoID.setEnabled(false);
        campoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIDActionPerformed(evt);
            }
        });

        jLabel2.setText("NOME");

        campoNome.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                campoNomeAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("IDADE");

        jLabel4.setText("SEXO");

        tabelaInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "IDADE", "SEXO"
            }
        ));
        tabelaInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaInfo);

        botaoBuscar.setText("BUSCAR");
        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });

        botaoLimpar.setText("LIMPAR");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        botaoSalvar.setText("SALVAR");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoApagar.setText("APAGAR");
        botaoApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoApagar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(campoID, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoIdade))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 70, Short.MAX_VALUE)))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botaoLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(botaoBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSalvar)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoLimpar)
                        .addComponent(botaoSalvar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoApagar)
                .addGap(62, 62, 62))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoApagarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(campoID.getText());
        pessoaDAO.deletarPessoaPorId(id);
        JOptionPane.showMessageDialog(null,"Pessoa Apagada com Sucesso!");
        LimparCampos();
        atualizarTabela();
    }//GEN-LAST:event_botaoApagarActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        //chama o metodo que limpa os campos
        LimparCampos();
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
   
        String idStr = null;
        String nome = campoNome.getText();
        String idadeStr = campoIdade.getText();
        String sexo = campoSexo.getText();
        
        if(verificarEntradas(nome, idadeStr, sexo)){
        
            int idade = Integer.parseInt(idadeStr); //converte a variavel idadestr para int

            Pessoa pessoa = new Pessoa();

            if (!campoID.getText().isEmpty()) {
                idStr = campoID.getText();
                pessoa.setId(Integer.valueOf(idStr));
            }

            pessoa.setNome(nome);
            pessoa.setSexo(sexo);
            pessoa.setIdade(idade);

            PessoaDAOLista pessoaDAO = PessoaDAOLista.getInstancia();

            if (pessoa.getId() > 0) {
                pessoaDAO.alterarPessoa(pessoa);
                JOptionPane.showMessageDialog(null, "Pessoa Alterada Com Sucesso");

            } else {
                pessoaDAO.adicionarPessoa(pessoa);
                JOptionPane.showMessageDialog(null, "Pessoa Cadastrada Com Sucesso");
            }
            LimparCampos();
            atualizarTabela();
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    
    private void campoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIDActionPerformed

    }//GEN-LAST:event_campoIDActionPerformed

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarActionPerformed

        String nomeStr = campoNome.getText();
        Pessoa pessoa = pessoaDAO.buscarPessoa(nomeStr);
      
        campoID.setText(Integer.toString(pessoa.getId()));  //as duas formas funcionam 
        //campoID.setText(String.valueOf(pessoa.getId()));      //funciona igual a linha acima
        campoNome.setText(pessoa.getNome());
        campoIdade.setText(String.valueOf(pessoa.getIdade()));
        campoSexo.setText(pessoa.getSexo());

        List<Pessoa> listaPessoas = new ArrayList<>();
        listaPessoas.add(pessoa);
        atualizarTabela(listaPessoas);
     
    }//GEN-LAST:event_botaoBuscarActionPerformed

    private void campoNomeAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_campoNomeAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeAncestorMoved

    
    //Evento de clique na tabela
    private void tabelaInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaInfoMouseClicked
        //JOptionPane.showMessageDialog(null, "Clique na table");
        
        Pessoa p = new Pessoa();
        PessoaDAOLista pessoaDAO = PessoaDAOLista.getInstancia();
        int index = tabelaInfo.getSelectedRow();
        
        p = pessoaDAO.buscarTodos().get(index);
        campoID.setText(String.valueOf(p.getId()));
        campoNome.setText(p.getNome());
        campoIdade.setText(String.valueOf(p.getIdade()));
        campoSexo.setText(p.getSexo());
        
        
    }//GEN-LAST:event_tabelaInfoMouseClicked

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoApagar;
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoIdade;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaInfo;
    // End of variables declaration//GEN-END:variables
}
