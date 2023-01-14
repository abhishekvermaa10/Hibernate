package com.scaleupindia.dto;

/**
 * @author abhishekvermaa10
 *
 */
public class WildPetDTO extends PetDTO {
	private String birthPlace;

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@Override
	public String toString() {
		return "WildPetDTO [id=" + getId() + ", name=" + getName() + ", gender=" + getGender() + ", birthPlace="
				+ birthPlace + ", type=" + getType() + "]";
	}
}
