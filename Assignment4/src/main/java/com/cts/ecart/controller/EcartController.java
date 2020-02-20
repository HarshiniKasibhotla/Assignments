package com.cts.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Orders;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.Review;
import com.cts.ecart.service.EcartService;

@RestController
@RequestMapping("api/")
public class EcartController {

	@Autowired
	private EcartService service;

	private List<Product> prods = null;

	public EcartController() {

	}

	@GetMapping("/greet")
	public String greetMe() {
		return "Good Morning";
	}

	@GetMapping("getProduct")
	public List<Product> listProducts() {

		return service.listProduct();
	}

	@GetMapping("productById/{pId}")
	public Product getProductById(@PathVariable("pId") int pId) {
		return service.getProductById(pId);
	}

	@GetMapping("productByName/{pName}")
	public List<Product> getProductByName(@PathVariable("pName") String pName) {
		return service.getProductByName(pName);
	}

	@PostMapping("product")
	public Product saveProduct(@RequestBody Product product) {

		return service.saveProduct(product);

	}

	@GetMapping("order/{userId}")
	public List<Orders> getOrderByUserId(@PathVariable("userId") int userId) {
		return service.getOrderByUserId(userId);
	}

	@GetMapping("orders")
	public List<Orders> listOrders() {

		return service.listAllOrders();
	}
	
	@GetMapping("review/{pId}")
	public List<Review> listReviewByProductId(@PathVariable("pId") int pId)
	{
		return service.listReviewByProductId(pId);
	}
	

}
