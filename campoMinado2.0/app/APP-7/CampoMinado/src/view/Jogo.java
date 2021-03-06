/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.JogoController;
import model.Global;
import model.Jogador;
import model.Partida;
import model.Time;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.DAOGeneric;
//import model.DAOPartida;

/**
 *
 * @author nani
 */
public final class Jogo extends javax.swing.JDialog implements ActionListener {

    private int id;
    private Partida p = (Partida) Global.getObjeto();
    private boolean acertouBomba = false;
    private JButton campo[][];
    private int cont = -1;
    private int contA = 0;
    private int tam = p.getCampo().getTamanho();
    private int qtdBandeira = 0;
    private int totalClicado = 0;
    private double quantidadeBombas = (p.getCampo().getTamanho() * p.getCampo().getTamanho()) * 0.10;
    private double quantidadeMapa = (p.getCampo().getTamanho() * p.getCampo().getTamanho()) * 0.10;
    private int qtdJogo = 0;
    private int dica = 0;
    private int pontos = 100;
    private final ArrayList<String> posBombas = new ArrayList<>();
    private final ArrayList<String> posZero = new ArrayList<>();
    private final ArrayList<String> mapa = new ArrayList<>();
    private final ArrayList<String> abertos = new ArrayList<>();
    private int contador;
    private boolean executaTempo;
    private JogoController controllerJogo;

    public Jogo(java.awt.Frame parent, boolean modal) throws IOException, URISyntaxException {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.getHSBColor(34, 100, 34));
        this.setLocationRelativeTo(null);
        controllerJogo = new JogoController();

        criaCampo(p.getCampo().getTamanho());

        executaTempo = true;
        if (p.getJogador().getTempo() != null) {
            int min = p.getJogador().getTempo().getMinutos();
            int seg = p.getJogador().getTempo().getSegundos();
            int tempo = (min * 60) + seg;
            contador = tempo;
            tempo();
        }

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jButtonDica = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextFieldTime = new javax.swing.JTextField();
        jPanel1 = new componentes.UJPanelImagem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelBomba = new javax.swing.JLabel();
        jButtonVitorias = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelTotalB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/smile.png"))); // NOI18N
        jButton4.setText("Novo Jogo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButtonDica.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1445032785_Tip_of_the_day.png"))); // NOI18N
        jButtonDica.setText("Dica");
        jButtonDica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDicaActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1445032707_pause-circle-fill.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1445032746_circle_help_question-mark_.png"))); // NOI18N
        jButton7.setText("Ajuda");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1445033117_time-24.png"))); // NOI18N
        jButton8.setEnabled(false);
        jButton8.setMargin(new java.awt.Insets(2, 14, 2, 0));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextFieldTime.setEditable(false);
        jTextFieldTime.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldTime.setForeground(new java.awt.Color(204, 0, 0));
        jTextFieldTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTime.setMargin(new java.awt.Insets(2, 0, 2, 2));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Nome :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("jLabel2");

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1445032724_play-circle-fill.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("Bombas :");
        jLabel3.setName("bomba"); // NOI18N

        jLabelBomba.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelBomba.setForeground(new java.awt.Color(0, 204, 0));
        jLabelBomba.setName("jBomba"); // NOI18N

        jButtonVitorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trophy.png"))); // NOI18N
        jButtonVitorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVitoriasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Total bombas :");

        jLabelTotalB.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabelTotalB.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(216, 216, 216)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelBomba, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelTotalB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonVitorias))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDica, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(5, 5, 5)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonDica, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabelBomba, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVitorias)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabelTotalB, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        new Principal(null, true).setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonDicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDicaActionPerformed
