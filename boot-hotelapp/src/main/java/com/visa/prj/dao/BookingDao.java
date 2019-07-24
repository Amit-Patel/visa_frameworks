package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer> {
	
	@Query("from Booking b where b.user.username = :u") 
	List<Booking> getBookingsByUsername(@Param("u") String username);
}
