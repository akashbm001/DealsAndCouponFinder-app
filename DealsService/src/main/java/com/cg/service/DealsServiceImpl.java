package com.cg.service;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.DealsAlreadyExistsException;
import com.cg.exception.DealsIdNotFound;
import com.cg.exception.NameNotFoundException;
import com.cg.model.Deals;

import com.cg.repository.DealsRepository;

@Service
public class DealsServiceImpl implements DealsService {
	@Autowired
	private DealsRepository dealRepo;
	
	
	public DealsServiceImpl(DealsRepository dealRepo) {
		super();
		this.dealRepo = dealRepo;
	}
	//add deals service using this method
 @Override
	public Deals addDeals(Deals deal)throws DealsAlreadyExistsException{
	 if(dealRepo.existsById(deal.getDealno())) {
			
			throw new DealsAlreadyExistsException();
		}
	
		Deals saveddeal = dealRepo.save(deal);
		return saveddeal;
	}
	
	
//@Override
//	public void deleteAgencyByagenno(int agenno) {
//		// TODO Auto-generated method stub
//		agenRepo.deleteById(agenno);
//	}
 
// get all deals using this method
	@Override
	public List<Deals> getAllDeals() {
		// TODO Auto-generated method stub
		return (List<Deals>) dealRepo.findAll();
	}


//@Override
//public Deals getDealsDataByname(Deals dname) throws DealsNameNotFound {
//	Deals popDb = dealRepo.findBydname(dname.getDname());
//	
//	
//  return popDb;
//}
	
//get deals by deal name
@Override
public Deals getDealsDataByname(String dname)throws NameNotFoundException  {
	Optional<Deals> dealDB = this.dealRepo.findBydname(dname);
	if(dealDB.isPresent())
	{
	
  return dealDB.get();
	}
	else {
	
		throw new NameNotFoundException();
	}
}

// get deal by deal id also throw deal id not found exception
@Override
public Deals getDealsDataById(int dealno)throws DealsIdNotFound {
	Optional<Deals> popDb = this.dealRepo.findById(dealno);

    if (popDb.isPresent()) {
    	
        return popDb.get();
    } 
    else
    {
    	throw new DealsIdNotFound();
    }
}
//this method update the deals details
	@Override
	public Deals updateDeals(Deals aptu) {
		Deals record;
		Optional<Deals> opt=dealRepo.findById(aptu.getDealno());
		if(opt.isPresent()) {
		record=opt.get();
		record.setDname(aptu.getDname());
		record.setDdetails(aptu.getDdetails());
		dealRepo.save(record);
		}else {
		return new Deals();
		}
		return record;
	}
	@Override
	public void deleteDealBydealno(int dealno) {
		dealRepo.deleteById(dealno);
			}
		
	}




//	public Deals updateApartmentComplex(Deals aptu) {
//		Deals record;
//		Optional<Deals> opt=agenRepo.findById(aptu.getAgenno());
//		if(opt.isPresent()) {
//		record=opt.get();
//		record.setAname(aptu.getAname());
//		agenRepo.save(record);
//		}else {
//		return new Deals();
//		}
//		return record;
//}

