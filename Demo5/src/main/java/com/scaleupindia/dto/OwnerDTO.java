package com.scaleupindia.dto;

import java.time.LocalDate;

import com.scaleupindia.enums.Gender;
import com.scaleupindia.enums.PetType;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerDTO {
	private int id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private String city;
	private String state;
	private String mobileNumber;
	private String emailId;
	private int petId;
	private String petName;
	private LocalDate petBirthDate;
	private Gender petGender;
	private PetType petType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public LocalDate getPetBirthDate() {
		return petBirthDate;
	}

	public void setPetBirthDate(LocalDate petBirthDate) {
		this.petBirthDate = petBirthDate;
	}

	public Gender getPetGender() {
		return petGender;
	}

	public void setPetGender(Gender petGender) {
		this.petGender = petGender;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	@Override
	public String toString() {
		return "OwnerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", petId=" + petId + ", petName=" + petName + ", petBirthDate=" + petBirthDate + ", petGender="
				+ petGender + ", petType=" + petType + "]";
	}
}
