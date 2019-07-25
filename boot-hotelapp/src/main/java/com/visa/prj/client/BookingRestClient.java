package com.visa.prj.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

public class BookingRestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:8080/hotels?criteria=Hotel";
		String url2 = "http://localhost:8080/bookings";
		methodOne(template, url);
		methodTwo(template, url);
//		methodThree(template, url2);
		
	}
	
	private static void methodThree(RestTemplate template, String url) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		User u = new User("a@visa.com", "root", "first1");
		Hotel h = new Hotel();
		Booking b = new Booking();
		h.setId(1L);
		b.setUser(u);
		b.setHotel(h);
		HttpEntity<Booking> requestEntity = new HttpEntity<Booking>(b, headers);

		ResponseEntity<Booking> result = template.postForEntity(url, requestEntity, Booking.class);
		System.out.println(result.getStatusCode()); // 201
		System.out.println(result.getBody().getId());
	}

	private static void methodOne(RestTemplate template, String url) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json = template.getForObject(url, String.class);
		System.out.println(json);

	}

	private static void methodTwo(RestTemplate template, String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		ResponseEntity<List<Hotel>> response = template.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Hotel>>() {
				});

		System.out.println(response.getStatusCode());
		List<Hotel> hotels = response.getBody();
		for (Hotel h : hotels) {
			System.out.println(h.getName() + "," + h.getCity());
		}
	}

}
