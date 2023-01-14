package com.scaleupindia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * @author abhishekvermaa10
 *
 */
@Entity
@DiscriminatorValue("Wild Pet")
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
		return "Pet [id=" + getId() + ", name=" + getName() + ", birthPlace=" + birthPlace + ", Gender=" + getGender()
				+ ", Type=" + getType() + "]";
	}
}
