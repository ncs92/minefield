/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.JDialogConTempo;

/**
 *
 * @author Maa - PC
 */
public class OperacaoNick {

    public void salvarNickTempo(Jogador j, String nick) {
        new JDialogConTempo(null, true).setVisible(true);
        Time t = (Time) Global.getObjeto();
        j.setTempo(t);
        j.setNome(nick);
        Global.setObjeto(null);
        Global.setObjeto(j);
    }

    public void salvarNick(Jogador j, String nick) {
        j.setNome(nick);
        j.setTempo(null);
        Global.setObjeto(j);
    }

}
