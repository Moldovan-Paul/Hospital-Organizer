package com.example.hospitalorganizer.repository;

import com.example.hospitalorganizer.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByMaximumCapacityGreaterThan(int capacity);

}
