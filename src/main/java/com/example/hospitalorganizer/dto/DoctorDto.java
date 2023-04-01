package com.example.hospitalorganizer.dto;

import com.example.hospitalorganizer.model.Shift;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorDto {
    int id;
    String firstName;
    String lastName;
    String speciality;
    int yearsOfExperience;
    List<Shift> shifts;
}
