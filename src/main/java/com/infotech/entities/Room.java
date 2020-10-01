package com.infotech.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room_table")
public class Room {
	@Id
	@Column(name = "room_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	@Column(name = "room_name")
	private String roomName;
	@Column(name = "room_type")
	private String roomType;
	@OneToMany(mappedBy="roomList")
    private Collection<Device> deviceList = new ArrayList<>();
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Collection<Device> getDeviceList() {
		return deviceList;
	}
	public void setDeviceList(Collection<Device> deviceList) {
		this.deviceList = deviceList;
	}
	
	
}
