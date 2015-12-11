/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
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
    
   
    public void getSorteio(int cont, ArrayList<String> posZero, JButton campo[][], ArrayList<String> posBombas, ArrayList<String> abertos, int tam){
        operacao.sorteio(cont, posZero, campo, posBombas, abertos,tam);
    }
}
