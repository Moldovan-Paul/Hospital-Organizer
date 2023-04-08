package com.example.hospitalorganizer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
        private int id;
        @Column(name = "name")
        private String name;
        @Column(name = "address")
        private String address;
        @Column(name = "specialties")
        private String specialties;
        @Column(name = "privateHospital")
        private boolean privateHospital;
        @Column(name = "takesEmergencies")
        private boolean takesEmergencies;
        @Column(name = "maximumCapacity")
        private int maximumCapacity;

        @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonManagedReference(value = "patient-list")
        private List<Patient> patients;

        @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonManagedReference(value = "hospital-shift-list")
        private List<Shift> shifts;
}

