package com.cg.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.NameNotFoundException;
import com.cg.exception.ProductAlreadyExistsException;
import com.cg.exception.ProductIdNotFound;
import com.cg.model.Product;

import com.cg.service.ProductService;

@RestController
@RequestMapping("/api/p1")
public class ProductServiceController {
	
	@Autowired
	private ProductService prodServ;


	//Add products by post mapping
	@PostMapping("/addproduct")
	 public ResponseEntity<Product> addProduct(@RequestBody Product prod )throws ProductAlreadyExistsException{
        Product savedprod = prodServ.addProducts(prod);
       return new ResponseEntity<>(savedprod, HttpStatus.CREATED);
   }
	//get all products 
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>((List<Product>)prodServ.getAllProducts(),HttpStatus.OK);
    }
	//get all products by product name
	  @GetMapping("/getproduct/{pname}")
	    public ResponseEntity < Product > getProductDataByname(@PathVariable String pname)throws NameNotFoundException  {
	        return ResponseEntity.ok().body(prodServ.getProductDataByname(pname));
	    }
	  //get all product by product id
	  @GetMapping("/getproduct/{id}")
	    public ResponseEntity < Product > getProductDataById(@PathVariable int id) throws ProductIdNotFound {
	        return ResponseEntity.ok().body(prodServ.getProductDataById(id));
	    }
	  
	// to delete product by admin
		
			 @DeleteMapping("/deletedeal/{productno}") 
			 public HttpStatus deleteProductByproductno(@PathVariable int productno) { 
				 this.prodServ.deleteProductByproductno(productno); 
			 return HttpStatus.OK; 
			 }
			 
			//Update product by admin
				
			 @PutMapping("/update")
				public Product updateProduct(@RequestBody Product aupdate) {
				return prodServ.updateProducts(aupdate);
			
			}
}
	  
//	@DeleteMapping("/agen/{agenno}")
//	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int agenno){
//        agenServ.deleteAgencyByagenno(agenno);
//        return ResponseEntity.noContent().build();
//    }
//	
//	@PutMapping("/update")
//	public Deals updateApartmentComplex(@RequestBody Deals aupdate) {
//	return agenServ.updateApartmentComplex(aupdate);
//
//	}
	
