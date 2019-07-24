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
	
	public List<Hotel> getHotelByName(String hotelName) {
		return bookingDao.findHotels(hotelName);
	}
	
	public Hotel getHotelById(long id) {
		return bookingDao.findHotelById(id);
	}
	
	public User getUser(String email, String password) {
		return bookingDao.getUser(email, password);
	}
	
	@Transactional
	public void makeBooking(String email, String password, long id, Date checkin, Date checkout, Boolean smoking, int noOfBeds) {
		User u = getUser(email, password);
		Hotel h = getHotelById(id);
		Booking b = new Booking();
		b.setUser(u);
		b.setHotel(h);
		b.setCheckinDate(checkin);
		b.setCheckoutDate(checkout);
		b.setSmoking(smoking);
		b.setBeds(noOfBeds);
		bookingDao.createBooking(b);
	}

}
