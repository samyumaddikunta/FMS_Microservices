package com.capg.as.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import com.capg.as.dto.Airport;
import com.capg.as.exception.AirportNotFoundException;
import com.capg.as.dao.AirportDAO;
import com.capg.as.service.AirportService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AirportController 
{
	@Autowired
	AirportService airportService;
	
	@Autowired
	AirportDAO airportDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AirportController.class);
	
	public void setFlightService(AirportService airportService)
	{
		this.airportService=airportService;
	}
	
	//view airport by ID
	@GetMapping("/getAirport/{id}")
	public ResponseEntity<Object> getAirport(@PathVariable("id") String airportId)
	{
	    Optional<Airport> airport = airportDao.findById(airportId);
	    if (airport.isPresent())
	    {
	      LOGGER.info("Get Airport method is accessed");	
	      return new ResponseEntity<>(airport.get(), HttpStatus.OK);
	    }
	    else
	    {
	      return new ResponseEntity<>("Airport not found",HttpStatus.NOT_FOUND);
	    }
	 }
	
	
	//view airport list
	@GetMapping("/getAirport")
	public ResponseEntity<Object> getAirports()
	{
		List<Airport> airportList = airportService.getAirports();
		LOGGER.info("View Airports method is accessed");
		return new ResponseEntity<>(airportList, HttpStatus.OK);
	}

	
	//add airport
	@PostMapping(value="/addAirport",consumes="application/json")
	public ResponseEntity<String> addAirport(@Valid @RequestBody()Airport airport)
	{
		try {
			airportService.addAirport(airport);
			LOGGER.info("Add airport method is accessed"); 
			return new ResponseEntity<>("Airport details added",HttpStatus.OK);
		} 
		catch (DataIntegrityViolationException ex) {
			return new ResponseEntity<>(ex.getMessage() + " Airport Already Exists", HttpStatus.BAD_REQUEST);
		}
	

	}
	
	
	//update Airport
	@PutMapping("/updateAirport/{id}")
	public ResponseEntity<Object> updateAirport(@PathVariable("id") String airportId, @RequestBody Airport airport)throws AirportNotFoundException
	{
		if (airportDao.existsById(airportId))
		{
			airportService.updateAirport(airport);
			LOGGER.info("update airport method is accessed");
			return new ResponseEntity<>("Airport is updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new AirportNotFoundException();
		}
	}


//Delete Airport By Id
@DeleteMapping("/deleteAirport/{id}")
public ResponseEntity<Object> deleteAirport(@PathVariable("id") String airportId)throws AirportNotFoundException
{
	if (airportDao.existsById(airportId))
	{
		airportService.deleteAirport(airportId);
		LOGGER.info("delete Airport method is accessed");
		return new ResponseEntity<>("Airport is deleted successsfully", HttpStatus.OK);
	}
	else
	{
		throw new AirportNotFoundException();
	}
}
}		
