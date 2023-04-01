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
@Table(name = "hospitals")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hospital{
        @Id
        @Column(name = "id")
        int id;
        @Column(name = "name")
        @NotBlank(message = "Please input name.")
        String name;
        @Column(name = "address")
        @NotBlank(message = "Please input address.")
        String address;
        @Column(name = "specialties")
        @NotBlank(message = "Please input specialties.")
        String specialties;
        @Column(name = "privateHospital")
        boolean privateHospital;
        @Column(name = "takesEmergencies")
        boolean takesEmergencies;
        @Column(name = "maximumCapacity")
        @Min(value = 1, message = "Please input a maximum capacity.")
        int maximumCapacity;

        @OneToMany(mappedBy = "h")
        @JsonManagedReference(value = "patient-list")
        List<Patient> patients;

        @OneToMany(mappedBy = "hospital")
        @JsonManagedReference(value = "hospital-shift-list")
        List<Shift> shifts;
}

