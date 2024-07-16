package org.example.jee_tp.repository;

import jakarta.persistence.Query;
import org.example.jee_tp.utils.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class Repository<T> {
    protected SessionFactory sessionFactory;
    protected Session session;

    public Repository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public boolean create(T entity) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public void update(T entity) {
        session.update(entity);
    }

    public void delete(T entity) {
        session.delete(entity);
    }

    public T getById(Class<T> classe, int id){
        try {
            session = sessionFactory.openSession();
            T entity = session.get(classe, id);
            return entity;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    };


    public List<T> getAll(Class<T> classe) {
        String query = "FROM " + classe.getSimpleName();
        session = sessionFactory.openSession();
        Query typedQuery = session.createQuery(query, classe);
        List<T> list = typedQuery.getResultList();
        session.close();
        return list;
    }
}
