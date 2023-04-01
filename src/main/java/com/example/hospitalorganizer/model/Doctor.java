package com.example.hospitalorganizer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "doctors")
public class Doctor {
        @Id
        @Column(name = "id")
        int id;
        @Column(name = "firstName")
        @NotBlank(message = "Please input first name.")
        String firstName;
        @NotBlank(message = "Please input last name.")
        @Column(name = "lastName")
        String lastName;
        @Column(name = "speciality")
        @NotBlank(message = "Please input specialty name.")
        String speciality;
        @Column(name = "yearsOfExperience")
        @Min(value = 1, message = "Please input years of experience.")
        int yearsOfExperience;

        @OneToMany(mappedBy = "doctor")
        @JsonManagedReference(value = "doctor-shift-list")
        List<Shift> shifts;
}
