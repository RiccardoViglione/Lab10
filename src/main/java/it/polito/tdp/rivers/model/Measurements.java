package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Measurements {
	River river;
	LocalDate startDate;
	LocalDate endDate;
	int numMeasurements;
	float fMed;
	
	public Measurements(River river, LocalDate startDate, LocalDate endDate, int numMeasurements, float fMed) {
		this.river = river;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numMeasurements = numMeasurements;
		this.fMed = fMed;
	}

	public River getRiver() {
		return river;
	}

	public void setRiver(River river) {
		this.river = river;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getNumMeasurements() {
		return numMeasurements;
	}

	public void setNumMeasurements(int numMeasurements) {
		this.numMeasurements = numMeasurements;
	}

	public double getfMed() {
		return fMed;
	}

	public void setfMed(float fMed) {
		this.fMed = fMed;
	}
}