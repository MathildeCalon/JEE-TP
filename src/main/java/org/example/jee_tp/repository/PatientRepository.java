package org.example.jee_tp.repository;

import org.example.jee_tp.model.Patient;
import org.example.jee_tp.utils.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PatientRepository extends Repository<Patient> {
    private SessionFactory sessionFactory;
    private Session session;

    public PatientRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    @Override
    public Patient getById(int id) { return (Patient) session.get(Patient.class, id); }

    @Override
    public List<Patient> getAll() { return session.createQuery("from Patient").list(); }

    //TODO necessaire?
    @Override
    public void create(Patient patient) { session.save(patient); }
    @Override
    public void update(Patient patient) { session.update(patient); }
    @Override
    public void delete(Patient patient) { session.delete(patient); }
}
