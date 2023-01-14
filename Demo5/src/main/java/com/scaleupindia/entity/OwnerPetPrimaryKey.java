/**
 * 
 */
package com.scaleupindia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * @author abhishekvermaa10
 *
 */
@Embeddable
public class OwnerPetPrimaryKey {
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "pet_id", nullable = false)
	private int petId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	@Override
	public String toString() {
		return "OwnerPetPrimaryKey [id=" + id + ", petId=" + petId + "]";
	}
}
