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
@Table(name="Place")
@NamedQueries({
	@NamedQuery(name="Place.findAll", query="SELECT p FROM Place p ORDER BY p.description ASC")
})
public class Place implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PLACE_ID")
	private long placeId;

	@Column(name="LATITUDE")
	private Double latitude;
	
	@Column(name="LONGITUDE")
	private Double longitude;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="LOCATION_JSON")
	private String locationJSON;
	
	
	public Place() {}

	
	public Place(long placeId, Double latitude, Double longitude, String description, String address, String locationJSON) {
		super();
		this.placeId = placeId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.address = address;
		this.locationJSON = locationJSON;
	}


	public long getPlaceId() {
		return placeId;
	}


	public void setPlaceId(long placeId) {
		this.placeId = placeId;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLocationJSON() {
		return locationJSON;
	}


	public void setLocationJSON(String locationJSON) {
		this.locationJSON = locationJSON;
	}

}
