package com.cg.repository;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Coupons;


@Repository
public interface CouponsRepository extends MongoRepository<Coupons, Integer> {
	public Optional<Coupons> findBycname(String couponName);

}
