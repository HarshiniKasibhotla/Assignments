package com.cts.ecart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.ecart.entity.Orders;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.Review;

@Repository
public class EcartDaoImpl implements EcartDao {

	@Autowired
	private SessionFactory sf;

	public Product saveProduct(Product prod) {
		sf.getCurrentSession().save(prod);
		System.out.println("Saved");
		return prod;
	}

	public List<Product> listProduct() {
		List<Product> productList = sf.getCurrentSession().createQuery("from Product").list();
		System.out.println(productList.size());
		return productList;
	}

	public List<Orders> getOrderByUserId(int userId) {

		Query query = sf.getCurrentSession().createQuery("from Orders where user_id = :uId");
		query.setInteger("uId", userId);
		Object queryResult = query.getResultList();
		return (List<Orders>) queryResult;
	}

	public List<Orders> listAllOrders() {

		List<Orders> orderList = sf.getCurrentSession().createQuery("from Orders").list();
		return orderList;

	}

	public Product getProductById(int pId) {

		Query query = sf.getCurrentSession().createQuery("from Product where product_id = :pId");
		query.setInteger("pId", pId);
		Object queryResult = query.uniqueResult();
		return (Product) queryResult;

	}

	public List<Product> getProductByName(String name) {

		Query query = sf.getCurrentSession().createQuery("from Product where productName = :pName");
		query.setParameter("pName", name);
		Object queryResult = query.getResultList();
		return (List<Product>) queryResult;

	}

	public List<Review> listReviewByProductId(int pId) {
		Query query = sf.getCurrentSession().createQuery("from Review where product_id = :pId");
		query.setInteger("pId", pId);
		Object queryResult = query.getResultList();
		return (List<Review>) queryResult;

	}

}
