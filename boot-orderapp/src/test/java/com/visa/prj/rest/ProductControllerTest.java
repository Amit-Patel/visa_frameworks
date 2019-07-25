package com.visa.prj.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	@MockBean
	private OrderService orderService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetProducts() throws Exception {

		List<Product> products = Arrays.asList(new Product(1, "a", "tv", 450, 100),
				new Product(2, "b", "mobile", 4210, 100));

		when(orderService.getAllProducts()).thenReturn(products);

		// @formatter:off
		mockMvc.perform(get("/products"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].name", is("a")))
				.andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].name", is("b")));
		// @formatter:on
		verify(orderService, times(1)).getAllProducts();
		verifyNoMoreInteractions(orderService);
	}

	@Test
	public void testAddProduct() throws Exception {
		Product p = new Product(0, "a", "tv", 55, 22);
		Mockito.doNothing().when(orderService).addProduct(Mockito.isA(Product.class));

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p);

		mockMvc.perform(post("/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isCreated());

		verify(orderService, times(1)).addProduct(Mockito.isA(Product.class));
		verifyNoMoreInteractions(orderService);
	}
}
