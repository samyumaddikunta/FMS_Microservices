package com.capg.as;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capg.as.dto.Airport;
@RunWith(SpringJUnit4ClassRunner.class)
public class AirportDtoTests {

	@Before
	public void initInput()
	{
		
	}
	@Test()
	public void testFlight_Positive()
	{
		Airport airport=new Airport("HYD", "Rajiv", "hyderabad");
		assertEquals("HYD",airport.getAirportId());
		assertEquals("Rajiv",airport.getAirportName());
		assertEquals("hyderabad",airport.getArea());
	}
	@Test()
	public void testFlight()
	{
		Airport airport=new Airport("HYD", "Rajiv", "hyderabad");
		assertNotEquals("CHN",airport.getAirportId());
		assertNotEquals("Maa",airport.getAirportName());
		assertNotEquals("chennai",airport.getArea());
	}
	
	@Test
	  public final void testToString() {
		Airport airport=new Airport("HYD", "Rajiv", "hyderabad");
		  String result = String.format("Airport [airportId=%s,airportName=%s,airportLoc=%s]",
		 airport.getAirportId(),airport.getAirportName(),airport.getArea());
		  assertNotEquals(result, airport.toString());
	  }
}
