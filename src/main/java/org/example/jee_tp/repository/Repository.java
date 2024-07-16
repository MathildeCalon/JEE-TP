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

    public void create(T entity) { session.save(entity); }
    public void update(T entity) { session.update(entity); }
    public void delete(T entity) { session.delete(entity); }

    abstract T getById(int id);

    public List<T> getAll(Class<T> classe){
        String query = "FROM " + classe.getSimpleName();
        session = sessionFactory.openSession();
        Query typedQuery = session.createQuery(query, classe);
        List<T> list = typedQuery.getResultList();
        session.close();
        return list;
    }
}
