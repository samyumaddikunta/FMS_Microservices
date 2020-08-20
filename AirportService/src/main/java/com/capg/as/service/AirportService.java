package com.capg.as.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capg.as.dao.AirportDAO;
import com.capg.as.dto.Airport;

@Service
public class AirportService 
{
	@Autowired
	AirportDAO adao;
	public void setAdao(AirportDAO adao) { this.adao=adao;}

	//view airport by Id
	@Transactional(readOnly=true)
	public Optional<Airport> getAirport(String airportId)
	{
		return adao.findById(airportId);
	}
	
	//view airport list
	@Transactional(readOnly=true)
	public List<Airport> getAirports()
	{
		return adao.findAll();
	}
	
	//add airport
	@Transactional
	public Airport addAirport(Airport airport)
	{
		return adao.save(airport);
	}
	
	//update airport by Id
	@Transactional
	public void updateAirport(Airport airport)
	{
		Airport a = adao.findById(airport.getAirportId()).get();
		a.setAirportName(airport.getAirportName());
		a.setArea(airport.getArea());
	} 
	
	//delete airport by Id
	@Transactional
	public void deleteAirport(String airportId)
	{
		adao.deleteById(airportId);
	}	
}
