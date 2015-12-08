package com.food.parking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CheckInPlaceDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CHECK_IN_PLACE_DATE_ID")
	private long checkInPlaceDateId;
	
	@Column(name="CHECK_IN_ID")
	private long checkInId;
	
	@Column(name="LATITUDE")
	private Double latitude;
	
	@Column(name="LONGITUDE")
	private Double longitude;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;

	
	public CheckInPlaceDate() {	}

	public CheckInPlaceDate(long checkInPlaceDateId, long checkInId, Double latitude, Double longitude, Date startDate, Date endDate) {	
		super();
		this.checkInPlaceDateId = checkInPlaceDateId;
		this.checkInId = checkInId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getCheckInPlaceDateId() {
		return checkInPlaceDateId;
	}

	public void setCheckInPlaceDateId(long checkInPlaceDateId) {
		this.checkInPlaceDateId = checkInPlaceDateId;
	}

	public long getCheckInId() {
		return checkInId;
	}

	public void setCheckInId(long checkInId) {
		this.checkInId = checkInId;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
