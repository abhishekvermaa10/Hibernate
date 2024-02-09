package com.scaleupindia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * @author abhishekvermaa10
 *
 */
@DiscriminatorValue("Wild")
@Entity
public class WildPet extends Pet {
	@Column(name = "place_of_birth")
	private String birthPlace;

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@Override
	public String toString() {
		return "WildPet [id=" + getId() + ", name=" + getName() + ", gender=" + getGender() + ", birthPlace="
				+ birthPlace + ", type=" + getType() + ", owner=" + getOwner() + "]";
	}
}
