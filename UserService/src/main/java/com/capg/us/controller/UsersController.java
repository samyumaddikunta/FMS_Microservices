package com.capg.us.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import com.capg.us.dto.Flight;
import com.capg.us.dto.Users;
import com.capg.us.service.UsersService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UsersController 
{
	@Autowired
	UsersService usersService;
	public void setUserService(UsersService usersService)
	{
		this.usersService=usersService;
	}
	@GetMapping(value="/login/{username}/{password}",produces="application/json")   
	public ResponseEntity<Optional<Users>> checkUser(@PathVariable String username,@PathVariable String password)
	{    
		Optional<Users> user = usersService.getUser(username);
		if(user.isPresent() && user.get().getPassword().equals(password)) 
			return new ResponseEntity<Optional<Users>>(user,HttpStatus.OK);
		return new ResponseEntity<Optional<Users>>(HttpStatus.NOT_FOUND);
		
		/*if(user!=null && user.getPassword().equals(password))
			return user;
		else
			return user; 
			*/
		
	}
	
	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<String> registerUser(@RequestBody Users user)
	{
		String message="{\"status\":\"success\"}";
		   if(usersService.addUser(user)==null) {
			   message="{\"status\":\"error\"}";
			   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		   }
		   return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	/*@GetMapping(value="/getUser/{username}",produces="application/json")
	public ResponseEntity<Optional<Users>> getUser(@PathVariable String username)
	{
		Optional<Users> users = usersService.getUser(username);
		if(users.isPresent())
			return new ResponseEntity<Optional<Users>>(users,HttpStatus.OK);
		return new ResponseEntity<Optional<Users>>(users,HttpStatus.BAD_REQUEST);
	}
	@GetMapping(value="/getUsers",produces="application/json")
	public List<Users> getUsers()
	{
		return usersService.getAllUsers();
	}
	@PostMapping(value="/addUser",consumes="application/json")
	public ResponseEntity<String> addUser(@RequestBody()Users users)
	{
		try
		{
			usersService.addUser(users);
			return new ResponseEntity<String>("User details added",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+"Details cannot be added",HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping(value="/updateUser",consumes="application/json")
	public void updateUser(@RequestBody()Users users)
	{
		usersService.updateUser(users);
	}
	@DeleteMapping("/deleteUser/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable String username)
	{
		try
		{
			usersService.deleteUser(username);
			return new ResponseEntity<String>("User details deleted successfully",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+"Details cannot be deleted",HttpStatus.BAD_REQUEST);
		}
	} */
}
