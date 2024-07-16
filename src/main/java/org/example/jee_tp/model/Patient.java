package org.example.jee_tp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String picture;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<Consultation> consultations;

    @Override
    public String toString() {
        return "Patient{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +'\'' +
                ", picture=" + picture +'\'' +
                ", consultations=" + consultations +
                '}';
    }
}
