package com.noteslookup.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noteslookup.springboot.bean.EmpMetaInfo;
import com.noteslookup.springboot.bean.Employee;
import com.noteslookup.springboot.dao.EmpMetaInfoRepository;

@Service
public class AttendanceService {
	@Autowired
	private EmpMetaInfoRepository empMetaInfoRepository; 

	public Employee getEmployee(String empId) {
		//To set
		Employee employee = new Employee();
		employee.setEmpId("001");
		employee.setfName("Anshu");
		employee.setlName("Kansakar");
		
		return employee;
	}

	public EmpMetaInfo getEmpMetaInfo(Long empId) {
		return empMetaInfoRepository.findOne(empId);
	}

	public EmpMetaInfo saveEmpMetaInfo(EmpMetaInfo empMetaInfo) {
		return empMetaInfoRepository.save(empMetaInfo);
	}
}
