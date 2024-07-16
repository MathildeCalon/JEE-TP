package org.example.jee_tp.services;

import jakarta.persistence.Query;
import org.example.jee_tp.model.Patient;
import org.example.jee_tp.repository.PatientRepository;

import java.time.LocalDate;
import java.util.List;

public class PatientService {
    private PatientRepository patientRepository = new PatientRepository();

    public Patient getPatient(int id) {
        return patientRepository.getById(Patient.class, id);
    }

    public List<Patient> getPatientByName(String name) {
        return patientRepository.getByName(name);
    }

    public void addPatient(String firstname, String lastname, LocalDate birthdate, String picture) {
        patientRepository.create(Patient.builder()
                        .firstname(firstname)
                        .lastname(lastname)
                        .birthdate(birthdate)
                        .picture(picture)
                        .build());
    }

    public List<Patient> getAllPatients() {
        return patientRepository.getAll(Patient.class);
    }
}
