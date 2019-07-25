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

import com.visa.prj.entity.Product;

public class ProductRestClient {

	public static void main(String[] args) {
		String url = "http://localhost:8080/products";
		RestTemplate template = new RestTemplate();
		methodOne(template, url);
		methodTwo(template, url);
		methodThree(template, url);
	}

	private static void methodThree(RestTemplate template, String url) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		Product p = new Product(0, "Nike Shoes", "shoes", 8900.00, 100);
		HttpEntity<Product> requestEntity = new HttpEntity<Product>(p, headers);

		ResponseEntity<Product> result = template.postForEntity(url, requestEntity, Product.class);
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

		ResponseEntity<List<Product>> response = template.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});

		System.out.println(response.getStatusCode());
		List<Product> products = response.getBody();
		for (Product p : products) {
			System.out.println(p.getName() + "," + p.getCategory());
		}
	}
}
