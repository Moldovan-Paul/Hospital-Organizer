package com.example.hospitalorganizer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
    private int id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonBackReference(value = "hospital-shift-list")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonBackReference(value = "doctor-shift-list")
    private Doctor doctor;

    @Column(name = "date_and_time")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateAndTime;

    @Column(name = "description")
    private String description;

}