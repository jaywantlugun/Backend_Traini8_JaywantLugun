package com.jaywant.rest.traini8.dto;

import java.time.LocalDate;
import java.util.List;

import com.jaywant.rest.traini8.model.Address;

//dto class to interact with client without directly accessing the entity class
public class TrainingCenterDTO {
	String centerName;
	String centerCode;
	Address address;
	Integer capacity;
	List<String> courses;
	LocalDate createdOn;
	String email;
	String phoneNumber;

	public TrainingCenterDTO() {
		super();
	}

	public TrainingCenterDTO(String centerName, String centerCode, Address address, Integer capacity,
			List<String> courses, LocalDate createdOn, String email, String phoneNumber) {
		super();
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.address = address;
		this.capacity = capacity;
		this.courses = courses;
		this.createdOn = createdOn;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
