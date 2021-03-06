/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TempoController;

import model.Global;
import model.Time;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author nani
 */
public class JDialogConTempo extends javax.swing.JDialog {

    private TempoController controllerTempo;

    public JDialogConTempo(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.getHSBColor(34, 139, 34));
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        controllerTempo = new TempoController();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldMinutos = new javax.swing.JTextField();
        jTextFieldSegundos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonMenosMin = new javax.swing.JButton();
        jButtonMenosSeg = new javax.swing.JButton();
        jButtonMaisMin = new javax.swing.JButton();
        jButtonMaisSeg = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldMinutos.setEditable(false);
        jTextFieldMinutos.setText("0");
        jTextFieldMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMinutosActionPerformed(evt);
            }
        });

        jTextFieldSegundos.setEditable(false);
        jTextFieldSegundos.setText("0");

        jLabel1.setText("Minutos :");

        jLabel2.setText("Segundos :");

        jButtonMenosMin.setText("-");
        jButtonMenosMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosMinActionPerformed(evt);
            }
        });

        jButtonMenosSeg.setText("-");
        jButtonMenosSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosSegActionPerformed(evt);
            }
        });

        jButtonMaisMin.setText("+");
        jButtonMaisMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaisMinActionPerformed(evt);
            }
        });

        jButtonMaisSeg.setText("+");
        jButtonMaisSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaisSegActionPerformed(evt);
            }
        });

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Escolha o Tempo para concluir o jogo");

        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldSegundos, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(jTextFieldMinutos))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jButtonMaisMin))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonMaisSeg)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonMenosSeg)
                                    .addComponent(jButtonMenosMin))))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel3)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonMenosMin)
                    .addComponent(jButtonMaisMin))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonMenosSeg)
                    .addComponent(jButtonMaisSeg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonMaisMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaisMinActionPerformed
        controllerTempo.operacoesMinutos("+");        
        jTextFieldMinutos.setText(String.valueOf(controllerTempo.getMinutos()));

    }//GEN-LAST:event_jButtonMaisMinActionPerformed

    private void jButtonMaisSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaisSegActionPerformed
        controllerTempo.operacoesSegundos("+");
        jTextFieldSegundos.setText(String.valueOf(controllerTempo.getSegundos()));
    }//GEN-LAST:event_jButtonMaisSegActionPerformed

    private void jButtonMenosMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosMinActionPerformed
        controllerTempo.operacoesMinutos("-");
        jTextFieldMinutos.setText(String.valueOf(controllerTempo.getMinutos()));
    }//GEN-LAST:event_jButtonMenosMinActionPerformed

    private void jButtonMenosSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosSegActionPerformed
        controllerTempo.operacoesSegundos("-");
        jTextFieldSegundos.setText(String.valueOf(controllerTempo.getSegundos()));
    }//GEN-LAST:event_jButtonMenosSegActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controllerTempo.operacaoTempo();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMinutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMinutosActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogConTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogConTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogConTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogConTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogConTempo dialog = new JDialogConTempo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonMaisMin;
    private javax.swing.JButton jButtonMaisSeg;
    private javax.swing.JButton jButtonMenosMin;
    private javax.swing.JButton jButtonMenosSeg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldMinutos;
    private javax.swing.JTextField jTextFieldSegundos;
    // End of variables declaration//GEN-END:variables

}
