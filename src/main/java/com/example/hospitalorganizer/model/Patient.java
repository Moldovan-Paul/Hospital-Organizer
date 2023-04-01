package com.example.hospitalorganizer.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    int id;
    @Column(name = "first_name")
    @NotBlank(message = "Please input first name.")
    String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "Please input last name.")
    String lastName;
    @Column
    @Min(value = 1, message = "Please input age." )
    int age;
    @Column(name = "symptoms_description")
    @NotBlank(message = "Please input a description of symptoms.")
    String symptomsDescription;
    @Column(name = "diagnosis", columnDefinition = "varchar(255) default 'To be decided'")
    String diagnosis;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonBackReference(value = "patient-list")
    Hospital h;

}


