package model;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DAOGeneric<T> {

    private static EntityManager em;

    public DAOGeneric(EntityManager entityM) {
        em = entityM;
    }

    public void insert(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void remove(T entity) {
  
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
        return clazz;
    }

    public List<T> list() {
        return em.createQuery("SELECT c FROM " + getTypeClass().getSimpleName() + " c").getResultList();
    }
    /* public List<T> listByTitulo(String titulo) {
     return em.createQuery("SELECT e FROM "+clazz.getSimpleName()+" e WHERE e.titulo LIKE '%"+titulo+"%'").getResultList();
     }*/

}
