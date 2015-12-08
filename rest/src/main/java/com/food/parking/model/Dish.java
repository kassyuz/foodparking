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
@Table(name="Dish")
@NamedQueries({
	@NamedQuery(name="Dish.findAll", query="SELECT d FROM Dish d ORDER BY d.name ASC")
})
public class Dish implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DISH_ID")
	private long dishId;

	@Column(name="NAME")
	private String name;
	
	@Column(name="INGREDIENTS")
	private String ingredients;
	
	@Column(name="PRICE")
	private Double price;
	
	
	public Dish() {
	}

	public Dish(long dishId, String name, String ingredients, Double price) {
		super();
		this.dishId = dishId;
		this.name = name;
		this.ingredients = ingredients;
		this.price = price;
	}

	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
