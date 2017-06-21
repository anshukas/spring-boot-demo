package com.noteslookup.springboot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.noteslookup.springboot.bean.EmpMetaInfo;
import com.noteslookup.springboot.bean.Employee;
import com.noteslookup.springboot.bean.EmployeeErrorType;
import com.noteslookup.springboot.service.AttendanceService;

@RestController
@RequestMapping("/api")
public class AttendanceController {
	/**
	 * Resource Design:
	 * 0. GET EMPID /rest/employee/meta-info/{empId}
	 * 		- EmpMetaInfo getEmpMetaInfo(String empId)
	 * 
	 * 1. GET  EMPID /rest/Employees
	 * 		- List<Employee> getEmployees();
	 * 
	 * 2. GET  EMPID /rest/employee/{empId}
	 * 		- Employee getEmployee(String empId);
	 * 
	 * 3. POST EMPID /rest/employee
	 * 		- Employee getEmployee(String empId);
	 * 
	 */
	@Autowired
	private AttendanceService attendanceService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/employee/meta-info")
	public ResponseEntity<?> saveEmpMetaInfo(@RequestBody EmpMetaInfo empMetaInfo){
		
		EmpMetaInfo empInfo = attendanceService.saveEmpMetaInfo(empMetaInfo);
		
		if(empInfo == null ){
			return new ResponseEntity<EmployeeErrorType>(new EmployeeErrorType("Employee Meta Info is not save"), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<EmpMetaInfo>(empInfo, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employee/meta-info/{empId}")
	public ResponseEntity<?> getEmpMetaInfo(@PathVariable Long empId){
		
		EmpMetaInfo empInfo = attendanceService.getEmpMetaInfo(empId);
		
		if(empInfo == null ){
			return new ResponseEntity<EmployeeErrorType>(new EmployeeErrorType("Employee with this Id "+empId+" not found."), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<EmpMetaInfo>(empInfo, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/employee/{empId}")
	public ResponseEntity<?> getEmployee(@PathVariable String empId){
		
		Employee empInfo = attendanceService.getEmployee(empId);
		
		if(empInfo == null ){
			return new ResponseEntity<EmployeeErrorType>(new EmployeeErrorType("Employee with this Id "+empId+" not found."), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Employee>(empInfo, HttpStatus.OK);
	}
	
}
