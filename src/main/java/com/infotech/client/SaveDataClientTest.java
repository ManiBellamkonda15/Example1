package com.infotech.client;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Device;
import com.infotech.entities.Property;
import com.infotech.entities.Room;
import com.infotech.util.HibernateUtil;

public class SaveDataClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();

			/*
			 * CriteriaBuilder userBuilder = session.getCriteriaBuilder();
			 * CriteriaUpdate<Device> deviceUpdate =
			 * userBuilder.createCriteriaUpdate(Device.class); Root<Device> deviceUpdateRoot
			 * = deviceUpdate.from(Device.class);
			 * deviceUpdate.set(deviceUpdateRoot.get("dispalyName"), "DISPLAY12345"); //
			 * deviceUpdate.set(deviceUpdateRoot.get("roomId"), 2);
			 * deviceUpdate.set(deviceUpdateRoot.get("roomList"),
			 * session.getReference(Room.class, 2));
			 * //deviceUpdate.set(deviceUpdateRoot.get("roomList"), 2);
			 * deviceUpdate.where(userBuilder.equal(((Path<Device>)
			 * deviceUpdateRoot).get("deviceName"), "DEVICE2")); int returnValue =
			 * session.createQuery(deviceUpdate).executeUpdate();
			 * System.out.println(returnValue);
			 */

			Property property = new Property();
			property.setPropertyName("PROPERTY1");
			property.setPropertyType("PROPERTY_TYPE_1");
			
			
			Room room1 = new Room();
			room1.setRoomName("ROOM1");
			room1.setRoomType("ROOM_TYPE1");
			room1.setProperty(property);
			
			Room room2 = new Room();
			room2.setRoomName("ROOM2");
			room2.setRoomType("ROOM_TYPE2");
			room2.setProperty(property);
			
			Device device1 = new Device();
			device1.setDeviceName("DEVICE1");
			device1.setDispalyName("DISPLAY1");

			Device device2 = new Device();
			device2.setDeviceName("DEVICE2");
			device2.setDispalyName("DISPLAY2");

					
			
			device1.setRoomList(room1);
			device2.setRoomList(room1);

			// device1.getRoomList().add(room1);
			// device2.getRoomList().add(room1);
			session.save(property);
			session.save(device1);
			session.save(device2);
			session.save(room1);
			session.save(room2);

			session.getTransaction().commit();
			session.clear();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
