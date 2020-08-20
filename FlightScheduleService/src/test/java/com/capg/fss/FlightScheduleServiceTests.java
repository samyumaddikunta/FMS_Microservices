package com.capg.fss;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.capg.fss.dao.FlightScheduleDAO;
import com.capg.fss.dto.FlightSchedule;
import com.capg.fss.service.FlightScheduleService;

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightScheduleServiceTests {	
	@Rule
	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	@Mock
    private FlightScheduleDAO flightScheduleDao;
	@InjectMocks
	private FlightScheduleService flightScheduleService;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetFlightScheduleList(){
		List<FlightSchedule> flightScheduleList = new ArrayList<FlightSchedule>();
		flightScheduleList.add(new FlightSchedule("101",null,null,null,3000,null,null));
		flightScheduleList.add(new FlightSchedule("102",null,null,null,3500,null,null));
		when(flightScheduleDao.findAll()).thenReturn(flightScheduleList);
		assertEquals(2, flightScheduleList.size());
	}
	@Test
	public void testAddFlightSchedule() {
		FlightSchedule flightSchedule=new FlightSchedule("101",null,null,null,3000,null,null);
		flightSchedule.setScheduleId("101");
		flightSchedule.setFlight(null);
		flightSchedule.setSource(null);
		flightSchedule.setDestination(null);
		flightSchedule.setFare(3000);
		flightSchedule.setArrival(null);
		flightSchedule.setDeparture(null);
		flightScheduleDao.save(flightSchedule);
	
	}
	
	@Test
	public void testUpdateFlightSchedule() {
		FlightSchedule flightSchedule=new FlightSchedule("101",null,null,null,3000,null,null);
		flightScheduleDao.findById("101");
		flightScheduleDao.save(flightSchedule);
	   verify(flightScheduleDao, Mockito.times(1)).save(flightSchedule);
	}
	
	@Test
	public void testDeleteFlightSchedule(){
	FlightSchedule flightSchedule=new FlightSchedule("101",null,null,null,3000,null,null);
	flightScheduleDao.deleteById("101");
	verify(flightScheduleDao, times(1)).deleteById("101");
	}
	
	@Test
	public void testViewFlightSchedule(){
	FlightSchedule flightSchedule=new FlightSchedule("101",null,null,null,3000,null,null);
	flightScheduleDao.findById("101");
	verify(flightScheduleDao, times(1)).findById("101");
	}
	
}