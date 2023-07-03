package com.gl.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.EmployeeRepository;
import com.gl.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {
		employeeRepository = theemployeeRepository;
	}

	@Override
	public List<Employee> findAll() {

		List<Employee> theEmployees = employeeRepository.findAll();
		return theEmployees;
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theemployee = null;

		if (result.isPresent()) {
			theemployee = result.get();
		} else {
			// couldn't find employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theemployee;
	}

	@Override
	public void save(Employee theemployee) {
		employeeRepository.save(theemployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
