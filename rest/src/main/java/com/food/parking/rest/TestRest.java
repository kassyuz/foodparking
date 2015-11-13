package com.food.parking.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.food.parking.business.TesteBO;
import com.food.parking.model.Teste;
import com.food.parking.vo.TesteVo;

@Path("/teste")
public class TestRest extends FoodParkingRest{
	//private final static Log log = LogFactory.getLog(IncreaseRest.class);

	public TestRest() {
	}

	@POST
	@Path("/teste1")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(String json) {
		TesteVo vo = new TesteVo();
		vo.setAaa(1);
		vo.setBbb("aaa");
		return buildJSONResponse(vo);
	}

	@GET
	@Path("/teste")
	@Produces({MediaType.APPLICATION_JSON})
	public Response findAll() {


		TesteBO bo = new TesteBO();
		bo.findAll();



		TesteVo vo = new TesteVo();
		vo.setAaa(1);
		vo.setBbb("aaa");




		return buildJSONResponse(vo);
	}


	@GET
	@Path("/teste2")
	@Produces({MediaType.APPLICATION_JSON})
	public Response teste2() {


		TesteBO bo = new TesteBO();
		Teste aaa = new Teste("1", "aaaa", 2.5);
		bo.create(aaa);
		List<Teste> result = bo.findAll();










		return buildJSONResponse(result);
	}


}