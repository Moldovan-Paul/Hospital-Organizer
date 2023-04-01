package com.example.hospitalorganizer.dto;

import com.example.hospitalorganizer.model.Shift;
import com.example.hospitalorganizer.model.Patient;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HospitalDto {
    int id;
    String name;
    String address;
    String specialties;
    boolean privateHospital;
    boolean takesEmergencies;
    int maximumCapacity;
    List<Integer> patientIds;
    List<Patient> patients;
    List<Shift> shifts;
    double averageAge;
}
