package com.ad.assignment.service;

import java.util.List;

import com.ad.assignment.model.Employee;

public interface EmployeeService {
	void delete(Employee employee);

	List<Employee> findAll();

	Employee findOne(int id);

	Employee save(Employee employee);

	List<Employee> findDirectReports(String managerId);

}
