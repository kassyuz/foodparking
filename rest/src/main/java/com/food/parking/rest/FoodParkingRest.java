package com.food.parking.rest;

import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FoodParkingRest {

	private static final Logger logRest = LoggerFactory.getLogger(FoodParkingRest.class);
	private final CacheControl cacheControl;

	public FoodParkingRest() {
		cacheControl = new CacheControl();
		cacheControl.setNoCache(true);
		cacheControl.setNoStore(true);
	}

	@SuppressWarnings("unchecked")
	protected Map<String, Object> jsonToMap(String json) {
		try {
			LinkedHashMap<String, Object> result = new ObjectMapper().readValue(json, LinkedHashMap.class);
			return result;
		} catch (Exception ex) {
			logRest.error(ex.getMessage(), ex);
			return new LinkedHashMap<String, Object>();
		}
	}

	protected Response buildJSONResponse(Object o) {
		try {
			StringWriter fw = new StringWriter();
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(fw, o);
			return _buildResponse(fw.toString());
		} catch (Exception ex) {
			logRest.error(ex.getMessage(), ex);
			return _buildResponse(o);
		}
	}

	private Response _buildResponse(Object o) {
		ResponseBuilder rb = Response.ok(o);
		rb.cacheControl(cacheControl);
		return rb.build();
	}

	protected Response buildErrorResponse(String str) {
		ResponseBuilder rb = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
		rb = rb.entity(str);
		rb = rb.type( MediaType.TEXT_PLAIN);
		rb.cacheControl(cacheControl);

		return rb.build();
	}


}
