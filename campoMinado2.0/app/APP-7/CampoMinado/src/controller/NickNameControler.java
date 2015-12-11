/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.Global;
import model.Jogador;
import model.OperacaoNick;
import model.Time;
import view.JDialogConTempo;

/**
 *
 * @author maa
 */
public class NickNameControler {

    Jogador j;
    OperacaoNick operacao = new OperacaoNick();

    public NickNameControler() {
        j = new Jogador();
    }
    public void salvarNick(String nick) {

        int tempo = JOptionPane.showConfirmDialog(null, "Deseja jogar com tempo limite ?!", "Tempo!", JOptionPane.YES_NO_OPTION);
        if (tempo == JOptionPane.YES_OPTION) {
            operacao.salvarNickTempo(j, nick);

        } else {
            operacao.salvarNick(j, nick);
        }

    }

}
