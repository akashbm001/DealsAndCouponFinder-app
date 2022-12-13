package com.cg.service;



import java.util.List;

import com.cg.exception.NameNotFoundException;
import com.cg.exception.ProductAlreadyExistsException;
import com.cg.exception.ProductIdNotFound;

import com.cg.model.Product;


public interface ProductService {

  public Product addProducts(Product prod)throws ProductAlreadyExistsException;
	public List<Product> getAllProducts() ;
	public Product getProductDataByname(String pname)throws  NameNotFoundException;
	public Product getProductDataById(int productno)throws ProductIdNotFound;
	Product updateProducts(Product aptu);
	public void deleteProductByproductno(int productno);
}