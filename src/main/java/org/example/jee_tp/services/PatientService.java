package org.example.jee_tp.services;

import org.example.jee_tp.model.Patient;
import org.example.jee_tp.repository.PatientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class PatientService {
    private PatientRepository patientRepository = new PatientRepository();
    private Session session;

    public Patient getPatient(int id) {
        Patient patient = null;
        try {
            patient = patientRepository.getById(id);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return patient;
    }

    public boolean addPatient(String firstname, String lastname, LocalDate birthdate) {
        boolean result = false;
        session = sessionFactory.openSession();
        session.beginTransaction();
        Patient patient = Patient.builder()
                .firstname(firstname)
                .lastname(lastname)
                .birthdate(birthdate)
                .build();
        try {
            patientRepository.create(patient);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = null;
        session = sessionFactory.openSession();
        try {
            patients = patientRepository.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return patients;
    }
}
