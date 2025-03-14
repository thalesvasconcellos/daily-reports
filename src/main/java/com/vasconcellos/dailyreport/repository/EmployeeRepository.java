package com.vasconcellos.dailyreport.repository;

import com.vasconcellos.dailyreport.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByName(String name);

}