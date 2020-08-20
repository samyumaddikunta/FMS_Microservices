package com.capg.fs.controller;//
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.capg.fs.dto.Flight;
import com.capg.fs.exception.FlightException;
import com.capg.fs.service.FlightServiceImpl;
/**************************************************************************************
 *          @author           P.Madhurima
 *          Description       It is a Rest Controller class that provides the suitable
 *                                       Flight Management methods for the given 
 *                                       matching URL and returns response in different
 *                                       types of data objects.
 *          @version          1.0
 *          Created Date      10-AUG-2020
***************************************************************************************/
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FlightController 
{
	Logger logger= LoggerFactory.getLogger(FlightController.class);
	@Autowired
	FlightServiceImpl flightService;
	public void setFlightService(FlightServiceImpl flightService)
	{
		this.flightService = flightService;
	}
	
	@GetMapping(value="/getFlight/{flightNo}",produces="application/json")
	public ResponseEntity<Optional<Flight>> getFlight(@PathVariable String flightNo) throws FlightException
	{
		String msg = "View the flight:";
		logger.info(msg);
		Optional<Flight> flight =  flightService.getFlight(flightNo);
		if(flight.isPresent())
			return new ResponseEntity<Optional<Flight>>(flight,HttpStatus.OK);
		return new ResponseEntity<Optional<Flight>>(flight,HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping(value="/getFlights",produces="application/json")
	public List<Flight> getFlights() throws FlightException
	{
		String msg = "View all flights :";
		logger.info(msg);
		return flightService.getFlights();
	}
	
	
	@PostMapping(value="/addFlight",consumes="application/json")
	public ResponseEntity<String> addFlight(@RequestBody()Flight flight)
	{
		String msg = "adding the flight :";
		logger.info(msg);
		try
		{
			flightService.addFlight(flight);
			return new ResponseEntity<String>("Flight added successfully!!",HttpStatus.OK);
		}
		catch (Exception ex) 
		{
			return new ResponseEntity<String>(ex.getMessage()+"Failed to add",HttpStatus.BAD_REQUEST);
		}
	}

	 @PutMapping(value="/updateFlight",consumes="application/json") public void
	  updateFlight(@RequestBody() Flight flight) throws FlightException { String
	  msg = "update the flight :"; logger.info(msg);
	  flightService.updateFlight(flight); }
	 
	 
	@DeleteMapping("/deleteFlight/{flightNo}")
	public ResponseEntity<String> deleteFlight(@PathVariable String flightNo)
	{
		String msg = "deleting  the flight :";
		logger.info(msg);
		try
		{
			flightService.deleteFlight(flightNo);
			return new ResponseEntity<String>("Flight Deleted Successfully!!",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("Deletion Failed",HttpStatus.BAD_REQUEST);
		}
	}

}

