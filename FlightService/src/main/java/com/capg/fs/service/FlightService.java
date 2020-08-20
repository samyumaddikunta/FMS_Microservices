package com.capg.fs.service;

import java.util.List;
import java.util.Optional;

import com.capg.fs.dto.Flight;

public interface FlightService {
	  public Flight addFlight(Flight flight);
	  public void updateFlight(Flight flight);
	  public void deleteFlight(String flightNo);
	  public List<Flight> getFlights();
	  public Optional<Flight> getFlight(String flightNo);
}
