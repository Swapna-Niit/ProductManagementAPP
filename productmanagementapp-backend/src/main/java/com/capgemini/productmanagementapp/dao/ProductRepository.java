package com.capgemini.productmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.productmanagementapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
