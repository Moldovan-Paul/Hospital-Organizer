package com.example.hospitalorganizer.controller;

import com.example.hospitalorganizer.dto.HospitalDto;
import com.example.hospitalorganizer.exception.HospitalNotFoundException;
import com.example.hospitalorganizer.model.Hospital;
import com.example.hospitalorganizer.service.HospitalService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
@Validated
public class HospitalController {

    private final HospitalService service;

    public HospitalController(HospitalService service) {
        this.service = service;
    }

    @GetMapping
    public List<HospitalDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public HospitalDto findById(@PathVariable int id) throws HospitalNotFoundException {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Hospital create(@Valid @RequestBody Hospital hospital) {
        return service.create(hospital);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Hospital hospital, @PathVariable int id) throws HospitalNotFoundException {
        service.update(hospital, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws HospitalNotFoundException {
        service.delete(id);
    }

    @GetMapping(value = "/filter/{capacity}")
    public List<Hospital> filterByMaximumCapacity(@PathVariable @Min(1) int capacity) {
        return service.filterByMaximumCapacity(capacity);
    }

    @GetMapping(value = "/statistics/orderbyage")
    public List<HospitalDto> orderByAverageAgeOfPatients() {
        return service.orderByAverageAgeOfPatients();
    }

}
