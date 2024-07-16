package org.example.jee_tp.services;

import org.example.jee_tp.model.Consultation;
import org.example.jee_tp.model.Patient;
import org.example.jee_tp.repository.ConsultationRepository;
import org.example.jee_tp.repository.PatientRepository;

import java.time.LocalDate;
import java.util.List;

public class ConsultationService {
    private PatientRepository patientRepository = new PatientRepository();
    private ConsultationRepository consultationRepo = new ConsultationRepository();

    public Consultation getConsultation(int id){
        return consultationRepo.getById(Consultation.class, id);
    }

    public void addConsultation(LocalDate date, String doctorName, String instruction, String caresheet, int id_patient){
        Patient patient = patientRepository.getById(Patient.class, id_patient);
        consultationRepo.create(Consultation.builder()
                        .date(date)
                        .doctorName(doctorName)
                        .instruction(instruction)
                        .careSheet(caresheet)
                        .patient(patient)
                        .build());
    }

    public List<Consultation> getAllConsultations(){
        return consultationRepo.getAll(Consultation.class);
    }
}
