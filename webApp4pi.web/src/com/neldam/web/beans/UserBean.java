package com.neldam.web.beans;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.neldam.ejb.entities.Address;
import com.neldam.ejb.entities.House;
import com.neldam.ejb.entities.LightingSensor;
import com.neldam.ejb.entities.Room;
import com.neldam.ejb.entities.TemperatureSensor;
import com.neldam.ejb.entities.User;
import com.neldam.ejb.service.UserService;
import com.neldam.ejb.url.URL;

@SessionScoped
@ManagedBean(name = "userBean")
public class UserBean {

	@EJB
	private UserService userService;

	/**
	 * Elementu do obslugi uzytkownika
	 * 
	 */
	private Set<Room> rooms = new HashSet<Room>();
	private Set<TemperatureSensor> tsensors = new HashSet<TemperatureSensor>();
	private Set<LightingSensor> lsensors = new HashSet<LightingSensor>();
	private Set<House> houses = new HashSet<House>();
	private User user = new User();
	private House house = new House();
	private Room room = new Room();
	private TemperatureSensor temperatureSensor = new TemperatureSensor();
	private LightingSensor lightingSensor = new LightingSensor();
	private Address address = new Address();

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Set<TemperatureSensor> getTsensors() {
		return tsensors;
	}

	public void setTsensors(Set<TemperatureSensor> tsensors) {
		this.tsensors = tsensors;
	}

	public Set<LightingSensor> getLsensors() {
		return lsensors;
	}

	public void setLsensors(Set<LightingSensor> lsensors) {
		this.lsensors = lsensors;
	}

	public Set<House> getHouses() {
		return houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public TemperatureSensor getTemperatureSensor() {
		return temperatureSensor;
	}

	public void setTemperatureSensor(TemperatureSensor temperatureSensor) {
		this.temperatureSensor = temperatureSensor;
	}

	public LightingSensor getLightingSensor() {
		return lightingSensor;
	}

	public void setLightingSensor(LightingSensor lightingSensor) {
		this.lightingSensor = lightingSensor;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	

	private int index = 0;

	public int getIndex() {
		return (index % 5);
	}

	public void next() {
		index++;
	}

	public void back() {
		index--;
	}

	public String getCurrentUrl() {
		if (index == 0) {
			return URL.USER_CONFIG;
		}
		if (index == 1) {
			return URL.HOUSE_CONFIG;
		}
		if (index == 2) {
			return URL.ROOM_CONFIG;
		}
		if (index == 3) {
			return URL.CONFIRM;
		}
		return URL.CONFIRM;
	}

	public void addNewDeafultUser() {

		Set<Room> rooms = new HashSet<Room>();
		Set<TemperatureSensor> tsensors = new HashSet<TemperatureSensor>();
		Set<LightingSensor> lsensors = new HashSet<LightingSensor>();
		Set<House> houses = new HashSet<House>();
		tsensors.add(new TemperatureSensor(null, "gpio_01", 11F, 22F));
		lsensors.add(new LightingSensor(null, true));
		rooms.add(new Room(null, "Pokoj jacka", null, tsensors, lsensors));

		House house = new House(null, false, new Address(null, "dsdsds",
				"dsdsds", "2"), rooms);
		houses.add(house);

		User user = new User(null, "neldam", "loka", "msgocz@gmail.com",
				"Mateusz", "Gocz", houses);
		userService.addNewUser(user);
		System.out.println("dsdsds");
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
