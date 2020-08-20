package com.capg.fs.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capg.fs.dao.FlightDAO;
import com.capg.fs.dto.Flight;

@Service
public class FlightServiceImpl 
{
   @Autowired
   FlightDAO fdao;
   public void setFdao(FlightDAO fdao) { this.fdao=fdao; }
   
   @Transactional(readOnly=true)
   public Optional<Flight> getFlight(String flightNo)
   {
	   return fdao.findById(flightNo);
   }
   
   @Transactional(readOnly=true)
   public List<Flight> getFlights()
   {
	   return fdao.findAll(Sort.by(Sort.Direction.ASC, "flightNo"));
   }
   
   @Transactional
   public Flight addFlight(Flight flight)
   {
	   return fdao.save(flight);
   }
   
   @Transactional
   public void updateFlight(Flight flight)
   {
	   fdao.save(flight);
   }
   
   
   @Transactional
   public void deleteFlight(String flightNo)
   {
	   fdao.deleteById(flightNo);
   }
}
