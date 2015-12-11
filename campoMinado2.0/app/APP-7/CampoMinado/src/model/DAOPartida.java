/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import modelo.ConexaoHibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Maa - PC
 */
public class DAOPartida {

    public static boolean salvar(Partida p) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
            return true;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }

    }

    static boolean salvar(Partida p) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        Collection<Animal> a = p.getAnimal();

        try {
            tx = session.beginTransaction();
            for (Animal animal : a) {
                session.save(animal);
            }

            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    static Animal consultar(int idAnimal) {
        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        Animal a = null;
        try {
            Query q;
            tx = session.beginTransaction();
            q = (Query) session.createQuery("FROM Animal as a where a.idAnimal=:id");
            q.setParameter("id", idAnimal);
            List resultados = q.getResultList();

            if (resultados.size() > 0) {
                a = (Animal) resultados.get(0);
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {

            session.close();
        }
        return a;
    }

    static Collection<Animal> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static boolean alterar(Animal a) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }

    }

    static boolean excluir(Animal a) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(a);
            tx.commit();
            return true;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }
    }

    static boolean excluir(Pessoa p) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        Collection<Animal> a = p.getAnimal();
        try{
            tx = session.beginTransaction();
            for(Animal animal : a){
                session.delete(animal);
            }
            tx.commit();
            return true;
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

}
