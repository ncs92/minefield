/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

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
    @Column
    private int milisegundos;

    public Time() {
    }

    public Time(int minutos, int segundos, int milisegundos) {
        this.minutos = minutos;
        this.segundos = segundos;
        this.milisegundos = milisegundos;
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

    public int getMilisegundos() {
        return milisegundos;
    }

    public void setMilisegundos(int milisegundos) {
        this.milisegundos = milisegundos;
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
        if (this.milisegundos != other.milisegundos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Time{" + "minutos=" + minutos + ", segundos=" + segundos + ", milisegundos=" + milisegundos + '}';
    }
    
    
}
