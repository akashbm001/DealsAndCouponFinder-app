package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.DealsIdNotFound;
import com.cg.exception.NameNotFoundException;
import com.cg.model.Deals;
import com.cg.service.DealsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/d2")
public class DealsServiceController {
	
	@Autowired
	private DealsService dealServ;

	public DealsServiceController(DealsService dealServ) {
		this.dealServ = dealServ;
	}
	
 //get deal by deal id
	 @GetMapping("/getdeal/{id}")
	    public ResponseEntity < Deals > getDealsDataById(@PathVariable int id) throws DealsIdNotFound {
	        return ResponseEntity.ok().body(dealServ.getDealsDataById(id));
	    }
	 
 //get all deals
	@GetMapping("/deals")
	public ResponseEntity<List<Deals>> getAllDeals(){
        return new ResponseEntity<List<Deals>>((List<Deals>)dealServ.getAllDeals(),HttpStatus.OK);
    }
	
 //get deal by deal name	
	   @GetMapping("/getdeal/{dname}")
	    public ResponseEntity < Deals > getDealsDataByname(@PathVariable String dname) throws NameNotFoundException {
	       
		   return ResponseEntity.ok().body(dealServ.getDealsDataByname(dname));
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
	
}
