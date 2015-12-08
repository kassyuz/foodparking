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
@Table(name="Menu")
@NamedQueries({
	@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m ORDER BY m.description ASC")
})
public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MENU_ID")
	private long menuId;
	
	@Column(name="DISH_ID")
	private long dishId;

	@Column(name="DESCRIPTION")
	private String description;
	
	public Menu() {
	}
	
	public Menu(long menuId, long dishId, String description) {
		super();
		this.menuId = menuId;
		this.dishId = dishId;
		this.description = description;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
