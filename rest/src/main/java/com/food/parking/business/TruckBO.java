package com.food.parking.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.parking.model.Teste;
import com.food.parking.model.Truck;

public class TruckBO extends AbstractBO<Teste>{

	private static Logger log = LoggerFactory.getLogger(TruckBO.class);

	public TruckBO() {
		super(Truck.class);
	}

	@SuppressWarnings("unchecked")
	public List<Truck> findAll(){
		List<Truck> trucks = null;
		try {
			trucks = entityManager.createNamedQuery("Truck.findAll").getResultList();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return trucks;
	}


}









