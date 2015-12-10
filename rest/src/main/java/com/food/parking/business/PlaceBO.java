package com.food.parking.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.parking.model.Place;

public class PlaceBO extends AbstractBO<Place>{

	private static Logger log = LoggerFactory.getLogger(PlaceBO.class);
	
	public PlaceBO() {
		super(PlaceBO.class);
	}
	
	public long createPlaceReturnsId(Double latitude, Double longitude, String description, String address, String locationJSON){
		Place place = new Place();
		place.setAddress(address);
		place.setDescription(description);
		place.setLatitude(latitude);
		place.setLongitude(longitude);
		place.setLocationJSON(locationJSON);
		
		return createReturnsEntity(place).getPlaceId();
	}

	public long createPlaceReturnsId(Place place){
		return createReturnsEntity(place).getPlaceId();
	}
	
	
}
