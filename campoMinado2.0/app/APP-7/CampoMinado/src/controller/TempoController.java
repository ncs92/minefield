/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Global;
import model.Time;

/**
 *
 * @author maa
 */
public class TempoController {

    Time tempo;

    public TempoController() {
        tempo = new Time();
    }

    public int getMinutos() {
        return tempo.getMinutos();
    }

    public int getSegundos() {
        return tempo.getSegundos();
    }

    public void operacoesMinutos(String op) {
        if (op.equals("+")) {
            tempo.adicionaMinutos();
        } else {
            tempo.diminuiMinutos();
        }
    }

    public void operacoesSegundos(String op) {
        if (op.equals("+")) {
            tempo.adicionaSegundos();
            
        } else {
            tempo.diminuiSegundos();
        }
    }

    public void operacaoTempo() {
        tempo.adicionaTempo();
        Global.setObjeto(tempo);
    }

}
