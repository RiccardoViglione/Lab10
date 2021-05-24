package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Event implements Comparable<Event>{
	 enum EventType{
		ENTRATA,
		 USCITA,
		 TRACIMAZIONE,
		 IRRIGAZIONE,
		 
		 
	};
	
	private EventType type;
	
	private Flow f;
	private LocalDate date;
	
	
	
	
	public Event(  LocalDate date,Flow f,EventType type) {
		super();
		this.type = type;
		this.f = f;
		this.date = date;
	}




	public EventType getType() {
		return type;
	}




	public void setType(EventType type) {
		this.type = type;
	}




	public Flow getF() {
		return f;
	}




	public void setF(Flow f) {
		this.f = f;
	}




	public LocalDate getDate() {
		return date;
	}




	public void setDate(LocalDate date) {
		this.date = date;
	}




	@Override
	public String toString() {
		return "Event [type=" + type + ", f=" + f + ", date=" + date + "]";
	}




	@Override
	public int compareTo(Event other) {
		// TODO Auto-generated method stub
		return this.date.compareTo(other.date);
	}
	

}
