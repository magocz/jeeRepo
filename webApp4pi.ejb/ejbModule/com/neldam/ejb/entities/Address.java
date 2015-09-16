package com.neldam.ejb.entities;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CITY", nullable = false, length = 50)
	private String city;

	@Column(name = "STREET", nullable = false, length = 50)
	private String street;

	@Column(name = "NUMBER", nullable = false)
	private String number;

	public Address() {

	}

	public Address(Long id, String city, String street, String number) {
		super();
		this.id = id;
		this.city = city;
		this.street = street;
		this.number = number;
	}

}
