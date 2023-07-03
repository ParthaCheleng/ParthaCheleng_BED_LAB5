package com.gl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
