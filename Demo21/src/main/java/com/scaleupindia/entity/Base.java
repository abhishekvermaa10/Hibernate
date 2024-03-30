package com.scaleupindia.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * @author abhishekvermaa10
 *
 */
@MappedSuperclass
public abstract class Base {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Base [id=" + id + "]";
	}
}
