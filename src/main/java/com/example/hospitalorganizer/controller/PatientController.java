package com.example.hospitalorganizer.controller;

import com.example.hospitalorganizer.dto.PatientDto;
import com.example.hospitalorganizer.exception.PatientNotFoundException;
import com.example.hospitalorganizer.model.Patient;
import com.example.hospitalorganizer.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@Validated
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    public List<PatientDto> findAllPatients() {
        return service.findAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDto findById(@PathVariable int id) throws PatientNotFoundException {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Patient create(@Valid @RequestBody Patient patient) {
        return service.create(patient);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Patient patient, @PathVariable int id) throws PatientNotFoundException {
        service.update(patient, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws PatientNotFoundException {
        service.delete(id);
    }
}
