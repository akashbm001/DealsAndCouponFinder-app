package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.exception.CouponAlreadyExistsException;
import com.cg.exception.CouponIdNotFound;
import com.cg.exception.NameNotFoundException;
import com.cg.model.Coupons;



@Service
public interface CouponsService {

  public Coupons addCoupon(Coupons deal)throws CouponAlreadyExistsException;
	public List<Coupons> getAllCoupons() ;
	public Coupons getCouponsDataByname(String cname) throws  NameNotFoundException;
	public Coupons getCouponDataById(int couponno)throws CouponIdNotFound;
	//public void deleteAgencyByagenno(int agenno);
	//public Deals updateApartmentComplex(Deals agen);
}