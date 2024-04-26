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
		return "DomesticPet [id=" + getId() + ", name=" + getName() + ", gender=" + getGender() + ", birthDate="
				+ birthDate + ", type=" + getType() + ", owner=" + getOwner() + "]";
	}
}
