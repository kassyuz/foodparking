package com.food.parking.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.food.parking.business.TruckBO;
import com.food.parking.model.Truck;

@Path("/truck")
public class TruckRest extends FoodParkingRest{
	//private final static Log log = LogFactory.getLog(TruckRest.class);

	public TruckRest() {
	}

	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public Response findAll() {
		TruckBO truckBO = new TruckBO();
		List<Truck> trucks = truckBO.findAll();
		return buildJSONResponse(trucks);
	}


}