package com.visa.prj.service;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired 
	private TicketDao ticketDao;
	
	public int logTicket(Ticket t) {
		t.setRaisedDate();
		ticketDao.save(t);
		return t.getTicketID();
	}
	
	public List<Ticket> getAllTickets(){
		return ticketDao.findAll();
	}
	public Ticket getTicketById(Integer id) {
		return ticketDao.findById(id).get();
	}
	
	public void addEmployee(Employee e) {
		employeeDao.save(e);
	}
	
	@Transactional
	public int resolveTicket(Integer tid, Employee e) {
		
		if(!("IT".equals(e.getDept()))) {
			return -1;
		}
		
		Ticket t = new Ticket();
		t = getTicketById(tid);
		t.setResolvedBy(e);
		t.setStatus(true);
		t.setResolvedInfo("resolved issue");
		t.setResolvedDate();
		return t.getTicketID();
	}
	
	public Employee getEmployeeByEmail(String email) {
		return employeeDao.findById(email).get();
	}
	
	
}
