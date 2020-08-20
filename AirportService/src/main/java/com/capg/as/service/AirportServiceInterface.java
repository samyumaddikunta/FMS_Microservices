package com.capg.as.service;

import java.util.List;
import java.util.Optional;

import com.capg.as.dto.Airport;
public interface AirportServiceInterface 
{
	public Optional<Airport> getAirport(String airportId);
	public List<Airport> getAirports();
	public Airport addAirport(Airport airport);
	public void updateAirport(Airport airport);
	public void deleteAirport(String airportId);
}
