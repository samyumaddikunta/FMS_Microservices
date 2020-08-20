package com.capg.fs.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.fs.dto.Flight;
@Repository
public interface FlightDAO extends JpaRepository<Flight,String>
{

}
