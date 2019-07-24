package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Booking;
import com.visa.prj.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService service;
	
	@GetMapping("bookings")
	public List<Booking> getAllBookingsOfUser(@RequestParam(name="username", required=false) String username){
		return service.getAllBookingsOfUser(username);
	}
	
	@PostMapping("bookings")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking b){
		service.makeBooking(b);
		return new ResponseEntity<>(b,HttpStatus.CREATED);
	}
}
