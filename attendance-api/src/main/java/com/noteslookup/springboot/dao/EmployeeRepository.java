package com.noteslookup.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.noteslookup.springboot.bean.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
