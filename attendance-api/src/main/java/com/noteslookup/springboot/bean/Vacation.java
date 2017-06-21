package com.noteslookup.springboot.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vacation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String vacationStartDate;
	private String vacationEndDate;
	
	@ManyToOne
	private EmpMetaInfo empMetainfo;
	
	public Vacation() {} //jpa
	
	public String getVacationStartDate() {
		return vacationStartDate;
	}
	public void setVacationStartDate(String vacationStartDate) {
		this.vacationStartDate = vacationStartDate;
	}
	
	public String getVacationEndDate() {
		return vacationEndDate;
	}
	public void setVacationEndDate(String vacationEndDate) {
		this.vacationEndDate = vacationEndDate;
	}

	public EmpMetaInfo getEmpMetainfo() {
		return empMetainfo;
	}

	public void setEmpMetainfo(EmpMetaInfo empMetainfo) {
		this.empMetainfo = empMetainfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
