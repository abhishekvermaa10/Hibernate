package com.scaleupindia.dto;

import java.util.List;
import java.util.Objects;

import com.scaleupindia.enums.Gender;

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
	private List<PetDTO> petDTOList;

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

	public List<PetDTO> getPetDTOList() {
		return petDTOList;
	}

	public void setPetDTOList(List<PetDTO> petDTOList) {
		this.petDTOList = petDTOList;
	}

	@Override
	public String toString() {
		if (Objects.isNull(petDTOList)) {
			return "OwnerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
					+ ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
					+ "]";
		} else {
			return "OwnerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
					+ ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
					+ ", petDTOList=" + petDTOList + "]";
		}
	}
}
