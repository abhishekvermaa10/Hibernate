package com.scaleupindia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author abhishekvermaa10
 *
 */
@Entity
@Table(name = "wild_pet_table")
public class WildPet extends Pet {
	@Column(name = "place_of_birth", nullable = false)
	private String birthPlace;

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@Override
	public String toString() {
		return "Pet [id=" + getId() + ", name=" + getName() + ", birthPlace=" + birthPlace + ", Gender=" + getGender()
				+ ", Type=" + getType() + "]";
	}
}
