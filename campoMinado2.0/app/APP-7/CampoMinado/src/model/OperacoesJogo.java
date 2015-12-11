/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.Jogo;
import view.Principal;

/**
 *
 * @author Maa - PC
 */
public class OperacoesJogo {

    public void dica(int pontos, int dica, int totalClicado, ArrayList<String> posZero, ArrayList<String> posBombas, ArrayList<String> abertos, Partida p, JButton campo[][], ArrayList<String> mapa) {
        pontos -= 10;
        ArrayList<String> lista = new ArrayList<String>();
        Font fonte = new Font("Serif", Font.BOLD, 20);
        int i = 0, j = 0;
        String posicao;
        if (dica < 10) {
            totalClicado++;
            boolean continuar = true;
            Random gerador = new Random();
            while (continuar == true) {
                i = gerador.nextInt(p.getCampo().getTamanho() - 1);
                j = gerador.nextInt(p.getCampo().getTamanho() - 1);
                posicao = String.valueOf(i) + String.valueOf(j);
                if (posZero.contains(posicao)) {
                    continuar = true;
                } else if (posBombas.contains(posicao)) {
                    continuar = true;
                } else if (abertos.contains(posicao)) {
                    continuar = true;
                } else if (mapa.contains(posicao)) {

                    continuar = true;
                } else if (campo[i][j].getName().equals("0") || campo[i][j].getName().equals("99") || campo[i][j].getIcon() != null) {
                    continuar = true;
                } else {

                    continuar = false;
                    dica++;
                }

            }
            campo[i][j].setOpaque(false);
            campo[i][j].setBorderPainted(false);
            campo[i][j].setContentAreaFilled(false);
            campo[i][j].setFont(fonte);
            campo[i][j].setContentAreaFilled(false);
            campo[i][j].setText(campo[i][j].getName());
            campo[i][j].setForeground(Color.red);

        } else {
            JOptionPane.showMessageDialog(null, "Você excedeu a quantidade de dicas!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sorteio(int cont, ArrayList<String> posZero, JButton campo[][], ArrayList<String> posBombas, ArrayList<String> abertos, int tam) {
        Random gerador = new Random();
        cont += posZero.size();
        Font fonte = new Font("Serif", Font.BOLD, 20);
        for (int k = 0; k < posZero.size(); k++) {
            int i = Integer.parseInt(posZero.get(k).split(" ")[0]);
            int j = Integer.parseInt(posZero.get(k).split(" ")[1]);
            campo[i][j].setOpaque(false);
            campo[i][j].setBorderPainted(false);
            campo[i][j].setContentAreaFilled(false);
            String posicao = String.valueOf(i) + String.valueOf(j);
            abertos.add(posicao);
        }
        double abrir = tam * 0.20;
        while (abrir > 0) {
            int i = gerador.nextInt(tam - 1);
            int j = gerador.nextInt(tam - 1);
            String aux = String.valueOf(i) + String.valueOf(j);
            if (!posZero.contains(aux) && !abertos.contains(aux) && !posBombas.contains(aux)) {
                abrir--;
                campo[i][j].setOpaque(false);
                campo[i][j].setBorderPainted(false);
                campo[i][j].setFont(fonte);
                campo[i][j].setContentAreaFilled(false);
                campo[i][j].setText(campo[i][j].getName());
                campo[i][j].setForeground(Color.red);
                campo[i][j].setEnabled(false);
                abertos.add(aux);
            }
        }
    }

    public boolean ehVazio(int i, int j, ArrayList<String> posZero) {
        for (int k = 0; k < posZero.size(); k++) {
            int l = Integer.parseInt(posZero.get(k).split(" ")[0]);
            int m = Integer.parseInt(posZero.get(k).split(" ")[1]);
            if (i == l && m == j) {
                return true;
            }
        }
        return false;
    }

    public void caraBotoes(String bt, ArrayList<String> posBombas, int tam, JButton campo[][]) {

        if (bt.equals("0")) {
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
        }

    }

    public void inicializa(int cont, ArrayList<String> posZero, JButton[][] campo, ArrayList<String> posBombas, ArrayList<String> abertos, int tam) {
        if (cont == 0) { /// caso seja o primeiro a clicar entra nesse
            int i = 0, j = 0;
            for (int k = 0; k < posZero.size(); k++) {
                i = Integer.parseInt(posZero.get(k).split(" ")[0]);
                j = Integer.parseInt(posZero.get(k).split(" ")[1]);
                campo[i][j].setOpaque(false);
                campo[i][j].setBorderPainted(false);
                campo[i][j].setContentAreaFilled(false);
            }
            sorteio(cont, posZero, campo, posBombas, abertos, tam);
            cont++;

        }
    }

    public ImageIcon geraIconeBandeira(int qtdBandeira, ArrayList<String> posBombas, int cont, int tam, ImageIcon icon) {

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
//            botaoClicado.setIcon(icon);
        }
        return icon;
    }

    public void adicionaListenerMouse(int tam, JButton campo[][], MouseAdapter al) {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                campo[i][j].addMouseListener(al);
            }
        }
    }

    public void geraBomba(double quantidadeBombas, ArrayList<String> posBombas, int tam, JButton[][] campo) {

        for (int k = 0; k < quantidadeBombas; k++) {
            int i = 0, j = 0;
            String aux = "";
            if (posBombas.isEmpty()) {
                Random gerador = new Random();
                i = gerador.nextInt(tam - 1);
                j = gerador.nextInt(tam - 1);
                aux = String.valueOf(i) + " " + String.valueOf(j);
                campo[i][j].setName("0");
                posBombas.add(aux);
                System.out.println(i + " " + j);
            } else {
                while (posBombas.contains(aux) || aux.equals("")) {
                    Random gerador = new Random();
                    i = gerador.nextInt(tam - 1);
                    j = gerador.nextInt(tam - 1);
                    aux = String.valueOf(i) + " " + String.valueOf(j);
                }
                campo[i][j].setName("0");
                posBombas.add(aux);
                System.out.println(i + " " + j);
            }
        }
    }

    public void escolheMapa(Partida p, double quantidadeMapa, int tam, JButton[][] campo, ArrayList<String> mapa) {
        if (!p.getCampo().getMapa().equals("Normal")) {

            for (int k = 0; k < quantidadeMapa; k++) {
                while (true) {
                    Random gerador = new Random();
                    int i = gerador.nextInt(tam - 1);
                    int j = gerador.nextInt(tam - 1);
                    String posicao = String.valueOf(i) + String.valueOf(j);
                    if (!campo[i][j].getName().equals("0")) {
                        if (p.getCampo().getMapa().equals("Floresta")) {
                            if (tam == 4) {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/4x4-flor.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            } else if (tam == 8) {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/8x8-flor.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            } else if (tam == 16) {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/16x16-flor.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            } else {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/perso-flor.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            }
                        } else if (p.getCampo().getMapa().equals("Cidade")) {
                            if (tam == 4) {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/4x4-home.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            } else if (tam == 8) {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/8x8-home.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            } else if (tam == 16) {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/16x16-home.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            } else {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/perso-home.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            }
                        } else if (p.getCampo().getMapa().equals("Pedreira")) {
                            if (tam == 4) {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/4x4-parede.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            } else if (tam == 8) {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/8x8-parede.png"));
//                                ImageIcon icon = new ImageIcon("/Users/nani/Desktop/APP/CampoMinado/src/img/8x8-parede.png");
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            } else if (tam == 16) {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/16x16-parede.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            } else {
                                ImageIcon icon = new ImageIcon(getClass().getResource("/img/perso-parede.png"));
                                campo[i][j].setIcon(icon);
                                campo[i][j].setName("1");
                                campo[i][j].setEnabled(false);
                                mapa.add(posicao);
                                break;
                            }
                        }
                    }

                }
            }
        }
    }

    public void colocaValorNosBotoes(int tam, JButton[][] campo, ArrayList<String> posZero) {
        for (int i = 0; i < tam; i++) {///////////////// PERCORRE O TABULEIRO ////////////////////////
            for (int j = 0; j < tam; j++) { //////////// PERCORRE O TABULEIRO /////////////////
                //    System.out.println("i :"+i);
                //      System.out.println("j :"+j);
                if (!campo[i][j].getName().equals("0") && !campo[i][j].getName().equals("1")) {/////////////////SO VERIFICA O VALOR SE NAO FOR UMA BOMBA ///////
                    int bomba = 0; /// QUANTIDADE DE BOMBAS AO REDOR ////
                    /////////////// VERIFICA A PRIMEIRA LINHA DA TABELA ///////////// 
                    if (i == 0) { // as bordas da matriz
                        if (j == 0) {
                            if (campo[i][j + 1].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i + 1][j].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i + 1][j + 1].getName().equals("0")) {
                                bomba++;
                            }
                            //    System.out.println("\n bbb "+bomba);
                        } else if (j == tam - 1) {

                            if (campo[i][j - 1].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i + 1][j].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i + 1][j - 1].getName().equals("0")) {
                                bomba++;
                            }
                        } else {
                            if (campo[i][j - 1].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i][j + 1].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i + 1][j].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i + 1][j - 1].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i + 1][j + 1].getName().equals("0")) {
                                bomba++;
                            }
                        }
                    } /////////////////////////////////////////////////////////////////
                    ////////////////////////VERIFICA A ULTIMA LINHA DA TABELA ///////////////////////////////
                    else if (i == tam - 1) { // as bordas da matriz
                        if (j == 0) {
                            if (campo[i][j + 1].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i - 1][j].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i - 1][j + 1].getName().equals("0")) {
                                bomba++;
                            }
                        } else if (j == tam - 1) {

                            if (campo[i][j - 1].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i - 1][j].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i - 1][j - 1].getName().equals("0")) {
                                bomba++;
                            }
                        } else {
                            if (campo[i][j - 1].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i][j + 1].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i - 1][j].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i - 1][j - 1].getName().equals("0")) {
                                bomba++;
                            }
                            if (campo[i - 1][j + 1].getName().equals("0")) {
                                bomba++;
                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////
                    ///////////////////////////VERIFICA A PRIMEIRA COLUNA DA TABELA///////////////////////////
                    if (j == 0 && i != 0 && i != tam - 1) {
                        if (campo[i][j + 1].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i - 1][j].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i - 1][j + 1].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i + 1][j].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i + 1][j + 1].getName().equals("0")) {
                            bomba++;
                        }
                    } /////////////////////////////////////////////////////////////////////
                    ///////////////////////////VERIFICA A ULTIMA COLUNA DA TABELA////////////////////////////////
                    else if (j == tam - 1 && i != 0 && i != tam - 1) {

                        if (campo[i][j - 1].getName().equals("0")) {
                            bomba++;
                        }
                        //   System.out.println("i-1 :"+(i-1));
                        if (campo[i - 1][j].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i - 1][j - 1].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i + 1][j - 1].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i + 1][j].getName().equals("0")) {
                            bomba++;
                        }
                    }
                    ////////////////////////////////////////////////////////////////////
                    /////////////////////////////VERIFICA CASOS NORMAIS///////////////////////////////////
                    if (!(i == 0 || i == tam - 1 || j == 0 || j == tam - 1)) {
                        if (campo[i][j + 1].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i][j - 1].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i - 1][j - 1].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i - 1][j].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i - 1][j + 1].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i + 1][j - 1].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i + 1][j].getName().equals("0")) {
                            bomba++;
                        }
                        if (campo[i + 1][j + 1].getName().equals("0")) {
                            bomba++;
                        }

                    }
                    /////////////////////////////////////////////////////////////
                    // System.out.println("bomba :"+bomba);
                    //   campo.addActionListener(this);
                    if (bomba == 0) {
                        String aux = String.valueOf(i) + " " + String.valueOf(j);
                        posZero.add(aux);
                        campo[i][j].setName("99");
                        System.out.println("\n" + i + " " + j + " Entrou");
                    } else {
                        campo[i][j].setForeground(Color.RED);
                        campo[i][j].setName(String.valueOf(bomba));
                    }

                }
            }
        }

        int total = 0;
        if (campo[0][1].getName().equals("0")) {
            total++;
        }
        if (campo[1][0].getName().equals("0")) {
            total++;
        }
        if (campo[1][1].getName().equals("0")) {
            total++;
        }
        if (total != 0) {
            campo[0][0].setName(String.valueOf(total));
        } else {
            String aux = String.valueOf(0) + " " + String.valueOf(0);
            campo[0][0].setName(String.valueOf("99"));
            posZero.add(aux);
        }
        System.out.println("\n -------------- pos --------------");
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo.length; j++) {
                System.out.println("\n ------");
                System.out.println("\n " + i + " " + " " + j + " : " + campo[i][j].getName());
            }
        }
        System.out.println("\n -----------------");
        System.out.println("\n --------------- Bombas ---------------");
//        System.out.println(posBombas.toString());
        System.out.println("\n ----------------------------------------------");
        System.out.println("\n ------------------ vazio -------------------------");
        System.out.println(posZero.toString());
        System.out.println("\n ----------------------------------------------");

    }
}
