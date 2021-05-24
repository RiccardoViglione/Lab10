package it.polito.tdp.rivers.model;

import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
RiversDAO dao;
public Model() {
	this.dao=new RiversDAO();
	
}public List<River>getAllRivers()
{
	return  this.dao.getAllRivers();}



public List <Flow> getFlows(River r){
	return this.dao.getFlows(r);
}
public Measurements getMeasurementsInfo(River r) {
	return this.dao.getMeasurementsInfo(r);
}

}
