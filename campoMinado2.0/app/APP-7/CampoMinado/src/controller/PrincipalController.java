/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.Campo;
import model.Jogador;
import model.OperacaoPrincipal;
import model.Partida;
import view.Nickname;

/**
 *
 * @author maa
 */
public class PrincipalController {

    private OperacaoPrincipal operacao;

    public PrincipalController() {
        operacao = new OperacaoPrincipal();
    }

    public void inicializar(String mapa, int tamanho) {
        new Nickname(null, true).setVisible(true);
        operacao.inicializarParatida(mapa, tamanho);
    }

    public void personalizado(String mapa) {
        new Nickname(null, true).setVisible(true);
        int tamanho = 0;
        
        tamanho = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite um número inteiro para o tamanho da matriz do tabuleiro "));
        while (tamanho > 20) {
            tamanho = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite um número inteiro menor que 20"));
        }
        operacao.inicializarParatida(mapa, tamanho);
    }

}
