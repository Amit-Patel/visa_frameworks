package com.visa.prj.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.BookingDao;
import com.visa.prj.dao.HotelDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	private UserDao userDao;
	
	public List<Hotel> getHotelsByCriteria(String criteria){
		return hotelDao.getByNameOrCity(criteria);
	}
	
	public Hotel getHotelById(long id) {
		return hotelDao.findById(id).get();
	}
	
	public User getUser(String email, String password) {
		return userDao.getByEmailAndPassword(email, password);
	}
	
	public List<Booking> getAllBookingsOfUser(String username){
		return bookingDao.getBookingsByUsername(username);
	}
	
	@Transactional
	public void makeBooking(Booking b) {
		bookingDao.save(b);
	}
}
