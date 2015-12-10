package com.food.parking.rest;

import java.awt.Image;
import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.food.parking.business.CheckInBO;

@Path("/checkin")
public class CheckInRest extends FoodParkingRest{

	@POST
	@Path("/create")
	@Produces({MediaType.APPLICATION_JSON})
	public Response checkIn() {
		CheckInBO checkInBO = new CheckInBO();
		
		Date today = new Date();
		Double latitude = -26.264732;
		Double longitude = -48.834844;
		long truckId = 1;
		long menuId = 1;
		Image photo = null;
		String description = "First checkin in FoodParking.com";
		Date startDate = today;
		Date endDate = today;
		Boolean isCloseEvent = false;
		
		
		checkInBO.createCheckin(latitude, longitude, truckId, menuId, photo, description, startDate, endDate, isCloseEvent);
		
		return buildJSONResponse(true);
	}

}
