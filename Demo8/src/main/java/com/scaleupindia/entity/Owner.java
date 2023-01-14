package com.scaleupindia.entity;

import java.util.List;

import com.scaleupindia.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * @author abhishekvermaa10
 *
 */
@Entity
@Table(name = "owner_table")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
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
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "owner_pet_table", joinColumns = @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false))
	private List<Pet> petList;

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

	public List<Pet> getPetList() {
		return petList;
	}

	public void setPetList(List<Pet> petList) {
		this.petList = petList;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", petList=" + petList + "]";
	}
}
