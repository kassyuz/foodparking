package com.food.parking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Truck")
@NamedQueries({
	@NamedQuery(name = "Truck.findAll", query = "SELECT t FROM Truck t ORDER BY t.description ASC")
})

public class Truck implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TRUCK_ID")
	private long id;

	@Column(name="TITLE")
	private String description;

	@Column(name="LATITUDE")
	private Double latitude;

	@Column(name="LONGITUDE")
	private Double longitude;

	public Truck() {}

	public Truck(String title) {
		super();
		description = title;
	}

	public Truck(String title, Double latitude, Double longitude) {
		super();
		description = title;
		this.latitude = latitude;
		this.longitude=longitude;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return description;
	}

	public void setTitle(String title) {
		description = title;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "com.food.parking.model.Truck" + "\n"
				+ ".id=" + id;
	}
}
