package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {
	
	/*
	@Transactional
	@Modifying
	@Query("Update Ticket t set t.resolvedBy.email = :resolvedBy where t.id = :tid")
	void updateTicket(@Param("tid") Integer tid,
						@Param("resolvedBy") String resolvedBy);*/
	
}
