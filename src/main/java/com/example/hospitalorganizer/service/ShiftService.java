package com.example.hospitalorganizer.service;

import com.example.hospitalorganizer.dto.ShiftDto;
import com.example.hospitalorganizer.dto.StatsDto;
import com.example.hospitalorganizer.exception.ConsultationNotFoundException;
import com.example.hospitalorganizer.model.Shift;
import com.example.hospitalorganizer.repository.ShiftRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShiftService {

    private final ShiftRepository repository;

    private final ModelMapper modelMapper;

    public ShiftService(ShiftRepository repository) {
        this.repository = repository;
        modelMapper = new ModelMapper();
    }

    private ShiftDto convertToDto(Shift shift) {
        return modelMapper.map(shift, ShiftDto.class);
    }

    private ShiftDto convertToDtoWithIds(Shift shift) {
        ShiftDto shiftDto = modelMapper.map(shift, ShiftDto.class);
        shiftDto.setHospital(null);
        shiftDto.setDoctor(null);
        return shiftDto;
    }

    private ShiftDto convertToDtoWithObjects(Shift shift) {
        ShiftDto shiftDto = modelMapper.map(shift, ShiftDto.class);
        shiftDto.setHospitalId(null);
        shiftDto.setDoctorId(null);
        shiftDto.makeHospitalConsultationsNull();
        shiftDto.makeDoctorlConsultationsNull();
        return shiftDto;
    }

    public List<ShiftDto> findAllConsultations() {
        return repository.findAll().stream()
                .map(this::convertToDtoWithIds)
                .collect(Collectors.toList());
    }

    public ShiftDto findById(@PathVariable int id) throws ConsultationNotFoundException {
        return convertToDtoWithObjects(repository.findById(id).orElseThrow(ConsultationNotFoundException::new));
    }

    public Shift create(@RequestBody Shift Shift) {
        return repository.save(Shift);
    }

    public void update(@RequestBody Shift Shift, @PathVariable int id) throws ConsultationNotFoundException {
        if (repository.existsById(id)) {
            repository.save(Shift);
        }
        else {
            throw new ConsultationNotFoundException();
        }
    }

    public void delete(@PathVariable int id) throws ConsultationNotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new ConsultationNotFoundException();
        }
    }

    public List<StatsDto> stats(){
        return repository.order();
    }
}
