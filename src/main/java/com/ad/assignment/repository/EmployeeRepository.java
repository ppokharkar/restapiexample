package com.ad.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.ad.assignment.model.Employee;

public interface EmployeeRepository extends Repository<Employee, Integer> {

    void delete(Employee employee);

    List<Employee> findAll();

    Employee save(Employee employee);
    
    @Query("SELECT e FROM Employee e WHERE e.managerId = :managerId)")
    List<Employee> findDirectReports(@Param("managerId") String managerId);
}
