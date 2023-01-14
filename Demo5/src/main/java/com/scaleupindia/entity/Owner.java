package com.scaleupindia.entity;

import java.time.LocalDate;

import com.scaleupindia.enums.Gender;
import com.scaleupindia.enums.PetType;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

/**
 * @author abhishekvermaa10
 *
 */
@Entity
@Table(name = "owner_table")
public class Owner {
	@EmbeddedId
	private OwnerPetPrimaryKey primaryKey;
	@Column(name = "first_name", nullable = false, length = 255)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 255)
	private String lastName;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private Gender gender;
	@Column(name = "city", nullable = false, length = 255)
	private String city;
	@Column(name = "state", nullable = false, length = 255)
	private String state;
	@Column(name = "mobile_number", nullable = false, length = 10, unique = true)
	private String mobileNumber;
	@Column(name = "email_id", nullable = false, length = 255, unique = true)
	private String emailId;
	@Column(name = "pet_name", nullable = false, length = 255)
	private String petName;
	@Column(name = "pet_date_of_birth", nullable = false)
	private LocalDate petBirthDate;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "pet_gender", nullable = false)
	private Gender petGender;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "pet_type", nullable = false)
	private PetType petType;

	public OwnerPetPrimaryKey getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(OwnerPetPrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
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
		return "Owner [primaryKey=" + primaryKey + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", emailId="
				+ emailId + ", petName=" + petName + ", petBirthDate=" + petBirthDate + ", petGender=" + petGender
				+ ", petType=" + petType + "]";
	}
}
