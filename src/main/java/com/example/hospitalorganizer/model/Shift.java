package com.example.hospitalorganizer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shifts")
public class Shift {
    @Id
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonBackReference(value = "hospital-shift-list")
    Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonBackReference(value = "doctor-shift-list")
    Doctor doctor;

    @Column(name = "date_and_time")
    @JsonFormat(pattern="dd-MM-yyyy")
    @NotNull(message = "Please input date and time.")
    Date dateAndTime;

    @Column(name = "description")
    @NotBlank(message = "Please input description.")
    String description;

}