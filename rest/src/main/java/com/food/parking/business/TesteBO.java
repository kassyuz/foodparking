package com.food.parking.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.parking.model.Teste;

public class TesteBO extends AbstractBO<Teste>{

	private static Logger log = LoggerFactory.getLogger(TesteBO.class);

	public TesteBO() {
		super(Teste.class);
	}

	@SuppressWarnings("unchecked")
	public List<Teste> findAll(){
		List<Teste> increases = null;
		try {
			increases = entityManager.createNamedQuery("Teste.findAll").getResultList();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return increases;
	}


}









