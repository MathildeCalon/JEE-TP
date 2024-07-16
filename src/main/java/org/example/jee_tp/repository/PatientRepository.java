package org.example.jee_tp.repository;

import jakarta.persistence.Query;
import org.example.jee_tp.model.Patient;

import java.util.List;

public class PatientRepository extends Repository<Patient> {
    public List<Patient> getByName(String name) {
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from " + Patient.class +" where" + Patient.class + ".lastname= :name",
                    Patient.class);
            query.setParameter("name", name);
            System.out.println("query: " + query);
            List<Patient> results = query.getResultList();
            return results;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
