package com.capg.as.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.as.dto.Airport;
@Repository
public interface AirportDAO extends JpaRepository<Airport,String>
{

}
