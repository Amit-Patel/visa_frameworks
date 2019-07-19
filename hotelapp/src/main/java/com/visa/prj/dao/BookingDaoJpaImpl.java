package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		TypedQuery<Hotel> query = em.createQuery("from Hotel where name like:h or city like :c",Hotel.class);
		query.setParameter("h","%"+criteria+"%");
		query.setParameter("c","%"+criteria+"%");
		return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		TypedQuery<User> query = em.createQuery("from User where email=:e and password=:p",User.class);
		query.setParameter("e", email);	// assuming email is unique
		query.setParameter("p", password);
		return query.getResultList().get(0);
	}

	@Override
	public long createBooking(Booking booking) {
		em.persist(booking);
		return booking.getId();
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		TypedQuery<Booking> query = em.createQuery("from Booking where username =:u",Booking.class);
		query.setParameter("u", user.getUsername());
		return query.getResultList();
	}

	
}
