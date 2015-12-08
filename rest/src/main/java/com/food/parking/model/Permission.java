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
@Table(name="Permission")
@NamedQueries({
	@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p ORDER BY p.permissionId ASC")
})
public class Permission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PERMISSION_ID")
	private long permissionId;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="TRUCK_ID")
	private long truckId;

	@Column(name="OWNER")
	private Boolean owner;
	
	public Permission() {
		
		
	}

	public Permission(long permissionId, long userId, long truckId, Boolean owner) {
		super();
		this.permissionId = permissionId;
		this.userId = userId;
		this.truckId = truckId;
		this.owner = owner;
	}

	public long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getTruckId() {
		return truckId;
	}

	public void setTruckId(long truckId) {
		this.truckId = truckId;
	}

	public Boolean isOwner() {
		return owner;
	}

	public void setOwner(Boolean owner) {
		this.owner = owner;
	}

}
