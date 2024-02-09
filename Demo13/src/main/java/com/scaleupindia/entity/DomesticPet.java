package com.scaleupindia.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
/**
 * @author abhishekvermaa10
 *
 */
@DiscriminatorValue("Domestic")
@Entity
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
		return "DomesticPet [id=" + getId() + ", name=" + getName() + ", gender=" + getGender() + ", birthDate="
				+ birthDate + ", type=" + getType() + ", owner=" + getOwner() + "]";
	}
}
