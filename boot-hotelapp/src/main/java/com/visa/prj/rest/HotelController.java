package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Hotel;
import com.visa.prj.service.BookingService;

@RestController
public class HotelController {

	@Autowired
	private BookingService service;
	
	@GetMapping("hotels")
	public @ResponseBody List<Hotel> getHotels(@RequestParam(name = "criteria", required = false) String criteria){
		return service.getHotelsByCriteria(criteria);
	}
	
	@GetMapping("hotels/{id}")
	public @ResponseBody Hotel getHotelById(@PathVariable("id") Long id) {
		return service.getHotelById(id);
	}
}
