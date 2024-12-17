/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tela;

import Persistencia.PessoaPersistencia;
import entidades.Endereco;
import entidades.Pessoa;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author d4nny
 */
public class TelaPessoa extends javax.swing.JFrame {

    /**
     * Creates new form TelaPessoa
     */
    public TelaPessoa() {
        setTitle("Pessoa");
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonSalva = new javax.swing.JButton();
        JButtonExcluir = new javax.swing.JButton();
        jButtonRecupera = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtIdendereco = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Data de Nascimento(AAAA-MM-DD):");

        jLabel3.setText("Id do Endereco:");

        jButtonSalva.setText("Salvar");
        jButtonSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvaActionPerformed(evt);
            }
        });

        JButtonExcluir.setText("Excluir");
        JButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonExcluirActionPerformed(evt);
            }
        });

        jButtonRecupera.setText("Recuperar");
        jButtonRecupera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecuperaActionPerformed(evt);
            }
        });

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtIdendereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdenderecoActionPerformed(evt);
            }
        });

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdendereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtData, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRecupera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalva)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalva, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRecupera, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtIdenderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdenderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdenderecoActionPerformed

    private void jButtonSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvaActionPerformed
        // TODO add your handling code here:
        // Extrair os valores dos campos de texto
        String nome = txtNome.getText();
        Date dataNascimento = (Date) txtData.getValue(); 
        int idEndereco = Integer.parseInt(txtIdendereco.getText());

        // Criar um novo objeto Pessoa com os valores dos campos de texto
        Pessoa pessoa = new Pessoa(nome, dataNascimento, new Endereco(idEndereco, null, 0, null, null));

        try {
            // Tentar salvar a pessoa no banco de dados
            PessoaPersistencia.salvar(pessoa);
            // Se não houver exceção, o salvamento foi bem-sucedido
            JOptionPane.showMessageDialog(this, "Pessoa salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            // Se uma exceção for lançada, exibir mensagem de erro
            JOptionPane.showMessageDialog(this, "Erro ao salvar a pessoa: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonSalvaActionPerformed

    private void jButtonRecuperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecuperaActionPerformed
        // TODO add your handling code here:
        // Extrair o nome da pessoa a ser recuperada
        String nome = txtNome.getText();

        // Tentar recuperar a pessoa do banco de dados
        Pessoa pessoa = PessoaPersistencia.recuperar(nome);

        // Verificar se a pessoa foi encontrada
        if (pessoa != null) {
            // Se encontrada, exibir os detalhes da pessoa
            String mensagem = "Pessoa encontrada:\n"
                    + "Nome: " + pessoa.getNome() + "\n"
                    + "Data de Nascimento: " + pessoa.getDataNascimento() + "\n"
                    + "ID do Endereço: " + pessoa.getEndereco().getId();
            JOptionPane.showMessageDialog(this, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Se não encontrada, exibir uma mensagem informando que a pessoa não foi encontrada
            JOptionPane.showMessageDialog(this, "Pessoa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonRecuperaActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        // Capturar os valores dos campos de texto
        String nome = txtNome.getText();
        Date dataNascimento = Date.valueOf(txtData.getText());
        int idEndereco = Integer.parseInt(txtIdendereco.getText());

        // Criar um objeto Pessoa com os valores capturados
        Pessoa pessoa = new Pessoa(nome, dataNascimento, new Endereco(idEndereco, null, 0, null, null)); // Você precisará definir o construtor apropriado em Pessoa

        try {
            // Tentar atualizar a pessoa no banco de dados
            PessoaPersistencia.atualizar(pessoa);
            // Se não houver exceção, a atualização foi bem-sucedida
            JOptionPane.showMessageDialog(this, "Pessoa atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            // Se uma exceção for lançada, exibir mensagem de erro
            JOptionPane.showMessageDialog(this, "Erro ao atualizar pessoa: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void JButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonExcluirActionPerformed
        // TODO add your handling code here:
        // Capturar o nome da pessoa a ser excluída
    String nome = txtNome.getText();

    try {
        // Tentar excluir a pessoa do banco de dados
        PessoaPersistencia.excluir(nome);
        // Se não houver exceção, a exclusão foi bem-sucedida
        JOptionPane.showMessageDialog(this, "Pessoa excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception ex) {
        // Se uma exceção for lançada, exibir mensagem de erro
        JOptionPane.showMessageDialog(this, "Erro ao excluir pessoa: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_JButtonExcluirActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonExcluir;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonRecupera;
    private javax.swing.JButton jButtonSalva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtIdendereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
