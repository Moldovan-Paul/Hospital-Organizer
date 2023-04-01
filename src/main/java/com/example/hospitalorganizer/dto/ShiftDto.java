package com.example.hospitalorganizer.dto;

import com.example.hospitalorganizer.model.Doctor;
import com.example.hospitalorganizer.model.Hospital;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShiftDto {
    int id;
    Optional<Integer> hospitalId;
    Optional<Integer> doctorId;
    Hospital hospital;
    Doctor doctor;
    @JsonFormat(pattern="dd-MM-yyyy")
    Date dateAndTime;
    String description;

    public void makeHospitalConsultationsNull() {
        hospital.setShifts(null);
    }

    public void makeDoctorlConsultationsNull() {
        doctor.setShifts(null);
    }
}
