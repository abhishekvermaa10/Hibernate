package com.scaleupindia.entity;

import com.scaleupindia.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author abhishekvermaa10
 *
 */
@Entity
@Table(name = "owner_table")
public class Owner {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String state;
	@Column(name = "mobile_number", nullable = false, unique = true, length = 10)
	private String mobileNumber;
	@Column(name = "email_id", nullable = false, unique = true)
	private String emailId;
	@OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	@JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false, unique = true)
	private Pet pet;
	
	public int getId() {
		return id;
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

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", pet=" + pet + "]";
	}

}
