package com.visa.auth.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author banup
 *
 */
@RestController
public class UserController {

	
	@RequestMapping("user")
	public Principal user(Principal user) {
		return user;
	}
 
	@RequestMapping("greet")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getUser(){
		return "Hi Admin!!!";
	}
 
}
