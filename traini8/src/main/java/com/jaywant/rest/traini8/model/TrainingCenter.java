package com.jaywant.rest.traini8.model;

import java.time.LocalDate;
import java.util.List;

import com.jaywant.rest.traini8.annotation.EmailIfPresent;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Transactional
public class TrainingCenter {

	@Size(max = 40, message = "center name should be less than 40 characters")
	String centerName;

	@Size(min = 12, max = 12, message = "center code length should be exactly 12")
	@Id
	String centerCode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId") // using addressId as foreign key to map address
	Address address;

	Integer capacity;
	List<String> courses;
	LocalDate createdOn;

	@EmailIfPresent()
	String email;

	@Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
	String phoneNumber;

	public TrainingCenter() {

	}

	public TrainingCenter(String centerName, String centerCode, Address address, Integer capacity, List<String> courses,
			LocalDate createdOn, String email, String phoneNumber) {
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

	@Override
	public String toString() {
		return "TrainingCenter [centerName=" + centerName + ", centerCode=" + centerCode + ", address=" + address
				+ ", capacity=" + capacity + ", courses=" + courses + ", createdOn=" + createdOn + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
