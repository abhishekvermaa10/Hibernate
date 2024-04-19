package com.scaleupindia;

import jakarta.persistence.Persistence;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("Petistaan");
	}
}