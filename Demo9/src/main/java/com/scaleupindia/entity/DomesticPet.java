package com.scaleupindia.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * @author abhishekvermaa10
 *
 */
@Entity
@DiscriminatorValue("Domestic Pet")
public class DomesticPet extends Pet {
	@Column(name = "date_of_birth")
	private LocalDate birthDate;

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Pet [id=" + getId() + ", name=" + getName() + ", birthDate=" + birthDate + ", Gender=" + getGender()
				+ ", Type=" + getType() + "]";
	}
}
