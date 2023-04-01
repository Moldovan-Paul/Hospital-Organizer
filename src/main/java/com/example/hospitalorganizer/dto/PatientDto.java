package com.example.hospitalorganizer.dto;

import com.example.hospitalorganizer.model.Hospital;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PatientDto {

    int id;
    String firstName;
    String lastName;
    int age;
    String symptomsDescription;
    String diagnosis;
    int hospitalId = 0;
    Hospital hospital;
    public void makePatientsListNull() {
        hospital.setPatients(null);
    }

    public void makeShiftsListNull() {
        hospital.setShifts(null);
    }
}