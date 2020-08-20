package com.capg.fs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.capg.fs.dto.Flight;

@SuppressWarnings("unused")
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)


class FlightServiceApplicationTests {


	@Autowired
	TestRestTemplate testRestTemplate;
	public void setTestRestTemplate(TestRestTemplate testRestTemplate)
	{
		this.testRestTemplate=testRestTemplate;
	}
	@LocalServerPort
	int localServerPort;
	@Test
	public void testGetFlight_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"getFlight/151";
		ResponseEntity<Flight> flight = testRestTemplate.getForEntity(url,Flight.class);
		Assertions.assertEquals(200, flight.getStatusCodeValue());
	}

	@Test
	public void testGetFlight_Negative() throws Exception
	{
		String url="http://localhost:"+localServerPort+"getFlight/160";
		ResponseEntity<Flight> flight = testRestTemplate.getForEntity(url,Flight.class);
		Assertions.assertEquals(404, flight.getStatusCodeValue());
	}

	@Test
	public void testAddFlight_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"addFlight";
		Flight flight = new Flight("151","VISS3","Vistara",200);
		ResponseEntity<String> response = testRestTemplate.postForEntity(url,flight,String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	@Test
	public void testAddFlight_Negative() throws Exception
	{
		String url="http://localhost:"+localServerPort+"addFlight";
		Flight flight = null;
		ResponseEntity<String> response = testRestTemplate.postForEntity(url,flight,String.class);
		Assertions.assertEquals(415, response.getStatusCodeValue());
	}

	/*
	 * @Test public void testDeleteFlight_Positive() throws Exception { String
	 * url="http://localhost:"+localServerPort+"deleteFlight/153";
	 * HttpEntity<Integer> ent = new HttpEntity<>(153); ResponseEntity<String>
	 * response =
	 * testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
	 * Assertions.assertEquals(200, response.getStatusCodeValue()); }
	 */	@Test
	public void testDeleteFlight_Negative() throws Exception
	{
		String url="http://localhost:"+localServerPort+"deleteFlight/158";
		HttpEntity<Integer> ent = new HttpEntity<>(158);
		ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
		Assertions.assertEquals(400, response.getStatusCodeValue());
	}

}
