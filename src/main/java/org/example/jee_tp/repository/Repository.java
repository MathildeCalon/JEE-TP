package org.example.jee_tp.repository;

import org.hibernate.Session;

import java.util.List;

public abstract class Repository<T> {
    protected Session session;
    public Repository(Session session) { session = session; }

    public void create(T entity) { session.save(entity); }
    public void update(T entity) { session.update(entity); }
    public void delete(T entity) { session.delete(entity); }

    abstract T getById(int id);
    abstract List<T> getAll();
}
