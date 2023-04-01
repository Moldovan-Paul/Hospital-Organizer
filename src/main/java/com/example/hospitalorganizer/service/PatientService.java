package com.example.hospitalorganizer.service;

import com.example.hospitalorganizer.dto.PatientDto;
import com.example.hospitalorganizer.exception.PatientNotFoundException;
import com.example.hospitalorganizer.model.Patient;
import com.example.hospitalorganizer.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository repository;

    private final ModelMapper modelMapper;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
        modelMapper = new ModelMapper();
    }

    private PatientDto convertToDtoWithHospitalId(Patient patient) {
        PatientDto patientDto = modelMapper.map(patient, PatientDto.class);
        if (patient.getH() != null)
            patientDto.setHospitalId(patient.getH().getId());
        return patientDto;
    }

    private PatientDto convertToDtoWithHospital(Patient patient) {
        PatientDto patientDto = modelMapper.map(patient, PatientDto.class);
        if (patient.getH() != null)
        {
            patientDto.setHospital(patient.getH());
            patientDto.makePatientsListNull();
            patientDto.makeShiftsListNull();
        }
        return patientDto;
    }

    public List<PatientDto> findAllPatients() {
        return repository.findAll().stream()
                .map(this::convertToDtoWithHospitalId)
                .collect(Collectors.toList());
    }

    public PatientDto findById(int id) throws PatientNotFoundException {
        return convertToDtoWithHospital(repository.findById(id).orElseThrow(PatientNotFoundException::new));
    }

    public Patient create(Patient patient) {
        return repository.save(patient);
    }

    public void update(Patient patient, int id) throws PatientNotFoundException {
        if (repository.existsById(id)) {
            repository.save(patient);
        }
        else {
            throw new PatientNotFoundException();
        }
    }

    public void delete(int id) throws PatientNotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new PatientNotFoundException();
        }
    }
}
