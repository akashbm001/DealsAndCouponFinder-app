package com.cg.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.DealsAlreadyExistsException;
import com.cg.exception.DealsIdNotFound;
import com.cg.exception.NameNotFoundException;
import com.cg.model.Deals;

import com.cg.service.DealsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/d1")
public class DealsServiceController {
	
	@Autowired
	private DealsService dealServ;

	
	public DealsServiceController(DealsService dealServ) {
		this.dealServ = dealServ;
	}
	//Adding Deals by post mapping
	@PostMapping("/adddeal")
	 public ResponseEntity<Deals> addAgency(@RequestBody Deals deal )throws DealsAlreadyExistsException{
        Deals saveddeal = dealServ.addDeals(deal);
       return new ResponseEntity<>(saveddeal, HttpStatus.CREATED);
   }
	//get deals by dealid 
	 @GetMapping("/getdeal/{id}")
	    public ResponseEntity < Deals > getDealsDataById(@PathVariable int id) throws DealsIdNotFound {
	        return ResponseEntity.ok().body(dealServ.getDealsDataById(id));
	    }
	 //get all deals 
	@GetMapping("/getdeals")
	public ResponseEntity<List<Deals>> getAllDeals(){
        return new ResponseEntity<List<Deals>>((List<Deals>)dealServ.getAllDeals(),HttpStatus.OK);
    }
	//get deals by deal name
	   @GetMapping("/getdeal/{dname}")
	    public ResponseEntity < Deals > getDealsDataByname(@PathVariable String dname) throws NameNotFoundException {
	       
		   return ResponseEntity.ok().body(dealServ.getDealsDataByname(dname));
	    }
	   
	// to delete deal by admin
		
		 @DeleteMapping("/deletedeal/{dealno}") 
		 public HttpStatus deleteDealBydealno(@PathVariable int dealno) { 
			 this.dealServ.deleteDealBydealno(dealno); 
		 return HttpStatus.OK; 
		 }
		 
		//Update deal by admin
			
		 @PutMapping("/update")
			public Deals updateApartmentComplex(@RequestBody Deals aupdate) {
			return dealServ.updateDeals(aupdate);
		
		}
		 

	
}
