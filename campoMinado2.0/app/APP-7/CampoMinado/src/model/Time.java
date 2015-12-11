/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nani
 */
@Entity
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int minutos;
    @Column
    private int segundos;

    public Time() {
    }

    public Time(int minutos, int segundos) {
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Time other = (Time) obj;
        if (this.minutos != other.minutos) {
            return false;
        }
        if (this.segundos != other.segundos) {
            return false;
        }

        return true;
    }

    public void adicionaMinutos() {
        this.minutos += 1;
    }

    public void diminuiMinutos() {
        this.minutos -= 1;
    }

    public void adicionaSegundos() {
        this.setSegundos(getSegundos() + 1);        
    }

    public void diminuiSegundos() {
        this.setSegundos(getSegundos() - 1);
    }

    public void adicionaTempo() {
        if (this.minutos < 0 || this.segundos < 0) {
            this.minutos = 1;
            this.segundos = 1;
        }
//        Time t = new Time(minutos, segundos);
//        Global.setObjeto(tempo);
    }

    @Override
    public String toString() {
        return "Time{" + "minutos=" + minutos + ", segundos=" + segundos + '}';
    }

}
