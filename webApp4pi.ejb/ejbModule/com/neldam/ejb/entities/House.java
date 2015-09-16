package com.neldam.ejb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "houses")
public class House {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "HOUSE_PROTECT")
	private Boolean houseProtect;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "house_address",
            joinColumns = {@JoinColumn(name = "HOUSE_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ADRRESS_ID", nullable = false, updatable = false)}
    )
	private Address address;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "house_room", joinColumns = { @JoinColumn(name = "HOUSE_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ROOM_ID", nullable = false, updatable = false) })
	private Set<Room> rooms = new HashSet<Room>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getHouseProtect() {
		return houseProtect;
	}

	public void setHouseProtect(Boolean houseProtect) {
		this.houseProtect = houseProtect;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public House(){
		
	}
	public House(Long id, Boolean houseProtect, Address address, Set<Room> rooms) {
		this.id = id;
		this.houseProtect = houseProtect;
		this.address = address;
		this.rooms = rooms;
	}
	
	
	
}
