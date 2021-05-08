package com.capgemini.productmanagementapp.controller;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.productmanagementapp.exception.ProductException;
import com.capgemini.productmanagementapp.model.Product;
import com.capgemini.productmanagementapp.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		System.out.println("Acc :"+product);
		try {
			productService.updateAccount(product);
		} catch (Exception ex) {
			throw new ProductException("Product Not Updated.");// "Product Not Updated");
		}
		return new ResponseEntity<String>("Product Updated.", HttpStatus.OK);
	}

	@DeleteMapping("/del/{productId}")
	public ResponseEntity<String> delProducts(@PathVariable("productId") Long productId) {
		System.out.println("Acc ID:"+productId);
		try {
			productService.delAccount(productId);
		} catch (Exception ex) {
			throw new ProductException(ex.getMessage());
		}
		return new ResponseEntity<String>("Product Deleted.", HttpStatus.OK);
	}


	@GetMapping("/viewall")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> productList = productService.showProducts();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}

	
	@GetMapping("/view/{productId}")
	public ResponseEntity<String> getProductById(@PathVariable("productId") Long productId) {
		try {
			Optional<Product> product = productService.showProductById(productId);
		}catch (Exception ex) {
			 new ProductException("Product Not Found.");// "Product Not Updated");
		}
		return new ResponseEntity<String>("Product  Found.", HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addAccount(@RequestBody Product product, BindingResult br)
			throws ProductException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new ProductException(err);
		}
		try {
			productService.addProduct(product);
			return new ResponseEntity<String>("Product added", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new ProductException("ID already exists");
		}
	}


}
