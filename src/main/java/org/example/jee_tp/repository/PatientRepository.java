package org.example.jee_tp.repository;

import org.example.jee_tp.model.Patient;
import org.hibernate.Session;

import java.util.List;

public class PatientRepository extends Repository<Patient> {
    public PatientRepository(Session session) { super(session);}

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
