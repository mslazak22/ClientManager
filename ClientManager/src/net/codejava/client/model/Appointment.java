package net.codejava.client.model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	private Integer id;
	private String name;
	private String type;
	private Date date;
	private Time time;
	
	public Appointment() {
		
	}
	public Appointment(Integer id, String name, String type, Date date, Time time) {
		this(name, type, date,time);
		this.id = id;
		
	}
	public Appointment (String name, String type, Date date, Time time) {
		this.name = name;
		this.type = type;
		this.date = date;
		this.time = time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", type=" + type + ", date=" + date + ", time=" + time + "]";
	}

}
