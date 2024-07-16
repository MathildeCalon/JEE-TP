package org.example.jee_tp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String doctorName;
    private String instruction;
    private String careSheet;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @Override
    public String toString() {
        return "Consultation{" +
                "date=" + date +
                ", doctorName='" + doctorName + '\'' +
                ", instruction='" + instruction + '\'' +
                ", careSheet='" + careSheet + '\'' +
                '}';
    }
}
