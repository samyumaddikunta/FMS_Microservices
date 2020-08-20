package com.capg.us.dto;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Users 
{
    @Id
    String username;
    String password;
    String name;
    char gender;
    String email;
    long phone;
    public Users() { }
	public Users(String username, String password, String name, char gender, String email, long phone) 
	{
		this.username = username;	this.password = password;		this.name = name;
		this.gender = gender;		this.email = email;		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
}
