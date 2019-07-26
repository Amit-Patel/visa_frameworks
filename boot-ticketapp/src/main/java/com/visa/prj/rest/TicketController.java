package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;
import com.visa.prj.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService service;
	
	@GetMapping("tickets")
	public List<Ticket> getAllTickets(){
		return service.getAllTickets();
	}
	
	@PostMapping("tickets")
	public Integer logTicket(@RequestBody Ticket t) {
		return service.logTicket(t);
	}
	
	@PostMapping("tickets/{id}")
	public Integer resolveTicket(@PathVariable("id") Integer id, @RequestBody Employee e) {
		return service.resolveTicket(id, e);
	}
}
