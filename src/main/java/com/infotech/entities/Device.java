package com.infotech.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "device_table")
public class Device {
	@Id
	@Column(name = "device_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deviceId;
	@Column(name = "device_name")
	private String deviceName;
	@Column(name = "display_name")
	private String dispalyName;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "ROOM_ID")
	//private List<Room> roomList = new ArrayList<>();
	
	private Room roomList; 
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDispalyName() {
		return dispalyName;
	}
	public void setDispalyName(String dispalyName) {
		this.dispalyName = dispalyName;
	}
	public Room getRoomList() {
		return roomList;
	}
	public void setRoomList(Room roomList) {
		this.roomList = roomList;
	}
	
	
	
	

}
