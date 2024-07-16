package org.example.jee_tp.repository;

import jakarta.persistence.Query;
import org.example.jee_tp.model.Patient;

import java.util.List;

public class PatientRepository extends Repository<Patient> {

    @Override
    public Patient getById(int id) { return (Patient) session.get(Patient.class, id); }

    //TODO necessaire?
    @Override
    public void create(Patient patient) { session.save(patient); }
    @Override
    public void update(Patient patient) { session.update(patient); }
    @Override
    public void delete(Patient patient) { session.delete(patient); }
}
