package net.codejava.client.dao;

import java.util.List;

import net.codejava.client.model.Appointment;

public interface AppointmentDAO {
	public int save(Appointment a);
	
	public int update(Appointment a);
	
	public Appointment get(Integer id);
	
	public int delete(Integer id);
	
	public List<Appointment> list();
	
	public List<Appointment> search(String name);//return id and use it to 
}
