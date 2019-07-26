package com.visa.prj.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketID;
	
	private String description;
	
	private Date raisedDate;
	
	@ManyToOne
	@JoinColumn(name = "raisedBy")
	private Employee raisedBy;
	
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name="resolvedBy")
	private Employee resolvedBy;
	
	private Date resolvedDate;
	
	private String resolvedInfo;
	
	public Ticket() {

	}

	public Ticket(Integer ticketID, String desc, Date raiseDate, Employee raisedBy, Employee resolvedBy,
			Date resolvedDate, String resolvedInfo, Boolean status) {
		this.ticketID = ticketID;
		this.description = desc;
		this.raisedDate = raiseDate;
		this.raisedBy = raisedBy;
		this.resolvedBy = resolvedBy;
		this.resolvedDate = resolvedDate;
		this.resolvedInfo = resolvedInfo;
		this.status = status;
	}

	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getTicketID() {
		return ticketID;
	}

	public Employee getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public Date getResolvedDate() {
		return this.resolvedDate;
	}

	public void setResolvedDate() {
		Calendar calendar = Calendar.getInstance();
		this.resolvedDate = calendar.getTime();
	}

	public String getResolvedInfo() {
		return resolvedInfo;
	}

	public void setResolvedInfo(String resolvedInfo) {
		this.resolvedInfo = resolvedInfo;
	}

	public void setTicketID(Integer ticketID) {
		this.ticketID = ticketID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public Date getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	public Employee getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(Employee raisedBy) {
		this.raisedBy = raisedBy;
	}
	
	
	
}
