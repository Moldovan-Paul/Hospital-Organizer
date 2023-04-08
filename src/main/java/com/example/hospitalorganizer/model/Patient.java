package com.example.hospitalorganizer.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private int age;
    @Column(name = "symptoms_description")
    private String symptomsDescription;
    @Column(name = "diagnosis", columnDefinition = "varchar(255) default 'To be decided'")
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonBackReference(value = "patient-list")
    private Hospital hospital;

}


