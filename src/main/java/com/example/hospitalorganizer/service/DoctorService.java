package com.example.hospitalorganizer.service;

import com.example.hospitalorganizer.dto.DoctorDto;
import com.example.hospitalorganizer.exception.DoctorNotFoundException;
import com.example.hospitalorganizer.model.Doctor;
import com.example.hospitalorganizer.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DoctorService {

    private final DoctorRepository repository;

    private final ModelMapper modelMapper;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
        modelMapper = new ModelMapper();
    }
    private DoctorDto convertToDtoWithoutShifts(Doctor doctor) {
        DoctorDto doctorDto = modelMapper.map(doctor, DoctorDto.class);
        doctorDto.setShifts(null);
        return doctorDto;
    }

    public List<DoctorDto> findAllDoctors() {
        return repository.findAll().stream()
                .map(this::convertToDtoWithoutShifts)
                .collect(Collectors.toList());
    }

    public Doctor findById(int id) throws DoctorNotFoundException {
        return repository.findById(id).orElseThrow(DoctorNotFoundException::new);
    }

    public Doctor create(Doctor Doctor) {
        return repository.save(Doctor);
    }

    public void update(Doctor Doctor, int id) throws DoctorNotFoundException {
        if (repository.existsById(id)) {
            repository.save(Doctor);
        }
        else {
            throw new DoctorNotFoundException();
        }
    }

    public void delete(int id) throws DoctorNotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new DoctorNotFoundException();
        }
    }
}
