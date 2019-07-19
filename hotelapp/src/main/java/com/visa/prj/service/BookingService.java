package com.visa.prj.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.BookingDao;
import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Service
public class BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
	public List<Booking> getAllBookingsByUser(User user){
		return bookingDao.getAllBookingsOfUser(user);
	}
	
	public Hotel getHotelByName(String hotel_name) {
		return bookingDao.findHotels(hotel_name).get(0);
	}
	
	public Hotel getHotelById(long id) {
		return bookingDao.findHotelById(id);
	}
	
	public User getUser(String email, String password) {
		return bookingDao.getUser(email, password);
	}
	
	@Transactional
	public void makeBooking(User u, Hotel h, Date checkin, Date checkout, Boolean smoking, int no_of_beds) {
		u = getUser(u.getEmail(), u.getPassword());
		h = getHotelById(h.getId());
		Booking b = new Booking(h,u);
		b.setCheckinDate(checkin);
		b.setCheckoutDate(checkout);
		b.setSmoking(smoking);
		b.setBeds(no_of_beds);
		bookingDao.createBooking(b);
	}

}
