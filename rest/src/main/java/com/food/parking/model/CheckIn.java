/**
 * 
 */
package com.food.parking.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="CheckIn")
@NamedQueries({
	@NamedQuery(name="CheckIn.findAll", query="SELECT c FROM CheckIn c ORDER BY c.id ASC")
})
public class CheckIn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CHECK_IN_ID")
	private long id;
	
	@Column(name="TRUCK_ID")
	private long truckId;
	
	@Column(name="MENU_ID")
	private long menuId;
	
	@Column(name="PLACE_ID")
	private long placeId;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="CLOSE_EVENT")
	private Boolean closeEvent;
	
	@Column(name="TICKET_PRICE")
	private Double ticketPrice;
	
	public CheckIn() {}

	public CheckIn(long truckId, long menuId, long placeId, String description, Boolean closeEvent, Double ticketPrice) {
		super();
		this.truckId = truckId;
		this.menuId = menuId;
		this.placeId = placeId;
		this.description = description;
		this.closeEvent = closeEvent;
		this.ticketPrice = ticketPrice;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTruckId() {
		return truckId;
	}

	public void setTruckId(long truckId) {
		this.truckId = truckId;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCloseEvent() {
		return closeEvent;
	}

	public void setCloseEvent(Boolean closeEvent) {
		this.closeEvent = closeEvent;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	@Override
	public String toString() {
		return "com.food.parking.model.CheckIn" + "\n"
				+ ".id=" + id;
	}
}
