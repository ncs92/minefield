/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.jndi.toolkit.ctx.PartialCompositeContext;

/**
 *
 * @author Maa - PC
 */
public class OperacaoPrincipal {

    private Partida p;
    private Jogador j;
    private Campo c;    
    
    public void inicializarParatida(String mapa, int tamanho){
        p = new Partida();
        j = (Jogador) Global.getObjeto();
        p.setJogador(j);
        
        Campo c = new Campo();
        c.setMapa(mapa);
        c.setTamanho(tamanho);
        
        p.setCampo(c);
        p.setJogador(j);
        
        Global.setObjeto(null);
        Global.setObjeto(p);
    }

}
