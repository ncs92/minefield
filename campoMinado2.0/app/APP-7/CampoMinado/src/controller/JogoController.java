/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Campo;
import model.Global;
import model.OperacoesJogo;
import model.Partida;

/**
 *
 * @author maa
 */
public class JogoController {

    private OperacoesJogo operacao;

    public JogoController() {
        operacao = new OperacoesJogo();
    }

    public void getSorteio(int cont, ArrayList<String> posZero, JButton campo[][], ArrayList<String> posBombas, ArrayList<String> abertos, int tam) {
        operacao.sorteio(cont, posZero, campo, posBombas, abertos, tam);
    }
    
    public boolean getVazio(int i, int j, ArrayList<String> posZero){
       return operacao.ehVazio(i, j, posZero);
    }
    
    public void montaBotoes(String bt,  ArrayList<String> posBombas, int tam, JButton campo[][]){
        operacao.caraBotoes(bt, posBombas, tam, campo);
    }
    
    public void inicializaController(int cont, ArrayList<String> posZero, JButton [][] campo, ArrayList<String> posBombas, ArrayList<String> abertos, int tam){
        operacao.inicializa(cont, posZero, campo, posBombas, abertos, tam);
    }
    
    public ImageIcon iconeBandeiras(int qtdBandeira, ArrayList<String> posBombas, int cont, int tam, ImageIcon icon){
        icon = operacao.geraIconeBandeira(qtdBandeira, posBombas, cont, tam, icon);
        return icon;
    }
    
    public void inicializaMouseMatriz(int tam, JButton campo[][], MouseAdapter al){
        operacao.adicionaListenerMouse(tam, campo, al);
    }
    
    public void bombas(double quantidadeBombas, ArrayList<String> posBombas, int tam, JButton[][] campo){
        operacao.geraBomba(quantidadeBombas, posBombas, tam, campo);
    }
    
    public void montaMapa(Partida p, double quantidadeMapa, int tam, JButton [][] campo, ArrayList<String> mapa){
        operacao.escolheMapa(p, quantidadeMapa, tam, campo, mapa);
    }
    
    public void inicializaBotoes(int tam, JButton [][]campo,ArrayList<String> posZero ){
        operacao.colocaValorNosBotoes(tam, campo, posZero);
    }
    
    public void getDicas(int pontos, int dica, int totalClicado, ArrayList<String> posZero, ArrayList<String> posBombas, ArrayList<String> abertos, Partida p, JButton campo[][], ArrayList<String> mapa){
        operacao.dica(pontos, dica, totalClicado, posZero, posBombas, abertos, p, campo, mapa);
    }

}