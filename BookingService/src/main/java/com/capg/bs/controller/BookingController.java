package com.capg.bs.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capg.bs.dto.Booking;
import com.capg.bs.dto.Passengers;
import com.capg.bs.service.BookingService;
import com.capg.bs.service.PassengersService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookingController 
{
	@Autowired
	BookingService bookingService;
	public void setBookingService(BookingService bookingService) {this.bookingService=bookingService;}

	@Autowired
	PassengersService passengersService;
	public void setPdao(PassengersService passengersService) { this.passengersService=passengersService; }

	/* @GetMapping("/addBooking")
     public String addBookingDetails()
     {
    	 Users user = new Users();   user.setUsername("venu");
    	 FlightSchedule sched = new FlightSchedule(); sched.setScheduleId("a101");
    	 ArrayList<Passengers> plist = new ArrayList<>();
    	 Passengers p1 = new Passengers("p8001","Ajay",25,'M',"ajay@gmail.com",9999999999L,"3A");
    	 Passengers p2 = new Passengers("p8002","Eashwar",30,'M',"Eashwar@gmail.com",8888888888L,"3B");
    	 passengersService.addPassengers(p1);   passengersService.addPassengers(p2);
    	 plist.add(p1);   plist.add(p2);
    	 Booking booking = new Booking("B7001",user,sched,LocalDate.now(),LocalDate.now(),plist);
    	 bookingService.addBookingDetails(booking);
    	 return "Hello From Booking";
     }*/

	@GetMapping(value="/getBookingDetails/{bookingId}",produces="application/json")
	public Optional<Booking> getBookingDetails(@PathVariable long bookingId)
	{
		return bookingService.getBookingDetails(bookingId);
	}

	@PostMapping(value="/addBookingDetails")
	public String addBookingDetails(@RequestBody()Booking booking)
	{
		for(Passengers p : booking.getPassengers())
			passengersService.addPassenger(p);
		Booking b = bookingService.addBookingDetails(booking);
		return "{\"bookingId\":" + b.getBookingId() + "}";
	}

	@GetMapping(value="/getAllBookingDetails",produces="application/json")
	public List<Booking> getAllBookingDetails()
	{
		return bookingService.getAllBookingDetails();
	}

	@DeleteMapping("/deleteBookingDetails/{bookingId}")
	public String deleteBookingDetails(@PathVariable long bookingId, Booking booking)
	{
		/*for(Passengers p : booking.getPassengers())
			passengersService.deletePassenger(p.getUid());*/ 
		bookingService.deleteBookingDetails(bookingId, booking);
		return "{}";
	}
}
