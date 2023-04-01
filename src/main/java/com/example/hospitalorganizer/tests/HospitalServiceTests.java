package com.example.hospitalorganizer.tests;

import com.example.hospitalorganizer.dto.HospitalDto;
import com.example.hospitalorganizer.model.Hospital;
import com.example.hospitalorganizer.model.Patient;
import com.example.hospitalorganizer.repository.HospitalRepository;
import com.example.hospitalorganizer.service.HospitalService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class HospitalServiceTests {

    @Mock
    private HospitalRepository repository;

    @InjectMocks
    private HospitalService service;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void orderByAverageAgeOfPatients() {
        Hospital h1 = new Hospital(1, "Regina Maria", "Ramurilor 30",
                "General", true, false,0,null, null);
        Hospital h2 = new Hospital(2, "Regina Maria", "Ramurilor 30",
                "General", true, false,0,null, null);
        Hospital h3 = new Hospital(3, "Regina Maria", "Ramurilor 30",
                "General", true, false,0,null, null);
        Patient p1 = new Patient(1, "", "", 10, "", "", null);
        Patient p2 = new Patient(2, "", "", 5, "", "", null);
        h1.setPatients(List.of(p1));
        h2.setPatients(List.of(p1,p2));
        h3.setPatients(List.of(p2));
        List<Hospital> hospitals = List.of(h1,h2,h3);
        when(repository.findAll()).thenReturn(hospitals);
        List<HospitalDto> result = service.orderByAverageAgeOfPatients();
        assertEquals(result.get(0).getAverageAge(), 5, 0);
        assertEquals(result.get(1).getAverageAge(), 7.5,0 );
        assertEquals(result.get(2).getAverageAge(), 10, 0);
    }
}
