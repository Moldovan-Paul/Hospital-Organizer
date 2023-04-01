package com.example.hospitalorganizer.controller;

import com.example.hospitalorganizer.dto.ShiftDto;
import com.example.hospitalorganizer.dto.StatsDto;
import com.example.hospitalorganizer.exception.ConsultationNotFoundException;
import com.example.hospitalorganizer.model.Shift;
import com.example.hospitalorganizer.service.ShiftService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shifts")
@Validated
public class ShiftController {

    private final ShiftService service;

    public ShiftController(ShiftService service) {
        this.service = service;
    }

    @GetMapping
    public List<ShiftDto> findAllConsultations() {
        return service.findAllConsultations();
    }

    @GetMapping("/{id}")
    public ShiftDto findById(@PathVariable int id) throws ConsultationNotFoundException {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Shift create(@Valid @RequestBody Shift shift) {
        return service.create(shift);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Shift shift, @PathVariable int id) throws ConsultationNotFoundException {
        service.update(shift, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws ConsultationNotFoundException {
        service.delete(id);
    }

    @GetMapping("/stats")
    public List<StatsDto> stats(){
        return service.stats();
    }
}
