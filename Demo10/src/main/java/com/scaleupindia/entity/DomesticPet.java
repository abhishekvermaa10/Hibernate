package com.scaleupindia.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author abhishekvermaa10
 *
 */
@Entity
@Table(name = "domestic_pet_table")
public class DomesticPet extends Pet {
	@Column(name = "date_of_birth", nullable = false)
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
