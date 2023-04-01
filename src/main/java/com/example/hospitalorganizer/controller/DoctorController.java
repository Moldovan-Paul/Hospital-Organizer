package com.example.hospitalorganizer.controller;

import com.example.hospitalorganizer.dto.DoctorDto;
import com.example.hospitalorganizer.exception.DoctorNotFoundException;
import com.example.hospitalorganizer.model.Doctor;
import com.example.hospitalorganizer.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@Validated
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping
    public List<DoctorDto> findAllDoctors() {
        return service.findAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor findById(@PathVariable int id) throws DoctorNotFoundException {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Doctor create(@Valid @RequestBody Doctor doctor) {
        return service.create(doctor);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Doctor doctor, @PathVariable int id) throws DoctorNotFoundException {
        service.update(doctor, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws DoctorNotFoundException {
        service.delete(id);
    }
}
