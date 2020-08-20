package com.capg.bs.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.bs.dao.PassengersDAO;
import com.capg.bs.dto.Passengers;

@Service
public class PassengersService 
{
	@Autowired
	PassengersDAO pdao;
	public void setPdao(PassengersDAO pdao) { this.pdao=pdao;}

	@Transactional(readOnly=true)
	public Optional<Passengers> getPassenger(String uid)
	{
		return pdao.findById(uid);
	}

	@Transactional(readOnly=true)
	public List<Passengers> getAllPassengers()
	{
		return pdao.findAll();
	}

	@Transactional
	public Passengers addPassenger(Passengers passenger)
	{
		return pdao.save(passenger);
	}

	@Transactional
	public void updatePassenger(Passengers passenger)
	{
		pdao.save(passenger);
	}

	@Transactional
	public void deletePassenger(String uid)
	{
		pdao.deleteById(uid);
	}
}
