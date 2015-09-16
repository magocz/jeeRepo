package com.neldam.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temperature_sensors")
public class TemperatureSensor {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "GPIO")
	private String gpio;

	@Column(name = "TEMPERATURE")
	private Float averageTemprature;

	@Column(name = "SET_TEMPERATURE")
	private Float setTemprature;

	/*
	 * @Column(name = "CURRENT_TEMPERATURE") private Float currentTemprature;
	 */

	public TemperatureSensor() {

	}

	public TemperatureSensor(Long id, String gpio, Float averageTemprature,
			Float setTemprature) {
		super();
		this.id = id;
		this.gpio = gpio;
		this.averageTemprature = averageTemprature;
		this.setTemprature = setTemprature;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGpio() {
		return gpio;
	}

	public void setGpio(String gpio) {
		this.gpio = gpio;
	}

	public Float getAverageTemprature() {
		return averageTemprature;
	}

	public void setAverageTemprature(Float averageTemprature) {
		this.averageTemprature = averageTemprature;
	}

	public Float getSetTemprature() {
		return setTemprature;
	}

	public void setSetTemprature(Float setTemprature) {
		this.setTemprature = setTemprature;
	}
}
