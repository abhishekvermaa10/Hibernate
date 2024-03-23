package com.scaleupindia.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author abhishekvermaa10
 *
 */
public class DomesticPetDTO extends PetDTO {
	private LocalDate birthDate;

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		if (Objects.isNull(getOwnerDTO())) {
			return "DomesticPetDTO [id=" + getId() + ", name=" + getName() + ", gender=" + getGender() + ", birthDate="
					+ birthDate + ", type=" + getType() + "]";
		} else {
			return "DomesticPetDTO [id=" + getId() + ", name=" + getName()
					+ ", gender=" + getGender() + ", birthDate=" + birthDate + ", type=" + getType() + ", ownerDTO=" + getOwnerDTO()
					+ "]";
		}
	}
}
