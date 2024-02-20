package com.scaleupindia.entity;

import com.scaleupindia.enums.Gender;
import com.scaleupindia.enums.PetType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author abhishekvermaa10
 *
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "pet_table")
public class Pet {
	@GeneratedValue
	@Id
	private int id;
	@Column(nullable = false)
	private String name;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private PetType type;
	@OneToOne(mappedBy = "pet")
	private Owner owner;

	public int getId() {
		return id;
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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", gender=" + gender + ", type=" + type + ", owner=" + owner + "]";
	}
}
