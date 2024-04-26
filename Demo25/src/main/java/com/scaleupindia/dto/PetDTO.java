package com.scaleupindia.dto;

import java.util.Objects;

import com.scaleupindia.enums.Gender;
import com.scaleupindia.enums.PetType;

/**
 * @author abhishekvermaa10
 *
 */
public class PetDTO {
	private int id;
	private String name;
	private Gender gender;
	private PetType type;
	private OwnerDTO ownerDTO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public OwnerDTO getOwnerDTO() {
		return ownerDTO;
	}

	public void setOwnerDTO(OwnerDTO ownerDTO) {
		this.ownerDTO = ownerDTO;
	}

	@Override
	public String toString() {
		if (Objects.isNull(ownerDTO)) {
			return "PetDTO [id=" + id + ", name=" + name + ", gender=" + gender + ", type=" + type + "]";
		} else {
			return "PetDTO [id=" + id + ", name=" + name + ", gender=" + gender + ", type=" + type + ", ownerDTO="
					+ ownerDTO + "]";
		}
	}
}
