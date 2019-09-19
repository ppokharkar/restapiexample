package com.ad.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ad.assignment.model.Employee;
import com.ad.assignment.service.EmployeeService;

@RequestMapping({ "/employees/directreports" })
@RestController
public class EmployeeController<synchroized> {

	@Autowired
	private EmployeeService employeeService;

	/*
	 * This GET method will find all direct reports of manager by accepting
	 * managerId 
	 */
	@GetMapping(path = { "/{id}" })
	public ResponseEntity<List<Employee>>  findDirectReports(@PathVariable("id") String managerId) {
		List<Employee> list = employeeService.findDirectReports(managerId);
		
		
		
		
		if (list != null && list.size() != 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(list);

	}

}
