package com.infotech.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Address;
import com.infotech.entities.Device;
import com.infotech.entities.Employee;
import com.infotech.entities.Room;
import com.infotech.util.HibernateUtil;

public class SaveDataClientTest {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	session.beginTransaction();
	    	
	    	Device device1= new Device();
	    	device1.setDeviceName("DEVICE1");
	    	device1.setDispalyName("DISPLAY1");
	    	
	    	Device device2= new Device();
	    	device2.setDeviceName("DEVICE2");
	    	device2.setDispalyName("DISPLAY2");
	    	
	    	Room room1 = new Room();
	    	room1.setRoomName("ROOM1");
	    	room1.setRoomType("ROOM_TYPE1");
	    	
	    	Room room2 = new Room();
	    	room2.setRoomName("ROOM2");
	    	room2.setRoomType("ROOM_TYPE2");
	    	
	    	//device1.getRoomList().add(room1);
	    	//device2.getRoomList().add(room1);
	    
	    	//room1.getDeviceList().add(device1);
	    	device1.setRoomList(room1);
	    	device2.setRoomList(room1);
	    	
	    	
	    	
	    	Employee employee1= new Employee();
			employee1.setEmployeeName("Barry Bingel");
			employee1.setEmail("barry.cs2017@gmail.com");
			employee1.setSalary(50000.00);
			employee1.setDoj(new Date());
			
			Employee employee2= new Employee();
			employee2.setEmployeeName("Sean Bingel");
			employee2.setEmail("sean.cs2017@gmail.com");
			employee2.setSalary(70000.00);
			employee2.setDoj(new Date());
			
			Address address1 = new Address();
			address1.setCity("Chennai");
			address1.setPincode(9087727L);
			address1.setState("Tamilnadu");
			address1.setStreet("Park Street");
			
			Address address2 = new Address();
			address2.setCity("Pune");
			address2.setPincode(9000027L);
			address2.setState("MH");
			address2.setStreet("XYZ Street");
			
			Address address3 = new Address();
			address3.setCity("Delhi");
			address3.setPincode(908877027L);
			address3.setState("DL");
			address3.setStreet("PQR Street");
			
			employee1.getAddressList().add(address1);
			employee1.getAddressList().add(address2);
			employee1.getAddressList().add(address3);
			
			address1.getEmpList().add(employee1);
			address2.getEmpList().add(employee1);
			address3.getEmpList().add(employee1);
			
			employee2.getAddressList().add(address2);
			employee2.getAddressList().add(address3);
			
			address2.getEmpList().add(employee2);
			address3.getEmpList().add(employee2);
			
			session.persist(employee1);
			session.persist(employee2);
			
			session.save(device1);
			session.save(device2);
			session.save(room1);
			session.save(room2);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
}
