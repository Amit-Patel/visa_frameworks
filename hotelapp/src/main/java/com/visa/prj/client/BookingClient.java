package com.visa.prj.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

public class BookingClient {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.visa");
		ctx.refresh();
		
		User u = new User();
		u.setEmail("a@visa.com");
//		u.setEnabled(true);
//		u.setName("firstuser");
		u.setPassword("root");
		u.setUsername("first1");
		
		BookingService service = ctx.getBean("bookingService", BookingService.class);
		Hotel h = service.getHotelByName("West").get(0);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
		Date checkin = new Date();
		try {
			checkin = formatter.parse("20/07/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date checkout = new Date();
		try {
			checkout = formatter.parse("25/07/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Boolean smoking = false;
		int no_of_beds = 3;
		
		service.makeBooking(u.getEmail(),u.getPassword(), h.getId(), checkin, checkout, smoking, no_of_beds);
		
		List<Booking> bk = service.getAllBookingsByUser(u);
		for (Booking booking : bk) {
			System.out.println(booking);
		}
		
	}

}
