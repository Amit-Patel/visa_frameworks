package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	List<Product> findByCategory(String category); // select * from products where category = ?

	@Query("from Product p where p.price between :low and :high")
	List<Product> getByPriceRange(@Param("low") double lower, @Param("high") double higher);
}
