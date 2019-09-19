package com.ad.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ad.assignment.model.Employee;
import com.ad.assignment.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public void setRepository(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *
	 * This method calls the employee repository method to find all the direct
	 * reports of a manager by accepting manager id *(non-Javadoc)*
	 * 
	 * @see
	 * com.ad.assignment.service.EmployeeService#findDirectReports(java.lang.String)
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Employee> findDirectReports(String managerId) {
		return repository.findDirectReports(managerId);
	}

}
