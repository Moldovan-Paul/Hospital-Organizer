package com.example.hospitalorganizer.service;

import com.example.hospitalorganizer.dto.HospitalDto;
import com.example.hospitalorganizer.exception.HospitalNotFoundException;
import com.example.hospitalorganizer.model.Hospital;
import com.example.hospitalorganizer.model.Patient;
import com.example.hospitalorganizer.repository.HospitalRepository;
import com.example.hospitalorganizer.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    private final HospitalRepository repository;
    private final ModelMapper modelMapper;

    public HospitalService(HospitalRepository repository, PatientRepository patientRepository) {
        this.repository = repository;
        modelMapper = new ModelMapper();
    }
    private HospitalDto convertToDto(Hospital hospital) {
        return modelMapper.map(hospital, HospitalDto.class);
    }
    private HospitalDto convertToDtoWithoutPatients(Hospital hospital) {
        HospitalDto hospitallDto = modelMapper.map(hospital, HospitalDto.class);
        hospitallDto.setPatientIds(null);
        hospitallDto.setPatients(null);
        hospitallDto.setShifts(null);
        return hospitallDto;
    }

    public List<HospitalDto> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDtoWithoutPatients)
                .collect(Collectors.toList());
    }

    public HospitalDto findById(@PathVariable int id) throws HospitalNotFoundException {
        return convertToDto(repository.findById(id).orElseThrow(HospitalNotFoundException::new));
    }

    public Hospital create(@RequestBody Hospital hospital) {
        return repository.save(hospital);
    }

    public void update(@RequestBody Hospital hospital, @PathVariable int id) throws HospitalNotFoundException {
        if (repository.existsById(id)) {
            repository.save(hospital);
        }
        else {
            throw new HospitalNotFoundException();
        }
    }

    public void delete(@PathVariable int id) throws HospitalNotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new HospitalNotFoundException();
        }
    }

    public List<Hospital> filterByMaximumCapacity(@PathVariable int capacity) {
        return repository.findByMaximumCapacityGreaterThan(capacity);
    }

    public List<HospitalDto> orderByAverageAgeOfPatients() {
        List<HospitalDto> orderedHospitals = repository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        for(HospitalDto h: orderedHospitals) {
            List<Patient> patients = h.getPatients();
            h.setPatientIds(null);
            h.setShifts(null);
            if (patients.isEmpty()) {
                continue;
            }
            h.setAverageAge(patients.stream()
                    .mapToDouble(Patient::getAge)
                    .average().getAsDouble());
        }
        orderedHospitals.sort(Comparator.comparing(HospitalDto::getAverageAge));
        orderedHospitals = orderedHospitals.stream()
                .filter( h -> h.getAverageAge() != 0)
                .collect(Collectors.toList());
        return orderedHospitals;
    }


}