//        dica();
        controllerJogo.getDicas(pontos, dica, totalClicado, posZero, posBombas, abertos, p, campo, mapa);
    }//GEN-LAST:event_jButtonDicaActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        if (!executaTempo) {
            executaTempo = true;
            tempo();
        } else {
            System.out.println("Já esta executando");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        executaTempo = false;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonVitoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVitoriasActionPerformed
        DAOGeneric dao = null;
        ArrayList<Partida> lista = new ArrayList<>();
        lista = (ArrayList<Partida>) dao.list();
        String aux = String.valueOf(lista.get(0).getJogador().getNome() + " " + lista.get(0).getJogador().getPontuacao());
        JOptionPane.showMessageDialog(null, aux, "Maior Resultado : ", JOptionPane.OK_OPTION);
    }//GEN-LAST:event_jButtonVitoriasActionPerformed
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        Global.setObjeto(null);
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
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Jogo dialog = null;
                try {
                    dialog = new Jogo(new javax.swing.JFrame(), true);
                } catch (IOException ex) {
                    Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonDica;
    private javax.swing.JButton jButtonVitorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelBomba;
    private javax.swing.JLabel jLabelTotalB;
    private componentes.UJPanelImagem jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldTime;
    // End of variables declaration//GEN-END:variables

    public void criaCampo(int tam) throws IOException, URISyntaxException {

        campo = new JButton[tam][tam];

        int posHorizontal = 0;
        int posVertical = 0;
        int tamHorizontal = 813 / tam;
        int tamVertical = 492 / tam;
        int cont = 0;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                campo[i][j] = new JButton("");
                if (posHorizontal >= 800) {
                    posHorizontal = 0;
                    posVertical += tamVertical;
                }
                if (posVertical >= 480) {
                    break;
                }
                campo[i][j].setName(String.valueOf(cont++));
                campo[i][j].setLocation(posHorizontal, posVertical);
                campo[i][j].setSize(tamHorizontal, tamVertical);
                posHorizontal += tamHorizontal;

                campo[i][j].setBackground(Color.WHITE);
                jPanel1.add(campo[i][j]);
                jPanel1.repaint();

            }
        }
        montaJogo(tam);

    }

    public void montaJogo(int tam) {
        JButton vet = new JButton();

        MouseAdapter al;
        jLabel2.setText(p.getJogador().getNome());

        al = new MouseAdapter() {
            public void actionPerformed(ActionEvent e) {
            }
            private void sorteio() {
                controllerJogo.getSorteio(cont, posZero, campo, posBombas, abertos, tam);
            }

            private boolean ehVazio(int i, int j) {
               return controllerJogo.getVazio(i, j, posZero);
            }
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                JButton botaoClicado = (JButton) e.getSource();

                if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
                    cont++;

                    System.out.println("\n cont :" + cont);
                    Font fonte = new Font("Serif", Font.BOLD, 20);

                    //////////////////////Clicou nas bombas ////////////////////
                    
                    if (botaoClicado.getIcon() == null && botaoClicado.isEnabled()) {
                        System.out.println("\n Botao name :" + botaoClicado.getName());
                        
                        if (botaoClicado.getName().equals("0")) {
                            for (int k = 0; k < posBombas.size(); k++) {
                                int i = Integer.parseInt(posBombas.get(k).split(" ")[0]);
                                int j = Integer.parseInt(posBombas.get(k).split(" ")[1]);

                                if (tam == 4) {
                                    ImageIcon icon;
                                    if (campo[i][j].getIcon() == null) {
                                        icon = new ImageIcon(getClass().getResource("/img/4x4-bomb.png"));
                                    } else {
                                        icon = new ImageIcon(getClass().getResource("/img/flagB4.png"));
                                    }
                                    campo[i][j].setIcon(icon);
                                } else if (tam == 8) {
                                    ImageIcon icon;
                                    if (campo[i][j].getIcon() == null) {
                                        icon = new ImageIcon(getClass().getResource("/img/8x8-bomb.png"));
                                    } else {
                                        icon = new ImageIcon(getClass().getResource("/img/flagB3.png"));
                                    }
                                    campo[i][j].setIcon(icon);
                                } else if (tam == 16) {
                                    ImageIcon icon;
                                    if (campo[i][j].getIcon() == null) {
                                        icon = new ImageIcon(getClass().getResource("/img/16x16-bomb.png"));
                                    } else {
                                        icon = new ImageIcon(getClass().getResource("/img/flagB2.png"));
                                    }
                                    campo[i][j].setIcon(icon);
                                } else {
                                    ImageIcon icon;
                                    if (campo[i][j].getIcon() == null) {
                                        icon = new ImageIcon(getClass().getResource("/img/perso-bomb.png"));
                                    } else {
                                        icon = new ImageIcon(getClass().getResource("/img/flagB.png"));
                                    }
                                    campo[i][j].setIcon(icon);
                                }
                                campo[i][j].setOpaque(false);
                                campo[i][j].setBorderPainted(false);
                                campo[i][j].setContentAreaFilled(false);
                            }

                            //////////////////////////////////////////////////////voce perdeu
                            int op = JOptionPane.showConfirmDialog(null, "Você perdeu! Deseja continuar no jogo ?", "You Can Do It!!", JOptionPane.YES_NO_OPTION);
                            if (op == JOptionPane.YES_OPTION) {
                                executaTempo = false;
                                dispose();
                                new Principal(null, true).setVisible(true);
                            } else {
                                System.exit(0);

                            }
                        } else { ///// caso nao tenha clicado numa bomba entra nesse else
                            
                            if (cont == 0) { /// caso seja o primeiro a clicar entra nesse
                                int i = 0, j = 0;
                                for (int k = 0; k < posZero.size(); k++) {
                                    i = Integer.parseInt(posZero.get(k).split(" ")[0]);
                                    j = Integer.parseInt(posZero.get(k).split(" ")[1]);
                                    campo[i][j].setOpaque(false);
                                    campo[i][j].setBorderPainted(false);
                                    campo[i][j].setContentAreaFilled(false);
                                }
                                sorteio();
                                cont++;
                            }
                            
                            if (botaoClicado.getName().equals("99")) {
                                botaoClicado.setOpaque(false);
                                botaoClicado.setBorderPainted(false);
                                botaoClicado.setContentAreaFilled(false);
                                botaoClicado.setEnabled(false);

                            } else {
                                botaoClicado.setOpaque(false);
                                botaoClicado.setBorderPainted(false);
                                botaoClicado.setFont(fonte);
                                botaoClicado.setContentAreaFilled(false);
                                botaoClicado.setText(botaoClicado.getName());
                                botaoClicado.setForeground(Color.red);
                                botaoClicado.setEnabled(false);
                            }

                        }
                    }
                    if (p.getCampo().getMapa().equals("Normal")) {
                        totalClicado = cont + posBombas.size();

                    } else {
                        totalClicado = cont + Integer.parseInt(String.valueOf(quantidadeMapa)) + posBombas.size();

                    }

                    if (totalClicado == (tam * tam)) {
                        DAOGeneric dao = null;
                        p.getJogador().setPontuacao(pontos);
                        ArrayList<Partida> lista = null;
                        System.out.println("\n dao :"+dao.list().toString());
                        if(!dao.list().isEmpty()){                            
                        lista = (ArrayList) dao.list();
                        }
                        if (lista.isEmpty()) {
                            dao.insert(p);
                            
                        } else {
                            if (p.getJogador().getPontuacao() >= lista.get(0).getJogador().getPontuacao()) {
                                lista.add(p);

                                dao.update(p);
                            }
                        }
                        JOptionPane.showMessageDialog(null, pontos, "Pontuação!!", JOptionPane.OK_OPTION);

                        int op = JOptionPane.showConfirmDialog(null, "Você ganhou!! Deseja ir para o proximo nivel ?!", "You Winnn!!!", JOptionPane.YES_NO_OPTION);
                        if (op == JOptionPane.YES_OPTION) {
                            dispose();
                            new Principal(null, true).setVisible(false);
                            setDefaultCloseOperation(Jogo.EXIT_ON_CLOSE);

                        } else {
                            dispose();
                        }
                    }
                }

                if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
                    if (botaoClicado.isEnabled()) {
                        ImageIcon icon;
                        System.out.println("\n qtd bandeira :" + qtdBandeira);
                        System.out.println("\n qtd bombas :" + quantidadeBombas);
                        if (botaoClicado.getIcon() == null) {

                            if (qtdBandeira < posBombas.size()) {
                                qtdBandeira += 1;
                                cont++;
                                if (tam == 4) {
                                    icon = new ImageIcon(getClass().getResource("/img/flag4.png"));
                                } else if (tam == 8) {
                                    icon = new ImageIcon(getClass().getResource("/img/flag3.png"));
                                } else if (tam == 16) {
                                    icon = new ImageIcon(getClass().getResource("/img/flag2.png"));
                                } else {
                                    icon = new ImageIcon(getClass().getResource("/img/flag.png"));
                                }
                                botaoClicado.setIcon(icon);
                            }
                        } else {
                            qtdBandeira -= 1;
                            botaoClicado.setIcon(null);
                        }
                        jLabelBomba.setText(String.valueOf(qtdBandeira));
                    }
                }

            }

        };
        controllerJogo.inicializaMouseMatriz(tam, campo, al);

        /*GERA AS BOMBAS*/
        controllerJogo.bombas(quantidadeBombas, posBombas, tam, campo);
        
        /*ESCOLHE O MAPA*/        
        controllerJogo.montaMapa(p, quantidadeMapa, tam, campo, mapa);

        /*COLOCA O VALOR DOS BOTOES*/
        controllerJogo.inicializaBotoes(tam, campo, posZero);
    }

    private void tempo() {
        jTextFieldTime.setForeground(Color.red);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (executaTempo && contador > 0) {
                        int minutos = contador / 60;
                        int segundos = contador % 60;
                        jTextFieldTime.setText(" " + String.valueOf(minutos) + ":" + String.valueOf(segundos));
                        Thread.sleep(1000); // 1 segundo 
//                        System.out.println("executando contador : " + contador);
                        contador--;
                        if (minutos == 0 && segundos == 0) {
                            JOptionPane.showMessageDialog(null, "Você excedeu a quantidade de tempo!", "Alerta", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interromperam meu sono!");
                }
            }
        });
        thread.start();
        Global.setObjeto(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
//testando