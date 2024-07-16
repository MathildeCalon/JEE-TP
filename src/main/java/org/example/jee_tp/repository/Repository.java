package org.example.jee_tp.repository;

import org.example.jee_tp.utils.SessionFactorySingleton;
import org.hibernate.Session;

import java.util.List;

public abstract class Repository<T> {
    private SessionFactorySingleton sessionFactory;
    private Session session;

    public Repository() {
        sessionFactory = (SessionFactorySingleton) SessionFactorySingleton.getSessionFactory();
    }

    public void create(T entity) { session.save(entity); }
    public void update(T entity) { session.update(entity); }
    public void delete(T entity) { session.delete(entity); }

    abstract T getById(int id);
    abstract List<T> getAll();
}
