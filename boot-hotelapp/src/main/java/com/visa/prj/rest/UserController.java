package com.visa.prj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@RestController
public class UserController {

	@Autowired
	private BookingService service;
	
	@GetMapping("users")
	public @ResponseBody User getUser(@RequestParam(name = "email", required=false) String email,
			@RequestParam(name="password", required = false) String password) {
		return service.getUser(email, password);
	}
}
