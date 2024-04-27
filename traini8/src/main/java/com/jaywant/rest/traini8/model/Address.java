package com.jaywant.rest.traini8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long addressId; // Using addressId as a primary key which act as a foreign key in TrainingCenter
					// class
	String detailedAddress;
	String city;
	String state;
	Integer pincode;

	public Address() {

	}

	public Address(String detailedAddress, String city, String state, Integer pincode) {
		super();
		this.detailedAddress = detailedAddress;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [detailedAddress=" + detailedAddress + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}

}
