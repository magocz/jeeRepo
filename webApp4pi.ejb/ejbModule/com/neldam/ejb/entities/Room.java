package com.neldam.ejb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	/*@Column(name = "TYPE")
	private RoomType type;*/
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "room_temperature",
            joinColumns = {@JoinColumn(name = "ROOM_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "TSENSOR_ID", nullable = false, updatable = false)}
    )
    private Set<TemperatureSensor> temperatureSensors = new HashSet<TemperatureSensor>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "room_light",
            joinColumns = {@JoinColumn(name = "ROOM_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "LSENSOR_ID", nullable = false, updatable = false)}
    )
    private Set<LightingSensor> lightingSensors = new HashSet<LightingSensor>();

	public Room(){
		
	}
	public Room(Long id, String name, RoomType type,
			Set<TemperatureSensor> temperatureSensors,
			Set<LightingSensor> lightingSensors) {
		super();
		this.id = id;
		this.name = name;
		this.temperatureSensors = temperatureSensors;
		this.lightingSensors = lightingSensors;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public RoomType getType() {
		return type;
	}
	public void setType(RoomType type) {
		this.type = type;
	}*/
	public Set<TemperatureSensor> getTemperatureSensors() {
		return temperatureSensors;
	}
	public void setTemperatureSensors(Set<TemperatureSensor> temperatureSensors) {
		this.temperatureSensors = temperatureSensors;
	}
	public Set<LightingSensor> getLightingSensors() {
		return lightingSensors;
	}
	public void setLightingSensors(Set<LightingSensor> lightingSensors) {
		this.lightingSensors = lightingSensors;
	}

	
}
