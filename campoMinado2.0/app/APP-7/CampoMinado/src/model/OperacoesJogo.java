/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Font;
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

    public void dica(int pontos, int dica, int totalClicado, ArrayList<String> posZero, ArrayList<String> posBombas, ArrayList<String> abertos, Partida p, JButton campo[][], String mapa) {
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

}
