package org.example.jee_tp.services;

import org.example.jee_tp.model.Patient;
import org.example.jee_tp.repository.PatientRepository;

import java.time.LocalDate;
import java.util.List;

public class PatientService {
    private PatientRepository patientRepository = new PatientRepository();

    public Patient getPatient(int id) {
        return patientRepository.getById(Patient.class, id);
    }

    public void addPatient(String firstname, String lastname, LocalDate birthdate) {
        patientRepository.create(Patient.builder()
                        .firstname(firstname)
                        .lastname(lastname)
                        .birthdate(birthdate)
                        .build());
    }

    public List<Patient> getAllPatients() {
        return patientRepository.getAll(Patient.class);
    }
}
