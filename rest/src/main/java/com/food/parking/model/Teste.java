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
@Table(name="Teste")
@NamedQueries({
	@NamedQuery(name = "Teste.findAll", query = "SELECT t FROM Teste t ORDER BY t.description ASC")
})

public class Teste implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PRODUCTO_ID")
	private long id;

	@Column(name="CODE")
	private String code;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="PRICE")
	private Double price = 0.0;

	@Column(name="MEASURE")
	private Integer measure = 1;

	@Column(name="ACTIVE")
	private Boolean active = true;

	@Column(name="INCREASE")
	private Boolean increase = false;

	@Column(name="ALLOWS_INCREASE")
	private Boolean allowsIncrease = false;

	public Teste() {}

	public Teste(String code, String description, Double price) {
		super();
		this.code = code;
		this.description = description;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMeasure() {
		return measure;
	}

	public void setMeasure(Integer measure) {
		this.measure = measure;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getIncrease() {
		return increase;
	}

	public void setIncrease(Boolean increase) {
		this.increase = increase;
	}

	public Boolean getAllowsIncrease() {
		return allowsIncrease;
	}

	public void setAllowsIncrease(Boolean allowsIncrease) {
		this.allowsIncrease = allowsIncrease;
	}

	@Override
	public String toString() {
		return "com.food.parking.model.Producto" + "\n"
				+ ".id=" + id;
	}
}
