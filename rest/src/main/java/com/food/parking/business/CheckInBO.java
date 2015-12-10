package com.food.parking.business;

import java.awt.Image;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.parking.model.CheckIn;
import com.food.parking.model.CheckInPlaceDate;
import com.food.parking.model.Place;

public class CheckInBO extends AbstractBO<CheckIn>{

	private static Logger log = LoggerFactory.getLogger(CheckInBO.class);
	public CheckInBO() {
		super(CheckInBO.class);
	}

	
	public void createCheckin(Double latitude, Double longitude, long truckId, long menuId, Image photo, String description, Date startDate, Date endDate, Boolean isCloseEvent){
		CheckIn checkIn = new CheckIn();
		
		CheckInPlaceDate checkInPlaceDate = new CheckInPlaceDate();

		PlaceBO placeBO = new PlaceBO();
		long placeId = placeBO.createPlaceReturnsId(latitude, longitude, "Novo local", "Av. Brasil, 4378", "objeto JSON");
		
		
		checkIn.setCloseEvent(false);
		checkIn.setDescription("Galera, estamos em frente ao Parque OPA, vamos ver a concorrencia como está");
		checkIn.setMenuId(1);
		checkIn.setPlaceId(placeId);
		checkIn.setTicketPrice(12.22);
		checkIn.setTruckId(1);
		
		create(checkIn);
	}


	
}
