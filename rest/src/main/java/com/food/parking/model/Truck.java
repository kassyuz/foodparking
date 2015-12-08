package com.food.parking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.type.LobType;

@Entity
@Table(name="Truck")
@NamedQueries({
	@NamedQuery(name = "Truck.findAll", query = "SELECT t FROM Truck t ORDER BY t.description ASC")
})

public class Truck implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TRUCK_ID")
	private long id;

	@Column(name="NAME")
	private String name;

	@Column(name="DESCRIPTION")
	private String description;

	@Lob
	@Column(name="IMAGE")
	private byte[] image;
	
	public Truck() {}

	public Truck(String name) {
		super();
		this.name = name;
	}

	public Truck(String name, String description, byte[] image ) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "com.food.parking.model.Truck" + "\n"
				+ ".id=" + id;
	}
}
