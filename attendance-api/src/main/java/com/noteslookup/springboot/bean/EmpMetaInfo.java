package com.noteslookup.springboot.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EmpMetaInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public EmpMetaInfo() {} //jpa

	@Id
	private long id;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Vacation> vacations;

	public Set<Vacation> getVacations() {
		return vacations;
	}

	public void setVacations(Set<Vacation> vacations) {
		this.vacations = vacations;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
