package com.infotech.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "property_table")
public class Property {
	@Id
	@Column(name = "property_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyId;
	@Column(name = "property_name")
	private String propertyName;
	@Column(name = "property_type")
	private String propertyType;
	@OneToMany(mappedBy = "property")
	private Collection<Room>	room  = new ArrayList<Room>();
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public Collection<Room> getRoom() {
		return room;
	}
	public void setRoom(Collection<Room> room) {
		this.room = room;
	}
	
	
}
