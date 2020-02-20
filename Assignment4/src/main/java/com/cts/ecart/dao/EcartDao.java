package com.cts.ecart.dao;

import java.util.List;

import com.cts.ecart.entity.Orders;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.Review;

public interface EcartDao {

	Product saveProduct(Product prod);
	
	Product getProductById(int pId);
	
	List<Product> getProductByName(String name);
	
	List<Product> listProduct();
	
	List<Orders> getOrderByUserId(int userId);
	
	List<Orders> listAllOrders();
	
	List<Review> listReviewByProductId(int pId);

}