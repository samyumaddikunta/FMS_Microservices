package com.capg.bs.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
//@SequenceGenerator(name="seq_book",initialValue=1,allocationSize=1)
public class Passengers 
{
  @Id
  @Column(name="passenger_uid")
 // @GeneratedValue(strategy=GenerationType.IDENTITY)
  //@SequenceGenerator(name = "passenger_s1", sequenceName = "PASSENGER_S1")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "retailerRaw_seq")
  @SequenceGenerator(name = "retailerRaw_seq", sequenceName = "PASSENGER_S1", allocationSize=1)
  //@GeneratedValue(strategy=GenerationType.AUTO)
  long uid;
  @Column(name="passenger_name")
  String name;
  @Column(name="passenger_age")
  int age;
  @Column(name="passenger_gender")
  char gender;
  @Column(name="passenger_phone")   
  long phone;
 /* @ManyToOne
  @JoinColumn(name="booking_id", referencedColumnName = "booking_id")
  Booking booking;  
 @Column(name="passenger_seat")
  String seat;*/
  public Passengers() {}
	public Passengers(long uid, String name, int age, char gender, long phone) 
	{
		this.uid = uid;		this.name = name;		this.age = age;		this.gender = gender;
		this.phone = phone;  /*this.booking = booking;
		this.seat = seat;	*/	
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	/*public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	*/
}
